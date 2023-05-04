package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fq9;
import com.baidu.tieba.gq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.ju4;
import com.baidu.tieba.xf6;
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
public class DeviceJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ju4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ju4 ju4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ju4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("device/getZid")) {
                hq9Var.s(true);
                hq9 k = this.mJsBridge.k(webView);
                if (k != null) {
                    hq9Var.y(k.f());
                    hq9Var.u(k.b());
                    hq9Var.o(k.a());
                    hq9Var.x(k.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/getHdid")) {
                hq9Var.s(true);
                hq9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    hq9Var.y(i.f());
                    hq9Var.u(i.b());
                    hq9Var.o(i.a());
                    hq9Var.x(i.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                hq9Var.s(true);
                hq9 j = this.mJsBridge.j(webView);
                if (j != null) {
                    hq9Var.y(j.f());
                    hq9Var.u(j.b());
                    hq9Var.o(j.a());
                    hq9Var.x(j.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                hq9Var.s(true);
                hq9 h = this.mJsBridge.h(webView);
                if (h != null) {
                    hq9Var.y(h.f());
                    hq9Var.u(h.b());
                    hq9Var.o(h.a());
                    hq9Var.x(h.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                hq9Var.s(true);
                hq9 m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    hq9Var.y(m.f());
                    hq9Var.u(m.b());
                    hq9Var.o(m.a());
                    hq9Var.x(m.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/deviceMotion")) {
                hq9Var.s(true);
                hq9 d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    hq9Var.y(d.f());
                    hq9Var.u(d.b());
                    hq9Var.o(d.a());
                    hq9Var.x(d.e());
                    if (!hq9Var.h()) {
                        hq9Var.n(false);
                        addObserver(webView, "deviceMotion", hq9Var, true);
                    }
                }
                hq9Var.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                hq9Var.s(true);
                hq9 g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    hq9Var.y(g.f());
                    hq9Var.u(g.b());
                    hq9Var.o(g.a());
                    hq9Var.x(g.e());
                    if (!hq9Var.h()) {
                        hq9Var.n(false);
                        addObserver(webView, "deviceRefreshRate", hq9Var, true);
                    }
                }
                hq9Var.z(0);
            }
            return hq9Var;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            hq9 hq9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                hq9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                hq9Var = this.mJsBridge.f(webView, hashMap);
            }
            if (hq9Var != null) {
                hq9Var.z(0);
            }
            List<gq9> list = this.mAsyncCallBackMethodList.get(str);
            if (hq9Var != null && list != null) {
                Iterator<gq9> it = list.iterator();
                if (!TextUtils.isEmpty(hq9Var.e())) {
                    while (it.hasNext()) {
                        gq9 next = it.next();
                        if (next.b().equals(hq9Var.e())) {
                            hq9 hq9Var2 = new hq9();
                            hq9Var2.w(next.a());
                            hq9Var2.y(hq9Var.f());
                            hq9Var2.u(hq9Var.b());
                            hq9Var2.o(hq9Var.a());
                            hq9Var2.A(hq9Var.l());
                            arrayList.add(hq9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        gq9 next2 = it.next();
                        hq9 hq9Var3 = new hq9();
                        hq9Var3.w(next2.a());
                        hq9Var3.y(hq9Var.f());
                        hq9Var3.u(hq9Var.b());
                        hq9Var3.o(hq9Var.a());
                        hq9Var3.A(hq9Var.l());
                        arrayList.add(hq9Var3);
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
