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
public class cp2 {
    public static /* synthetic */ Interceptable $ic;
    public static List a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682372, "Lcom/baidu/tieba/cp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682372, "Lcom/baidu/tieba/cp2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(up1 up1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, up1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bp2 bp2Var = (bp2) ((WeakReference) a.get(size)).get();
                if (bp2Var == null) {
                    a.remove(size);
                } else {
                    bp2Var.d(up1Var);
                }
            }
        }
    }

    public static void b(up1 up1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, up1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bp2 bp2Var = (bp2) ((WeakReference) a.get(size)).get();
                if (bp2Var == null) {
                    a.remove(size);
                } else {
                    bp2Var.b(up1Var);
                }
            }
        }
    }

    public static void c(up1 up1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, up1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bp2 bp2Var = (bp2) ((WeakReference) a.get(size)).get();
                if (bp2Var == null) {
                    a.remove(size);
                } else {
                    bp2Var.c(up1Var);
                }
            }
        }
    }

    public static void d(up1 up1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, up1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bp2 bp2Var = (bp2) ((WeakReference) a.get(size)).get();
                if (bp2Var == null) {
                    a.remove(size);
                } else {
                    bp2Var.a(up1Var);
                }
            }
        }
    }

    public static void f(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, bp2Var) != null) || bp2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            bp2 bp2Var2 = (bp2) ((WeakReference) a.get(size)).get();
            if (bp2Var2 == null || bp2Var == bp2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, bp2Var) != null) || bp2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            bp2 bp2Var2 = (bp2) ((WeakReference) a.get(size)).get();
            if (bp2Var2 == null) {
                a.remove(size);
            } else if (bp2Var2 == bp2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference(bp2Var));
        }
    }
}
