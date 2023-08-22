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
import com.baidu.tieba.am6;
import com.baidu.tieba.an6;
import com.baidu.tieba.b8c;
import com.baidu.tieba.bm6;
import com.baidu.tieba.bn6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.cm6;
import com.baidu.tieba.dm6;
import com.baidu.tieba.dn6;
import com.baidu.tieba.em6;
import com.baidu.tieba.en6;
import com.baidu.tieba.fm6;
import com.baidu.tieba.g8c;
import com.baidu.tieba.gn6;
import com.baidu.tieba.h8c;
import com.baidu.tieba.hm6;
import com.baidu.tieba.im6;
import com.baidu.tieba.in6;
import com.baidu.tieba.jcc;
import com.baidu.tieba.ll6;
import com.baidu.tieba.ql6;
import com.baidu.tieba.ri6;
import com.baidu.tieba.si6;
import com.baidu.tieba.sm6;
import com.baidu.tieba.ti6;
import com.baidu.tieba.tm6;
import com.baidu.tieba.ui6;
import com.baidu.tieba.wm6;
import com.baidu.tieba.ym6;
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
public class TbWebView extends FrameLayout implements ui6, WebViewLifeCycle, hm6, am6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public gn6 A;
    public final bn6 B;
    public final in6 a;
    @Nullable
    public MonitorWebView b;
    public final zm6 c;
    public final an6 d;
    public ProgressBar e;
    public ri6<WebView> f;
    public ri6<WebView> g;
    public final ql6 h;
    public String i;
    public si6<Integer, Double> j;
    public boolean k;
    public boolean l;
    public am6 m;
    public final Map<String, String> n;
    public final Map<String, ti6<Object>> o;
    public final jcc<Lifecycle.Event> p;
    public View q;
    public hm6 r;
    public ui6 s;
    public bm6 t;
    public dm6 u;
    public cm6 v;
    public em6 w;
    public fm6 x;
    public DownloadListener y;
    @Nullable
    public wm6 z;

    public /* synthetic */ ui6 V() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements ti6<WebView> {
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
        @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
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
    public class b implements ri6<WebView> {
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
        @Override // com.baidu.tieba.ri6
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
    public class c implements ti6<Object> {
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

        @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
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
        this.a = new in6();
        this.c = new dn6(new ti6() { // from class: com.baidu.tieba.ei6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new en6(this);
        this.f = null;
        this.g = null;
        this.h = new ql6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = jcc.R(Lifecycle.Event.ON_RESUME);
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
        this.B = new bn6(new a(this));
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
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
                im6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
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
        this.a = new in6();
        this.c = new dn6(new ti6() { // from class: com.baidu.tieba.ei6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new en6(this);
        this.f = null;
        this.g = null;
        this.h = new ql6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = jcc.R(Lifecycle.Event.ON_RESUME);
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
        this.B = new bn6(new a(this));
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
        this.a = new in6();
        this.c = new dn6(new ti6() { // from class: com.baidu.tieba.ei6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.V() : invokeV.objValue;
            }
        });
        this.d = new en6(this);
        this.f = null;
        this.g = null;
        this.h = new ql6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = jcc.R(Lifecycle.Event.ON_RESUME);
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
        this.B = new bn6(new a(this));
    }

    public void I(String str, ti6<Object> ti6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, ti6Var) == null) {
            this.o.put(str, ti6Var);
        }
    }

    public void J(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, obj) == null) {
            this.o.put(str, new c(this, obj));
        }
    }

    public /* synthetic */ boolean Q(WebView webView, String str) {
        bm6 bm6Var = this.t;
        if (bm6Var != null) {
            return bm6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void R(WebView webView, String str) {
        dm6 dm6Var = this.u;
        if (dm6Var != null) {
            dm6Var.d(webView, str);
        }
    }

    public /* synthetic */ void S(WebView webView, String str) {
        cm6 cm6Var = this.v;
        if (cm6Var != null) {
            cm6Var.onPageFinished(webView, str);
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

    @Override // com.baidu.tieba.am6
    public void j(View view2, MotionEvent motionEvent) {
        am6 am6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, view2, motionEvent) == null) && (am6Var = this.m) != null) {
            am6Var.j(view2, motionEvent);
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, str2) == null) {
            this.n.put(str, str2);
        }
    }

    public void setScrollBarEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = new b(this, i, z);
            this.g = bVar;
            bVar.call((b) this.b);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048639, this, str, i) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048641, this, str, valueCallback) == null) && (monitorWebView = this.b) != null) {
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

    public void F(ri6<WebView> ri6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ri6Var) == null) {
            this.f = ri6Var;
            if (ri6Var != null && (monitorWebView = this.b) != null) {
                ri6Var.call(monitorWebView);
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: F */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: S */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void O(Pair pair) {
        im6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.j.call(pair.first, pair.second);
    }

    public final void Z(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (view2 = this.q) != null) {
            view2.setVisibility(0);
            tm6 tm6Var = (tm6) ServiceManager.getService(tm6.a);
            if (tm6Var != null) {
                tm6Var.a(this.q, i);
            }
        }
    }

    public void p(gn6 gn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, gn6Var) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                gn6Var.a(monitorWebView);
            } else {
                this.A = gn6Var;
            }
        }
    }

    public void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            this.a.n(j);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, downloadListener) == null) {
            this.y = downloadListener;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.k = z;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setNestedScrollingEnabled(z);
            }
        }
    }

    public void setOnDoubleClickListener(am6 am6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, am6Var) == null) {
            this.m = am6Var;
        }
    }

    public void setOnLoadUrlListener(bm6 bm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bm6Var) == null) {
            this.t = bm6Var;
        }
    }

    public void setOnPageFinishedListener(cm6 cm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, cm6Var) == null) {
            this.v = cm6Var;
        }
    }

    public void setOnPageStartedListener(dm6 dm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, dm6Var) == null) {
            this.u = dm6Var;
        }
    }

    public void setOnProgressChangedListener(ui6 ui6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, ui6Var) == null) {
            this.s = ui6Var;
        }
    }

    public void setOnReceivedErrorListener(em6 em6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, em6Var) == null) {
            this.w = em6Var;
        }
    }

    public void setOnReceivedSslErrorListener(fm6 fm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fm6Var) == null) {
            this.x = fm6Var;
        }
    }

    public void setOnScrollChangeListener(hm6 hm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, hm6Var) == null) {
            this.r = hm6Var;
        }
    }

    public void setOnSizeChangedListener(si6<Integer, Double> si6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, si6Var) == null) {
            this.j = si6Var;
        }
    }

    public void setPreRenderMode(PreRenderMode preRenderMode) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, preRenderMode) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.setPreRenderMode(preRenderMode);
        }
    }

    public final void setTargetInterceptor(wm6 wm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, wm6Var) == null) {
            this.z = wm6Var;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setTargetInterceptor(wm6Var);
            }
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, webChromeClient) == null) {
            this.c.c(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, webViewClient) == null) {
            this.d.b(webViewClient);
        }
    }

    public boolean v(@Nullable WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, webView)) == null) {
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
            MonitorWebView monitorWebView = (MonitorWebView) ((ym6) ServiceManager.getService(ym6.a)).b(context, str);
            this.b = monitorWebView;
            monitorWebView.setTargetInterceptor(this.z);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new ti6() { // from class: com.baidu.tieba.ji6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.L() : invokeV.objValue;
                }
            }, new ti6() { // from class: com.baidu.tieba.qi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                jcc<Lifecycle.Event> jccVar = this.p;
                simpleWebViewLifeCycle.getClass();
                jccVar.H(new b8c() { // from class: com.baidu.tieba.pi6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.b8c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            SimpleWebViewLifeCycle.this.c((Lifecycle.Event) obj);
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
            ri6<WebView> ri6Var = this.f;
            if (ri6Var != null) {
                F(ri6Var);
            }
            ri6<WebView> ri6Var2 = this.g;
            if (ri6Var2 != null) {
                ri6Var2.call(this.b);
            }
            this.b.getViewHeightBs().k(new g8c() { // from class: com.baidu.tieba.mi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.g8c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.M((Pair) obj) : invokeL.objValue;
                }
            }).h(new h8c() { // from class: com.baidu.tieba.li6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.h8c
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
            }).H(new b8c() { // from class: com.baidu.tieba.hi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.b8c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.O((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            E(context);
            G(this.b);
            gn6 gn6Var = this.A;
            if (gn6Var != null) {
                gn6Var.a(this.b);
            }
            if (ll6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                sm6.a(view2);
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

    public void a0() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.stopLoading();
        }
    }

    public Map<String, String> getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, ti6<Object>> getBizData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.o;
        }
        return (Map) invokeV.objValue;
    }

    public WebChromeClient getChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.c.b();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    @NonNull
    public bn6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.B;
        }
        return (bn6) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public WebView getInnerWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public in6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a;
        }
        return (in6) invokeV.objValue;
    }

    @Nullable
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.d.a();
        }
        return (WebViewClient) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                return monitorWebView.canGoBack();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.b();
        }
    }

    public final void G(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new bm6() { // from class: com.baidu.tieba.ki6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.bm6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.Q(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new dm6() { // from class: com.baidu.tieba.fi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.dm6
                public final void d(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.R(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new cm6() { // from class: com.baidu.tieba.ii6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.cm6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.S(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new em6() { // from class: com.baidu.tieba.gi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.em6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.T(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new fm6() { // from class: com.baidu.tieba.ni6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.fm6
                public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.U(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.oi6
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
        em6 em6Var = this.w;
        if (em6Var != null) {
            em6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.hm6
    public void c(int i, int i2, int i3, int i4) {
        hm6 hm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) && (hm6Var = this.r) != null) {
            hm6Var.c(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.hm6
    public void d(int i, int i2, int i3, int i4) {
        hm6 hm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) && (hm6Var = this.r) != null) {
            hm6Var.d(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void U(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        fm6 fm6Var = this.x;
        if (fm6Var != null) {
            fm6Var.a(webView, sslErrorHandler, sslError);
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
            if (this.f != null && !TextUtils.isEmpty(getUrl())) {
                loadUrl(getUrl());
            }
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null && monitorWebView.getPreRenderMode() == PreRenderMode.NONE) {
                this.b.loadUrl("file:///android_asset/blank.html");
            }
            this.f = null;
            this.p.onNext(Lifecycle.Event.ON_DESTROY);
            this.p.onCompleted();
            setWebChromeClient(null);
            setWebViewClient(null);
        }
    }

    @Override // com.baidu.tieba.ui6
    public void i(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, webView, i) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.e);
                } else {
                    sm6.f(progressBar, 0);
                    this.h.b(this.e, i);
                }
            }
            if (i >= 100) {
                sm6.f(webView, 0);
            }
            ui6 ui6Var = this.s;
            if (ui6Var != null) {
                ui6Var.i(webView, i);
            }
        }
    }

    @Override // android.view.View, com.baidu.tieba.hm6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048617, this, i, i2, i3, i4) == null) {
            hm6 hm6Var = this.r;
            if (hm6Var != null) {
                hm6Var.onScrollChanged(i, i2, i3, i4);
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
