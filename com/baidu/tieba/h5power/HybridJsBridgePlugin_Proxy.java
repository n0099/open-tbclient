package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.qj6;
import com.baidu.tieba.ts4;
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
public class HybridJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ts4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ts4 ts4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ts4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ts4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
        this.mNotificationNameList.add("parseLink");
    }

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        fxa fxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar2 = new fxa();
            } else {
                fxaVar2 = fxaVar;
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                fxaVar2.s(true);
                fxa e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    fxaVar2.y(e2.f());
                    fxaVar2.u(e2.b());
                    fxaVar2.o(e2.a());
                    fxaVar2.x(e2.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                fxaVar2.s(true);
                fxa d = this.mJsBridge.d(webView);
                if (d != null) {
                    fxaVar2.y(d.f());
                    fxaVar2.u(d.b());
                    fxaVar2.o(d.a());
                    fxaVar2.x(d.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                fxaVar2.s(true);
                fxa n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    fxaVar2.y(n.f());
                    fxaVar2.u(n.b());
                    fxaVar2.o(n.a());
                    fxaVar2.x(n.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                fxaVar2.s(true);
                fxa i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    fxaVar2.y(i.f());
                    fxaVar2.u(i.b());
                    fxaVar2.o(i.a());
                    fxaVar2.x(i.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                fxaVar2.s(true);
                fxa f = this.mJsBridge.f(webView);
                if (f != null) {
                    fxaVar2.y(f.f());
                    fxaVar2.u(f.b());
                    fxaVar2.o(f.a());
                    fxaVar2.x(f.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                fxaVar2.s(true);
                fxa q = this.mJsBridge.q(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (q != null) {
                    fxaVar2.y(q.f());
                    fxaVar2.u(q.b());
                    fxaVar2.o(q.a());
                    fxaVar2.x(q.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                fxaVar2.s(true);
                fxa l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    fxaVar2.y(l.f());
                    fxaVar2.u(l.b());
                    fxaVar2.o(l.a());
                    fxaVar2.x(l.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/parseLink")) {
                fxaVar2.s(true);
                fxa o = this.mJsBridge.o(webView, e.optString("forum_id"), e.optString("url"), e.optString("link_num"));
                this.mNotificationNameList.add("parseLink");
                if (o != null) {
                    fxaVar2.y(o.f());
                    fxaVar2.u(o.b());
                    fxaVar2.o(o.a());
                    fxaVar2.x(o.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "parseLink", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("hybrid/syncWebViewWhiteState")) {
                fxaVar2.s(true);
                fxa t = this.mJsBridge.t(webView, e.optBoolean("isWhite"), e.optJSONObject("webviewState"));
                this.mNotificationNameList.add("syncWebViewWhiteState");
                if (t != null) {
                    fxaVar2.y(t.f());
                    fxaVar2.u(t.b());
                    fxaVar2.o(t.a());
                    fxaVar2.x(t.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "syncWebViewWhiteState", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            }
            return fxaVar2;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                fxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                fxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                fxaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                fxaVar = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("parseLink")) {
                fxaVar = this.mJsBridge.p(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
