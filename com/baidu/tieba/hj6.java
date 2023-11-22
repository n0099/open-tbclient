package com.baidu.tieba;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
/* loaded from: classes6.dex */
public interface hj6 {
    void a(WebView webView, String str);

    void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence);

    void c(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
