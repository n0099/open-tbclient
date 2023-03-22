package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.fu4;
import com.baidu.tieba.rc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
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
/* loaded from: classes4.dex */
public class ToastJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fu4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(fu4 fu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = fu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        tc9 tc9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var2 = new tc9();
            } else {
                tc9Var2 = tc9Var;
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("toast/toastPopupView")) {
                tc9Var2.r(true);
                tc9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    tc9Var2.x(f.f());
                    tc9Var2.t(f.b());
                    tc9Var2.o(f.a());
                    tc9Var2.w(f.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                tc9Var2.r(true);
                tc9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    tc9Var2.x(g.f());
                    tc9Var2.t(g.b());
                    tc9Var2.o(g.a());
                    tc9Var2.w(g.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                tc9Var2.r(true);
                tc9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    tc9Var2.x(e2.f());
                    tc9Var2.t(e2.b());
                    tc9Var2.o(e2.a());
                    tc9Var2.w(e2.e());
                }
                tc9Var2.y(0);
            }
            return tc9Var2;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
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
