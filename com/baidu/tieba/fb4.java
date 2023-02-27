package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ug2 ug2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ug2Var) == null) && ug2Var != null && ug2Var.n().hasEventListener("audiointerruptionbegin") && p34.h().i()) {
            ug2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(ug2 ug2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ug2Var) == null) && ug2Var != null && ug2Var.n().hasEventListener("audiointerruptionend")) {
            ug2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
