package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, mw2 mw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, mw2Var)) == null) {
            yn1 Y = tr2.V().Y();
            if (Y != null && Y.c(view2, mw2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, mw2 mw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, mw2Var)) == null) {
            yn1 Y = tr2.V().Y();
            if (Y != null && Y.a(view2, mw2Var)) {
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
            yn1 Y = tr2.V().Y();
            if (Y != null) {
                return Y.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(fl3 fl3Var) {
        yn1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, fl3Var) == null) && (Y = tr2.V().Y()) != null) {
            Y.e(fl3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            yn1 Y = tr2.V().Y();
            if (Y != null && Y.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(fl3 fl3Var) {
        yn1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fl3Var) == null) && (Y = tr2.V().Y()) != null) {
            Y.f(fl3Var);
        }
    }
}
