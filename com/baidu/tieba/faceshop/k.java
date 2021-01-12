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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class k extends ProxyAdkBaseActivity<k> implements BaseWebView.b, BaseWebView.c, BaseWebView.d {
    private static final Pattern iPe = Pattern.compile("[?|&]order_id=(\\w+)&+");
    private NavigationBar iPb;
    private String iPc;
    private com.baidu.tbadk.core.dialog.a iPd;
    private int mPosition;
    private String mTitle;
    private String mUrl;
    private BaseWebView mWebView;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.faceshop.k.1
        @Override // java.lang.Runnable
        public void run() {
            String guessUrl = URLUtil.guessUrl(k.this.mUrl);
            if (URLUtil.isNetworkUrl(guessUrl)) {
                k.this.mWebView.loadUrl(guessUrl);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData(bundle);
        initCookie();
    }

    private void initUI() {
        setContentView(R.layout.face_buy_webview_activity);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds98);
        this.mWebView = (BaseWebView) findViewById(R.id.webview);
        this.iPb = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iPb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.cxx();
            }
        });
        this.iPb.setTitleText("");
        this.mWebView.setOnLoadUrlListener(this);
        this.mWebView.setOnPageFinishedListener(this);
        this.mWebView.setOnPageStartedListener(this);
        this.mWebView.setHorizontalScrollBarEnabled(false);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("tag_url");
            this.iPc = bundle.getString("tag_hook_url");
            this.mTitle = bundle.getString("tag_title");
            this.mPosition = bundle.getInt("tag_position");
        } else {
            this.mUrl = getIntent().getStringExtra("tag_url");
            this.iPc = getIntent().getStringExtra("tag_hook_url");
            this.mTitle = getIntent().getStringExtra("tag_title");
            this.mPosition = getIntent().getIntExtra("tag_position", -1);
        }
        this.iPb.setTitleText(this.mTitle);
        this.mHandler.postDelayed(this.mRunnable, 150L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tag_url", this.mUrl);
        bundle.putString("tag_hook_url", this.iPc);
        bundle.putString("tag_title", this.mTitle);
        bundle.putInt("tag_position", this.mPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPb != null) {
            this.iPb.onChangeSkinType(getPageContext(), i);
        }
        if (this.mWebView != null) {
            ao.setBgColor(this.mWebView, i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cxx();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void initCookie() {
        try {
            com.baidu.tbadk.core.a.a.bkC().zq(TbadkApplication.getCurrentBduss());
            CookieSyncManager.createInstance(getPageContext().getContext());
            CookieManager.getInstance().setAcceptCookie(true);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        if (this.iPd == null) {
            this.iPd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iPd.nt(R.string.inform);
            this.iPd.jD(false);
            this.iPd.nu(R.string.quit_buy_confirm);
            this.iPd.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.faceshop.k.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    k.this.closeActivity();
                }
            });
            this.iPd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.faceshop.k.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iPd.b(getPageContext());
        }
        this.iPd.bqe();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            if (at.isEmpty(str) || at.isEmpty(this.iPc)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(this.iPc.toLowerCase())) {
                Matcher matcher = iPe.matcher(str);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        Intent intent = new Intent();
                        intent.putExtra("tag_order_id", group);
                        intent.putExtra("tag_position", this.mPosition);
                        setResult(-1, intent);
                        closeActivity();
                        return true;
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
            } else if (lowerCase.startsWith("tel:")) {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(lowerCase)));
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        hideProgressBar();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public void onPageStarted(WebView webView, String str) {
        showProgressBar();
    }
}
