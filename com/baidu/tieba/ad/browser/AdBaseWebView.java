package com.baidu.tieba.ad.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class AdBaseWebView extends WebView {
    private b dht;
    private b dhu;
    private d dhv;
    private c dhw;
    private e dhx;
    private com.baidu.tieba.tbadkCore.e.c jsCallback;
    private Context mContext;
    private WebViewClient mWebViewClient;

    /* loaded from: classes3.dex */
    public interface b {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void b(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onReceivedError(WebView webView, int i, String str, String str2);
    }

    public AdBaseWebView(Context context) {
        super(context);
        this.dht = null;
        this.mContext = null;
        this.dhu = null;
        this.dhv = null;
        this.dhw = null;
        this.dhx = null;
        this.mContext = context;
        init();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.dhu == null) {
                initDownload();
            }
            setOnLoadUrlListener(this.dhu);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public AdBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dht = null;
        this.mContext = null;
        this.dhu = null;
        this.dhv = null;
        this.dhw = null;
        this.dhx = null;
        this.mContext = context;
        init();
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.jsCallback = cVar;
    }

    public void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion());
        com.baidu.tbadk.browser.a.WebViewNoDataBase(getSettings());
        this.mWebViewClient = new a();
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(new f());
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        setAcceptThirdPartyCookies(true);
    }

    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(getContext());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f extends WebChromeClient {
        private f() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((AdBaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.isActivityCanShowDialogOrPopupWindow((Activity) AdBaseWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((AdBaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.isActivityCanShowDialogOrPopupWindow((Activity) AdBaseWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((AdBaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.isActivityCanShowDialogOrPopupWindow((Activity) AdBaseWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (AdBaseWebView.this.jsCallback == null || !AdBaseWebView.this.jsCallback.onJsPrompt(str2, jsPromptResult)) {
                if ((AdBaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.isActivityCanShowDialogOrPopupWindow((Activity) AdBaseWebView.this.getContext())) {
                    return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (AdBaseWebView.this.dhv != null) {
                AdBaseWebView.this.dhv.b(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (AdBaseWebView.this.dhw != null) {
                AdBaseWebView.this.dhw.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AdBaseWebView.this.dht != null) {
                return AdBaseWebView.this.dht.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (AdBaseWebView.this.dhx != null) {
                AdBaseWebView.this.dhx.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"Override"})
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    public void setOnLoadUrlListener(b bVar) {
        this.dht = bVar;
    }

    public void setOnPageStartedListener(d dVar) {
        this.dhv = dVar;
    }

    public void setOnPageFinishedListener(c cVar) {
        this.dhw = cVar;
    }

    public void setOnReceivedErrorListener(e eVar) {
        this.dhx = eVar;
    }

    private void initDownload() {
        this.dhu = new b() { // from class: com.baidu.tieba.ad.browser.AdBaseWebView.1
            @Override // com.baidu.tieba.ad.browser.AdBaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    try {
                        com.baidu.tbadk.browser.a.startExternWebActivity(AdBaseWebView.this.mContext, str);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
                return true;
            }
        };
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.mWebViewClient = null;
        this.dht = null;
        this.mContext = null;
        this.dhu = null;
        this.dhv = null;
        this.dhw = null;
        this.dhx = null;
        this.jsCallback = null;
    }
}
