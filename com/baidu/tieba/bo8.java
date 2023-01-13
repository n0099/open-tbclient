package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class bo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ao8 ao8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ao8Var)) == null) {
            if (i <= 0) {
                return ao8Var.a();
            }
            if (ao8Var.c()) {
                return i + ao8Var.b();
            }
            return i + ao8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ao8 ao8Var, int i2, @Nullable T t, @Nullable co8 co8Var, @Nullable do8 do8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ao8Var, Integer.valueOf(i2), t, co8Var, do8Var})) == null) {
            if (ao8Var.a() != -1 && ao8Var.b() != -1) {
                int a = a(i2, ao8Var);
                if (co8Var != null && t != null) {
                    if (i <= i2) {
                        if (do8Var != 0) {
                            do8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (do8Var != 0) {
                            do8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = uq7.i(list);
                    if (i3 >= i5 && (co8Var.b() || i3 > i5)) {
                        if (do8Var != 0) {
                            do8Var.d(i, i3, i5, co8Var, t);
                        }
                        return false;
                    }
                    co8Var.a(i3);
                    if (!co8Var.b()) {
                        uq7.b(list, t, i3);
                        if (do8Var != 0) {
                            do8Var.c(i, i3, co8Var, t);
                            return true;
                        }
                        return true;
                    } else if (do8Var != 0) {
                        do8Var.e(i, i3, uq7.d(list, i3), co8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (do8Var != 0) {
                    do8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
