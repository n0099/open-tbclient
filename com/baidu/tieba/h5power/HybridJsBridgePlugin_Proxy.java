package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.ry4;
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
public class HybridJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ry4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ry4 ry4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ry4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ry4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                f5aVar.s(true);
                f5a e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    f5aVar.y(e2.f());
                    f5aVar.u(e2.b());
                    f5aVar.o(e2.a());
                    f5aVar.x(e2.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                f5aVar.s(true);
                f5a d = this.mJsBridge.d(webView);
                if (d != null) {
                    f5aVar.y(d.f());
                    f5aVar.u(d.b());
                    f5aVar.o(d.a());
                    f5aVar.x(d.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                f5aVar.s(true);
                f5a l = this.mJsBridge.l(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (l != null) {
                    f5aVar.y(l.f());
                    f5aVar.u(l.b());
                    f5aVar.o(l.a());
                    f5aVar.x(l.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                f5aVar.s(true);
                f5a g = this.mJsBridge.g(webView);
                if (g != null) {
                    f5aVar.y(g.f());
                    f5aVar.u(g.b());
                    f5aVar.o(g.a());
                    f5aVar.x(g.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                f5aVar.s(true);
                f5a f = this.mJsBridge.f(webView);
                if (f != null) {
                    f5aVar.y(f.f());
                    f5aVar.u(f.b());
                    f5aVar.o(f.a());
                    f5aVar.x(f.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                f5aVar.s(true);
                f5a m = this.mJsBridge.m(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (m != null) {
                    f5aVar.y(m.f());
                    f5aVar.u(m.b());
                    f5aVar.o(m.a());
                    f5aVar.x(m.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "RequestByNativeToH5", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                f5aVar.s(true);
                f5a j = this.mJsBridge.j(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (j != null) {
                    f5aVar.y(j.f());
                    f5aVar.u(j.b());
                    f5aVar.o(j.a());
                    f5aVar.x(j.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                f5aVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                f5aVar = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                f5aVar = this.mJsBridge.k(webView, hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!TextUtils.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
