package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, rt2 rt2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, rt2Var)) == null) {
            cl1 X = yo2.U().X();
            return X != null && X.c(view2, rt2Var);
        }
        return invokeLL.booleanValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            cl1 X = yo2.U().X();
            if (X != null) {
                return X.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static void c(ki3 ki3Var) {
        cl1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, ki3Var) == null) || (X = yo2.U().X()) == null) {
            return;
        }
        X.e(ki3Var);
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            cl1 X = yo2.U().X();
            return X != null && X.removeView(view2);
        }
        return invokeL.booleanValue;
    }

    public static void e(ki3 ki3Var) {
        cl1 X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ki3Var) == null) || (X = yo2.U().X()) == null) {
            return;
        }
        X.f(ki3Var);
    }

    public static boolean f(View view2, rt2 rt2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, view2, rt2Var)) == null) {
            cl1 X = yo2.U().X();
            return X != null && X.a(view2, rt2Var);
        }
        return invokeLL.booleanValue;
    }
}
