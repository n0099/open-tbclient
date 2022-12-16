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
public class ft8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<at8> a;

    public ft8() {
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

    public void a(at8 at8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, at8Var) == null) {
            this.a.add(at8Var);
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

    public ct8 c(et8 et8Var, ct8 ct8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, et8Var, ct8Var)) == null) {
            if (ct8Var == null) {
                ct8Var = new ct8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(et8Var.c()) && "addObserver".equals(et8Var.a())) {
                Iterator<at8> it = this.a.iterator();
                while (it.hasNext()) {
                    ct8Var = it.next().addObserver(et8Var.d(), ct8Var, true);
                    if (ct8Var.j()) {
                        return ct8Var;
                    }
                }
                if (!ct8Var.j()) {
                    ct8Var.y(202);
                    ct8Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = et8Var.c();
                if (!xi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    ct8Var.y(201);
                    return ct8Var;
                }
                Iterator<at8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    ct8Var = it2.next().dispatch(et8Var, ct8Var);
                    if (ct8Var.i()) {
                        return ct8Var;
                    }
                }
                if (!ct8Var.i()) {
                    ct8Var.y(202);
                }
            }
            return ct8Var;
        }
        return (ct8) invokeLL.objValue;
    }

    public void d(WebView webView, ct8 ct8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, ct8Var) != null) || webView == null || ct8Var == null || !ct8Var.k()) {
            return;
        }
        b(webView, ct8Var.c(), ct8Var.d());
    }

    public void e(WebView webView, List<ct8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (ct8 ct8Var : list) {
                if (ct8Var != null && ct8Var.k()) {
                    b(webView, ct8Var.c(), ct8Var.d());
                }
            }
        }
    }

    public List<ct8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<ct8> list = null;
            if (xi.isEmpty(str)) {
                return null;
            }
            Iterator<at8> it = this.a.iterator();
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
