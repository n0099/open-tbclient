package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ny4;
import com.baidu.tieba.sl6;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
/* loaded from: classes6.dex */
public class HybridJsBridgePlugin_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ny4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ny4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ny4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                wy9Var.s(true);
                wy9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    wy9Var.y(e2.f());
                    wy9Var.u(e2.b());
                    wy9Var.o(e2.a());
                    wy9Var.x(e2.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                wy9Var.s(true);
                wy9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    wy9Var.y(d.f());
                    wy9Var.u(d.b());
                    wy9Var.o(d.a());
                    wy9Var.x(d.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                wy9Var.s(true);
                wy9 l = this.mJsBridge.l(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (l != null) {
                    wy9Var.y(l.f());
                    wy9Var.u(l.b());
                    wy9Var.o(l.a());
                    wy9Var.x(l.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                wy9Var.s(true);
                wy9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    wy9Var.y(g.f());
                    wy9Var.u(g.b());
                    wy9Var.o(g.a());
                    wy9Var.x(g.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                wy9Var.s(true);
                wy9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    wy9Var.y(f.f());
                    wy9Var.u(f.b());
                    wy9Var.o(f.a());
                    wy9Var.x(f.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                wy9Var.s(true);
                wy9 m = this.mJsBridge.m(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (m != null) {
                    wy9Var.y(m.f());
                    wy9Var.u(m.b());
                    wy9Var.o(m.a());
                    wy9Var.x(m.e());
                    if (!wy9Var.h()) {
                        wy9Var.n(false);
                        addObserver(webView, "RequestByNativeToH5", wy9Var, false);
                    }
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                wy9Var.s(true);
                wy9 j = this.mJsBridge.j(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (j != null) {
                    wy9Var.y(j.f());
                    wy9Var.u(j.b());
                    wy9Var.o(j.a());
                    wy9Var.x(j.e());
                    if (!wy9Var.h()) {
                        wy9Var.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", wy9Var, false);
                    }
                }
                wy9Var.z(0);
            }
            return wy9Var;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (sl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            wy9 wy9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                wy9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                wy9Var = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                wy9Var = this.mJsBridge.k(webView, hashMap);
            }
            if (wy9Var != null) {
                wy9Var.z(0);
            }
            List<vy9> list = this.mAsyncCallBackMethodList.get(str);
            if (wy9Var != null && list != null) {
                Iterator<vy9> it = list.iterator();
                if (!TextUtils.isEmpty(wy9Var.e())) {
                    while (it.hasNext()) {
                        vy9 next = it.next();
                        if (next.b().equals(wy9Var.e())) {
                            wy9 wy9Var2 = new wy9();
                            wy9Var2.w(next.a());
                            wy9Var2.y(wy9Var.f());
                            wy9Var2.u(wy9Var.b());
                            wy9Var2.o(wy9Var.a());
                            wy9Var2.A(wy9Var.l());
                            arrayList.add(wy9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        vy9 next2 = it.next();
                        wy9 wy9Var3 = new wy9();
                        wy9Var3.w(next2.a());
                        wy9Var3.y(wy9Var.f());
                        wy9Var3.u(wy9Var.b());
                        wy9Var3.o(wy9Var.a());
                        wy9Var3.A(wy9Var.l());
                        arrayList.add(wy9Var3);
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
