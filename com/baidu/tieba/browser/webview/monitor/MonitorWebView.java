package com.baidu.tieba.browser.webview.monitor;

import android.content.Context;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.UiThread;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.co6;
import com.baidu.tieba.mo6;
import com.baidu.tieba.on6;
import com.baidu.tieba.oo6;
import com.baidu.tieba.p6c;
import com.baidu.tieba.pn6;
import com.baidu.tieba.qn6;
import com.baidu.tieba.rn6;
import com.baidu.tieba.ro6;
import com.baidu.tieba.sn6;
import com.baidu.tieba.so6;
import com.baidu.tieba.to6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class MonitorWebView extends NestedScrollWebView implements so6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public to6 n;
    public String o;
    public on6 p;
    public qn6 q;
    public pn6 r;
    public rn6 s;
    public sn6 t;
    public PreRenderMode u;
    public final p6c<Pair<Integer, Double>> v;
    public final mo6 w;

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends ro6 {
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

        @Override // com.baidu.tieba.mn6
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) && this.a.t != null) {
                this.a.t.a(webView, sslErrorHandler, sslError);
            }
        }

        @Override // com.baidu.tieba.mn6
        public void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, i, charSequence) == null) && this.a.s != null) {
                this.a.s.a(webView, webResourceRequest, i, charSequence);
            }
        }

        @Override // com.baidu.tieba.mn6
        public void c(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) && this.a.q != null) {
                this.a.q.c(webView, str);
            }
        }

        @Override // com.baidu.tieba.mn6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) && this.a.r != null) {
                this.a.r.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.mn6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (this.a.p != null) {
                    return this.a.p.shouldOverrideUrlLoading(webView, str);
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
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = PreRenderMode.NONE;
        this.v = p6c.Q();
        oo6 oo6Var = new oo6(null, new a(this));
        this.w = oo6Var;
        super.setWebViewClient(oo6Var);
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
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = PreRenderMode.NONE;
        this.v = p6c.Q();
        oo6 oo6Var = new oo6(null, new a(this));
        this.w = oo6Var;
        super.setWebViewClient(oo6Var);
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
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = PreRenderMode.NONE;
        this.v = p6c.Q();
        oo6 oo6Var = new oo6(null, new a(this));
        this.w = oo6Var;
        super.setWebViewClient(oo6Var);
    }

    public void setOnLoadUrlListener(on6 on6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, on6Var) == null) {
            this.p = on6Var;
        }
    }

    public void setOnPageFinishedListener(pn6 pn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pn6Var) == null) {
            this.r = pn6Var;
        }
    }

    public void setOnPageStartedListener(qn6 qn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qn6Var) == null) {
            this.q = qn6Var;
        }
    }

    public void setOnReceivedErrorListener(rn6 rn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rn6Var) == null) {
            this.s = rn6Var;
        }
    }

    public void setOnReceivedSslErrorListener(sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sn6Var) == null) {
            this.t = sn6Var;
        }
    }

    public void setPerfData(to6 to6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, to6Var) == null) {
            this.n = to6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, preRenderMode) == null) {
            this.u = preRenderMode;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webViewClient) == null) {
            this.w.b(webViewClient);
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
            return this.u;
        }
        return (PreRenderMode) invokeV.objValue;
    }

    public p6c<Pair<Integer, Double>> getViewHeightBs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.v;
        }
        return (p6c) invokeV.objValue;
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
            this.u = PreRenderMode.NONE;
            this.v.onNext(null);
            super.setNeedDisAllowParentInterceptTouchEvent(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i();
            setDownloadListener(null);
            setOnDoubleClickListener(null);
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
            this.t = null;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.u = PreRenderMode.NONE;
            this.n = null;
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) {
            if (URLUtil.isNetworkUrl(str) || URLUtil.isFileUrl(str)) {
                map.put("Accept", SapiWebView.DATA_MIME_TYPE);
                this.o = co6.c(str);
            }
            to6 to6Var = this.n;
            if (to6Var != null) {
                to6Var.s(str);
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
            this.v.onNext(Pair.create(Integer.valueOf(i), Double.valueOf(d)));
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
