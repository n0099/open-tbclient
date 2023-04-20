package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cu4;
import com.baidu.tieba.qm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class OfflineJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu4 mJsBridge;

    public OfflineJsBridgePlugin_Proxy(cu4 cu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = cu4Var;
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
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sm9Var.r(true);
                sm9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    sm9Var.x(d.f());
                    sm9Var.t(d.b());
                    sm9Var.o(d.a());
                    sm9Var.w(d.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sm9Var.r(true);
                sm9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    sm9Var.x(c.f());
                    sm9Var.t(c.b());
                    sm9Var.o(c.a());
                    sm9Var.w(c.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sm9Var.r(true);
                sm9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    sm9Var.x(i.f());
                    sm9Var.t(i.b());
                    sm9Var.o(i.a());
                    sm9Var.w(i.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sm9Var.r(true);
                sm9 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    sm9Var.x(g.f());
                    sm9Var.t(g.b());
                    sm9Var.o(g.a());
                    sm9Var.w(g.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sm9Var.r(true);
                sm9 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    sm9Var.x(f.f());
                    sm9Var.t(f.b());
                    sm9Var.o(f.a());
                    sm9Var.w(f.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sm9Var.r(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                sm9 h = this.mJsBridge.h(webView, arrayList);
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
