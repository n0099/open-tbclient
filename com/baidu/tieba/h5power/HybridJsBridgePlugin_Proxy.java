package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.lx4;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
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
public class HybridJsBridgePlugin_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        kca kcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar2 = new kca();
            } else {
                kcaVar2 = kcaVar;
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                kcaVar2.s(true);
                kca e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    kcaVar2.y(e2.f());
                    kcaVar2.u(e2.b());
                    kcaVar2.o(e2.a());
                    kcaVar2.x(e2.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                kcaVar2.s(true);
                kca d = this.mJsBridge.d(webView);
                if (d != null) {
                    kcaVar2.y(d.f());
                    kcaVar2.u(d.b());
                    kcaVar2.o(d.a());
                    kcaVar2.x(d.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                kcaVar2.s(true);
                kca n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    kcaVar2.y(n.f());
                    kcaVar2.u(n.b());
                    kcaVar2.o(n.a());
                    kcaVar2.x(n.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                kcaVar2.s(true);
                kca i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    kcaVar2.y(i.f());
                    kcaVar2.u(i.b());
                    kcaVar2.o(i.a());
                    kcaVar2.x(i.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                kcaVar2.s(true);
                kca f = this.mJsBridge.f(webView);
                if (f != null) {
                    kcaVar2.y(f.f());
                    kcaVar2.u(f.b());
                    kcaVar2.o(f.a());
                    kcaVar2.x(f.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                kcaVar2.s(true);
                kca o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    kcaVar2.y(o.f());
                    kcaVar2.u(o.b());
                    kcaVar2.o(o.a());
                    kcaVar2.x(o.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                kcaVar2.s(true);
                kca l = this.mJsBridge.l(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    kcaVar2.y(l.f());
                    kcaVar2.u(l.b());
                    kcaVar2.o(l.a());
                    kcaVar2.x(l.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            }
            return kcaVar2;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            kca kcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                kcaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                kcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                kcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                kcaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!TextUtils.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
