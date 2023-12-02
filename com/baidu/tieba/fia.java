package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class fia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, eia eiaVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, eiaVar)) == null) {
            if (i <= 0) {
                return eiaVar.a();
            }
            if (eiaVar.c()) {
                return i + eiaVar.b();
            }
            return i + eiaVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull eia eiaVar, int i2, @Nullable T t, @Nullable gia giaVar, @Nullable hia hiaVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), eiaVar, Integer.valueOf(i2), t, giaVar, hiaVar})) == null) {
            if (eiaVar.a() != -1 && eiaVar.b() != -1) {
                int a = a(i2, eiaVar);
                if (giaVar != null && t != null) {
                    if (i <= i2) {
                        if (hiaVar != 0) {
                            hiaVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (hiaVar != 0) {
                            hiaVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = dg9.i(list);
                    if (i3 >= i5 && (giaVar.b() || i3 > i5)) {
                        if (hiaVar != 0) {
                            hiaVar.d(i, i3, i5, giaVar, t);
                        }
                        return false;
                    }
                    giaVar.a(i3);
                    if (!giaVar.b()) {
                        dg9.b(list, t, i3);
                        if (hiaVar != 0) {
                            hiaVar.c(i, i3, giaVar, t);
                            return true;
                        }
                        return true;
                    } else if (hiaVar != 0) {
                        hiaVar.e(i, i3, dg9.d(list, i3), giaVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (hiaVar != 0) {
                    hiaVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
