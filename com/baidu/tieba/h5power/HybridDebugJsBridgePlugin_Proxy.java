package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.is9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
import com.baidu.tieba.uv4;
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
/* loaded from: classes5.dex */
public class HybridDebugJsBridgePlugin_Proxy extends is9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(uv4 uv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                ks9Var.s(true);
                ks9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    ks9Var.y(d.f());
                    ks9Var.u(d.b());
                    ks9Var.o(d.a());
                    ks9Var.x(d.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                ks9Var.s(true);
                ks9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    ks9Var.y(c.f());
                    ks9Var.u(c.b());
                    ks9Var.o(c.a());
                    ks9Var.x(c.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                ks9Var.s(true);
                ks9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    ks9Var.y(i.f());
                    ks9Var.u(i.b());
                    ks9Var.o(i.a());
                    ks9Var.x(i.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                ks9Var.s(true);
                ks9 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    ks9Var.y(g.f());
                    ks9Var.u(g.b());
                    ks9Var.o(g.a());
                    ks9Var.x(g.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                ks9Var.s(true);
                ks9 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    ks9Var.y(f.f());
                    ks9Var.u(f.b());
                    ks9Var.o(f.a());
                    ks9Var.x(f.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                ks9Var.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                ks9 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    ks9Var.y(h.f());
                    ks9Var.u(h.b());
                    ks9Var.o(h.a());
                    ks9Var.x(h.e());
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
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
