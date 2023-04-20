package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class gh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull pi4 pi4Var, @Nullable List<vg4> list, @Nullable List<wg4> list2, @NonNull qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, pi4Var, list, list2, qf4Var) == null) {
            ai4 b = ih4.b(pi4Var, qf4Var);
            if (list != null && !list.isEmpty()) {
                ih4.a(b, zh4.h(list, qf4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ih4.a(b, zh4.e(list2, qf4Var));
            }
            b.e();
        }
    }

    public static void b(qi4 qi4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qi4Var, qf4Var) == null) {
            ih4.c(qi4Var, qf4Var);
        }
    }

    public static void c(ri4 ri4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ri4Var, qf4Var) == null) {
            ih4.d(ri4Var, qf4Var);
        }
    }

    public static void d(si4 si4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, si4Var, qf4Var) == null) {
            ih4.e(si4Var, qf4Var);
        }
    }

    public static void e(nk4 nk4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nk4Var, qf4Var) == null) {
            ih4.f(nk4Var, qf4Var);
        }
    }

    public static synchronized void f(List<wg4> list, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, qf4Var) == null) {
            synchronized (gh4.class) {
                ih4.g(list, qf4Var);
            }
        }
    }
}
