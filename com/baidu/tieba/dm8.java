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
public class dm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yl8> a;

    public dm8() {
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

    public void a(yl8 yl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yl8Var) == null) {
            this.a.add(yl8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || qi.isEmpty(str) || qi.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public am8 c(cm8 cm8Var, am8 am8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cm8Var, am8Var)) == null) {
            if (am8Var == null) {
                am8Var = new am8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(cm8Var.c()) && "addObserver".equals(cm8Var.a())) {
                Iterator<yl8> it = this.a.iterator();
                while (it.hasNext()) {
                    am8Var = it.next().addObserver(cm8Var.d(), am8Var, true);
                    if (am8Var.j()) {
                        return am8Var;
                    }
                }
                if (!am8Var.j()) {
                    am8Var.y(202);
                    am8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0368));
                }
            } else {
                String c = cm8Var.c();
                if (!qi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    am8Var.y(201);
                    return am8Var;
                }
                Iterator<yl8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    am8Var = it2.next().dispatch(cm8Var, am8Var);
                    if (am8Var.i()) {
                        return am8Var;
                    }
                }
                if (!am8Var.i()) {
                    am8Var.y(202);
                }
            }
            return am8Var;
        }
        return (am8) invokeLL.objValue;
    }

    public void d(WebView webView, am8 am8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, am8Var) == null) || webView == null || am8Var == null || !am8Var.k()) {
            return;
        }
        b(webView, am8Var.c(), am8Var.d());
    }

    public void e(WebView webView, List<am8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (am8 am8Var : list) {
            if (am8Var != null && am8Var.k()) {
                b(webView, am8Var.c(), am8Var.d());
            }
        }
    }

    public List<am8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<am8> list = null;
            if (qi.isEmpty(str)) {
                return null;
            }
            Iterator<yl8> it = this.a.iterator();
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
