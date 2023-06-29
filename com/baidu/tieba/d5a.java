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
public abstract class d5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<e5a>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, h5aVar, f5aVar)) == null) {
            return null;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Nullable
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (em6) invokeV.objValue;
    }

    public abstract List<f5a> processNotification(WebView webView, String str, HashMap hashMap);

    public d5a() {
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
        em6 jsBridge;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jsBridge = getJsBridge()) != null) {
            jsBridge.onDestroy();
        }
    }

    public f5a addObserver(WebView webView, String str, f5a f5aVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, f5aVar, Boolean.valueOf(z)})) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            if (this.mNotificationNameList.contains(str)) {
                f5aVar.n(false);
                f5aVar.t(true);
                List<e5a> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                e5a e5aVar = new e5a();
                e5aVar.e(f5aVar.c());
                e5aVar.d(z);
                e5aVar.f(f5aVar.e());
                list.add(e5aVar);
                this.mAsyncCallBackMethodList.put(str, list);
                if (webView instanceof bm6) {
                    ((bm6) webView).a(str, e5aVar.a());
                }
            }
            return f5aVar;
        }
        return (f5a) invokeCommon.objValue;
    }

    public f5a addObserver(String str, f5a f5aVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f5aVar, z)) == null) {
            return addObserver(null, str, f5aVar, z);
        }
        return (f5a) invokeLLZ.objValue;
    }

    public f5a dispatch(h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, h5aVar, f5aVar)) == null) {
            return dispatch(null, h5aVar, f5aVar);
        }
        return (f5a) invokeLL.objValue;
    }

    public void removeObserverBridge(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
            for (Pair<String, String> pair : list) {
                List<e5a> list2 = this.mAsyncCallBackMethodList.get(pair.first);
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<e5a> it = list2.iterator();
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
