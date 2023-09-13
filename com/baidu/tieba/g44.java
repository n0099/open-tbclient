package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view2, n13 n13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, view2, n13Var)) == null) {
            ys1 V = uw2.T().V();
            if (V != null && V.c(view2, n13Var)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ys1 V = uw2.T().V();
            if (V == null || !V.b() || V.h()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            ys1 V = uw2.T().V();
            if (V != null && V.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            ys1 V = uw2.T().V();
            if (V == null) {
                return false;
            }
            if (V.h()) {
                SwanAppActivity activity = uw2.T().getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(0);
                }
                V.g(false);
            }
            return V.removeView(view2);
        }
        return invokeL.booleanValue;
    }
}
