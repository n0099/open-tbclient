package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.qka;
import com.baidu.tieba.qx4;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
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
public class HybridJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qx4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(qx4 qx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        ska skaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar2 = new ska();
            } else {
                skaVar2 = skaVar;
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                skaVar2.s(true);
                ska e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    skaVar2.y(e2.f());
                    skaVar2.u(e2.b());
                    skaVar2.o(e2.a());
                    skaVar2.x(e2.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                skaVar2.s(true);
                ska d = this.mJsBridge.d(webView);
                if (d != null) {
                    skaVar2.y(d.f());
                    skaVar2.u(d.b());
                    skaVar2.o(d.a());
                    skaVar2.x(d.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                skaVar2.s(true);
                ska n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    skaVar2.y(n.f());
                    skaVar2.u(n.b());
                    skaVar2.o(n.a());
                    skaVar2.x(n.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                skaVar2.s(true);
                ska i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    skaVar2.y(i.f());
                    skaVar2.u(i.b());
                    skaVar2.o(i.a());
                    skaVar2.x(i.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                skaVar2.s(true);
                ska f = this.mJsBridge.f(webView);
                if (f != null) {
                    skaVar2.y(f.f());
                    skaVar2.u(f.b());
                    skaVar2.o(f.a());
                    skaVar2.x(f.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                skaVar2.s(true);
                ska o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    skaVar2.y(o.f());
                    skaVar2.u(o.b());
                    skaVar2.o(o.a());
                    skaVar2.x(o.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                skaVar2.s(true);
                ska l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    skaVar2.y(l.f());
                    skaVar2.u(l.b());
                    skaVar2.o(l.a());
                    skaVar2.x(l.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            }
            return skaVar2;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                skaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                skaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                skaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                skaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
