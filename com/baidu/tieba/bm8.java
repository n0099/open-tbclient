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
public class bm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wl8> a;

    public bm8() {
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

    public void a(wl8 wl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wl8Var) == null) {
            this.a.add(wl8Var);
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

    public yl8 c(am8 am8Var, yl8 yl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, am8Var, yl8Var)) == null) {
            if (yl8Var == null) {
                yl8Var = new yl8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(am8Var.c()) && "addObserver".equals(am8Var.a())) {
                Iterator<wl8> it = this.a.iterator();
                while (it.hasNext()) {
                    yl8Var = it.next().addObserver(am8Var.d(), yl8Var, true);
                    if (yl8Var.j()) {
                        return yl8Var;
                    }
                }
                if (!yl8Var.j()) {
                    yl8Var.y(202);
                    yl8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0368));
                }
            } else {
                String c = am8Var.c();
                if (!qi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    yl8Var.y(201);
                    return yl8Var;
                }
                Iterator<wl8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    yl8Var = it2.next().dispatch(am8Var, yl8Var);
                    if (yl8Var.i()) {
                        return yl8Var;
                    }
                }
                if (!yl8Var.i()) {
                    yl8Var.y(202);
                }
            }
            return yl8Var;
        }
        return (yl8) invokeLL.objValue;
    }

    public void d(WebView webView, yl8 yl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, yl8Var) == null) || webView == null || yl8Var == null || !yl8Var.k()) {
            return;
        }
        b(webView, yl8Var.c(), yl8Var.d());
    }

    public void e(WebView webView, List<yl8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (yl8 yl8Var : list) {
            if (yl8Var != null && yl8Var.k()) {
                b(webView, yl8Var.c(), yl8Var.d());
            }
        }
    }

    public List<yl8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<yl8> list = null;
            if (qi.isEmpty(str)) {
                return null;
            }
            Iterator<wl8> it = this.a.iterator();
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
