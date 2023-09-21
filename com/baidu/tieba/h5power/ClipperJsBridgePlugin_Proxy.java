package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mx4;
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
public class ClipperJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mx4 mJsBridge;

    public ClipperJsBridgePlugin_Proxy(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = mx4Var;
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
            if (b.equals("clipper/getClipperInformation")) {
                skaVar.s(true);
                ska c = this.mJsBridge.c(webView);
                if (c != null) {
                    skaVar.y(c.f());
                    skaVar.u(c.b());
                    skaVar.o(c.a());
                    skaVar.x(c.e());
                }
                skaVar.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                skaVar.s(true);
                ska d = this.mJsBridge.d(webView, e.optString("txt"));
                if (d != null) {
                    skaVar.y(d.f());
                    skaVar.u(d.b());
                    skaVar.o(d.a());
                    skaVar.x(d.e());
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
