package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cb6 implements hd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<jd6> b;
    public final db6 c;

    public cb6() {
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
        this.c = new db6();
    }

    @Override // com.baidu.tieba.hd6
    public void a(WebView webView, String str, @Nullable HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, hashMap) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            g(webView.getUrl(), str, str);
            if (this.c.e(webView, this.c.g(webView, str, hashMap))) {
                pd6.c("lt-log", "端能力 执行成功 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            pd6.e("lt-log", "端能力 执行失败 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean h(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, webView, str, jsPromptResult)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                w58 hybridLog = HybridLog.getInstance();
                hybridLog.c("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                return e(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString("param", ""), jsPromptResult);
            } catch (JSONException e) {
                w58 hybridLog2 = HybridLog.getInstance();
                hybridLog2.b("JsBridge", "processJSON JSONException:" + e);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hd6
    public void b(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.c.f(list);
        }
    }

    @Override // com.baidu.tieba.hd6
    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            f(str, str, webView.getUrl());
            if (str.startsWith("tiebaapp")) {
                return i(webView, str);
            }
            return h(webView, str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("js_call_native");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void g(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("native_call_js");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, String str, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, tbPageContext, str, tc9Var)) == null) {
            if (tc9Var == null || tc9Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            tc9Var.r(true);
            tc9Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hd6
    public void d(jd6 jd6Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, jd6Var, obj) == null) && (obj instanceof rc9)) {
            this.b.add(jd6Var);
            this.c.a((rc9) obj);
        }
    }

    public final boolean e(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<jd6> it = this.b.iterator();
            while (it.hasNext()) {
                jd6 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean i(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            w58 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "processScheme scheme:" + str);
            vc9 vc9Var = new vc9();
            String a = xc9.a(str);
            String d = xc9.d(str);
            String b = xc9.b(str);
            vc9Var.f(a);
            vc9Var.h(d);
            tc9 tc9Var = new tc9();
            tc9Var.v(b);
            if (gi.isEmpty(a) || gi.isEmpty(d) || gi.isEmpty(b)) {
                tc9Var.y(101);
            }
            try {
                vc9Var.j(xc9.f(str));
            } catch (JSONException unused) {
                vc9Var.j(new JSONObject());
                tc9Var.y(101);
            }
            vc9Var.i(xc9.e(str));
            vc9Var.g(xc9.c(str));
            tc9 c = this.c.c(webView, vc9Var, tc9Var);
            if (c.g()) {
                this.c.d(webView, c);
                return false;
            }
            j(ea9.a(webView.getContext()), str, c);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
