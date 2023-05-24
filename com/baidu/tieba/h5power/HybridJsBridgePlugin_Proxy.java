package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
import com.baidu.tieba.vv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HybridJsBridgePlugin_Proxy extends is9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vv4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(vv4 vv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ks9Var.s(true);
                ks9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    ks9Var.y(e2.f());
                    ks9Var.u(e2.b());
                    ks9Var.o(e2.a());
                    ks9Var.x(e2.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ks9Var.s(true);
                ks9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    ks9Var.y(d.f());
                    ks9Var.u(d.b());
                    ks9Var.o(d.a());
                    ks9Var.x(d.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ks9Var.s(true);
                ks9 j = this.mJsBridge.j(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (j != null) {
                    ks9Var.y(j.f());
                    ks9Var.u(j.b());
                    ks9Var.o(j.a());
                    ks9Var.x(j.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ks9Var.s(true);
                ks9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    ks9Var.y(g.f());
                    ks9Var.u(g.b());
                    ks9Var.o(g.a());
                    ks9Var.x(g.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ks9Var.s(true);
                ks9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    ks9Var.y(f.f());
                    ks9Var.u(f.b());
                    ks9Var.o(f.a());
                    ks9Var.x(f.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                ks9Var.s(true);
                ks9 k = this.mJsBridge.k(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (k != null) {
                    ks9Var.y(k.f());
                    ks9Var.u(k.b());
                    ks9Var.o(k.a());
                    ks9Var.x(k.e());
                    if (!ks9Var.h()) {
                        ks9Var.n(false);
                        addObserver(webView, "RequestByNativeToH5", ks9Var, false);
                    }
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ks9Var = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                ks9Var = this.mJsBridge.l(webView, hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!TextUtils.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
