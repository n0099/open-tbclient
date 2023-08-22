package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.mx4;
import com.baidu.tieba.qga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
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
public class HybridDebugJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mx4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = mx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sgaVar.s(true);
                sga d = this.mJsBridge.d(webView);
                if (d != null) {
                    sgaVar.y(d.f());
                    sgaVar.u(d.b());
                    sgaVar.o(d.a());
                    sgaVar.x(d.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sgaVar.s(true);
                sga c = this.mJsBridge.c(webView);
                if (c != null) {
                    sgaVar.y(c.f());
                    sgaVar.u(c.b());
                    sgaVar.o(c.a());
                    sgaVar.x(c.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sgaVar.s(true);
                sga i = this.mJsBridge.i(webView);
                if (i != null) {
                    sgaVar.y(i.f());
                    sgaVar.u(i.b());
                    sgaVar.o(i.a());
                    sgaVar.x(i.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sgaVar.s(true);
                sga g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    sgaVar.y(g.f());
                    sgaVar.u(g.b());
                    sgaVar.o(g.a());
                    sgaVar.x(g.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sgaVar.s(true);
                sga f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    sgaVar.y(f.f());
                    sgaVar.u(f.b());
                    sgaVar.o(f.a());
                    sgaVar.x(f.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sgaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                sga h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    sgaVar.y(h.f());
                    sgaVar.u(h.b());
                    sgaVar.o(h.a());
                    sgaVar.x(h.e());
                }
                sgaVar.z(0);
            }
            return sgaVar;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
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
