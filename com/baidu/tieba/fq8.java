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
public class fq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<aq8> a;

    public fq8() {
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

    public void a(aq8 aq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aq8Var) == null) {
            this.a.add(aq8Var);
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

    public cq8 c(eq8 eq8Var, cq8 cq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eq8Var, cq8Var)) == null) {
            if (cq8Var == null) {
                cq8Var = new cq8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(eq8Var.c()) && "addObserver".equals(eq8Var.a())) {
                Iterator<aq8> it = this.a.iterator();
                while (it.hasNext()) {
                    cq8Var = it.next().addObserver(eq8Var.d(), cq8Var, true);
                    if (cq8Var.j()) {
                        return cq8Var;
                    }
                }
                if (!cq8Var.j()) {
                    cq8Var.y(202);
                    cq8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036d));
                }
            } else {
                String c = eq8Var.c();
                if (!xi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    cq8Var.y(201);
                    return cq8Var;
                }
                Iterator<aq8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    cq8Var = it2.next().dispatch(eq8Var, cq8Var);
                    if (cq8Var.i()) {
                        return cq8Var;
                    }
                }
                if (!cq8Var.i()) {
                    cq8Var.y(202);
                }
            }
            return cq8Var;
        }
        return (cq8) invokeLL.objValue;
    }

    public void d(WebView webView, cq8 cq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, cq8Var) != null) || webView == null || cq8Var == null || !cq8Var.k()) {
            return;
        }
        b(webView, cq8Var.c(), cq8Var.d());
    }

    public void e(WebView webView, List<cq8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (cq8 cq8Var : list) {
                if (cq8Var != null && cq8Var.k()) {
                    b(webView, cq8Var.c(), cq8Var.d());
                }
            }
        }
    }

    public List<cq8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<cq8> list = null;
            if (xi.isEmpty(str)) {
                return null;
            }
            Iterator<aq8> it = this.a.iterator();
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
