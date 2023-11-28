package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class bia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, aia aiaVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, aiaVar)) == null) {
            if (i <= 0) {
                return aiaVar.a();
            }
            if (aiaVar.c()) {
                return i + aiaVar.b();
            }
            return i + aiaVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull aia aiaVar, int i2, @Nullable T t, @Nullable cia ciaVar, @Nullable dia diaVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), aiaVar, Integer.valueOf(i2), t, ciaVar, diaVar})) == null) {
            if (aiaVar.a() != -1 && aiaVar.b() != -1) {
                int a = a(i2, aiaVar);
                if (ciaVar != null && t != null) {
                    if (i <= i2) {
                        if (diaVar != 0) {
                            diaVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (diaVar != 0) {
                            diaVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = zf9.i(list);
                    if (i3 >= i5 && (ciaVar.b() || i3 > i5)) {
                        if (diaVar != 0) {
                            diaVar.d(i, i3, i5, ciaVar, t);
                        }
                        return false;
                    }
                    ciaVar.a(i3);
                    if (!ciaVar.b()) {
                        zf9.b(list, t, i3);
                        if (diaVar != 0) {
                            diaVar.c(i, i3, ciaVar, t);
                            return true;
                        }
                        return true;
                    } else if (diaVar != 0) {
                        diaVar.e(i, i3, zf9.d(list, i3), ciaVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (diaVar != 0) {
                    diaVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
