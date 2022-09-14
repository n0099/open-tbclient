package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<in8> a;
    public pn8 b;

    public hn8() {
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
        this.b = new pn8();
    }

    public void a(in8 in8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, in8Var) == null) {
            if (in8Var != null) {
                this.a.add(in8Var);
            }
            if (this.b == null || in8Var == null || in8Var.getClass().getAnnotation(xo.class) == null) {
                return;
            }
            try {
                this.b.a((kn8) Class.forName("com.baidu.tieba.h5power." + in8Var.getClass().getSimpleName() + kn8.PROXY_CLASS_NAME_SUFFIX).getConstructor(in8Var.getClass()).newInstance(in8Var));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                e(webView, str);
                return false;
            }
            return c(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return d(optString, optString2, optString3, jsPromptResult);
                }
            } catch (JSONException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<in8> it = this.a.iterator();
                while (it.hasNext()) {
                    in8 next = it.next();
                    if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void e(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) || this.b == null) {
            return;
        }
        on8 on8Var = new on8();
        mn8 mn8Var = new mn8();
        String a = qn8.a(str);
        on8Var.f(a);
        String d = qn8.d(str);
        on8Var.h(d);
        String b = qn8.b(str);
        mn8Var.v(b);
        if (dj.isEmpty(a) || dj.isEmpty(d) || dj.isEmpty(b)) {
            mn8Var.y(101);
        }
        try {
            on8Var.j(qn8.f(str));
        } catch (JSONException unused) {
            on8Var.j(new JSONObject());
            mn8Var.y(101);
        }
        on8Var.i(qn8.e(str));
        on8Var.g(qn8.c(str));
        mn8 c = this.b.c(on8Var, mn8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(xk8.a(webView.getContext()), str, c);
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, mn8 mn8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, mn8Var)) == null) {
            if (mn8Var == null || mn8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            mn8Var.r(true);
            mn8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.clear();
        }
    }

    public void h(WebView webView, String str, @Nullable HashMap hashMap) {
        pn8 pn8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, webView, str, hashMap) == null) || (pn8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, pn8Var.f(str, hashMap));
    }
}
