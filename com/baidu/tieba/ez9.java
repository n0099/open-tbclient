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
/* loaded from: classes5.dex */
public class ez9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<zy9> a;

    public ez9() {
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

    public void a(zy9 zy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zy9Var) == null) {
            this.a.add(zy9Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) {
            zq8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !ui.isEmpty(str) && !ui.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                    return;
                }
                webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
            }
        }
    }

    public bz9 c(dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            if ("notification".equals(dz9Var.c()) && "addObserver".equals(dz9Var.a())) {
                Iterator<zy9> it = this.a.iterator();
                while (it.hasNext()) {
                    bz9Var = it.next().addObserver(dz9Var.d(), bz9Var, true);
                    if (bz9Var.j()) {
                        return bz9Var;
                    }
                }
                if (!bz9Var.j()) {
                    bz9Var.z(202);
                    bz9Var.v(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = dz9Var.c();
                if (!ui.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    bz9Var.z(201);
                    return bz9Var;
                }
                Iterator<zy9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    bz9Var = it2.next().dispatch(dz9Var, bz9Var);
                    if (bz9Var.i()) {
                        return bz9Var;
                    }
                }
                if (!bz9Var.i()) {
                    bz9Var.z(202);
                }
            }
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    public void d(WebView webView, bz9 bz9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, bz9Var) != null) || webView == null || bz9Var == null || !bz9Var.k()) {
            return;
        }
        b(webView, bz9Var.c(), bz9Var.d());
    }

    public void e(WebView webView, List<bz9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (bz9 bz9Var : list) {
                if (bz9Var != null && bz9Var.k()) {
                    b(webView, bz9Var.c(), bz9Var.d());
                }
            }
        }
    }

    public List<bz9> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<bz9> list = null;
            if (ui.isEmpty(str)) {
                return null;
            }
            Iterator<zy9> it = this.a.iterator();
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
