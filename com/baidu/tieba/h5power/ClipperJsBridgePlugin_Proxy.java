package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dj6;
import com.baidu.tieba.ls4;
import com.baidu.tieba.msa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
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
public class ClipperJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ls4 mJsBridge;

    public ClipperJsBridgePlugin_Proxy(ls4 ls4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ls4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ls4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("clipper/getClipperInformation")) {
                osaVar.s(true);
                osa c = this.mJsBridge.c(webView);
                if (c != null) {
                    osaVar.y(c.f());
                    osaVar.u(c.b());
                    osaVar.o(c.a());
                    osaVar.x(c.e());
                }
                osaVar.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                osaVar.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("txt"));
                if (d != null) {
                    osaVar.y(d.f());
                    osaVar.u(d.b());
                    osaVar.o(d.a());
                    osaVar.x(d.e());
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
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
