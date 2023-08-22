package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.browser.core.cache.prefetch.FetchStaticResourceManager;
import com.baidu.tieba.browser.core.webview.base.BaseWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class cj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ej6<MonitorWebView> a;
    public boolean b;
    public int c;
    public int d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ cj6 c;

        public a(cj6 cj6Var, MonitorWebView monitorWebView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj6Var, monitorWebView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj6Var;
            this.a = monitorWebView;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
                HybridLog.getInstance().e("CachedManager", "WebView空白页监听未触发，进行兜底销毁");
                this.a.destroy();
                this.c.a.a(this.c.c(this.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cm6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MonitorWebView a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ cj6 c;

        public b(cj6 cj6Var, MonitorWebView monitorWebView, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj6Var, monitorWebView, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj6Var;
            this.a = monitorWebView;
            this.b = runnable;
        }

        @Override // com.baidu.tieba.cm6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) && this.a != null) {
                HybridLog.getInstance().i("CachedManager", "WebView空白页监听，开始回收");
                ((BaseWebView) this.a).D();
                SafeHandler.getInst().removeCallbacks(this.b);
                this.c.a.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final cj6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-888422501, "Lcom/baidu/tieba/cj6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-888422501, "Lcom/baidu/tieba/cj6$c;");
                    return;
                }
            }
            a = new cj6(null);
        }
    }

    public cj6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = -1;
        this.a = new gj6(8);
    }

    public static cj6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a;
        }
        return (cj6) invokeV.objValue;
    }

    public void b() {
        ej6<MonitorWebView> ej6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ej6Var = this.a) != null) {
            ej6Var.d();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FetchStaticResourceManager.e();
        }
    }

    public /* synthetic */ cj6(a aVar) {
        this();
    }

    @NonNull
    public MonitorWebView c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new BaseWebView(new MutableContextWrapper(e(context)));
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public final ContextThemeWrapper e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            if (theme != null) {
                theme.resolveAttribute(16973840, typedValue, true);
            }
            return new ContextThemeWrapper(context, typedValue.resourceId);
        }
        return (ContextThemeWrapper) invokeL.objValue;
    }

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            try {
                if (uh.a()) {
                    k(c(context));
                    this.b = true;
                    k(c(context));
                }
            } catch (Exception unused) {
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c < 0) {
                this.c = SharedPrefHelper.getInstance().getInt("webview_blank_page_switch_android", 2);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("CachedManager", "初始化空白页设置开关：" + this.c);
            }
            return this.c;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d < 0) {
                this.d = SharedPrefHelper.getInstance().getInt("webview_reuse_limit_android", 3);
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("CachedManager", "初始化webview复用次数：" + this.d);
            }
            return this.d;
        }
        return invokeV.intValue;
    }

    @NonNull
    public MonitorWebView j(Context context) {
        InterceptResult invokeL;
        MonitorWebView c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (context == null) {
                context = kl6.getContext();
            }
            if (uh.a()) {
                c2 = this.a.b();
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("CachedManager", "尝试获取可复用WebView：" + c2);
                if (c2 == null) {
                    if (!this.b) {
                        TbLog hybridLog2 = HybridLog.getInstance();
                        hybridLog2.e("CachedManager", "冷启立刻就加载WebView？：" + context);
                    }
                    c2 = c(context);
                }
            } else {
                c2 = c(context);
            }
            Context context2 = c2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else {
                c2.destroy();
                c2 = c(context);
            }
            vj6.d(c2);
            return c2;
        }
        return (MonitorWebView) invokeL.objValue;
    }

    public void k(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView) == null) {
            if (webView instanceof MonitorWebView) {
                MonitorWebView monitorWebView = (MonitorWebView) webView;
                boolean z = false;
                Context context = monitorWebView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(kl6.getContext());
                    z = true;
                }
                if (uh.a() && z && monitorWebView.v() && monitorWebView.p < g() && monitorWebView.q == 2) {
                    monitorWebView.p++;
                    if (d() == 2 && (monitorWebView instanceof BaseWebView)) {
                        a aVar = new a(this, monitorWebView, context);
                        ((BaseWebView) monitorWebView).E(new b(this, monitorWebView, aVar));
                        SafeHandler.getInst().postDelayed(aVar, 200L);
                    } else {
                        if (monitorWebView.q != 2) {
                            HybridLog.getInstance().e("CachedManager", "WebView本次没有正常加载，不进行复用：" + monitorWebView.q);
                        } else if (monitorWebView.p > g()) {
                            HybridLog.getInstance().e("CachedManager", "WebView超过复用次数上限，不进行复用：" + monitorWebView.p);
                        }
                        this.a.a(monitorWebView);
                    }
                    HybridLog.getInstance().i("CachedManager", "WebView放回缓存池：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                    return;
                }
                HybridLog.getInstance().i("CachedManager", "销毁WebView：" + monitorWebView + " url:" + monitorWebView.getOriginalUrl());
                monitorWebView.destroy();
            } else if (webView != null) {
                webView.destroy();
            }
        }
    }
}
