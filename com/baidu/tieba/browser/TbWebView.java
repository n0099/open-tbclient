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
import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.bh6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.ce6;
import com.baidu.tieba.de6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.fbc;
import com.baidu.tieba.fe6;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ii6;
import com.baidu.tieba.lh6;
import com.baidu.tieba.li6;
import com.baidu.tieba.mh6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.o6c;
import com.baidu.tieba.oh6;
import com.baidu.tieba.oi6;
import com.baidu.tieba.ph6;
import com.baidu.tieba.pi6;
import com.baidu.tieba.qh6;
import com.baidu.tieba.qi6;
import com.baidu.tieba.sh6;
import com.baidu.tieba.si6;
import com.baidu.tieba.th6;
import com.baidu.tieba.ti6;
import com.baidu.tieba.v6c;
import com.baidu.tieba.vi6;
import com.baidu.tieba.wg6;
import com.baidu.tieba.zi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes5.dex */
public class TbWebView extends FrameLayout implements fe6, WebViewLifeCycle, sh6, lh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public vi6 A;
    public o6c B;
    public ee6<Object> C;
    public final qi6 D;
    public final zi6 a;
    @Nullable
    public MonitorWebView b;
    public final oi6 c;
    public final pi6 d;
    public ProgressBar e;
    public ce6<WebView> f;
    public ce6<WebView> g;
    public final bh6 h;
    public String i;
    public de6<Integer, Double> j;
    public boolean k;
    public boolean l;
    public lh6 m;
    public final Map<String, String> n;
    public final Map<String, ee6<Object>> o;
    public final fbc<Lifecycle.Event> p;
    public View q;
    public sh6 r;
    public fe6 s;
    public mh6 t;
    public oh6 u;
    public nh6 v;
    public ph6 w;
    public qh6 x;
    public DownloadListener y;
    @Nullable
    public li6 z;

    public /* synthetic */ fe6 V() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements ee6<WebView> {
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
        @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
        /* renamed from: a */
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
    public class b implements ce6<WebView> {
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
        @Override // com.baidu.tieba.ce6
        /* renamed from: a */
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
    public class c implements ee6<Object> {
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

        @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
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
        this.a = new zi6();
        this.c = new si6(new ee6() { // from class: com.baidu.tieba.pd6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new ti6(this);
        this.f = null;
        this.g = null;
        this.h = new bh6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = fbc.R(Lifecycle.Event.ON_RESUME);
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
        this.D = new qi6(new a(this));
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    B(getContext(), str);
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
                th6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
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
        this.a = new zi6();
        this.c = new si6(new ee6() { // from class: com.baidu.tieba.pd6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new ti6(this);
        this.f = null;
        this.g = null;
        this.h = new bh6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = fbc.R(Lifecycle.Event.ON_RESUME);
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
        this.D = new qi6(new a(this));
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
        this.a = new zi6();
        this.c = new si6(new ee6() { // from class: com.baidu.tieba.pd6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new ti6(this);
        this.f = null;
        this.g = null;
        this.h = new bh6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = fbc.R(Lifecycle.Event.ON_RESUME);
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
        this.D = new qi6(new a(this));
    }

    public void I(String str, ee6<Object> ee6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, ee6Var) == null) {
            this.o.put(str, ee6Var);
        }
    }

    public void J(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, obj) == null) {
            this.o.put(str, new c(this, obj));
        }
    }

    public /* synthetic */ boolean Q(WebView webView, String str) {
        mh6 mh6Var = this.t;
        if (mh6Var != null) {
            return mh6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void R(WebView webView, String str) {
        oh6 oh6Var = this.u;
        if (oh6Var != null) {
            oh6Var.a(webView, str);
        }
    }

    public /* synthetic */ void S(WebView webView, String str) {
        nh6 nh6Var = this.v;
        if (nh6Var != null) {
            nh6Var.onPageFinished(webView, str);
        }
    }

    public final void Y(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048596, this, i, drawable) == null) && this.e == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.e = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.e, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.lh6
    public void j(View view2, MotionEvent motionEvent) {
        lh6 lh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, view2, motionEvent) == null) && (lh6Var = this.m) != null) {
            lh6Var.j(view2, motionEvent);
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
            bVar.call(this.b);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048641, this, str, i) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                D();
            } else {
                Z(i);
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

    public void F(ce6<WebView> ce6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ce6Var) == null) {
            this.f = ce6Var;
            if (ce6Var != null && (monitorWebView = this.b) != null) {
                ce6Var.call(monitorWebView);
            }
        }
    }

    public /* synthetic */ Boolean M(Pair pair) {
        boolean z;
        if (pair != null && this.j != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public /* synthetic */ void O(Pair pair) {
        th6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.j.a((Integer) pair.first, (Double) pair.second);
    }

    public final void Z(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (view2 = this.q) != null) {
            view2.setVisibility(0);
            ii6 ii6Var = (ii6) ServiceManager.getService(ii6.a);
            if (ii6Var != null) {
                ii6Var.a(this.q, i);
            }
        }
    }

    public void n(vi6 vi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, vi6Var) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                vi6Var.a(monitorWebView);
            }
            this.A = vi6Var;
        }
    }

    public void s(long j) {
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

    public void setInvalidPageCallback(ee6<Object> ee6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, ee6Var) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setInvalidPageCallback(ee6Var);
            }
            this.C = ee6Var;
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

    public void setOnDoubleClickListener(lh6 lh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, lh6Var) == null) {
            this.m = lh6Var;
        }
    }

    public void setOnLoadUrlListener(mh6 mh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, mh6Var) == null) {
            this.t = mh6Var;
        }
    }

    public void setOnPageFinishedListener(nh6 nh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, nh6Var) == null) {
            this.v = nh6Var;
        }
    }

    public void setOnPageStartedListener(oh6 oh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, oh6Var) == null) {
            this.u = oh6Var;
        }
    }

    public void setOnProgressChangedListener(fe6 fe6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fe6Var) == null) {
            this.s = fe6Var;
        }
    }

    public void setOnReceivedErrorListener(ph6 ph6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, ph6Var) == null) {
            this.w = ph6Var;
        }
    }

    public void setOnReceivedSslErrorListener(qh6 qh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, qh6Var) == null) {
            this.x = qh6Var;
        }
    }

    public void setOnScrollChangeListener(sh6 sh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, sh6Var) == null) {
            this.r = sh6Var;
        }
    }

    public void setOnSizeChangedListener(de6<Integer, Double> de6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, de6Var) == null) {
            this.j = de6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, preRenderMode) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.setPreRenderMode(preRenderMode);
        }
    }

    public final void setTargetInterceptor(li6 li6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, li6Var) == null) {
            this.z = li6Var;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setTargetInterceptor(li6Var);
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

    public final void B(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            this.a.r(System.currentTimeMillis());
            MonitorWebView monitorWebView = (MonitorWebView) ((ni6) ServiceManager.getService(ni6.a)).b(context, str);
            this.b = monitorWebView;
            monitorWebView.setTargetInterceptor(this.z);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new ee6() { // from class: com.baidu.tieba.ud6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.L() : invokeV.objValue;
                }
            }, new ee6() { // from class: com.baidu.tieba.be6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ee6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                this.p.H(new v6c() { // from class: com.baidu.tieba.ae6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.v6c
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
            ce6<WebView> ce6Var = this.f;
            if (ce6Var != null) {
                F(ce6Var);
            }
            ce6<WebView> ce6Var2 = this.g;
            if (ce6Var2 != null) {
                ce6Var2.call(this.b);
            }
            b0();
            this.B = this.b.getViewHeightBs().k(new a7c() { // from class: com.baidu.tieba.xd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.a7c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.M((Pair) obj) : invokeL.objValue;
                }
            }).h(new b7c() { // from class: com.baidu.tieba.wd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.b7c
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Boolean valueOf;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                        valueOf = Boolean.valueOf(Objects.equals(((Pair) obj).second, ((Pair) obj2).second));
                        return valueOf;
                    }
                    return invokeLL.objValue;
                }
            }).H(new v6c() { // from class: com.baidu.tieba.sd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.v6c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.O((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            E(context);
            H(this.b);
            vi6 vi6Var = this.A;
            if (vi6Var != null) {
                vi6Var.a(this.b);
            }
            ee6<Object> ee6Var = this.C;
            if (ee6Var != null) {
                this.b.setInvalidPageCallback(ee6Var);
            }
            if (wg6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                hi6.a(view2);
            }
        }
    }

    public void C() {
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

    public /* synthetic */ WebView L() {
        return this.b;
    }

    public void W() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.r();
        }
    }

    public void X() {
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

    public void a0() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.stopLoading();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            o6c o6cVar = this.B;
            if (o6cVar != null && o6cVar.isUnsubscribed()) {
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

    public Map<String, ee6<Object>> getBizData() {
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
    public qi6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.D;
        }
        return (qi6) invokeV.objValue;
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

    public zi6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a;
        }
        return (zi6) invokeV.objValue;
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

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                return monitorWebView.canGoBack();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public void q() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.b();
        }
    }

    public final void H(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new mh6() { // from class: com.baidu.tieba.vd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mh6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.Q(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new oh6() { // from class: com.baidu.tieba.qd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.oh6
                public final void a(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.R(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new nh6() { // from class: com.baidu.tieba.td6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.nh6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.S(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new ph6() { // from class: com.baidu.tieba.rd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ph6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.T(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new qh6() { // from class: com.baidu.tieba.yd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.qh6
                public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.U(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.zd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        TbWebView.this.P(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    public /* synthetic */ void P(String str, String str2, String str3, String str4, long j) {
        DownloadListener downloadListener = this.y;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public /* synthetic */ void T(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        ph6 ph6Var = this.w;
        if (ph6Var != null) {
            ph6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.sh6
    public void b(int i, int i2, int i3, int i4) {
        sh6 sh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) && (sh6Var = this.r) != null) {
            sh6Var.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.sh6
    public void c(int i, int i2, int i3, int i4) {
        sh6 sh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048601, this, i, i2, i3, i4) == null) && (sh6Var = this.r) != null) {
            sh6Var.c(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void U(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        qh6 qh6Var = this.x;
        if (qh6Var != null) {
            qh6Var.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.tieba.fe6
    public void g(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, webView, i) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.e);
                } else {
                    hi6.f(progressBar, 0);
                    this.h.b(this.e, i);
                }
            }
            if (i >= 100) {
                hi6.f(webView, 0);
            }
            fe6 fe6Var = this.s;
            if (fe6Var != null) {
                fe6Var.g(webView, i);
            }
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            b0();
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

    @Override // android.view.View, com.baidu.tieba.sh6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i, i2, i3, i4) == null) {
            sh6 sh6Var = this.r;
            if (sh6Var != null) {
                sh6Var.onScrollChanged(i, i2, i3, i4);
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
