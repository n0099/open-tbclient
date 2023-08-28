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
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ak6;
import com.baidu.tieba.an6;
import com.baidu.tieba.bk6;
import com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.cm6;
import com.baidu.tieba.in6;
import com.baidu.tieba.km6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pj6;
import com.baidu.tieba.qj6;
import com.baidu.tieba.sk6;
import com.baidu.tieba.sl6;
import com.baidu.tieba.sm6;
import com.baidu.tieba.wj6;
import com.baidu.tieba.wk6;
import com.baidu.tieba.wl6;
import com.baidu.tieba.wm6;
import com.baidu.tieba.xl6;
import com.baidu.tieba.zj6;
import com.baidu.tieba.zm6;
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
public class BaseWebView extends MonitorWebView implements sl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b A;
    public final zm6 B;
    public final AtomicBoolean C;
    public final wk6 D;
    public final pj6 E;
    public final List<Pair<String, String>> F;
    public cm6 G;
    public boolean H;
    public final Runnable I;
    public boolean z;

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
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, "onPageStart not called after loadUrl 1800ms, url=" + this.a.getOriginalUrl());
                wj6 a = wj6.a(HybridStatisticKey.KEY_RD_USE);
                a.c("obj_type", "hybrid-check");
                a.c("obj_source", this.a.getOriginalUrl());
                a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends an6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public wm6 b;
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
                if (!km6.b(map)) {
                    return TextUtils.equals(map.get("tieba-response-via"), PrefetchEvent.MODULE);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void d(@Nullable wm6 wm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm6Var) == null) {
                this.b = wm6Var;
            }
        }

        @Override // com.baidu.tieba.an6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            cm6 cm6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && webView != null && webView.getContext() != null) {
                if (str.startsWith("file:///android_asset/blank.html") && (cm6Var = this.c.G) != null) {
                    cm6Var.onPageFinished(webView, str);
                }
                if (!TextUtils.equals("about:blank", str) && this.c.C.get()) {
                    this.c.C.set(false);
                    webView.clearHistory();
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.an6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048579, this, webView, str, bitmap) != null) {
                return;
            }
            this.c.H = true;
            SafeHandler.getInst().removeCallbacks(this.c.I);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.baidu.tieba.an6, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            WebResourceResponse a;
            WebResourceResponse a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, webResourceRequest)) == null) {
                wm6 wm6Var = this.b;
                if (wm6Var != null && (a2 = wm6Var.a(webView, webResourceRequest)) != null) {
                    return a2;
                }
                if (webView != null && (a = sk6.b().a(webView.getOriginalUrl(), webResourceRequest)) != null) {
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
        this.z = true;
        this.A = new b(this);
        this.B = new bk6();
        this.C = new AtomicBoolean(true);
        this.D = new wk6();
        this.E = qj6.g(this);
        this.F = new ArrayList();
        this.G = null;
        this.I = new a(this);
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
        this.z = true;
        this.A = new b(this);
        this.B = new bk6();
        this.C = new AtomicBoolean(true);
        this.D = new wk6();
        this.E = qj6.g(this);
        this.F = new ArrayList();
        this.G = null;
        this.I = new a(this);
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
        this.z = true;
        this.A = new b(this);
        this.B = new bk6();
        this.C = new AtomicBoolean(true);
        this.D = new wk6();
        this.E = qj6.g(this);
        this.F = new ArrayList();
        this.G = null;
        this.I = new a(this);
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

    public void E(cm6 cm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cm6Var) == null) {
            super.loadUrl("file:///android_asset/blank.html");
            this.G = cm6Var;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
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
                    put("referer", TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
                }
            });
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void setTargetInterceptor(@Nullable wm6 wm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wm6Var) == null) {
            this.A.d(wm6Var);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, webChromeClient) == null) {
            this.B.c(webChromeClient);
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, webViewClient) == null) {
            this.A.b(webViewClient);
        }
    }

    @Override // com.baidu.tieba.sl6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.F.add(Pair.create(str, str2));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundColor(0);
            sm6.e(this);
            BrowserHelper.initCookie(getContext());
            ak6.b(this);
            zj6.a(this);
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            super.setWebChromeClient(this.B);
            super.setWebViewClient(this.A);
            u();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.G = null;
        }
    }

    @Override // com.baidu.tieba.hn6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.z = false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.C.get()) {
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

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.u();
            xl6.b().c(this);
            this.E.b();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public String F(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Pair<Boolean, String> g = this.D.g(this, str);
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
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (p(str)) {
                this.C.set(true);
                str2 = F(str);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, this + " 开始加载 原始url:" + str + " 离线包转换后的url:" + str2 + " Headers:" + map);
                List<Pair<String, Long>> c = FetchDynamicResourceManager.c(str2);
                if (this.n != null && !km6.a(c)) {
                    this.n.p(c);
                }
                in6 in6Var = this.n;
                if (in6Var != null) {
                    in6Var.o(str);
                }
            } else {
                str2 = str;
            }
            SafeHandler.getInst().removeCallbacks(this.I);
            super.loadUrl(str2, map);
            if (!TextUtils.isEmpty(str) && !str.startsWith("file:///android_asset/blank.html") && !TextUtils.equals("about:blank", str)) {
                SafeHandler.getInst().postDelayed(this.I, DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT);
            }
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setTargetInterceptor(null);
            this.D.c();
            super.loadUrl("file:///android_asset/blank.html");
            xl6.b().d(this);
            wl6.a().a(this.F);
            this.E.a();
            this.F.clear();
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
            sm6.d(this);
            super.s();
        }
    }
}
