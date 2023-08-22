package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(k54 k54Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, k54Var, jsObject) == null) {
            d64 d64Var = new d64();
            k32 F = k32.F(jsObject);
            if (F == null) {
                F = new k32();
            }
            boolean z = false;
            if (k54Var == null) {
                d64Var.errMsg = "openCustomerServiceConversation:fail";
                pd4.call(F, false, d64Var);
                return;
            }
            if (n74.c()) {
                db3 M = db3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ku2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        d64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        d64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    d64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                d64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            pd4.call(F, z, d64Var);
        }
    }
}
