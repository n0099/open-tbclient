package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ap2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yo2 a(SwanAppActivity swanAppActivity, zb3 zb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, zb3Var)) == null) {
            if (zb3Var == null || !zb3Var.I()) {
                return null;
            }
            int k = zb3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return hv2.i().n(swanAppActivity, zb3Var.b);
            }
            return new bp2(swanAppActivity, zb3Var.b);
        }
        return (yo2) invokeLL.objValue;
    }
}
