package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class dz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ly3 ly3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ly3Var, jsObject) == null) {
            ez3 ez3Var = new ez3();
            lw1 F = lw1.F(jsObject);
            if (F == null) {
                F = new lw1();
            }
            boolean z = false;
            if (ly3Var == null) {
                ez3Var.errMsg = "openCustomerServiceConversation:fail";
                q64.call(F, false, ez3Var);
                return;
            }
            if (o04.c()) {
                e43 M = e43.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ln2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        ez3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        ez3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    ez3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                ez3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            q64.call(F, z, ez3Var);
        }
    }
}
