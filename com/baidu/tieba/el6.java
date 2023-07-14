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
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class el6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<oda> a;

    public el6() {
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

    public void a(oda odaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, odaVar) == null) {
            this.a.add(odaVar);
        }
    }

    public void g(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<oda> it = this.a.iterator();
            while (it.hasNext()) {
                oda next = it.next();
                next.removeObserverBridge(list);
                next.onDestroy();
            }
        }
    }

    public void b(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            h29 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "H5通知callJsDispatchEvent params:" + str);
            if (webView != null && !TextUtils.isEmpty(str)) {
                webView.evaluateJavascript("javascript:var eventType = 'naNotify';var setEvent = new Event(eventType);setEvent.detail = " + str + ParamableElem.DIVIDE_PARAM + "document.dispatchEvent(setEvent);", null);
            }
        }
    }

    public boolean f(WebView webView, List<qda> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (qda qdaVar : list) {
                    if (qdaVar != null && qdaVar.k()) {
                        if (c(webView, qdaVar.c(), qdaVar.d()) || z) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            h29 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "端能力返回H5：callJsMethod methodName:" + str + " param:" + str2 + " " + webView);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public qda d(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            if ("notification".equals(sdaVar.c()) && "addObserver".equals(sdaVar.a())) {
                Iterator<oda> it = this.a.iterator();
                while (it.hasNext()) {
                    qdaVar = it.next().addObserver(webView, sdaVar.d(), qdaVar, true);
                    if (qdaVar.j()) {
                        return qdaVar;
                    }
                }
                if (!qdaVar.j()) {
                    qdaVar.z(202);
                    qdaVar.v(xm6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<oda> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    qdaVar = it2.next().dispatch(webView, sdaVar, qdaVar);
                    if (qdaVar.i()) {
                        return qdaVar;
                    }
                }
                if (!qdaVar.i()) {
                    qdaVar.z(202);
                }
            }
            return qdaVar;
        }
        return (qda) invokeLLL.objValue;
    }

    public void e(WebView webView, qda qdaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, webView, qdaVar) != null) || webView == null || qdaVar == null || !qdaVar.k()) {
            return;
        }
        c(webView, qdaVar.c(), qdaVar.d());
    }

    public List<qda> h(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, hashMap)) == null) {
            List<qda> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<oda> it = this.a.iterator();
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
