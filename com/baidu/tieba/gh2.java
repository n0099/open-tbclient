package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static eh2 a(SwanAppActivity swanAppActivity, f43 f43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, f43Var)) == null) {
            if (f43Var == null || !f43Var.I()) {
                return null;
            }
            int k = f43Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return nn2.i().n(swanAppActivity, f43Var.b);
            }
            return new hh2(swanAppActivity, f43Var.b);
        }
        return (eh2) invokeLL.objValue;
    }
}
