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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.j;
import d.a.m0.z0.b0;
import d.a.n0.r0.o0;
import java.util.List;
/* loaded from: classes4.dex */
public class TabWebFragment extends BaseWebViewFragment implements o0 {

    /* renamed from: h  reason: collision with root package name */
    public String f16595h;

    /* renamed from: i  reason: collision with root package name */
    public String f16596i;
    public String j;
    public int k;
    public View l;
    public NestedScrollWebView m;
    public FrameLayout n;
    public d.a.n0.e3.l0.a o;
    public boolean q;
    public boolean r;
    public final View.OnClickListener u;
    public boolean p = true;
    public boolean s = false;
    public d.a.n0.e3.l0.c t = new a();

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.e3.l0.c {
        public a() {
        }

        @Override // d.a.n0.e3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (TabWebFragment.this.o != null) {
                return TabWebFragment.this.o.b(TabWebFragment.this.m, str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(TabWebFragment.this.f11980e)) {
                return;
            }
            TabWebFragment.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                TabWebFragment.this.u();
            } else {
                TabWebFragment.this.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TabWebFragment.this.q = false;
            TabWebFragment tabWebFragment = TabWebFragment.this;
            tabWebFragment.f11980e = str;
            if (tabWebFragment.m == null || TabWebFragment.this.n == null) {
                return;
            }
            webView.getProgress();
            if (TabWebFragment.this.r) {
                TabWebFragment.this.m.stopLoading();
                TabWebFragment.this.m.setVisibility(8);
                TabWebFragment.this.n.setVisibility(0);
                TabWebFragment tabWebFragment2 = TabWebFragment.this;
                tabWebFragment2.hideLoadingView(tabWebFragment2.n);
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                TabWebFragment tabWebFragment3 = TabWebFragment.this;
                tabWebFragment3.showNetRefreshView(tabWebFragment3.n, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, TabWebFragment.this.u);
                return;
            }
            TabWebFragment.this.p = false;
            TabWebFragment.this.m.setVisibility(0);
            TabWebFragment.this.n.setVisibility(8);
            TabWebFragment tabWebFragment4 = TabWebFragment.this;
            tabWebFragment4.hideLoadingView(tabWebFragment4.n);
            TabWebFragment tabWebFragment5 = TabWebFragment.this;
            tabWebFragment5.hideNetRefreshView(tabWebFragment5.n);
            String title = TabWebFragment.this.m.getTitle();
            if (TextUtils.isEmpty(title)) {
                return;
            }
            TabWebFragment.this.P0(title);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TabWebFragment.this.m == null || TabWebFragment.this.n == null) {
                return;
            }
            TabWebFragment.this.r = false;
            if (TabWebFragment.this.p) {
                TabWebFragment.this.q = true;
                TabWebFragment.this.n.setVisibility(0);
                TabWebFragment tabWebFragment = TabWebFragment.this;
                tabWebFragment.showLoadingView(tabWebFragment.n);
            }
            TabWebFragment.this.f11980e = str;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TabWebFragment.this.r = true;
            if (TabWebFragment.this.m == null || TabWebFragment.this.n == null) {
                return;
            }
            TabWebFragment.this.m.stopLoading();
            TabWebFragment.this.m.setVisibility(8);
            TabWebFragment.this.n.setVisibility(0);
            TabWebFragment tabWebFragment = TabWebFragment.this;
            tabWebFragment.hideLoadingView(tabWebFragment.n);
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            TabWebFragment tabWebFragment2 = TabWebFragment.this;
            tabWebFragment2.showNetRefreshView(tabWebFragment2.n, inst.getString(R.string.url_not_found), null, inst.getString(R.string.refresh), false, TabWebFragment.this.u);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str) || TabWebFragment.this.getPageContext() == null || TabWebFragment.this.m == null) {
                return false;
            }
            if (TabWebFragment.this.p) {
                TabWebFragment.this.p = false;
                return false;
            } else if (!TabWebFragment.this.h1(str) || TbadkCoreApplication.isLogin() || TabWebFragment.this.getPageContext() == null) {
                if (TabWebFragment.this.m != null && TabWebFragment.this.m.isShown()) {
                    if (!TabWebFragment.this.I0(str)) {
                        if (TabWebFragment.this.s) {
                            return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(TabWebFragment.this.getPageContext(), new String[]{str}) == 0;
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) TabWebFragment.this.getPageContext(), new String[]{str}, true);
                    } else {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(TabWebFragment.this.getPageContext(), new String[]{str});
                        return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                    }
                }
                return true;
            } else {
                ViewHelper.skipToLoginActivity(TabWebFragment.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements DownloadListener {
        public e() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                TabWebFragment.this.startActivity(intent);
            }
        }

        public /* synthetic */ e(TabWebFragment tabWebFragment, a aVar) {
            this();
        }
    }

    public TabWebFragment() {
        new b(2005016);
        this.u = new c();
    }

    @Override // d.a.n0.r0.o0
    public void H() {
    }

    @Override // d.a.n0.r0.o0
    public void I() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final d.a.n0.e3.l0.b g1() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.n0.e3.l0.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (d.a.n0.e3.l0.b) runTask.getData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.m0.k0.d getPageStayDurationItem() {
        return super.getPageStayDurationItem();
    }

    public final boolean h1(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    public void i1() {
        d.a.m0.l.a.f(getBaseFragmentActivity().getApplicationContext());
    }

    public final void initData() {
        String str = this.f11980e;
        if (str != null && str.contains("redirect=1")) {
            this.s = true;
        }
        k1(this.f11980e);
    }

    @RequiresApi(api = 11)
    public void j1() {
        NestedScrollWebView nestedScrollWebView = this.m;
        if (nestedScrollWebView != null) {
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
            this.m.setWebViewClient(new d());
            this.m.setDownloadListener(new e(this, null));
            d.a.n0.b1.j.i.a aVar = new d.a.n0.b1.j.i.a(getPageContext());
            aVar.a(this.t);
            this.m.setWebChromeClient(aVar);
            CompatibleUtile.getInstance().removeJavascriptInterface(this.m);
        }
    }

    public void k1(String str) {
        if (this.m != null) {
            CompatibleUtile.getInstance().loadUrl(this.m, str);
        }
    }

    public final void l1() {
        if (isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f16595h);
            statisticItem.param("obj_type", this.f16596i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        d.a.m0.s0.a.a(getPageContext(), this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.k = arguments.getInt("tab_type");
            this.f16595h = arguments.getString("tab_name");
            this.f16596i = arguments.getString(LowFlowsActivityConfig.TAB_CODE);
            this.j = arguments.getString("tab_url");
        } else if (bundle != null) {
            this.k = bundle.getInt("tab_type");
            this.f16595h = bundle.getString("tab_name");
            this.f16596i = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
            this.j = bundle.getString("tab_url");
        }
        this.f11980e = this.j;
        d.a.n0.e3.l0.a aVar = new d.a.n0.e3.l0.a();
        this.o = aVar;
        aVar.a(new XiubaTbJsBridge(getPageContext()));
        this.o.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
        this.o.a(g1());
        i1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.e3.l0.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.m != null) {
            l1();
            if (this.p) {
                initData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("tab_name", this.f16595h);
            bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16596i);
            bundle.putString("tab_url", this.j);
            bundle.putInt("tab_type", this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        u();
    }

    @Override // d.a.n0.r0.o0
    public void t() {
    }

    public final void u() {
        if (this.n == null || this.m == null || this.q || TextUtils.isEmpty(this.f11980e) || !j.z()) {
            return;
        }
        this.q = true;
        this.p = true;
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        hideNetRefreshView(this.n);
        showLoadingView(this.n);
        k1(this.f11980e);
    }

    @Override // d.a.n0.r0.o0
    public void v() {
    }

    @Override // d.a.n0.r0.o0
    public void z(b0 b0Var) {
    }
}
