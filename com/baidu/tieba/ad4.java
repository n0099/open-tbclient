package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ad4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pi2 pi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, pi2Var) == null) && pi2Var != null && pi2Var.m().hasEventListener("audiointerruptionbegin") && k54.h().i()) {
            pi2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(pi2 pi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, pi2Var) == null) && pi2Var != null && pi2Var.m().hasEventListener("audiointerruptionend")) {
            pi2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
