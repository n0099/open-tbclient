package com.baidu.tieba.enterForum.forumtest.js;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes21.dex */
public class ForumTestWebView extends WebView {
    private g ijQ;
    private b ijR;
    private d ijS;
    private c ijT;
    private e ijU;
    private f ijV;
    protected com.baidu.tieba.enterForum.forumtest.js.a ijW;
    private com.baidu.tieba.enterForum.forumtest.js.c ijX;
    private WebViewClient mWebViewClient;

    /* loaded from: classes21.dex */
    public interface b {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes21.dex */
    public interface c {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes21.dex */
    public interface d {
        void onPageStarted(WebView webView, String str);
    }

    /* loaded from: classes21.dex */
    public interface e {
        void onProgressChanged(WebView webView, int i);
    }

    /* loaded from: classes21.dex */
    public interface f {
        void iJ(String str);
    }

    public ForumTestWebView(Context context) {
        super(context);
        this.ijX = new com.baidu.tieba.enterForum.forumtest.js.c() { // from class: com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView.1
            @Override // com.baidu.tieba.enterForum.forumtest.js.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (ForumTestWebView.this.ijW != null) {
                    return ForumTestWebView.this.ijW.a(str, jsPromptResult);
                }
                return false;
            }
        };
    }

    public ForumTestWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ijX = new com.baidu.tieba.enterForum.forumtest.js.c() { // from class: com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView.1
            @Override // com.baidu.tieba.enterForum.forumtest.js.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (ForumTestWebView.this.ijW != null) {
                    return ForumTestWebView.this.ijW.a(str, jsPromptResult);
                }
                return false;
            }
        };
    }

    public ForumTestWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ijX = new com.baidu.tieba.enterForum.forumtest.js.c() { // from class: com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView.1
            @Override // com.baidu.tieba.enterForum.forumtest.js.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (ForumTestWebView.this.ijW != null) {
                    return ForumTestWebView.this.ijW.a(str, jsPromptResult);
                }
                return false;
            }
        };
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(com.baidu.tieba.enterForum.forumtest.js.b bVar) {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setCacheMode(2);
        getSettings().setDatabasePath(getContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setInitialScale(100);
        setScrollBarStyle(33554432);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion());
        this.mWebViewClient = new a();
        setWebViewClient(this.mWebViewClient);
        this.ijQ = new g();
        setWebChromeClient(this.ijQ);
        this.ijW = new com.baidu.tieba.enterForum.forumtest.js.a();
        this.ijW.b(bVar);
        com.baidu.tbadk.browser.a.initCookie(getContext());
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        if (Build.VERSION.SDK_INT >= 21) {
            setAcceptThirdPartyCookies(true);
            getSettings().setMixedContentMode(0);
        }
    }

    @TargetApi(21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager = null;
        try {
            CookieSyncManager.createInstance(getContext());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
        }
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, z);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.mWebViewClient = null;
        this.ijQ = null;
        this.ijR = null;
        this.ijS = null;
        this.ijT = null;
        this.ijU = null;
        this.ijV = null;
        this.ijX = null;
    }

    /* loaded from: classes21.dex */
    private class g extends WebChromeClient {
        private g() {
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            quotaUpdater.updateQuota(2 * j2);
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(ForumTestWebView.this.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.f.g.isActivityCanShowDialogOrPopupWindow((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.f.g.isActivityCanShowDialogOrPopupWindow((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && com.baidu.adp.lib.f.g.isActivityCanShowDialogOrPopupWindow((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (ForumTestWebView.this.ijX == null || !ForumTestWebView.this.ijX.onJsPrompt(str2, jsPromptResult)) {
                jsPromptResult.cancel();
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (ForumTestWebView.this.ijU != null) {
                ForumTestWebView.this.ijU.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (ForumTestWebView.this.ijV != null) {
                ForumTestWebView.this.ijV.iJ(str);
            }
        }
    }

    /* loaded from: classes21.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (ForumTestWebView.this.ijS != null) {
                ForumTestWebView.this.ijS.onPageStarted(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (ForumTestWebView.this.ijT != null) {
                ForumTestWebView.this.ijT.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return ForumTestWebView.this.ijR != null ? ForumTestWebView.this.ijR.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
