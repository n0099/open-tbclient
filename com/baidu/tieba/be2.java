package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class be2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zd2 a(SwanAppActivity swanAppActivity, a13 a13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, a13Var)) == null) {
            if (a13Var == null || !a13Var.I()) {
                return null;
            }
            int k = a13Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return ik2.i().n(swanAppActivity, a13Var.b);
            }
            return new ce2(swanAppActivity, a13Var.b);
        }
        return (zd2) invokeLL.objValue;
    }
}
