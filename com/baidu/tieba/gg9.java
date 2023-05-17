package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class gg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, fg9 fg9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, fg9Var)) == null) {
            if (i <= 0) {
                return fg9Var.a();
            }
            if (fg9Var.c()) {
                return i + fg9Var.b();
            }
            return i + fg9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull fg9 fg9Var, int i2, @Nullable T t, @Nullable hg9 hg9Var, @Nullable ig9 ig9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), fg9Var, Integer.valueOf(i2), t, hg9Var, ig9Var})) == null) {
            if (fg9Var.a() != -1 && fg9Var.b() != -1) {
                int a = a(i2, fg9Var);
                if (hg9Var != null && t != null) {
                    if (i <= i2) {
                        if (ig9Var != 0) {
                            ig9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (ig9Var != 0) {
                            ig9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = xi8.i(list);
                    if (i3 >= i5 && (hg9Var.b() || i3 > i5)) {
                        if (ig9Var != 0) {
                            ig9Var.d(i, i3, i5, hg9Var, t);
                        }
                        return false;
                    }
                    hg9Var.a(i3);
                    if (!hg9Var.b()) {
                        xi8.b(list, t, i3);
                        if (ig9Var != 0) {
                            ig9Var.c(i, i3, hg9Var, t);
                            return true;
                        }
                        return true;
                    } else if (ig9Var != 0) {
                        ig9Var.e(i, i3, xi8.d(list, i3), hg9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (ig9Var != 0) {
                    ig9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
