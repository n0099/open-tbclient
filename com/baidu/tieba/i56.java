package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.flyweight.FlyweightWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class i56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l56<FlyweightWebView> a;
    public final j56<FlyweightWebView> b;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final i56 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-765594270, "Lcom/baidu/tieba/i56$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-765594270, "Lcom/baidu/tieba/i56$a;");
                    return;
                }
            }
            a = new i56(null);
        }
    }

    public i56() {
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
        this.b = new k56(8);
        this.a = new l56<>();
    }

    public static i56 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a.a;
        }
        return (i56) invokeV.objValue;
    }

    public /* synthetic */ i56(h56 h56Var) {
        this();
    }

    @NonNull
    public FlyweightWebView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            o76.b("lt-log", "我创建了新的webview:");
            return new FlyweightWebView(new MutableContextWrapper(b(context)));
        }
        return (FlyweightWebView) invokeL.objValue;
    }

    public final ContextThemeWrapper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            if (theme != null) {
                theme.resolveAttribute(16973840, typedValue, true);
            }
            return new ContextThemeWrapper(context, typedValue.resourceId);
        }
        return (ContextThemeWrapper) invokeL.objValue;
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            f(a(context));
        }
    }

    @NonNull
    public FlyweightWebView e(Context context, String str) {
        InterceptResult invokeLL;
        FlyweightWebView flyweightWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                flyweightWebView = this.a.a(str);
                if (flyweightWebView != null) {
                    o76.b("lt-log", "我在预热池里找到了webview");
                }
            } else {
                flyweightWebView = null;
            }
            if (flyweightWebView == null && (flyweightWebView = this.b.a()) != null) {
                o76.b("lt-log", "我在复用池里找到了webview");
            }
            if (flyweightWebView == null) {
                flyweightWebView = a(context);
            } else {
                ((MutableContextWrapper) flyweightWebView.getContext()).setBaseContext(b(context));
            }
            q76.a().b();
            return flyweightWebView;
        }
        return (FlyweightWebView) invokeLL.objValue;
    }

    public void f(@NonNull WebView webView) {
        FlyweightWebView flyweightWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webView) == null) {
            if (webView instanceof FlyweightWebView) {
                flyweightWebView = (FlyweightWebView) webView;
            } else {
                flyweightWebView = null;
            }
            if (flyweightWebView == null) {
                return;
            }
            boolean z = false;
            if (flyweightWebView.d()) {
                z = this.a.b(flyweightWebView);
            }
            if (!z) {
                this.b.c(flyweightWebView);
            }
            q76.a().c();
        }
    }
}
