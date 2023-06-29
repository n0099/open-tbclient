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
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.bn6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.cn6;
import com.baidu.tieba.ej6;
import com.baidu.tieba.fj6;
import com.baidu.tieba.gj6;
import com.baidu.tieba.gn6;
import com.baidu.tieba.hj6;
import com.baidu.tieba.hn6;
import com.baidu.tieba.in6;
import com.baidu.tieba.jm6;
import com.baidu.tieba.jn6;
import com.baidu.tieba.km6;
import com.baidu.tieba.lm6;
import com.baidu.tieba.ln6;
import com.baidu.tieba.ltb;
import com.baidu.tieba.mm6;
import com.baidu.tieba.mn6;
import com.baidu.tieba.nm6;
import com.baidu.tieba.om6;
import com.baidu.tieba.pn6;
import com.baidu.tieba.ptb;
import com.baidu.tieba.qm6;
import com.baidu.tieba.qtb;
import com.baidu.tieba.rm6;
import com.baidu.tieba.sxb;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes5.dex */
public class TbWebView extends FrameLayout implements hj6, WebViewLifeCycle, qm6, jm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pn6 a;
    @Nullable
    public MonitorWebView b;
    public final hn6 c;
    public final in6 d;
    public ProgressBar e;
    public ej6<WebView> f;
    public ej6<WebView> g;
    public final zl6 h;
    public String i;
    public fj6<Integer, Double> j;
    public boolean k;
    public boolean l;
    public jm6 m;
    public final Map<String, String> n;
    public final Map<String, gj6<Object>> o;
    public final sxb<Lifecycle.Event> p;
    public View q;
    public qm6 r;
    public hj6 s;
    public km6 t;
    public mm6 u;
    public lm6 v;
    public nm6 w;
    public om6 x;
    public DownloadListener y;
    public final jn6 z;

    public /* synthetic */ hj6 O() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements gj6<WebView> {
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
        @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
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
    public class b implements ej6<WebView> {
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
        @Override // com.baidu.tieba.ej6
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
    public class c implements gj6<Object> {
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

        @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
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
        this.a = new pn6();
        this.c = new ln6(new gj6() { // from class: com.baidu.tieba.ui6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.O() : invokeV.objValue;
            }
        });
        this.d = new mn6(this);
        this.f = null;
        this.g = null;
        this.h = new zl6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = sxb.P(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new jn6(new a(this));
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    q(getContext(), str);
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
                rm6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
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
        this.a = new pn6();
        this.c = new ln6(new gj6() { // from class: com.baidu.tieba.ui6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.O() : invokeV.objValue;
            }
        });
        this.d = new mn6(this);
        this.f = null;
        this.g = null;
        this.h = new zl6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = sxb.P(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new jn6(new a(this));
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
        this.a = new pn6();
        this.c = new ln6(new gj6() { // from class: com.baidu.tieba.ui6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.O() : invokeV.objValue;
            }
        });
        this.d = new mn6(this);
        this.f = null;
        this.g = null;
        this.h = new zl6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = sxb.P(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new jn6(new a(this));
    }

    public /* synthetic */ boolean L(WebView webView, String str) {
        km6 km6Var = this.t;
        if (km6Var != null) {
            return km6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void M(WebView webView, String str) {
        mm6 mm6Var = this.u;
        if (mm6Var != null) {
            mm6Var.d(webView, str);
        }
    }

    public /* synthetic */ void N(WebView webView, String str) {
        lm6 lm6Var = this.v;
        if (lm6Var != null) {
            lm6Var.onPageFinished(webView, str);
        }
    }

    public final void S(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048588, this, i, drawable) == null) && this.e == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.e = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.e, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.jm6
    public void g(View view2, MotionEvent motionEvent) {
        jm6 jm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, view2, motionEvent) == null) && (jm6Var = this.m) != null) {
            jm6Var.g(view2, motionEvent);
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            this.n.put(str, str2);
        }
    }

    public void p(String str, ValueCallback<String> valueCallback) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, str, valueCallback) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public void setScrollBarEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = new b(this, i, z);
            this.g = bVar;
            bVar.call((b) this.b);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048629, this, str, i) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                r();
            } else {
                T(i);
            }
        }
    }

    public void v(String str, gj6<Object> gj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, gj6Var) == null) {
            this.o.put(str, gj6Var);
        }
    }

    public void w(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, obj) == null) {
            this.o.put(str, new c(this, obj));
        }
    }

    public /* synthetic */ Boolean D(Pair pair) {
        boolean z;
        if (pair != null && this.j != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: F */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: S */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void G(Pair pair) {
        rm6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.j.call(pair.first, pair.second);
    }

    public final void T(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (view2 = this.q) != null) {
            view2.setVisibility(0);
            cn6 cn6Var = (cn6) ServiceManager.getService(cn6.a);
            if (cn6Var != null) {
                cn6Var.a(this.q, i);
            }
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.a.n(j);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, context) == null) && this.q == null) {
            View view2 = new View(context);
            this.q = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.q);
            this.q.setVisibility(8);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, downloadListener) == null) {
            this.y = downloadListener;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.k = z;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setNestedScrollingEnabled(z);
            }
        }
    }

    public void setOnDoubleClickListener(jm6 jm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jm6Var) == null) {
            this.m = jm6Var;
        }
    }

    public void setOnLoadUrlListener(km6 km6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, km6Var) == null) {
            this.t = km6Var;
        }
    }

    public void setOnPageFinishedListener(lm6 lm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, lm6Var) == null) {
            this.v = lm6Var;
        }
    }

    public void setOnPageStartedListener(mm6 mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, mm6Var) == null) {
            this.u = mm6Var;
        }
    }

    public void setOnProgressChangedListener(hj6 hj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, hj6Var) == null) {
            this.s = hj6Var;
        }
    }

    public void setOnReceivedErrorListener(nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, nm6Var) == null) {
            this.w = nm6Var;
        }
    }

    public void setOnReceivedSslErrorListener(om6 om6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, om6Var) == null) {
            this.x = om6Var;
        }
    }

    public void setOnScrollChangeListener(qm6 qm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, qm6Var) == null) {
            this.r = qm6Var;
        }
    }

    public void setOnSizeChangedListener(fj6<Integer, Double> fj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, fj6Var) == null) {
            this.j = fj6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, webChromeClient) == null) {
            this.c.c(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, webViewClient) == null) {
            this.d.b(webViewClient);
        }
    }

    public void t(ej6<WebView> ej6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, ej6Var) == null) {
            this.f = ej6Var;
            if (ej6Var != null && (monitorWebView = this.b) != null) {
                ej6Var.call(monitorWebView);
            }
        }
    }

    public /* synthetic */ WebView C() {
        return this.b;
    }

    public void Q() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.r();
        }
    }

    public Map<String, String> getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, gj6<Object>> getBizData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (Map) invokeV.objValue;
    }

    public WebChromeClient getChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c.b();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    @NonNull
    public jn6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.z;
        }
        return (jn6) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public WebView getInnerWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public pn6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a;
        }
        return (pn6) invokeV.objValue;
    }

    @Nullable
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.d.a();
        }
        return (WebViewClient) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public final void r() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (view2 = this.q) != null) {
            view2.setVisibility(8);
        }
    }

    public /* synthetic */ void H(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        nm6 nm6Var = this.w;
        if (nm6Var != null) {
            nm6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.qm6
    public void b(int i, int i2, int i3, int i4) {
        qm6 qm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) && (qm6Var = this.r) != null) {
            qm6Var.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.qm6
    public void d(int i, int i2, int i3, int i4) {
        qm6 qm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) && (qm6Var = this.r) != null) {
            qm6Var.d(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void I(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        om6 om6Var = this.x;
        if (om6Var != null) {
            om6Var.a(webView, sslErrorHandler, sslError);
        }
    }

    public /* synthetic */ void J(String str, String str2, String str3, String str4, long j) {
        DownloadListener downloadListener = this.y;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.b();
                this.b.destroy();
                this.b = null;
            }
            if (this.f != null && !TextUtils.isEmpty(getUrl())) {
                loadUrl(getUrl());
            }
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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

    @Override // com.baidu.tieba.hj6
    public void f(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, webView, i) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.e);
                } else {
                    bn6.f(progressBar, 0);
                    this.h.b(this.e, i);
                }
            }
            if (i >= 100) {
                bn6.f(webView, 0);
            }
            hj6 hj6Var = this.s;
            if (hj6Var != null) {
                hj6Var.f(webView, i);
            }
        }
    }

    @Override // android.view.View, com.baidu.tieba.qm6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048609, this, i, i2, i3, i4) == null) {
            qm6 qm6Var = this.r;
            if (qm6Var != null) {
                qm6Var.onScrollChanged(i, i2, i3, i4);
            }
            View view2 = this.q;
            if (view2 != null && view2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
                layoutParams.height = getHeight() + i2;
                this.q.setLayoutParams(layoutParams);
            }
        }
    }

    public final void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, str) == null) {
            this.a.r(System.currentTimeMillis());
            this.b = (MonitorWebView) ((gn6) ServiceManager.getService(gn6.a)).b(context, str);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new gj6() { // from class: com.baidu.tieba.xi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.C() : invokeV.objValue;
                }
            }, new gj6() { // from class: com.baidu.tieba.dj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gj6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                sxb<Lifecycle.Event> sxbVar = this.p;
                simpleWebViewLifeCycle.getClass();
                sxbVar.F(new ltb() { // from class: com.baidu.tieba.cj6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ltb
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
            ej6<WebView> ej6Var = this.f;
            if (ej6Var != null) {
                t(ej6Var);
            }
            ej6<WebView> ej6Var2 = this.g;
            if (ej6Var2 != null) {
                ej6Var2.call(this.b);
            }
            this.b.getViewHeightBs().k(new ptb() { // from class: com.baidu.tieba.aj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ptb
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.D((Pair) obj) : invokeL.objValue;
                }
            }).h(new qtb() { // from class: com.baidu.tieba.ti6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.qtb
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
            }).F(new ltb() { // from class: com.baidu.tieba.ri6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.G((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            s(context);
            u(this.b);
            if (ul6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                bn6.a(view2);
            }
        }
    }

    public final void u(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new km6() { // from class: com.baidu.tieba.zi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.km6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.L(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new mm6() { // from class: com.baidu.tieba.si6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mm6
                public final void d(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.M(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new lm6() { // from class: com.baidu.tieba.vi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.lm6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.N(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new nm6() { // from class: com.baidu.tieba.yi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.nm6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.H(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new om6() { // from class: com.baidu.tieba.wi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.om6
                public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.I(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.bj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        TbWebView.this.J(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }
}
