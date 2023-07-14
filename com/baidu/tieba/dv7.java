package com.baidu.tieba;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static cv7 a(hv7 hv7Var, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, hv7Var, intent)) == null) {
            int intExtra = intent.getIntExtra("transition_type", 0);
            if (intExtra == 1) {
                return new iv7(hv7Var, intent);
            }
            if (intExtra == 2) {
                return new bv7(hv7Var, intent);
            }
            return null;
        }
        return (cv7) invokeLL.objValue;
    }
}
