/* Program to implement subtitution cipher in java 
Created on : 18.03.2015
Reason : Assignment for OOP paper 
Author : Naveen Prasanth (nnpths01)
*/

import java.io.*;
import java.*; 
import java.util.Scanner;


class SusbtitutionCipherEncrypt
{
	public void encryptText()
	{
		int i,j;
        String a="abcdefghijklmnopqrstuvwx.y z";
        char[] charArray = a.toCharArray();

		try
		{	
			FileReader read1 = new FileReader("input.txt");
			FileReader read2 = new FileReader("key.txt");
			FileWriter write1 = new FileWriter("encrypted.txt");
			BufferedReader key = new BufferedReader(read2);
			BufferedReader in = new BufferedReader(read1);
			BufferedWriter out = new BufferedWriter(write1);

			char data;
			String contentBuffer ;
			String keyBuffer;
			keyBuffer = key.readLine();
			char[] keyArray  = keyBuffer.toCharArray();
				
			while((contentBuffer=in.readLine())!=null)
			{
				char[] contentArray = contentBuffer.toCharArray();
				for(j=0;j<contentBuffer.length();j++)
				{
						
					data = contentArray[j];
					for(i=0;i<a.length();i++)
					{
						if(data == charArray[i])
						{
							out.write(keyArray[i]);
						
						}
					}
				}
			}
			key.close();
			in.close();
			out.close();
	    }
		    
		catch(IOException e)
		{
		    System.out.println(e);
		}
	    

	}
}



class SubstitutionCipherDecrypt extends SubstitutionCipherEncrypt
{
	public  void decryptText()
	{
		int i,j;
        String a="abcdefghijklmnopqrstuvwx.y z";
        char[] charArray = a.toCharArray();

		try
		{	
			FileWriter write1 = new FileWriter("decrypted.txt");
			FileReader read1 = new FileReader("key.txt");
			FileReader read2 = new FileReader("encrypted.txt");
			BufferedReader key = new BufferedReader(read1);
			BufferedReader enc = new BufferedReader(read2);
			BufferedWriter dec = new BufferedWriter(write1);

			char data;
			String encryptBuffer ;
			String keyBuffer;
			keyBuffer = key.readLine();
			char[] keyArray  = keyBuffer.toCharArray();
				
			while((encryptBuffer=enc.readLine())!=null)
			{
				char[] encryptArray = encryptBuffer.toCharArray();
				for(j=0;j<encryptBuffer.length();j++)
				{
						
					data = encryptArray[j];
					for(i=0;i<a.length();i++)
					{
						if(data == keyArray[i])
						{
							dec.write(charArray[i]);
							
						}
					}
				}
			}
			key.close();
			enc.close();
			dec.close();
	    }
		    
		catch(IOException e)
		{
		    System.out.println(e);
		}
	    

	}
}
class SubstitutionCipher extends SubstitutionCipherDecrypt
{
	public static void main(String[] args)
	{
		SubstitutionCipherDecrypt decryptify = new SusbtitutionCipherDecrypt();
		SubstitutionCipherEncrypt encryptify = new SusbtitutionCipherEncrypt();
		Scanner obj = new Scanner(System.in);
		System.out.println("What do you want to do ? \n 1.Encrypt data \n 2.Decrypt data \n");
		int choice = obj.nextInt();
		switch(choice)
		{
			case 1: encryptify.encryptText();
					break;

			case 2: decryptify.decryptText();
					break;
			default : System.out.println ("Invalid choice");
		}



	}
}
