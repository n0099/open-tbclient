package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes4.dex */
public final class g9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947750138, "Lcom/baidu/tieba/g9a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947750138, "Lcom/baidu/tieba/g9a;");
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
