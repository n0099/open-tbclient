package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ica;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
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
public class SubscriptionJsBridgePlugin_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar = new kca();
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("subscription/gamePush")) {
                kcaVar.s(true);
                kca c = this.mJsBridge.c(webView, e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (c != null) {
                    kcaVar.y(c.f());
                    kcaVar.u(c.b());
                    kcaVar.o(c.a());
                    kcaVar.x(c.e());
                }
                kcaVar.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                kcaVar.s(true);
                kca e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    kcaVar.y(e2.f());
                    kcaVar.u(e2.b());
                    kcaVar.o(e2.a());
                    kcaVar.x(e2.e());
                }
                kcaVar.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                kcaVar.s(true);
                kca f = this.mJsBridge.f(webView, e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (f != null) {
                    kcaVar.y(f.f());
                    kcaVar.u(f.b());
                    kcaVar.o(f.a());
                    kcaVar.x(f.e());
                }
                kcaVar.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                kcaVar.s(true);
                kca d = this.mJsBridge.d(webView, e.optString("viewId"), e.optString("data"));
                if (d != null) {
                    kcaVar.y(d.f());
                    kcaVar.u(d.b());
                    kcaVar.o(d.a());
                    kcaVar.x(d.e());
                }
                kcaVar.z(0);
            }
            return kcaVar;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
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
