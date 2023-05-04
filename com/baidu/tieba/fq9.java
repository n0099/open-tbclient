package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class fq9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<gq9>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, jq9Var, hq9Var)) == null) {
            return null;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Nullable
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (xf6) invokeV.objValue;
    }

    public abstract List<hq9> processNotification(WebView webView, String str, HashMap hashMap);

    public fq9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void onDestroy() {
        xf6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public hq9 addObserver(WebView webView, String str, hq9 hq9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, hq9Var, Boolean.valueOf(z)})) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            if (this.mNotificationNameList.contains(str)) {
                hq9Var.n(false);
                hq9Var.t(true);
                List<gq9> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                gq9 gq9Var = new gq9();
                gq9Var.e(hq9Var.c());
                gq9Var.d(z);
                gq9Var.f(hq9Var.e());
                list.add(gq9Var);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof uf6) {
                    ((uf6) webView).a(str, gq9Var.a());
                }
            }
            return hq9Var;
        }
        return (hq9) invokeCommon.objValue;
    }

    public hq9 addObserver(String str, hq9 hq9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hq9Var, z)) == null) {
            return addObserver(null, str, hq9Var, z);
        }
        return (hq9) invokeLLZ.objValue;
    }

    public hq9 dispatch(jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jq9Var, hq9Var)) == null) {
            return dispatch(null, jq9Var, hq9Var);
        }
        return (hq9) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<gq9> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<gq9> it = list2.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().a(), pair.second)) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }
}
