package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes5.dex */
public class bxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<cxa> a;
    public final jxa b;

    public bxa() {
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
        this.b = new jxa();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.clear();
        }
    }

    public void a(cxa cxaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, cxaVar) != null) || cxaVar == null) {
            return;
        }
        this.a.add(cxaVar);
        if (cxaVar.getClass().getAnnotation(ck.class) != null) {
            try {
                this.b.a((exa) Class.forName("com.baidu.tieba.h5power." + cxaVar.getClass().getSimpleName() + exa.PROXY_CLASS_NAME_SUFFIX).getConstructor(cxaVar.getClass()).newInstance(cxaVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                f(webView, str);
                return false;
            }
            return d(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, String str, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, gxaVar)) == null) {
            if (gxaVar == null || gxaVar.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            gxaVar.s(true);
            gxaVar.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        jxa jxaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) != null) || (jxaVar = this.b) == null) {
            return;
        }
        this.b.e(webView, jxaVar.f(webView, str, hashMap));
    }

    public boolean d(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return e(optString, optString2, optString3, jsPromptResult);
                }
                TbLog hybridLog2 = HybridLog.getInstance();
                hybridLog2.e("JsBridge", "processJSON fail interfaceName:" + optString + " methodName:" + optString2 + " params:" + optString3);
                return false;
            } catch (JSONException e) {
                TbLog hybridLog3 = HybridLog.getInstance();
                hybridLog3.e("JsBridge", "processJSON JSONException:" + e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void f(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, webView, str) != null) || this.b == null) {
            return;
        }
        TbLog hybridLog = HybridLog.getInstance();
        hybridLog.i("JsBridge", "processScheme scheme:" + str);
        ixa ixaVar = new ixa();
        gxa gxaVar = new gxa();
        String a = kxa.a(str);
        ixaVar.f(a);
        String d = kxa.d(str);
        ixaVar.h(d);
        String b = kxa.b(str);
        gxaVar.w(b);
        if (rd.isEmpty(a) || rd.isEmpty(d) || rd.isEmpty(b)) {
            gxaVar.z(101);
        }
        try {
            ixaVar.j(kxa.f(str));
        } catch (JSONException unused) {
            ixaVar.j(new JSONObject());
            gxaVar.z(101);
        }
        ixaVar.i(kxa.e(str));
        ixaVar.g(kxa.c(str));
        gxa c = this.b.c(ixaVar, gxaVar);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            g(sua.c(webView.getContext()), str, c);
        }
    }

    public final boolean e(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<cxa> it = this.a.iterator();
                while (it.hasNext()) {
                    cxa next = it.next();
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
}
