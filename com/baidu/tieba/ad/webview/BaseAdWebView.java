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
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes12.dex */
public abstract class BaseAdWebView extends WebView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUESTCODE_FILECHOOSER = 15689;
    public static final String SCHEME_WTAI_MC = "wtai://wp/mc;";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f43304e;
    public Context mContext;
    public DownloadCacheKey mDownloadCacheKey;
    public boolean mDownloadPicOnLoad;
    public d mDownloadStartListener;
    public ValueCallback<Uri[]> mHightUploadMessage;
    public ValueCallback<Uri> mUploadMessage;
    public BaseAdWebView mWebview;
    public String mWebviewUrl;

    /* loaded from: classes12.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseAdWebView f43305c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseAdWebView baseAdWebView, BaseAdWebView baseAdWebView2, Activity activity) {
            super(baseAdWebView2, activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdWebView, baseAdWebView2, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseAdWebView) objArr2[0], (Activity) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43305c = baseAdWebView;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseAdWebView a;

        public b(BaseAdWebView baseAdWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                BaseAdWebView baseAdWebView = this.a;
                if (baseAdWebView.mWebview != null) {
                    baseAdWebView.shouldOverrideUrlLoadingByDownloadApp(str, str3, str4, j2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BaseAdWebView a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f43306b;

        public c(BaseAdWebView baseAdWebView, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseAdWebView;
            this.f43306b = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.setLightTouchEnabled();
                BaseAdWebView baseAdWebView = this.a;
                if (!baseAdWebView.mDownloadPicOnLoad) {
                    baseAdWebView.getSettings().setBlockNetworkImage(false);
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                this.a.mWebviewUrl = str;
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, renderProcessGoneDetail)) == null) {
                f.a("BaseAdWebView", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                super.shouldOverrideUrlLoading(webView, str);
                try {
                    if (this.f43306b != null) {
                        if (str.startsWith("tel:")) {
                            this.f43306b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        } else if (str.startsWith(BaseAdWebView.SCHEME_WTAI_MC)) {
                            this.f43306b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13))));
                            return true;
                        } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                            this.f43306b.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface d {
        void onDownloadStart(DownloadCacheKey downloadCacheKey);
    }

    /* loaded from: classes12.dex */
    public interface e {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1028868982, "Lcom/baidu/tieba/ad/webview/BaseAdWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1028868982, "Lcom/baidu/tieba/ad/webview/BaseAdWebView;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDownloadPicOnLoad = true;
        this.mWebview = this;
        this.mContext = context;
        b();
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.mWebview.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebview.removeJavascriptInterface("accessibility");
                this.mWebview.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(this.mContext);
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
            setWebViewClient(new a(this, this, (Activity) getContext()));
            clearFocus();
            clearHistory();
            clearView();
            setScrollBarStyle(0);
            setAcceptThirdPartyCookies(true);
            setDownloadListener(new b(this));
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mUploadMessage = null;
            super.removeAllViews();
            super.destroy();
        }
    }

    public abstract String getUserAgent();

    public abstract void handleDownload(@NonNull DownloadCacheKey downloadCacheKey, boolean z);

    public void handlerActivityResultForFileChooser(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) && i2 == 15689) {
            if (this.mUploadMessage == null && this.mHightUploadMessage == null) {
                return;
            }
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                this.mUploadMessage = null;
            } else if (this.mHightUploadMessage != null) {
                Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                if (data != null) {
                    this.mHightUploadMessage.onReceiveValue(new Uri[]{data});
                    this.mHightUploadMessage = null;
                    return;
                }
                this.mHightUploadMessage.onReceiveValue(null);
                this.mHightUploadMessage = null;
            }
        }
    }

    public void inputDownloadCachekey(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadCacheKey) == null) {
            this.mDownloadCacheKey = downloadCacheKey;
        }
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!this.mDownloadPicOnLoad) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4, str5) == null) {
            if (!this.mDownloadPicOnLoad) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!this.mDownloadPicOnLoad) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadUrl(str);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            e eVar = this.f43304e;
            if (eVar != null) {
                eVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
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
    }

    public void setDownloadPicOnLoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mDownloadPicOnLoad = z;
        }
    }

    public void setDownloadStartListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.mDownloadStartListener = dVar;
        }
    }

    public void setLightTouchEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {\tvar bodystyle = document.body.style.cssText;\tif (bodystyle == undefined || bodystyle == null)\t\tbodystyle = '';\tvar tapstylekey = '-webkit-tap-highlight-color';\tif (bodystyle.indexOf(tapstylekey) < 0) {\t\tbodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';\t\tdocument.body.style.cssText = bodystyle;\t}}\");");
            loadUrl("javascript:SetBodyStyleTapColor();");
        }
    }

    public void setWebViewScrollListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.f43304e = eVar;
        }
    }

    public void shouldOverrideUrlLoadingByDownloadApp(String str, String str2, String str3, long j2) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(str) || (downloadCacheKey = this.mDownloadCacheKey) == null) {
            return;
        }
        downloadCacheKey.mDownloadUrl = str;
        String g2 = c.a.t0.v.l.a.g(str, str2, str3);
        boolean z = c.a.t0.v.l.a.b(c.a.t0.v.l.a.e(g2), str3) == 3;
        if (TextUtils.isEmpty(g2)) {
            String[] split = str.split("/");
            g2 = split.length > 1 ? split[split.length - 1] : str;
            if (g2 != null && g2.length() > 50) {
                g2 = g2.substring(0, 50);
            }
        }
        this.mDownloadCacheKey.mPackageName = g2;
        AdDownloadData b2 = c.a.t0.v.g.e.d().b(this.mDownloadCacheKey);
        b2.setupPkgName(g2);
        b2.setupDownloadUrl(str);
        handleDownload(this.mDownloadCacheKey, z);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) {
            if (!this.mDownloadPicOnLoad) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadUrl(str, map);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDownloadPicOnLoad = true;
        this.mWebview = this;
        this.mContext = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDownloadPicOnLoad = true;
        this.mWebview = this;
        this.mContext = context;
        b();
    }
}
