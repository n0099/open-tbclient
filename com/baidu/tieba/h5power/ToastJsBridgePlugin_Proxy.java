package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.dw4;
import com.baidu.tieba.hs9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ToastJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dw4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(dw4 dw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dw4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = dw4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        js9 js9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var2 = new js9();
            } else {
                js9Var2 = js9Var;
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("toast/toastPopupView")) {
                js9Var2.s(true);
                js9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    js9Var2.y(f.f());
                    js9Var2.u(f.b());
                    js9Var2.o(f.a());
                    js9Var2.x(f.e());
                }
                js9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                js9Var2.s(true);
                js9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    js9Var2.y(g.f());
                    js9Var2.u(g.b());
                    js9Var2.o(g.a());
                    js9Var2.x(g.e());
                }
                js9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                js9Var2.s(true);
                js9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    js9Var2.y(e2.f());
                    js9Var2.u(e2.b());
                    js9Var2.o(e2.a());
                    js9Var2.x(e2.e());
                }
                js9Var2.z(0);
            }
            return js9Var2;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
