package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class ih4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ri4 ri4Var, @Nullable List<xg4> list, @Nullable List<yg4> list2, @NonNull sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ri4Var, list, list2, sf4Var) == null) {
            ci4 b = kh4.b(ri4Var, sf4Var);
            if (list != null && !list.isEmpty()) {
                kh4.a(b, bi4.h(list, sf4Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                kh4.a(b, bi4.e(list2, sf4Var));
            }
            b.e();
        }
    }

    public static void b(si4 si4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, si4Var, sf4Var) == null) {
            kh4.c(si4Var, sf4Var);
        }
    }

    public static void c(ti4 ti4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ti4Var, sf4Var) == null) {
            kh4.d(ti4Var, sf4Var);
        }
    }

    public static void d(ui4 ui4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ui4Var, sf4Var) == null) {
            kh4.e(ui4Var, sf4Var);
        }
    }

    public static void e(pk4 pk4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pk4Var, sf4Var) == null) {
            kh4.f(pk4Var, sf4Var);
        }
    }

    public static synchronized void f(List<yg4> list, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, sf4Var) == null) {
            synchronized (ih4.class) {
                kh4.g(list, sf4Var);
            }
        }
    }
}
