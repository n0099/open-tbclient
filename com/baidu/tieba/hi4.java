package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class hi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull qj4 qj4Var, @Nullable List<wh4> list, @Nullable List<xh4> list2, @NonNull rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, qj4Var, list, list2, rg4Var) == null) {
            bj4 b = ji4.b(qj4Var, rg4Var);
            if (list != null && !list.isEmpty()) {
                ji4.a(b, aj4.h(list, rg4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ji4.a(b, aj4.e(list2, rg4Var));
            }
            b.e();
        }
    }

    public static void b(rj4 rj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rj4Var, rg4Var) == null) {
            ji4.c(rj4Var, rg4Var);
        }
    }

    public static void c(sj4 sj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sj4Var, rg4Var) == null) {
            ji4.d(sj4Var, rg4Var);
        }
    }

    public static void d(tj4 tj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tj4Var, rg4Var) == null) {
            ji4.e(tj4Var, rg4Var);
        }
    }

    public static void e(ol4 ol4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ol4Var, rg4Var) == null) {
            ji4.f(ol4Var, rg4Var);
        }
    }

    public static synchronized void f(List<xh4> list, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, rg4Var) == null) {
            synchronized (hi4.class) {
                ji4.g(list, rg4Var);
            }
        }
    }
}
