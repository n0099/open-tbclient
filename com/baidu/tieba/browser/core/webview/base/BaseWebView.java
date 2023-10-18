package com.baidu.tieba.browser.core.webview.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tieba.af6;
import com.baidu.tieba.bf6;
import com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.dg6;
import com.baidu.tieba.dh6;
import com.baidu.tieba.hf6;
import com.baidu.tieba.hg6;
import com.baidu.tieba.hh6;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ih6;
import com.baidu.tieba.kf6;
import com.baidu.tieba.lf6;
import com.baidu.tieba.li6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mf6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.oi6;
import com.baidu.tieba.pi6;
import com.baidu.tieba.wi6;
import com.baidu.tieba.xi6;
import com.baidu.tieba.zh6;
import com.baidu.tieba.zi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class BaseWebView extends MonitorWebView implements dh6, wi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean B;
    public final b C;
    public final oi6 D;
    public final AtomicBoolean E;
    public final hg6 F;
    public final af6 G;
    public final List<Pair<String, String>> H;
    public nh6 I;
    public boolean J;
    public xi6 K;
    public final Runnable L;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView a;

        public a(BaseWebView baseWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r = true;
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, "onPageStart not called after loadUrl 1800ms, url=" + this.a.getOriginalUrl());
                hf6 a = hf6.a(HybridStatisticKey.KEY_RD_USE);
                a.c("obj_type", "hybrid-check");
                a.c("obj_source", this.a.getOriginalUrl());
                a.d();
                if (this.a.getInvalidPageCallback() != null) {
                    this.a.getInvalidPageCallback().call();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends pi6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public li6 b;
        public final /* synthetic */ BaseWebView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseWebView baseWebView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WebViewClient) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseWebView;
            this.b = null;
        }

        public boolean c(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                if (!zh6.b(map)) {
                    return TextUtils.equals(map.get("tieba-response-via"), PrefetchEvent.MODULE);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void d(@Nullable li6 li6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li6Var) == null) {
                this.b = li6Var;
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            nh6 nh6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && webView != null && webView.getContext() != null) {
                if (str.startsWith("file:///android_asset/blank.html") && (nh6Var = this.c.I) != null) {
                    nh6Var.onPageFinished(webView, str);
                }
                if (!TextUtils.equals("about:blank", str) && this.c.E.get()) {
                    this.c.E.set(false);
                    webView.clearHistory();
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048579, this, webView, str, bitmap) != null) {
                return;
            }
            this.c.J = true;
            this.c.r = false;
            SafeHandler.getInst().removeCallbacks(this.c.L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            WebResourceResponse a;
            WebResourceResponse a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, webResourceRequest)) == null) {
                li6 li6Var = this.b;
                if (li6Var != null && (a2 = li6Var.a(webView, webResourceRequest)) != null) {
                    return a2;
                }
                if (webView != null && (a = dg6.b().a(webView.getOriginalUrl(), webResourceRequest)) != null) {
                    try {
                        Map<String, String> responseHeaders = a.getResponseHeaders();
                        if (this.c.n != null && c(responseHeaders)) {
                            this.c.n.a(webResourceRequest.getUrl().getPath(), responseHeaders.get("tieba-response-time"), Long.valueOf(System.currentTimeMillis()));
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    return a;
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context) {
        super(B(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = true;
        this.C = new b(this);
        this.D = new mf6();
        this.E = new AtomicBoolean(true);
        this.F = new hg6();
        this.G = bf6.g(this);
        this.H = new ArrayList();
        this.I = null;
        this.L = new a(this);
        C();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(B(context), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = true;
        this.C = new b(this);
        this.D = new mf6();
        this.E = new AtomicBoolean(true);
        this.F = new hg6();
        this.G = bf6.g(this);
        this.H = new ArrayList();
        this.I = null;
        this.L = new a(this);
        C();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(B(context), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.B = true;
        this.C = new b(this);
        this.D = new mf6();
        this.E = new AtomicBoolean(true);
        this.F = new hg6();
        this.G = bf6.g(this);
        this.H = new ArrayList();
        this.I = null;
        this.L = new a(this);
        C();
    }

    public static Context B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return new MutableContextWrapper(context.createConfigurationContext(new Configuration()));
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    public void E(nh6 nh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nh6Var) == null) {
            super.loadUrl("file:///android_asset/blank.html");
            this.I = nh6Var;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            loadUrl(str, new HashMap<String, String>(this) { // from class: com.baidu.tieba.browser.core.webview.base.BaseWebView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseWebView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    put("referer", "https://tiebac.baidu.com/");
                }
            });
        }
    }

    @Override // com.baidu.tieba.wi6
    public void setJSPromptRedirector(xi6 xi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xi6Var) == null) {
            this.K = xi6Var;
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void setTargetInterceptor(@Nullable li6 li6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, li6Var) == null) {
            this.C.d(li6Var);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, webChromeClient) == null) {
            this.D.c(webChromeClient);
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, webViewClient) == null) {
            this.C.b(webViewClient);
        }
    }

    @Override // com.baidu.tieba.dh6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.H.add(Pair.create(str, str2));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundColor(0);
            hi6.e(this);
            BrowserHelper.initCookie(getContext());
            lf6.b(this);
            kf6.a(this);
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            super.setWebChromeClient(this.D);
            super.setWebViewClient(this.C);
            u();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.I = null;
        }
    }

    @Override // com.baidu.tieba.yi6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.E.get()) {
                return false;
            }
            return super.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            s();
            super.destroy();
        }
    }

    @Override // com.baidu.tieba.wi6
    @Nullable
    public xi6 getJSPromptRedirector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.K;
        }
        return (xi6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.u();
            ih6.b().c(this);
            this.G.b();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public String F(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Pair<Boolean, String> g = this.F.g(this, str);
                if (this.n != null) {
                    TbLog hybridLog = HybridLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    if (g.first.booleanValue()) {
                        str2 = "有离线包";
                    } else {
                        str2 = "没有离线包";
                    }
                    sb.append(str2);
                    sb.append(", url: ");
                    sb.append(str);
                    hybridLog.i("Offline", sb.toString());
                    this.n.m(g.first.booleanValue());
                }
                return g.second;
            } catch (Exception e) {
                BdLog.e(e);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (p(str)) {
                this.E.set(true);
                str2 = F(str);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, this + " 开始加载 原始url:" + str + " 离线包转换后的url:" + str2 + " Headers:" + map);
                List<Pair<String, Long>> c = FetchDynamicResourceManager.c(str2);
                if (this.n != null && !zh6.a(c)) {
                    this.n.p(c);
                }
                zi6 zi6Var = this.n;
                if (zi6Var != null) {
                    zi6Var.o(str);
                }
            } else {
                str2 = str;
            }
            SafeHandler.getInst().removeCallbacks(this.L);
            super.loadUrl(str2, map);
            if (!TextUtils.isEmpty(str) && !str.startsWith("file:///android_asset/blank.html") && !TextUtils.equals("about:blank", str)) {
                long j = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
                if (System.currentTimeMillis() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp() < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    j = 4000;
                }
                SafeHandler.getInst().postDelayed(this.L, j);
            }
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setTargetInterceptor(null);
            this.F.c();
            super.loadUrl("about:blank");
            ih6.b().d(this);
            hh6.a().a(this.H);
            this.G.a();
            this.H.clear();
            stopLoading();
            setOnLongClickListener(null);
            if (getHandler() != null) {
                getHandler().removeCallbacksAndMessages(null);
            }
            clearFocus();
            setWebChromeClient(null);
            setWebViewClient(null);
            clearAnimation();
            setTag(null);
            removeAllViews();
            clearView();
            hi6.d(this);
            this.K = null;
            super.s();
        }
    }
}
