package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, sd2Var) == null) && sd2Var != null && sd2Var.m().hasEventListener("audiointerruptionbegin") && n04.h().i()) {
            sd2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, sd2Var) == null) && sd2Var != null && sd2Var.m().hasEventListener("audiointerruptionend")) {
            sd2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
