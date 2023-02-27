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
public class cv2 {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<bv2>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688138, "Lcom/baidu/tieba/cv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688138, "Lcom/baidu/tieba/cv2;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(uv1 uv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, uv1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bv2 bv2Var = a.get(size).get();
                if (bv2Var == null) {
                    a.remove(size);
                } else {
                    bv2Var.d(uv1Var);
                }
            }
        }
    }

    public static void b(uv1 uv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, uv1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bv2 bv2Var = a.get(size).get();
                if (bv2Var == null) {
                    a.remove(size);
                } else {
                    bv2Var.b(uv1Var);
                }
            }
        }
    }

    public static void c(uv1 uv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, uv1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bv2 bv2Var = a.get(size).get();
                if (bv2Var == null) {
                    a.remove(size);
                } else {
                    bv2Var.c(uv1Var);
                }
            }
        }
    }

    public static void d(uv1 uv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uv1Var) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                bv2 bv2Var = a.get(size).get();
                if (bv2Var == null) {
                    a.remove(size);
                } else {
                    bv2Var.a(uv1Var);
                }
            }
        }
    }

    public static void f(bv2 bv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, bv2Var) != null) || bv2Var == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            bv2 bv2Var2 = a.get(size).get();
            if (bv2Var2 == null || bv2Var == bv2Var2) {
                a.remove(size);
            }
        }
    }

    public static void e(bv2 bv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, bv2Var) != null) || bv2Var == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            bv2 bv2Var2 = a.get(size).get();
            if (bv2Var2 == null) {
                a.remove(size);
            } else if (bv2Var2 == bv2Var) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            a.add(new WeakReference<>(bv2Var));
        }
    }
}
