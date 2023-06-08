package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ky4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class DeviceJsBridgePlugin_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("device/getZid")) {
                bz9Var.s(true);
                bz9 k = this.mJsBridge.k(webView);
                if (k != null) {
                    bz9Var.y(k.f());
                    bz9Var.u(k.b());
                    bz9Var.o(k.a());
                    bz9Var.x(k.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/getHdid")) {
                bz9Var.s(true);
                bz9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    bz9Var.y(i.f());
                    bz9Var.u(i.b());
                    bz9Var.o(i.a());
                    bz9Var.x(i.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                bz9Var.s(true);
                bz9 j = this.mJsBridge.j(webView);
                if (j != null) {
                    bz9Var.y(j.f());
                    bz9Var.u(j.b());
                    bz9Var.o(j.a());
                    bz9Var.x(j.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                bz9Var.s(true);
                bz9 h = this.mJsBridge.h(webView);
                if (h != null) {
                    bz9Var.y(h.f());
                    bz9Var.u(h.b());
                    bz9Var.o(h.a());
                    bz9Var.x(h.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                bz9Var.s(true);
                bz9 m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    bz9Var.y(m.f());
                    bz9Var.u(m.b());
                    bz9Var.o(m.a());
                    bz9Var.x(m.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/deviceMotion")) {
                bz9Var.s(true);
                bz9 d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    bz9Var.y(d.f());
                    bz9Var.u(d.b());
                    bz9Var.o(d.a());
                    bz9Var.x(d.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "deviceMotion", bz9Var, true);
                    }
                }
                bz9Var.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                bz9Var.s(true);
                bz9 g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    bz9Var.y(g.f());
                    bz9Var.u(g.b());
                    bz9Var.o(g.a());
                    bz9Var.x(g.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "deviceRefreshRate", bz9Var, true);
                    }
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("deviceMotion")) {
                bz9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                bz9Var = this.mJsBridge.f(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
