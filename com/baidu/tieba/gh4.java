package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ni4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class gh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull yh4 yh4Var, @NonNull List<vh4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, yh4Var, list) == null) {
            for (vh4<T> vh4Var : list) {
                yh4Var.c(th4.b().a(vh4Var));
            }
        }
    }

    public static synchronized void d(pi4 pi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pi4Var, of4Var) == null) {
            synchronized (gh4.class) {
                vh4<ug4> i = xh4.i(pi4Var.a, of4Var);
                yh4 yh4Var = new yh4(of4Var);
                yh4Var.c(th4.b().a(i));
                yh4Var.e();
            }
        }
    }

    public static synchronized void g(List<ug4> list, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, of4Var) == null) {
            synchronized (gh4.class) {
                List<vh4<ug4>> e = xh4.e(list, of4Var);
                yh4 yh4Var = new yh4(of4Var);
                a(yh4Var, e);
                yh4Var.e();
            }
        }
    }

    @NonNull
    public static yh4 b(ni4 ni4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ni4Var, of4Var)) == null) {
            List<vh4<ni4.a>> f = xh4.f(ni4Var.a, of4Var);
            yh4 yh4Var = new yh4(of4Var);
            for (vh4<ni4.a> vh4Var : f) {
                yh4Var.c(th4.b().a(vh4Var));
            }
            return yh4Var;
        }
        return (yh4) invokeLL.objValue;
    }

    public static synchronized void e(qi4 qi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qi4Var, of4Var) == null) {
            synchronized (gh4.class) {
                List<vh4<tg4>> h = xh4.h(qi4Var.a, of4Var);
                yh4 yh4Var = new yh4(of4Var);
                for (vh4<tg4> vh4Var : h) {
                    yh4Var.c(th4.b().a(vh4Var));
                }
                yh4Var.e();
            }
        }
    }

    public static synchronized void c(oi4 oi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, oi4Var, of4Var) == null) {
            synchronized (gh4.class) {
                vh4<qg4> d = xh4.d(oi4Var.d, of4Var);
                vh4<sg4> g = xh4.g(oi4Var.a, of4Var);
                vh4<og4> c = xh4.c(oi4Var.f, of4Var);
                List<vh4<tg4>> h = xh4.h(oi4Var.b, of4Var);
                List<vh4<ug4>> e = xh4.e(oi4Var.c, of4Var);
                yh4 yh4Var = new yh4(of4Var);
                yh4Var.c(th4.b().a(d));
                yh4Var.c(th4.b().a(g));
                yh4Var.c(th4.b().a(c));
                a(yh4Var, h);
                a(yh4Var, e);
                yh4Var.e();
            }
        }
    }

    public static synchronized void f(lk4 lk4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, lk4Var, of4Var) == null) {
            synchronized (gh4.class) {
                vh4<qg4> d = xh4.d(lk4Var.b, of4Var);
                vh4<qg4> d2 = xh4.d(lk4Var.a, of4Var);
                vh4<og4> c = xh4.c(lk4Var.c, of4Var);
                yh4 yh4Var = new yh4(of4Var);
                if (d != null) {
                    yh4Var.c(th4.b().a(d));
                }
                if (d2 != null) {
                    yh4Var.c(th4.b().a(d2));
                }
                if (c != null) {
                    yh4Var.c(th4.b().a(c));
                }
                if (lk4Var.d != null) {
                    for (vg4 vg4Var : lk4Var.d) {
                        vh4<vg4> j = xh4.j(vg4Var, of4Var);
                        if (j != null) {
                            yh4Var.c(th4.b().a(j));
                        }
                    }
                }
                if (lk4Var.e != null) {
                    for (ug4 ug4Var : lk4Var.e) {
                        vh4<ug4> i = xh4.i(ug4Var, of4Var);
                        if (i != null) {
                            yh4Var.c(th4.b().a(i));
                        }
                    }
                }
                yh4Var.e();
            }
        }
    }
}
