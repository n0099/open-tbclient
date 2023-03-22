package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class eh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ni4 ni4Var, @Nullable List<tg4> list, @Nullable List<ug4> list2, @NonNull of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ni4Var, list, list2, of4Var) == null) {
            yh4 b = gh4.b(ni4Var, of4Var);
            if (list != null && !list.isEmpty()) {
                gh4.a(b, xh4.h(list, of4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                gh4.a(b, xh4.e(list2, of4Var));
            }
            b.e();
        }
    }

    public static void b(oi4 oi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, oi4Var, of4Var) == null) {
            gh4.c(oi4Var, of4Var);
        }
    }

    public static void c(pi4 pi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, pi4Var, of4Var) == null) {
            gh4.d(pi4Var, of4Var);
        }
    }

    public static void d(qi4 qi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, qi4Var, of4Var) == null) {
            gh4.e(qi4Var, of4Var);
        }
    }

    public static void e(lk4 lk4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lk4Var, of4Var) == null) {
            gh4.f(lk4Var, of4Var);
        }
    }

    public static synchronized void f(List<ug4> list, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, of4Var) == null) {
            synchronized (eh4.class) {
                gh4.g(list, of4Var);
            }
        }
    }
}
