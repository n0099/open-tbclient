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
public class gq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<bq8> a;

    public gq8() {
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

    public void a(bq8 bq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bq8Var) == null) {
            this.a.add(bq8Var);
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

    public dq8 c(fq8 fq8Var, dq8 dq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fq8Var, dq8Var)) == null) {
            if (dq8Var == null) {
                dq8Var = new dq8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(fq8Var.c()) && "addObserver".equals(fq8Var.a())) {
                Iterator<bq8> it = this.a.iterator();
                while (it.hasNext()) {
                    dq8Var = it.next().addObserver(fq8Var.d(), dq8Var, true);
                    if (dq8Var.j()) {
                        return dq8Var;
                    }
                }
                if (!dq8Var.j()) {
                    dq8Var.y(202);
                    dq8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036d));
                }
            } else {
                String c = fq8Var.c();
                if (!xi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    dq8Var.y(201);
                    return dq8Var;
                }
                Iterator<bq8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    dq8Var = it2.next().dispatch(fq8Var, dq8Var);
                    if (dq8Var.i()) {
                        return dq8Var;
                    }
                }
                if (!dq8Var.i()) {
                    dq8Var.y(202);
                }
            }
            return dq8Var;
        }
        return (dq8) invokeLL.objValue;
    }

    public void d(WebView webView, dq8 dq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, dq8Var) != null) || webView == null || dq8Var == null || !dq8Var.k()) {
            return;
        }
        b(webView, dq8Var.c(), dq8Var.d());
    }

    public void e(WebView webView, List<dq8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (dq8 dq8Var : list) {
                if (dq8Var != null && dq8Var.k()) {
                    b(webView, dq8Var.c(), dq8Var.d());
                }
            }
        }
    }

    public List<dq8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<dq8> list = null;
            if (xi.isEmpty(str)) {
                return null;
            }
            Iterator<bq8> it = this.a.iterator();
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
