package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class ih4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String b(File file, boolean z) {
        InterceptResult invokeLZ;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, file, z)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String a = a(messageDigest.digest(), "", z);
                            ik4.d(fileInputStream);
                            return a;
                        }
                    }
                } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
                    ik4.d(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    ik4.d(fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (String) invokeLZ.objValue;
        }
    }
}
