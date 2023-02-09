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
/* loaded from: classes4.dex */
public class e39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<z29> a;

    public e39() {
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

    public void a(z29 z29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z29Var) == null) {
            this.a.add(z29Var);
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

    public b39 c(d39 d39Var, b39 b39Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(d39Var.c()) && "addObserver".equals(d39Var.a())) {
                Iterator<z29> it = this.a.iterator();
                while (it.hasNext()) {
                    b39Var = it.next().addObserver(d39Var.d(), b39Var, true);
                    if (b39Var.j()) {
                        return b39Var;
                    }
                }
                if (!b39Var.j()) {
                    b39Var.y(202);
                    b39Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = d39Var.c();
                if (!dj.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    b39Var.y(201);
                    return b39Var;
                }
                Iterator<z29> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    b39Var = it2.next().dispatch(d39Var, b39Var);
                    if (b39Var.i()) {
                        return b39Var;
                    }
                }
                if (!b39Var.i()) {
                    b39Var.y(202);
                }
            }
            return b39Var;
        }
        return (b39) invokeLL.objValue;
    }

    public void d(WebView webView, b39 b39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, b39Var) != null) || webView == null || b39Var == null || !b39Var.k()) {
            return;
        }
        b(webView, b39Var.c(), b39Var.d());
    }

    public void e(WebView webView, List<b39> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (b39 b39Var : list) {
                if (b39Var != null && b39Var.k()) {
                    b(webView, b39Var.c(), b39Var.d());
                }
            }
        }
    }

    public List<b39> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<b39> list = null;
            if (dj.isEmpty(str)) {
                return null;
            }
            Iterator<z29> it = this.a.iterator();
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
