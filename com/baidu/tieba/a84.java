package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pd2 pd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, pd2Var) == null) && pd2Var != null && pd2Var.m().hasEventListener("audiointerruptionbegin") && k04.h().i()) {
            pd2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(pd2 pd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, pd2Var) == null) && pd2Var != null && pd2Var.m().hasEventListener("audiointerruptionend")) {
            pd2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
