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
import com.baidu.tieba.gp4;
import com.baidu.tieba.ih;
import com.baidu.tieba.wn8;
import com.baidu.tieba.yn8;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class BaseWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yn8 jsCallback;
    public CommonTbJsBridge mCommonJsBridge;
    public Context mContext;
    public d mDownloadListener;
    public boolean mIsLoaded;
    public wn8 mJsBridge;
    public d mOnLoadUrlListener;
    public e mOnPageFinishedListener;
    public f mOnPageStartedListener;
    public g mOnProgressChangedListener;
    public h mOnReceivedErrorListener;
    public i mOnReceivedSslErrorListener;
    public j mOnScrollChangeListener;
    public k mWebChromeClient;
    public WebViewClient mWebViewClient;

    /* loaded from: classes3.dex */
    public class a implements yn8 {
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

        @Override // com.baidu.tieba.yn8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                BaseWebView baseWebView = this.a;
                wn8 wn8Var = baseWebView.mJsBridge;
                if (wn8Var != null) {
                    return wn8Var.b(baseWebView.getWebView(), str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView a;

        public b(BaseWebView baseWebView) {
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

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (str == null) {
                    return true;
                }
                try {
                    yo4.l(this.a.mContext, str);
                } catch (Exception e) {
                    BdLog.e(e.toString());
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView a;

        public c(BaseWebView baseWebView) {
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
                this.a.mIsLoaded = true;
                if (this.a.mOnPageFinishedListener != null) {
                    this.a.mOnPageFinishedListener.onPageFinished(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.mOnPageStartedListener != null) {
                    this.a.mOnPageStartedListener.D0(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.mOnReceivedErrorListener != null) {
                    this.a.mOnReceivedErrorListener.a(webView, i, str, str2);
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
                if (this.a.mOnReceivedSslErrorListener != null) {
                    this.a.mOnReceivedSslErrorListener.a(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, renderProcessGoneDetail)) == null) {
                gp4.a("BaseWebView", webView);
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
                if (this.a.mOnLoadUrlListener != null) {
                    return this.a.mOnLoadUrlListener.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void D0(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(WebView webView, int i);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(WebView webView, int i, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public class k extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView a;

        public k(BaseWebView baseWebView) {
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

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) {
                if ((this.a.getContext() instanceof Activity) && ih.e((Activity) this.a.getContext())) {
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
                if ((this.a.getContext() instanceof Activity) && ih.e((Activity) this.a.getContext())) {
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
                if ((this.a.getContext() instanceof Activity) && ih.e((Activity) this.a.getContext())) {
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
                if (this.a.jsCallback == null || !this.a.jsCallback.onJsPrompt(str2, jsPromptResult)) {
                    jsPromptResult.cancel();
                    return true;
                }
                return true;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, webView, i) == null) {
                super.onProgressChanged(webView, i);
                if (this.a.mOnProgressChangedListener != null) {
                    this.a.mOnProgressChangedListener.a(webView, i);
                }
            }
        }

        public /* synthetic */ k(BaseWebView baseWebView, a aVar) {
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
        this.mOnScrollChangeListener = null;
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
            yo4.a(getSettings());
            this.mWebViewClient = new c(this);
            this.mWebChromeClient = new k(this, null);
            this.mJsBridge = new wn8();
            setWebViewClient(this.mWebViewClient);
            setWebChromeClient(this.mWebChromeClient);
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            yo4.g(getContext());
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

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            j jVar = this.mOnScrollChangeListener;
            if (jVar != null) {
                jVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    public void resetProxy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            CompatibleUtile.dealWebView(null);
        }
    }

    public void sendNotification(String str, HashMap hashMap) {
        wn8 wn8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) || (wn8Var = this.mJsBridge) == null) {
            return;
        }
        wn8Var.h(getWebView(), str, hashMap);
    }

    @RequiresApi(api = 21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
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

    public void setOnJsPromptCallback(yn8 yn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yn8Var) == null) {
            this.jsCallback = yn8Var;
        }
    }

    public void setOnLoadUrlListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.mOnLoadUrlListener = dVar;
        }
    }

    public void setOnPageFinishedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.mOnPageFinishedListener = eVar;
        }
    }

    public void setOnPageStartedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.mOnPageStartedListener = fVar;
        }
    }

    public void setOnProgressChangedListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.mOnProgressChangedListener = gVar;
        }
    }

    public void setOnReceivedErrorListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            this.mOnReceivedErrorListener = hVar;
        }
    }

    public void setOnReceivedSslErrorListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) {
            this.mOnReceivedSslErrorListener = iVar;
        }
    }

    public void setOnScrollChangeListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jVar) == null) {
            this.mOnScrollChangeListener = jVar;
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, webChromeClient) == null) {
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, webViewClient) == null) {
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
        this.mOnScrollChangeListener = null;
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
