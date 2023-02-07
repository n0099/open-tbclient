package com.baidu.tieba.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.aa6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.core.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.core.webview.flyweight.FlyweightWebView;
import com.baidu.tieba.browser.core.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.hc6;
import com.baidu.tieba.hda;
import com.baidu.tieba.ic6;
import com.baidu.tieba.jc6;
import com.baidu.tieba.l96;
import com.baidu.tieba.la6;
import com.baidu.tieba.lb6;
import com.baidu.tieba.ma6;
import com.baidu.tieba.mb6;
import com.baidu.tieba.na6;
import com.baidu.tieba.nb6;
import com.baidu.tieba.oa6;
import com.baidu.tieba.p15;
import com.baidu.tieba.u96;
import com.baidu.tieba.z96;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebView extends FrameLayout implements aa6, WebViewLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ic6 a;
    public FlyweightWebView b;
    public SimpleWebViewLifeCycle c;
    public final ma6 d;
    public final na6 e;
    public hda<WebView> f;
    public ProgressBar g;
    public final lb6 h;

    public /* synthetic */ aa6 f() {
        return this;
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
        this.a = new ic6();
        this.d = new nb6(new z96() { // from class: com.baidu.tieba.n96
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.z96, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.f() : invokeV.objValue;
            }
        });
        this.e = new mb6(l96.a);
        this.h = new lb6();
        e(context);
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
        this.a = new ic6();
        this.d = new nb6(new z96() { // from class: com.baidu.tieba.n96
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.z96, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.f() : invokeV.objValue;
            }
        });
        this.e = new mb6(l96.a);
        this.h = new lb6();
        e(context);
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
        this.a = new ic6();
        this.d = new nb6(new z96() { // from class: com.baidu.tieba.n96
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.z96, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.f() : invokeV.objValue;
            }
        });
        this.e = new mb6(l96.a);
        this.h = new lb6();
        e(context);
    }

    @Override // com.baidu.tieba.aa6
    public void a(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            ProgressBar progressBar = this.g;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.g);
                } else {
                    jc6.d(progressBar, 0);
                    this.h.b(this.g, i);
                }
            }
            if (i > 50 && webView.getVisibility() != 0) {
                webView.setVisibility(0);
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (this.b == null) {
                this.a.j(System.currentTimeMillis());
                FlyweightWebView e = u96.c().e(getContext(), str);
                this.b = e;
                e.setWebChromeClient(this.d);
                this.b.setWebViewClient(this.e);
                this.b.setPerfData(this.a);
                this.b.setVisibility(8);
                la6.d(this.b);
                addView(this.b, new FrameLayout.LayoutParams(-1, -1));
                ProgressBar progressBar = this.g;
                if (progressBar != null) {
                    progressBar.bringToFront();
                }
                this.a.i(System.currentTimeMillis());
            }
            SimpleWebViewLifeCycle simpleWebViewLifeCycle = this.c;
            if (simpleWebViewLifeCycle != null) {
                simpleWebViewLifeCycle.a(this.b);
            }
            hda<WebView> hdaVar = this.f;
            if (hdaVar != null) {
                hdaVar.call(this.b);
            }
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.a.h(j);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.c = new SimpleWebViewLifeCycle(this.b, hc6.e());
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(this.c);
            }
        }
    }

    public void g(hda<WebView> hdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hdaVar) == null) {
            this.f = hdaVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            b(str);
            if (!this.b.d()) {
                this.b.loadUrl(str);
            }
        }
    }

    public void setOnScrollChangeListener(NestedScrollWebView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.b.setOnScrollChangeListener(aVar);
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, webChromeClient) == null) {
            this.d.b(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, webViewClient) == null) {
            this.e.a(webViewClient);
        }
    }

    public void setWebViewSkinOverly(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.USER_SKIN_OVERLAY)) {
                n();
            } else {
                d();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setBackgroundColor(0);
        }
    }

    public WebView get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public oa6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b.getController();
        }
        return (oa6) invokeV.objValue;
    }

    public ic6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (ic6) invokeV.objValue;
    }

    public Drawable getProgressDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08047a, getContext().getTheme());
        }
        return (Drawable) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p15.d(this).f(R.color.CAM_X0503);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!(getContext() instanceof AppCompatActivity)) {
                this.c.onDestroy();
            }
            this.b.k();
            setWebChromeClient(null);
            setWebViewClient(null);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onPause();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onResume();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            p15.d(this).f(R.color.CAM_X0503);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }
}
