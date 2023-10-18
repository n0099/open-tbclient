package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.vr4;
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
public class DeviceJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vr4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(vr4 vr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vr4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vr4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar = new ifa();
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("device/getZid")) {
                ifaVar.s(true);
                ifa k = this.mJsBridge.k(webView);
                if (k != null) {
                    ifaVar.y(k.f());
                    ifaVar.u(k.b());
                    ifaVar.o(k.a());
                    ifaVar.x(k.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                ifaVar.s(true);
                ifa i = this.mJsBridge.i(webView);
                if (i != null) {
                    ifaVar.y(i.f());
                    ifaVar.u(i.b());
                    ifaVar.o(i.a());
                    ifaVar.x(i.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ifaVar.s(true);
                ifa j = this.mJsBridge.j(webView);
                if (j != null) {
                    ifaVar.y(j.f());
                    ifaVar.u(j.b());
                    ifaVar.o(j.a());
                    ifaVar.x(j.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                ifaVar.s(true);
                ifa h = this.mJsBridge.h(webView);
                if (h != null) {
                    ifaVar.y(h.f());
                    ifaVar.u(h.b());
                    ifaVar.o(h.a());
                    ifaVar.x(h.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ifaVar.s(true);
                ifa m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    ifaVar.y(m.f());
                    ifaVar.u(m.b());
                    ifaVar.o(m.a());
                    ifaVar.x(m.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                ifaVar.s(true);
                ifa d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    ifaVar.y(d.f());
                    ifaVar.u(d.b());
                    ifaVar.o(d.a());
                    ifaVar.x(d.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "deviceMotion", ifaVar, true);
                    }
                }
                ifaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                ifaVar.s(true);
                ifa g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    ifaVar.y(g.f());
                    ifaVar.u(g.b());
                    ifaVar.o(g.a());
                    ifaVar.x(g.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", ifaVar, true);
                    }
                }
                ifaVar.z(0);
            }
            return ifaVar;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                ifaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                ifaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
