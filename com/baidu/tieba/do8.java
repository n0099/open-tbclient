package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
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
/* loaded from: classes3.dex */
public class do8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public lo8 b;

    public do8() {
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
        this.a = new ArrayList();
        this.b = new lo8();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.clear();
        }
    }

    public void a(eo8 eo8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eo8Var) == null) {
            if (eo8Var != null) {
                this.a.add(eo8Var);
            }
            if (this.b != null && eo8Var != null && eo8Var.getClass().getAnnotation(yo.class) != null) {
                try {
                    this.b.a((go8) Class.forName("com.baidu.tieba.h5power." + eo8Var.getClass().getSimpleName() + go8.PROXY_CLASS_NAME_SUFFIX).getConstructor(eo8Var.getClass()).newInstance(eo8Var));
                } catch (Exception e) {
                    BdLog.e(e);
                }
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

    public final boolean f(TbPageContext tbPageContext, String str, io8 io8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, io8Var)) == null) {
            if (io8Var == null || io8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            io8Var.r(true);
            io8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void h(WebView webView, String str, HashMap hashMap) {
        lo8 lo8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, webView, str, hashMap) != null) || (lo8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, lo8Var.f(str, hashMap));
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
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    eo8 eo8Var = (eo8) it.next();
                    if (eo8Var != null && eo8Var.dealJsInterface(str, str2, str3, jsPromptResult)) {
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
        if ((interceptable != null && interceptable.invokeLL(1048580, this, webView, str) != null) || this.b == null) {
            return;
        }
        ko8 ko8Var = new ko8();
        io8 io8Var = new io8();
        String a = mo8.a(str);
        ko8Var.f(a);
        String d = mo8.d(str);
        ko8Var.h(d);
        String b = mo8.b(str);
        io8Var.v(b);
        if (ej.isEmpty(a) || ej.isEmpty(d) || ej.isEmpty(b)) {
            io8Var.y(101);
        }
        try {
            ko8Var.j(mo8.f(str));
        } catch (JSONException unused) {
            ko8Var.j(new JSONObject());
            io8Var.y(101);
        }
        ko8Var.i(mo8.e(str));
        ko8Var.g(mo8.c(str));
        io8 c = this.b.c(ko8Var, io8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(tl8.a(webView.getContext()), str, c);
        }
    }
}
