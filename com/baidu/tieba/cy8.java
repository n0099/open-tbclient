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
public class cy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<xx8> a;

    public cy8() {
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

    public void a(xx8 xx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xx8Var) == null) {
            this.a.add(xx8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) && webView != null && !yi.isEmpty(str) && !yi.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
        }
    }

    public zx8 c(by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(by8Var.c()) && "addObserver".equals(by8Var.a())) {
                Iterator<xx8> it = this.a.iterator();
                while (it.hasNext()) {
                    zx8Var = it.next().addObserver(by8Var.d(), zx8Var, true);
                    if (zx8Var.j()) {
                        return zx8Var;
                    }
                }
                if (!zx8Var.j()) {
                    zx8Var.y(202);
                    zx8Var.u(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c = by8Var.c();
                if (!yi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    zx8Var.y(201);
                    return zx8Var;
                }
                Iterator<xx8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    zx8Var = it2.next().dispatch(by8Var, zx8Var);
                    if (zx8Var.i()) {
                        return zx8Var;
                    }
                }
                if (!zx8Var.i()) {
                    zx8Var.y(202);
                }
            }
            return zx8Var;
        }
        return (zx8) invokeLL.objValue;
    }

    public void d(WebView webView, zx8 zx8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, zx8Var) != null) || webView == null || zx8Var == null || !zx8Var.k()) {
            return;
        }
        b(webView, zx8Var.c(), zx8Var.d());
    }

    public void e(WebView webView, List<zx8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (zx8 zx8Var : list) {
                if (zx8Var != null && zx8Var.k()) {
                    b(webView, zx8Var.c(), zx8Var.d());
                }
            }
        }
    }

    public List<zx8> f(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, hashMap)) == null) {
            List<zx8> list = null;
            if (yi.isEmpty(str)) {
                return null;
            }
            Iterator<xx8> it = this.a.iterator();
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
