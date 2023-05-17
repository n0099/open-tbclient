package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class f44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(n34 n34Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, n34Var, jsObject) == null) {
            g44 g44Var = new g44();
            n12 F = n12.F(jsObject);
            if (F == null) {
                F = new n12();
            }
            boolean z = false;
            if (n34Var == null) {
                g44Var.errMsg = "openCustomerServiceConversation:fail";
                sb4.call(F, false, g44Var);
                return;
            }
            if (q54.c()) {
                g93 M = g93.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ns2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        g44Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        g44Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    g44Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                g44Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            sb4.call(F, z, g44Var);
        }
    }
}
