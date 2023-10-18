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
/* loaded from: classes6.dex */
public class fr2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<er2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773667, "Lcom/baidu/tieba/fr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773667, "Lcom/baidu/tieba/fr2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, yr1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                er2 er2Var = a.get(size).get();
                if (er2Var == null) {
                    a.remove(size);
                } else {
                    er2Var.d(yr1Var);
                }
            }
        }
    }

    public static void b(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, yr1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                er2 er2Var = a.get(size).get();
                if (er2Var == null) {
                    a.remove(size);
                } else {
                    er2Var.b(yr1Var);
                }
            }
        }
    }

    public static void c(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yr1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                er2 er2Var = a.get(size).get();
                if (er2Var == null) {
                    a.remove(size);
                } else {
                    er2Var.c(yr1Var);
                }
            }
        }
    }

    public static void d(yr1 yr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yr1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                er2 er2Var = a.get(size).get();
                if (er2Var == null) {
                    a.remove(size);
                } else {
                    er2Var.a(yr1Var);
                }
            }
        }
    }

    public static void f(er2 er2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, er2Var) != null) || er2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            er2 er2Var2 = a.get(size).get();
            if (er2Var2 == null || er2Var == er2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(er2 er2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, er2Var) != null) || er2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            er2 er2Var2 = a.get(size).get();
            if (er2Var2 == null) {
                a.remove(size);
            } else if (er2Var2 == er2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(er2Var));
        }
    }
}
