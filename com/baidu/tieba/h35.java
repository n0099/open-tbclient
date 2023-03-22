package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h35 {
    public static /* synthetic */ Interceptable $ic = null;
    public static g35 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947772799, "Lcom/baidu/tieba/h35;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947772799, "Lcom/baidu/tieba/h35;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g35 g35Var = a;
            if (g35Var == null) {
                return -1;
            }
            return g35Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            g35 g35Var = a;
            if (g35Var == null) {
                return null;
            }
            return g35Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            g35 g35Var = a;
            if (g35Var == null) {
                return null;
            }
            return g35Var.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        g35 g35Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) || (g35Var = a) == null) {
            return;
        }
        g35Var.a(context);
    }

    public static void h(g35 g35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, g35Var) == null) {
            a = g35Var;
        }
    }

    public static void e(Context context, int i) {
        g35 g35Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65541, null, context, i) != null) || (g35Var = a) == null) {
            return;
        }
        g35Var.b(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        g35 g35Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (g35Var = a) == null) {
            return;
        }
        g35Var.c(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        g35 g35Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (g35Var = a) == null) {
            return;
        }
        g35Var.e(context, i, z);
    }
}
