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
public class bs4 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ksa a;

    public bs4() {
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
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, str2) == null) && webView != null && !qd.isEmpty(str) && !qd.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "('" + str2 + "')");
        }
    }

    public void b(ksa ksaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksaVar) == null) {
            this.a = ksaVar;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        ksa ksaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!s85.a(str) && str2.startsWith("tiebaapp")) {
                nsa nsaVar = new nsa();
                nsaVar.w(rsa.b(str2));
                nsaVar.y(301);
                a(webView, nsaVar.c(), nsaVar.d());
            }
            if ((!s85.a(str) || (ksaVar = this.a) == null || !ksaVar.onJsPrompt(str2, jsPromptResult)) && jsPromptResult != null) {
                jsPromptResult.cancel();
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
