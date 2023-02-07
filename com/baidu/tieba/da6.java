package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
public class da6 implements tb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<vb6> b;
    public final ea6 c;

    public da6() {
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
        this.b = new ArrayList<>();
        this.c = new ea6();
    }

    @Override // com.baidu.tieba.tb6
    public void a(WebView webView, String str, @Nullable HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, hashMap) == null) {
            this.c.e(webView, this.c.f(webView, str, hashMap));
        }
    }

    @Override // com.baidu.tieba.tb6
    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                return f(webView, str);
            }
            return e(webView, str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, String str, x19 x19Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, x19Var)) == null) {
            if (x19Var == null || x19Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            x19Var.r(true);
            x19Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.tb6
    public void c(vb6 vb6Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vb6Var, obj) == null) && (obj instanceof v19)) {
            this.b.add(vb6Var);
            this.c.a((v19) obj);
        }
    }

    public final boolean d(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<vb6> it = this.b.iterator();
            while (it.hasNext()) {
                vb6 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, str, jsPromptResult)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return d(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString(Constants.EXTRA_PARAM, ""), jsPromptResult);
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            z19 z19Var = new z19();
            String a = b29.a(str);
            String d = b29.d(str);
            String b = b29.b(str);
            z19Var.f(a);
            z19Var.h(d);
            x19 x19Var = new x19();
            x19Var.v(b);
            if (dj.isEmpty(a) || dj.isEmpty(d) || dj.isEmpty(b)) {
                x19Var.y(101);
            }
            try {
                z19Var.j(b29.f(str));
            } catch (JSONException unused) {
                z19Var.j(new JSONObject());
                x19Var.y(101);
            }
            z19Var.i(b29.e(str));
            z19Var.g(b29.c(str));
            x19 c = this.c.c(webView, z19Var, x19Var);
            if (c.g()) {
                this.c.d(webView, c);
                return false;
            }
            g(jz8.a(webView.getContext()), str, c);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
