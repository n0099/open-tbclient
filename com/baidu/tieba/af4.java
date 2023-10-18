package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class af4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull jg4 jg4Var, @Nullable List<pe4> list, @Nullable List<qe4> list2, @NonNull kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, jg4Var, list, list2, kd4Var) == null) {
            uf4 b = cf4.b(jg4Var, kd4Var);
            if (list != null && !list.isEmpty()) {
                cf4.a(b, tf4.h(list, kd4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                cf4.a(b, tf4.e(list2, kd4Var));
            }
            b.e();
        }
    }

    public static void b(kg4 kg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, kg4Var, kd4Var) == null) {
            cf4.c(kg4Var, kd4Var);
        }
    }

    public static void c(lg4 lg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, lg4Var, kd4Var) == null) {
            cf4.d(lg4Var, kd4Var);
        }
    }

    public static void d(mg4 mg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, mg4Var, kd4Var) == null) {
            cf4.e(mg4Var, kd4Var);
        }
    }

    public static void e(hi4 hi4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hi4Var, kd4Var) == null) {
            cf4.f(hi4Var, kd4Var);
        }
    }

    public static synchronized void f(List<qe4> list, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, kd4Var) == null) {
            synchronized (af4.class) {
                cf4.g(list, kd4Var);
            }
        }
    }
}
