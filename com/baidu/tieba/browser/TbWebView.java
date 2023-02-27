package com.baidu.tieba.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.core.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.core.webview.flyweight.FlyweightWebView;
import com.baidu.tieba.browser.core.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.cc6;
import com.baidu.tieba.dc6;
import com.baidu.tieba.ec6;
import com.baidu.tieba.fc6;
import com.baidu.tieba.gna;
import com.baidu.tieba.je6;
import com.baidu.tieba.lb6;
import com.baidu.tieba.qb6;
import com.baidu.tieba.rb6;
import com.baidu.tieba.re6;
import com.baidu.tieba.sd6;
import com.baidu.tieba.se6;
import com.baidu.tieba.td6;
import com.baidu.tieba.ud6;
import com.baidu.tieba.ve6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbWebView extends FrameLayout implements rb6, WebViewLifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final se6 a;
    public FlyweightWebView b;
    public SimpleWebViewLifeCycle c;
    public final dc6 d;
    public je6 e;
    public final ec6 f;
    public ProgressBar g;
    public final sd6 h;

    public /* synthetic */ rb6 g() {
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
        this.a = new se6();
        this.d = new ud6(new qb6() { // from class: com.baidu.tieba.eb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.g() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new td6(new qb6() { // from class: com.baidu.tieba.db6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.i() : invokeV.objValue;
            }
        });
        this.h = new sd6();
        d(context);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                if (this.g == null) {
                    ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
                    this.g = progressBar;
                    progressBar.setProgressDrawable(getProgressDrawable());
                    addView(this.g, new ViewGroup.LayoutParams(-1, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702d2)));
                    return;
                }
                return;
            }
            ProgressBar progressBar2 = this.g;
            if (progressBar2 != null) {
                removeView(progressBar2);
                this.g = null;
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
        this.a = new se6();
        this.d = new ud6(new qb6() { // from class: com.baidu.tieba.eb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.g() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new td6(new qb6() { // from class: com.baidu.tieba.db6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.i() : invokeV.objValue;
            }
        });
        this.h = new sd6();
        d(context);
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
        this.a = new se6();
        this.d = new ud6(new qb6() { // from class: com.baidu.tieba.eb6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.g() : invokeV.objValue;
            }
        });
        this.e = null;
        this.f = new td6(new qb6() { // from class: com.baidu.tieba.db6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.qb6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.i() : invokeV.objValue;
            }
        });
        this.h = new sd6();
        d(context);
    }

    @Override // com.baidu.tieba.rb6
    public void a(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            ProgressBar progressBar = this.g;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.g);
                } else {
                    ve6.d(progressBar, 0);
                    this.h.b(this.g, i);
                }
            }
            if (i >= 80) {
                ve6.d(webView, 0);
            }
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.a.h(j);
        }
    }

    public void e(gna<WebView> gnaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gnaVar) == null) && gnaVar != null) {
            gnaVar.call(this.b);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.b.setFirstUrl();
            if (!this.b.h()) {
                this.b.loadUrl(str);
            }
        }
    }

    public void setOnScrollChangeListener(NestedScrollWebView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.b.setOnScrollChangeListener(aVar);
        }
    }

    public void setPageLifeCycle(je6 je6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, je6Var) == null) {
            this.e = je6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, webChromeClient) == null) {
            this.d.b(webChromeClient);
        }
    }

    public final void setWebViewClient(ec6 ec6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ec6Var) == null) {
            this.f.a(ec6Var);
        }
    }

    public void setWebViewSkinOverly(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.USER_SKIN_OVERLAY)) {
                p();
            } else {
                c();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setBackgroundColor(0);
        }
    }

    public WebView get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public fc6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.getController();
        }
        return (fc6) invokeV.objValue;
    }

    public se6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (se6) invokeV.objValue;
    }

    public Drawable getProgressDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080481, getContext().getTheme());
        }
        return (Drawable) invokeV.objValue;
    }

    public /* synthetic */ je6 i() {
        return this.e;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b35.d(this).f(R.color.CAM_X0503);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onPause();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !(getContext() instanceof AppCompatActivity)) {
            this.c.onResume();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (!(getContext() instanceof AppCompatActivity)) {
                this.c.onDestroy();
            }
            this.b.m();
            setWebChromeClient(null);
            setWebViewClient(null);
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

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b35.d(this).f(R.color.CAM_X0503);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a.j(System.currentTimeMillis());
            FlyweightWebView e = lb6.c().e(context);
            this.b = e;
            this.c = new SimpleWebViewLifeCycle(e, re6.f());
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(this.c);
            }
            this.b.setWebChromeClient(this.d);
            this.b.setWebViewClient(this.f);
            this.b.setPerfData(this.a);
            this.b.setVisibility(4);
            cc6.d(this.b);
            addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = this.g;
            if (progressBar != null) {
                progressBar.bringToFront();
            }
            this.a.i(System.currentTimeMillis());
            SimpleWebViewLifeCycle simpleWebViewLifeCycle = this.c;
            if (simpleWebViewLifeCycle != null) {
                simpleWebViewLifeCycle.a(this.b);
            }
        }
    }
}
