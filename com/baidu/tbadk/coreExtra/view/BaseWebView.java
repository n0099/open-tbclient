package com.baidu.tbadk.coreExtra.view;

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
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class BaseWebView extends WebView {
    public d.b.i0.d3.l0.c jsCallback;
    public CommonTbJsBridge mCommonJsBridge;
    public Context mContext;
    public d mDownloadListener;
    public boolean mIsLoaded;
    public d.b.i0.d3.l0.a mJsBridge;
    public d mOnLoadUrlListener;
    public e mOnPageFinishedListener;
    public f mOnPageStartedListener;
    public g mOnProgressChangedListener;
    public h mOnReceivedErrorListener;
    public i mOnReceivedSslErrorListener;
    public j mWebChromeClient;
    public WebViewClient mWebViewClient;

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.d3.l0.c {
        public a() {
        }

        @Override // d.b.i0.d3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            BaseWebView baseWebView = BaseWebView.this;
            d.b.i0.d3.l0.a aVar = baseWebView.mJsBridge;
            if (aVar != null) {
                return aVar.b(baseWebView.getWebView(), str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return true;
            }
            try {
                d.b.h0.l.a.j(BaseWebView.this.mContext, str);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends WebViewClient {
        public c() {
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
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (BaseWebView.this.mOnPageStartedListener != null) {
                BaseWebView.this.mOnPageStartedListener.a(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BaseWebView.this.mOnReceivedErrorListener != null) {
                BaseWebView.this.mOnReceivedErrorListener.a(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"Override"})
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
            if (BaseWebView.this.mOnReceivedSslErrorListener != null) {
                BaseWebView.this.mOnReceivedSslErrorListener.a(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (BaseWebView.this.mOnLoadUrlListener != null) {
                return BaseWebView.this.mOnLoadUrlListener.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(WebView webView, int i);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(WebView webView, int i, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    /* loaded from: classes3.dex */
    public class j extends WebChromeClient {
        public j() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) BaseWebView.this.getContext())) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) BaseWebView.this.getContext())) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if ((BaseWebView.this.getContext() instanceof Activity) && d.b.c.e.m.g.e((Activity) BaseWebView.this.getContext())) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (BaseWebView.this.jsCallback == null || !BaseWebView.this.jsCallback.onJsPrompt(str2, jsPromptResult)) {
                jsPromptResult.cancel();
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (BaseWebView.this.mOnProgressChangedListener != null) {
                BaseWebView.this.mOnProgressChangedListener.a(webView, i);
            }
        }

        public /* synthetic */ j(BaseWebView baseWebView, a aVar) {
            this();
        }
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
        this.mOnProgressChangedListener = null;
        this.jsCallback = new a();
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseWebView getWebView() {
        return this;
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        getSettings().setUseWideViewPort(true);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion() + " skin/" + SkinManager.getCurrentSkinTypeString());
        d.b.h0.l.a.a(getSettings());
        this.mWebViewClient = new c();
        this.mWebChromeClient = new j(this, null);
        this.mJsBridge = new d.b.i0.d3.l0.a();
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.mWebChromeClient);
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        d.b.h0.l.a.f(getContext());
        if (Build.VERSION.SDK_INT >= 21) {
            setAcceptThirdPartyCookies(true);
            getSettings().setMixedContentMode(0);
        }
    }

    private void initDownload() {
        this.mDownloadListener = new b();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        CommonTbJsBridge commonTbJsBridge = this.mCommonJsBridge;
        if (commonTbJsBridge != null) {
            commonTbJsBridge.onDestroy();
        }
        this.mContext = null;
        this.mWebViewClient = null;
        this.mWebChromeClient = null;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.jsCallback = null;
    }

    public boolean getIsLoaded() {
        return this.mIsLoaded;
    }

    public void initCommonJsBridge(Context context) {
        CommonTbJsBridge commonTbJsBridge = new CommonTbJsBridge(context, this);
        this.mCommonJsBridge = commonTbJsBridge;
        this.mJsBridge.a(commonTbJsBridge);
    }

    public void onChangeSkinType() {
        if (this.mJsBridge != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
            this.mJsBridge.h(getWebView(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
        }
    }

    public void resetProxy(int i2) {
        CompatibleUtile.dealWebView(null);
    }

    @RequiresApi(api = 21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(getContext());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, z);
        }
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

    public void setOnJsPromptCallback(d.b.i0.d3.l0.c cVar) {
        this.jsCallback = cVar;
    }

    public void setOnLoadUrlListener(d dVar) {
        this.mOnLoadUrlListener = dVar;
    }

    public void setOnPageFinishedListener(e eVar) {
        this.mOnPageFinishedListener = eVar;
    }

    public void setOnPageStartedListener(f fVar) {
        this.mOnPageStartedListener = fVar;
    }

    public void setOnProgressChangedListener(g gVar) {
        this.mOnProgressChangedListener = gVar;
    }

    public void setOnReceivedErrorListener(h hVar) {
        this.mOnReceivedErrorListener = hVar;
    }

    public void setOnReceivedSslErrorListener(i iVar) {
        this.mOnReceivedSslErrorListener = iVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
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
        this.mOnProgressChangedListener = null;
        this.jsCallback = new a();
        this.mContext = context;
        init();
    }
}
