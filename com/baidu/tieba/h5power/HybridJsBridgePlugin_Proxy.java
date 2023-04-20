package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.qm9;
import com.baidu.tieba.rm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
import com.baidu.tieba.zt4;
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
public class HybridJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zt4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(zt4 zt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
    }

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sm9Var.r(true);
                sm9 e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    sm9Var.x(e2.f());
                    sm9Var.t(e2.b());
                    sm9Var.o(e2.a());
                    sm9Var.w(e2.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sm9Var.r(true);
                sm9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    sm9Var.x(d.f());
                    sm9Var.t(d.b());
                    sm9Var.o(d.a());
                    sm9Var.w(d.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sm9Var.r(true);
                sm9 i = this.mJsBridge.i(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (i != null) {
                    sm9Var.x(i.f());
                    sm9Var.t(i.b());
                    sm9Var.o(i.a());
                    sm9Var.w(i.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sm9Var.r(true);
                sm9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    sm9Var.x(g.f());
                    sm9Var.t(g.b());
                    sm9Var.o(g.a());
                    sm9Var.w(g.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sm9Var.r(true);
                sm9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    sm9Var.x(f.f());
                    sm9Var.t(f.b());
                    sm9Var.o(f.a());
                    sm9Var.w(f.e());
                }
                sm9Var.y(0);
            }
            return sm9Var;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            sm9 sm9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sm9Var = this.mJsBridge.j(webView, hashMap);
            }
            if (sm9Var != null) {
                sm9Var.y(0);
            }
            List<rm9> list = this.mAsyncCallBackMethodList.get(str);
            if (sm9Var != null && list != null) {
                Iterator<rm9> it = list.iterator();
                if (!TextUtils.isEmpty(sm9Var.e())) {
                    while (it.hasNext()) {
                        rm9 next = it.next();
                        if (next.b().equals(sm9Var.e())) {
                            sm9 sm9Var2 = new sm9();
                            sm9Var2.v(next.a());
                            sm9Var2.x(sm9Var.f());
                            sm9Var2.t(sm9Var.b());
                            sm9Var2.o(sm9Var.a());
                            sm9Var2.z(sm9Var.l());
                            arrayList.add(sm9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rm9 next2 = it.next();
                        sm9 sm9Var3 = new sm9();
                        sm9Var3.v(next2.a());
                        sm9Var3.x(sm9Var.f());
                        sm9Var3.t(sm9Var.b());
                        sm9Var3.o(sm9Var.a());
                        sm9Var3.z(sm9Var.l());
                        arrayList.add(sm9Var3);
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
