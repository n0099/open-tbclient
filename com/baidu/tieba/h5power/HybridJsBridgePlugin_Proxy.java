package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.in6;
import com.baidu.tieba.ky4;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
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
public class HybridJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ky4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ky4 ky4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ky4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ky4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        qda qdaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar2 = new qda();
            } else {
                qdaVar2 = qdaVar;
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                qdaVar2.s(true);
                qda e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    qdaVar2.y(e2.f());
                    qdaVar2.u(e2.b());
                    qdaVar2.o(e2.a());
                    qdaVar2.x(e2.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                qdaVar2.s(true);
                qda d = this.mJsBridge.d(webView);
                if (d != null) {
                    qdaVar2.y(d.f());
                    qdaVar2.u(d.b());
                    qdaVar2.o(d.a());
                    qdaVar2.x(d.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                qdaVar2.s(true);
                qda n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    qdaVar2.y(n.f());
                    qdaVar2.u(n.b());
                    qdaVar2.o(n.a());
                    qdaVar2.x(n.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                qdaVar2.s(true);
                qda i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    qdaVar2.y(i.f());
                    qdaVar2.u(i.b());
                    qdaVar2.o(i.a());
                    qdaVar2.x(i.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                qdaVar2.s(true);
                qda f = this.mJsBridge.f(webView);
                if (f != null) {
                    qdaVar2.y(f.f());
                    qdaVar2.u(f.b());
                    qdaVar2.o(f.a());
                    qdaVar2.x(f.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                qdaVar2.s(true);
                qda o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    qdaVar2.y(o.f());
                    qdaVar2.u(o.b());
                    qdaVar2.o(o.a());
                    qdaVar2.x(o.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                qdaVar2.s(true);
                qda l = this.mJsBridge.l(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    qdaVar2.y(l.f());
                    qdaVar2.u(l.b());
                    qdaVar2.o(l.a());
                    qdaVar2.x(l.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            }
            return qdaVar2;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                qdaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                qdaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                qdaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                qdaVar = this.mJsBridge.m(webView, hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!TextUtils.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
