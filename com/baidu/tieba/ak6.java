package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ak6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<d5a> a;

    public ak6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public void a(d5a d5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d5aVar) == null) {
            this.a.add(d5aVar);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<d5a> it = this.a.iterator();
            while (it.hasNext()) {
                d5a next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            ew8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "端能力返回结果：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public f5a c(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            if ("notification".equals(h5aVar.c()) && "addObserver".equals(h5aVar.a())) {
                Iterator<d5a> it = this.a.iterator();
                while (it.hasNext()) {
                    f5aVar = it.next().addObserver(webView, h5aVar.d(), f5aVar, true);
                    if (f5aVar.j()) {
                        return f5aVar;
                    }
                }
                if (!f5aVar.j()) {
                    f5aVar.z(202);
                    f5aVar.v(tl6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<d5a> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    f5aVar = it2.next().dispatch(webView, h5aVar, f5aVar);
                    if (f5aVar.i()) {
                        return f5aVar;
                    }
                }
                if (!f5aVar.i()) {
                    f5aVar.z(202);
                }
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    public void d(WebView webView, f5a f5aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, f5aVar) != null) || webView == null || f5aVar == null || !f5aVar.k()) {
            return;
        }
        b(webView, f5aVar.c(), f5aVar.d());
    }

    public boolean e(WebView webView, List<f5a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (f5a f5aVar : list) {
                    if (f5aVar != null && f5aVar.k()) {
                        if (b(webView, f5aVar.c(), f5aVar.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<f5a> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<f5a> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<d5a> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(webView, str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLLL.objValue;
    }
}
