package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.oy4;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
public class HybridJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(oy4 oy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = oy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                t0aVar.s(true);
                t0a e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    t0aVar.y(e2.f());
                    t0aVar.u(e2.b());
                    t0aVar.o(e2.a());
                    t0aVar.x(e2.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                t0aVar.s(true);
                t0a d = this.mJsBridge.d(webView);
                if (d != null) {
                    t0aVar.y(d.f());
                    t0aVar.u(d.b());
                    t0aVar.o(d.a());
                    t0aVar.x(d.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                t0aVar.s(true);
                t0a l = this.mJsBridge.l(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (l != null) {
                    t0aVar.y(l.f());
                    t0aVar.u(l.b());
                    t0aVar.o(l.a());
                    t0aVar.x(l.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                t0aVar.s(true);
                t0a g = this.mJsBridge.g(webView);
                if (g != null) {
                    t0aVar.y(g.f());
                    t0aVar.u(g.b());
                    t0aVar.o(g.a());
                    t0aVar.x(g.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                t0aVar.s(true);
                t0a f = this.mJsBridge.f(webView);
                if (f != null) {
                    t0aVar.y(f.f());
                    t0aVar.u(f.b());
                    t0aVar.o(f.a());
                    t0aVar.x(f.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                t0aVar.s(true);
                t0a m = this.mJsBridge.m(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (m != null) {
                    t0aVar.y(m.f());
                    t0aVar.u(m.b());
                    t0aVar.o(m.a());
                    t0aVar.x(m.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "RequestByNativeToH5", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                t0aVar.s(true);
                t0a j = this.mJsBridge.j(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (j != null) {
                    t0aVar.y(j.f());
                    t0aVar.u(j.b());
                    t0aVar.o(j.a());
                    t0aVar.x(j.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                t0aVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                t0aVar = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                t0aVar = this.mJsBridge.k(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
