package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.mj6;
import com.baidu.tieba.ns4;
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
public class DeviceJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ns4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ns4 ns4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ns4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ns4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("device/getZid")) {
                gxaVar.s(true);
                gxa k = this.mJsBridge.k(webView);
                if (k != null) {
                    gxaVar.y(k.f());
                    gxaVar.u(k.b());
                    gxaVar.o(k.a());
                    gxaVar.x(k.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                gxaVar.s(true);
                gxa i = this.mJsBridge.i(webView);
                if (i != null) {
                    gxaVar.y(i.f());
                    gxaVar.u(i.b());
                    gxaVar.o(i.a());
                    gxaVar.x(i.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                gxaVar.s(true);
                gxa j = this.mJsBridge.j(webView);
                if (j != null) {
                    gxaVar.y(j.f());
                    gxaVar.u(j.b());
                    gxaVar.o(j.a());
                    gxaVar.x(j.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                gxaVar.s(true);
                gxa h = this.mJsBridge.h(webView);
                if (h != null) {
                    gxaVar.y(h.f());
                    gxaVar.u(h.b());
                    gxaVar.o(h.a());
                    gxaVar.x(h.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                gxaVar.s(true);
                gxa m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    gxaVar.y(m.f());
                    gxaVar.u(m.b());
                    gxaVar.o(m.a());
                    gxaVar.x(m.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                gxaVar.s(true);
                gxa d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    gxaVar.y(d.f());
                    gxaVar.u(d.b());
                    gxaVar.o(d.a());
                    gxaVar.x(d.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "deviceMotion", gxaVar, true);
                    }
                }
                gxaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                gxaVar.s(true);
                gxa g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    gxaVar.y(g.f());
                    gxaVar.u(g.b());
                    gxaVar.o(g.a());
                    gxaVar.x(g.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", gxaVar, true);
                    }
                }
                gxaVar.z(0);
            }
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                gxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                gxaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
