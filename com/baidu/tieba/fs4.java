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
/* loaded from: classes6.dex */
public class fs4 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cxa a;

    public fs4() {
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
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, str2) == null) && webView != null && !rd.isEmpty(str) && !rd.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "('" + str2 + "')");
        }
    }

    public void b(cxa cxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cxaVar) == null) {
            this.a = cxaVar;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        cxa cxaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!c95.a(str) && str2.startsWith("tiebaapp")) {
                fxa fxaVar = new fxa();
                fxaVar.w(jxa.b(str2));
                fxaVar.y(301);
                a(webView, fxaVar.c(), fxaVar.d());
            }
            if ((!c95.a(str) || (cxaVar = this.a) == null || !cxaVar.onJsPrompt(str2, jsPromptResult)) && jsPromptResult != null) {
                jsPromptResult.cancel();
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
