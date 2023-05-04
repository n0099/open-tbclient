package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.fq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.uu4;
import com.baidu.tieba.xf6;
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
public class ToastJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uu4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        hq9 hq9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var2 = new hq9();
            } else {
                hq9Var2 = hq9Var;
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("toast/toastPopupView")) {
                hq9Var2.s(true);
                hq9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    hq9Var2.y(f.f());
                    hq9Var2.u(f.b());
                    hq9Var2.o(f.a());
                    hq9Var2.x(f.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                hq9Var2.s(true);
                hq9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    hq9Var2.y(g.f());
                    hq9Var2.u(g.b());
                    hq9Var2.o(g.a());
                    hq9Var2.x(g.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                hq9Var2.s(true);
                hq9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    hq9Var2.y(e2.f());
                    hq9Var2.u(e2.b());
                    hq9Var2.o(e2.a());
                    hq9Var2.x(e2.e());
                }
                hq9Var2.z(0);
            }
            return hq9Var2;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
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
