package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ida {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, hda hdaVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, hdaVar)) == null) {
            if (i <= 0) {
                return hdaVar.a();
            }
            if (hdaVar.c()) {
                return i + hdaVar.b();
            }
            return i + hdaVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull hda hdaVar, int i2, @Nullable T t, @Nullable jda jdaVar, @Nullable kda kdaVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), hdaVar, Integer.valueOf(i2), t, jdaVar, kdaVar})) == null) {
            if (hdaVar.a() != -1 && hdaVar.b() != -1) {
                int a = a(i2, hdaVar);
                if (jdaVar != null && t != null) {
                    if (i <= i2) {
                        if (kdaVar != 0) {
                            kdaVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 < a) {
                        if (kdaVar != 0) {
                            kdaVar.a(i, a);
                        }
                        return false;
                    }
                    if (i > a) {
                        i3 = i4;
                    } else {
                        i3 = a;
                    }
                    int i5 = ic9.i(list);
                    if (i3 >= i5 && (jdaVar.b() || i3 > i5)) {
                        if (kdaVar != 0) {
                            kdaVar.d(i, i3, i5, jdaVar, t);
                        }
                        return false;
                    }
                    jdaVar.a(i3);
                    if (!jdaVar.b()) {
                        ic9.b(list, t, i3);
                        if (kdaVar != 0) {
                            kdaVar.c(i, i3, jdaVar, t);
                            return true;
                        }
                        return true;
                    } else if (kdaVar != 0) {
                        kdaVar.e(i, i3, ic9.d(list, i3), jdaVar, t);
                        return true;
                    } else {
                        return true;
                    }
                } else if (kdaVar != 0) {
                    kdaVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
