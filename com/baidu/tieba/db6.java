package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.ListUtils;
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
public class db6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rc9> a;

    public db6() {
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

    public void a(rc9 rc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rc9Var) == null) {
            this.a.add(rc9Var);
        }
    }

    public void f(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty()) {
            Iterator<rc9> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().removeObserverBridge(list);
            }
        }
    }

    public final boolean b(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2)) == null) {
            w58 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "callJsMethod methodName:" + str + " param:" + str2);
            if (webView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public tc9 c(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            if ("notification".equals(vc9Var.c()) && "addObserver".equals(vc9Var.a())) {
                Iterator<rc9> it = this.a.iterator();
                while (it.hasNext()) {
                    tc9Var = it.next().addObserver(webView, vc9Var.d(), tc9Var, true);
                    if (tc9Var.j()) {
                        return tc9Var;
                    }
                }
                if (!tc9Var.j()) {
                    tc9Var.y(202);
                    tc9Var.u(zc6.getContext().getString(R.string.can_find_notification_name));
                }
            } else {
                Iterator<rc9> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    tc9Var = it2.next().dispatch(webView, vc9Var, tc9Var);
                    if (tc9Var.i()) {
                        return tc9Var;
                    }
                }
                if (!tc9Var.i()) {
                    tc9Var.y(202);
                }
            }
            return tc9Var;
        }
        return (tc9) invokeLLL.objValue;
    }

    public void d(WebView webView, tc9 tc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, tc9Var) != null) || webView == null || tc9Var == null || !tc9Var.k()) {
            return;
        }
        b(webView, tc9Var.c(), tc9Var.d());
    }

    public boolean e(WebView webView, List<tc9> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, list)) == null) {
            if (webView == null || ListUtils.isEmpty(list)) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (tc9 tc9Var : list) {
                    if (tc9Var != null && tc9Var.k()) {
                        if (z || b(webView, tc9Var.c(), tc9Var.d())) {
                            z = true;
                        }
                    }
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public List<tc9> g(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, hashMap)) == null) {
            List<tc9> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<rc9> it = this.a.iterator();
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
