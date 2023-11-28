package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ij2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gj2 a(SwanAppActivity swanAppActivity, h63 h63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, h63Var)) == null) {
            if (h63Var == null || !h63Var.I()) {
                return null;
            }
            int k = h63Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return pp2.i().n(swanAppActivity, h63Var.b);
            }
            return new jj2(swanAppActivity, h63Var.b);
        }
        return (gj2) invokeLL.objValue;
    }
}
