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
import com.baidu.tieba.lf6;
import com.baidu.tieba.me6;
import com.baidu.tieba.nf6;
import com.baidu.tieba.of6;
import com.baidu.tieba.pf6;
import com.baidu.tieba.qf6;
import com.baidu.tieba.rf6;
import com.baidu.tieba.sf6;
import com.baidu.tieba.tf6;
import com.baidu.tieba.ub6;
import com.baidu.tieba.ue6;
import com.baidu.tieba.vb6;
import com.baidu.tieba.vf6;
import com.baidu.tieba.wb6;
import com.baidu.tieba.we6;
import com.baidu.tieba.xe6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebView extends FrameLayout implements wb6, WebViewLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vf6 a;
    public MonitorWebView b;
    public SimpleWebViewLifeCycle c;
    public final pf6 d;
    public ue6 e;
    public final qf6 f;
    public final qf6 g;
    public ProgressBar h;
    public ub6<WebView> i;
    public final me6 j;
    public String k;

    public /* synthetic */ wb6 p() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a extends qf6 {
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

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, renderProcessGoneDetail)) == null) {
                if (Build.VERSION.SDK_INT < 26) {
                    return false;
                }
                if (webView instanceof of6) {
                    ((of6) webView).b();
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
        this.a = new vf6();
        this.d = new tf6(new vb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new sf6(this.f, new vb6() { // from class: com.baidu.tieba.rb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new me6();
        this.k = null;
        n(context);
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.a.p(System.currentTimeMillis());
            WebView b = ((nf6) ServiceManager.getService(nf6.a)).b(context);
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
        this.a = new vf6();
        this.d = new tf6(new vb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new sf6(this.f, new vb6() { // from class: com.baidu.tieba.rb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new me6();
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
        this.a = new vf6();
        this.d = new tf6(new vb6() { // from class: com.baidu.tieba.sb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.p() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new sf6(this.f, new vb6() { // from class: com.baidu.tieba.rb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.q() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new me6();
        this.k = null;
        n(context);
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.a.m(j);
        }
    }

    public void o(ub6<WebView> ub6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ub6Var) == null) {
            this.i = ub6Var;
            if (ub6Var != null) {
                ub6Var.call(this.b);
            }
        }
    }

    public void setOnScrollChangeListener(we6 we6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, we6Var) == null) {
            this.b.setOnScrollChangeListener(we6Var);
        }
    }

    public void setPageLifeCycle(ue6 ue6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ue6Var) == null) {
            this.e = ue6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, webChromeClient) == null) {
            this.d.b(webChromeClient);
        }
    }

    public final void setWebViewClient(qf6 qf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, qf6Var) == null) {
            this.f.a(qf6Var);
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

    @Override // com.baidu.tieba.wb6
    public void b(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            ProgressBar progressBar = this.h;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.j.a(this.h);
                } else {
                    lf6.e(progressBar, 0);
                    this.j.b(this.h, i);
                }
            }
            if (i >= 80) {
                lf6.e(webView, 0);
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

    public rf6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getController();
        }
        return (rf6) invokeV.objValue;
    }

    public vf6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (vf6) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.c();
            super.onDetachedFromWindow();
        }
    }

    public /* synthetic */ ue6 q() {
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
                xe6.c("lt-log", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                if (URLUtil.isNetworkUrl(str)) {
                    this.k = str;
                }
            }
        }
    }
}
