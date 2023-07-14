package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.NestedScrollWebView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.floatball.FloatWebLayout;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b16 implements f16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    public LinearLayout b;
    public final FloatWebLayout c;
    public final NestedScrollWebView d;
    public final FrameLayout e;
    public do5 f;
    public co5 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public final lda m;
    public final nda n;

    @Override // com.baidu.tieba.vu5
    public void P(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
        }
    }

    @Override // com.baidu.tieba.wu5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wu5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wu5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements nda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b16 a;

        public a(b16 b16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b16Var;
        }

        @Override // com.baidu.tieba.nda
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.m != null) {
                    return this.a.m.c(this.a.d, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b16 a;

        public b(b16 b16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.Q(this.a.a, R.string.obfuscated_res_0x7f0f0e1f);
                } else {
                    this.a.t();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b16 a;

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public c(b16 b16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b16Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.h = false;
                if (this.a.d != null && this.a.e != null) {
                    if (this.a.i) {
                        this.a.d.stopLoading();
                        this.a.d.setVisibility(8);
                        this.a.e.setVisibility(0);
                        this.a.u();
                        this.a.y();
                        return;
                    }
                    this.a.j = false;
                    this.a.d.setVisibility(0);
                    this.a.e.setVisibility(8);
                    this.a.u();
                    this.a.v();
                    this.a.c.setCenterTitle(webView.getTitle());
                    if (this.a.d.canGoBack()) {
                        this.a.c.k();
                    } else {
                        this.a.c.d();
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.d != null && this.a.e != null) {
                    this.a.i = false;
                    if (this.a.j) {
                        this.a.h = true;
                        this.a.e.setVisibility(0);
                        this.a.x();
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.i = true;
                if (this.a.d != null && this.a.e != null) {
                    this.a.d.stopLoading();
                    this.a.d.setVisibility(8);
                    this.a.e.setVisibility(0);
                    this.a.u();
                    this.a.y();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.a.d == null) {
                    return false;
                }
                if (this.a.j) {
                    this.a.j = false;
                    return false;
                } else if (this.a.s(str) && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a);
                    return false;
                } else {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b16 a;

        public d(b16 b16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b16Var;
        }

        public /* synthetic */ d(b16 b16Var, a aVar) {
            this(b16Var);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) != null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                return;
            }
            this.a.a.startActivity(intent);
        }
    }

    public b16(@NonNull Context context, LinearLayout linearLayout, FloatWebLayout floatWebLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, linearLayout, floatWebLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.k = true;
        this.n = new a(this);
        this.a = context;
        this.b = linearLayout;
        this.c = floatWebLayout;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_float_web_content_view, (ViewGroup) linearLayout, true);
        this.d = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f0929c2);
        this.e = (FrameLayout) inflate.findViewById(R.id.load_state_container);
        lda ldaVar = new lda();
        this.m = ldaVar;
        ldaVar.a(new CommonTbJsBridge(context));
        this.m.a(new UegTbJsBridge(context));
        nx4.k(context);
        w();
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && this.d != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.d, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.f16
    public void m1(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) && this.d != null) {
            if (z || this.j) {
                this.l = str;
                CompatibleUtile.getInstance().loadUrl(this.d, str);
            }
        }
    }

    @Override // com.baidu.tieba.wu5
    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.getScrollY() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f16
    public boolean goBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NestedScrollWebView nestedScrollWebView = this.d;
            if (nestedScrollWebView != null && nestedScrollWebView.canGoBack()) {
                this.d.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f16
    public void onDestroy() {
        lda ldaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ldaVar = this.m) != null) {
            ldaVar.h();
        }
    }

    @Override // com.baidu.tieba.f16
    public void onPause() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (nestedScrollWebView = this.d) == null) {
            return;
        }
        try {
            nestedScrollWebView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
        r(MissionEvent.MESSAGE_PAUSE);
        lda ldaVar = this.m;
        if (ldaVar != null) {
            ldaVar.i(this.d, CommonTbJsBridge.RE_HIDE, null);
        }
    }

    public final void u() {
        co5 co5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (co5Var = this.g) != null) {
            co5Var.dettachView(this.e);
        }
    }

    public final void v() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (do5Var = this.f) != null) {
            do5Var.dettachView(this.e);
        }
    }

    @Override // com.baidu.tieba.f16
    public void onResume() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (nestedScrollWebView = this.d) == null) {
            return;
        }
        try {
            nestedScrollWebView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        r("onResume");
        lda ldaVar = this.m;
        if (ldaVar != null) {
            ldaVar.i(this.d, CommonTbJsBridge.RE_SHOW, null);
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.k) {
                this.m.i(this.d, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
        }
        this.k = false;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.e != null && this.d != null && !this.h && !TextUtils.isEmpty(this.l) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.h = true;
            this.j = true;
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            v();
            x();
            m1(this.l, true);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f == null) {
                this.f = new do5(this.a, new b(this));
            }
            this.f.n(this.a.getString(R.string.url_not_found));
            this.f.g(this.a.getString(R.string.obfuscated_res_0x7f0f11f9));
            this.f.i(R.drawable.new_pic_emotion_08);
            this.f.attachView(this.e, false);
            this.f.p();
        }
    }

    public void w() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (nestedScrollWebView = this.d) != null) {
            nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
            this.d.getSettings().setJavaScriptEnabled(true);
            this.d.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.d.getSettings().setAllowFileAccess(true);
            this.d.getSettings().setDatabaseEnabled(true);
            this.d.getSettings().setDomStorageEnabled(true);
            this.d.getSettings().setSupportZoom(true);
            this.d.getSettings().setBuiltInZoomControls(true);
            this.d.getSettings().setUseWideViewPort(true);
            this.d.getSettings().setLoadWithOverviewMode(true);
            this.d.getSettings().setDatabasePath(this.a.getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.d.setHorizontalScrollBarEnabled(false);
            this.d.setHorizontalScrollbarOverlay(false);
            this.d.setInitialScale(100);
            this.d.setScrollBarStyle(33554432);
            this.d.setWebViewClient(new c(this));
            this.d.setDownloadListener(new d(this, null));
            if (this.a instanceof Activity) {
                a16 a16Var = new a16((Activity) this.a);
                a16Var.b(this.n);
                this.d.setWebChromeClient(a16Var);
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.d);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            co5 co5Var = this.g;
            if (co5Var != null && co5Var.isViewAttached()) {
                return;
            }
            if (this.g == null) {
                co5 co5Var2 = new co5(this.a);
                this.g = co5Var2;
                co5Var2.s(TbadkCoreApplication.getInst().getSkinType());
                this.g.onChangeSkinType();
            }
            this.g.attachView(this.e, false);
        }
    }
}
