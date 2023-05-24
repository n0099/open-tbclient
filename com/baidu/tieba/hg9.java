package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class hg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, gg9 gg9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, gg9Var)) == null) {
            if (i <= 0) {
                return gg9Var.a();
            }
            if (gg9Var.c()) {
                return i + gg9Var.b();
            }
            return i + gg9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull gg9 gg9Var, int i2, @Nullable T t, @Nullable ig9 ig9Var, @Nullable jg9 jg9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), gg9Var, Integer.valueOf(i2), t, ig9Var, jg9Var})) == null) {
            if (gg9Var.a() != -1 && gg9Var.b() != -1) {
                int a = a(i2, gg9Var);
                if (ig9Var != null && t != null) {
                    if (i <= i2) {
                        if (jg9Var != 0) {
                            jg9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (jg9Var != 0) {
                            jg9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = yi8.i(list);
                    if (i3 >= i5 && (ig9Var.b() || i3 > i5)) {
                        if (jg9Var != 0) {
                            jg9Var.d(i, i3, i5, ig9Var, t);
                        }
                        return false;
                    }
                    ig9Var.a(i3);
                    if (!ig9Var.b()) {
                        yi8.b(list, t, i3);
                        if (jg9Var != 0) {
                            jg9Var.c(i, i3, ig9Var, t);
                            return true;
                        }
                        return true;
                    } else if (jg9Var != 0) {
                        jg9Var.e(i, i3, yi8.d(list, i3), ig9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (jg9Var != 0) {
                    jg9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
