package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes4.dex */
public final class h66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(WebView webView, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, webView, list) == null) {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("setSafeBrowsingWhitelist", List.class, ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(webView, list, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @SuppressLint({"WebViewApiAvailability"})
    public static void b(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, webView) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i == 26) {
                webView.setImportantForAutofill(2);
                webView.getSettings().setSafeBrowsingEnabled(false);
            } else if (i >= 27) {
                List<String> a = g56.a();
                try {
                    WebView.setSafeBrowsingWhitelist(a, null);
                } catch (Throwable unused) {
                    a(webView, a);
                }
            }
        }
    }
}
