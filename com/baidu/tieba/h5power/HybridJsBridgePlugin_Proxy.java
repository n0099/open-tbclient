package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.ps4;
import com.baidu.tieba.psa;
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
public class HybridJsBridgePlugin_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        nsa nsaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar2 = new nsa();
            } else {
                nsaVar2 = nsaVar;
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                nsaVar2.s(true);
                nsa e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    nsaVar2.y(e2.f());
                    nsaVar2.u(e2.b());
                    nsaVar2.o(e2.a());
                    nsaVar2.x(e2.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                nsaVar2.s(true);
                nsa d = this.mJsBridge.d(webView);
                if (d != null) {
                    nsaVar2.y(d.f());
                    nsaVar2.u(d.b());
                    nsaVar2.o(d.a());
                    nsaVar2.x(d.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                nsaVar2.s(true);
                nsa n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    nsaVar2.y(n.f());
                    nsaVar2.u(n.b());
                    nsaVar2.o(n.a());
                    nsaVar2.x(n.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                nsaVar2.s(true);
                nsa i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    nsaVar2.y(i.f());
                    nsaVar2.u(i.b());
                    nsaVar2.o(i.a());
                    nsaVar2.x(i.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                nsaVar2.s(true);
                nsa f = this.mJsBridge.f(webView);
                if (f != null) {
                    nsaVar2.y(f.f());
                    nsaVar2.u(f.b());
                    nsaVar2.o(f.a());
                    nsaVar2.x(f.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                nsaVar2.s(true);
                nsa q = this.mJsBridge.q(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (q != null) {
                    nsaVar2.y(q.f());
                    nsaVar2.u(q.b());
                    nsaVar2.o(q.a());
                    nsaVar2.x(q.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                nsaVar2.s(true);
                nsa l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    nsaVar2.y(l.f());
                    nsaVar2.u(l.b());
                    nsaVar2.o(l.a());
                    nsaVar2.x(l.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("hybrid/parseLink")) {
                nsaVar2.s(true);
                nsa o = this.mJsBridge.o(webView, e.optString("forum_id"), e.optString("url"), e.optString("link_num"));
                this.mNotificationNameList.add("parseLink");
                if (o != null) {
                    nsaVar2.y(o.f());
                    nsaVar2.u(o.b());
                    nsaVar2.o(o.a());
                    nsaVar2.x(o.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "parseLink", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            }
            return nsaVar2;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                nsaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                nsaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                nsaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                nsaVar = this.mJsBridge.m(webView, hashMap);
            } else if (str.equals("parseLink")) {
                nsaVar = this.mJsBridge.p(webView, hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!TextUtils.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.j = nsaVar.j;
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.j = nsaVar.j;
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
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
