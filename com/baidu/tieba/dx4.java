package com.baidu.tieba;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dx4 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jia a;

    public dx4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, str2) == null) && webView != null && !ei.isEmpty(str) && !ei.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "('" + str2 + "')");
        }
    }

    public void b(jia jiaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jiaVar) == null) {
            this.a = jiaVar;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        jia jiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!md5.a(str) && str2.startsWith("tiebaapp")) {
                mia miaVar = new mia();
                miaVar.w(qia.b(str2));
                miaVar.y(301);
                a(webView, miaVar.c(), miaVar.d());
            }
            if ((!md5.a(str) || (jiaVar = this.a) == null || !jiaVar.onJsPrompt(str2, jsPromptResult)) && jsPromptResult != null) {
                jsPromptResult.cancel();
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
