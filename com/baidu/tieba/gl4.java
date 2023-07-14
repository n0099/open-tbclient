package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class gl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull pm4 pm4Var, @Nullable List<vk4> list, @Nullable List<wk4> list2, @NonNull qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, pm4Var, list, list2, qj4Var) == null) {
            am4 b = il4.b(pm4Var, qj4Var);
            if (list != null && !list.isEmpty()) {
                il4.a(b, zl4.h(list, qj4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                il4.a(b, zl4.e(list2, qj4Var));
            }
            b.e();
        }
    }

    public static void b(qm4 qm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qm4Var, qj4Var) == null) {
            il4.c(qm4Var, qj4Var);
        }
    }

    public static void c(rm4 rm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, rm4Var, qj4Var) == null) {
            il4.d(rm4Var, qj4Var);
        }
    }

    public static void d(sm4 sm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sm4Var, qj4Var) == null) {
            il4.e(sm4Var, qj4Var);
        }
    }

    public static void e(no4 no4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, no4Var, qj4Var) == null) {
            il4.f(no4Var, qj4Var);
        }
    }

    public static synchronized void f(List<wk4> list, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, qj4Var) == null) {
            synchronized (gl4.class) {
                il4.g(list, qj4Var);
            }
        }
    }
}
