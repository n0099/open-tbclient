package com.baidu.tieba;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
/* loaded from: classes5.dex */
public interface ak6 {
    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
}
