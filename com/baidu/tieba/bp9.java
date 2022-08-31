package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class bp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, int i2, String str) {
        InterceptResult invokeIIL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65536, null, i, i2, str)) == null) {
            if (i < 0 || i >= i2) {
                if (i < 0) {
                    a = cp9.a("%s (%s) must not be negative", "index", Integer.valueOf(i));
                } else if (i2 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i2);
                    throw new IllegalArgumentException(sb.toString());
                } else {
                    a = cp9.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
                }
                throw new IndexOutOfBoundsException(a);
            }
            return i;
        }
        return invokeIIL.intValue;
    }

    public static int b(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, null, i, i2, str)) == null) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(d(i, i2, "index"));
            }
            return i;
        }
        return invokeIIL.intValue;
    }

    public static void c(int i, int i2, int i3) {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65538, null, i, i2, i3) == null) {
            if (i < 0 || i2 < i || i2 > i3) {
                if (i >= 0 && i <= i3) {
                    d = (i2 < 0 || i2 > i3) ? d(i2, i3, "end index") : cp9.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    d = d(i, i3, "start index");
                }
                throw new IndexOutOfBoundsException(d);
            }
        }
    }

    public static String d(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, str)) == null) {
            if (i < 0) {
                return cp9.a("%s (%s) must not be negative", str, Integer.valueOf(i));
            }
            if (i2 >= 0) {
                return cp9.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return (String) invokeIIL.objValue;
    }
}
