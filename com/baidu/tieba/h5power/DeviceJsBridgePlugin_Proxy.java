package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dj6;
import com.baidu.tieba.ms4;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
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
public class DeviceJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ms4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ms4 ms4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ms4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ms4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("device/getZid")) {
                osaVar.s(true);
                osa k = this.mJsBridge.k(webView);
                if (k != null) {
                    osaVar.y(k.f());
                    osaVar.u(k.b());
                    osaVar.o(k.a());
                    osaVar.x(k.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                osaVar.s(true);
                osa i = this.mJsBridge.i(webView);
                if (i != null) {
                    osaVar.y(i.f());
                    osaVar.u(i.b());
                    osaVar.o(i.a());
                    osaVar.x(i.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                osaVar.s(true);
                osa j = this.mJsBridge.j(webView);
                if (j != null) {
                    osaVar.y(j.f());
                    osaVar.u(j.b());
                    osaVar.o(j.a());
                    osaVar.x(j.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                osaVar.s(true);
                osa h = this.mJsBridge.h(webView);
                if (h != null) {
                    osaVar.y(h.f());
                    osaVar.u(h.b());
                    osaVar.o(h.a());
                    osaVar.x(h.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                osaVar.s(true);
                osa m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    osaVar.y(m.f());
                    osaVar.u(m.b());
                    osaVar.o(m.a());
                    osaVar.x(m.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                osaVar.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    osaVar.y(d.f());
                    osaVar.u(d.b());
                    osaVar.o(d.a());
                    osaVar.x(d.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "deviceMotion", osaVar, true);
                    }
                }
                osaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                osaVar.s(true);
                osa g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    osaVar.y(g.f());
                    osaVar.u(g.b());
                    osaVar.o(g.a());
                    osaVar.x(g.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", osaVar, true);
                    }
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                osaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                osaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
