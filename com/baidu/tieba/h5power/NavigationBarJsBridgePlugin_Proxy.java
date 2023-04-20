package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bu4;
import com.baidu.tieba.qm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
/* loaded from: classes4.dex */
public class NavigationBarJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bu4 mJsBridge;

    public NavigationBarJsBridgePlugin_Proxy(bu4 bu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = bu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            String b = um9Var.b();
            um9Var.e();
            if (b.equals("navigationBar/isDisableGoBack")) {
                sm9Var.r(true);
                sm9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    sm9Var.x(c.f());
                    sm9Var.t(c.b());
                    sm9Var.o(c.a());
                    sm9Var.w(c.e());
                }
                sm9Var.y(0);
            }
            return sm9Var;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
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
