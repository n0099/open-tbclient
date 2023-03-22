package com.baidu.tieba.browser.core.webview.bridge;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.OfflinePkgAutoCleanSwitch;
import com.baidu.tieba.browser.core.webview.bridge.BridgeWebChromeClient;
import com.baidu.tieba.bsa;
import com.baidu.tieba.de6;
import com.baidu.tieba.fsa;
import com.baidu.tieba.kd6;
import com.baidu.tieba.lg;
import com.baidu.tieba.mc6;
import com.baidu.tieba.pc6;
import com.baidu.tieba.pd6;
import com.baidu.tieba.rc6;
import com.baidu.tieba.vc6;
import com.baidu.tieba.vd6;
import com.baidu.tieba.zc6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class BridgeWebChromeClient extends de6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean b;
    @NonNull
    public final fsa<String> c;
    @NonNull
    public final bsa d;
    public final Set<String> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1244169312, "Lcom/baidu/tieba/browser/core/webview/bridge/BridgeWebChromeClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1244169312, "Lcom/baidu/tieba/browser/core/webview/bridge/BridgeWebChromeClient;");
                return;
            }
        }
        f = new HashSet<String>() { // from class: com.baidu.tieba.browser.core.webview.bridge.BridgeWebChromeClient.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("Uncaught SyntaxError: Invalid or unexpected token");
                add("Uncaught SyntaxError: Unexpected end of input");
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeWebChromeClient(final fsa<String> fsaVar, final bsa bsaVar) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fsaVar, bsaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((WebChromeClient) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = OfflinePkgAutoCleanSwitch.isOn();
        this.e = new HashSet();
        this.d = new bsa() { // from class: com.baidu.tieba.ob6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bsa
            public final void call() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BridgeWebChromeClient.d(bsa.this);
                }
            }
        };
        this.c = new fsa() { // from class: com.baidu.tieba.pb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.fsa
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BridgeWebChromeClient.e(fsa.this) : invokeV.objValue;
            }
        };
    }

    public static /* synthetic */ void d(bsa bsaVar) {
        if (bsaVar != null) {
            bsaVar.call();
        }
    }

    public static /* synthetic */ String e(fsa fsaVar) {
        if (fsaVar != null) {
            return (String) fsaVar.call();
        }
        return null;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        vc6 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (URLUtil.isFileUrl(str)) {
                String str2 = "file://" + mc6.g + "bdtbNWCache/";
                if (str.startsWith(str2)) {
                    String[] split = str.substring(str2.length()).split("/");
                    if (!vd6.d(split)) {
                        return split[0];
                    }
                    return null;
                }
                return null;
            } else if (URLUtil.isNetworkUrl(str)) {
                String call = this.c.call();
                if (!TextUtils.isEmpty(call) && (c = pc6.b().c(call)) != null) {
                    return c.c;
                }
                return null;
            } else {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.de6, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consoleMessage)) == null) {
            if (this.b && consoleMessage != null && f.contains(consoleMessage.message())) {
                String sourceId = consoleMessage.sourceId();
                String c = c(sourceId);
                pd6.b("lt-log", "module = " + c + ",资源检查异常！");
                if (!TextUtils.isEmpty(c)) {
                    rc6.a(c);
                    if (!this.e.contains(sourceId)) {
                        this.e.add(sourceId);
                        this.d.call();
                    }
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.de6, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
            if (lg.e(zc6.a(webView.getContext()))) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.de6, android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            if (lg.e(zc6.a(webView.getContext()))) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.de6, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            if (lg.e(zc6.a(webView.getContext()))) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.de6, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (kd6.a().c(webView, str2, jsPromptResult)) {
                pd6.b("lt-log", "端能力执行失败：" + str2 + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                return true;
            }
            pd6.c("lt-log", "端能力执行成功：" + str2 + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
