package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.qj6;
import com.baidu.tieba.qs4;
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
public class DeviceJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qs4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(qs4 qs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("device/getZid")) {
                fxaVar.s(true);
                fxa k = this.mJsBridge.k(webView);
                if (k != null) {
                    fxaVar.y(k.f());
                    fxaVar.u(k.b());
                    fxaVar.o(k.a());
                    fxaVar.x(k.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                fxaVar.s(true);
                fxa i = this.mJsBridge.i(webView);
                if (i != null) {
                    fxaVar.y(i.f());
                    fxaVar.u(i.b());
                    fxaVar.o(i.a());
                    fxaVar.x(i.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                fxaVar.s(true);
                fxa j = this.mJsBridge.j(webView);
                if (j != null) {
                    fxaVar.y(j.f());
                    fxaVar.u(j.b());
                    fxaVar.o(j.a());
                    fxaVar.x(j.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                fxaVar.s(true);
                fxa h = this.mJsBridge.h(webView);
                if (h != null) {
                    fxaVar.y(h.f());
                    fxaVar.u(h.b());
                    fxaVar.o(h.a());
                    fxaVar.x(h.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                fxaVar.s(true);
                fxa m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    fxaVar.y(m.f());
                    fxaVar.u(m.b());
                    fxaVar.o(m.a());
                    fxaVar.x(m.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                fxaVar.s(true);
                fxa d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    fxaVar.y(d.f());
                    fxaVar.u(d.b());
                    fxaVar.o(d.a());
                    fxaVar.x(d.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "deviceMotion", fxaVar, true);
                    }
                }
                fxaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                fxaVar.s(true);
                fxa g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    fxaVar.y(g.f());
                    fxaVar.u(g.b());
                    fxaVar.o(g.a());
                    fxaVar.x(g.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", fxaVar, true);
                    }
                }
                fxaVar.z(0);
            }
            return fxaVar;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                fxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                fxaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
