package com.baidu.tbadk.coreExtra.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.TbChannelJsInterface;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fm9;
import com.baidu.tieba.hm9;
import com.baidu.tieba.it4;
import com.baidu.tieba.lg;
import com.baidu.tieba.ng8;
import com.baidu.tieba.q25;
import com.baidu.tieba.qt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class BaseWebView extends WebView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseWebView";
    public static final String TB_NA_CHANNEL = "__tb_channel__";
    public static final String USER_SKIN_OVERLAY = "user_skin_overlay=1";
    public transient /* synthetic */ FieldHolder $fh;
    public long initFinishedTime;
    public final long initStartTime;
    public hm9 jsCallback;
    public CommonTbJsBridge mCommonJsBridge;
    public Context mContext;
    public boolean mIsLoaded;
    public fm9 mJsBridge;
    public c mOnLoadUrlListener;
    public d mOnPageFinishedListener;
    public e mOnPageStartedListener;
    public f mOnProgressChangedListener;
    public g mOnReceivedErrorListener;
    public h mOnReceivedSslErrorListener;
    public i mOnScrollChangeListener;
    public j mWebChromeClient;
    public WebViewClient mWebViewClient;
    public View skinOverlayView;
    public TbChannelJsInterface tbChannelJsInterface;

    /* loaded from: classes3.dex */
    public interface c {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onPageFinished(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void d(WebView webView, String str);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void b(WebView webView, int i);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(WebView webView, int i, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this : (BaseWebView) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements hm9 {
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

        @Override // com.baidu.tieba.hm9
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                BaseWebView baseWebView = this.a;
                fm9 fm9Var = baseWebView.mJsBridge;
                if (fm9Var != null) {
                    return fm9Var.c(baseWebView.getWebView(), str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends WebViewClient {
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

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, renderProcessGoneDetail)) == null) {
                qt4.a(BaseWebView.TAG, webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
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

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.mIsLoaded = true;
                if (this.a.mOnPageFinishedListener != null) {
                    this.a.mOnPageFinishedListener.onPageFinished(webView, str);
                }
                ng8 hybridLog = HybridLog.getInstance();
                hybridLog.c(BaseWebView.TAG, "onPageFinished:" + str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.mOnPageStartedListener != null) {
                    this.a.mOnPageStartedListener.d(webView, str);
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
                ng8 hybridLog = HybridLog.getInstance();
                hybridLog.b(BaseWebView.TAG, "onReceivedError errorCode:" + i + " description:" + str + " failingUrl:" + str2);
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
                ng8 hybridLog = HybridLog.getInstance();
                hybridLog.b(BaseWebView.TAG, "onReceivedSslError error:" + sslError);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebView a;

        public j(BaseWebView baseWebView) {
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

        public /* synthetic */ j(BaseWebView baseWebView, a aVar) {
            this(baseWebView);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, webView, i) == null) {
                super.onProgressChanged(webView, i);
                if (this.a.mOnProgressChangedListener != null) {
                    this.a.mOnProgressChangedListener.b(webView, i);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) {
                if ((this.a.getContext() instanceof Activity) && lg.e((Activity) this.a.getContext())) {
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
                if ((this.a.getContext() instanceof Activity) && lg.e((Activity) this.a.getContext())) {
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
                if ((this.a.getContext() instanceof Activity) && lg.e((Activity) this.a.getContext())) {
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
                if (this.a.jsCallback != null && this.a.jsCallback.onJsPrompt(str2, jsPromptResult)) {
                    return true;
                }
                jsPromptResult.cancel();
                return true;
            }
            return invokeLLLLL.booleanValue;
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
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.initStartTime = System.currentTimeMillis();
        this.tbChannelJsInterface = null;
        this.jsCallback = new a(this);
        this.mContext = context;
        init();
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
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.initStartTime = System.currentTimeMillis();
        this.tbChannelJsInterface = null;
        this.jsCallback = new a(this);
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mContext = null;
        this.mIsLoaded = false;
        this.mOnScrollChangeListener = null;
        this.mOnLoadUrlListener = null;
        this.mOnPageStartedListener = null;
        this.mOnPageFinishedListener = null;
        this.mOnReceivedErrorListener = null;
        this.mOnReceivedSslErrorListener = null;
        this.mOnProgressChangedListener = null;
        this.initStartTime = System.currentTimeMillis();
        this.tbChannelJsInterface = null;
        this.jsCallback = new a(this);
        this.mContext = context;
        init();
    }

    public void initCommonJsBridge(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            CommonTbJsBridge commonTbJsBridge = new CommonTbJsBridge(context, this);
            this.mCommonJsBridge = commonTbJsBridge;
            this.mJsBridge.a(commonTbJsBridge);
        }
    }

    public final void registerPerformanceTracker(@NonNull TbChannelJsInterface tbChannelJsInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tbChannelJsInterface) == null) && tbChannelJsInterface != null) {
            this.tbChannelJsInterface = tbChannelJsInterface;
            tbChannelJsInterface.setWebViewInitStartTime(this.initStartTime);
            this.tbChannelJsInterface.setWebViewInitFinishTime(this.initFinishedTime);
            addJavascriptInterface(tbChannelJsInterface, TB_NA_CHANNEL);
        }
    }

    @RequiresApi(api = 21)
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
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

    public void setOnJsPromptCallback(hm9 hm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hm9Var) == null) {
            this.jsCallback = hm9Var;
        }
    }

    public void setOnLoadUrlListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.mOnLoadUrlListener = cVar;
        }
    }

    public void setOnPageFinishedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.mOnPageFinishedListener = dVar;
        }
    }

    public void setOnPageStartedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.mOnPageStartedListener = eVar;
        }
    }

    public void setOnProgressChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            this.mOnProgressChangedListener = fVar;
        }
    }

    public void setOnReceivedErrorListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.mOnReceivedErrorListener = gVar;
        }
    }

    public void setOnReceivedSslErrorListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            this.mOnReceivedSslErrorListener = hVar;
        }
    }

    public void setOnScrollChangeListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iVar) == null) {
            this.mOnScrollChangeListener = iVar;
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, webChromeClient) == null) {
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, webViewClient) == null) {
            super.setWebViewClient(webViewClient);
        }
    }

    public void setWebViewSkinOverly(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(USER_SKIN_OVERLAY)) {
                showSkinOverly();
            } else {
                hideSkinOverly();
            }
        }
    }

    public void sendNotification(String str, HashMap hashMap) {
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, hashMap) == null) && (fm9Var = this.mJsBridge) != null) {
            fm9Var.i(getWebView(), str, hashMap);
        }
    }

    private void hideSkinOverly() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && (view2 = this.skinOverlayView) != null) {
            view2.setVisibility(8);
        }
    }

    private void showSkinOverly() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && (view2 = this.skinOverlayView) != null) {
            view2.setVisibility(0);
            q25.d(this.skinOverlayView).f(R.color.CAM_X0503);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIsLoaded;
        }
        return invokeV.booleanValue;
    }

    public void reshow() {
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (fm9Var = this.mJsBridge) != null) {
            fm9Var.i(getWebView(), CommonTbJsBridge.RE_SHOW, null);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setCacheMode(2);
            getSettings().setUseWideViewPort(true);
            getSettings().setUserAgentString(getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion() + " skin/" + SkinManager.getCurrentSkinTypeString());
            it4.a(getSettings());
            this.mWebViewClient = new b(this);
            this.mWebChromeClient = new j(this, null);
            this.mJsBridge = new fm9();
            setWebViewClient(this.mWebViewClient);
            setWebChromeClient(this.mWebChromeClient);
            if (Build.VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            it4.j(getContext());
            if (Build.VERSION.SDK_INT >= 21) {
                setAcceptThirdPartyCookies(true);
                getSettings().setMixedContentMode(0);
            }
            initSkinOverlyView();
            this.initFinishedTime = System.currentTimeMillis();
        }
    }

    private void initSkinOverlyView() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && (context = this.mContext) != null && this.skinOverlayView == null) {
            View view2 = new View(context);
            this.skinOverlayView = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.skinOverlayView);
            this.skinOverlayView.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mJsBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.mJsBridge.i(getWebView(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
            View view2 = this.skinOverlayView;
            if (view2 != null) {
                q25.d(view2).f(R.color.CAM_X0503);
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TbChannelJsInterface tbChannelJsInterface = this.tbChannelJsInterface;
            if (tbChannelJsInterface != null) {
                tbChannelJsInterface.startLoadUrl(str);
            }
            ng8 hybridLog = HybridLog.getInstance();
            hybridLog.c(TAG, "loadUrl:" + str);
            super.loadUrl(str);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) {
            TbChannelJsInterface tbChannelJsInterface = this.tbChannelJsInterface;
            if (tbChannelJsInterface != null) {
                tbChannelJsInterface.startLoadUrl(str);
            }
            ng8 hybridLog = HybridLog.getInstance();
            hybridLog.c(TAG, "loadUrl:" + str + " additionalHttpHeaders:" + map);
            super.loadUrl(str, map);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            i iVar = this.mOnScrollChangeListener;
            if (iVar != null) {
                iVar.onScrollChanged(i2, i3, i4, i5);
            }
            View view2 = this.skinOverlayView;
            if (view2 != null && view2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.skinOverlayView.getLayoutParams();
                layoutParams.height = getHeight() + i3;
                this.skinOverlayView.setLayoutParams(layoutParams);
            }
        }
    }
}
