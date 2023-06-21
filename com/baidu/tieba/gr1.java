package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public final class gr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            try {
                byte[] bArr2 = new byte[32];
                new SecureRandom().nextBytes(bArr2);
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr2, 8, bArr3, 0, 16);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.c);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] bArr4 = new byte[doFinal.length + 32];
                System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
                System.arraycopy(bArr2, 0, bArr4, doFinal.length, 32);
                return Base64.encodeToString(bArr4, 0);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                byte[] decode = Base64.decode(str, 0);
                if (decode != null && decode.length >= 32) {
                    byte[] bArr = new byte[32];
                    int length = decode.length - 32;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(decode, 0, bArr2, 0, length);
                    System.arraycopy(decode, length, bArr, 0, 32);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.c);
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(bArr, 8, bArr3, 0, 16);
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                    return cipher.doFinal(bArr2);
                }
                return decode;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
