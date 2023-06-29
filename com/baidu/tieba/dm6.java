package com.baidu.tieba;

import android.util.Log;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* compiled from: JsPromptInterface.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class dm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(em6 em6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, em6Var) == null) {
        }
    }

    public static void a(em6 em6Var, WebView webView, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, em6Var, webView, str, jSONObject) != null) || webView == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
        StringBuilder sb = new StringBuilder();
        sb.append("javascript 执行成功:");
        sb.append(str);
        sb.append(" 耗时：");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        Log.i("newHybrid", sb.toString());
    }
}
