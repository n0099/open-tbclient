package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.qda;
import com.baidu.tieba.qy4;
import com.baidu.tieba.sda;
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
public class SubscriptionJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qy4 mJsBridge;

    public SubscriptionJsBridgePlugin_Proxy(qy4 qy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("subscription/gamePush")) {
                qdaVar.s(true);
                qda c = this.mJsBridge.c(webView, e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (c != null) {
                    qdaVar.y(c.f());
                    qdaVar.u(c.b());
                    qdaVar.o(c.a());
                    qdaVar.x(c.e());
                }
                qdaVar.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                qdaVar.s(true);
                qda e2 = this.mJsBridge.e(webView);
                if (e2 != null) {
                    qdaVar.y(e2.f());
                    qdaVar.u(e2.b());
                    qdaVar.o(e2.a());
                    qdaVar.x(e2.e());
                }
                qdaVar.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                qdaVar.s(true);
                qda f = this.mJsBridge.f(webView, e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (f != null) {
                    qdaVar.y(f.f());
                    qdaVar.u(f.b());
                    qdaVar.o(f.a());
                    qdaVar.x(f.e());
                }
                qdaVar.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                qdaVar.s(true);
                qda d = this.mJsBridge.d(webView, e.optString("viewId"), e.optString("data"));
                if (d != null) {
                    qdaVar.y(d.f());
                    qdaVar.u(d.b());
                    qdaVar.o(d.a());
                    qdaVar.x(d.e());
                }
                qdaVar.z(0);
            }
            return qdaVar;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
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
