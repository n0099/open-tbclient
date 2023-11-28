package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.mj6;
import com.baidu.tieba.qs4;
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
public class HybridJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qs4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(qs4 qs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
        this.mNotificationNameList.add("parseLink");
    }

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        gxa gxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar2 = new gxa();
            } else {
                gxaVar2 = gxaVar;
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                gxaVar2.s(true);
                gxa e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    gxaVar2.y(e2.f());
                    gxaVar2.u(e2.b());
                    gxaVar2.o(e2.a());
                    gxaVar2.x(e2.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                gxaVar2.s(true);
                gxa d = this.mJsBridge.d(webView);
                if (d != null) {
                    gxaVar2.y(d.f());
                    gxaVar2.u(d.b());
                    gxaVar2.o(d.a());
                    gxaVar2.x(d.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                gxaVar2.s(true);
                gxa n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    gxaVar2.y(n.f());
                    gxaVar2.u(n.b());
                    gxaVar2.o(n.a());
                    gxaVar2.x(n.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                gxaVar2.s(true);
                gxa i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    gxaVar2.y(i.f());
                    gxaVar2.u(i.b());
                    gxaVar2.o(i.a());
                    gxaVar2.x(i.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                gxaVar2.s(true);
                gxa f = this.mJsBridge.f(webView);
                if (f != null) {
                    gxaVar2.y(f.f());
                    gxaVar2.u(f.b());
                    gxaVar2.o(f.a());
                    gxaVar2.x(f.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                gxaVar2.s(true);
                gxa q = this.mJsBridge.q(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (q != null) {
                    gxaVar2.y(q.f());
                    gxaVar2.u(q.b());
                    gxaVar2.o(q.a());
                    gxaVar2.x(q.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                gxaVar2.s(true);
                gxa l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    gxaVar2.y(l.f());
                    gxaVar2.u(l.b());
                    gxaVar2.o(l.a());
                    gxaVar2.x(l.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/parseLink")) {
                gxaVar2.s(true);
                gxa o = this.mJsBridge.o(webView, e.optString("forum_id"), e.optString("url"), e.optString("link_num"));
                this.mNotificationNameList.add("parseLink");
                if (o != null) {
                    gxaVar2.y(o.f());
                    gxaVar2.u(o.b());
                    gxaVar2.o(o.a());
                    gxaVar2.x(o.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "parseLink", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("hybrid/syncWebViewWhiteState")) {
                gxaVar2.s(true);
                gxa t = this.mJsBridge.t(webView, e.optBoolean("isWhite"), e.optJSONObject("webviewState"));
                this.mNotificationNameList.add("syncWebViewWhiteState");
                if (t != null) {
                    gxaVar2.y(t.f());
                    gxaVar2.u(t.b());
                    gxaVar2.o(t.a());
                    gxaVar2.x(t.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "syncWebViewWhiteState", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            }
            return gxaVar2;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                gxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                gxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                gxaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                gxaVar = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("parseLink")) {
                gxaVar = this.mJsBridge.p(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
