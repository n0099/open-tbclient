package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class fb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, eb9 eb9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, eb9Var)) == null) {
            if (i <= 0) {
                return eb9Var.a();
            }
            if (eb9Var.c()) {
                return i + eb9Var.b();
            }
            return i + eb9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull eb9 eb9Var, int i2, @Nullable T t, @Nullable gb9 gb9Var, @Nullable hb9 hb9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), eb9Var, Integer.valueOf(i2), t, gb9Var, hb9Var})) == null) {
            if (eb9Var.a() != -1 && eb9Var.b() != -1) {
                int a = a(i2, eb9Var);
                if (gb9Var != null && t != null) {
                    if (i <= i2) {
                        if (hb9Var != 0) {
                            hb9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (hb9Var != 0) {
                            hb9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = me8.i(list);
                    if (i3 >= i5 && (gb9Var.b() || i3 > i5)) {
                        if (hb9Var != 0) {
                            hb9Var.d(i, i3, i5, gb9Var, t);
                        }
                        return false;
                    }
                    gb9Var.a(i3);
                    if (!gb9Var.b()) {
                        me8.b(list, t, i3);
                        if (hb9Var != 0) {
                            hb9Var.c(i, i3, gb9Var, t);
                            return true;
                        }
                        return true;
                    } else if (hb9Var != 0) {
                        hb9Var.e(i, i3, me8.d(list, i3), gb9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (hb9Var != 0) {
                    hb9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
