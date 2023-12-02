package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, qw2 qw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, qw2Var)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && Y.c(view2, qw2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, qw2 qw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, qw2Var)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && Y.a(view2, qw2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null) {
                return Y.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(jl3 jl3Var) {
        co1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, jl3Var) == null) && (Y = xr2.V().Y()) != null) {
            Y.e(jl3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && Y.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(jl3 jl3Var) {
        co1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jl3Var) == null) && (Y = xr2.V().Y()) != null) {
            Y.f(jl3Var);
        }
    }
}
