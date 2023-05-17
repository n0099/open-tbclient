package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class hm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fm2 a(SwanAppActivity swanAppActivity, g93 g93Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, g93Var)) == null) {
            if (g93Var == null || !g93Var.I()) {
                return null;
            }
            int k = g93Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return os2.i().n(swanAppActivity, g93Var.b);
            }
            return new im2(swanAppActivity, g93Var.b);
        }
        return (fm2) invokeLL.objValue;
    }
}
