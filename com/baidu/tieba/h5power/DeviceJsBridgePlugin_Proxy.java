package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.wt4;
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
public class DeviceJsBridgePlugin_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(wt4 wt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = wt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var = new km9();
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("device/getZid")) {
                km9Var.r(true);
                km9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    km9Var.x(g.f());
                    km9Var.t(g.b());
                    km9Var.o(g.a());
                    km9Var.w(g.e());
                }
                km9Var.y(0);
            } else if (b.equals("device/getHdid")) {
                km9Var.r(true);
                km9 e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    km9Var.x(e2.f());
                    km9Var.t(e2.b());
                    km9Var.o(e2.a());
                    km9Var.w(e2.e());
                }
                km9Var.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                km9Var.r(true);
                km9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    km9Var.x(f.f());
                    km9Var.t(f.b());
                    km9Var.o(f.a());
                    km9Var.w(f.e());
                }
                km9Var.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                km9Var.r(true);
                km9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    km9Var.x(d.f());
                    km9Var.t(d.b());
                    km9Var.o(d.a());
                    km9Var.w(d.e());
                }
                km9Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                km9Var.r(true);
                km9 h = this.mJsBridge.h(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (h != null) {
                    km9Var.x(h.f());
                    km9Var.t(h.b());
                    km9Var.o(h.a());
                    km9Var.w(h.e());
                }
                km9Var.y(0);
            }
            return km9Var;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
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
