package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(xc2 xc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, xc2Var) == null) && xc2Var != null && xc2Var.m().hasEventListener("audiointerruptionbegin") && sz3.h().i()) {
            xc2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(xc2 xc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, xc2Var) == null) && xc2Var != null && xc2Var.m().hasEventListener("audiointerruptionend")) {
            xc2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
