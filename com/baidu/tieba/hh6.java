package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class hh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<dxa> a;

    public hh6() {
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

    public void a(dxa dxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dxaVar) == null) {
            this.a.add(dxaVar);
        }
    }

    public void g(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<dxa> it = this.a.iterator();
            while (it.hasNext()) {
                dxa next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public void b(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "H5通知callJsDispatchEvent params:" + str);
            if (webView != null && !TextUtils.isEmpty(str)) {
                webView.evaluateJavascript("javascript:var eventType = 'naNotify';var setEvent = new Event(eventType);setEvent.detail = " + str + ";document.dispatchEvent(setEvent);", null);
            }
        }
    }

    public boolean f(WebView webView, List<fxa> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (fxa fxaVar : list) {
                    if (fxaVar != null && fxaVar.k()) {
                        if (c(webView, fxaVar.c(), fxaVar.d(), fxaVar.j) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(WebView webView, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{webView, str, str2, Boolean.valueOf(z)})) == null) {
            if (!z) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("JsBridge", "执行javascript：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            }
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public fxa d(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            if ("notification".equals(hxaVar.c()) && "addObserver".equals(hxaVar.a())) {
                Iterator<dxa> it = this.a.iterator();
                while (it.hasNext()) {
                    fxaVar = it.next().addObserver(webView, hxaVar.d(), fxaVar, true);
                    if (fxaVar.j()) {
                        return fxaVar;
                    }
                }
                if (!fxaVar.j()) {
                    fxaVar.z(202);
                    fxaVar.v(fj6.b().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<dxa> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    fxaVar = it2.next().dispatch(webView, hxaVar, fxaVar);
                    if (fxaVar.i()) {
                        return fxaVar;
                    }
                }
                if (!fxaVar.i()) {
                    fxaVar.z(202);
                }
            }
            return fxaVar;
        }
        return (fxa) invokeLLL.objValue;
    }

    public boolean e(WebView webView, fxa fxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, fxaVar)) == null) {
            if (webView == null || fxaVar == null || !fxaVar.k()) {
                return false;
            }
            return c(webView, fxaVar.c(), fxaVar.d(), fxaVar.j);
        }
        return invokeLL.booleanValue;
    }

    public List<fxa> h(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, hashMap)) == null) {
            List<fxa> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<dxa> it = this.a.iterator();
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
