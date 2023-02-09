package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.a39;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.uu4;
import com.baidu.tieba.z29;
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
/* loaded from: classes4.dex */
public class CommonModuleJsBridge_Proxy extends z29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uu4 mJsBridge;

    public CommonModuleJsBridge_Proxy(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
    }

    @Override // com.baidu.tieba.z29
    public b39 dispatch(WebView webView, d39 d39Var, b39 b39Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            d39Var.b();
            d39Var.e();
            return b39Var;
        }
        return (b39) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            b39 b39Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                b39Var = this.mJsBridge.c(webView, hashMap);
            }
            if (b39Var != null) {
                b39Var.y(0);
            }
            List<a39> list = this.mAsyncCallBackMethodList.get(str);
            if (b39Var != null && list != null) {
                Iterator<a39> it = list.iterator();
                if (!TextUtils.isEmpty(b39Var.e())) {
                    while (it.hasNext()) {
                        a39 next = it.next();
                        if (next.b().equals(b39Var.e())) {
                            b39 b39Var2 = new b39();
                            b39Var2.v(next.a());
                            b39Var2.x(b39Var.f());
                            b39Var2.t(b39Var.b());
                            b39Var2.o(b39Var.a());
                            b39Var2.z(b39Var.l());
                            arrayList.add(b39Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        a39 next2 = it.next();
                        b39 b39Var3 = new b39();
                        b39Var3.v(next2.a());
                        b39Var3.x(b39Var.f());
                        b39Var3.t(b39Var.b());
                        b39Var3.o(b39Var.a());
                        b39Var3.z(b39Var.l());
                        arrayList.add(b39Var3);
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
