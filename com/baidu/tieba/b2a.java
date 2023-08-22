package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class b2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, a2a a2aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, a2aVar)) == null) {
            if (i <= 0) {
                return a2aVar.a();
            }
            if (a2aVar.c()) {
                return i + a2aVar.b();
            }
            return i + a2aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull a2a a2aVar, int i2, @Nullable T t, @Nullable c2a c2aVar, @Nullable d2a d2aVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), a2aVar, Integer.valueOf(i2), t, c2aVar, d2aVar})) == null) {
            if (a2aVar.a() != -1 && a2aVar.b() != -1) {
                int a = a(i2, a2aVar);
                if (c2aVar != null && t != null) {
                    if (i <= i2) {
                        if (d2aVar != 0) {
                            d2aVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (d2aVar != 0) {
                            d2aVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = g29.i(list);
                    if (i3 >= i5 && (c2aVar.b() || i3 > i5)) {
                        if (d2aVar != 0) {
                            d2aVar.d(i, i3, i5, c2aVar, t);
                        }
                        return false;
                    }
                    c2aVar.a(i3);
                    if (!c2aVar.b()) {
                        g29.b(list, t, i3);
                        if (d2aVar != 0) {
                            d2aVar.c(i, i3, c2aVar, t);
                            return true;
                        }
                        return true;
                    } else if (d2aVar != 0) {
                        d2aVar.e(i, i3, g29.d(list, i3), c2aVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (d2aVar != 0) {
                    d2aVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
