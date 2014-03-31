package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public final class e extends WebViewClient {
    final /* synthetic */ BaseWebView a;

    public e(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        h hVar;
        h hVar2;
        super.onPageStarted(webView, str, bitmap);
        hVar = this.a.e;
        if (hVar != null) {
            hVar2 = this.a.e;
            hVar2.b();
        }
        Log.d("BaseWebView", "@onPageStarted = " + str);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        g gVar;
        g gVar2;
        super.onPageFinished(webView, str);
        gVar = this.a.f;
        if (gVar != null) {
            gVar2 = this.a.f;
            gVar2.a();
        }
        Log.d("BaseWebView", "@onPageFinished = " + str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        f fVar;
        f fVar2;
        fVar = this.a.b;
        if (fVar != null) {
            fVar2 = this.a.b;
            return fVar2.a(str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
