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
/* loaded from: classes5.dex */
public abstract class dxa {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<exa>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, hxaVar, fxaVar)) == null) {
            return null;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Nullable
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (qj6) invokeV.objValue;
    }

    public abstract List<fxa> processNotification(WebView webView, String str, HashMap hashMap);

    public dxa() {
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
        qj6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public fxa addObserver(WebView webView, String str, fxa fxaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, fxaVar, Boolean.valueOf(z)})) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            if (this.mNotificationNameList.contains(str)) {
                fxaVar.n(false);
                fxaVar.t(true);
                List<exa> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                exa exaVar = new exa();
                exaVar.e(fxaVar.c());
                exaVar.d(z);
                exaVar.f(fxaVar.e());
                list.add(exaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof nj6) {
                    ((nj6) webView).a(str, exaVar.a());
                }
            }
            return fxaVar;
        }
        return (fxa) invokeCommon.objValue;
    }

    public fxa addObserver(String str, fxa fxaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fxaVar, z)) == null) {
            return addObserver(null, str, fxaVar, z);
        }
        return (fxa) invokeLLZ.objValue;
    }

    public fxa dispatch(hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hxaVar, fxaVar)) == null) {
            return dispatch(null, hxaVar, fxaVar);
        }
        return (fxa) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<exa> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<exa> it = list2.iterator();
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
