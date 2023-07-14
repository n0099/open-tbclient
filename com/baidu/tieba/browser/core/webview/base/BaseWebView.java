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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.fl6;
import com.baidu.tieba.fn6;
import com.baidu.tieba.fo6;
import com.baidu.tieba.gl6;
import com.baidu.tieba.h29;
import com.baidu.tieba.hm6;
import com.baidu.tieba.jn6;
import com.baidu.tieba.kn6;
import com.baidu.tieba.lm6;
import com.baidu.tieba.lo6;
import com.baidu.tieba.mo6;
import com.baidu.tieba.nx4;
import com.baidu.tieba.ol6;
import com.baidu.tieba.pl6;
import com.baidu.tieba.pn6;
import com.baidu.tieba.ql6;
import com.baidu.tieba.to6;
import com.baidu.tieba.xn6;
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
public class BaseWebView extends MonitorWebView implements fn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean A;
    public final lm6 B;
    public final fl6 C;
    public final List<Pair<String, String>> D;
    public pn6 E;
    public boolean x;
    public final a y;
    public final lo6 z;

    /* loaded from: classes5.dex */
    public class a extends mo6 {
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

        public boolean c(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
                if (!xn6.b(map)) {
                    return TextUtils.equals(map.get("tieba-response-via"), PrefetchEvent.MODULE);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.mo6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            pn6 pn6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) && webView != null && webView.getContext() != null) {
                if (str.startsWith("file:///android_asset/blank.html") && (pn6Var = this.b.E) != null) {
                    pn6Var.onPageFinished(webView, str);
                }
                if (!TextUtils.equals("about:blank", str) && this.b.A.get()) {
                    this.b.A.set(false);
                    webView.clearHistory();
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.mo6, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            WebResourceResponse a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest)) == null) {
                if (webView != null && (a = hm6.b().a(webView.getOriginalUrl(), webResourceRequest)) != null) {
                    try {
                        Map<String, String> responseHeaders = a.getResponseHeaders();
                        if (this.b.n != null && c(responseHeaders)) {
                            this.b.n.a(webResourceRequest.getUrl().getPath(), responseHeaders.get("tieba-response-time"), Long.valueOf(System.currentTimeMillis()));
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
        super(z(context));
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
        this.x = true;
        this.y = new a(this);
        this.z = new ql6();
        this.A = new AtomicBoolean(true);
        this.B = new lm6();
        this.C = gl6.g(this);
        this.D = new ArrayList();
        this.E = null;
        A();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(z(context), attributeSet);
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
        this.x = true;
        this.y = new a(this);
        this.z = new ql6();
        this.A = new AtomicBoolean(true);
        this.B = new lm6();
        this.C = gl6.g(this);
        this.D = new ArrayList();
        this.E = null;
        A();
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, map) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (p(str)) {
                this.A.set(true);
                String D = D(str);
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.c(com.baidu.tbadk.coreExtra.view.BaseWebView.TAG, this + " 开始加载 原始url:" + str + " 离线包转换后的url:" + D + " Headers:" + map);
                List<Pair<String, Long>> c = FetchDynamicResourceManager.c(D);
                if (this.n != null && !xn6.a(c)) {
                    this.n.p(c);
                }
                to6 to6Var = this.n;
                if (to6Var != null) {
                    to6Var.o(str);
                }
                str = D;
            }
            super.loadUrl(str, map);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(z(context), attributeSet, i);
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
        this.x = true;
        this.y = new a(this);
        this.z = new ql6();
        this.A = new AtomicBoolean(true);
        this.B = new lm6();
        this.C = gl6.g(this);
        this.D = new ArrayList();
        this.E = null;
        A();
    }

    public static Context z(Context context) {
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

    public void C(pn6 pn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pn6Var) == null) {
            super.loadUrl("file:///android_asset/blank.html");
            this.E = pn6Var;
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

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, webChromeClient) == null) {
            this.z.c(webChromeClient);
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, webViewClient) == null) {
            this.y.b(webViewClient);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundColor(0);
            fo6.e(this);
            nx4.k(getContext());
            pl6.b(this);
            ol6.a(this);
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            super.setWebChromeClient(this.z);
            super.setWebViewClient(this.y);
            u();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.E = null;
        }
    }

    @Override // com.baidu.tieba.so6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.x = false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.A.get()) {
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.u();
            kn6.b().c(this);
            this.C.b();
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public String D(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Pair<Boolean, String> g = this.B.g(this, str);
                if (this.n != null) {
                    h29 hybridLog = HybridLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    if (g.first.booleanValue()) {
                        str2 = "有离线包";
                    } else {
                        str2 = "没有离线包";
                    }
                    sb.append(str2);
                    sb.append(", url: ");
                    sb.append(str);
                    hybridLog.c("Offline", sb.toString());
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

    @Override // com.baidu.tieba.fn6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.D.add(Pair.create(str, str2));
        }
    }

    @Override // com.baidu.tieba.browser.webview.monitor.MonitorWebView
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.B.c();
            super.loadUrl("file:///android_asset/blank.html");
            kn6.b().d(this);
            jn6.a().a(this.D);
            this.C.a();
            this.D.clear();
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
            fo6.d(this);
            super.s();
        }
    }
}
