package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.my4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class HybridDebugJsBridgePlugin_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(my4 my4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {my4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = my4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                bz9Var.s(true);
                bz9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    bz9Var.y(d.f());
                    bz9Var.u(d.b());
                    bz9Var.o(d.a());
                    bz9Var.x(d.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                bz9Var.s(true);
                bz9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    bz9Var.y(c.f());
                    bz9Var.u(c.b());
                    bz9Var.o(c.a());
                    bz9Var.x(c.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                bz9Var.s(true);
                bz9 i = this.mJsBridge.i(webView);
                if (i != null) {
                    bz9Var.y(i.f());
                    bz9Var.u(i.b());
                    bz9Var.o(i.a());
                    bz9Var.x(i.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                bz9Var.s(true);
                bz9 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    bz9Var.y(g.f());
                    bz9Var.u(g.b());
                    bz9Var.o(g.a());
                    bz9Var.x(g.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                bz9Var.s(true);
                bz9 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    bz9Var.y(f.f());
                    bz9Var.u(f.b());
                    bz9Var.o(f.a());
                    bz9Var.x(f.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                bz9Var.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                bz9 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    bz9Var.y(h.f());
                    bz9Var.u(h.b());
                    bz9Var.o(h.a());
                    bz9Var.x(h.e());
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
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
