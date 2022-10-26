package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ua2 ua2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ua2Var) == null) && ua2Var != null && ua2Var.n().hasEventListener("audiointerruptionbegin") && px3.h().i()) {
            ua2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(ua2 ua2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ua2Var) == null) && ua2Var != null && ua2Var.n().hasEventListener("audiointerruptionend")) {
            ua2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
