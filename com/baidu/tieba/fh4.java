package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class fh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull oi4 oi4Var, @Nullable List<ug4> list, @Nullable List<vg4> list2, @NonNull pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, oi4Var, list, list2, pf4Var) == null) {
            zh4 b = hh4.b(oi4Var, pf4Var);
            if (list != null && !list.isEmpty()) {
                hh4.a(b, yh4.h(list, pf4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                hh4.a(b, yh4.e(list2, pf4Var));
            }
            b.e();
        }
    }

    public static void b(pi4 pi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, pi4Var, pf4Var) == null) {
            hh4.c(pi4Var, pf4Var);
        }
    }

    public static void c(qi4 qi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qi4Var, pf4Var) == null) {
            hh4.d(qi4Var, pf4Var);
        }
    }

    public static void d(ri4 ri4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ri4Var, pf4Var) == null) {
            hh4.e(ri4Var, pf4Var);
        }
    }

    public static void e(mk4 mk4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mk4Var, pf4Var) == null) {
            hh4.f(mk4Var, pf4Var);
        }
    }

    public static synchronized void f(List<vg4> list, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, pf4Var) == null) {
            synchronized (fh4.class) {
                hh4.g(list, pf4Var);
            }
        }
    }
}
