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
public class gt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<bt8> a;

    public gt8() {
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

    public void a(bt8 bt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bt8Var) == null) {
            this.a.add(bt8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) && webView != null && !xi.isEmpty(str) && !xi.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
        }
    }

    public dt8 c(ft8 ft8Var, dt8 dt8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ft8Var, dt8Var)) == null) {
            if (dt8Var == null) {
                dt8Var = new dt8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(ft8Var.c()) && "addObserver".equals(ft8Var.a())) {
                Iterator<bt8> it = this.a.iterator();
                while (it.hasNext()) {
                    dt8Var = it.next().addObserver(ft8Var.d(), dt8Var, true);
                    if (dt8Var.j()) {
                        return dt8Var;
                    }
                }
                if (!dt8Var.j()) {
                    dt8Var.y(202);
                    dt8Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = ft8Var.c();
                if (!xi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    dt8Var.y(201);
                    return dt8Var;
                }
                Iterator<bt8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    dt8Var = it2.next().dispatch(ft8Var, dt8Var);
                    if (dt8Var.i()) {
                        return dt8Var;
                    }
                }
                if (!dt8Var.i()) {
                    dt8Var.y(202);
                }
            }
            return dt8Var;
        }
        return (dt8) invokeLL.objValue;
    }

    public void d(WebView webView, dt8 dt8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, dt8Var) != null) || webView == null || dt8Var == null || !dt8Var.k()) {
            return;
        }
        b(webView, dt8Var.c(), dt8Var.d());
    }

    public void e(WebView webView, List<dt8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (dt8 dt8Var : list) {
                if (dt8Var != null && dt8Var.k()) {
                    b(webView, dt8Var.c(), dt8Var.d());
                }
            }
        }
    }

    public List<dt8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<dt8> list = null;
            if (xi.isEmpty(str)) {
                return null;
            }
            Iterator<bt8> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
