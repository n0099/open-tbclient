package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
/* loaded from: classes5.dex */
public class cmb {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947680977, "Lcom/baidu/tieba/cmb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947680977, "Lcom/baidu/tieba/cmb;");
                return;
            }
        }
        a = new char[]{TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null) {
                return b(bArr, 0, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i, i2)) == null) {
            if (bArr != null) {
                if (i >= 0 && i + i2 <= bArr.length) {
                    int i3 = i2 * 2;
                    char[] cArr = new char[i3];
                    int i4 = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = bArr[i5 + i] & 255;
                        int i7 = i4 + 1;
                        char[] cArr2 = a;
                        cArr[i4] = cArr2[i6 >> 4];
                        i4 = i7 + 1;
                        cArr[i7] = cArr2[i6 & 15];
                    }
                    return new String(cArr, 0, i3);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }
}
