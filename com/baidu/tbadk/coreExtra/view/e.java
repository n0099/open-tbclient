package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class e extends WebViewClient {
    final /* synthetic */ BaseWebView TP;

    public e(BaseWebView baseWebView) {
        this.TP = baseWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        h hVar;
        h hVar2;
        super.onPageStarted(webView, str, bitmap);
        hVar = this.TP.mOnPageStartedListener;
        if (hVar != null) {
            hVar2 = this.TP.mOnPageStartedListener;
            hVar2.a(webView, str);
        }
        Log.d("BaseWebView", "@onPageStarted = " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        g gVar;
        g gVar2;
        super.onPageFinished(webView, str);
        gVar = this.TP.mOnPageFinishedListener;
        if (gVar != null) {
            gVar2 = this.TP.mOnPageFinishedListener;
            gVar2.onPageFinished(webView, str);
        }
        Log.d("BaseWebView", "@onPageFinished = " + str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        f fVar;
        f fVar2;
        fVar = this.TP.mOnLoadUrlListener;
        if (fVar != null) {
            fVar2 = this.TP.mOnLoadUrlListener;
            return fVar2.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
