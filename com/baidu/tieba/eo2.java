package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static co2 a(SwanAppActivity swanAppActivity, db3 db3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, db3Var)) == null) {
            if (db3Var == null || !db3Var.I()) {
                return null;
            }
            int k = db3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return lu2.i().n(swanAppActivity, db3Var.b);
            }
            return new fo2(swanAppActivity, db3Var.b);
        }
        return (co2) invokeLL.objValue;
    }
}
