package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes3.dex */
public class a29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<v19> a;

    public a29() {
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

    public void a(v19 v19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v19Var) == null) {
            this.a.add(v19Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) && webView != null && !dj.isEmpty(str) && !dj.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
        }
    }

    public x19 c(z19 z19Var, x19 x19Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(z19Var.c()) && "addObserver".equals(z19Var.a())) {
                Iterator<v19> it = this.a.iterator();
                while (it.hasNext()) {
                    x19Var = it.next().addObserver(z19Var.d(), x19Var, true);
                    if (x19Var.j()) {
                        return x19Var;
                    }
                }
                if (!x19Var.j()) {
                    x19Var.y(202);
                    x19Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = z19Var.c();
                if (!dj.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    x19Var.y(201);
                    return x19Var;
                }
                Iterator<v19> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    x19Var = it2.next().dispatch(z19Var, x19Var);
                    if (x19Var.i()) {
                        return x19Var;
                    }
                }
                if (!x19Var.i()) {
                    x19Var.y(202);
                }
            }
            return x19Var;
        }
        return (x19) invokeLL.objValue;
    }

    public void d(WebView webView, x19 x19Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, x19Var) != null) || webView == null || x19Var == null || !x19Var.k()) {
            return;
        }
        b(webView, x19Var.c(), x19Var.d());
    }

    public void e(WebView webView, List<x19> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (x19 x19Var : list) {
                if (x19Var != null && x19Var.k()) {
                    b(webView, x19Var.c(), x19Var.d());
                }
            }
        }
    }

    public List<x19> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<x19> list = null;
            if (dj.isEmpty(str)) {
                return null;
            }
            Iterator<v19> it = this.a.iterator();
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
