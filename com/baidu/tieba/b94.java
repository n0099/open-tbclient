package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, nw2 nw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, nw2Var)) == null) {
            zn1 Y = ur2.V().Y();
            if (Y != null && Y.c(view2, nw2Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(View view2, nw2 nw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, nw2Var)) == null) {
            zn1 Y = ur2.V().Y();
            if (Y != null && Y.a(view2, nw2Var)) {
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
            zn1 Y = ur2.V().Y();
            if (Y != null) {
                return Y.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(gl3 gl3Var) {
        zn1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, gl3Var) == null) && (Y = ur2.V().Y()) != null) {
            Y.e(gl3Var);
        }
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            zn1 Y = ur2.V().Y();
            if (Y != null && Y.removeView(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(gl3 gl3Var) {
        zn1 Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gl3Var) == null) && (Y = ur2.V().Y()) != null) {
            Y.f(gl3Var);
        }
    }
}
