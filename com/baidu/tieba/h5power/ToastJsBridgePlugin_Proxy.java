package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.yv4;
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
public class ToastJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(yv4 yv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = yv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        n69 n69Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var2 = new n69();
            } else {
                n69Var2 = n69Var;
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("toast/toastPopupView")) {
                n69Var2.r(true);
                n69 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    n69Var2.x(f.f());
                    n69Var2.t(f.b());
                    n69Var2.o(f.a());
                    n69Var2.w(f.e());
                }
                n69Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                n69Var2.r(true);
                n69 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    n69Var2.x(g.f());
                    n69Var2.t(g.b());
                    n69Var2.o(g.a());
                    n69Var2.w(g.e());
                }
                n69Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                n69Var2.r(true);
                n69 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    n69Var2.x(e2.f());
                    n69Var2.t(e2.b());
                    n69Var2.o(e2.a());
                    n69Var2.w(e2.e());
                }
                n69Var2.y(0);
            }
            return n69Var2;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
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
