package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hca;
import com.baidu.tieba.jca;
import com.baidu.tieba.kx4;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
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
public class HybridDebugJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kx4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(kx4 kx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = kx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar = new jca();
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                jcaVar.s(true);
                jca d = this.mJsBridge.d(webView);
                if (d != null) {
                    jcaVar.y(d.f());
                    jcaVar.u(d.b());
                    jcaVar.o(d.a());
                    jcaVar.x(d.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                jcaVar.s(true);
                jca c = this.mJsBridge.c(webView);
                if (c != null) {
                    jcaVar.y(c.f());
                    jcaVar.u(c.b());
                    jcaVar.o(c.a());
                    jcaVar.x(c.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                jcaVar.s(true);
                jca i = this.mJsBridge.i(webView);
                if (i != null) {
                    jcaVar.y(i.f());
                    jcaVar.u(i.b());
                    jcaVar.o(i.a());
                    jcaVar.x(i.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                jcaVar.s(true);
                jca g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    jcaVar.y(g.f());
                    jcaVar.u(g.b());
                    jcaVar.o(g.a());
                    jcaVar.x(g.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                jcaVar.s(true);
                jca f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    jcaVar.y(f.f());
                    jcaVar.u(f.b());
                    jcaVar.o(f.a());
                    jcaVar.x(f.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                jcaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                jca h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    jcaVar.y(h.f());
                    jcaVar.u(h.b());
                    jcaVar.o(h.a());
                    jcaVar.x(h.e());
                }
                jcaVar.z(0);
            }
            return jcaVar;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
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
