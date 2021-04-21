package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class FaceBuyWebViewActivity extends ProxyAdkBaseActivity<FaceBuyWebViewActivity> implements BaseWebView.d, BaseWebView.f, BaseWebView.e {
    public static final Pattern n = Pattern.compile("[?|&]order_id=(\\w+)&+");

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f15307e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f15308f;

    /* renamed from: g  reason: collision with root package name */
    public String f15309g;

    /* renamed from: h  reason: collision with root package name */
    public String f15310h;
    public String i;
    public int j;
    public d.b.i0.r.s.a k;
    public final Handler l = new Handler();
    public final Runnable m = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String guessUrl = URLUtil.guessUrl(FaceBuyWebViewActivity.this.f15309g);
            if (URLUtil.isNetworkUrl(guessUrl)) {
                FaceBuyWebViewActivity.this.f15307e.loadUrl(guessUrl);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FaceBuyWebViewActivity.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            FaceBuyWebViewActivity.this.closeActivity();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
    public void a(WebView webView, String str) {
        showProgressBar();
    }

    public void j() {
        try {
            d.b.i0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
            CookieSyncManager.createInstance(getPageContext().getContext());
            CookieManager.getInstance().setAcceptCookie(true);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k(Bundle bundle) {
        if (bundle != null) {
            this.f15309g = bundle.getString(WebViewActivityConfig.TAG_URL);
            this.f15310h = bundle.getString("tag_hook_url");
            this.i = bundle.getString(WebViewActivityConfig.TAG_TITLE);
            this.j = bundle.getInt("tag_position");
        } else {
            this.f15309g = getIntent().getStringExtra(WebViewActivityConfig.TAG_URL);
            this.f15310h = getIntent().getStringExtra("tag_hook_url");
            this.i = getIntent().getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.j = getIntent().getIntExtra("tag_position", -1);
        }
        this.f15308f.setTitleText(this.i);
        this.l.postDelayed(this.m, 150L);
    }

    public final void l() {
        setContentView(R.layout.face_buy_webview_activity);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98);
        this.f15307e = (BaseWebView) findViewById(R.id.webview);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f15308f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f15308f.setTitleText("");
        this.f15307e.setOnLoadUrlListener(this);
        this.f15307e.setOnPageFinishedListener(this);
        this.f15307e.setOnPageStartedListener(this);
        this.f15307e.setHorizontalScrollBarEnabled(false);
    }

    public final void m() {
        if (this.k == null) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            this.k = aVar;
            aVar.setTitle(R.string.inform);
            this.k.setCancelable(false);
            this.k.setMessageId(R.string.quit_buy_confirm);
            this.k.setPositiveButton(R.string.alert_yes_button, new c());
            this.k.setNegativeButton(R.string.cancel, new d());
            this.k.create(getPageContext());
        }
        this.k.show();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        NavigationBar navigationBar = this.f15308f;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
        }
        BaseWebView baseWebView = this.f15307e;
        if (baseWebView != null) {
            SkinManager.setBgColor(baseWebView, i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        k(bundle);
        j();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.l.removeCallbacks(this.m);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            m();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
    public void onPageFinished(WebView webView, String str) {
        hideProgressBar();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(WebViewActivityConfig.TAG_URL, this.f15309g);
        bundle.putString("tag_hook_url", this.f15310h);
        bundle.putString(WebViewActivityConfig.TAG_TITLE, this.i);
        bundle.putInt("tag_position", this.j);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null && !k.isEmpty(str) && !k.isEmpty(this.f15310h)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(this.f15310h.toLowerCase())) {
                Matcher matcher = n.matcher(str);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        Intent intent = new Intent();
                        intent.putExtra("tag_order_id", group);
                        intent.putExtra("tag_position", this.j);
                        setResult(-1, intent);
                        closeActivity();
                        return true;
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                }
            } else if (lowerCase.startsWith("tel:")) {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(lowerCase)));
                return true;
            }
        }
        return false;
    }
}
