package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(rb2 rb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, rb2Var) == null) && rb2Var != null && rb2Var.n().hasEventListener("audiointerruptionbegin") && my3.h().i()) {
            rb2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(rb2 rb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, rb2Var) == null) && rb2Var != null && rb2Var.n().hasEventListener("audiointerruptionend")) {
            rb2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
