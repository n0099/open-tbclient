package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.h5power.DescriptionTableInfo;
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
public class i5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<d5a> a;

    public i5a() {
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

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            ew8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !wi.isEmpty(str) && !wi.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public f5a c(h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            if ("notification".equals(h5aVar.c()) && "addObserver".equals(h5aVar.a())) {
                Iterator<d5a> it = this.a.iterator();
                while (it.hasNext()) {
                    f5aVar = it.next().addObserver(h5aVar.d(), f5aVar, true);
                    if (f5aVar.j()) {
                        return f5aVar;
                    }
                }
                if (!f5aVar.j()) {
                    f5aVar.z(202);
                    f5aVar.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = h5aVar.c();
                if (!wi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    f5aVar.z(201);
                    return f5aVar;
                }
                Iterator<d5a> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    f5aVar = it2.next().dispatch(h5aVar, f5aVar);
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
        return (f5a) invokeLL.objValue;
    }

    public void d(WebView webView, f5a f5aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, f5aVar) != null) || webView == null || f5aVar == null || !f5aVar.k()) {
            return;
        }
        b(webView, f5aVar.c(), f5aVar.d());
    }

    public void e(WebView webView, List<f5a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (f5a f5aVar : list) {
                if (f5aVar != null && f5aVar.k()) {
                    b(webView, f5aVar.c(), f5aVar.d());
                }
            }
        }
    }

    public List<f5a> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<f5a> list = null;
            if (wi.isEmpty(str)) {
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
