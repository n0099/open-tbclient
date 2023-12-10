package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class gia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, fia fiaVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, fiaVar)) == null) {
            if (i <= 0) {
                return fiaVar.a();
            }
            if (fiaVar.c()) {
                return i + fiaVar.b();
            }
            return i + fiaVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull fia fiaVar, int i2, @Nullable T t, @Nullable hia hiaVar, @Nullable iia iiaVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), fiaVar, Integer.valueOf(i2), t, hiaVar, iiaVar})) == null) {
            if (fiaVar.a() != -1 && fiaVar.b() != -1) {
                int a = a(i2, fiaVar);
                if (hiaVar != null && t != null) {
                    if (i <= i2) {
                        if (iiaVar != 0) {
                            iiaVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (iiaVar != 0) {
                            iiaVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = eg9.i(list);
                    if (i3 >= i5 && (hiaVar.b() || i3 > i5)) {
                        if (iiaVar != 0) {
                            iiaVar.d(i, i3, i5, hiaVar, t);
                        }
                        return false;
                    }
                    hiaVar.a(i3);
                    if (!hiaVar.b()) {
                        eg9.b(list, t, i3);
                        if (iiaVar != 0) {
                            iiaVar.c(i, i3, hiaVar, t);
                            return true;
                        }
                        return true;
                    } else if (iiaVar != 0) {
                        iiaVar.e(i, i3, eg9.d(list, i3), hiaVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (iiaVar != 0) {
                    iiaVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
