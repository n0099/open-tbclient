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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class FaceBuyWebViewActivity extends ProxyAdkBaseActivity<FaceBuyWebViewActivity> implements BaseWebView.d, BaseWebView.f, BaseWebView.e {
    public static final Pattern n = Pattern.compile("[?|&]order_id=(\\w+)&+");

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f14724e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f14725f;

    /* renamed from: g  reason: collision with root package name */
    public String f14726g;

    /* renamed from: h  reason: collision with root package name */
    public String f14727h;

    /* renamed from: i  reason: collision with root package name */
    public String f14728i;
    public int j;
    public d.a.m0.r.s.a k;
    public final Handler l = new Handler();
    public final Runnable m = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String guessUrl = URLUtil.guessUrl(FaceBuyWebViewActivity.this.f14726g);
            if (URLUtil.isNetworkUrl(guessUrl)) {
                FaceBuyWebViewActivity.this.f14724e.loadUrl(guessUrl);
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

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            FaceBuyWebViewActivity.this.closeActivity();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
    public void a(WebView webView, String str) {
        showProgressBar();
    }

    public void j() {
        try {
            d.a.m0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
            CookieSyncManager.createInstance(getPageContext().getContext());
            CookieManager.getInstance().setAcceptCookie(true);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k(Bundle bundle) {
        if (bundle != null) {
            this.f14726g = bundle.getString(WebViewActivityConfig.TAG_URL);
            this.f14727h = bundle.getString("tag_hook_url");
            this.f14728i = bundle.getString(WebViewActivityConfig.TAG_TITLE);
            this.j = bundle.getInt("tag_position");
        } else {
            this.f14726g = getIntent().getStringExtra(WebViewActivityConfig.TAG_URL);
            this.f14727h = getIntent().getStringExtra("tag_hook_url");
            this.f14728i = getIntent().getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.j = getIntent().getIntExtra("tag_position", -1);
        }
        this.f14725f.setTitleText(this.f14728i);
        this.l.postDelayed(this.m, 150L);
    }

    public final void l() {
        setContentView(R.layout.face_buy_webview_activity);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98);
        this.f14724e = (BaseWebView) findViewById(R.id.webview);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f14725f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        this.f14725f.setTitleText("");
        this.f14724e.setOnLoadUrlListener(this);
        this.f14724e.setOnPageFinishedListener(this);
        this.f14724e.setOnPageStartedListener(this);
        this.f14724e.setHorizontalScrollBarEnabled(false);
    }

    public final void m() {
        if (this.k == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
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
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        NavigationBar navigationBar = this.f14725f;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i2);
        }
        BaseWebView baseWebView = this.f14724e;
        if (baseWebView != null) {
            SkinManager.setBgColor(baseWebView, i2);
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            m();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
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
        bundle.putString(WebViewActivityConfig.TAG_URL, this.f14726g);
        bundle.putString("tag_hook_url", this.f14727h);
        bundle.putString(WebViewActivityConfig.TAG_TITLE, this.f14728i);
        bundle.putInt("tag_position", this.j);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null && !k.isEmpty(str) && !k.isEmpty(this.f14727h)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(this.f14727h.toLowerCase())) {
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
