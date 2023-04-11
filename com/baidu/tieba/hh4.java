package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.oi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class hh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull zh4 zh4Var, @NonNull List<wh4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, zh4Var, list) == null) {
            for (wh4<T> wh4Var : list) {
                zh4Var.c(uh4.b().a(wh4Var));
            }
        }
    }

    public static synchronized void d(qi4 qi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, qi4Var, pf4Var) == null) {
            synchronized (hh4.class) {
                wh4<vg4> i = yh4.i(qi4Var.a, pf4Var);
                zh4 zh4Var = new zh4(pf4Var);
                zh4Var.c(uh4.b().a(i));
                zh4Var.e();
            }
        }
    }

    public static synchronized void g(List<vg4> list, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, pf4Var) == null) {
            synchronized (hh4.class) {
                List<wh4<vg4>> e = yh4.e(list, pf4Var);
                zh4 zh4Var = new zh4(pf4Var);
                a(zh4Var, e);
                zh4Var.e();
            }
        }
    }

    @NonNull
    public static zh4 b(oi4 oi4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, oi4Var, pf4Var)) == null) {
            List<wh4<oi4.a>> f = yh4.f(oi4Var.a, pf4Var);
            zh4 zh4Var = new zh4(pf4Var);
            for (wh4<oi4.a> wh4Var : f) {
                zh4Var.c(uh4.b().a(wh4Var));
            }
            return zh4Var;
        }
        return (zh4) invokeLL.objValue;
    }

    public static synchronized void e(ri4 ri4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ri4Var, pf4Var) == null) {
            synchronized (hh4.class) {
                List<wh4<ug4>> h = yh4.h(ri4Var.a, pf4Var);
                zh4 zh4Var = new zh4(pf4Var);
                for (wh4<ug4> wh4Var : h) {
                    zh4Var.c(uh4.b().a(wh4Var));
                }
                zh4Var.e();
            }
        }
    }

    public static synchronized void c(pi4 pi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, pi4Var, pf4Var) == null) {
            synchronized (hh4.class) {
                wh4<rg4> d = yh4.d(pi4Var.d, pf4Var);
                wh4<tg4> g = yh4.g(pi4Var.a, pf4Var);
                wh4<pg4> c = yh4.c(pi4Var.f, pf4Var);
                List<wh4<ug4>> h = yh4.h(pi4Var.b, pf4Var);
                List<wh4<vg4>> e = yh4.e(pi4Var.c, pf4Var);
                zh4 zh4Var = new zh4(pf4Var);
                zh4Var.c(uh4.b().a(d));
                zh4Var.c(uh4.b().a(g));
                zh4Var.c(uh4.b().a(c));
                a(zh4Var, h);
                a(zh4Var, e);
                zh4Var.e();
            }
        }
    }

    public static synchronized void f(mk4 mk4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mk4Var, pf4Var) == null) {
            synchronized (hh4.class) {
                wh4<rg4> d = yh4.d(mk4Var.b, pf4Var);
                wh4<rg4> d2 = yh4.d(mk4Var.a, pf4Var);
                wh4<pg4> c = yh4.c(mk4Var.c, pf4Var);
                zh4 zh4Var = new zh4(pf4Var);
                if (d != null) {
                    zh4Var.c(uh4.b().a(d));
                }
                if (d2 != null) {
                    zh4Var.c(uh4.b().a(d2));
                }
                if (c != null) {
                    zh4Var.c(uh4.b().a(c));
                }
                if (mk4Var.d != null) {
                    for (wg4 wg4Var : mk4Var.d) {
                        wh4<wg4> j = yh4.j(wg4Var, pf4Var);
                        if (j != null) {
                            zh4Var.c(uh4.b().a(j));
                        }
                    }
                }
                if (mk4Var.e != null) {
                    for (vg4 vg4Var : mk4Var.e) {
                        wh4<vg4> i = yh4.i(vg4Var, pf4Var);
                        if (i != null) {
                            zh4Var.c(uh4.b().a(i));
                        }
                    }
                }
                zh4Var.e();
            }
        }
    }
}
