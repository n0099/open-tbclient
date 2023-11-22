package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.ps4;
import com.baidu.tieba.qsa;
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
public class HybridJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ps4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ps4 ps4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ps4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ps4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
        this.mNotificationNameList.add("parseLink");
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        osa osaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar2 = new osa();
            } else {
                osaVar2 = osaVar;
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                osaVar2.s(true);
                osa e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    osaVar2.y(e2.f());
                    osaVar2.u(e2.b());
                    osaVar2.o(e2.a());
                    osaVar2.x(e2.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                osaVar2.s(true);
                osa d = this.mJsBridge.d(webView);
                if (d != null) {
                    osaVar2.y(d.f());
                    osaVar2.u(d.b());
                    osaVar2.o(d.a());
                    osaVar2.x(d.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                osaVar2.s(true);
                osa n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    osaVar2.y(n.f());
                    osaVar2.u(n.b());
                    osaVar2.o(n.a());
                    osaVar2.x(n.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                osaVar2.s(true);
                osa i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    osaVar2.y(i.f());
                    osaVar2.u(i.b());
                    osaVar2.o(i.a());
                    osaVar2.x(i.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                osaVar2.s(true);
                osa f = this.mJsBridge.f(webView);
                if (f != null) {
                    osaVar2.y(f.f());
                    osaVar2.u(f.b());
                    osaVar2.o(f.a());
                    osaVar2.x(f.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                osaVar2.s(true);
                osa q = this.mJsBridge.q(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (q != null) {
                    osaVar2.y(q.f());
                    osaVar2.u(q.b());
                    osaVar2.o(q.a());
                    osaVar2.x(q.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                osaVar2.s(true);
                osa l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    osaVar2.y(l.f());
                    osaVar2.u(l.b());
                    osaVar2.o(l.a());
                    osaVar2.x(l.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("hybrid/parseLink")) {
                osaVar2.s(true);
                osa o = this.mJsBridge.o(webView, e.optString("forum_id"), e.optString("url"), e.optString("link_num"));
                this.mNotificationNameList.add("parseLink");
                if (o != null) {
                    osaVar2.y(o.f());
                    osaVar2.u(o.b());
                    osaVar2.o(o.a());
                    osaVar2.x(o.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "parseLink", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            }
            return osaVar2;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                osaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                osaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                osaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                osaVar = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("parseLink")) {
                osaVar = this.mJsBridge.p(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
