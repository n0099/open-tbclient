package com.baidu.tieba.ad.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.d;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class BaseAdWebView extends WebView {
    private static final String TAG = BaseAdWebView.class.getSimpleName();
    protected DownloadCacheKey dYY;
    protected BaseAdWebView eae;
    protected String eaf;
    protected boolean eag;
    private b eah;
    protected Context mContext;
    protected ValueCallback<Uri> mUploadMessage;

    /* loaded from: classes8.dex */
    public interface b {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    protected abstract void a(@NonNull DownloadCacheKey downloadCacheKey, boolean z);

    protected abstract String getUserAgent();

    public BaseAdWebView(Context context) {
        super(context);
        this.eag = true;
        this.eae = this;
        this.mContext = context;
        init();
    }

    public BaseAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eag = true;
        this.eae = this;
        this.mContext = context;
        init();
    }

    public BaseAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eag = true;
        this.eae = this;
        this.mContext = context;
        init();
    }

    private void init() {
        try {
            this.eae.removeJavascriptInterface("searchBoxJavaBridge_");
            this.eae.removeJavascriptInterface("accessibility");
            this.eae.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        et(this.mContext);
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
        getSettings().setSupportMultipleWindows(true);
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setCacheMode(-1);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowContentAccess(true);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        }
        getSettings().setDomStorageEnabled(true);
        setWebViewClient(new a(this, (Activity) getContext()) { // from class: com.baidu.tieba.ad.webview.BaseAdWebView.1
            @Override // com.baidu.tieba.ad.webview.BaseAdWebView.a, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.baidu.tieba.ad.webview.BaseAdWebView.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        clearFocus();
        clearHistory();
        clearView();
        setScrollBarStyle(0);
        setAcceptThirdPartyCookies(true);
        setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.ad.webview.BaseAdWebView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (BaseAdWebView.this.eae != null) {
                    BaseAdWebView.this.b(str, str3, str4, j);
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.mUploadMessage = null;
        super.removeAllViews();
        super.destroy();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!this.eag) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.eag) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        if (!this.eag) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.eag) {
            getSettings().setBlockNetworkImage(true);
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void h(@NonNull DownloadCacheKey downloadCacheKey) {
        this.dYY = downloadCacheKey;
    }

    public void setLightTouchEnabled() {
        loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {\tvar bodystyle = document.body.style.cssText;\tif (bodystyle == undefined || bodystyle == null)\t\tbodystyle = '';\tvar tapstylekey = '-webkit-tap-highlight-color';\tif (bodystyle.indexOf(tapstylekey) < 0) {\t\tbodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';\t\tdocument.body.style.cssText = bodystyle;\t}}\");");
        loadUrl("javascript:SetBodyStyleTapColor();");
    }

    public void setWebViewScrollListener(b bVar) {
        this.eah = bVar;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.eah != null) {
            this.eah.onScrollChanged(i, i2, i3, i4);
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
        if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(this, z);
        }
    }

    private void et(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setDownloadPicOnLoad(boolean z) {
        this.eag = z;
    }

    /* loaded from: classes8.dex */
    public static class a extends WebViewClient {
        private BaseAdWebView eae;
        private Activity mActivity;

        public a(BaseAdWebView baseAdWebView, Activity activity) {
            this.eae = baseAdWebView;
            this.mActivity = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.eae.eaf = str;
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.eae.setLightTouchEnabled();
            if (!this.eae.eag) {
                this.eae.getSettings().setBlockNetworkImage(false);
            }
            super.onPageFinished(webView, str);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0061 -> B:8:0x0022). Please submit an issue!!! */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            super.shouldOverrideUrlLoading(webView, str);
            try {
                if (this.mActivity != null) {
                    if (str.startsWith("tel:")) {
                        this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.startsWith("wtai://wp/mc;")) {
                        this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring("wtai://wp/mc;".length()))));
                        return true;
                    } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                        this.mActivity.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    protected void b(String str, String str2, String str3, long j) {
        String str4;
        if (!TextUtils.isEmpty(str) && this.dYY != null) {
            this.dYY.mDownloadUrl = str;
            String aa = com.baidu.tieba.ad.webview.a.aa(str, str2, str3);
            boolean z = com.baidu.tieba.ad.webview.a.cN(com.baidu.tieba.ad.webview.a.mI(aa), str3) == 3;
            if (TextUtils.isEmpty(aa)) {
                String[] split = str.split("/");
                str4 = split.length > 1 ? split[split.length - 1] : str;
                if (str4 != null && str4.length() > 50) {
                    str4 = str4.substring(0, 50);
                }
            } else {
                str4 = aa;
            }
            this.dYY.mPackageName = str4;
            AdDownloadData d = d.aYi().d(this.dYY);
            d.setupPkgName(str4);
            d.setupDownloadUrl(str);
            a(this.dYY, z);
        }
    }
}
