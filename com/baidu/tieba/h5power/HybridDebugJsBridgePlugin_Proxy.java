package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.exa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.mj6;
import com.baidu.tieba.ps4;
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
public class HybridDebugJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ps4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(ps4 ps4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ps4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ps4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                gxaVar.s(true);
                gxa d = this.mJsBridge.d(webView);
                if (d != null) {
                    gxaVar.y(d.f());
                    gxaVar.u(d.b());
                    gxaVar.o(d.a());
                    gxaVar.x(d.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                gxaVar.s(true);
                gxa c = this.mJsBridge.c(webView);
                if (c != null) {
                    gxaVar.y(c.f());
                    gxaVar.u(c.b());
                    gxaVar.o(c.a());
                    gxaVar.x(c.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                gxaVar.s(true);
                gxa i = this.mJsBridge.i(webView);
                if (i != null) {
                    gxaVar.y(i.f());
                    gxaVar.u(i.b());
                    gxaVar.o(i.a());
                    gxaVar.x(i.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                gxaVar.s(true);
                gxa g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    gxaVar.y(g.f());
                    gxaVar.u(g.b());
                    gxaVar.o(g.a());
                    gxaVar.x(g.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                gxaVar.s(true);
                gxa f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    gxaVar.y(f.f());
                    gxaVar.u(f.b());
                    gxaVar.o(f.a());
                    gxaVar.x(f.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                gxaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                gxa h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    gxaVar.y(h.f());
                    gxaVar.u(h.b());
                    gxaVar.o(h.a());
                    gxaVar.x(h.e());
                }
                gxaVar.z(0);
            }
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
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
