package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
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
public class HybridJsBridgePlugin_Proxy extends hs9 {
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

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                js9Var.s(true);
                js9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    js9Var.y(e2.f());
                    js9Var.u(e2.b());
                    js9Var.o(e2.a());
                    js9Var.x(e2.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                js9Var.s(true);
                js9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    js9Var.y(d.f());
                    js9Var.u(d.b());
                    js9Var.o(d.a());
                    js9Var.x(d.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                js9Var.s(true);
                js9 j = this.mJsBridge.j(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (j != null) {
                    js9Var.y(j.f());
                    js9Var.u(j.b());
                    js9Var.o(j.a());
                    js9Var.x(j.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                js9Var.s(true);
                js9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    js9Var.y(g.f());
                    js9Var.u(g.b());
                    js9Var.o(g.a());
                    js9Var.x(g.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                js9Var.s(true);
                js9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    js9Var.y(f.f());
                    js9Var.u(f.b());
                    js9Var.o(f.a());
                    js9Var.x(f.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                js9Var.s(true);
                js9 k = this.mJsBridge.k(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (k != null) {
                    js9Var.y(k.f());
                    js9Var.u(k.b());
                    js9Var.o(k.a());
                    js9Var.x(k.e());
                    if (!js9Var.h()) {
                        js9Var.n(false);
                        addObserver(webView, "RequestByNativeToH5", js9Var, false);
                    }
                }
                js9Var.z(0);
            }
            return js9Var;
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
            js9 js9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                js9Var = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                js9Var = this.mJsBridge.l(webView, hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!TextUtils.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
