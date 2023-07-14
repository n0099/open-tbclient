package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.pm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class il4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull am4 am4Var, @NonNull List<xl4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, am4Var, list) == null) {
            for (xl4<T> xl4Var : list) {
                am4Var.c(vl4.b().a(xl4Var));
            }
        }
    }

    public static synchronized void d(rm4 rm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, rm4Var, qj4Var) == null) {
            synchronized (il4.class) {
                xl4<wk4> i = zl4.i(rm4Var.a, qj4Var);
                am4 am4Var = new am4(qj4Var);
                am4Var.c(vl4.b().a(i));
                am4Var.e();
            }
        }
    }

    public static synchronized void g(List<wk4> list, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, qj4Var) == null) {
            synchronized (il4.class) {
                List<xl4<wk4>> e = zl4.e(list, qj4Var);
                am4 am4Var = new am4(qj4Var);
                a(am4Var, e);
                am4Var.e();
            }
        }
    }

    @NonNull
    public static am4 b(pm4 pm4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pm4Var, qj4Var)) == null) {
            List<xl4<pm4.a>> f = zl4.f(pm4Var.a, qj4Var);
            am4 am4Var = new am4(qj4Var);
            for (xl4<pm4.a> xl4Var : f) {
                am4Var.c(vl4.b().a(xl4Var));
            }
            return am4Var;
        }
        return (am4) invokeLL.objValue;
    }

    public static synchronized void e(sm4 sm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sm4Var, qj4Var) == null) {
            synchronized (il4.class) {
                List<xl4<vk4>> h = zl4.h(sm4Var.a, qj4Var);
                am4 am4Var = new am4(qj4Var);
                for (xl4<vk4> xl4Var : h) {
                    am4Var.c(vl4.b().a(xl4Var));
                }
                am4Var.e();
            }
        }
    }

    public static synchronized void c(qm4 qm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qm4Var, qj4Var) == null) {
            synchronized (il4.class) {
                xl4<sk4> d = zl4.d(qm4Var.d, qj4Var);
                xl4<uk4> g = zl4.g(qm4Var.a, qj4Var);
                xl4<qk4> c = zl4.c(qm4Var.f, qj4Var);
                List<xl4<vk4>> h = zl4.h(qm4Var.b, qj4Var);
                List<xl4<wk4>> e = zl4.e(qm4Var.c, qj4Var);
                am4 am4Var = new am4(qj4Var);
                am4Var.c(vl4.b().a(d));
                am4Var.c(vl4.b().a(g));
                am4Var.c(vl4.b().a(c));
                a(am4Var, h);
                a(am4Var, e);
                am4Var.e();
            }
        }
    }

    public static synchronized void f(no4 no4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, no4Var, qj4Var) == null) {
            synchronized (il4.class) {
                xl4<sk4> d = zl4.d(no4Var.b, qj4Var);
                xl4<sk4> d2 = zl4.d(no4Var.a, qj4Var);
                xl4<qk4> c = zl4.c(no4Var.c, qj4Var);
                am4 am4Var = new am4(qj4Var);
                if (d != null) {
                    am4Var.c(vl4.b().a(d));
                }
                if (d2 != null) {
                    am4Var.c(vl4.b().a(d2));
                }
                if (c != null) {
                    am4Var.c(vl4.b().a(c));
                }
                if (no4Var.d != null) {
                    for (xk4 xk4Var : no4Var.d) {
                        xl4<xk4> j = zl4.j(xk4Var, qj4Var);
                        if (j != null) {
                            am4Var.c(vl4.b().a(j));
                        }
                    }
                }
                if (no4Var.e != null) {
                    for (wk4 wk4Var : no4Var.e) {
                        xl4<wk4> i = zl4.i(wk4Var, qj4Var);
                        if (i != null) {
                            am4Var.c(vl4.b().a(i));
                        }
                    }
                }
                am4Var.e();
            }
        }
    }
}
