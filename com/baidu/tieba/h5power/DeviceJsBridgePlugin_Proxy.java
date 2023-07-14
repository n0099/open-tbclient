package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hy4;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
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
public class DeviceJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hy4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(hy4 hy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = hy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("device/getZid")) {
                qdaVar.s(true);
                qda k = this.mJsBridge.k(webView);
                if (k != null) {
                    qdaVar.y(k.f());
                    qdaVar.u(k.b());
                    qdaVar.o(k.a());
                    qdaVar.x(k.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                qdaVar.s(true);
                qda i = this.mJsBridge.i(webView);
                if (i != null) {
                    qdaVar.y(i.f());
                    qdaVar.u(i.b());
                    qdaVar.o(i.a());
                    qdaVar.x(i.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                qdaVar.s(true);
                qda j = this.mJsBridge.j(webView);
                if (j != null) {
                    qdaVar.y(j.f());
                    qdaVar.u(j.b());
                    qdaVar.o(j.a());
                    qdaVar.x(j.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                qdaVar.s(true);
                qda h = this.mJsBridge.h(webView);
                if (h != null) {
                    qdaVar.y(h.f());
                    qdaVar.u(h.b());
                    qdaVar.o(h.a());
                    qdaVar.x(h.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                qdaVar.s(true);
                qda m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    qdaVar.y(m.f());
                    qdaVar.u(m.b());
                    qdaVar.o(m.a());
                    qdaVar.x(m.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                qdaVar.s(true);
                qda d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    qdaVar.y(d.f());
                    qdaVar.u(d.b());
                    qdaVar.o(d.a());
                    qdaVar.x(d.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "deviceMotion", qdaVar, true);
                    }
                }
                qdaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                qdaVar.s(true);
                qda g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    qdaVar.y(g.f());
                    qdaVar.u(g.b());
                    qdaVar.o(g.a());
                    qdaVar.x(g.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", qdaVar, true);
                    }
                }
                qdaVar.z(0);
            }
            return qdaVar;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                qdaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                qdaVar = this.mJsBridge.f(webView, hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!TextUtils.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
