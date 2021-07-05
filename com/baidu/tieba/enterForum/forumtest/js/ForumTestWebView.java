package com.baidu.tieba.enterForum.forumtest.js;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForumTestWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WebViewClient f14620e;

    /* renamed from: f  reason: collision with root package name */
    public h f14621f;

    /* renamed from: g  reason: collision with root package name */
    public c f14622g;

    /* renamed from: h  reason: collision with root package name */
    public e f14623h;

    /* renamed from: i  reason: collision with root package name */
    public d f14624i;
    public f j;
    public g k;
    public d.a.s0.l0.e.a.a l;
    public d.a.s0.l0.e.a.c m;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.l0.e.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestWebView f14625a;

        public a(ForumTestWebView forumTestWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14625a = forumTestWebView;
        }

        @Override // d.a.s0.l0.e.a.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                d.a.s0.l0.e.a.a aVar = this.f14625a.l;
                if (aVar != null) {
                    return aVar.b(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestWebView f14626a;

        public b(ForumTestWebView forumTestWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14626a = forumTestWebView;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.f14626a.f14624i != null) {
                    this.f14626a.f14624i.onPageFinished(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f14626a.f14623h != null) {
                    this.f14626a.f14623h.a(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) ? super.shouldInterceptRequest(webView, str) : (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (this.f14626a.f14622g != null) {
                    return this.f14626a.f14622g.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(WebView webView, String str);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(WebView webView, int i2);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(String str);
    }

    /* loaded from: classes5.dex */
    public class h extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumTestWebView f14627a;

        public h(ForumTestWebView forumTestWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14627a = forumTestWebView;
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrameLayout frameLayout = new FrameLayout(this.f14627a.getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return frameLayout;
            }
            return (View) invokeV.objValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                quotaUpdater.updateQuota(j2 * 2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
                if ((this.f14627a.getContext() instanceof Activity) && d.a.c.e.m.g.e((Activity) this.f14627a.getContext())) {
                    return super.onJsAlert(webView, str, str2, jsResult);
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
                if ((this.f14627a.getContext() instanceof Activity) && d.a.c.e.m.g.e((Activity) this.f14627a.getContext())) {
                    return super.onJsBeforeUnload(webView, str, str2, jsResult);
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
                if ((this.f14627a.getContext() instanceof Activity) && d.a.c.e.m.g.e((Activity) this.f14627a.getContext())) {
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
                if (this.f14627a.m == null || !this.f14627a.m.onJsPrompt(str2, jsPromptResult)) {
                    jsPromptResult.cancel();
                    return true;
                }
                return true;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                if (this.f14627a.j != null) {
                    this.f14627a.j.a(webView, i2);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f14627a.k != null) {
                    this.f14627a.k.a(str);
                }
            }
        }

        public /* synthetic */ h(ForumTestWebView forumTestWebView, a aVar) {
            this(forumTestWebView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            this.f14620e = null;
            this.f14621f = null;
            this.f14622g = null;
            this.f14623h = null;
            this.f14624i = null;
            this.j = null;
            this.k = null;
            this.m = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void g(d.a.s0.l0.e.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setAllowFileAccess(true);
            getSettings().setDatabaseEnabled(true);
            getSettings().setDomStorageEnabled(true);
            getSettings().setUseWideViewPort(true);
            getSettings().setSupportZoom(true);
            getSettings().setBuiltInZoomControls(true);
            getSettings().setCacheMode(2);
            getSettings().setDatabasePath(getContext().getDir("databases", 0).getAbsolutePath());
            setHorizontalScrollBarEnabled(false);
            setHorizontalScrollbarOverlay(false);
            setInitialScale(100);
            setScrollBarStyle(33554432);
            getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion());
            WebViewClient bVar2 = new b(this);
            this.f14620e = bVar2;
            setWebViewClient(bVar2);
            h hVar = new h(this, null);
            this.f14621f = hVar;
            setWebChromeClient(hVar);
            d.a.s0.l0.e.a.a aVar = new d.a.s0.l0.e.a.a();
            this.l = aVar;
            aVar.a(bVar);
            d.a.r0.l.a.f(getContext());
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            if (Build.VERSION.SDK_INT >= 21) {
                setAcceptThirdPartyCookies(true);
                getSettings().setMixedContentMode(0);
            }
        }
    }

    @TargetApi(21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                CookieSyncManager.createInstance(getContext());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable unused) {
                cookieManager = null;
            }
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(this, z);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            try {
                super.setOverScrollMode(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new a(this);
    }
}
