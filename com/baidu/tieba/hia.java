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
/* loaded from: classes6.dex */
public class hia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<iia> a;
    public final pia b;

    public hia() {
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
        this.b = new pia();
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

    public void a(iia iiaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, iiaVar) != null) || iiaVar == null) {
            return;
        }
        this.a.add(iiaVar);
        if (iiaVar.getClass().getAnnotation(oo.class) != null) {
            try {
                this.b.a((kia) Class.forName("com.baidu.tieba.h5power." + iiaVar.getClass().getSimpleName() + kia.PROXY_CLASS_NAME_SUFFIX).getConstructor(iiaVar.getClass()).newInstance(iiaVar));
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

    public final boolean g(TbPageContext<?> tbPageContext, String str, mia miaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, miaVar)) == null) {
            if (miaVar == null || miaVar.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            miaVar.s(true);
            miaVar.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        pia piaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) != null) || (piaVar = this.b) == null) {
            return;
        }
        this.b.e(webView, piaVar.f(webView, str, hashMap));
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
        oia oiaVar = new oia();
        mia miaVar = new mia();
        String a = qia.a(str);
        oiaVar.f(a);
        String d = qia.d(str);
        oiaVar.h(d);
        String b = qia.b(str);
        miaVar.w(b);
        if (ei.isEmpty(a) || ei.isEmpty(d) || ei.isEmpty(b)) {
            miaVar.z(101);
        }
        try {
            oiaVar.j(qia.f(str));
        } catch (JSONException unused) {
            oiaVar.j(new JSONObject());
            miaVar.z(101);
        }
        oiaVar.i(qia.e(str));
        oiaVar.g(qia.c(str));
        mia c = this.b.c(oiaVar, miaVar);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            g(xfa.c(webView.getContext()), str, c);
        }
    }

    public final boolean e(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<iia> it = this.a.iterator();
                while (it.hasNext()) {
                    iia next = it.next();
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
