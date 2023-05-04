package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.iu4;
import com.baidu.tieba.jq9;
import com.baidu.tieba.xf6;
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
public class ClipperJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iu4 mJsBridge;

    public ClipperJsBridgePlugin_Proxy(iu4 iu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = iu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("clipper/getClipperInformation")) {
                hq9Var.s(true);
                hq9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    hq9Var.y(c.f());
                    hq9Var.u(c.b());
                    hq9Var.o(c.a());
                    hq9Var.x(c.e());
                }
                hq9Var.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                hq9Var.s(true);
                hq9 d = this.mJsBridge.d(webView, e.optString("txt"));
                if (d != null) {
                    hq9Var.y(d.f());
                    hq9Var.u(d.b());
                    hq9Var.o(d.a());
                    hq9Var.x(d.e());
                }
                hq9Var.z(0);
            }
            return hq9Var;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
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
