package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ta2Var) == null) && ta2Var != null && ta2Var.n().hasEventListener("audiointerruptionbegin") && ox3.h().i()) {
            ta2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ta2Var) == null) && ta2Var != null && ta2Var.n().hasEventListener("audiointerruptionend")) {
            ta2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
