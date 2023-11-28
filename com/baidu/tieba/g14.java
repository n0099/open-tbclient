package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class g14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(o04 o04Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, o04Var, jsObject) == null) {
            h14 h14Var = new h14();
            py1 G = py1.G(jsObject);
            if (G == null) {
                G = new py1();
            }
            boolean z = false;
            if (o04Var == null) {
                h14Var.errMsg = "openCustomerServiceConversation:fail";
                t84.a(G, false, h14Var);
                return;
            }
            if (r24.c()) {
                h63 M = h63.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.P() + "\"}";
                    if (SchemeRouter.invoke(op2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        h14Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        h14Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    h14Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                h14Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            t84.a(G, z, h14Var);
        }
    }
}
