package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class g64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(o54 o54Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, o54Var, jsObject) == null) {
            h64 h64Var = new h64();
            o32 F = o32.F(jsObject);
            if (F == null) {
                F = new o32();
            }
            boolean z = false;
            if (o54Var == null) {
                h64Var.errMsg = "openCustomerServiceConversation:fail";
                td4.call(F, false, h64Var);
                return;
            }
            if (r74.c()) {
                hb3 M = hb3.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(ou2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        h64Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        h64Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    h64Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                h64Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            td4.call(F, z, h64Var);
        }
    }
}
