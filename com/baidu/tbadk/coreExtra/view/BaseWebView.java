package com.baidu.tbadk.coreExtra.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.hybrid.HybridManager;
import com.baidu.tbadk.coreExtra.data.WebCacheWhiteListData;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private boolean isUrlHitCache;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private com.baidu.tieba.tbadkCore.e.c jsCallback;
    private Context mContext;
    private b mDownloadListener;
    private boolean mIsLoaded;
    private b mOnLoadUrlListener;
    private c mOnPageFinishedListener;
    private d mOnPageStartedListener;
    private e mOnReceivedErrorListener;
    private f mOnReceivedSslErrorListener;
    private g mWebChromeClient;
    private WebViewClient mWebViewClient;
    private WebCacheWhiteListData webCacheData;

    /* loaded from: classes.dex */
    public interface b {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(WebView webView, String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onReceivedError(WebView webView, int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    public BaseWebView(Context context) {
        super(context);
        this.mContext = null;
        this.mIsLoaded = false;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.isUrlHitCache = false;
        this.jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tbadk.coreExtra.view.BaseWebView.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (BaseWebView.this.jsBridge != null) {
                    return BaseWebView.this.jsBridge.b(str, jsPromptResult);
                }
                return false;
            }
        };
        this.mContext = context;
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mIsLoaded = false;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.isUrlHitCache = false;
        this.jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tbadk.coreExtra.view.BaseWebView.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (BaseWebView.this.jsBridge != null) {
                    return BaseWebView.this.jsBridge.b(str, jsPromptResult);
                }
                return false;
            }
        };
        this.mContext = context;
        init();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!str.contains("javascript:")) {
            this.isUrlHitCache = isUrlMatchWhiteList(str);
        }
        super.loadUrl(fixStaticsParam(str));
    }

    private boolean isUrlMatchWhiteList(String str) {
        if (StringUtils.isNull(str) || this.webCacheData == null) {
            return false;
        }
        return this.webCacheData.checkUrl(str);
    }

    private String fixStaticsParam(String str) {
        if ((str == null || !str.contains("tieba.baidu.com/n")) && !str.contains("tiebac.baidu.com/n")) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + "_webview_time=" + System.currentTimeMillis();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.mDownloadListener == null) {
                initDownload();
            }
            setOnLoadUrlListener(this.mDownloadListener);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public void setOnJsPromptCallback(com.baidu.tieba.tbadkCore.e.c cVar) {
        this.jsCallback = cVar;
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion());
        com.baidu.tbadk.browser.a.WebViewNoDataBase(getSettings());
        this.mWebViewClient = new a();
        this.mWebChromeClient = new g();
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.mWebChromeClient);
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
        com.baidu.tbadk.browser.a.ar(getContext());
        this.webCacheData = WebCacheWhiteListData.createBySP();
    }

    public void initCommonJsBridge(TbPageContext tbPageContext) {
        this.jsBridge.a(new com.baidu.tbadk.browser.b(tbPageContext));
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends WebChromeClient {
        private g() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.m((Activity) BaseWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.m((Activity) BaseWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.g.m((Activity) BaseWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (BaseWebView.this.jsCallback == null || BaseWebView.this.jsCallback.onJsPrompt(str2, jsPromptResult)) {
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (BaseWebView.this.mOnPageStartedListener != null) {
                BaseWebView.this.mOnPageStartedListener.a(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            BaseWebView.this.mIsLoaded = true;
            if (BaseWebView.this.mOnPageFinishedListener != null) {
                BaseWebView.this.mOnPageFinishedListener.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return BaseWebView.this.mOnLoadUrlListener != null ? BaseWebView.this.mOnLoadUrlListener.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BaseWebView.this.mOnReceivedErrorListener != null) {
                BaseWebView.this.mOnReceivedErrorListener.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"Override"})
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
            if (BaseWebView.this.mOnReceivedSslErrorListener != null) {
                BaseWebView.this.mOnReceivedSslErrorListener.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest;
            return (!BaseWebView.this.isUrlHitCache || (shouldInterceptRequest = HybridManager.tM().shouldInterceptRequest(webView, str)) == null) ? super.shouldInterceptRequest(webView, str) : shouldInterceptRequest;
        }
    }

    public void setOnLoadUrlListener(b bVar) {
        this.mOnLoadUrlListener = bVar;
    }

    public void setOnPageStartedListener(d dVar) {
        this.mOnPageStartedListener = dVar;
    }

    public void setOnPageFinishedListener(c cVar) {
        this.mOnPageFinishedListener = cVar;
    }

    public void setOnReceivedErrorListener(e eVar) {
        this.mOnReceivedErrorListener = eVar;
    }

    public void setOnReceivedSslErrorListener(f fVar) {
        this.mOnReceivedSslErrorListener = fVar;
    }

    public void resetProxy(int i) {
        CompatibleUtile.dealWebView(null);
    }

    private void initDownload() {
        this.mDownloadListener = new b() { // from class: com.baidu.tbadk.coreExtra.view.BaseWebView.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    try {
                        com.baidu.tbadk.browser.a.V(BaseWebView.this.mContext, str);
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
        this.mContext = null;
        this.mWebViewClient = null;
        this.mWebChromeClient = null;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.jsCallback = null;
    }

    public boolean getIsLoaded() {
        return this.mIsLoaded;
    }
}
