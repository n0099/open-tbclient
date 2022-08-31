package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class df9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;

    public df9(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j;
        this.a = i;
    }

    public static df9 b(String str, int i, int i2) {
        InterceptResult invokeLII;
        long j;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i, i2)) == null) {
            if (i >= i2) {
                return null;
            }
            long j2 = 0;
            int i4 = i;
            while (i4 < i2) {
                char charAt = str.charAt(i4);
                if (charAt < '0' || charAt > '9') {
                    if (charAt >= 'A' && charAt <= 'F') {
                        j = j2 * 16;
                        i3 = charAt - 'A';
                    } else if (charAt < 'a' || charAt > 'f') {
                        break;
                    } else {
                        j = j2 * 16;
                        i3 = charAt - 'a';
                    }
                    j2 = j + i3 + 10;
                } else {
                    j2 = (j2 * 16) + (charAt - '0');
                }
                if (j2 > 4294967295L) {
                    return null;
                }
                i4++;
            }
            if (i4 == i) {
                return null;
            }
            return new df9(j2, i4);
        }
        return (df9) invokeLII.objValue;
    }

    public static df9 c(String str, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i >= i2) {
                return null;
            }
            if (z) {
                char charAt = str.charAt(i);
                if (charAt != '+') {
                    r1 = charAt == '-';
                }
                i++;
            }
            long j = 0;
            int i3 = i;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                if (r1) {
                    j = (j * 10) - (charAt2 - '0');
                    if (j < -2147483648L) {
                        return null;
                    }
                } else {
                    j = (j * 10) + (charAt2 - '0');
                    if (j > 2147483647L) {
                        return null;
                    }
                }
                i3++;
            }
            if (i3 == i) {
                return null;
            }
            return new df9(j, i3);
        }
        return (df9) invokeCommon.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.b : invokeV.intValue;
    }
}
