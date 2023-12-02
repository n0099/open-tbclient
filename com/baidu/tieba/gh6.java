package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.exception.JsInterfaceException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gh6 implements oj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<qj6> b;
    public final hh6 c;

    public gh6() {
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
        this.c = new hh6();
    }

    @Override // com.baidu.tieba.oj6
    public void a(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.c.g(list);
        }
    }

    @Override // com.baidu.tieba.oj6
    public void b(String str, HashMap<String, Object> hashMap) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) {
            for (WeakReference<WebView> weakReference : sj6.b().a()) {
                if (weakReference != null && (webView = weakReference.get()) != null) {
                    try {
                        d(webView, str, hashMap);
                    } catch (JsInterfaceException e) {
                        BdLog.e(e, true);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.oj6
    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            if (sh6.isOn()) {
                l(str, str, webView.getUrl());
            }
            if (str.startsWith("tiebaapp")) {
                if (jsPromptResult != null) {
                    jsPromptResult.cancel();
                }
                return o(webView, str);
            }
            boolean n = n(webView, str, jsPromptResult);
            if (!n) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", com.baidu.mobads.sdk.internal.a.g).param("obj_source", str));
            }
            return n;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.oj6
    public void d(View view2, String str, @Nullable HashMap<String, Object> hashMap) {
        WebView webView;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view2, str, hashMap) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (view2 instanceof WebView) {
                webView = (WebView) view2;
            } else if (view2 instanceof TbWebView) {
                webView = ((TbWebView) view2).getInnerWebView();
            } else {
                webView = null;
            }
            if (webView != null) {
                m(webView.getUrl(), str, str);
                List<fxa> h = this.c.h(webView, str, hashMap);
                boolean f = this.c.f(webView, h);
                boolean z2 = false;
                if (!ListUtils.isEmpty(h)) {
                    loop0: while (true) {
                        z = false;
                        for (fxa fxaVar : h) {
                            if (fxaVar != null && fxaVar.k()) {
                                if (fxaVar.j || z) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z2 = z;
                }
                if (!z2) {
                    if (f && !ListUtils.isEmpty(h)) {
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.i("JsBridge", "通知类型端能力 执行成功 " + str + " 耗时=" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } else if (ListUtils.isEmpty(h)) {
                        TbLog hybridLog2 = HybridLog.getInstance();
                        hybridLog2.e("JsBridge", "通知类型端能力 执行失败-没有注册对应的监听 " + str + " 耗时=" + (System.currentTimeMillis() - currentTimeMillis) + " " + webView.getUrl());
                        return;
                    } else {
                        TbLog hybridLog3 = HybridLog.getInstance();
                        hybridLog3.e("JsBridge", "通知类型端能力 执行失败-js执行失败" + str + " " + webView + " 耗时=" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                }
                return;
            }
            TbLog hybridLog4 = HybridLog.getInstance();
            hybridLog4.e("JsBridge", "端能力 执行失败 view类型不匹配！" + view2);
        }
    }

    @Override // com.baidu.tieba.oj6
    public void e(View view2, String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, view2, str, valueCallback) == null) && !TextUtils.isEmpty(str)) {
            if (view2 instanceof WebView) {
                ((WebView) view2).evaluateJavascript(str, valueCallback);
            } else if (view2 instanceof TbWebView) {
                ((TbWebView) view2).v(str, valueCallback);
            }
        }
    }

    @Override // com.baidu.tieba.oj6
    public void i(View view2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, str, jSONObject) == null) {
            j(view2, str, jSONObject, null);
        }
    }

    public final void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("js_call_native");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("native_call_js");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean p(TbPageContext<?> tbPageContext, String str, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, tbPageContext, str, fxaVar)) == null) {
            if (fxaVar == null || fxaVar.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            fxaVar.s(true);
            fxaVar.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.oj6
    public void f(qj6 qj6Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, qj6Var, obj) == null) && (obj instanceof dxa)) {
            this.b.add(qj6Var);
            this.c.a((dxa) obj);
        }
    }

    @Override // com.baidu.tieba.oj6
    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, jSONObject) == null) {
            g(str, jSONObject, null);
        }
    }

    @Override // com.baidu.tieba.oj6
    public void g(String str, JSONObject jSONObject, WebView webView) {
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, jSONObject, webView) == null) {
            for (WeakReference<WebView> weakReference : sj6.b().a()) {
                if (weakReference != null && (webView2 = weakReference.get()) != null) {
                    j(webView2, str, jSONObject, webView);
                }
            }
        }
    }

    public void j(View view2, String str, JSONObject jSONObject, WebView webView) {
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, view2, str, jSONObject, webView) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("双向通信通知H5:");
            sb.append(str);
            if (view2 instanceof WebView) {
                webView2 = (WebView) view2;
            } else if (view2 instanceof TbWebView) {
                webView2 = ((TbWebView) view2).getInnerWebView();
            } else {
                webView2 = null;
            }
            if (webView2 == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("data", jSONObject);
                if (webView != null) {
                    jSONObject2.put("sourceWebviewId", webView.toString());
                }
                this.c.b(webView2, jSONObject2.toString());
            } catch (Exception e) {
                sb.append(" 执行异常:");
                sb.append(e);
            }
            sb.append(" 执行耗时=");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" webView：");
            sb.append(webView2);
            HybridLog.getInstance().i("JsBridge", sb.toString());
        }
    }

    public final boolean k(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<qj6> it = this.b.iterator();
            while (it.hasNext()) {
                qj6 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean n(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, webView, str, jsPromptResult)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("旧版端能力");
            try {
                JSONObject jSONObject = new JSONObject(str);
                z = k(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString("param", ""), jsPromptResult);
            } catch (JSONException e) {
                sb.append(" 旧版端能力异常:");
                sb.append(e);
            }
            sb.append(" 执行耗时=");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" json:");
            sb.append(str);
            sb.append(" webview:");
            sb.append(webView);
            HybridLog.getInstance().i("JsBridge", sb.toString());
            return z;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean o(WebView webView, String str) {
        InterceptResult invokeLL;
        boolean p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, webView, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("新版端能力");
            hxa hxaVar = new hxa();
            String a = jxa.a(str);
            String d = jxa.d(str);
            String b = jxa.b(str);
            hxaVar.f(a);
            hxaVar.h(d);
            fxa fxaVar = new fxa();
            fxaVar.w(b);
            if (rd.isEmpty(a) || rd.isEmpty(d) || rd.isEmpty(b)) {
                fxaVar.z(101);
            }
            try {
                hxaVar.j(jxa.f(str));
            } catch (JSONException unused) {
                hxaVar.j(new JSONObject());
                fxaVar.z(101);
            }
            hxaVar.i(jxa.e(str));
            hxaVar.g(jxa.c(str));
            fxa d2 = this.c.d(webView, hxaVar, fxaVar);
            long currentTimeMillis2 = System.currentTimeMillis();
            sb.append(" 执行耗时=");
            sb.append(currentTimeMillis2 - currentTimeMillis);
            if (d2.g()) {
                p = this.c.e(webView, d2);
                sb.append(" 同步返回H5耗时=");
            } else {
                p = p(rua.c(webView.getContext()), str, d2);
                sb.append(" 无返回，尝试作为通用scheme处理:");
            }
            sb.append(System.currentTimeMillis() - currentTimeMillis2);
            sb.append(" 执行结束，总耗时=");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" scheme:");
            sb.append(str);
            sb.append(" webView:");
            sb.append(webView);
            if (!d2.j) {
                HybridLog.getInstance().i("JsBridge", sb.toString());
            }
            return p;
        }
        return invokeLL.booleanValue;
    }
}
