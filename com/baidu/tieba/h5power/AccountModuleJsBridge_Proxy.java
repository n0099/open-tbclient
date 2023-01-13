package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.by8;
import com.baidu.tieba.gq4;
import com.baidu.tieba.xx8;
import com.baidu.tieba.yx8;
import com.baidu.tieba.zx8;
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
public class AccountModuleJsBridge_Proxy extends xx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gq4 mJsBridge;

    public AccountModuleJsBridge_Proxy(gq4 gq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gq4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = gq4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
    }

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(WebView webView, by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("account/startLoginModule")) {
                zx8Var.r(true);
                zx8 f = this.mJsBridge.f(webView, e.optString("cssUrl"));
                if (f != null) {
                    zx8Var.x(f.f());
                    zx8Var.t(f.b());
                    zx8Var.o(f.a());
                    zx8Var.w(f.e());
                }
                zx8Var.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                zx8Var.r(true);
                zx8 c = this.mJsBridge.c(webView, e.optInt("socialType"), e.optString("activityId"));
                if (c != null) {
                    zx8Var.x(c.f());
                    zx8Var.t(c.b());
                    zx8Var.o(c.a());
                    zx8Var.w(c.e());
                }
                zx8Var.y(0);
            }
            return zx8Var;
        }
        return (zx8) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            zx8 zx8Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                zx8Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                zx8Var = this.mJsBridge.g(webView, hashMap);
            }
            if (zx8Var != null) {
                zx8Var.y(0);
            }
            List<yx8> list = this.mAsyncCallBackMethodList.get(str);
            if (zx8Var != null && list != null) {
                Iterator<yx8> it = list.iterator();
                if (!TextUtils.isEmpty(zx8Var.e())) {
                    while (it.hasNext()) {
                        yx8 next = it.next();
                        if (next.b().equals(zx8Var.e())) {
                            zx8 zx8Var2 = new zx8();
                            zx8Var2.v(next.a());
                            zx8Var2.x(zx8Var.f());
                            zx8Var2.t(zx8Var.b());
                            zx8Var2.o(zx8Var.a());
                            zx8Var2.z(zx8Var.l());
                            arrayList.add(zx8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        yx8 next2 = it.next();
                        zx8 zx8Var3 = new zx8();
                        zx8Var3.v(next2.a());
                        zx8Var3.x(zx8Var.f());
                        zx8Var3.t(zx8Var.b());
                        zx8Var3.o(zx8Var.a());
                        zx8Var3.z(zx8Var.l());
                        arrayList.add(zx8Var3);
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
