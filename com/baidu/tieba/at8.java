package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class at8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, zs8 zs8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, zs8Var)) == null) {
            if (i <= 0) {
                return zs8Var.a();
            }
            if (zs8Var.c()) {
                return i + zs8Var.b();
            }
            return i + zs8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull zs8 zs8Var, int i2, @Nullable T t, @Nullable bt8 bt8Var, @Nullable ct8 ct8Var) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), zs8Var, Integer.valueOf(i2), t, bt8Var, ct8Var})) == null) {
            if (zs8Var.a() != -1 && zs8Var.b() != -1) {
                int a = a(i2, zs8Var);
                if (bt8Var != null && t != null) {
                    if (i <= i2) {
                        if (ct8Var != 0) {
                            ct8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (ct8Var != 0) {
                            ct8Var.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = mv7.i(list);
                    if (i3 >= i5 && (bt8Var.b() || i3 > i5)) {
                        if (ct8Var != 0) {
                            ct8Var.d(i, i3, i5, bt8Var, t);
                        }
                        return false;
                    }
                    bt8Var.a(i3);
                    if (!bt8Var.b()) {
                        mv7.b(list, t, i3);
                        if (ct8Var != 0) {
                            ct8Var.c(i, i3, bt8Var, t);
                            return true;
                        }
                        return true;
                    } else if (ct8Var != 0) {
                        ct8Var.e(i, i3, mv7.d(list, i3), bt8Var, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (ct8Var != 0) {
                    ct8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
