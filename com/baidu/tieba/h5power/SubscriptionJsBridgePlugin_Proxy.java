package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bw4;
import com.baidu.tieba.hs9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
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
/* loaded from: classes5.dex */
public class SubscriptionJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bw4 mJsBridge;

    public SubscriptionJsBridgePlugin_Proxy(bw4 bw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bw4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = bw4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("subscription/gamePush")) {
                js9Var.s(true);
                js9 c = this.mJsBridge.c(webView, e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (c != null) {
                    js9Var.y(c.f());
                    js9Var.u(c.b());
                    js9Var.o(c.a());
                    js9Var.x(c.e());
                }
                js9Var.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                js9Var.s(true);
                js9 e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    js9Var.y(e2.f());
                    js9Var.u(e2.b());
                    js9Var.o(e2.a());
                    js9Var.x(e2.e());
                }
                js9Var.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                js9Var.s(true);
                js9 f = this.mJsBridge.f(webView, e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (f != null) {
                    js9Var.y(f.f());
                    js9Var.u(f.b());
                    js9Var.o(f.a());
                    js9Var.x(f.e());
                    if (!js9Var.h()) {
                        js9Var.n(false);
                        addObserver(webView, "notifyNativeRefresh", js9Var, false);
                    }
                }
                js9Var.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                js9Var.s(true);
                js9 d = this.mJsBridge.d(webView, e.optString("viewId"), e.optString("data"));
                if (d != null) {
                    js9Var.y(d.f());
                    js9Var.u(d.b());
                    js9Var.o(d.a());
                    js9Var.x(d.e());
                }
                js9Var.z(0);
            }
            return js9Var;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
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
