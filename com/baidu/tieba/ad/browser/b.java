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
    private AdTbWebViewActivity fZD;

    public b(AdTbWebViewActivity adTbWebViewActivity) {
        this.fZD = adTbWebViewActivity;
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
        FrameLayout frameLayout = new FrameLayout(this.fZD.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.fZD.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.fZD.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        this.fZD.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.fZD.startActivityForResult(Intent.createChooser(intent, "File Browser"), 1);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.fZD.setUploadMessage(valueCallback);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.fZD.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fZD == null || !g.a(this.fZD.getPageContext())) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fZD == null || !g.a(this.fZD.getPageContext())) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.fZD == null || !g.a(this.fZD.getPageContext())) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ((this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) && this.fZD != null && g.a(this.fZD.getPageContext())) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}
