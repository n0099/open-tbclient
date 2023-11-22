package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.os4;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
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
public class HybridDebugJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public os4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(os4 os4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {os4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = os4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                osaVar.s(true);
                osa d = this.mJsBridge.d(webView);
                if (d != null) {
                    osaVar.y(d.f());
                    osaVar.u(d.b());
                    osaVar.o(d.a());
                    osaVar.x(d.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                osaVar.s(true);
                osa c = this.mJsBridge.c(webView);
                if (c != null) {
                    osaVar.y(c.f());
                    osaVar.u(c.b());
                    osaVar.o(c.a());
                    osaVar.x(c.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                osaVar.s(true);
                osa i = this.mJsBridge.i(webView);
                if (i != null) {
                    osaVar.y(i.f());
                    osaVar.u(i.b());
                    osaVar.o(i.a());
                    osaVar.x(i.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                osaVar.s(true);
                osa g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    osaVar.y(g.f());
                    osaVar.u(g.b());
                    osaVar.o(g.a());
                    osaVar.x(g.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                osaVar.s(true);
                osa f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    osaVar.y(f.f());
                    osaVar.u(f.b());
                    osaVar.o(f.a());
                    osaVar.x(f.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                osaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                osa h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    osaVar.y(h.f());
                    osaVar.u(h.b());
                    osaVar.o(h.a());
                    osaVar.x(h.e());
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
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
