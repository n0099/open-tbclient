package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bp2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ap2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947652581, "Lcom/baidu/tieba/bp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947652581, "Lcom/baidu/tieba/bp2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(tp1 tp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ap2 ap2Var = a.get(size).get();
                if (ap2Var == null) {
                    a.remove(size);
                } else {
                    ap2Var.d(tp1Var);
                }
            }
        }
    }

    public static void b(tp1 tp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ap2 ap2Var = a.get(size).get();
                if (ap2Var == null) {
                    a.remove(size);
                } else {
                    ap2Var.b(tp1Var);
                }
            }
        }
    }

    public static void c(tp1 tp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ap2 ap2Var = a.get(size).get();
                if (ap2Var == null) {
                    a.remove(size);
                } else {
                    ap2Var.c(tp1Var);
                }
            }
        }
    }

    public static void d(tp1 tp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tp1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                ap2 ap2Var = a.get(size).get();
                if (ap2Var == null) {
                    a.remove(size);
                } else {
                    ap2Var.a(tp1Var);
                }
            }
        }
    }

    public static void e(ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, ap2Var) == null) || ap2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            ap2 ap2Var2 = a.get(size).get();
            if (ap2Var2 == null) {
                a.remove(size);
            } else {
                z = ap2Var2 == ap2Var;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(ap2Var));
    }

    public static void f(ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, ap2Var) == null) || ap2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            ap2 ap2Var2 = a.get(size).get();
            if (ap2Var2 == null || ap2Var == ap2Var2) {
                a.remove(size);
            }
        }
    }
}
