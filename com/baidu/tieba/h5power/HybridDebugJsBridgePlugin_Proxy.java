package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.px4;
import com.baidu.tieba.qka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
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
public class HybridDebugJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(px4 px4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {px4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = px4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                skaVar.s(true);
                ska d = this.mJsBridge.d(webView);
                if (d != null) {
                    skaVar.y(d.f());
                    skaVar.u(d.b());
                    skaVar.o(d.a());
                    skaVar.x(d.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                skaVar.s(true);
                ska c = this.mJsBridge.c(webView);
                if (c != null) {
                    skaVar.y(c.f());
                    skaVar.u(c.b());
                    skaVar.o(c.a());
                    skaVar.x(c.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                skaVar.s(true);
                ska i = this.mJsBridge.i(webView);
                if (i != null) {
                    skaVar.y(i.f());
                    skaVar.u(i.b());
                    skaVar.o(i.a());
                    skaVar.x(i.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                skaVar.s(true);
                ska g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    skaVar.y(g.f());
                    skaVar.u(g.b());
                    skaVar.o(g.a());
                    skaVar.x(g.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                skaVar.s(true);
                ska f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    skaVar.y(f.f());
                    skaVar.u(f.b());
                    skaVar.o(f.a());
                    skaVar.x(f.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                skaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                ska h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    skaVar.y(h.f());
                    skaVar.u(h.b());
                    skaVar.o(h.a());
                    skaVar.x(h.e());
                }
                skaVar.z(0);
            }
            return skaVar;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
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
