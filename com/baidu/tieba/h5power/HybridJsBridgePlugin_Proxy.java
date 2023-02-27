package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.l69;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.pv4;
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
/* loaded from: classes4.dex */
public class HybridJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(pv4 pv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = pv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                n69Var.r(true);
                n69 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    n69Var.x(e2.f());
                    n69Var.t(e2.b());
                    n69Var.o(e2.a());
                    n69Var.w(e2.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                n69Var.r(true);
                n69 d = this.mJsBridge.d(webView);
                if (d != null) {
                    n69Var.x(d.f());
                    n69Var.t(d.b());
                    n69Var.o(d.a());
                    n69Var.w(d.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                n69Var.r(true);
                n69 i = this.mJsBridge.i(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (i != null) {
                    n69Var.x(i.f());
                    n69Var.t(i.b());
                    n69Var.o(i.a());
                    n69Var.w(i.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                n69Var.r(true);
                n69 g = this.mJsBridge.g(webView);
                if (g != null) {
                    n69Var.x(g.f());
                    n69Var.t(g.b());
                    n69Var.o(g.a());
                    n69Var.w(g.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                n69Var.r(true);
                n69 f = this.mJsBridge.f(webView);
                if (f != null) {
                    n69Var.x(f.f());
                    n69Var.t(f.b());
                    n69Var.o(f.a());
                    n69Var.w(f.e());
                }
                n69Var.y(0);
            }
            return n69Var;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            n69 n69Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                n69Var = this.mJsBridge.j(webView, hashMap);
            }
            if (n69Var != null) {
                n69Var.y(0);
            }
            List<m69> list = this.mAsyncCallBackMethodList.get(str);
            if (n69Var != null && list != null) {
                Iterator<m69> it = list.iterator();
                if (!TextUtils.isEmpty(n69Var.e())) {
                    while (it.hasNext()) {
                        m69 next = it.next();
                        if (next.b().equals(n69Var.e())) {
                            n69 n69Var2 = new n69();
                            n69Var2.v(next.a());
                            n69Var2.x(n69Var.f());
                            n69Var2.t(n69Var.b());
                            n69Var2.o(n69Var.a());
                            n69Var2.z(n69Var.l());
                            arrayList.add(n69Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        m69 next2 = it.next();
                        n69 n69Var3 = new n69();
                        n69Var3.v(next2.a());
                        n69Var3.x(n69Var.f());
                        n69Var3.t(n69Var.b());
                        n69Var3.o(n69Var.a());
                        n69Var3.z(n69Var.l());
                        arrayList.add(n69Var3);
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
