package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public final class fl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            char[] cArr = new char[32];
            try {
                char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                for (int i = 0; i < 32; i++) {
                    int nextInt = new SecureRandom().nextInt(62);
                    if (nextInt >= 0 && nextInt < charArray.length) {
                        cArr[i] = charArray[nextInt];
                    }
                }
            } catch (Throwable th) {
                ul1.d(th);
            }
            return new String(cArr).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length == 32 && bArr2 != null && bArr2.length != 0) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                        Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f);
                        byte[] bArr3 = new byte[16];
                        System.arraycopy(bArr, 8, bArr3, 0, 16);
                        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                        byte[] bArr4 = new byte[bArr2.length - 16];
                        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                        return cipher.doFinal(bArr4);
                    }
                } catch (Throwable th) {
                    ul1.d(th);
                    return null;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static el1 c(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length != 0) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                        Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f);
                        byte[] bArr3 = new byte[16];
                        System.arraycopy(bArr, 8, bArr3, 0, 16);
                        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                        byte[] doFinal = cipher.doFinal(bArr2);
                        byte[] e = zl1.e(bArr2);
                        byte[] bArr4 = new byte[doFinal.length + e.length];
                        System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
                        System.arraycopy(e, 0, bArr4, doFinal.length, e.length);
                        return new el1(bArr, bArr4);
                    }
                } catch (Throwable th) {
                    ul1.d(th);
                }
            }
            return null;
        }
        return (el1) invokeLL.objValue;
    }
}
