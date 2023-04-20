package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
import com.baidu.tieba.xt4;
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
public class DeviceJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xt4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(xt4 xt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = xt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("device/getZid")) {
                sm9Var.r(true);
                sm9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    sm9Var.x(g.f());
                    sm9Var.t(g.b());
                    sm9Var.o(g.a());
                    sm9Var.w(g.e());
                }
                sm9Var.y(0);
            } else if (b.equals("device/getHdid")) {
                sm9Var.r(true);
                sm9 e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    sm9Var.x(e2.f());
                    sm9Var.t(e2.b());
                    sm9Var.o(e2.a());
                    sm9Var.w(e2.e());
                }
                sm9Var.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                sm9Var.r(true);
                sm9 f = this.mJsBridge.f(webView);
                if (f != null) {
                    sm9Var.x(f.f());
                    sm9Var.t(f.b());
                    sm9Var.o(f.a());
                    sm9Var.w(f.e());
                }
                sm9Var.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                sm9Var.r(true);
                sm9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    sm9Var.x(d.f());
                    sm9Var.t(d.b());
                    sm9Var.o(d.a());
                    sm9Var.w(d.e());
                }
                sm9Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                sm9Var.r(true);
                sm9 h = this.mJsBridge.h(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (h != null) {
                    sm9Var.x(h.f());
                    sm9Var.t(h.b());
                    sm9Var.o(h.a());
                    sm9Var.w(h.e());
                }
                sm9Var.y(0);
            }
            return sm9Var;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
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
