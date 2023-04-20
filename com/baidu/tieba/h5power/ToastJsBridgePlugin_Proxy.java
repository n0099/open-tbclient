package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.iu4;
import com.baidu.tieba.qm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class ToastJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iu4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(iu4 iu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = iu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        sm9 sm9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var2 = new sm9();
            } else {
                sm9Var2 = sm9Var;
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("toast/toastPopupView")) {
                sm9Var2.r(true);
                sm9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    sm9Var2.x(f.f());
                    sm9Var2.t(f.b());
                    sm9Var2.o(f.a());
                    sm9Var2.w(f.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                sm9Var2.r(true);
                sm9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    sm9Var2.x(g.f());
                    sm9Var2.t(g.b());
                    sm9Var2.o(g.a());
                    sm9Var2.w(g.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                sm9Var2.r(true);
                sm9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    sm9Var2.x(e2.f());
                    sm9Var2.t(e2.b());
                    sm9Var2.o(e2.a());
                    sm9Var2.w(e2.e());
                }
                sm9Var2.y(0);
            }
            return sm9Var2;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
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
