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
import com.baidu.tieba.bn6;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.cn6;
import com.baidu.tieba.co6;
import com.baidu.tieba.dn6;
import com.baidu.tieba.eo6;
import com.baidu.tieba.ho6;
import com.baidu.tieba.jo6;
import com.baidu.tieba.ko6;
import com.baidu.tieba.ofc;
import com.baidu.tieba.rj6;
import com.baidu.tieba.rn6;
import com.baidu.tieba.yn6;
import com.baidu.tieba.zm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class MonitorWebView extends NestedScrollWebView implements jo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final co6 A;
    public ko6 n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public zm6 s;
    public bn6 t;
    public an6 u;
    public cn6 v;
    public dn6 w;
    public PreRenderMode x;
    public final ofc<Pair<Integer, Double>> y;
    public rj6<Object> z;

    public void setTargetInterceptor(@Nullable yn6 yn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yn6Var) == null) {
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
    public class a extends ho6 {
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

        @Override // com.baidu.tieba.xm6
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) && this.a.w != null) {
                this.a.w.a(webView, sslErrorHandler, sslError);
            }
        }

        @Override // com.baidu.tieba.xm6
        public void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, i, charSequence) == null) && this.a.v != null) {
                this.a.v.a(webView, webResourceRequest, i, charSequence);
            }
        }

        @Override // com.baidu.tieba.xm6
        public void c(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                monitorWebView.q = 1;
                if (monitorWebView.t != null) {
                    this.a.t.c(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.xm6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
                MonitorWebView monitorWebView = this.a;
                if (monitorWebView.q == 1) {
                    monitorWebView.q = 2;
                }
                if (this.a.u != null) {
                    this.a.u.onPageFinished(webView, str);
                }
            }
        }

        @Override // com.baidu.tieba.xm6
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
        this.y = ofc.Q();
        eo6 eo6Var = new eo6(null, new a(this));
        this.A = eo6Var;
        super.setWebViewClient(eo6Var);
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
        this.y = ofc.Q();
        eo6 eo6Var = new eo6(null, new a(this));
        this.A = eo6Var;
        super.setWebViewClient(eo6Var);
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
        this.y = ofc.Q();
        eo6 eo6Var = new eo6(null, new a(this));
        this.A = eo6Var;
        super.setWebViewClient(eo6Var);
    }

    public void setInvalidPageCallback(rj6<Object> rj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rj6Var) == null) {
            this.z = rj6Var;
            if (this.r) {
                rj6Var.call();
            }
        }
    }

    public void setOnLoadUrlListener(zm6 zm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, zm6Var) == null) {
            this.s = zm6Var;
        }
    }

    public void setOnPageFinishedListener(an6 an6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, an6Var) == null) {
            this.u = an6Var;
        }
    }

    public void setOnPageStartedListener(bn6 bn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bn6Var) == null) {
            this.t = bn6Var;
        }
    }

    public void setOnReceivedErrorListener(cn6 cn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cn6Var) == null) {
            this.v = cn6Var;
        }
    }

    public void setOnReceivedSslErrorListener(dn6 dn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dn6Var) == null) {
            this.w = dn6Var;
        }
    }

    public void setPerfData(ko6 ko6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ko6Var) == null) {
            this.n = ko6Var;
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

    public rj6<Object> getInvalidPageCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return (rj6) invokeV.objValue;
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

    public ofc<Pair<Integer, Double>> getViewHeightBs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.y;
        }
        return (ofc) invokeV.objValue;
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
                this.o = rn6.c(str);
            }
            ko6 ko6Var = this.n;
            if (ko6Var != null) {
                ko6Var.s(str);
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
