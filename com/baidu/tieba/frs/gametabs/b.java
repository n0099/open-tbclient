package com.baidu.tieba.frs.gametabs;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.g;
/* loaded from: classes7.dex */
public class b extends WebChromeClient {
    private com.baidu.adp.base.e cRA;
    private com.baidu.tieba.tbadkCore.e.c callback;

    public b(com.baidu.adp.base.e eVar) {
        this.cRA = eVar;
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
        FrameLayout frameLayout = new FrameLayout(this.cRA.getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.cRA == null || !g.a(this.cRA)) {
            return true;
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.cRA == null || !g.a(this.cRA)) {
            return true;
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.cRA == null || !g.a(this.cRA)) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ((this.callback == null || !this.callback.onJsPrompt(str2, jsPromptResult)) && this.cRA != null && g.a(this.cRA)) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }
}
