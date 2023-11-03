package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.os4;
import com.baidu.tieba.psa;
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
public class HybridDebugJsBridgePlugin_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                nsaVar.s(true);
                nsa d = this.mJsBridge.d(webView);
                if (d != null) {
                    nsaVar.y(d.f());
                    nsaVar.u(d.b());
                    nsaVar.o(d.a());
                    nsaVar.x(d.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                nsaVar.s(true);
                nsa c = this.mJsBridge.c(webView);
                if (c != null) {
                    nsaVar.y(c.f());
                    nsaVar.u(c.b());
                    nsaVar.o(c.a());
                    nsaVar.x(c.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                nsaVar.s(true);
                nsa i = this.mJsBridge.i(webView);
                if (i != null) {
                    nsaVar.y(i.f());
                    nsaVar.u(i.b());
                    nsaVar.o(i.a());
                    nsaVar.x(i.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                nsaVar.s(true);
                nsa g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    nsaVar.y(g.f());
                    nsaVar.u(g.b());
                    nsaVar.o(g.a());
                    nsaVar.x(g.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                nsaVar.s(true);
                nsa f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    nsaVar.y(f.f());
                    nsaVar.u(f.b());
                    nsaVar.o(f.a());
                    nsaVar.x(f.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                nsaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                nsa h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    nsaVar.y(h.f());
                    nsaVar.u(h.b());
                    nsaVar.o(h.a());
                    nsaVar.x(h.e());
                }
                nsaVar.z(0);
            }
            return nsaVar;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
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
