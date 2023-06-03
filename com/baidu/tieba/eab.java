package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class eab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SecretKey a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) throws NoSuchAlgorithmException, InvalidKeySpecException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{bArr, bArr2, bArr3, bArr4, Integer.valueOf(i)})) == null) {
            if (bArr.length == 16 && bArr2.length == 16 && bArr3.length == 16) {
                return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(u9b.c(e(bArr, bArr2, bArr3)).toCharArray(), bArr4, i, 128)).getEncoded(), "AES");
            }
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        return (SecretKey) invokeCommon.objValue;
    }

    public static byte[] b(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, secretKey, bArr)) == null) {
            if (secretKey == null || bArr == null) {
                throw new NullPointerException("key or cipherText must not be null.");
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
            return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) {
            if (bArr != null) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    if (i < 0) {
                        bArr[i2] = (byte) (bArr[i2] << (-i));
                    } else {
                        bArr[i2] = (byte) (bArr[i2] >> i);
                    }
                }
                return bArr;
            }
            throw new NullPointerException("bytes must not be null.");
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null) {
                throw new NullPointerException("left or right must not be null.");
            }
            if (bArr.length == bArr2.length) {
                byte[] bArr3 = new byte[bArr.length];
                for (int i = 0; i < bArr.length; i++) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
                }
                return bArr3;
            }
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2, bArr3)) == null) {
            c(bArr, -4);
            byte[] d = d(bArr, bArr2);
            c(d, 6);
            return d(d, bArr3);
        }
        return (byte[]) invokeLLL.objValue;
    }
}
