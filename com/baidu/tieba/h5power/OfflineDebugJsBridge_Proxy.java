package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.v19;
import com.baidu.tieba.vu4;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
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
public class OfflineDebugJsBridge_Proxy extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vu4 mJsBridge;

    public OfflineDebugJsBridge_Proxy(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.v19
    public x19 dispatch(WebView webView, z19 z19Var, x19 x19Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                x19Var.r(true);
                x19 d = this.mJsBridge.d(webView);
                if (d != null) {
                    x19Var.x(d.f());
                    x19Var.t(d.b());
                    x19Var.o(d.a());
                    x19Var.w(d.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                x19Var.r(true);
                x19 c = this.mJsBridge.c(webView);
                if (c != null) {
                    x19Var.x(c.f());
                    x19Var.t(c.b());
                    x19Var.o(c.a());
                    x19Var.w(c.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                x19Var.r(true);
                x19 i = this.mJsBridge.i(webView);
                if (i != null) {
                    x19Var.x(i.f());
                    x19Var.t(i.b());
                    x19Var.o(i.a());
                    x19Var.w(i.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                x19Var.r(true);
                x19 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    x19Var.x(g.f());
                    x19Var.t(g.b());
                    x19Var.o(g.a());
                    x19Var.w(g.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                x19Var.r(true);
                x19 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    x19Var.x(f.f());
                    x19Var.t(f.b());
                    x19Var.o(f.a());
                    x19Var.w(f.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                x19Var.r(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                x19 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    x19Var.x(h.f());
                    x19Var.t(h.b());
                    x19Var.o(h.a());
                    x19Var.w(h.e());
                }
                x19Var.y(0);
            }
            return x19Var;
        }
        return (x19) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
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
