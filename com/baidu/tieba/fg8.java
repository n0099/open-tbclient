package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class fg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, eg8 eg8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, eg8Var)) == null) {
            if (i <= 0) {
                return eg8Var.a();
            }
            if (eg8Var.c()) {
                return i + eg8Var.b();
            }
            return i + eg8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull eg8 eg8Var, int i2, @Nullable T t, @Nullable gg8 gg8Var, @Nullable hg8 hg8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), eg8Var, Integer.valueOf(i2), t, gg8Var, hg8Var})) == null) {
            if (eg8Var.a() != -1 && eg8Var.b() != -1) {
                int a = a(i2, eg8Var);
                if (gg8Var != null && t != null) {
                    if (i <= i2) {
                        if (hg8Var != 0) {
                            hg8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (hg8Var != 0) {
                            hg8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = vi7.i(list);
                    if (i3 >= i5 && (gg8Var.b() || i3 > i5)) {
                        if (hg8Var != 0) {
                            hg8Var.d(i, i3, i5, gg8Var, t);
                        }
                        return false;
                    }
                    gg8Var.a(i3);
                    if (!gg8Var.b()) {
                        vi7.b(list, t, i3);
                        if (hg8Var != 0) {
                            hg8Var.c(i, i3, gg8Var, t);
                            return true;
                        }
                        return true;
                    } else if (hg8Var != 0) {
                        hg8Var.e(i, i3, vi7.d(list, i3), gg8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (hg8Var != 0) {
                    hg8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
