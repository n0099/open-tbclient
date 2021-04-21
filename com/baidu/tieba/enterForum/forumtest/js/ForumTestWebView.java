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
import com.baidu.tbadk.TbConfig;
import com.baidubce.auth.NTLMEngineImpl;
/* loaded from: classes4.dex */
public class ForumTestWebView extends WebView {

    /* renamed from: e  reason: collision with root package name */
    public WebViewClient f15055e;

    /* renamed from: f  reason: collision with root package name */
    public h f15056f;

    /* renamed from: g  reason: collision with root package name */
    public c f15057g;

    /* renamed from: h  reason: collision with root package name */
    public e f15058h;
    public d i;
    public f j;
    public g k;
    public d.b.j0.i0.e.a.a l;
    public d.b.j0.i0.e.a.c m;

    /* loaded from: classes4.dex */
    public class a implements d.b.j0.i0.e.a.c {
        public a() {
        }

        @Override // d.b.j0.i0.e.a.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            d.b.j0.i0.e.a.a aVar = ForumTestWebView.this.l;
            if (aVar != null) {
                return aVar.b(str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (ForumTestWebView.this.i != null) {
                ForumTestWebView.this.i.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (ForumTestWebView.this.f15058h != null) {
                ForumTestWebView.this.f15058h.a(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (ForumTestWebView.this.f15057g != null) {
                return ForumTestWebView.this.f15057g.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(WebView webView, String str);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(WebView webView, int i);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(String str);
    }

    /* loaded from: classes4.dex */
    public class h extends WebChromeClient {
        public h() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(ForumTestWebView.this.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            quotaUpdater.updateQuota(j2 * 2);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((ForumTestWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) ForumTestWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (ForumTestWebView.this.m == null || !ForumTestWebView.this.m.onJsPrompt(str2, jsPromptResult)) {
                jsPromptResult.cancel();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (ForumTestWebView.this.j != null) {
                ForumTestWebView.this.j.a(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (ForumTestWebView.this.k != null) {
                ForumTestWebView.this.k.a(str);
            }
        }

        public /* synthetic */ h(ForumTestWebView forumTestWebView, a aVar) {
            this();
        }
    }

    public ForumTestWebView(Context context) {
        super(context);
        this.m = new a();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.f15055e = null;
        this.f15056f = null;
        this.f15057g = null;
        this.f15058h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void g(d.b.j0.i0.e.a.b bVar) {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setCacheMode(2);
        getSettings().setDatabasePath(getContext().getDir("databases", 0).getAbsolutePath());
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setInitialScale(100);
        setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion());
        WebViewClient bVar2 = new b();
        this.f15055e = bVar2;
        setWebViewClient(bVar2);
        h hVar = new h(this, null);
        this.f15056f = hVar;
        setWebChromeClient(hVar);
        d.b.j0.i0.e.a.a aVar = new d.b.j0.i0.e.a.a();
        this.l = aVar;
        aVar.a(bVar);
        d.b.i0.l.a.f(getContext());
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
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(getContext());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable unused) {
            cookieManager = null;
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

    public ForumTestWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new a();
    }

    public ForumTestWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new a();
    }
}
