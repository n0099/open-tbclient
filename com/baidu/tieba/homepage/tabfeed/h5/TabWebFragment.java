package com.baidu.tieba.homepage.tabfeed.h5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.q0.m.f;
import b.a.r0.x0.n0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.NestedScrollWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class TabWebFragment extends BaseWebViewFragment implements n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_NAME = "tab_name";
    public static final String TAB_TYPE = "tab_type";
    public static final String TAB_URL = "tab_url";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f49768g;

    /* renamed from: h  reason: collision with root package name */
    public String f49769h;

    /* renamed from: i  reason: collision with root package name */
    public String f49770i;
    public int j;
    public View k;
    public NestedScrollWebView l;
    public FrameLayout m;
    public b.a.r0.l3.n0.a n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public b.a.r0.l3.n0.c s;
    public final View.OnClickListener t;

    /* loaded from: classes9.dex */
    public class a implements b.a.r0.l3.n0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f49771a;

        public a(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49771a = tabWebFragment;
        }

        @Override // b.a.r0.l3.n0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f49771a.n != null) {
                    return this.f49771a.n.b(this.f49771a.l, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f49772a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TabWebFragment tabWebFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49772a = tabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.f49772a.mUrl)) {
                return;
            }
            this.f49772a.forceRefresh();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f49773e;

        public c(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49773e = tabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f49773e.forceRefresh();
                } else {
                    this.f49773e.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f49774a;

        public d(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49774a = tabWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f49774a.p = false;
                TabWebFragment tabWebFragment = this.f49774a;
                tabWebFragment.mUrl = str;
                if (tabWebFragment.l == null || this.f49774a.m == null) {
                    return;
                }
                webView.getProgress();
                if (this.f49774a.q) {
                    this.f49774a.l.stopLoading();
                    this.f49774a.l.setVisibility(8);
                    this.f49774a.m.setVisibility(0);
                    TabWebFragment tabWebFragment2 = this.f49774a;
                    tabWebFragment2.hideLoadingView(tabWebFragment2.m);
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    TabWebFragment tabWebFragment3 = this.f49774a;
                    tabWebFragment3.showNetRefreshView(tabWebFragment3.m, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, this.f49774a.t);
                    return;
                }
                this.f49774a.o = false;
                this.f49774a.l.setVisibility(0);
                this.f49774a.m.setVisibility(8);
                TabWebFragment tabWebFragment4 = this.f49774a;
                tabWebFragment4.hideLoadingView(tabWebFragment4.m);
                TabWebFragment tabWebFragment5 = this.f49774a;
                tabWebFragment5.hideNetRefreshView(tabWebFragment5.m);
                String title = this.f49774a.l.getTitle();
                if (TextUtils.isEmpty(title)) {
                    return;
                }
                this.f49774a.setUrlTitle(title);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f49774a.l == null || this.f49774a.m == null) {
                    return;
                }
                this.f49774a.q = false;
                if (this.f49774a.o) {
                    this.f49774a.p = true;
                    this.f49774a.m.setVisibility(0);
                    TabWebFragment tabWebFragment = this.f49774a;
                    tabWebFragment.showLoadingView(tabWebFragment.m);
                }
                this.f49774a.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f49774a.q = true;
                if (this.f49774a.l == null || this.f49774a.m == null) {
                    return;
                }
                this.f49774a.l.stopLoading();
                this.f49774a.l.setVisibility(8);
                this.f49774a.m.setVisibility(0);
                TabWebFragment tabWebFragment = this.f49774a;
                tabWebFragment.hideLoadingView(tabWebFragment.m);
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                TabWebFragment tabWebFragment2 = this.f49774a;
                tabWebFragment2.showNetRefreshView(tabWebFragment2.m, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, this.f49774a.t);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                f.a("TabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.f49774a.getPageContext() == null || this.f49774a.l == null) {
                    return false;
                }
                if (this.f49774a.o) {
                    this.f49774a.o = false;
                    return false;
                } else if (!this.f49774a.u(str) || TbadkCoreApplication.isLogin() || this.f49774a.getPageContext() == null) {
                    if (this.f49774a.l != null && this.f49774a.l.isShown()) {
                        if (!this.f49774a.isNeedNativeWebViewOpen(str)) {
                            if (this.f49774a.r) {
                                return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f49774a.getPageContext(), new String[]{str}) == 0;
                            }
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f49774a.getPageContext(), new String[]{str}, true);
                        } else {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f49774a.getPageContext(), new String[]{str});
                            return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                        }
                    }
                    return true;
                } else {
                    ViewHelper.skipToLoginActivity(this.f49774a.getPageContext().getPageActivity());
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f49775a;

        public e(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49775a = tabWebFragment;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.f49775a.startActivity(intent);
            }
        }

        public /* synthetic */ e(TabWebFragment tabWebFragment, a aVar) {
            this(tabWebFragment);
        }
    }

    public TabWebFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.r = false;
        this.s = new a(this);
        new b(this, 2005016);
        this.t = new c(this);
    }

    public void addJsPromptInterface(b.a.r0.l3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.n.a(bVar);
    }

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.l == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.l, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // b.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.m == null || this.l == null || this.p || TextUtils.isEmpty(this.mUrl) || !j.z()) {
            return;
        }
        this.p = true;
        this.o = true;
        this.m.setVisibility(0);
        this.l.setVisibility(8);
        hideNetRefreshView(this.m);
        showLoadingView(this.m);
        loadUrl(this.mUrl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public b.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.getPageStayDurationItem() : (b.a.q0.o0.d) invokeV.objValue;
    }

    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.m.a.f(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String str = this.mUrl;
            if (str != null && str.contains("redirect=1")) {
                this.r = true;
            }
            loadUrl(this.mUrl);
        }
    }

    @RequiresApi(api = 11)
    public void initWebView() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (nestedScrollWebView = this.l) == null) {
            return;
        }
        nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
        this.l.getSettings().setJavaScriptEnabled(true);
        this.l.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.l.getSettings().setAllowFileAccess(true);
        this.l.getSettings().setDatabaseEnabled(true);
        this.l.getSettings().setDomStorageEnabled(true);
        this.l.getSettings().setSupportZoom(true);
        this.l.getSettings().setBuiltInZoomControls(true);
        this.l.getSettings().setUseWideViewPort(true);
        this.l.getSettings().setLoadWithOverviewMode(true);
        this.l.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
        this.l.setHorizontalScrollBarEnabled(false);
        this.l.setHorizontalScrollbarOverlay(false);
        this.l.setInitialScale(100);
        this.l.setScrollBarStyle(33554432);
        this.l.setWebViewClient(new d(this));
        this.l.setDownloadListener(new e(this, null));
        b.a.r0.h1.j.i.a aVar = new b.a.r0.h1.j.i.a(getPageContext());
        aVar.a(this.s);
        this.l.setWebChromeClient(aVar);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.l);
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.l == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.l, str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            b.a.q0.w0.a.a(getPageContext(), this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.j = arguments.getInt("tab_type");
                this.f49768g = arguments.getString("tab_name");
                this.f49769h = arguments.getString("tab_code");
                this.f49770i = arguments.getString(TAB_URL);
            } else if (bundle != null) {
                this.j = bundle.getInt("tab_type");
                this.f49768g = bundle.getString("tab_name");
                this.f49769h = bundle.getString("tab_code");
                this.f49770i = bundle.getString(TAB_URL);
            }
            this.mUrl = this.f49770i;
            b.a.r0.l3.n0.a aVar = new b.a.r0.l3.n0.a();
            this.n = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.n.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.n.a(t());
            initCookie();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View view = this.k;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.k.getParent()).removeView(this.k);
            }
            if (this.k == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.tab_web_fragment, (ViewGroup) null);
                this.k = inflate;
                this.l = (NestedScrollWebView) inflate.findViewById(R.id.webview);
                this.m = (FrameLayout) this.k.findViewById(R.id.load_state_container);
                initWebView();
            }
            NestedScrollWebView nestedScrollWebView = this.l;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(0);
            }
            this.k.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            b.a.r0.l3.n0.a aVar = this.n;
            if (aVar != null) {
                aVar.f();
            }
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            NestedScrollWebView nestedScrollWebView = this.l;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(8);
            }
            super.onDestroyView();
        }
    }

    @Override // b.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // b.a.r0.x0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && this.l != null) {
                v();
                if (this.o) {
                    initData();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f49768g);
                bundle.putString("tab_code", this.f49769h);
                bundle.putString(TAB_URL, this.f49770i);
                bundle.putInt("tab_type", this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    @Override // b.a.r0.x0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            forceRefresh();
        }
    }

    public void removePromptInterface(b.a.r0.l3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) || bVar == null) {
            return;
        }
        this.n.g(bVar);
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
        }
    }

    public final b.a.r0.l3.n0.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, b.a.r0.l3.n0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (b.a.r0.l3.n0.b) runTask.getData();
        }
        return (b.a.r0.l3.n0.b) invokeV.objValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f49768g);
            statisticItem.param("obj_type", this.f49769h);
            TiebaStatic.log(statisticItem);
        }
    }
}
