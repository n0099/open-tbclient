package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.vu4;
import com.baidu.tieba.z29;
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
public class OfflineDebugJsBridge_Proxy extends z29 {
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

    @Override // com.baidu.tieba.z29
    public b39 dispatch(WebView webView, d39 d39Var, b39 b39Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            String b = d39Var.b();
            JSONObject e = d39Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                b39Var.r(true);
                b39 d = this.mJsBridge.d(webView);
                if (d != null) {
                    b39Var.x(d.f());
                    b39Var.t(d.b());
                    b39Var.o(d.a());
                    b39Var.w(d.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                b39Var.r(true);
                b39 c = this.mJsBridge.c(webView);
                if (c != null) {
                    b39Var.x(c.f());
                    b39Var.t(c.b());
                    b39Var.o(c.a());
                    b39Var.w(c.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                b39Var.r(true);
                b39 i = this.mJsBridge.i(webView);
                if (i != null) {
                    b39Var.x(i.f());
                    b39Var.t(i.b());
                    b39Var.o(i.a());
                    b39Var.w(i.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                b39Var.r(true);
                b39 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    b39Var.x(g.f());
                    b39Var.t(g.b());
                    b39Var.o(g.a());
                    b39Var.w(g.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                b39Var.r(true);
                b39 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    b39Var.x(f.f());
                    b39Var.t(f.b());
                    b39Var.o(f.a());
                    b39Var.w(f.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                b39Var.r(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                b39 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    b39Var.x(h.f());
                    b39Var.t(h.b());
                    b39Var.o(h.a());
                    b39Var.w(h.e());
                }
                b39Var.y(0);
            }
            return b39Var;
        }
        return (b39) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
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
