package com.baidu.tieba.ad.browser;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
/* loaded from: classes6.dex */
final class AdBridgeWebView extends AdBaseWebView {
    public WebChromeClient chromeClient;
    public WebViewClient webViewClient;

    public AdBridgeWebView(Context context) {
        super(context);
    }

    public AdBridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
