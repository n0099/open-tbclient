package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ly4;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
public class DeviceJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ly4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ly4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("device/getZid")) {
                t0aVar.s(true);
                t0a k = this.mJsBridge.k(webView);
                if (k != null) {
                    t0aVar.y(k.f());
                    t0aVar.u(k.b());
                    t0aVar.o(k.a());
                    t0aVar.x(k.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/getHdid")) {
                t0aVar.s(true);
                t0a i = this.mJsBridge.i(webView);
                if (i != null) {
                    t0aVar.y(i.f());
                    t0aVar.u(i.b());
                    t0aVar.o(i.a());
                    t0aVar.x(i.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                t0aVar.s(true);
                t0a j = this.mJsBridge.j(webView);
                if (j != null) {
                    t0aVar.y(j.f());
                    t0aVar.u(j.b());
                    t0aVar.o(j.a());
                    t0aVar.x(j.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                t0aVar.s(true);
                t0a h = this.mJsBridge.h(webView);
                if (h != null) {
                    t0aVar.y(h.f());
                    t0aVar.u(h.b());
                    t0aVar.o(h.a());
                    t0aVar.x(h.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                t0aVar.s(true);
                t0a m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    t0aVar.y(m.f());
                    t0aVar.u(m.b());
                    t0aVar.o(m.a());
                    t0aVar.x(m.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                t0aVar.s(true);
                t0a d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    t0aVar.y(d.f());
                    t0aVar.u(d.b());
                    t0aVar.o(d.a());
                    t0aVar.x(d.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "deviceMotion", t0aVar, true);
                    }
                }
                t0aVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                t0aVar.s(true);
                t0a g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    t0aVar.y(g.f());
                    t0aVar.u(g.b());
                    t0aVar.o(g.a());
                    t0aVar.x(g.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "deviceRefreshRate", t0aVar, true);
                    }
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                t0aVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                t0aVar = this.mJsBridge.f(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
