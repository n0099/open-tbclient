package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class b74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(j64 j64Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, j64Var, jsObject) == null) {
            c74 c74Var = new c74();
            j42 F = j42.F(jsObject);
            if (F == null) {
                F = new j42();
            }
            boolean z = false;
            if (j64Var == null) {
                c74Var.errMsg = "openCustomerServiceConversation:fail";
                oe4.call(F, false, c74Var);
                return;
            }
            if (m84.c()) {
                cc3 M = cc3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(jv2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        c74Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        c74Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    c74Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                c74Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            oe4.call(F, z, c74Var);
        }
    }
}
