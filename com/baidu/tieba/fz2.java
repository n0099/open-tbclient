package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, callbackHandler, unitedSchemeEntity)) == null) {
            String b = b(unitedSchemeEntity);
            if (TextUtils.isEmpty(b)) {
                k32.i("WxWebViewPayment", "wxPay: url is empty");
                k32.k("WxWebViewPayment", "param check error - src" + b);
                dd3.H(false, "wechatH5Action", dd3.m(b, "param check error - src"));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (!bb1.a().b(context)) {
                c63.g(context, context.getText(R.string.obfuscated_res_0x7f0f0221)).G();
                k32.k("WxWebViewPayment", "Error: wechat not install. " + b);
                dd3.H(false, "wechatH5Action", dd3.m(b, "Error: wechat not install. "));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
                return false;
            } else {
                kw2 d = kw2.d(b, b);
                k32.k("WxWebViewPayment", "Info: open wechat pay webview, pageParam =" + d);
                if (!y52.k3("wxPay", d)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    k32.k("WxWebViewPayment", "Error: webview fragment not opened.");
                    return false;
                }
                k32.k("WxWebViewPayment", "Success:open wxPay page success");
                k32.k("WxWebViewPayment", "Info: end WeChat H5 redirect " + b);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(yy2.c(b), 0));
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String b(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, unitedSchemeEntity)) == null) {
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str).optString("src");
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
