package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class f extends WebViewClient {
    final /* synthetic */ BaseWebView a;

    public f(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        i iVar;
        i iVar2;
        super.onPageStarted(webView, str, bitmap);
        iVar = this.a.e;
        if (iVar != null) {
            iVar2 = this.a.e;
            iVar2.c(webView, str);
        }
        Log.d("BaseWebView", "@onPageStarted = " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        h hVar;
        h hVar2;
        super.onPageFinished(webView, str);
        hVar = this.a.f;
        if (hVar != null) {
            hVar2 = this.a.f;
            hVar2.b(webView, str);
        }
        Log.d("BaseWebView", "@onPageFinished = " + str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        g gVar;
        g gVar2;
        gVar = this.a.b;
        if (gVar != null) {
            gVar2 = this.a.b;
            return gVar2.a(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
