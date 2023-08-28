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
import com.baidu.tieba.an6;
import com.baidu.tieba.bm6;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.cm6;
import com.baidu.tieba.cn6;
import com.baidu.tieba.dm6;
import com.baidu.tieba.em6;
import com.baidu.tieba.fm6;
import com.baidu.tieba.fn6;
import com.baidu.tieba.hn6;
import com.baidu.tieba.in6;
import com.baidu.tieba.lcc;
import com.baidu.tieba.pm6;
import com.baidu.tieba.wm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class MonitorWebView extends NestedScrollWebView implements hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public in6 n;
    public String o;
    public int p;
    public int q;
    public bm6 r;
    public dm6 s;
    public cm6 t;
    public em6 u;
    public fm6 v;
    public PreRenderMode w;
    public final lcc<Pair<Integer, Double>> x;
    public final an6 y;

    public void setTargetInterceptor(@Nullable wm6 wm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wm6Var) == null) {
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends fn6 {
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

        @Override // com.baidu.tieba.zl6
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) && this.a.v != null) {
                this.a.v.a(webView, sslErrorHandler, sslError);
            }
        }

        @Override // com.baidu.tieba.zl6
        public void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, i, charSequence) == null) && this.a.u != null) {
                this.a.u.a(webView, webResourceRequest, i, charSequence);
            }
        }

        @Override // com.baidu.tieba.zl6
        public void d(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                monitorWebView.q = 1;
                if (monitorWebView.s != null) {
                    this.a.s.d(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.zl6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                if (monitorWebView.q == 1) {
                    monitorWebView.q = 2;
                }
                if (this.a.t != null) {
                    this.a.t.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.zl6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (this.a.r != null) {
                    return this.a.r.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
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
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = PreRenderMode.NONE;
        this.x = lcc.Q();
        cn6 cn6Var = new cn6(null, new a(this));
        this.y = cn6Var;
        super.setWebViewClient(cn6Var);
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
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = PreRenderMode.NONE;
        this.x = lcc.Q();
        cn6 cn6Var = new cn6(null, new a(this));
        this.y = cn6Var;
        super.setWebViewClient(cn6Var);
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
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = PreRenderMode.NONE;
        this.x = lcc.Q();
        cn6 cn6Var = new cn6(null, new a(this));
        this.y = cn6Var;
        super.setWebViewClient(cn6Var);
    }

    public void setOnLoadUrlListener(bm6 bm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bm6Var) == null) {
            this.r = bm6Var;
        }
    }

    public void setOnPageFinishedListener(cm6 cm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cm6Var) == null) {
            this.t = cm6Var;
        }
    }

    public void setOnPageStartedListener(dm6 dm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dm6Var) == null) {
            this.s = dm6Var;
        }
    }

    public void setOnReceivedErrorListener(em6 em6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, em6Var) == null) {
            this.u = em6Var;
        }
    }

    public void setOnReceivedSslErrorListener(fm6 fm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fm6Var) == null) {
            this.v = fm6Var;
        }
    }

    public void setPerfData(in6 in6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, in6Var) == null) {
            this.n = in6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, preRenderMode) == null) {
            this.w = preRenderMode;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, webViewClient) == null) {
            this.y.b(webViewClient);
        }
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public PreRenderMode getPreRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w;
        }
        return (PreRenderMode) invokeV.objValue;
    }

    public lcc<Pair<Integer, Double>> getViewHeightBs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.x;
        }
        return (lcc) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o("event_show", "");
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t();
            this.n = null;
            this.o = null;
            this.w = PreRenderMode.NONE;
            this.x.onNext(null);
            super.setNeedDisAllowParentInterceptTouchEvent(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i();
            setDownloadListener(null);
            setOnDoubleClickListener(null);
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.w = PreRenderMode.NONE;
            this.n = null;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) {
            if (URLUtil.isNetworkUrl(str) || URLUtil.isFileUrl(str)) {
                map.put("Accept", SapiWebView.DATA_MIME_TYPE);
                this.o = pm6.c(str);
            }
            in6 in6Var = this.n;
            if (in6Var != null) {
                in6Var.s(str);
            }
            super.loadUrl(str, map);
        }
    }

    @UiThread
    public void o(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
        }
    }

    public void q(int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
            this.x.onNext(Pair.create(Integer.valueOf(i), Double.valueOf(d)));
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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
