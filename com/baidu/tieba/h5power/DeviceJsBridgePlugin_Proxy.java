package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nx4;
import com.baidu.tieba.qka;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
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
public class DeviceJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nx4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = nx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("device/getZid")) {
                skaVar.s(true);
                ska k = this.mJsBridge.k(webView);
                if (k != null) {
                    skaVar.y(k.f());
                    skaVar.u(k.b());
                    skaVar.o(k.a());
                    skaVar.x(k.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                skaVar.s(true);
                ska i = this.mJsBridge.i(webView);
                if (i != null) {
                    skaVar.y(i.f());
                    skaVar.u(i.b());
                    skaVar.o(i.a());
                    skaVar.x(i.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                skaVar.s(true);
                ska j = this.mJsBridge.j(webView);
                if (j != null) {
                    skaVar.y(j.f());
                    skaVar.u(j.b());
                    skaVar.o(j.a());
                    skaVar.x(j.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                skaVar.s(true);
                ska h = this.mJsBridge.h(webView);
                if (h != null) {
                    skaVar.y(h.f());
                    skaVar.u(h.b());
                    skaVar.o(h.a());
                    skaVar.x(h.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                skaVar.s(true);
                ska m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    skaVar.y(m.f());
                    skaVar.u(m.b());
                    skaVar.o(m.a());
                    skaVar.x(m.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                skaVar.s(true);
                ska d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    skaVar.y(d.f());
                    skaVar.u(d.b());
                    skaVar.o(d.a());
                    skaVar.x(d.e());
                    if (!skaVar.h()) {
                        skaVar.n(false);
                        addObserver(webView, "deviceMotion", skaVar, true);
                    }
                }
                skaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                skaVar.s(true);
                ska g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    skaVar.y(g.f());
                    skaVar.u(g.b());
                    skaVar.o(g.a());
                    skaVar.x(g.e());
                    if (!skaVar.h()) {
                        skaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", skaVar, true);
                    }
                }
                skaVar.z(0);
            }
            return skaVar;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                skaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                skaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
