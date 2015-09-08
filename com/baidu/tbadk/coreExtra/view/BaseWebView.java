package com.baidu.tbadk.coreExtra.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private Context mContext;
    private b mDownloadListener;
    private b mOnLoadUrlListener;
    private c mOnPageFinishedListener;
    private d mOnPageStartedListener;
    private e mOnReceivedErrorListener;
    private WebViewClient mWebViewClient;

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

    public BaseWebView(Context context) {
        super(context);
        this.mOnLoadUrlListener = null;
        this.mContext = null;
        this.mDownloadListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mContext = context;
        init();
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

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnLoadUrlListener = null;
        this.mContext = null;
        this.mDownloadListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mContext = context;
        init();
    }

    public void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        com.baidu.tbadk.browser.g.WebViewNoDataBase(getSettings());
        this.mWebViewClient = new a();
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(new f(this, null));
        setOnLongClickListener(new com.baidu.tbadk.coreExtra.view.b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends WebChromeClient {
        private f() {
        }

        /* synthetic */ f(BaseWebView baseWebView, f fVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.j.k((Activity) BaseWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.j.k((Activity) BaseWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.j.k((Activity) BaseWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.g.j.k((Activity) BaseWebView.this.getContext())) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
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
            if (BaseWebView.this.mOnPageFinishedListener != null) {
                BaseWebView.this.mOnPageFinishedListener.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (BaseWebView.this.mOnLoadUrlListener != null) {
                return BaseWebView.this.mOnLoadUrlListener.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BaseWebView.this.mOnReceivedErrorListener != null) {
                BaseWebView.this.mOnReceivedErrorListener.onReceivedError(webView, i, str, str2);
            }
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

    public void resetProxy(int i) {
        CompatibleUtile.dealWebView(null);
    }

    private void initDownload() {
        this.mDownloadListener = new com.baidu.tbadk.coreExtra.view.c(this);
    }
}
