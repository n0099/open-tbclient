package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class f64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(n54 n54Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, n54Var, jsObject) == null) {
            g64 g64Var = new g64();
            n32 F = n32.F(jsObject);
            if (F == null) {
                F = new n32();
            }
            boolean z = false;
            if (n54Var == null) {
                g64Var.errMsg = "openCustomerServiceConversation:fail";
                sd4.call(F, false, g64Var);
                return;
            }
            if (q74.c()) {
                gb3 M = gb3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(nu2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        g64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        g64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    g64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                g64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            sd4.call(F, z, g64Var);
        }
    }
}
