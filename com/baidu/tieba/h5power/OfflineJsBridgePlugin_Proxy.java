package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.rc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
import com.baidu.tieba.zt4;
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
public class OfflineJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zt4 mJsBridge;

    public OfflineJsBridgePlugin_Proxy(zt4 zt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zt4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zt4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                tc9Var.r(true);
                tc9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    tc9Var.x(d.f());
                    tc9Var.t(d.b());
                    tc9Var.o(d.a());
                    tc9Var.w(d.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                tc9Var.r(true);
                tc9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    tc9Var.x(c.f());
                    tc9Var.t(c.b());
                    tc9Var.o(c.a());
                    tc9Var.w(c.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                tc9Var.r(true);
                tc9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    tc9Var.x(i.f());
                    tc9Var.t(i.b());
                    tc9Var.o(i.a());
                    tc9Var.w(i.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                tc9Var.r(true);
                tc9 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    tc9Var.x(g.f());
                    tc9Var.t(g.b());
                    tc9Var.o(g.a());
                    tc9Var.w(g.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                tc9Var.r(true);
                tc9 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    tc9Var.x(f.f());
                    tc9Var.t(f.b());
                    tc9Var.o(f.a());
                    tc9Var.w(f.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                tc9Var.r(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                tc9 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    tc9Var.x(h.f());
                    tc9Var.t(h.b());
                    tc9Var.o(h.a());
                    tc9Var.w(h.e());
                }
                tc9Var.y(0);
            }
            return tc9Var;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
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
