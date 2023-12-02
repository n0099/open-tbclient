package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.dxa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.qj6;
import com.baidu.tieba.ss4;
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
public class HybridDebugJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ss4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(ss4 ss4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ss4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ss4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                fxaVar.s(true);
                fxa d = this.mJsBridge.d(webView);
                if (d != null) {
                    fxaVar.y(d.f());
                    fxaVar.u(d.b());
                    fxaVar.o(d.a());
                    fxaVar.x(d.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                fxaVar.s(true);
                fxa c = this.mJsBridge.c(webView);
                if (c != null) {
                    fxaVar.y(c.f());
                    fxaVar.u(c.b());
                    fxaVar.o(c.a());
                    fxaVar.x(c.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                fxaVar.s(true);
                fxa i = this.mJsBridge.i(webView);
                if (i != null) {
                    fxaVar.y(i.f());
                    fxaVar.u(i.b());
                    fxaVar.o(i.a());
                    fxaVar.x(i.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                fxaVar.s(true);
                fxa g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    fxaVar.y(g.f());
                    fxaVar.u(g.b());
                    fxaVar.o(g.a());
                    fxaVar.x(g.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                fxaVar.s(true);
                fxa f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    fxaVar.y(f.f());
                    fxaVar.u(f.b());
                    fxaVar.o(f.a());
                    fxaVar.x(f.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                fxaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                fxa h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    fxaVar.y(h.f());
                    fxaVar.u(h.b());
                    fxaVar.o(h.a());
                    fxaVar.x(h.e());
                }
                fxaVar.z(0);
            }
            return fxaVar;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
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
