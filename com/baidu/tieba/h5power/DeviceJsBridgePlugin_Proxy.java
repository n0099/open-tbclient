package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class DeviceJsBridgePlugin_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("device/getZid")) {
                ks9Var.s(true);
                ks9 k = this.mJsBridge.k(webView);
                if (k != null) {
                    ks9Var.y(k.f());
                    ks9Var.u(k.b());
                    ks9Var.o(k.a());
                    ks9Var.x(k.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/getHdid")) {
                ks9Var.s(true);
                ks9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    ks9Var.y(i.f());
                    ks9Var.u(i.b());
                    ks9Var.o(i.a());
                    ks9Var.x(i.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ks9Var.s(true);
                ks9 j = this.mJsBridge.j(webView);
                if (j != null) {
                    ks9Var.y(j.f());
                    ks9Var.u(j.b());
                    ks9Var.o(j.a());
                    ks9Var.x(j.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                ks9Var.s(true);
                ks9 h = this.mJsBridge.h(webView);
                if (h != null) {
                    ks9Var.y(h.f());
                    ks9Var.u(h.b());
                    ks9Var.o(h.a());
                    ks9Var.x(h.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ks9Var.s(true);
                ks9 m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    ks9Var.y(m.f());
                    ks9Var.u(m.b());
                    ks9Var.o(m.a());
                    ks9Var.x(m.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/deviceMotion")) {
                ks9Var.s(true);
                ks9 d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    ks9Var.y(d.f());
                    ks9Var.u(d.b());
                    ks9Var.o(d.a());
                    ks9Var.x(d.e());
                    if (!ks9Var.h()) {
                        ks9Var.n(false);
                        addObserver(webView, "deviceMotion", ks9Var, true);
                    }
                }
                ks9Var.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                ks9Var.s(true);
                ks9 g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    ks9Var.y(g.f());
                    ks9Var.u(g.b());
                    ks9Var.o(g.a());
                    ks9Var.x(g.e());
                    if (!ks9Var.h()) {
                        ks9Var.n(false);
                        addObserver(webView, "deviceRefreshRate", ks9Var, true);
                    }
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                ks9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                ks9Var = this.mJsBridge.f(webView, hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!TextUtils.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
