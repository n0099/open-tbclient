package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ho2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fo2 a(SwanAppActivity swanAppActivity, gb3 gb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, gb3Var)) == null) {
            if (gb3Var == null || !gb3Var.I()) {
                return null;
            }
            int k = gb3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return ou2.i().n(swanAppActivity, gb3Var.b);
            }
            return new io2(swanAppActivity, gb3Var.b);
        }
        return (fo2) invokeLL.objValue;
    }
}
