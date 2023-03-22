package com.baidu.tieba.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.ae6;
import com.baidu.tieba.be6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.ce6;
import com.baidu.tieba.de6;
import com.baidu.tieba.ed6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.fe6;
import com.baidu.tieba.ge6;
import com.baidu.tieba.he6;
import com.baidu.tieba.je6;
import com.baidu.tieba.md6;
import com.baidu.tieba.oa6;
import com.baidu.tieba.od6;
import com.baidu.tieba.pa6;
import com.baidu.tieba.pd6;
import com.baidu.tieba.qa6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebView extends FrameLayout implements qa6, WebViewLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final je6 a;
    public MonitorWebView b;
    public SimpleWebViewLifeCycle c;
    public final de6 d;
    public md6 e;
    public final ee6 f;
    public final ee6 g;
    public ProgressBar h;
    public oa6<WebView> i;
    public final ed6 j;
    public String k;

    public /* synthetic */ qa6 l() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a extends ee6 {
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

        @Override // com.baidu.tieba.ee6, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, renderProcessGoneDetail)) == null) {
                if (Build.VERSION.SDK_INT < 26) {
                    return false;
                }
                if (webView instanceof ce6) {
                    ((ce6) webView).b();
                }
                if (this.b.b != null && webView == this.b.b) {
                    this.b.b.b();
                    this.b.b.destroy();
                    this.b.b = null;
                    TbWebView tbWebView = this.b;
                    tbWebView.j(tbWebView.getContext());
                    TbWebView tbWebView2 = this.b;
                    tbWebView2.k(tbWebView2.i);
                    TbWebView tbWebView3 = this.b;
                    tbWebView3.n(tbWebView3.k);
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
        this.a = new je6();
        this.d = new he6(new pa6() { // from class: com.baidu.tieba.ma6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.l() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new ge6(this.f, new pa6() { // from class: com.baidu.tieba.la6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.m() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ed6();
        this.k = null;
        j(context);
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.a.p(System.currentTimeMillis());
            WebView b = ((be6) ServiceManager.getService(be6.a)).b(context);
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
                simpleWebViewLifeCycle.a(this.b);
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
        this.a = new je6();
        this.d = new he6(new pa6() { // from class: com.baidu.tieba.ma6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.l() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new ge6(this.f, new pa6() { // from class: com.baidu.tieba.la6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.m() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ed6();
        this.k = null;
        j(context);
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
        this.a = new je6();
        this.d = new he6(new pa6() { // from class: com.baidu.tieba.ma6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.l() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new a(this);
        this.g = new ge6(this.f, new pa6() { // from class: com.baidu.tieba.la6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.pa6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.m() : invokeV.objValue;
            }
        });
        this.i = null;
        this.j = new ed6();
        this.k = null;
        j(context);
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.a.m(j);
        }
    }

    public void k(oa6<WebView> oa6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oa6Var) == null) {
            this.i = oa6Var;
            if (oa6Var != null) {
                oa6Var.call(this.b);
            }
        }
    }

    public void setOnScrollChangeListener(od6 od6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, od6Var) == null) {
            this.b.setOnScrollChangeListener(od6Var);
        }
    }

    public void setPageLifeCycle(md6 md6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, md6Var) == null) {
            this.e = md6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webChromeClient) == null) {
            this.d.b(webChromeClient);
        }
    }

    public final void setWebViewClient(ee6 ee6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ee6Var) == null) {
            this.f.a(ee6Var);
        }
    }

    public final void u(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048594, this, i, drawable) == null) && this.h == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.h = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.h, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.qa6
    public void a(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            ProgressBar progressBar = this.h;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.j.a(this.h);
                } else {
                    ae6.e(progressBar, 0);
                    this.j.b(this.h, i);
                }
            }
            if (i >= 80) {
                ae6.e(webView, 0);
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

    public fe6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getController();
        }
        return (fe6) invokeV.objValue;
    }

    public je6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (je6) invokeV.objValue;
    }

    public /* synthetic */ md6 m() {
        return this.e;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onPause();
        }
    }

    public void onDestroy() {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j.c();
            super.onDetachedFromWindow();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onResume();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                this.k = str;
                this.b.loadUrl(str);
                pd6.c("lt-log", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        }
    }
}
