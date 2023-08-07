package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.lx4;
import com.baidu.tieba.pk6;
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
public class HybridJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(lx4 lx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = lx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        jca jcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar2 = new jca();
            } else {
                jcaVar2 = jcaVar;
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                jcaVar2.s(true);
                jca e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    jcaVar2.y(e2.f());
                    jcaVar2.u(e2.b());
                    jcaVar2.o(e2.a());
                    jcaVar2.x(e2.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                jcaVar2.s(true);
                jca d = this.mJsBridge.d(webView);
                if (d != null) {
                    jcaVar2.y(d.f());
                    jcaVar2.u(d.b());
                    jcaVar2.o(d.a());
                    jcaVar2.x(d.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                jcaVar2.s(true);
                jca n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    jcaVar2.y(n.f());
                    jcaVar2.u(n.b());
                    jcaVar2.o(n.a());
                    jcaVar2.x(n.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                jcaVar2.s(true);
                jca i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    jcaVar2.y(i.f());
                    jcaVar2.u(i.b());
                    jcaVar2.o(i.a());
                    jcaVar2.x(i.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                jcaVar2.s(true);
                jca f = this.mJsBridge.f(webView);
                if (f != null) {
                    jcaVar2.y(f.f());
                    jcaVar2.u(f.b());
                    jcaVar2.o(f.a());
                    jcaVar2.x(f.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                jcaVar2.s(true);
                jca o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    jcaVar2.y(o.f());
                    jcaVar2.u(o.b());
                    jcaVar2.o(o.a());
                    jcaVar2.x(o.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                jcaVar2.s(true);
                jca l = this.mJsBridge.l(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    jcaVar2.y(l.f());
                    jcaVar2.u(l.b());
                    jcaVar2.o(l.a());
                    jcaVar2.x(l.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            }
            return jcaVar2;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                jcaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                jcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                jcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                jcaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!TextUtils.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
