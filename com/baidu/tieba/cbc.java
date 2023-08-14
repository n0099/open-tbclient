package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes5.dex */
public final class cbc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947670437, "Lcom/baidu/tieba/cbc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947670437, "Lcom/baidu/tieba/cbc;");
        }
    }

    @JvmStatic
    public static final void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, webView) == null) {
            if (webView != null) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
            }
            if (webView != null) {
                webView.removeJavascriptInterface("accessibility");
            }
            if (webView != null) {
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
        }
    }
}
