package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ta2 ta2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, ta2Var, str) == null) && ta2Var != null && ta2Var.n().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new f54(str);
            ta2Var.dispatchEvent(jSEvent);
        }
    }
}
