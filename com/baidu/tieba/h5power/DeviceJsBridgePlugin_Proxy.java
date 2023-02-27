package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
import com.baidu.tieba.nv4;
import com.baidu.tieba.p69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DeviceJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nv4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(nv4 nv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = nv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("device/getZid")) {
                n69Var.r(true);
                n69 g = this.mJsBridge.g(webView);
                if (g != null) {
                    n69Var.x(g.f());
                    n69Var.t(g.b());
                    n69Var.o(g.a());
                    n69Var.w(g.e());
                }
                n69Var.y(0);
            } else if (b.equals("device/getHdid")) {
                n69Var.r(true);
                n69 e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    n69Var.x(e2.f());
                    n69Var.t(e2.b());
                    n69Var.o(e2.a());
                    n69Var.w(e2.e());
                }
                n69Var.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                n69Var.r(true);
                n69 f = this.mJsBridge.f(webView);
                if (f != null) {
                    n69Var.x(f.f());
                    n69Var.t(f.b());
                    n69Var.o(f.a());
                    n69Var.w(f.e());
                }
                n69Var.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                n69Var.r(true);
                n69 d = this.mJsBridge.d(webView);
                if (d != null) {
                    n69Var.x(d.f());
                    n69Var.t(d.b());
                    n69Var.o(d.a());
                    n69Var.w(d.e());
                }
                n69Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                n69Var.r(true);
                n69 h = this.mJsBridge.h(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (h != null) {
                    n69Var.x(h.f());
                    n69Var.t(h.b());
                    n69Var.o(h.a());
                    n69Var.w(h.e());
                }
                n69Var.y(0);
            }
            return n69Var;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
