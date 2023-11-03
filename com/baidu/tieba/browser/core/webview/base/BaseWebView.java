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
import com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.ch6;
import com.baidu.tieba.di6;
import com.baidu.tieba.dj6;
import com.baidu.tieba.dk6;
import com.baidu.tieba.ej6;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hh6;
import com.baidu.tieba.hk6;
import com.baidu.tieba.ih6;
import com.baidu.tieba.jj6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.lk6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sk6;
import com.baidu.tieba.tk6;
import com.baidu.tieba.vg6;
import com.baidu.tieba.vj6;
import com.baidu.tieba.vk6;
import com.baidu.tieba.wg6;
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
public class BaseWebView extends MonitorWebView implements zi6, sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean G;
    public final b H;
    public final kk6 I;
    public final AtomicBoolean J;
    public final di6 K;
    public final vg6 L;
    public final List<Pair<String, String>> M;
    public jj6 N;
    public boolean O;
    public tk6 P;
    public final Runnable Q;

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
                this.a.w = true;
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, "onPageStart not called after loadUrl 1800ms, url=" + this.a.getOriginalUrl());
                ch6 a = ch6.a(HybridStatisticKey.KEY_RD_USE);
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
    public class b extends lk6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public hk6 b;
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
                if (!vj6.b(map)) {
                    return TextUtils.equals(map.get("tieba-response-via"), PrefetchEvent.MODULE);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void d(@Nullable hk6 hk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hk6Var) == null) {
                this.b = hk6Var;
            }
        }

        @Override // com.baidu.tieba.lk6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            jj6 jj6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && webView != null && webView.getContext() != null) {
                if (str.startsWith("file:///android_asset/blank.html") && (jj6Var = this.c.N) != null) {
                    jj6Var.onPageFinished(webView, str);
                }
                if (!TextUtils.equals("about:blank", str) && this.c.J.get()) {
                    this.c.J.set(false);
                    webView.clearHistory();
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.lk6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048579, this, webView, str, bitmap) != null) {
                return;
            }
            this.c.O = true;
            this.c.w = false;
            SafeHandler.getInst().removeCallbacks(this.c.Q);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.baidu.tieba.lk6, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            WebResourceResponse a;
            WebResourceResponse a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, webResourceRequest)) == null) {
                hk6 hk6Var = this.b;
                if (hk6Var != null && (a2 = hk6Var.a(webView, webResourceRequest)) != null) {
                    return a2;
                }
                if (webView != null && (a = zh6.b().a(webView.getOriginalUrl(), webResourceRequest)) != null) {
                    try {
                        Map<String, String> responseHeaders = a.getResponseHeaders();
                        if (this.c.s != null && c(responseHeaders)) {
                            this.c.s.a(webResourceRequest.getUrl().getPath(), responseHeaders.get("tieba-response-time"), Long.valueOf(System.currentTimeMillis()));
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
        super(I(context));
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
        this.G = true;
        this.H = new b(this);
        this.I = new ih6();
        this.J = new AtomicBoolean(true);
        this.K = new di6();
        this.L = wg6.g(this);
        this.M = new ArrayList();
        this.N = null;
        this.Q = new a(this);
        J();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(I(context), attributeSet);
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
        this.G = true;
        this.H = new b(this);
        this.I = new ih6();
        this.J = new AtomicBoolean(true);
        this.K = new di6();
        this.L = wg6.g(this);
        this.M = new ArrayList();
        this.N = null;
        this.Q = new a(this);
        J();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(I(context), attributeSet, i);
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
        this.G = true;
        this.H = new b(this);
        this.I = new ih6();
        this.J = new AtomicBoolean(true);
        this.K = new di6();
        this.L = wg6.g(this);
        this.M = new ArrayList();
        this.N = null;
        this.Q = new a(this);
        J();
    }

    public static Context I(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return new MutableContextWrapper(context.createConfigurationContext(new Configuration()));
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    public void L(jj6 jj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jj6Var) == null) {
            super.loadUrl("file:///android_asset/blank.html");
            this.N = jj6Var;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
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

    @Override // com.baidu.tieba.sk6
    public void setJSPromptRedirector(tk6 tk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tk6Var) == null) {
            this.P = tk6Var;
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void setTargetInterceptor(@Nullable hk6 hk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hk6Var) == null) {
            this.H.d(hk6Var);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, webChromeClient) == null) {
            this.I.c(webChromeClient);
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webViewClient) == null) {
            this.H.b(webViewClient);
        }
    }

    @Override // com.baidu.tieba.zi6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.M.add(Pair.create(str, str2));
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B();
            ej6.b().c(this);
            this.L.b();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.N = null;
        }
    }

    @Override // com.baidu.tieba.uk6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.G = false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.J.get()) {
                return false;
            }
            return super.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            z();
            super.destroy();
        }
    }

    @Override // com.baidu.tieba.sk6
    @Nullable
    public tk6 getJSPromptRedirector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.P;
        }
        return (tk6) invokeV.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setBackgroundColor(0);
            dk6.e(this);
            BrowserHelper.initCookie(getContext());
            hh6.b(this);
            gh6.a(this);
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            super.setWebChromeClient(this.I);
            super.setWebViewClient(this.H);
            B();
        }
    }

    public String M(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                Pair<Boolean, String> g = this.K.g(this, str);
                if (this.s != null) {
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
                    this.s.m(g.first.booleanValue());
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
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (w(str)) {
                this.J.set(true);
                str2 = M(str);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, this + " 开始加载 原始url:" + str + " 离线包转换后的url:" + str2 + " Headers:" + map);
                List<Pair<String, Long>> c = FetchDynamicResourceManager.c(str2);
                if (this.s != null && !vj6.a(c)) {
                    this.s.p(c);
                }
                vk6 vk6Var = this.s;
                if (vk6Var != null) {
                    vk6Var.o(str);
                }
            } else {
                str2 = str;
            }
            SafeHandler.getInst().removeCallbacks(this.Q);
            super.loadUrl(str2, map);
            if (!TextUtils.isEmpty(str) && !str.startsWith("file:///android_asset/blank.html") && !TextUtils.equals("about:blank", str)) {
                long j = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
                if (System.currentTimeMillis() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp() < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    j = 4000;
                }
                SafeHandler.getInst().postDelayed(this.Q, j);
            }
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setTargetInterceptor(null);
            this.K.c();
            super.loadUrl("about:blank");
            ej6.b().d(this);
            dj6.a().a(this.M);
            this.L.a();
            this.M.clear();
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
            dk6.d(this);
            this.P = null;
            super.z();
        }
    }
}
