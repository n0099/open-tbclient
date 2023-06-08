package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ny4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class HybridJsBridgePlugin_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ny4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ny4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ny4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                bz9Var.s(true);
                bz9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    bz9Var.y(e2.f());
                    bz9Var.u(e2.b());
                    bz9Var.o(e2.a());
                    bz9Var.x(e2.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                bz9Var.s(true);
                bz9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    bz9Var.y(d.f());
                    bz9Var.u(d.b());
                    bz9Var.o(d.a());
                    bz9Var.x(d.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                bz9Var.s(true);
                bz9 l = this.mJsBridge.l(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (l != null) {
                    bz9Var.y(l.f());
                    bz9Var.u(l.b());
                    bz9Var.o(l.a());
                    bz9Var.x(l.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                bz9Var.s(true);
                bz9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    bz9Var.y(g.f());
                    bz9Var.u(g.b());
                    bz9Var.o(g.a());
                    bz9Var.x(g.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                bz9Var.s(true);
                bz9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    bz9Var.y(f.f());
                    bz9Var.u(f.b());
                    bz9Var.o(f.a());
                    bz9Var.x(f.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                bz9Var.s(true);
                bz9 m = this.mJsBridge.m(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (m != null) {
                    bz9Var.y(m.f());
                    bz9Var.u(m.b());
                    bz9Var.o(m.a());
                    bz9Var.x(m.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "RequestByNativeToH5", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                bz9Var.s(true);
                bz9 j = this.mJsBridge.j(webView, e.optString("host"), e.optString("path"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (j != null) {
                    bz9Var.y(j.f());
                    bz9Var.u(j.b());
                    bz9Var.o(j.a());
                    bz9Var.x(j.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                bz9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                bz9Var = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                bz9Var = this.mJsBridge.k(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
