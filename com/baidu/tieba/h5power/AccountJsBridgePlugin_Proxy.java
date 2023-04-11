package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.im9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.tt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AccountJsBridgePlugin_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tt4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(tt4 tt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = tt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
    }

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var = new km9();
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("account/startLoginModule")) {
                km9Var.r(true);
                km9 h = this.mJsBridge.h(webView, e.optString("cssUrl"));
                if (h != null) {
                    km9Var.x(h.f());
                    km9Var.t(h.b());
                    km9Var.o(h.a());
                    km9Var.w(h.e());
                }
                km9Var.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                km9Var.r(true);
                km9 d = this.mJsBridge.d(webView, e.optInt("socialType"), e.optString("activityId"));
                if (d != null) {
                    km9Var.x(d.f());
                    km9Var.t(d.b());
                    km9Var.o(d.a());
                    km9Var.w(d.e());
                }
                km9Var.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                km9Var.r(true);
                km9 g = this.mJsBridge.g(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (g != null) {
                    km9Var.x(g.f());
                    km9Var.t(g.b());
                    km9Var.o(g.a());
                    km9Var.w(g.e());
                }
                km9Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                km9Var.r(true);
                km9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    km9Var.x(c.f());
                    km9Var.t(c.b());
                    km9Var.o(c.a());
                    km9Var.w(c.e());
                }
                km9Var.y(0);
            }
            return km9Var;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            km9 km9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                km9Var = this.mJsBridge.f(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                km9Var = this.mJsBridge.i(webView, hashMap);
            }
            if (km9Var != null) {
                km9Var.y(0);
            }
            List<jm9> list = this.mAsyncCallBackMethodList.get(str);
            if (km9Var != null && list != null) {
                Iterator<jm9> it = list.iterator();
                if (!TextUtils.isEmpty(km9Var.e())) {
                    while (it.hasNext()) {
                        jm9 next = it.next();
                        if (next.b().equals(km9Var.e())) {
                            km9 km9Var2 = new km9();
                            km9Var2.v(next.a());
                            km9Var2.x(km9Var.f());
                            km9Var2.t(km9Var.b());
                            km9Var2.o(km9Var.a());
                            km9Var2.z(km9Var.l());
                            arrayList.add(km9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jm9 next2 = it.next();
                        km9 km9Var3 = new km9();
                        km9Var3.v(next2.a());
                        km9Var3.x(km9Var.f());
                        km9Var3.t(km9Var.b());
                        km9Var3.o(km9Var.a());
                        km9Var3.z(km9Var.l());
                        arrayList.add(km9Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
