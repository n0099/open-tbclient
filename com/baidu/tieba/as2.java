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
/* loaded from: classes5.dex */
public class as2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<zr2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625673, "Lcom/baidu/tieba/as2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625673, "Lcom/baidu/tieba/as2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ts1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                zr2 zr2Var = a.get(size).get();
                if (zr2Var == null) {
                    a.remove(size);
                } else {
                    zr2Var.d(ts1Var);
                }
            }
        }
    }

    public static void b(ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ts1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                zr2 zr2Var = a.get(size).get();
                if (zr2Var == null) {
                    a.remove(size);
                } else {
                    zr2Var.b(ts1Var);
                }
            }
        }
    }

    public static void c(ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ts1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                zr2 zr2Var = a.get(size).get();
                if (zr2Var == null) {
                    a.remove(size);
                } else {
                    zr2Var.c(ts1Var);
                }
            }
        }
    }

    public static void d(ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ts1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                zr2 zr2Var = a.get(size).get();
                if (zr2Var == null) {
                    a.remove(size);
                } else {
                    zr2Var.a(ts1Var);
                }
            }
        }
    }

    public static void f(zr2 zr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, zr2Var) != null) || zr2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            zr2 zr2Var2 = a.get(size).get();
            if (zr2Var2 == null || zr2Var == zr2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(zr2 zr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, zr2Var) != null) || zr2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            zr2 zr2Var2 = a.get(size).get();
            if (zr2Var2 == null) {
                a.remove(size);
            } else if (zr2Var2 == zr2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(zr2Var));
        }
    }
}
