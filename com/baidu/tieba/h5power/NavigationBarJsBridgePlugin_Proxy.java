package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.ty4;
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
/* loaded from: classes6.dex */
public class NavigationBarJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ty4 mJsBridge;

    public NavigationBarJsBridgePlugin_Proxy(ty4 ty4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ty4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ty4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            h5aVar.e();
            if (b.equals("navigationBar/isDisableGoBack")) {
                f5aVar.s(true);
                f5a c = this.mJsBridge.c(webView);
                if (c != null) {
                    f5aVar.y(c.f());
                    f5aVar.u(c.b());
                    f5aVar.o(c.a());
                    f5aVar.x(c.e());
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
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
