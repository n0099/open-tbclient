package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cj6;
import com.baidu.tieba.ls4;
import com.baidu.tieba.lsa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
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
public class ClipperJsBridgePlugin_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("clipper/getClipperInformation")) {
                nsaVar.s(true);
                nsa c = this.mJsBridge.c(webView);
                if (c != null) {
                    nsaVar.y(c.f());
                    nsaVar.u(c.b());
                    nsaVar.o(c.a());
                    nsaVar.x(c.e());
                }
                nsaVar.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                nsaVar.s(true);
                nsa d = this.mJsBridge.d(webView, e.optString("txt"));
                if (d != null) {
                    nsaVar.y(d.f());
                    nsaVar.u(d.b());
                    nsaVar.o(d.a());
                    nsaVar.x(d.e());
                }
                nsaVar.z(0);
            }
            return nsaVar;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
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
