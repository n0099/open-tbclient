package com.baidu.tieba.ad.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.eg0;
import com.baidu.tieba.f11;
import com.baidu.tieba.lr4;
import com.baidu.tieba.s06;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public abstract class BaseAdWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public static final String f;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdWebView a;
    public Context b;
    public s06 c;
    public eg0 d;
    public d e;

    /* loaded from: classes5.dex */
    public interface d {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public abstract void b(@NonNull eg0 eg0Var, boolean z);

    public abstract String getUserAgent();

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseAdWebView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseAdWebView baseAdWebView, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Activity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baseAdWebView;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseAdWebView a;

        public b(BaseAdWebView baseAdWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                BaseAdWebView baseAdWebView = this.a;
                if (baseAdWebView.a != null) {
                    baseAdWebView.e(str, str3, str4, j);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        public c(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                BaseAdWebView.setLightTouchEnabled(webView);
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, renderProcessGoneDetail)) == null) {
                lr4.a("BaseAdWebView", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                super.shouldOverrideUrlLoading(webView, str);
                try {
                    if (this.a != null) {
                        if (str.startsWith("tel:")) {
                            this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
                            return true;
                        } else if (str.startsWith("wtai://wp/mc;")) {
                            this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("tel:" + str.substring(13))));
                            return true;
                        } else if (str.startsWith("mailto:")) {
                            this.a.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1028868982, "Lcom/baidu/tieba/ad/webview/BaseAdWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1028868982, "Lcom/baidu/tieba/ad/webview/BaseAdWebView;");
                return;
            }
        }
        f = BaseAdWebView.class.getSimpleName();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.removeAllViews();
            super.destroy();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = this;
        this.b = context;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = this;
        this.b = context;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = this;
        this.b = context;
        c();
    }

    public static void setLightTouchEnabled(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView) == null) {
            webView.loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {\tvar bodystyle = document.body.style.cssText;\tif (bodystyle == undefined || bodystyle == null)\t\tbodystyle = '';\tvar tapstylekey = '-webkit-tap-highlight-color';\tif (bodystyle.indexOf(tapstylekey) < 0) {\t\tbodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';\t\tdocument.body.style.cssText = bodystyle;\t}}\");");
            webView.loadUrl("javascript:SetBodyStyleTapColor();");
        }
    }

    public void d(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eg0Var) == null) {
            this.d = eg0Var;
        }
    }

    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            try {
                CookieSyncManager.createInstance(getContext());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                th.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
                cookieManager.setAcceptThirdPartyCookies(this, z);
            }
        }
    }

    public void setDownloadStartListener(s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, s06Var) == null) {
            this.c = s06Var;
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (!accessibilityManager.isEnabled()) {
                    return;
                }
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.a.removeJavascriptInterface("accessibility");
                this.a.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e) {
                e.printStackTrace();
            }
            a(this.b);
            setScrollbarFadingEnabled(true);
            setVerticalScrollBarEnabled(true);
            setHorizontalScrollBarEnabled(false);
            getSettings().setLightTouchEnabled(true);
            getSettings().setUserAgentString(getUserAgent());
            getSettings().setDefaultTextEncodingName("UTF-8");
            getSettings().setSupportZoom(true);
            getSettings().setJavaScriptEnabled(true);
            getSettings().setAllowFileAccess(false);
            getSettings().setUseWideViewPort(true);
            getSettings().setPluginState(WebSettings.PluginState.ON);
            getSettings().setCacheMode(-1);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setAllowContentAccess(true);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
            }
            getSettings().setDomStorageEnabled(true);
            setWebViewClient(new a(this, (Activity) getContext()));
            clearFocus();
            clearHistory();
            clearView();
            setScrollBarStyle(0);
            setAcceptThirdPartyCookies(true);
            setDownloadListener(new b(this));
            if (GlobalBuildConfig.isDebug()) {
                Log.e(f, "init webview succeed");
            }
        }
    }

    public void e(String str, String str2, String str3, long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Long.valueOf(j)}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.d == null) {
            if (!GlobalBuildConfig.isDebug()) {
                return;
            }
            throw new IllegalArgumentException("cache key is null");
        }
        if (GlobalBuildConfig.isDebug()) {
            Log.e(f, "start downloading.....");
            String str4 = f;
            Log.e(str4, "download url：" + str);
        }
        this.d.g = str;
        String e = f11.e(str, str2, str3);
        if (f11.b(f11.c(e), str3) == 3) {
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(e)) {
            String[] split = str.split("/");
            if (split.length > 1) {
                str = split[split.length - 1];
            }
            if (str != null && str.length() > 50) {
                e = str.substring(0, 50);
            } else {
                e = str;
            }
        }
        eg0 eg0Var = this.d;
        eg0Var.d = e;
        b(eg0Var, z);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            d dVar = this.e;
            if (dVar != null) {
                dVar.onScrollChanged(i, i2, i3, i4);
            }
        }
    }
}
