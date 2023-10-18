package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class d0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, c0a c0aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, c0aVar)) == null) {
            if (i <= 0) {
                return c0aVar.a();
            }
            if (c0aVar.c()) {
                return i + c0aVar.b();
            }
            return i + c0aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull c0a c0aVar, int i2, @Nullable T t, @Nullable e0a e0aVar, @Nullable f0a f0aVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), c0aVar, Integer.valueOf(i2), t, e0aVar, f0aVar})) == null) {
            if (c0aVar.a() != -1 && c0aVar.b() != -1) {
                int a = a(i2, c0aVar);
                if (e0aVar != null && t != null) {
                    if (i <= i2) {
                        if (f0aVar != 0) {
                            f0aVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (f0aVar != 0) {
                            f0aVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = ez8.i(list);
                    if (i3 >= i5 && (e0aVar.b() || i3 > i5)) {
                        if (f0aVar != 0) {
                            f0aVar.d(i, i3, i5, e0aVar, t);
                        }
                        return false;
                    }
                    e0aVar.a(i3);
                    if (!e0aVar.b()) {
                        ez8.b(list, t, i3);
                        if (f0aVar != 0) {
                            f0aVar.c(i, i3, e0aVar, t);
                            return true;
                        }
                        return true;
                    } else if (f0aVar != 0) {
                        f0aVar.e(i, i3, ez8.d(list, i3), e0aVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (f0aVar != 0) {
                    f0aVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
