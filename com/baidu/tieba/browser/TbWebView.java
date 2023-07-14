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
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.lifecycle.WebViewLifeCycle;
import com.baidu.tieba.browser.webview.lifecycle.SimpleWebViewLifeCycle;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.dn6;
import com.baidu.tieba.fo6;
import com.baidu.tieba.go6;
import com.baidu.tieba.i2c;
import com.baidu.tieba.ik6;
import com.baidu.tieba.jk6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.ko6;
import com.baidu.tieba.lk6;
import com.baidu.tieba.lo6;
import com.baidu.tieba.m2c;
import com.baidu.tieba.mo6;
import com.baidu.tieba.n2c;
import com.baidu.tieba.nn6;
import com.baidu.tieba.no6;
import com.baidu.tieba.on6;
import com.baidu.tieba.p6c;
import com.baidu.tieba.pn6;
import com.baidu.tieba.po6;
import com.baidu.tieba.qn6;
import com.baidu.tieba.qo6;
import com.baidu.tieba.rn6;
import com.baidu.tieba.sn6;
import com.baidu.tieba.to6;
import com.baidu.tieba.un6;
import com.baidu.tieba.vn6;
import com.baidu.tieba.ym6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes5.dex */
public class TbWebView extends FrameLayout implements lk6, WebViewLifeCycle, un6, nn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final to6 a;
    @Nullable
    public MonitorWebView b;
    public final lo6 c;
    public final mo6 d;
    public ProgressBar e;
    public ik6<WebView> f;
    public ik6<WebView> g;
    public final dn6 h;
    public String i;
    public jk6<Integer, Double> j;
    public boolean k;
    public boolean l;
    public nn6 m;
    public final Map<String, String> n;
    public final Map<String, kk6<Object>> o;
    public final p6c<Lifecycle.Event> p;
    public View q;
    public un6 r;
    public lk6 s;
    public on6 t;
    public qn6 u;
    public pn6 v;
    public rn6 w;
    public sn6 x;
    public DownloadListener y;
    public final no6 z;

    public /* synthetic */ lk6 S() {
        return this;
    }

    /* loaded from: classes5.dex */
    public class a implements kk6<WebView> {
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
        @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
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
    public class b implements ik6<WebView> {
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
        @Override // com.baidu.tieba.ik6
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
    public class c implements kk6<Object> {
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

        @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
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
        this.a = new to6();
        this.c = new po6(new kk6() { // from class: com.baidu.tieba.yj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.S() : invokeV.objValue;
            }
        });
        this.d = new qo6(this);
        this.f = null;
        this.g = null;
        this.h = new dn6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = p6c.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new no6(new a(this));
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    s(getContext(), str);
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
                vn6.c("newHybrid", "loadUrl 处理耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url=" + str);
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
        this.a = new to6();
        this.c = new po6(new kk6() { // from class: com.baidu.tieba.yj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.S() : invokeV.objValue;
            }
        });
        this.d = new qo6(this);
        this.f = null;
        this.g = null;
        this.h = new dn6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = p6c.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new no6(new a(this));
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
        this.a = new to6();
        this.c = new po6(new kk6() { // from class: com.baidu.tieba.yj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.S() : invokeV.objValue;
            }
        });
        this.d = new qo6(this);
        this.f = null;
        this.g = null;
        this.h = new dn6();
        this.i = null;
        this.l = false;
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = p6c.R(Lifecycle.Event.ON_RESUME);
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = new no6(new a(this));
    }

    public void D(String str, kk6<Object> kk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, kk6Var) == null) {
            this.o.put(str, kk6Var);
        }
    }

    public void E(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            this.o.put(str, new c(this, obj));
        }
    }

    public /* synthetic */ boolean O(WebView webView, String str) {
        on6 on6Var = this.t;
        if (on6Var != null) {
            return on6Var.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }

    public /* synthetic */ void P(WebView webView, String str) {
        qn6 qn6Var = this.u;
        if (qn6Var != null) {
            qn6Var.c(webView, str);
        }
    }

    public /* synthetic */ void R(WebView webView, String str) {
        pn6 pn6Var = this.v;
        if (pn6Var != null) {
            pn6Var.onPageFinished(webView, str);
        }
    }

    public final void V(int i, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048591, this, i, drawable) == null) && this.e == null) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16842872);
            this.e = progressBar;
            progressBar.setProgressDrawable(drawable);
            addView(this.e, new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.baidu.tieba.nn6
    public void j(View view2, MotionEvent motionEvent) {
        nn6 nn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, view2, motionEvent) == null) && (nn6Var = this.m) != null) {
            nn6Var.j(view2, motionEvent);
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            this.n.put(str, str2);
        }
    }

    public void r(String str, ValueCallback<String> valueCallback) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048614, this, str, valueCallback) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public void setScrollBarEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = new b(this, i, z);
            this.g = bVar;
            bVar.call((b) this.b);
        }
    }

    public void setWebViewSkinOverly(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, str, i) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                u();
            } else {
                W(i);
            }
        }
    }

    public /* synthetic */ Boolean G(Pair pair) {
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
    public /* synthetic */ void J(Pair pair) {
        vn6.b("newHybrid", "webView内容高度发生变化:height=" + pair.second);
        this.j.call(pair.first, pair.second);
    }

    public final void W(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (view2 = this.q) != null) {
            view2.setVisibility(0);
            go6 go6Var = (go6) ServiceManager.getService(go6.a);
            if (go6Var != null) {
                go6Var.a(this.q, i);
            }
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.a.n(j);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, downloadListener) == null) {
            this.y = downloadListener;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.k = z;
            MonitorWebView monitorWebView = this.b;
            if (monitorWebView != null) {
                monitorWebView.setNestedScrollingEnabled(z);
            }
        }
    }

    public void setOnDoubleClickListener(nn6 nn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, nn6Var) == null) {
            this.m = nn6Var;
        }
    }

    public void setOnLoadUrlListener(on6 on6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, on6Var) == null) {
            this.t = on6Var;
        }
    }

    public void setOnPageFinishedListener(pn6 pn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, pn6Var) == null) {
            this.v = pn6Var;
        }
    }

    public void setOnPageStartedListener(qn6 qn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, qn6Var) == null) {
            this.u = qn6Var;
        }
    }

    public void setOnProgressChangedListener(lk6 lk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, lk6Var) == null) {
            this.s = lk6Var;
        }
    }

    public void setOnReceivedErrorListener(rn6 rn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, rn6Var) == null) {
            this.w = rn6Var;
        }
    }

    public void setOnReceivedSslErrorListener(sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sn6Var) == null) {
            this.x = sn6Var;
        }
    }

    public void setOnScrollChangeListener(un6 un6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, un6Var) == null) {
            this.r = un6Var;
        }
    }

    public void setOnSizeChangedListener(jk6<Integer, Double> jk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jk6Var) == null) {
            this.j = jk6Var;
        }
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, webChromeClient) == null) {
            this.c.c(webChromeClient);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, webViewClient) == null) {
            this.d.b(webViewClient);
        }
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, context) == null) && this.q == null) {
            View view2 = new View(context);
            this.q = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.q);
            this.q.setVisibility(8);
        }
    }

    public void w(ik6<WebView> ik6Var) {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, ik6Var) == null) {
            this.f = ik6Var;
            if (ik6Var != null && (monitorWebView = this.b) != null) {
                ik6Var.call(monitorWebView);
            }
        }
    }

    public final void A(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, monitorWebView) == null) {
            monitorWebView.setOnScrollChangeListener(this);
            monitorWebView.setOnDoubleClickListener(this);
            monitorWebView.setOnLoadUrlListener(new on6() { // from class: com.baidu.tieba.dk6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.on6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? TbWebView.this.O(webView, str) : invokeLL.booleanValue;
                }
            });
            monitorWebView.setOnPageStartedListener(new qn6() { // from class: com.baidu.tieba.wj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.qn6
                public final void c(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.P(webView, str);
                    }
                }
            });
            monitorWebView.setOnPageFinishedListener(new pn6() { // from class: com.baidu.tieba.zj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pn6
                public final void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        TbWebView.this.R(webView, str);
                    }
                }
            });
            monitorWebView.setOnReceivedErrorListener(new rn6() { // from class: com.baidu.tieba.ck6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rn6
                public final void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                        TbWebView.this.K(webView, webResourceRequest, i, charSequence);
                    }
                }
            });
            monitorWebView.setOnReceivedSslErrorListener(new sn6() { // from class: com.baidu.tieba.ak6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.sn6
                public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
                        TbWebView.this.M(webView, sslErrorHandler, sslError);
                    }
                }
            });
            monitorWebView.setDownloadListener(new DownloadListener() { // from class: com.baidu.tieba.fk6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        TbWebView.this.N(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    public /* synthetic */ WebView F() {
        return this.b;
    }

    public void T() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.r();
        }
    }

    public Map<String, String> getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, kk6<Object>> getBizData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.o;
        }
        return (Map) invokeV.objValue;
    }

    public WebChromeClient getChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c.b();
        }
        return (WebChromeClient) invokeV.objValue;
    }

    @NonNull
    public no6 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.z;
        }
        return (no6) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public WebView getInnerWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (WebView) invokeV.objValue;
    }

    public to6 getPerfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a;
        }
        return (to6) invokeV.objValue;
    }

    @Nullable
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d.a();
        }
        return (WebViewClient) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.h.c();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.p.onNext(Lifecycle.Event.ON_RESUME);
        }
    }

    public void t() {
        MonitorWebView monitorWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (monitorWebView = this.b) != null) {
            monitorWebView.goBack();
        }
    }

    public final void u() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (view2 = this.q) != null) {
            view2.setVisibility(8);
        }
    }

    public /* synthetic */ void K(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
        rn6 rn6Var = this.w;
        if (rn6Var != null) {
            rn6Var.a(webView, webResourceRequest, i, charSequence);
        }
    }

    @Override // com.baidu.tieba.un6
    public void b(int i, int i2, int i3, int i4) {
        un6 un6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048593, this, i, i2, i3, i4) == null) && (un6Var = this.r) != null) {
            un6Var.b(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.un6
    public void d(int i, int i2, int i3, int i4) {
        un6 un6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048594, this, i, i2, i3, i4) == null) && (un6Var = this.r) != null) {
            un6Var.d(i, i2, i3, i4);
        }
    }

    public /* synthetic */ void M(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sn6 sn6Var = this.x;
        if (sn6Var != null) {
            sn6Var.a(webView, sslErrorHandler, sslError);
        }
    }

    public /* synthetic */ void N(String str, String str2, String str3, String str4, long j) {
        DownloadListener downloadListener = this.y;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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

    @Override // com.baidu.tieba.lk6
    public void i(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, webView, i) == null) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                if (i >= 100) {
                    progressBar.setProgress(i);
                    this.h.a(this.e);
                } else {
                    fo6.f(progressBar, 0);
                    this.h.b(this.e, i);
                }
            }
            if (i >= 100) {
                fo6.f(webView, 0);
            }
            lk6 lk6Var = this.s;
            if (lk6Var != null) {
                lk6Var.i(webView, i);
            }
        }
    }

    @Override // android.view.View, com.baidu.tieba.un6
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048612, this, i, i2, i3, i4) == null) {
            un6 un6Var = this.r;
            if (un6Var != null) {
                un6Var.onScrollChanged(i, i2, i3, i4);
            }
            View view2 = this.q;
            if (view2 != null && view2.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
                layoutParams.height = getHeight() + i2;
                this.q.setLayoutParams(layoutParams);
            }
        }
    }

    public final void s(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
            this.a.r(System.currentTimeMillis());
            this.b = (MonitorWebView) ((ko6) ServiceManager.getService(ko6.a)).b(context, str);
            final SimpleWebViewLifeCycle simpleWebViewLifeCycle = new SimpleWebViewLifeCycle(new kk6() { // from class: com.baidu.tieba.bk6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.F() : invokeV.objValue;
                }
            }, new kk6() { // from class: com.baidu.tieba.hk6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.kk6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbWebView.this.getUrl() : invokeV.objValue;
                }
            });
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().addObserver(simpleWebViewLifeCycle);
            } else {
                p6c<Lifecycle.Event> p6cVar = this.p;
                simpleWebViewLifeCycle.getClass();
                p6cVar.H(new i2c() { // from class: com.baidu.tieba.gk6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.i2c
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
            ik6<WebView> ik6Var = this.f;
            if (ik6Var != null) {
                w(ik6Var);
            }
            ik6<WebView> ik6Var2 = this.g;
            if (ik6Var2 != null) {
                ik6Var2.call(this.b);
            }
            this.b.getViewHeightBs().k(new m2c() { // from class: com.baidu.tieba.ek6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.m2c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? TbWebView.this.G((Pair) obj) : invokeL.objValue;
                }
            }).h(new n2c() { // from class: com.baidu.tieba.xj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.n2c
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
            }).H(new i2c() { // from class: com.baidu.tieba.vj6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i2c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TbWebView.this.J((Pair) obj);
                    }
                }
            });
            this.a.q(System.currentTimeMillis());
            v(context);
            A(this.b);
            if (ym6.a()) {
                View view2 = new View(context);
                view2.setBackgroundResource(R.drawable.tv_circle_shape);
                int i = (int) (context.getResources().getDisplayMetrics().density * 15.0f);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
                marginLayoutParams.topMargin = i;
                marginLayoutParams.leftMargin = i;
                addView(view2, marginLayoutParams);
                fo6.a(view2);
            }
        }
    }
}
