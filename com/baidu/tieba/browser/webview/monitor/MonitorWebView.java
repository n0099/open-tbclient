package com.baidu.tieba.browser.webview.monitor;

import android.content.Context;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.ee6;
import com.baidu.tieba.ei6;
import com.baidu.tieba.fbc;
import com.baidu.tieba.li6;
import com.baidu.tieba.mh6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.oh6;
import com.baidu.tieba.ph6;
import com.baidu.tieba.pi6;
import com.baidu.tieba.qh6;
import com.baidu.tieba.ri6;
import com.baidu.tieba.ui6;
import com.baidu.tieba.yi6;
import com.baidu.tieba.zi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class MonitorWebView extends NestedScrollWebView implements yi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pi6 A;
    public zi6 n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public mh6 s;
    public oh6 t;
    public nh6 u;
    public ph6 v;
    public qh6 w;
    public PreRenderMode x;
    public final fbc<Pair<Integer, Double>> y;
    public ee6<Object> z;

    public void setTargetInterceptor(@Nullable li6 li6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, li6Var) == null) {
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends ui6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;

        public a(MonitorWebView monitorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {monitorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = monitorWebView;
        }

        @Override // com.baidu.tieba.kh6
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                monitorWebView.q = 1;
                if (monitorWebView.t != null) {
                    this.a.t.a(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.kh6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                if (monitorWebView.q == 1) {
                    monitorWebView.q = 2;
                }
                if (this.a.u != null) {
                    this.a.u.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.kh6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (this.a.s != null) {
                    return this.a.s.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.kh6
        public void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, i, charSequence) == null) && this.a.v != null) {
                this.a.v.a(webView, webResourceRequest, i, charSequence);
            }
        }

        @Override // com.baidu.tieba.kh6
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) && this.a.w != null) {
                this.a.w.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonitorWebView(Context context) {
        super(context);
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
        this.o = "";
        this.p = 0;
        this.q = -1;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = PreRenderMode.NONE;
        this.y = fbc.Q();
        ri6 ri6Var = new ri6(null, new a(this));
        this.A = ri6Var;
        super.setWebViewClient(ri6Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonitorWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        this.o = "";
        this.p = 0;
        this.q = -1;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = PreRenderMode.NONE;
        this.y = fbc.Q();
        ri6 ri6Var = new ri6(null, new a(this));
        this.A = ri6Var;
        super.setWebViewClient(ri6Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonitorWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.o = "";
        this.p = 0;
        this.q = -1;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = PreRenderMode.NONE;
        this.y = fbc.Q();
        ri6 ri6Var = new ri6(null, new a(this));
        this.A = ri6Var;
        super.setWebViewClient(ri6Var);
    }

    public void setInvalidPageCallback(ee6<Object> ee6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ee6Var) == null) {
            this.z = ee6Var;
            if (this.r) {
                ee6Var.call();
            }
        }
    }

    public void setOnLoadUrlListener(mh6 mh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mh6Var) == null) {
            this.s = mh6Var;
        }
    }

    public void setOnPageFinishedListener(nh6 nh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nh6Var) == null) {
            this.u = nh6Var;
        }
    }

    public void setOnPageStartedListener(oh6 oh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, oh6Var) == null) {
            this.t = oh6Var;
        }
    }

    public void setOnReceivedErrorListener(ph6 ph6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ph6Var) == null) {
            this.v = ph6Var;
        }
    }

    public void setOnReceivedSslErrorListener(qh6 qh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, qh6Var) == null) {
            this.w = qh6Var;
        }
    }

    public void setPerfData(zi6 zi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zi6Var) == null) {
            this.n = zi6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, preRenderMode) == null) {
            this.x = preRenderMode;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, webViewClient) == null) {
            this.A.b(webViewClient);
        }
    }

    public ee6<Object> getInvalidPageCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return (ee6) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public PreRenderMode getPreRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.x;
        }
        return (PreRenderMode) invokeV.objValue;
    }

    public fbc<Pair<Integer, Double>> getViewHeightBs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.y;
        }
        return (fbc) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            o("event_show", "");
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            t();
            this.n = null;
            this.o = null;
            this.x = PreRenderMode.NONE;
            this.y.onNext(null);
            super.setNeedDisAllowParentInterceptTouchEvent(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            i();
            setDownloadListener(null);
            setOnDoubleClickListener(null);
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.x = PreRenderMode.NONE;
            this.n = null;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) {
            if (URLUtil.isNetworkUrl(str) || URLUtil.isFileUrl(str)) {
                map.put("Accept", SapiWebView.DATA_MIME_TYPE);
                this.o = ei6.c(str);
            }
            zi6 zi6Var = this.n;
            if (zi6Var != null) {
                zi6Var.s(str);
            }
            super.loadUrl(str, map);
        }
    }

    @UiThread
    public void o(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
        }
    }

    public void q(int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
            this.y.onNext(Pair.create(Integer.valueOf(i), Double.valueOf(d)));
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            if (!URLUtil.isAssetUrl(str) && !URLUtil.isFileUrl(str) && !URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
