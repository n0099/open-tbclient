package com.baidu.tieba.browser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.an6;
import com.baidu.tieba.ao6;
import com.baidu.tieba.bn6;
import com.baidu.tieba.bo6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.cn6;
import com.baidu.tieba.co6;
import com.baidu.tieba.dn6;
import com.baidu.tieba.do6;
import com.baidu.tieba.fn6;
import com.baidu.tieba.fo6;
import com.baidu.tieba.gbc;
import com.baidu.tieba.gn6;
import com.baidu.tieba.go6;
import com.baidu.tieba.io6;
import com.baidu.tieba.jm6;
import com.baidu.tieba.ko6;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.ofc;
import com.baidu.tieba.om6;
import com.baidu.tieba.pj6;
import com.baidu.tieba.qj6;
import com.baidu.tieba.rj6;
import com.baidu.tieba.sj6;
import com.baidu.tieba.un6;
import com.baidu.tieba.vn6;
import com.baidu.tieba.ym6;
import com.baidu.tieba.yn6;
import com.baidu.tieba.zac;
import com.baidu.tieba.zm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes5.dex */
public class TbWebView extends FrameLayout implements sj6, WebViewLifeCycle, fn6, ym6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public io6 A;
    public zac B;
    public rj6<Object> C;
    public final do6 D;
    public final ko6 a;
    @Nullable
    public MonitorWebView b;
    public final bo6 c;
    public final co6 d;
    public ProgressBar e;
    public pj6<WebView> f;
    public pj6<WebView> g;
    public final om6 h;
    public String i;
    public qj6<Integer, Double> j;
    public boolean k;
    public boolean l;
    public ym6 m;
    public final Map<String, String> n;
    public final Map<String, rj6<Object>> o;
    public final ofc<Lifecycle.Event> p;
    public View q;
    public fn6 r;
    public sj6 s;
    public zm6 t;
    public bn6 u;
    public an6 v;
    public cn6 w;
    public dn6 x;
    public DownloadListener y;
    @Nullable
    public yn6 z;

    public /* synthetic */ sj6 U() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements rj6<WebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebView a;

        public a(TbWebView tbWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
        public WebView call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (WebView) invokeV.objValue;
            }
            return this.a.b;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pj6<WebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ TbWebView c;

        public b(TbWebView tbWebView, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebView, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebView;
            this.a = i;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj6
        public void call(WebView webView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, webView) == null) && webView != null) {
                int i = this.a;
                if (i == 0) {
                    webView.setHorizontalScrollBarEnabled(this.b);
                    webView.setHorizontalScrollbarOverlay(this.b);
                } else if (i == 1) {
                    webView.setVerticalScrollBarEnabled(this.b);
                    webView.setVerticalScrollbarOverlay(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rj6<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;
        public final /* synthetic */ TbWebView b;

        public c(TbWebView tbWebView, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebView, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbWebView;
            this.a = obj;
        }

        @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.objValue;
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
        this.a = new ko6();
        this.c = new fo6(new rj6() { // from class: com.baidu.tieba.cj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.U() : invokeV.objValue;
            }
        });
        this.d = new go6(this);
        this.f = null;
        this.g = null;
        this.h = new om6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = ofc.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = new do6(new a(this));
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    A(getContext(), str);
                }
                if (this.b.getPreRenderMode() == PreRenderMode.NONE) {
                    if (this.b.p(str)) {
                        this.i = str;
                    }
                    this.b.loadUrl(str);
                } else {
                    this.i = str;
                    this.b.setVisibility(0);
                    this.b.r();
                }
                gn6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
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
        this.a = new ko6();
        this.c = new fo6(new rj6() { // from class: com.baidu.tieba.cj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.U() : invokeV.objValue;
            }
        });
        this.d = new go6(this);
        this.f = null;
        this.g = null;
        this.h = new om6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = ofc.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = new do6(new a(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, i);
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
        this.a = new ko6();
        this.c = new fo6(new rj6() { // from class: com.baidu.tieba.cj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.U() : invokeV.objValue;
            }
        });
        this.d = new go6(this);
        this.f = null;
        this.g = null;
        this.h = new om6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = ofc.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = new do6(new a(this));
    }

    public void H(String str, rj6<Object> rj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, rj6Var) == null) {
            this.o.put(str, rj6Var);
        }
    }

    public void I(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, obj) == null) {
            this.o.put(str, new c(this, obj));
        }
    }

    public /* synthetic */ boolean P(WebView webView, String str) {
        zm6 zm6Var = this.t;
        if (zm6Var != null) {
            return zm6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void Q(WebView webView, String str) {
        bn6 bn6Var = this.u;
        if (bn6Var != null) {
            bn6Var.c(webView, str);
        }
    }

    public /* synthetic */ void R(WebView webView, String str) {
        an6 an6Var = this.v;
        if (an6Var != null) {
            an6Var.onPageFinished(webView, str);
        }
    }

    public final void X(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048596, this, i, drawable) == null) && this.e == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.e = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.e, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.ym6
    public void j(View view2, MotionEvent motionEvent) {
        ym6 ym6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, view2, motionEvent) == null) && (ym6Var = this.m) != null) {
            ym6Var.j(view2, motionEvent);
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            this.n.put(str, str2);
        }
    }

    public void setScrollBarEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = new b(this, i, z);
            this.g = bVar;
            bVar.call((b) this.b);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048641, this, str, i) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                D();
            } else {
                Y(i);
            }
        }
    }

    public void w(String str, ValueCallback<String> valueCallback) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048643, this, str, valueCallback) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && this.q == null) {
            View view2 = new View(context);
            this.q = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.q);
            this.q.setVisibility(8);
        }
    }

    public void F(pj6<WebView> pj6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pj6Var) == null) {
            this.f = pj6Var;
            if (pj6Var != null && (monitorWebView = this.b) != null) {
                pj6Var.call(monitorWebView);
            }
        }
    }

    public /* synthetic */ Boolean L(Pair pair) {
        boolean z;
        if (pair != null && this.j != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public /* synthetic */ void N(Pair pair) {
        gn6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.j.call((Integer) pair.first, (Double) pair.second);
    }

    public final void Y(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (view2 = this.q) != null) {
            view2.setVisibility(0);
            vn6 vn6Var = (vn6) ServiceManager.getService(vn6.a);
            if (vn6Var != null) {
                vn6Var.a(this.q, i);
            }
        }
    }

    public void n(io6 io6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, io6Var) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                io6Var.a(monitorWebView);
            }
            this.A = io6Var;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.a.n(j);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, downloadListener) == null) {
            this.y = downloadListener;
        }
    }

    public void setInvalidPageCallback(rj6<Object> rj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, rj6Var) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setInvalidPageCallback(rj6Var);
            }
            this.C = rj6Var;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.l = z;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setNeedDisAllowParentInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.k = z;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setNestedScrollingEnabled(z);
            }
        }
    }

    public void setOnDoubleClickListener(ym6 ym6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, ym6Var) == null) {
            this.m = ym6Var;
        }
    }

    public void setOnLoadUrlListener(zm6 zm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, zm6Var) == null) {
            this.t = zm6Var;
        }
    }

    public void setOnPageFinishedListener(an6 an6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, an6Var) == null) {
            this.v = an6Var;
        }
    }

    public void setOnPageStartedListener(bn6 bn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bn6Var) == null) {
            this.u = bn6Var;
        }
    }

    public void setOnProgressChangedListener(sj6 sj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, sj6Var) == null) {
            this.s = sj6Var;
        }
    }

    public void setOnReceivedErrorListener(cn6 cn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, cn6Var) == null) {
            this.w = cn6Var;
        }
    }

    public void setOnReceivedSslErrorListener(dn6 dn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, dn6Var) == null) {
            this.x = dn6Var;
        }
    }

    public void setOnScrollChangeListener(fn6 fn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, fn6Var) == null) {
            this.r = fn6Var;
        }
    }

    public void setOnSizeChangedListener(qj6<Integer, Double> qj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, qj6Var) == null) {
            this.j = qj6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, preRenderMode) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.setPreRenderMode(preRenderMode);
        }
    }

    public final void setTargetInterceptor(yn6 yn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, yn6Var) == null) {
            this.z = yn6Var;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setTargetInterceptor(yn6Var);
            }
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, webChromeClient) == null) {
            this.c.c(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, webViewClient) == null) {
            this.d.b(webViewClient);
        }
    }

    public boolean v(@Nullable WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, webView)) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null && monitorWebView == webView) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void A(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            this.a.r(System.currentTimeMillis());
            MonitorWebView monitorWebView = (MonitorWebView) ((ao6) ServiceManager.getService(ao6.a)).b(context, str);
            this.b = monitorWebView;
            monitorWebView.setTargetInterceptor(this.z);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new rj6() { // from class: com.baidu.tieba.hj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.K() : invokeV.objValue;
                }
            }, new rj6() { // from class: com.baidu.tieba.oj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                this.p.H(new gbc() { // from class: com.baidu.tieba.nj6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.gbc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            SimpleWebViewLifeCycle.this.b((Lifecycle.Event) obj);
                        }
                    }
                });
            }
            this.b.setNestedScrollingEnabled(this.k);
            this.b.setNeedDisAllowParentInterceptTouchEvent(this.l);
            this.b.setWebChromeClient(this.c);
            this.b.setWebViewClient(this.d);
            this.b.setPerfData(this.a);
            addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                progressBar.bringToFront();
            }
            pj6<WebView> pj6Var = this.f;
            if (pj6Var != null) {
                F(pj6Var);
            }
            pj6<WebView> pj6Var2 = this.g;
            if (pj6Var2 != null) {
                pj6Var2.call(this.b);
            }
            a0();
            this.B = this.b.getViewHeightBs().k(new lbc() { // from class: com.baidu.tieba.kj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lbc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.L((Pair) obj) : invokeL.objValue;
                }
            }).h(new mbc() { // from class: com.baidu.tieba.jj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mbc
                public final Object call(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Boolean valueOf;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                        valueOf = Boolean.valueOf(Objects.equals(((Pair) obj).second, ((Pair) obj2).second));
                        return valueOf;
                    }
                    return invokeLL.objValue;
                }
            }).H(new gbc() { // from class: com.baidu.tieba.fj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gbc
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.N((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            E(context);
            G(this.b);
            io6 io6Var = this.A;
            if (io6Var != null) {
                io6Var.a(this.b);
            }
            rj6<Object> rj6Var = this.C;
            if (rj6Var != null) {
                this.b.setInvalidPageCallback(rj6Var);
            }
            if (jm6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                un6.a(view2);
            }
        }
    }

    public void B() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.goBack();
        }
    }

    public final void D() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (view2 = this.q) != null) {
            view2.setVisibility(8);
        }
    }

    public /* synthetic */ WebView K() {
        return this.b;
    }

    public void V() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.r();
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.b();
                this.b.destroy();
                this.b = null;
            }
            if (!TextUtils.isEmpty(getUrl())) {
                loadUrl(getUrl());
            }
        }
    }

    public void Z() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.stopLoading();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            zac zacVar = this.B;
            if (zacVar != null && zacVar.isUnsubscribed()) {
                this.B.unsubscribe();
            }
            this.B = null;
        }
    }

    public Map<String, String> getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.n;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, rj6<Object>> getBizData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.o;
        }
        return (Map) invokeV.objValue;
    }

    public WebChromeClient getChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.c.b();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    @NonNull
    public do6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.D;
        }
        return (do6) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public WebView getInnerWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public ko6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a;
        }
        return (ko6) invokeV.objValue;
    }

    @Nullable
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!TextUtils.isEmpty(this.i)) {
                return this.i;
            }
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                return monitorWebView.getUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public WebViewClient getWebViewClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.d.a();
        }
        return (WebViewClient) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                return monitorWebView.canGoBack();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.b();
        }
    }

    public final void G(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new zm6() { // from class: com.baidu.tieba.ij6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zm6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.P(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new bn6() { // from class: com.baidu.tieba.dj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.bn6
                public final void c(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.Q(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new an6() { // from class: com.baidu.tieba.gj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.an6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.R(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new cn6() { // from class: com.baidu.tieba.ej6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.cn6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.S(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new dn6() { // from class: com.baidu.tieba.lj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.dn6
                public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.T(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.mj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        TbWebView.this.O(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    public /* synthetic */ void O(String str, String str2, String str3, String str4, long j) {
        DownloadListener downloadListener = this.y;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public /* synthetic */ void S(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        cn6 cn6Var = this.w;
        if (cn6Var != null) {
            cn6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.fn6
    public void b(int i, int i2, int i3, int i4) {
        fn6 fn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) && (fn6Var = this.r) != null) {
            fn6Var.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.fn6
    public void c(int i, int i2, int i3, int i4) {
        fn6 fn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048601, this, i, i2, i3, i4) == null) && (fn6Var = this.r) != null) {
            fn6Var.c(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void T(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        dn6 dn6Var = this.x;
        if (dn6Var != null) {
            dn6Var.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.tieba.sj6
    public void g(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, webView, i) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.e);
                } else {
                    un6.f(progressBar, 0);
                    this.h.b(this.e, i);
                }
            }
            if (i >= 100) {
                un6.f(webView, 0);
            }
            sj6 sj6Var = this.s;
            if (sj6Var != null) {
                sj6Var.g(webView, i);
            }
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            a0();
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null && monitorWebView.getPreRenderMode() == PreRenderMode.NONE) {
                this.b.loadUrl("about:blank");
            }
            this.f = null;
            this.p.onNext(Lifecycle.Event.ON_DESTROY);
            this.p.onCompleted();
            setWebChromeClient(null);
            setWebViewClient(null);
        }
    }

    @Override // android.view.View, com.baidu.tieba.fn6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048619, this, i, i2, i3, i4) == null) {
            fn6 fn6Var = this.r;
            if (fn6Var != null) {
                fn6Var.onScrollChanged(i, i2, i3, i4);
            }
            View view2 = this.q;
            if (view2 != null && view2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
                layoutParams.height = getHeight() + i2;
                this.q.setLayoutParams(layoutParams);
            }
        }
    }
}
