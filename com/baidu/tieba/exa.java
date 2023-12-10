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
public abstract class exa {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<fxa>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, ixaVar, gxaVar)) == null) {
            return null;
        }
        return (gxa) invokeLLL.objValue;
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

    public abstract List<gxa> processNotification(WebView webView, String str, HashMap hashMap);

    public exa() {
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

    public gxa addObserver(WebView webView, String str, gxa gxaVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, gxaVar, Boolean.valueOf(z)})) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            if (this.mNotificationNameList.contains(str)) {
                gxaVar.n(false);
                gxaVar.t(true);
                List<fxa> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                fxa fxaVar = new fxa();
                fxaVar.e(gxaVar.c());
                fxaVar.d(z);
                fxaVar.f(gxaVar.e());
                list.add(fxaVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof nj6) {
                    ((nj6) webView).a(str, fxaVar.a());
                }
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa addObserver(String str, gxa gxaVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gxaVar, z)) == null) {
            return addObserver(null, str, gxaVar, z);
        }
        return (gxa) invokeLLZ.objValue;
    }

    public gxa dispatch(ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ixaVar, gxaVar)) == null) {
            return dispatch(null, ixaVar, gxaVar);
        }
        return (gxa) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<fxa> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<fxa> it = list2.iterator();
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
