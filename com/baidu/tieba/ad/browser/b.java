package com.baidu.tieba.ad.browser;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.g;
/* loaded from: classes21.dex */
class b extends WebChromeClient {
    private com.baidu.tieba.tbadkCore.e.c callback;
    private AdTbWebViewActivity fLW;

    public b(AdTbWebViewActivity adTbWebViewActivity) {
        this.fLW = adTbWebViewActivity;
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.callback = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(2 * j2);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.fLW.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.fLW.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.fLW.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        this.fLW.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.fLW.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.fLW.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.fLW.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fLW == null || !g.a(this.fLW.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fLW == null || !g.a(this.fLW.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fLW == null || !g.a(this.fLW.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ((this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) && this.fLW != null && g.a(this.fLW.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}
