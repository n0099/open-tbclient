package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.yr4;
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
public class HybridJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(yr4 yr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yr4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = yr4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        ifa ifaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar2 = new ifa();
            } else {
                ifaVar2 = ifaVar;
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ifaVar2.s(true);
                ifa e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    ifaVar2.y(e2.f());
                    ifaVar2.u(e2.b());
                    ifaVar2.o(e2.a());
                    ifaVar2.x(e2.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ifaVar2.s(true);
                ifa d = this.mJsBridge.d(webView);
                if (d != null) {
                    ifaVar2.y(d.f());
                    ifaVar2.u(d.b());
                    ifaVar2.o(d.a());
                    ifaVar2.x(d.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ifaVar2.s(true);
                ifa n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    ifaVar2.y(n.f());
                    ifaVar2.u(n.b());
                    ifaVar2.o(n.a());
                    ifaVar2.x(n.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ifaVar2.s(true);
                ifa i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    ifaVar2.y(i.f());
                    ifaVar2.u(i.b());
                    ifaVar2.o(i.a());
                    ifaVar2.x(i.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ifaVar2.s(true);
                ifa f = this.mJsBridge.f(webView);
                if (f != null) {
                    ifaVar2.y(f.f());
                    ifaVar2.u(f.b());
                    ifaVar2.o(f.a());
                    ifaVar2.x(f.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                ifaVar2.s(true);
                ifa o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    ifaVar2.y(o.f());
                    ifaVar2.u(o.b());
                    ifaVar2.o(o.a());
                    ifaVar2.x(o.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                ifaVar2.s(true);
                ifa l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    ifaVar2.y(l.f());
                    ifaVar2.u(l.b());
                    ifaVar2.o(l.a());
                    ifaVar2.x(l.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            }
            return ifaVar2;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                ifaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ifaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                ifaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                ifaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
