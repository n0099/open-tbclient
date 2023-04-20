package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.pi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class ih4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull ai4 ai4Var, @NonNull List<xh4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ai4Var, list) == null) {
            for (xh4<T> xh4Var : list) {
                ai4Var.c(vh4.b().a(xh4Var));
            }
        }
    }

    public static synchronized void d(ri4 ri4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ri4Var, qf4Var) == null) {
            synchronized (ih4.class) {
                xh4<wg4> i = zh4.i(ri4Var.a, qf4Var);
                ai4 ai4Var = new ai4(qf4Var);
                ai4Var.c(vh4.b().a(i));
                ai4Var.e();
            }
        }
    }

    public static synchronized void g(List<wg4> list, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, qf4Var) == null) {
            synchronized (ih4.class) {
                List<xh4<wg4>> e = zh4.e(list, qf4Var);
                ai4 ai4Var = new ai4(qf4Var);
                a(ai4Var, e);
                ai4Var.e();
            }
        }
    }

    @NonNull
    public static ai4 b(pi4 pi4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pi4Var, qf4Var)) == null) {
            List<xh4<pi4.a>> f = zh4.f(pi4Var.a, qf4Var);
            ai4 ai4Var = new ai4(qf4Var);
            for (xh4<pi4.a> xh4Var : f) {
                ai4Var.c(vh4.b().a(xh4Var));
            }
            return ai4Var;
        }
        return (ai4) invokeLL.objValue;
    }

    public static synchronized void e(si4 si4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, si4Var, qf4Var) == null) {
            synchronized (ih4.class) {
                List<xh4<vg4>> h = zh4.h(si4Var.a, qf4Var);
                ai4 ai4Var = new ai4(qf4Var);
                for (xh4<vg4> xh4Var : h) {
                    ai4Var.c(vh4.b().a(xh4Var));
                }
                ai4Var.e();
            }
        }
    }

    public static synchronized void c(qi4 qi4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qi4Var, qf4Var) == null) {
            synchronized (ih4.class) {
                xh4<sg4> d = zh4.d(qi4Var.d, qf4Var);
                xh4<ug4> g = zh4.g(qi4Var.a, qf4Var);
                xh4<qg4> c = zh4.c(qi4Var.f, qf4Var);
                List<xh4<vg4>> h = zh4.h(qi4Var.b, qf4Var);
                List<xh4<wg4>> e = zh4.e(qi4Var.c, qf4Var);
                ai4 ai4Var = new ai4(qf4Var);
                ai4Var.c(vh4.b().a(d));
                ai4Var.c(vh4.b().a(g));
                ai4Var.c(vh4.b().a(c));
                a(ai4Var, h);
                a(ai4Var, e);
                ai4Var.e();
            }
        }
    }

    public static synchronized void f(nk4 nk4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, nk4Var, qf4Var) == null) {
            synchronized (ih4.class) {
                xh4<sg4> d = zh4.d(nk4Var.b, qf4Var);
                xh4<sg4> d2 = zh4.d(nk4Var.a, qf4Var);
                xh4<qg4> c = zh4.c(nk4Var.c, qf4Var);
                ai4 ai4Var = new ai4(qf4Var);
                if (d != null) {
                    ai4Var.c(vh4.b().a(d));
                }
                if (d2 != null) {
                    ai4Var.c(vh4.b().a(d2));
                }
                if (c != null) {
                    ai4Var.c(vh4.b().a(c));
                }
                if (nk4Var.d != null) {
                    for (xg4 xg4Var : nk4Var.d) {
                        xh4<xg4> j = zh4.j(xg4Var, qf4Var);
                        if (j != null) {
                            ai4Var.c(vh4.b().a(j));
                        }
                    }
                }
                if (nk4Var.e != null) {
                    for (wg4 wg4Var : nk4Var.e) {
                        xh4<wg4> i = zh4.i(wg4Var, qf4Var);
                        if (i != null) {
                            ai4Var.c(vh4.b().a(i));
                        }
                    }
                }
                ai4Var.e();
            }
        }
    }
}
