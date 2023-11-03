package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class f14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(n04 n04Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, n04Var, jsObject) == null) {
            g14 g14Var = new g14();
            oy1 G = oy1.G(jsObject);
            if (G == null) {
                G = new oy1();
            }
            boolean z = false;
            if (n04Var == null) {
                g14Var.errMsg = "openCustomerServiceConversation:fail";
                s84.a(G, false, g14Var);
                return;
            }
            if (q24.c()) {
                g63 M = g63.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.P() + "\"}";
                    if (SchemeRouter.invoke(np2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        g14Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        g14Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    g14Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                g14Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            s84.a(G, z, g14Var);
        }
    }
}
