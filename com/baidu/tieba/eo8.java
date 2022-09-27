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
public class eo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zn8> a;

    public eo8() {
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

    public void a(zn8 zn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zn8Var) == null) {
            this.a.add(zn8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || dj.isEmpty(str) || dj.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public bo8 c(do8 do8Var, bo8 bo8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, do8Var, bo8Var)) == null) {
            if (bo8Var == null) {
                bo8Var = new bo8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(do8Var.c()) && "addObserver".equals(do8Var.a())) {
                Iterator<zn8> it = this.a.iterator();
                while (it.hasNext()) {
                    bo8Var = it.next().addObserver(do8Var.d(), bo8Var, true);
                    if (bo8Var.j()) {
                        return bo8Var;
                    }
                }
                if (!bo8Var.j()) {
                    bo8Var.y(202);
                    bo8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c));
                }
            } else {
                String c = do8Var.c();
                if (!dj.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    bo8Var.y(201);
                    return bo8Var;
                }
                Iterator<zn8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    bo8Var = it2.next().dispatch(do8Var, bo8Var);
                    if (bo8Var.i()) {
                        return bo8Var;
                    }
                }
                if (!bo8Var.i()) {
                    bo8Var.y(202);
                }
            }
            return bo8Var;
        }
        return (bo8) invokeLL.objValue;
    }

    public void d(WebView webView, bo8 bo8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, bo8Var) == null) || webView == null || bo8Var == null || !bo8Var.k()) {
            return;
        }
        b(webView, bo8Var.c(), bo8Var.d());
    }

    public void e(WebView webView, List<bo8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (bo8 bo8Var : list) {
            if (bo8Var != null && bo8Var.k()) {
                b(webView, bo8Var.c(), bo8Var.d());
            }
        }
    }

    public List<bo8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<bo8> list = null;
            if (dj.isEmpty(str)) {
                return null;
            }
            Iterator<zn8> it = this.a.iterator();
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
