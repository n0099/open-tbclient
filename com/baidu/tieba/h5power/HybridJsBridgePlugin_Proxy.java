package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.rc9;
import com.baidu.tieba.sc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
import com.baidu.tieba.wt4;
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
public class HybridJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(wt4 wt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = wt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
    }

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                tc9Var.r(true);
                tc9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    tc9Var.x(e2.f());
                    tc9Var.t(e2.b());
                    tc9Var.o(e2.a());
                    tc9Var.w(e2.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                tc9Var.r(true);
                tc9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    tc9Var.x(d.f());
                    tc9Var.t(d.b());
                    tc9Var.o(d.a());
                    tc9Var.w(d.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                tc9Var.r(true);
                tc9 i = this.mJsBridge.i(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (i != null) {
                    tc9Var.x(i.f());
                    tc9Var.t(i.b());
                    tc9Var.o(i.a());
                    tc9Var.w(i.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                tc9Var.r(true);
                tc9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    tc9Var.x(g.f());
                    tc9Var.t(g.b());
                    tc9Var.o(g.a());
                    tc9Var.w(g.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                tc9Var.r(true);
                tc9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    tc9Var.x(f.f());
                    tc9Var.t(f.b());
                    tc9Var.o(f.a());
                    tc9Var.w(f.e());
                }
                tc9Var.y(0);
            }
            return tc9Var;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            tc9 tc9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                tc9Var = this.mJsBridge.j(webView, hashMap);
            }
            if (tc9Var != null) {
                tc9Var.y(0);
            }
            List<sc9> list = this.mAsyncCallBackMethodList.get(str);
            if (tc9Var != null && list != null) {
                Iterator<sc9> it = list.iterator();
                if (!TextUtils.isEmpty(tc9Var.e())) {
                    while (it.hasNext()) {
                        sc9 next = it.next();
                        if (next.b().equals(tc9Var.e())) {
                            tc9 tc9Var2 = new tc9();
                            tc9Var2.v(next.a());
                            tc9Var2.x(tc9Var.f());
                            tc9Var2.t(tc9Var.b());
                            tc9Var2.o(tc9Var.a());
                            tc9Var2.z(tc9Var.l());
                            arrayList.add(tc9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sc9 next2 = it.next();
                        tc9 tc9Var3 = new tc9();
                        tc9Var3.v(next2.a());
                        tc9Var3.x(tc9Var.f());
                        tc9Var3.t(tc9Var.b());
                        tc9Var3.o(tc9Var.a());
                        tc9Var3.z(tc9Var.l());
                        arrayList.add(tc9Var3);
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
