package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.sv4;
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
/* loaded from: classes5.dex */
public class DeviceJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sv4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(sv4 sv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("device/getZid")) {
                js9Var.s(true);
                js9 k = this.mJsBridge.k(webView);
                if (k != null) {
                    js9Var.y(k.f());
                    js9Var.u(k.b());
                    js9Var.o(k.a());
                    js9Var.x(k.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/getHdid")) {
                js9Var.s(true);
                js9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    js9Var.y(i.f());
                    js9Var.u(i.b());
                    js9Var.o(i.a());
                    js9Var.x(i.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                js9Var.s(true);
                js9 j = this.mJsBridge.j(webView);
                if (j != null) {
                    js9Var.y(j.f());
                    js9Var.u(j.b());
                    js9Var.o(j.a());
                    js9Var.x(j.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                js9Var.s(true);
                js9 h = this.mJsBridge.h(webView);
                if (h != null) {
                    js9Var.y(h.f());
                    js9Var.u(h.b());
                    js9Var.o(h.a());
                    js9Var.x(h.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                js9Var.s(true);
                js9 m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    js9Var.y(m.f());
                    js9Var.u(m.b());
                    js9Var.o(m.a());
                    js9Var.x(m.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/deviceMotion")) {
                js9Var.s(true);
                js9 d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    js9Var.y(d.f());
                    js9Var.u(d.b());
                    js9Var.o(d.a());
                    js9Var.x(d.e());
                    if (!js9Var.h()) {
                        js9Var.n(false);
                        addObserver(webView, "deviceMotion", js9Var, true);
                    }
                }
                js9Var.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                js9Var.s(true);
                js9 g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    js9Var.y(g.f());
                    js9Var.u(g.b());
                    js9Var.o(g.a());
                    js9Var.x(g.e());
                    if (!js9Var.h()) {
                        js9Var.n(false);
                        addObserver(webView, "deviceRefreshRate", js9Var, true);
                    }
                }
                js9Var.z(0);
            }
            return js9Var;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            js9 js9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                js9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                js9Var = this.mJsBridge.f(webView, hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!TextUtils.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
