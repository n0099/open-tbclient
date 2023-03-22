package com.baidu.tieba.browser.core.webview.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tieba.ae6;
import com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager;
import com.baidu.tieba.browser.core.webview.base.BaseWebView;
import com.baidu.tieba.browser.core.webview.bridge.BridgeWebChromeClient;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.bsa;
import com.baidu.tieba.de6;
import com.baidu.tieba.eb6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.fb6;
import com.baidu.tieba.fsa;
import com.baidu.tieba.gd6;
import com.baidu.tieba.gt4;
import com.baidu.tieba.ic6;
import com.baidu.tieba.je6;
import com.baidu.tieba.kc6;
import com.baidu.tieba.kd6;
import com.baidu.tieba.mb6;
import com.baidu.tieba.nb6;
import com.baidu.tieba.vd6;
import com.baidu.tieba.w58;
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
/* loaded from: classes3.dex */
public class BaseWebView extends MonitorWebView implements gd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean p;
    public final a q;
    public final de6 r;
    public final AtomicBoolean s;
    public final kc6 t;
    public eb6 u;
    public final List<Pair<String, String>> v;

    /* loaded from: classes3.dex */
    public class a extends ee6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseWebView baseWebView) {
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
            this.b = baseWebView;
        }

        public boolean b(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                if (!vd6.b(map)) {
                    return TextUtils.equals(map.get("tieba-response-via"), PrefetchEvent.MODULE);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ee6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) && webView != null && webView.getContext() != null) {
                if (!TextUtils.equals("about:blank", str) && this.b.s.get()) {
                    this.b.s.set(false);
                    webView.clearHistory();
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.ee6, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            WebResourceResponse a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest)) == null) {
                if (webView != null && (a = ic6.b().a(webView.getOriginalUrl(), webResourceRequest)) != null) {
                    try {
                        Map<String, String> responseHeaders = a.getResponseHeaders();
                        if (this.b.m != null && b(responseHeaders)) {
                            this.b.m.a(webResourceRequest.getUrl().getPath(), responseHeaders.get("tieba-response-time"), Long.valueOf(System.currentTimeMillis()));
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
        super(n(context));
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
        this.p = true;
        this.q = new a(this);
        this.r = new BridgeWebChromeClient(new fsa() { // from class: com.baidu.tieba.kb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.fsa
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BaseWebView.this.getOriginalUrl() : invokeV.objValue;
            }
        }, new bsa() { // from class: com.baidu.tieba.lb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bsa
            public final void call() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BaseWebView.this.reload();
                }
            }
        });
        this.s = new AtomicBoolean(true);
        this.t = new kc6();
        this.v = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(n(context), attributeSet);
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
        this.p = true;
        this.q = new a(this);
        this.r = new BridgeWebChromeClient(new fsa() { // from class: com.baidu.tieba.kb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.fsa
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BaseWebView.this.getOriginalUrl() : invokeV.objValue;
            }
        }, new bsa() { // from class: com.baidu.tieba.lb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bsa
            public final void call() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BaseWebView.this.reload();
                }
            }
        });
        this.s = new AtomicBoolean(true);
        this.t = new kc6();
        this.v = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(n(context), attributeSet, i);
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
        this.p = true;
        this.q = new a(this);
        this.r = new BridgeWebChromeClient(new fsa() { // from class: com.baidu.tieba.kb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.fsa
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BaseWebView.this.getOriginalUrl() : invokeV.objValue;
            }
        }, new bsa() { // from class: com.baidu.tieba.lb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bsa
            public final void call() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BaseWebView.this.reload();
                }
            }
        });
        this.s = new AtomicBoolean(true);
        this.t = new kc6();
        this.v = new ArrayList();
    }

    public static Context n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return new MutableContextWrapper(context.createConfigurationContext(new Configuration()));
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
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
                    put(Config.LAUNCH_REFERER, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, webChromeClient) == null) {
            this.r.b(webChromeClient);
            super.setWebChromeClient(this.r);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, webViewClient) == null) {
            this.q.a(webViewClient);
            super.setWebViewClient(this.q);
        }
    }

    @Override // com.baidu.tieba.gd6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.v.add(Pair.create(str, str2));
        }
    }

    @Override // com.baidu.tieba.ce6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p = false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.s.get()) {
                return false;
            }
            return super.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
            super.destroy();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.j();
            this.u.b();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.e(context);
            setBackgroundColor(0);
            ae6.d(this);
            gt4.j(context);
            nb6.b(this);
            mb6.a(this);
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            if (this.u == null) {
                fb6 g = fb6.g(this);
                this.u = g;
                g.b();
            }
        }
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                Pair<Boolean, String> f = this.t.f(this, str);
                if (this.m != null) {
                    this.m.l(f.first.booleanValue());
                }
                return f.second;
            } catch (Exception e) {
                BdLog.e(e);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.t.b();
            kd6.a().b(this.v);
            this.u.a();
            this.v.clear();
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
            ae6.c(this);
            super.i();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            this.s.set(true);
            String p = p(str);
            w58 hybridLog = HybridLog.getInstance();
            hybridLog.c(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, "loadUrl:" + str + " additionalHttpHeaders:" + map);
            List<Pair<String, Long>> c = FetchDynamicResourceManager.c(p, map);
            je6 je6Var = this.m;
            if (je6Var != null) {
                je6Var.n(c);
            }
            super.loadUrl(p, map);
        }
    }
}
