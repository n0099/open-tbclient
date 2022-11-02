package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fy4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static ey4 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947780456, "Lcom/baidu/tieba/fy4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947780456, "Lcom/baidu/tieba/fy4;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ey4 ey4Var = a;
            if (ey4Var == null) {
                return -1;
            }
            return ey4Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ey4 ey4Var = a;
            if (ey4Var == null) {
                return null;
            }
            return ey4Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ey4 ey4Var = a;
            if (ey4Var == null) {
                return null;
            }
            return ey4Var.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) || (ey4Var = a) == null) {
            return;
        }
        ey4Var.a(context);
    }

    public static void h(ey4 ey4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ey4Var) == null) {
            a = ey4Var;
        }
    }

    public static void e(Context context, int i) {
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65541, null, context, i) != null) || (ey4Var = a) == null) {
            return;
        }
        ey4Var.b(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (ey4Var = a) == null) {
            return;
        }
        ey4Var.c(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (ey4Var = a) == null) {
            return;
        }
        ey4Var.e(context, i, z);
    }
}
