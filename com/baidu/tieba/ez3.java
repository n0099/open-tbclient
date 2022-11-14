package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class ez3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(my3 my3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, my3Var, jsObject) == null) {
            fz3 fz3Var = new fz3();
            mw1 F = mw1.F(jsObject);
            if (F == null) {
                F = new mw1();
            }
            boolean z = false;
            if (my3Var == null) {
                fz3Var.errMsg = "openCustomerServiceConversation:fail";
                r64.call(F, false, fz3Var);
                return;
            }
            if (p04.c()) {
                f43 M = f43.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(mn2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        fz3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        fz3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    fz3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                fz3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            r64.call(F, z, fz3Var);
        }
    }
}
