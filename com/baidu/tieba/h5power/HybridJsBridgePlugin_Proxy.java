package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.nx4;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
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
public class HybridJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nx4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = nx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        sga sgaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar2 = new sga();
            } else {
                sgaVar2 = sgaVar;
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sgaVar2.s(true);
                sga e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    sgaVar2.y(e2.f());
                    sgaVar2.u(e2.b());
                    sgaVar2.o(e2.a());
                    sgaVar2.x(e2.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sgaVar2.s(true);
                sga d = this.mJsBridge.d(webView);
                if (d != null) {
                    sgaVar2.y(d.f());
                    sgaVar2.u(d.b());
                    sgaVar2.o(d.a());
                    sgaVar2.x(d.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sgaVar2.s(true);
                sga n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    sgaVar2.y(n.f());
                    sgaVar2.u(n.b());
                    sgaVar2.o(n.a());
                    sgaVar2.x(n.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sgaVar2.s(true);
                sga i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    sgaVar2.y(i.f());
                    sgaVar2.u(i.b());
                    sgaVar2.o(i.a());
                    sgaVar2.x(i.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sgaVar2.s(true);
                sga f = this.mJsBridge.f(webView);
                if (f != null) {
                    sgaVar2.y(f.f());
                    sgaVar2.u(f.b());
                    sgaVar2.o(f.a());
                    sgaVar2.x(f.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                sgaVar2.s(true);
                sga o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    sgaVar2.y(o.f());
                    sgaVar2.u(o.b());
                    sgaVar2.o(o.a());
                    sgaVar2.x(o.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                sgaVar2.s(true);
                sga l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    sgaVar2.y(l.f());
                    sgaVar2.u(l.b());
                    sgaVar2.o(l.a());
                    sgaVar2.x(l.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            }
            return sgaVar2;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                sgaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sgaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                sgaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                sgaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!TextUtils.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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
