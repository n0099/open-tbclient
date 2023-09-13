package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.floatball.FloatWebLayout;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d06 implements c06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    public LinearLayout b;
    public final FloatWebLayout c;
    public final TbWebView d;
    public final FrameLayout e;
    public wn5 f;
    public LoadingView g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;

    @Override // com.baidu.tieba.wt5
    public void W(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
        }
    }

    @Override // com.baidu.tieba.xt5
    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xt5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d06 a;

        public a(d06 d06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.a, (int) R.string.obfuscated_res_0x7f0f0e40);
                } else {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d06 a;

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(d06 d06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d06Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.h = false;
                if (this.a.d != null && this.a.e != null) {
                    if (this.a.i) {
                        this.a.d.getController().e();
                        this.a.d.setVisibility(8);
                        this.a.e.setVisibility(0);
                        this.a.t();
                        this.a.x();
                        return;
                    }
                    this.a.j = false;
                    this.a.d.setVisibility(0);
                    this.a.e.setVisibility(8);
                    this.a.t();
                    this.a.u();
                    this.a.c.setCenterTitle(webView.getTitle());
                    if (this.a.d.getController().a()) {
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
                        this.a.w();
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
                    this.a.d.getController().e();
                    this.a.d.setVisibility(8);
                    this.a.e.setVisibility(0);
                    this.a.t();
                    this.a.x();
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
                } else if (this.a.q(str) && !TbadkCoreApplication.isLogin()) {
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
    public class c implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d06 a;

        public c(d06 d06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d06Var;
        }

        public /* synthetic */ c(d06 d06Var, a aVar) {
            this(d06Var);
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

    public d06(@NonNull Context context, LinearLayout linearLayout, FloatWebLayout floatWebLayout) {
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
        this.a = context;
        this.b = linearLayout;
        this.c = floatWebLayout;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_float_new_web_content_view, (ViewGroup) linearLayout, true);
        this.d = (TbWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092a49);
        this.e = (FrameLayout) inflate.findViewById(R.id.load_state_container);
        BrowserHelper.initCookie(context);
        v();
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.d != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.d, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.c06
    public void z1(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) && this.d != null) {
            if (z || this.j) {
                this.l = str;
                this.d.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tieba.xt5
    public boolean E() {
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

    @Override // com.baidu.tieba.c06
    public boolean goBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbWebView tbWebView = this.d;
            if (tbWebView != null && tbWebView.getController().a()) {
                this.d.getController().c();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c06
    public void onDestroy() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (tbWebView = this.d) != null) {
            tbWebView.onDestroy();
        }
    }

    @Override // com.baidu.tieba.c06
    public void onPause() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (tbWebView = this.d) == null) {
            return;
        }
        try {
            tbWebView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p(MissionEvent.MESSAGE_PAUSE);
        um6.a().d(this.d, CommonTbJsBridge.RE_HIDE, null);
    }

    public final void t() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (loadingView = this.g) != null) {
            loadingView.dettachView(this.e);
        }
    }

    public final void u() {
        wn5 wn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (wn5Var = this.f) != null) {
            wn5Var.dettachView(this.e);
        }
    }

    @Override // com.baidu.tieba.c06
    public void onResume() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (tbWebView = this.d) == null) {
            return;
        }
        try {
            tbWebView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p("onResume");
        um6.a().d(this.d, CommonTbJsBridge.RE_SHOW, null);
        if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.k) {
            um6.a().d(this.d, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
        }
        this.k = false;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e != null && this.d != null && !this.h && !TextUtils.isEmpty(this.l) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.h = true;
            this.j = true;
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            u();
            w();
            z1(this.l, true);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f == null) {
                this.f = new wn5(this.a, new a(this));
            }
            this.f.m(this.a.getString(R.string.url_not_found));
            this.f.f(this.a.getString(R.string.obfuscated_res_0x7f0f1220));
            this.f.h(R.drawable.new_pic_emotion_08);
            this.f.attachView(this.e, false);
            this.f.o();
        }
    }

    public void v() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (tbWebView = this.d) != null) {
            tbWebView.setHorizontalScrollBarEnabled(false);
            this.d.setScrollBarStyle(33554432);
            this.d.setWebViewClient(new b(this));
            this.d.setDownloadListener(new c(this, null));
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LoadingView loadingView = this.g;
            if (loadingView != null && loadingView.isViewAttached()) {
                return;
            }
            if (this.g == null) {
                LoadingView loadingView2 = new LoadingView(this.a);
                this.g = loadingView2;
                loadingView2.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.g.onChangeSkinType();
            }
            this.g.attachView(this.e, false);
        }
    }
}
