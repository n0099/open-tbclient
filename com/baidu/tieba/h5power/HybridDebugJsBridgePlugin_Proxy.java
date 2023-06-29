package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.d5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.qy4;
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
/* loaded from: classes6.dex */
public class HybridDebugJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qy4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(qy4 qy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                f5aVar.s(true);
                f5a d = this.mJsBridge.d(webView);
                if (d != null) {
                    f5aVar.y(d.f());
                    f5aVar.u(d.b());
                    f5aVar.o(d.a());
                    f5aVar.x(d.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                f5aVar.s(true);
                f5a c = this.mJsBridge.c(webView);
                if (c != null) {
                    f5aVar.y(c.f());
                    f5aVar.u(c.b());
                    f5aVar.o(c.a());
                    f5aVar.x(c.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                f5aVar.s(true);
                f5a i = this.mJsBridge.i(webView);
                if (i != null) {
                    f5aVar.y(i.f());
                    f5aVar.u(i.b());
                    f5aVar.o(i.a());
                    f5aVar.x(i.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                f5aVar.s(true);
                f5a g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    f5aVar.y(g.f());
                    f5aVar.u(g.b());
                    f5aVar.o(g.a());
                    f5aVar.x(g.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                f5aVar.s(true);
                f5a f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    f5aVar.y(f.f());
                    f5aVar.u(f.b());
                    f5aVar.o(f.a());
                    f5aVar.x(f.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                f5aVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                f5a h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    f5aVar.y(h.f());
                    f5aVar.u(h.b());
                    f5aVar.o(h.a());
                    f5aVar.x(h.e());
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
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
