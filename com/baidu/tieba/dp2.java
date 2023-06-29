package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bp2 a(SwanAppActivity swanAppActivity, cc3 cc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, cc3Var)) == null) {
            if (cc3Var == null || !cc3Var.I()) {
                return null;
            }
            int k = cc3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return kv2.i().n(swanAppActivity, cc3Var.b);
            }
            return new ep2(swanAppActivity, cc3Var.b);
        }
        return (bp2) invokeLL.objValue;
    }
}
