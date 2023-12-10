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
import com.baidu.tieba.ak6;
import com.baidu.tieba.al6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.browser.webview.scroll.NestedScrollingWebView;
import com.baidu.tieba.ck6;
import com.baidu.tieba.cl6;
import com.baidu.tieba.ctc;
import com.baidu.tieba.dk6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.gj6;
import com.baidu.tieba.jl6;
import com.baidu.tieba.kg6;
import com.baidu.tieba.kl6;
import com.baidu.tieba.lg6;
import com.baidu.tieba.lj6;
import com.baidu.tieba.loc;
import com.baidu.tieba.mg6;
import com.baidu.tieba.ng6;
import com.baidu.tieba.rk6;
import com.baidu.tieba.sk6;
import com.baidu.tieba.soc;
import com.baidu.tieba.vj6;
import com.baidu.tieba.vk6;
import com.baidu.tieba.wj6;
import com.baidu.tieba.xj6;
import com.baidu.tieba.xk6;
import com.baidu.tieba.xoc;
import com.baidu.tieba.yj6;
import com.baidu.tieba.yk6;
import com.baidu.tieba.yoc;
import com.baidu.tieba.zj6;
import com.baidu.tieba.zk6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes5.dex */
public class TbWebView extends FrameLayout implements ng6, WebViewLifeCycle, ck6, vj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadListener A;
    @Nullable
    public vk6 B;
    @Nullable
    public fl6 C;
    public loc D;
    public mg6<Object> E;
    public final al6 F;
    public final jl6 a;
    public final kl6 b;
    @Nullable
    public MonitorWebView c;
    public final yk6 d;
    public final zk6 e;
    public ProgressBar f;
    public kg6<WebView> g;
    public kg6<WebView> h;
    public kg6<WebView> i;
    public final lj6 j;
    public String k;
    public lg6<Integer, Double> l;
    public boolean m;
    public boolean n;
    public vj6 o;
    public final Map<String, String> p;
    public final Map<String, mg6<Object>> q;
    public final ctc<Lifecycle.Event> r;
    public View s;
    public ck6 t;
    public ng6 u;
    public wj6 v;
    public yj6 w;
    public xj6 x;
    public zj6 y;
    public ak6 z;

    public /* synthetic */ ng6 V() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements mg6<WebView> {
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
        @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
        /* renamed from: a */
        public WebView call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (WebView) invokeV.objValue;
            }
            return this.a.c;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kg6<WebView> {
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
        @Override // com.baidu.tieba.kg6
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
    public class c implements kg6<WebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class a;
        public final /* synthetic */ TbWebView b;

        public c(TbWebView tbWebView, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebView, cls};
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
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg6
        /* renamed from: a */
        public void call(WebView webView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, webView) == null) && (webView instanceof NestedScrollingWebView)) {
                ((NestedScrollingWebView) webView).setInterceptTargetParentClz(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements mg6<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;
        public final /* synthetic */ TbWebView b;

        public d(TbWebView tbWebView, Object obj) {
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

        @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
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
        this.a = new jl6();
        this.b = new kl6();
        this.d = new cl6(new mg6() { // from class: com.baidu.tieba.xf6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.e = new dl6(this);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new lj6();
        this.k = null;
        this.n = false;
        this.p = new HashMap();
        this.q = new HashMap();
        this.r = ctc.R(Lifecycle.Event.ON_RESUME);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = new al6(new a(this));
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
        this.a = new jl6();
        this.b = new kl6();
        this.d = new cl6(new mg6() { // from class: com.baidu.tieba.xf6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.e = new dl6(this);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new lj6();
        this.k = null;
        this.n = false;
        this.p = new HashMap();
        this.q = new HashMap();
        this.r = ctc.R(Lifecycle.Event.ON_RESUME);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = new al6(new a(this));
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
        this.a = new jl6();
        this.b = new kl6();
        this.d = new cl6(new mg6() { // from class: com.baidu.tieba.xf6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.e = new dl6(this);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new lj6();
        this.k = null;
        this.n = false;
        this.p = new HashMap();
        this.q = new HashMap();
        this.r = ctc.R(Lifecycle.Event.ON_RESUME);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = new al6(new a(this));
    }

    public void I(String str, mg6<Object> mg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, mg6Var) == null) {
            this.q.put(str, mg6Var);
        }
    }

    public void J(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, obj) == null) {
            this.q.put(str, new d(this, obj));
        }
    }

    public /* synthetic */ boolean Q(WebView webView, String str) {
        wj6 wj6Var = this.v;
        if (wj6Var != null) {
            return wj6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void R(WebView webView, String str) {
        yj6 yj6Var = this.w;
        if (yj6Var != null) {
            yj6Var.a(webView, str);
        }
    }

    public /* synthetic */ void S(WebView webView, String str) {
        xj6 xj6Var = this.x;
        if (xj6Var != null) {
            xj6Var.onPageFinished(webView, str);
        }
    }

    public final void Y(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048595, this, i, drawable) == null) && this.f == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.f = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.f, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.vj6
    public void i(View view2, MotionEvent motionEvent) {
        vj6 vj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, view2, motionEvent) == null) && (vj6Var = this.o) != null) {
            vj6Var.i(view2, motionEvent);
        }
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            this.p.put(str, str2);
        }
    }

    public void setScrollBarEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = new b(this, i, z);
            this.h = bVar;
            bVar.call(this.c);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048642, this, str, i) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                D();
            } else {
                Z(i);
            }
        }
    }

    public void v(String str, ValueCallback<String> valueCallback) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048644, this, str, valueCallback) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.s == null) {
            View view2 = new View(context);
            this.s = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.s);
            this.s.setVisibility(8);
        }
    }

    public void F(kg6<WebView> kg6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kg6Var) == null) {
            this.g = kg6Var;
            if (kg6Var != null && (monitorWebView = this.c) != null) {
                kg6Var.call(monitorWebView);
            }
        }
    }

    public /* synthetic */ Boolean M(Pair pair) {
        boolean z;
        if (pair != null && this.l != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public /* synthetic */ void O(Pair pair) {
        dk6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.l.a((Integer) pair.first, (Double) pair.second);
    }

    public final void Z(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (view2 = this.s) != null) {
            view2.setVisibility(0);
            sk6 sk6Var = (sk6) ServiceManager.getService(sk6.a);
            if (sk6Var != null) {
                sk6Var.a(this.s, i);
            }
        }
    }

    public void m(fl6 fl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fl6Var) == null) {
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                fl6Var.a(monitorWebView);
            }
            this.C = fl6Var;
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
            this.A = downloadListener;
        }
    }

    public void setInterceptParentCls(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cls) == null) {
            c cVar = new c(this, cls);
            this.i = cVar;
            cVar.call(this.c);
        }
    }

    public void setInvalidPageCallback(mg6<Object> mg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, mg6Var) == null) {
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                monitorWebView.setInvalidPageCallback(mg6Var);
            }
            this.E = mg6Var;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.n = z;
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                monitorWebView.setNeedDisAllowParentInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.m = z;
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                monitorWebView.setNestedScrollingEnabled(z);
            }
        }
    }

    public void setOnDoubleClickListener(vj6 vj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, vj6Var) == null) {
            this.o = vj6Var;
        }
    }

    public void setOnLoadUrlListener(wj6 wj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, wj6Var) == null) {
            this.v = wj6Var;
        }
    }

    public void setOnPageFinishedListener(xj6 xj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, xj6Var) == null) {
            this.x = xj6Var;
        }
    }

    public void setOnPageStartedListener(yj6 yj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, yj6Var) == null) {
            this.w = yj6Var;
        }
    }

    public void setOnProgressChangedListener(ng6 ng6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, ng6Var) == null) {
            this.u = ng6Var;
        }
    }

    public void setOnReceivedErrorListener(zj6 zj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, zj6Var) == null) {
            this.y = zj6Var;
        }
    }

    public void setOnReceivedSslErrorListener(ak6 ak6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, ak6Var) == null) {
            this.z = ak6Var;
        }
    }

    public void setOnScrollChangeListener(ck6 ck6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, ck6Var) == null) {
            this.t = ck6Var;
        }
    }

    public void setOnSizeChangedListener(lg6<Integer, Double> lg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, lg6Var) == null) {
            this.l = lg6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, preRenderMode) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.setPreRenderMode(preRenderMode);
        }
    }

    public final void setTargetInterceptor(vk6 vk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, vk6Var) == null) {
            this.B = vk6Var;
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                monitorWebView.setTargetInterceptor(vk6Var);
            }
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, webChromeClient) == null) {
            this.d.c(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, webViewClient) == null) {
            this.e.b(webViewClient);
        }
    }

    public boolean u(@Nullable WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, webView)) == null) {
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null && monitorWebView == webView) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void B() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.goBack();
        }
    }

    public final void D() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (view2 = this.s) != null) {
            view2.setVisibility(8);
        }
    }

    public /* synthetic */ WebView K() {
        return this.c;
    }

    public void W() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.y();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null) {
                monitorWebView.b();
                this.c.destroy();
                this.c = null;
            }
            if (!TextUtils.isEmpty(getUrl())) {
                loadUrl(getUrl());
            }
        }
    }

    public void a0() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.stopLoading();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            loc locVar = this.D;
            if (locVar != null && locVar.isUnsubscribed()) {
                this.D.unsubscribe();
            }
            this.D = null;
        }
    }

    public Map<String, String> getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.p;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, mg6<Object>> getBizData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.q;
        }
        return (Map) invokeV.objValue;
    }

    public WebChromeClient getChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d.b();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    @NonNull
    public al6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.F;
        }
        return (al6) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public WebView getInnerWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.c;
        }
        return (WebView) invokeV.objValue;
    }

    public jl6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.a;
        }
        return (jl6) invokeV.objValue;
    }

    @Nullable
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!TextUtils.isEmpty(this.k)) {
                return this.k;
            }
            MonitorWebView monitorWebView = this.c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.e.a();
        }
        return (WebViewClient) invokeV.objValue;
    }

    @NonNull
    public kl6 getWhitePageMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.b;
        }
        return (kl6) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            MonitorWebView monitorWebView = this.c;
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
            this.j.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.r.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.r.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public void q() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (monitorWebView = this.c) != null) {
            monitorWebView.b();
        }
    }

    public final void G(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new wj6() { // from class: com.baidu.tieba.dg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.wj6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.Q(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new yj6() { // from class: com.baidu.tieba.yf6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yj6
                public final void a(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.R(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new xj6() { // from class: com.baidu.tieba.bg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.xj6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.S(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new zj6() { // from class: com.baidu.tieba.zf6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zj6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.T(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new ak6() { // from class: com.baidu.tieba.gg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ak6
                public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.U(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.hg6
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
        DownloadListener downloadListener = this.A;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public /* synthetic */ void T(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        zj6 zj6Var = this.y;
        if (zj6Var != null) {
            zj6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.ck6
    public void b(int i, int i2, int i3, int i4) {
        ck6 ck6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048598, this, i, i2, i3, i4) == null) && (ck6Var = this.t) != null) {
            ck6Var.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.ck6
    public void d(int i, int i2, int i3, int i4) {
        ck6 ck6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) && (ck6Var = this.t) != null) {
            ck6Var.d(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void U(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        ak6 ak6Var = this.z;
        if (ak6Var != null) {
            ak6Var.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.tieba.ng6
    public void f(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, webView, i) == null) {
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.j.a(this.f);
                } else {
                    rk6.f(progressBar, 0);
                    this.j.b(this.f, i);
                }
            }
            if (i >= 100) {
                rk6.f(webView, 0);
            }
            ng6 ng6Var = this.u;
            if (ng6Var != null) {
                ng6Var.f(webView, i);
            }
        }
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                if (this.c == null) {
                    w(getContext(), str);
                    this.b.a(this.c);
                }
                if (this.c.getPreRenderMode() == PreRenderMode.NONE) {
                    if (this.c.w(str)) {
                        this.k = str;
                    }
                    this.c.loadUrl(str);
                } else {
                    this.k = str;
                    this.c.setVisibility(0);
                    this.c.y();
                }
                dk6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
            }
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "页面展现前被关闭，onDestroy执行");
            hashMap.put("webviewWhiteType", "3");
            this.b.b(getUrl(), hashMap);
            b0();
            MonitorWebView monitorWebView = this.c;
            if (monitorWebView != null && monitorWebView.getPreRenderMode() == PreRenderMode.NONE) {
                this.c.loadUrl("about:blank");
            }
            this.g = null;
            this.r.onNext(Lifecycle.Event.ON_DESTROY);
            this.r.onCompleted();
            setWebChromeClient(null);
            setWebViewClient(null);
        }
    }

    @Override // android.view.View, com.baidu.tieba.ck6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i, i2, i3, i4) == null) {
            ck6 ck6Var = this.t;
            if (ck6Var != null) {
                ck6Var.onScrollChanged(i, i2, i3, i4);
            }
            View view2 = this.s;
            if (view2 != null && view2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
                layoutParams.height = getHeight() + i2;
                this.s.setLayoutParams(layoutParams);
            }
        }
    }

    public final void w(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, context, str) == null) {
            this.a.r(System.currentTimeMillis());
            MonitorWebView monitorWebView = (MonitorWebView) ((xk6) ServiceManager.getService(xk6.a)).b(context, str);
            this.c = monitorWebView;
            monitorWebView.setTargetInterceptor(this.B);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new mg6() { // from class: com.baidu.tieba.cg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.K() : invokeV.objValue;
                }
            }, new mg6() { // from class: com.baidu.tieba.jg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                this.r.H(new soc() { // from class: com.baidu.tieba.ig6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.soc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            SimpleWebViewLifeCycle.this.b((Lifecycle.Event) obj);
                        }
                    }
                });
            }
            this.c.setNestedScrollingEnabled(this.m);
            this.c.setNeedDisAllowParentInterceptTouchEvent(this.n);
            this.c.setWebChromeClient(this.d);
            this.c.setWebViewClient(this.e);
            this.c.setPerfData(this.a);
            addView(this.c, new FrameLayout.LayoutParams(-1, -1));
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                progressBar.bringToFront();
            }
            kg6<WebView> kg6Var = this.g;
            if (kg6Var != null) {
                F(kg6Var);
            }
            kg6<WebView> kg6Var2 = this.h;
            if (kg6Var2 != null) {
                kg6Var2.call(this.c);
            }
            kg6<WebView> kg6Var3 = this.i;
            if (kg6Var3 != null) {
                kg6Var3.call(this.c);
            }
            b0();
            this.D = this.c.getViewHeightBs().k(new xoc() { // from class: com.baidu.tieba.fg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.xoc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.M((Pair) obj) : invokeL.objValue;
                }
            }).h(new yoc() { // from class: com.baidu.tieba.eg6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yoc
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
            }).H(new soc() { // from class: com.baidu.tieba.ag6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.soc
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.O((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            E(context);
            G(this.c);
            fl6 fl6Var = this.C;
            if (fl6Var != null) {
                fl6Var.a(this.c);
            }
            mg6<Object> mg6Var = this.E;
            if (mg6Var != null) {
                this.c.setInvalidPageCallback(mg6Var);
            }
            if (gj6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                rk6.a(view2);
            }
        }
    }
}
