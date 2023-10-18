package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.jg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class cf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull uf4 uf4Var, @NonNull List<rf4<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, uf4Var, list) == null) {
            for (rf4<T> rf4Var : list) {
                uf4Var.c(pf4.b().a(rf4Var));
            }
        }
    }

    public static synchronized void d(lg4 lg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, lg4Var, kd4Var) == null) {
            synchronized (cf4.class) {
                rf4<qe4> i = tf4.i(lg4Var.a, kd4Var);
                uf4 uf4Var = new uf4(kd4Var);
                uf4Var.c(pf4.b().a(i));
                uf4Var.e();
            }
        }
    }

    public static synchronized void g(List<qe4> list, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, kd4Var) == null) {
            synchronized (cf4.class) {
                List<rf4<qe4>> e = tf4.e(list, kd4Var);
                uf4 uf4Var = new uf4(kd4Var);
                a(uf4Var, e);
                uf4Var.e();
            }
        }
    }

    @NonNull
    public static uf4 b(jg4 jg4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jg4Var, kd4Var)) == null) {
            List<rf4<jg4.a>> f = tf4.f(jg4Var.a, kd4Var);
            uf4 uf4Var = new uf4(kd4Var);
            for (rf4<jg4.a> rf4Var : f) {
                uf4Var.c(pf4.b().a(rf4Var));
            }
            return uf4Var;
        }
        return (uf4) invokeLL.objValue;
    }

    public static synchronized void e(mg4 mg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mg4Var, kd4Var) == null) {
            synchronized (cf4.class) {
                List<rf4<pe4>> h = tf4.h(mg4Var.a, kd4Var);
                uf4 uf4Var = new uf4(kd4Var);
                for (rf4<pe4> rf4Var : h) {
                    uf4Var.c(pf4.b().a(rf4Var));
                }
                uf4Var.e();
            }
        }
    }

    public static synchronized void c(kg4 kg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, kg4Var, kd4Var) == null) {
            synchronized (cf4.class) {
                rf4<me4> d = tf4.d(kg4Var.d, kd4Var);
                rf4<oe4> g = tf4.g(kg4Var.a, kd4Var);
                rf4<ke4> c = tf4.c(kg4Var.f, kd4Var);
                List<rf4<pe4>> h = tf4.h(kg4Var.b, kd4Var);
                List<rf4<qe4>> e = tf4.e(kg4Var.c, kd4Var);
                uf4 uf4Var = new uf4(kd4Var);
                uf4Var.c(pf4.b().a(d));
                uf4Var.c(pf4.b().a(g));
                uf4Var.c(pf4.b().a(c));
                a(uf4Var, h);
                a(uf4Var, e);
                uf4Var.e();
            }
        }
    }

    public static synchronized void f(hi4 hi4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, hi4Var, kd4Var) == null) {
            synchronized (cf4.class) {
                rf4<me4> d = tf4.d(hi4Var.b, kd4Var);
                rf4<me4> d2 = tf4.d(hi4Var.a, kd4Var);
                rf4<ke4> c = tf4.c(hi4Var.c, kd4Var);
                uf4 uf4Var = new uf4(kd4Var);
                if (d != null) {
                    uf4Var.c(pf4.b().a(d));
                }
                if (d2 != null) {
                    uf4Var.c(pf4.b().a(d2));
                }
                if (c != null) {
                    uf4Var.c(pf4.b().a(c));
                }
                if (hi4Var.d != null) {
                    for (re4 re4Var : hi4Var.d) {
                        rf4<re4> j = tf4.j(re4Var, kd4Var);
                        if (j != null) {
                            uf4Var.c(pf4.b().a(j));
                        }
                    }
                }
                if (hi4Var.e != null) {
                    for (qe4 qe4Var : hi4Var.e) {
                        rf4<qe4> i = tf4.i(qe4Var, kd4Var);
                        if (i != null) {
                            uf4Var.c(pf4.b().a(i));
                        }
                    }
                }
                uf4Var.e();
            }
        }
    }
}
