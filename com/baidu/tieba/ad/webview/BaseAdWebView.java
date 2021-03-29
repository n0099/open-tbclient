package com.baidu.tieba.ad.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class BaseAdWebView extends WebView {

    /* renamed from: e  reason: collision with root package name */
    public BaseAdWebView f14533e;

    /* renamed from: f  reason: collision with root package name */
    public Context f14534f;

    /* renamed from: g  reason: collision with root package name */
    public String f14535g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadCacheKey f14536h;
    public boolean i;
    public d j;

    /* loaded from: classes4.dex */
    public class a extends c {
        public a(BaseAdWebView baseAdWebView, Activity activity) {
            super(baseAdWebView, activity);
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            BaseAdWebView baseAdWebView = BaseAdWebView.this;
            if (baseAdWebView.f14533e != null) {
                baseAdWebView.e(str, str3, str4, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public BaseAdWebView f14539a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f14540b;

        public c(BaseAdWebView baseAdWebView, Activity activity) {
            this.f14539a = baseAdWebView;
            this.f14540b = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f14539a.setLightTouchEnabled();
            BaseAdWebView baseAdWebView = this.f14539a;
            if (!baseAdWebView.i) {
                baseAdWebView.getSettings().setBlockNetworkImage(false);
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f14539a.f14535g = str;
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            super.shouldOverrideUrlLoading(webView, str);
            try {
                if (this.f14540b != null) {
                    if (str.startsWith("tel:")) {
                        this.f14540b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.startsWith("wtai://wp/mc;")) {
                        this.f14540b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13))));
                        return true;
                    } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                        this.f14540b.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public BaseAdWebView(Context context) {
        super(context);
        this.i = true;
        this.f14533e = this;
        this.f14534f = context;
        c();
    }

    public final void a(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public abstract void b(@NonNull DownloadCacheKey downloadCacheKey, boolean z);

    public final void c() {
        try {
            this.f14533e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f14533e.removeJavascriptInterface("accessibility");
            this.f14533e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(this.f14534f);
        setScrollbarFadingEnabled(true);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(false);
        getSettings().setLightTouchEnabled(true);
        getSettings().setUserAgentString(getUserAgent());
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setSupportZoom(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowFileAccess(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setCacheMode(-1);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowContentAccess(true);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        }
        getSettings().setDomStorageEnabled(true);
        setWebViewClient(new a(this, (Activity) getContext()));
        clearFocus();
        clearHistory();
        clearView();
        setScrollBarStyle(0);
        setAcceptThirdPartyCookies(true);
        setDownloadListener(new b());
    }

    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        this.f14536h = downloadCacheKey;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.removeAllViews();
        super.destroy();
    }

    public void e(String str, String str2, String str3, long j) {
        DownloadCacheKey downloadCacheKey;
        if (TextUtils.isEmpty(str) || (downloadCacheKey = this.f14536h) == null) {
            return;
        }
        downloadCacheKey.mDownloadUrl = str;
        String g2 = d.b.i0.o.g.a.g(str, str2, str3);
        boolean z = d.b.i0.o.g.a.b(d.b.i0.o.g.a.e(g2), str3) == 3;
        if (TextUtils.isEmpty(g2)) {
            String[] split = str.split("/");
            g2 = split.length > 1 ? split[split.length - 1] : str;
            if (g2 != null && g2.length() > 50) {
                g2 = g2.substring(0, 50);
            }
        }
        this.f14536h.mPackageName = g2;
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(this.f14536h);
        b2.setupPkgName(g2);
        b2.setupDownloadUrl(str);
        b(this.f14536h, z);
    }

    public abstract String getUserAgent();

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        if (!this.i) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.i) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!this.i) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        d dVar = this.j;
        if (dVar != null) {
            dVar.onScrollChanged(i, i2, i3, i4);
        }
    }

    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(getContext());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            th.printStackTrace();
            cookieManager = null;
        }
        if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        cookieManager.setAcceptThirdPartyCookies(this, z);
    }

    public void setDownloadPicOnLoad(boolean z) {
        this.i = z;
    }

    public void setLightTouchEnabled() {
        loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {\tvar bodystyle = document.body.style.cssText;\tif (bodystyle == undefined || bodystyle == null)\t\tbodystyle = '';\tvar tapstylekey = '-webkit-tap-highlight-color';\tif (bodystyle.indexOf(tapstylekey) < 0) {\t\tbodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';\t\tdocument.body.style.cssText = bodystyle;\t}}\");");
        loadUrl("javascript:SetBodyStyleTapColor();");
    }

    public void setWebViewScrollListener(d dVar) {
        this.j = dVar;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.i) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadUrl(str, map);
    }

    public BaseAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = true;
        this.f14533e = this;
        this.f14534f = context;
        c();
    }

    public BaseAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        this.f14533e = this;
        this.f14534f = context;
        c();
    }
}
