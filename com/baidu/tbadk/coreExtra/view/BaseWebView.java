package com.baidu.tbadk.coreExtra.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class BaseWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.k3.m0.c jsCallback;
    public CommonTbJsBridge mCommonJsBridge;
    public Context mContext;
    public d mDownloadListener;
    public boolean mIsLoaded;
    public c.a.r0.k3.m0.a mJsBridge;
    public d mOnLoadUrlListener;
    public e mOnPageFinishedListener;
    public f mOnPageStartedListener;
    public g mOnProgressChangedListener;
    public h mOnReceivedErrorListener;
    public i mOnReceivedSslErrorListener;
    public j mWebChromeClient;
    public WebViewClient mWebViewClient;

    /* loaded from: classes6.dex */
    public class a implements c.a.r0.k3.m0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f48168a;

        public a(BaseWebView baseWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48168a = baseWebView;
        }

        @Override // c.a.r0.k3.m0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                BaseWebView baseWebView = this.f48168a;
                c.a.r0.k3.m0.a aVar = baseWebView.mJsBridge;
                if (aVar != null) {
                    return aVar.b(baseWebView.getWebView(), str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f48169e;

        public b(BaseWebView baseWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48169e = baseWebView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (str == null) {
                    return true;
                }
                try {
                    c.a.q0.m.a.j(this.f48169e.mContext, str);
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f48170a;

        public c(BaseWebView baseWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48170a = baseWebView;
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
                this.f48170a.mIsLoaded = true;
                if (this.f48170a.mOnPageFinishedListener != null) {
                    this.f48170a.mOnPageFinishedListener.onPageFinished(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f48170a.mOnPageStartedListener != null) {
                    this.f48170a.mOnPageStartedListener.a(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (this.f48170a.mOnReceivedErrorListener != null) {
                    this.f48170a.mOnReceivedErrorListener.a(webView, i2, str, str2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"Override"})
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, sslErrorHandler, sslError) == null) {
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
                if (this.f48170a.mOnReceivedSslErrorListener != null) {
                    this.f48170a.mOnReceivedSslErrorListener.a(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, renderProcessGoneDetail)) == null) {
                c.a.q0.m.f.a("BaseWebView", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) ? super.shouldInterceptRequest(webView, str) : (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
                if (this.f48170a.mOnLoadUrlListener != null) {
                    return this.f48170a.mOnLoadUrlListener.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(WebView webView, String str);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(WebView webView, int i2);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(WebView webView, int i2, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    /* loaded from: classes6.dex */
    public class j extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f48171a;

        public j(BaseWebView baseWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48171a = baseWebView;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) {
                if ((this.f48171a.getContext() instanceof Activity) && c.a.e.e.m.g.e((Activity) this.f48171a.getContext())) {
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
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, jsResult)) == null) {
                if ((this.f48171a.getContext() instanceof Activity) && c.a.e.e.m.g.e((Activity) this.f48171a.getContext())) {
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
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
                if ((this.f48171a.getContext() instanceof Activity) && c.a.e.e.m.g.e((Activity) this.f48171a.getContext())) {
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
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, webView, str, str2, str3, jsPromptResult)) == null) {
                if (this.f48171a.jsCallback == null || !this.f48171a.jsCallback.onJsPrompt(str2, jsPromptResult)) {
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
            if (interceptable == null || interceptable.invokeLI(1048580, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                if (this.f48171a.mOnProgressChangedListener != null) {
                    this.f48171a.mOnProgressChangedListener.a(webView, i2);
                }
            }
        }

        public /* synthetic */ j(BaseWebView baseWebView, a aVar) {
            this(baseWebView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context) {
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
        this.mContext = null;
        this.mIsLoaded = false;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.jsCallback = new a(this);
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this : (BaseWebView) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setCacheMode(2);
            getSettings().setUseWideViewPort(true);
            getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion() + " skin/" + SkinManager.getCurrentSkinTypeString());
            c.a.q0.m.a.a(getSettings());
            this.mWebViewClient = new c(this);
            this.mWebChromeClient = new j(this, null);
            this.mJsBridge = new c.a.r0.k3.m0.a();
            setWebViewClient(this.mWebViewClient);
            setWebChromeClient(this.mWebChromeClient);
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            c.a.q0.m.a.f(getContext());
            if (Build.VERSION.SDK_INT >= 21) {
                setAcceptThirdPartyCookies(true);
                getSettings().setMixedContentMode(0);
            }
        }
    }

    private void initDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mDownloadListener = new b(this);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            CommonTbJsBridge commonTbJsBridge = this.mCommonJsBridge;
            if (commonTbJsBridge != null) {
                commonTbJsBridge.onDestroy();
            }
            this.mContext = null;
            this.mWebViewClient = null;
            this.mWebChromeClient = null;
            this.mDownloadListener = null;
            this.mOnLoadUrlListener = null;
            this.mOnPageStartedListener = null;
            this.mOnPageFinishedListener = null;
            this.mOnReceivedErrorListener = null;
            this.mOnReceivedSslErrorListener = null;
            this.mOnProgressChangedListener = null;
            this.jsCallback = null;
        }
    }

    public boolean getIsLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsLoaded : invokeV.booleanValue;
    }

    public void initCommonJsBridge(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            CommonTbJsBridge commonTbJsBridge = new CommonTbJsBridge(context, this);
            this.mCommonJsBridge = commonTbJsBridge;
            this.mJsBridge.a(commonTbJsBridge);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mJsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
        this.mJsBridge.h(getWebView(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
    }

    public void resetProxy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            CompatibleUtile.dealWebView(null);
        }
    }

    public void sendNotification(String str, HashMap hashMap) {
        c.a.r0.k3.m0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, hashMap) == null) || (aVar = this.mJsBridge) == null) {
            return;
        }
        aVar.h(getWebView(), str, hashMap);
    }

    @RequiresApi(api = 21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            try {
                CookieSyncManager.createInstance(getContext());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                BdLog.e(th);
                cookieManager = null;
            }
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(this, z);
            }
        }
    }

    public void setDownloadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.mDownloadListener == null) {
                    initDownload();
                }
                setOnLoadUrlListener(this.mDownloadListener);
                return;
            }
            setOnLoadUrlListener(null);
        }
    }

    public void setOnJsPromptCallback(c.a.r0.k3.m0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.jsCallback = cVar;
        }
    }

    public void setOnLoadUrlListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.mOnLoadUrlListener = dVar;
        }
    }

    public void setOnPageFinishedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.mOnPageFinishedListener = eVar;
        }
    }

    public void setOnPageStartedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.mOnPageStartedListener = fVar;
        }
    }

    public void setOnProgressChangedListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.mOnProgressChangedListener = gVar;
        }
    }

    public void setOnReceivedErrorListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
            this.mOnReceivedErrorListener = hVar;
        }
    }

    public void setOnReceivedSslErrorListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            this.mOnReceivedSslErrorListener = iVar;
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, webChromeClient) == null) {
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webViewClient) == null) {
            super.setWebViewClient(webViewClient);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet) {
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
        this.mContext = null;
        this.mIsLoaded = false;
        this.mDownloadListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.jsCallback = new a(this);
        this.mContext = context;
        init();
    }
}
