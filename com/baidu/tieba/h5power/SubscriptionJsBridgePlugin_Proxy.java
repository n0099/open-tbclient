package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hca;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
import com.baidu.tieba.rx4;
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
public class SubscriptionJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rx4 mJsBridge;

    public SubscriptionJsBridgePlugin_Proxy(rx4 rx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = rx4Var;
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
            if (b.equals("subscription/gamePush")) {
                jcaVar.s(true);
                jca c = this.mJsBridge.c(webView, e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (c != null) {
                    jcaVar.y(c.f());
                    jcaVar.u(c.b());
                    jcaVar.o(c.a());
                    jcaVar.x(c.e());
                }
                jcaVar.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                jcaVar.s(true);
                jca e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    jcaVar.y(e2.f());
                    jcaVar.u(e2.b());
                    jcaVar.o(e2.a());
                    jcaVar.x(e2.e());
                }
                jcaVar.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                jcaVar.s(true);
                jca f = this.mJsBridge.f(webView, e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (f != null) {
                    jcaVar.y(f.f());
                    jcaVar.u(f.b());
                    jcaVar.o(f.a());
                    jcaVar.x(f.e());
                }
                jcaVar.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                jcaVar.s(true);
                jca d = this.mJsBridge.d(webView, e.optString("viewId"), e.optString("data"));
                if (d != null) {
                    jcaVar.y(d.f());
                    jcaVar.u(d.b());
                    jcaVar.o(d.a());
                    jcaVar.x(d.e());
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
