package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class ez9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, dz9 dz9Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, dz9Var)) == null) {
            if (i <= 0) {
                return dz9Var.a();
            }
            if (dz9Var.c()) {
                return i + dz9Var.b();
            }
            return i + dz9Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull dz9 dz9Var, int i2, @Nullable T t, @Nullable fz9 fz9Var, @Nullable gz9 gz9Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), dz9Var, Integer.valueOf(i2), t, fz9Var, gz9Var})) == null) {
            if (dz9Var.a() != -1 && dz9Var.b() != -1) {
                int a = a(i2, dz9Var);
                if (fz9Var != null && t != null) {
                    if (i <= i2) {
                        if (gz9Var != 0) {
                            gz9Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (gz9Var != 0) {
                            gz9Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = g09.i(list);
                    if (i3 >= i5 && (fz9Var.b() || i3 > i5)) {
                        if (gz9Var != 0) {
                            gz9Var.d(i, i3, i5, fz9Var, t);
                        }
                        return false;
                    }
                    fz9Var.a(i3);
                    if (!fz9Var.b()) {
                        g09.b(list, t, i3);
                        if (gz9Var != 0) {
                            gz9Var.c(i, i3, fz9Var, t);
                            return true;
                        }
                        return true;
                    } else if (gz9Var != 0) {
                        gz9Var.e(i, i3, g09.d(list, i3), fz9Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (gz9Var != 0) {
                    gz9Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
