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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.OpenAppUtils;
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
/* loaded from: classes5.dex */
public abstract class BaseAdWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseAdWebView f13745e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13746f;

    /* renamed from: g  reason: collision with root package name */
    public String f13747g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadCacheKey f13748h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13749i;
    public d j;
    public e k;

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseAdWebView f13750c;

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
            this.f13750c = baseAdWebView;
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

    /* loaded from: classes5.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseAdWebView f13751a;

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
            this.f13751a = baseAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                BaseAdWebView baseAdWebView = this.f13751a;
                if (baseAdWebView.f13745e != null) {
                    baseAdWebView.e(str, str3, str4, j);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BaseAdWebView f13752a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f13753b;

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
            this.f13752a = baseAdWebView;
            this.f13753b = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f13752a.setLightTouchEnabled();
                BaseAdWebView baseAdWebView = this.f13752a;
                if (!baseAdWebView.f13749i) {
                    baseAdWebView.getSettings().setBlockNetworkImage(false);
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                this.f13752a.f13747g = str;
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                super.shouldOverrideUrlLoading(webView, str);
                try {
                    if (this.f13753b != null) {
                        if (str.startsWith("tel:")) {
                            this.f13753b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        } else if (str.startsWith(OpenAppUtils.SCHEME_WTAI_MC)) {
                            this.f13753b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13))));
                            return true;
                        } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                            this.f13753b.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
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

    /* loaded from: classes5.dex */
    public interface d {
        void onDownloadStart();
    }

    /* loaded from: classes5.dex */
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
        this.f13749i = true;
        this.f13745e = this;
        this.f13746f = context;
        c();
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

    public abstract void b(@NonNull DownloadCacheKey downloadCacheKey, boolean z);

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f13745e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f13745e.removeJavascriptInterface("accessibility");
                this.f13745e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(this.f13746f);
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

    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadCacheKey) == null) {
            this.f13748h = downloadCacheKey;
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.removeAllViews();
            super.destroy();
        }
    }

    public void e(String str, String str2, String str3, long j) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Long.valueOf(j)}) == null) || TextUtils.isEmpty(str) || (downloadCacheKey = this.f13748h) == null) {
            return;
        }
        downloadCacheKey.mDownloadUrl = str;
        String g2 = d.a.s0.q.h.a.g(str, str2, str3);
        boolean z = d.a.s0.q.h.a.b(d.a.s0.q.h.a.e(g2), str3) == 3;
        if (TextUtils.isEmpty(g2)) {
            String[] split = str.split("/");
            g2 = split.length > 1 ? split[split.length - 1] : str;
            if (g2 != null && g2.length() > 50) {
                g2 = g2.substring(0, 50);
            }
        }
        this.f13748h.mPackageName = g2;
        AdDownloadData b2 = d.a.s0.q.d.e.c().b(this.f13748h);
        b2.setupPkgName(g2);
        b2.setupDownloadUrl(str);
        b(this.f13748h, z);
    }

    public abstract String getUserAgent();

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!this.f13749i) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4, str5) == null) {
            if (!this.f13749i) {
                getSettings().setBlockNetworkImage(true);
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!this.f13749i) {
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
            e eVar = this.k;
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
            this.f13749i = z;
        }
    }

    public void setDownloadStartListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.j = dVar;
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
            this.k = eVar;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) {
            if (!this.f13749i) {
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
        this.f13749i = true;
        this.f13745e = this;
        this.f13746f = context;
        c();
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
        this.f13749i = true;
        this.f13745e = this;
        this.f13746f = context;
        c();
    }
}
