package com.baidu.tieba.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.mf6;
import com.baidu.tieba.ne6;
import com.baidu.tieba.of6;
import com.baidu.tieba.pf6;
import com.baidu.tieba.qf6;
import com.baidu.tieba.rf6;
import com.baidu.tieba.sf6;
import com.baidu.tieba.tf6;
import com.baidu.tieba.uf6;
import com.baidu.tieba.vb6;
import com.baidu.tieba.ve6;
import com.baidu.tieba.wb6;
import com.baidu.tieba.wf6;
import com.baidu.tieba.xb6;
import com.baidu.tieba.xe6;
import com.baidu.tieba.ye6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebView extends FrameLayout implements xb6, WebViewLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wf6 a;
    public MonitorWebView b;
    public SimpleWebViewLifeCycle c;
    public final qf6 d;
    public ve6 e;
    public final rf6 f;
    public final rf6 g;
    public ProgressBar h;
    public vb6<WebView> i;
    public final ne6 j;
    public String k;

    public /* synthetic */ xb6 p() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a extends rf6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbWebView tbWebView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebView};
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
            this.b = tbWebView;
        }

        @Override // com.baidu.tieba.rf6, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, renderProcessGoneDetail)) == null) {
                if (Build.VERSION.SDK_INT < 26) {
                    return false;
                }
                if (webView instanceof pf6) {
                    ((pf6) webView).b();
                }
                if (this.b.b != null && webView == this.b.b) {
                    this.b.b.b();
                    this.b.b.destroy();
                    this.b.b = null;
                    TbWebView tbWebView = this.b;
                    tbWebView.n(tbWebView.getContext());
                    TbWebView tbWebView2 = this.b;
                    tbWebView2.o(tbWebView2.i);
                    TbWebView tbWebView3 = this.b;
                    tbWebView3.r(tbWebView3.k);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebView(Context context) {
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
        this.a = new wf6();
        this.d = new uf6(new wb6() { // from class: com.baidu.tieba.tb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new tf6(this.f, new wb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ne6();
        this.k = null;
        n(context);
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.a.p(System.currentTimeMillis());
            WebView b = ((of6) ServiceManager.getService(of6.a)).b(context);
            if (b instanceof MonitorWebView) {
                this.b = (MonitorWebView) b;
            }
            this.c = new SimpleWebViewLifeCycle(this.b, null);
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(this.c);
            }
            this.b.setWebChromeClient(this.d);
            this.b.setWebViewClient(this.g);
            this.b.setPerfData(this.a);
            this.b.setVisibility(4);
            addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = this.h;
            if (progressBar != null) {
                progressBar.bringToFront();
            }
            this.a.o(System.currentTimeMillis());
            SimpleWebViewLifeCycle simpleWebViewLifeCycle = this.c;
            if (simpleWebViewLifeCycle != null) {
                simpleWebViewLifeCycle.b(this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebView(Context context, AttributeSet attributeSet) {
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
        this.a = new wf6();
        this.d = new uf6(new wb6() { // from class: com.baidu.tieba.tb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new tf6(this.f, new wb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ne6();
        this.k = null;
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new wf6();
        this.d = new uf6(new wb6() { // from class: com.baidu.tieba.tb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new tf6(this.f, new wb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.wb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ne6();
        this.k = null;
        n(context);
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.a.m(j);
        }
    }

    public void o(vb6<WebView> vb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vb6Var) == null) {
            this.i = vb6Var;
            if (vb6Var != null) {
                vb6Var.call(this.b);
            }
        }
    }

    public void setOnScrollChangeListener(xe6 xe6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xe6Var) == null) {
            this.b.setOnScrollChangeListener(xe6Var);
        }
    }

    public void setPageLifeCycle(ve6 ve6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ve6Var) == null) {
            this.e = ve6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, webChromeClient) == null) {
            this.d.b(webChromeClient);
        }
    }

    public final void setWebViewClient(rf6 rf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rf6Var) == null) {
            this.f.a(rf6Var);
        }
    }

    public final void z(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048594, this, i, drawable) == null) && this.h == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.h = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.h, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.xb6
    public void b(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            ProgressBar progressBar = this.h;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.j.a(this.h);
                } else {
                    mf6.e(progressBar, 0);
                    this.j.b(this.h, i);
                }
            }
            if (i >= 80) {
                mf6.e(webView, 0);
            }
        }
    }

    public WebView get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public sf6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getController();
        }
        return (sf6) invokeV.objValue;
    }

    public wf6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (wf6) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.c();
            super.onDetachedFromWindow();
        }
    }

    public /* synthetic */ ve6 q() {
        return this.e;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!(getContext() instanceof AppCompatActivity)) {
                this.c.onDestroy();
            }
            this.b.h();
            setWebChromeClient(null);
            setWebViewClient(null);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onPause();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onResume();
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                this.b.loadUrl(str);
                ye6.c("lt-log", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                if (URLUtil.isNetworkUrl(str)) {
                    this.k = str;
                }
            }
        }
    }
}
