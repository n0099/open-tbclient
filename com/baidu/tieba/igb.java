package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class igb {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947853957, "Lcom/baidu/tieba/igb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947853957, "Lcom/baidu/tieba/igb;");
                return;
            }
        }
        a = "0123456789ABCDEF".toCharArray();
    }

    public static byte[] a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cArr)) == null) {
            if ((cArr.length & 1) == 0) {
                byte[] bArr = new byte[cArr.length >> 1];
                int i = 0;
                int i2 = 0;
                while (i < cArr.length) {
                    int digit = Character.digit(cArr[i], 16);
                    if (digit == -1) {
                        throw new IllegalArgumentException("Illegal hexadecimal character at index " + i);
                    }
                    int i3 = i + 1;
                    int digit2 = Character.digit(cArr[i3], 16);
                    if (digit2 == -1) {
                        throw new IllegalArgumentException("Illegal hexadecimal character at index " + i3);
                    }
                    i = i3 + 1;
                    bArr[i2] = (byte) (((digit << 4) | digit2) & 255);
                    i2++;
                }
                return bArr;
            }
            throw new IllegalArgumentException("Odd number of characters.");
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(str.toCharArray()) : (byte[]) invokeL.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                sb.append(a[(b >> 4) & 15]);
                sb.append(a[b & 15]);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
