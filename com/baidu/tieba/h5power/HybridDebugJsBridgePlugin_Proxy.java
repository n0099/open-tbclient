package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ny4;
import com.baidu.tieba.r0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
public class HybridDebugJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ny4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ny4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ny4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                t0aVar.s(true);
                t0a d = this.mJsBridge.d(webView);
                if (d != null) {
                    t0aVar.y(d.f());
                    t0aVar.u(d.b());
                    t0aVar.o(d.a());
                    t0aVar.x(d.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                t0aVar.s(true);
                t0a c = this.mJsBridge.c(webView);
                if (c != null) {
                    t0aVar.y(c.f());
                    t0aVar.u(c.b());
                    t0aVar.o(c.a());
                    t0aVar.x(c.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                t0aVar.s(true);
                t0a i = this.mJsBridge.i(webView);
                if (i != null) {
                    t0aVar.y(i.f());
                    t0aVar.u(i.b());
                    t0aVar.o(i.a());
                    t0aVar.x(i.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                t0aVar.s(true);
                t0a g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    t0aVar.y(g.f());
                    t0aVar.u(g.b());
                    t0aVar.o(g.a());
                    t0aVar.x(g.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                t0aVar.s(true);
                t0a f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    t0aVar.y(f.f());
                    t0aVar.u(f.b());
                    t0aVar.o(f.a());
                    t0aVar.x(f.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                t0aVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                t0a h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    t0aVar.y(h.f());
                    t0aVar.u(h.b());
                    t0aVar.o(h.a());
                    t0aVar.x(h.e());
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
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
