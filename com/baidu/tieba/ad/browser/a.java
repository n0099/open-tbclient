package com.baidu.tieba.ad.browser;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
/* loaded from: classes3.dex */
final class a extends AdBaseWebView {
    public WebChromeClient chromeClient;
    public WebViewClient webViewClient;

    public a(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }
}
