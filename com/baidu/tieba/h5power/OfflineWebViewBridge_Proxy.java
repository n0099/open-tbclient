package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.vd6;
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
public class OfflineWebViewBridge_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vd6 mJsBridge;

    public OfflineWebViewBridge_Proxy(vd6 vd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vd6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vd6Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var = new km9();
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("hybrid/requestByNativeNew")) {
                km9Var.r(true);
                km9 d = this.mJsBridge.d(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (d != null) {
                    km9Var.x(d.f());
                    km9Var.t(d.b());
                    km9Var.o(d.a());
                    km9Var.w(d.e());
                    if (!km9Var.h()) {
                        km9Var.n(false);
                        addObserver(webView, "RequestByNativeToH5", km9Var, false);
                    }
                }
                km9Var.y(0);
            }
            return km9Var;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            km9 km9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("RequestByNativeToH5")) {
                km9Var = this.mJsBridge.e(webView, hashMap);
            }
            if (km9Var != null) {
                km9Var.y(0);
            }
            List<jm9> list = this.mAsyncCallBackMethodList.get(str);
            if (km9Var != null && list != null) {
                Iterator<jm9> it = list.iterator();
                if (!TextUtils.isEmpty(km9Var.e())) {
                    while (it.hasNext()) {
                        jm9 next = it.next();
                        if (next.b().equals(km9Var.e())) {
                            km9 km9Var2 = new km9();
                            km9Var2.v(next.a());
                            km9Var2.x(km9Var.f());
                            km9Var2.t(km9Var.b());
                            km9Var2.o(km9Var.a());
                            km9Var2.z(km9Var.l());
                            arrayList.add(km9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jm9 next2 = it.next();
                        km9 km9Var3 = new km9();
                        km9Var3.v(next2.a());
                        km9Var3.x(km9Var.f());
                        km9Var3.t(km9Var.b());
                        km9Var3.o(km9Var.a());
                        km9Var3.z(km9Var.l());
                        arrayList.add(km9Var3);
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
