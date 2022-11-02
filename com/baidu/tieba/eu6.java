package com.baidu.tieba;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static du6 a(iu6 iu6Var, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, iu6Var, intent)) == null) {
            int intExtra = intent.getIntExtra("transition_type", 0);
            if (intExtra == 1) {
                return new ju6(iu6Var, intent);
            }
            if (intExtra == 2) {
                return new cu6(iu6Var, intent);
            }
            return null;
        }
        return (du6) invokeLL.objValue;
    }
}
