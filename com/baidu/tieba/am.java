package com.baidu.tieba;

import android.content.pm.Signature;
import android.util.Base64;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class am {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448299777, "Lcom/baidu/tieba/am;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448299777, "Lcom/baidu/tieba/am;");
        }
    }

    public static byte[] a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, signatureArr)) == null) {
            if (signatureArr != null) {
                int i = 0;
                for (Signature signature : signatureArr) {
                    i += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (Signature signature2 : signatureArr) {
                    byte[] byteArray = signature2.toByteArray();
                    System.arraycopy(byteArray, 0, bArr, i2, byteArray.length);
                    i2 += byteArray.length;
                }
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        NoSuchAlgorithmException e;
        String str;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                digest = MessageDigest.getInstance("MD5").digest(bArr);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                str = null;
            }
            if (digest == null) {
                return null;
            }
            str = Base64.encodeToString(digest, 0);
            if (str != null) {
                try {
                    str = str.replaceAll("\\s", "").replaceAll("\\\\", "rg").replaceAll("/", "lg");
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    if (BdLog.isDebugMode()) {
                        e.printStackTrace();
                    }
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Signature[] signatureArr) {
        InterceptResult invokeL;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, signatureArr)) == null) {
            if (signatureArr != null && (a = a(signatureArr)) != null) {
                return b(a);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
