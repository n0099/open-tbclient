package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dh2 a(SwanAppActivity swanAppActivity, e43 e43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, e43Var)) == null) {
            if (e43Var == null || !e43Var.I()) {
                return null;
            }
            int k = e43Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return mn2.i().n(swanAppActivity, e43Var.b);
            }
            return new gh2(swanAppActivity, e43Var.b);
        }
        return (dh2) invokeLL.objValue;
    }
}
