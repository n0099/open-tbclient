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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
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
import d.a.c.e.p.j;
import d.a.r0.z0.b0;
import d.a.s0.u0.n0;
import java.util.List;
/* loaded from: classes5.dex */
public class TabWebFragment extends BaseWebViewFragment implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f16813h;

    /* renamed from: i  reason: collision with root package name */
    public String f16814i;
    public String j;
    public int k;
    public View l;
    public NestedScrollWebView m;
    public FrameLayout n;
    public d.a.s0.h3.l0.a o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public d.a.s0.h3.l0.c t;
    public final View.OnClickListener u;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f16815a;

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
            this.f16815a = tabWebFragment;
        }

        @Override // d.a.s0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f16815a.o != null) {
                    return this.f16815a.o.b(this.f16815a.m, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f16816a;

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
            this.f16816a = tabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.f16816a.f12115e)) {
                return;
            }
            this.f16816a.s();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f16817e;

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
            this.f16817e = tabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f16817e.s();
                } else {
                    this.f16817e.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f16818a;

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
            this.f16818a = tabWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f16818a.q = false;
                TabWebFragment tabWebFragment = this.f16818a;
                tabWebFragment.f12115e = str;
                if (tabWebFragment.m == null || this.f16818a.n == null) {
                    return;
                }
                webView.getProgress();
                if (this.f16818a.r) {
                    this.f16818a.m.stopLoading();
                    this.f16818a.m.setVisibility(8);
                    this.f16818a.n.setVisibility(0);
                    TabWebFragment tabWebFragment2 = this.f16818a;
                    tabWebFragment2.hideLoadingView(tabWebFragment2.n);
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    TabWebFragment tabWebFragment3 = this.f16818a;
                    tabWebFragment3.showNetRefreshView(tabWebFragment3.n, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, this.f16818a.u);
                    return;
                }
                this.f16818a.p = false;
                this.f16818a.m.setVisibility(0);
                this.f16818a.n.setVisibility(8);
                TabWebFragment tabWebFragment4 = this.f16818a;
                tabWebFragment4.hideLoadingView(tabWebFragment4.n);
                TabWebFragment tabWebFragment5 = this.f16818a;
                tabWebFragment5.hideNetRefreshView(tabWebFragment5.n);
                String title = this.f16818a.m.getTitle();
                if (TextUtils.isEmpty(title)) {
                    return;
                }
                this.f16818a.P0(title);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f16818a.m == null || this.f16818a.n == null) {
                    return;
                }
                this.f16818a.r = false;
                if (this.f16818a.p) {
                    this.f16818a.q = true;
                    this.f16818a.n.setVisibility(0);
                    TabWebFragment tabWebFragment = this.f16818a;
                    tabWebFragment.showLoadingView(tabWebFragment.n);
                }
                this.f16818a.f12115e = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f16818a.r = true;
                if (this.f16818a.m == null || this.f16818a.n == null) {
                    return;
                }
                this.f16818a.m.stopLoading();
                this.f16818a.m.setVisibility(8);
                this.f16818a.n.setVisibility(0);
                TabWebFragment tabWebFragment = this.f16818a;
                tabWebFragment.hideLoadingView(tabWebFragment.n);
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                TabWebFragment tabWebFragment2 = this.f16818a;
                tabWebFragment2.showNetRefreshView(tabWebFragment2.n, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, this.f16818a.u);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.f16818a.getPageContext() == null || this.f16818a.m == null) {
                    return false;
                }
                if (this.f16818a.p) {
                    this.f16818a.p = false;
                    return false;
                } else if (!this.f16818a.h1(str) || TbadkCoreApplication.isLogin() || this.f16818a.getPageContext() == null) {
                    if (this.f16818a.m != null && this.f16818a.m.isShown()) {
                        if (!this.f16818a.I0(str)) {
                            if (this.f16818a.s) {
                                return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f16818a.getPageContext(), new String[]{str}) == 0;
                            }
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f16818a.getPageContext(), new String[]{str}, true);
                        } else {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f16818a.getPageContext(), new String[]{str});
                            return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                        }
                    }
                    return true;
                } else {
                    ViewHelper.skipToLoginActivity(this.f16818a.getPageContext().getPageActivity());
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TabWebFragment f16819a;

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
            this.f16819a = tabWebFragment;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.f16819a.startActivity(intent);
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
        this.p = true;
        this.s = false;
        this.t = new a(this);
        new b(this, 2005016);
        this.u = new c(this);
    }

    @Override // d.a.s0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final d.a.s0.h3.l0.b g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.s0.h3.l0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (d.a.s0.h3.l0.b) runTask.getData();
        }
        return (d.a.s0.h3.l0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.r0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.getPageStayDurationItem() : (d.a.r0.k0.d) invokeV.objValue;
    }

    public final boolean h1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.r0.l.a.f(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String str = this.f12115e;
            if (str != null && str.contains("redirect=1")) {
                this.s = true;
            }
            k1(this.f12115e);
        }
    }

    @RequiresApi(api = 11)
    public void j1() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (nestedScrollWebView = this.m) == null) {
            return;
        }
        nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
        this.m.getSettings().setJavaScriptEnabled(true);
        this.m.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.m.getSettings().setAllowFileAccess(true);
        this.m.getSettings().setDatabaseEnabled(true);
        this.m.getSettings().setDomStorageEnabled(true);
        this.m.getSettings().setSupportZoom(true);
        this.m.getSettings().setBuiltInZoomControls(true);
        this.m.getSettings().setUseWideViewPort(true);
        this.m.getSettings().setLoadWithOverviewMode(true);
        this.m.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
        this.m.setHorizontalScrollBarEnabled(false);
        this.m.setHorizontalScrollbarOverlay(false);
        this.m.setInitialScale(100);
        this.m.setScrollBarStyle(33554432);
        this.m.setWebViewClient(new d(this));
        this.m.setDownloadListener(new e(this, null));
        d.a.s0.e1.j.i.a aVar = new d.a.s0.e1.j.i.a(getPageContext());
        aVar.a(this.t);
        this.m.setWebChromeClient(aVar);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.m);
    }

    public void k1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.m == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.m, str);
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f16813h);
            statisticItem.param("obj_type", this.f16814i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            d.a.r0.s0.a.a(getPageContext(), this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.k = arguments.getInt("tab_type");
                this.f16813h = arguments.getString("tab_name");
                this.f16814i = arguments.getString(LowFlowsActivityConfig.TAB_CODE);
                this.j = arguments.getString("tab_url");
            } else if (bundle != null) {
                this.k = bundle.getInt("tab_type");
                this.f16813h = bundle.getString("tab_name");
                this.f16814i = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
                this.j = bundle.getString("tab_url");
            }
            this.f12115e = this.j;
            d.a.s0.h3.l0.a aVar = new d.a.s0.h3.l0.a();
            this.o = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.o.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.o.a(g1());
            i1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            View view = this.l;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.l.getParent()).removeView(this.l);
            }
            if (this.l == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.tab_web_fragment, (ViewGroup) null);
                this.l = inflate;
                this.m = (NestedScrollWebView) inflate.findViewById(R.id.webview);
                this.n = (FrameLayout) this.l.findViewById(R.id.load_state_container);
                j1();
            }
            this.l.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            d.a.s0.h3.l0.a aVar = this.o;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && this.m != null) {
                l1();
                if (this.p) {
                    initData();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f16813h);
                bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16814i);
                bundle.putString("tab_url", this.j);
                bundle.putInt("tab_type", this.k);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            s();
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.n == null || this.m == null || this.q || TextUtils.isEmpty(this.f12115e) || !j.z()) {
            return;
        }
        this.q = true;
        this.p = true;
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        hideNetRefreshView(this.n);
        showLoadingView(this.n);
        k1(this.f12115e);
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, b0Var) == null) {
        }
    }
}
