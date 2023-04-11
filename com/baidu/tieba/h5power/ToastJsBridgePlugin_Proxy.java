package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.hu4;
import com.baidu.tieba.im9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
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
public class ToastJsBridgePlugin_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hu4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = hu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        km9 km9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var2 = new km9();
            } else {
                km9Var2 = km9Var;
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("toast/toastPopupView")) {
                km9Var2.r(true);
                km9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    km9Var2.x(f.f());
                    km9Var2.t(f.b());
                    km9Var2.o(f.a());
                    km9Var2.w(f.e());
                }
                km9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                km9Var2.r(true);
                km9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    km9Var2.x(g.f());
                    km9Var2.t(g.b());
                    km9Var2.o(g.a());
                    km9Var2.w(g.e());
                }
                km9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                km9Var2.r(true);
                km9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    km9Var2.x(e2.f());
                    km9Var2.t(e2.b());
                    km9Var2.o(e2.a());
                    km9Var2.w(e2.e());
                }
                km9Var2.y(0);
            }
            return km9Var2;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
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
