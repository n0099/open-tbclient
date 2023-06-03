package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ky4;
import com.baidu.tieba.sl6;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class DeviceJsBridgePlugin_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ky4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ky4 ky4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ky4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ky4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
    }

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("device/getZid")) {
                wy9Var.s(true);
                wy9 k = this.mJsBridge.k(webView);
                if (k != null) {
                    wy9Var.y(k.f());
                    wy9Var.u(k.b());
                    wy9Var.o(k.a());
                    wy9Var.x(k.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/getHdid")) {
                wy9Var.s(true);
                wy9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    wy9Var.y(i.f());
                    wy9Var.u(i.b());
                    wy9Var.o(i.a());
                    wy9Var.x(i.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                wy9Var.s(true);
                wy9 j = this.mJsBridge.j(webView);
                if (j != null) {
                    wy9Var.y(j.f());
                    wy9Var.u(j.b());
                    wy9Var.o(j.a());
                    wy9Var.x(j.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                wy9Var.s(true);
                wy9 h = this.mJsBridge.h(webView);
                if (h != null) {
                    wy9Var.y(h.f());
                    wy9Var.u(h.b());
                    wy9Var.o(h.a());
                    wy9Var.x(h.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                wy9Var.s(true);
                wy9 m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    wy9Var.y(m.f());
                    wy9Var.u(m.b());
                    wy9Var.o(m.a());
                    wy9Var.x(m.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/deviceMotion")) {
                wy9Var.s(true);
                wy9 d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    wy9Var.y(d.f());
                    wy9Var.u(d.b());
                    wy9Var.o(d.a());
                    wy9Var.x(d.e());
                    if (!wy9Var.h()) {
                        wy9Var.n(false);
                        addObserver(webView, "deviceMotion", wy9Var, true);
                    }
                }
                wy9Var.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                wy9Var.s(true);
                wy9 g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    wy9Var.y(g.f());
                    wy9Var.u(g.b());
                    wy9Var.o(g.a());
                    wy9Var.x(g.e());
                    if (!wy9Var.h()) {
                        wy9Var.n(false);
                        addObserver(webView, "deviceRefreshRate", wy9Var, true);
                    }
                }
                wy9Var.z(0);
            }
            return wy9Var;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (sl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            wy9 wy9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                wy9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                wy9Var = this.mJsBridge.f(webView, hashMap);
            }
            if (wy9Var != null) {
                wy9Var.z(0);
            }
            List<vy9> list = this.mAsyncCallBackMethodList.get(str);
            if (wy9Var != null && list != null) {
                Iterator<vy9> it = list.iterator();
                if (!TextUtils.isEmpty(wy9Var.e())) {
                    while (it.hasNext()) {
                        vy9 next = it.next();
                        if (next.b().equals(wy9Var.e())) {
                            wy9 wy9Var2 = new wy9();
                            wy9Var2.w(next.a());
                            wy9Var2.y(wy9Var.f());
                            wy9Var2.u(wy9Var.b());
                            wy9Var2.o(wy9Var.a());
                            wy9Var2.A(wy9Var.l());
                            arrayList.add(wy9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        vy9 next2 = it.next();
                        wy9 wy9Var3 = new wy9();
                        wy9Var3.w(next2.a());
                        wy9Var3.y(wy9Var.f());
                        wy9Var3.u(wy9Var.b());
                        wy9Var3.o(wy9Var.a());
                        wy9Var3.A(wy9Var.l());
                        arrayList.add(wy9Var3);
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
