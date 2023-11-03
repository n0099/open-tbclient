package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fj2 a(SwanAppActivity swanAppActivity, g63 g63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, g63Var)) == null) {
            if (g63Var == null || !g63Var.I()) {
                return null;
            }
            int k = g63Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return op2.i().n(swanAppActivity, g63Var.b);
            }
            return new ij2(swanAppActivity, g63Var.b);
        }
        return (fj2) invokeLL.objValue;
    }
}
