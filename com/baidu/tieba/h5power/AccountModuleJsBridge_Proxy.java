package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.tu4;
import com.baidu.tieba.v19;
import com.baidu.tieba.w19;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AccountModuleJsBridge_Proxy extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tu4 mJsBridge;

    public AccountModuleJsBridge_Proxy(tu4 tu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = tu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
    }

    @Override // com.baidu.tieba.v19
    public x19 dispatch(WebView webView, z19 z19Var, x19 x19Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("account/startLoginModule")) {
                x19Var.r(true);
                x19 f = this.mJsBridge.f(webView, e.optString("cssUrl"));
                if (f != null) {
                    x19Var.x(f.f());
                    x19Var.t(f.b());
                    x19Var.o(f.a());
                    x19Var.w(f.e());
                }
                x19Var.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                x19Var.r(true);
                x19 c = this.mJsBridge.c(webView, e.optInt("socialType"), e.optString("activityId"));
                if (c != null) {
                    x19Var.x(c.f());
                    x19Var.t(c.b());
                    x19Var.o(c.a());
                    x19Var.w(c.e());
                }
                x19Var.y(0);
            }
            return x19Var;
        }
        return (x19) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            x19 x19Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                x19Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                x19Var = this.mJsBridge.g(webView, hashMap);
            }
            if (x19Var != null) {
                x19Var.y(0);
            }
            List<w19> list = this.mAsyncCallBackMethodList.get(str);
            if (x19Var != null && list != null) {
                Iterator<w19> it = list.iterator();
                if (!TextUtils.isEmpty(x19Var.e())) {
                    while (it.hasNext()) {
                        w19 next = it.next();
                        if (next.b().equals(x19Var.e())) {
                            x19 x19Var2 = new x19();
                            x19Var2.v(next.a());
                            x19Var2.x(x19Var.f());
                            x19Var2.t(x19Var.b());
                            x19Var2.o(x19Var.a());
                            x19Var2.z(x19Var.l());
                            arrayList.add(x19Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        w19 next2 = it.next();
                        x19 x19Var3 = new x19();
                        x19Var3.v(next2.a());
                        x19Var3.x(x19Var.f());
                        x19Var3.t(x19Var.b());
                        x19Var3.o(x19Var.a());
                        x19Var3.z(x19Var.l());
                        arrayList.add(x19Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
