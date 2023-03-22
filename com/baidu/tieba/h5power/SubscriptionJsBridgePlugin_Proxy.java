package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.du4;
import com.baidu.tieba.rc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
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
/* loaded from: classes4.dex */
public class SubscriptionJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public du4 mJsBridge;

    public SubscriptionJsBridgePlugin_Proxy(du4 du4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {du4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = du4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("subscription/gamePush")) {
                tc9Var.r(true);
                tc9 c = this.mJsBridge.c(webView, e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (c != null) {
                    tc9Var.x(c.f());
                    tc9Var.t(c.b());
                    tc9Var.o(c.a());
                    tc9Var.w(c.e());
                }
                tc9Var.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                tc9Var.r(true);
                tc9 d = this.mJsBridge.d(webView);
                if (d != null) {
                    tc9Var.x(d.f());
                    tc9Var.t(d.b());
                    tc9Var.o(d.a());
                    tc9Var.w(d.e());
                }
                tc9Var.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                tc9Var.r(true);
                tc9 e2 = this.mJsBridge.e(webView, e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (e2 != null) {
                    tc9Var.x(e2.f());
                    tc9Var.t(e2.b());
                    tc9Var.o(e2.a());
                    tc9Var.w(e2.e());
                    if (!tc9Var.h()) {
                        tc9Var.n(false);
                        addObserver(webView, "notifyNativeRefresh", tc9Var, false);
                    }
                }
                tc9Var.y(0);
            }
            return tc9Var;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
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
