package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class FaceBuyWebViewActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.f, com.baidu.tbadk.coreExtra.view.g, com.baidu.tbadk.coreExtra.view.h {
    private static final Pattern asY = Pattern.compile("[?|&]order_id=(\\w+)&+");
    private int Uy;
    private NavigationBar asV;
    private String asW;
    private AlertDialog asX;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new aa(this);
    private String mTitle;
    private String mUrl;
    private BaseWebView mWebView;

    public static void a(Activity activity, String str, String str2, String str3, int i, int i2) {
        Intent intent = new Intent(activity, FaceBuyWebViewActivity.class);
        intent.putExtra(TbWebViewActivityConfig.TAG_URL, str);
        intent.putExtra("tag_hook_url", str2);
        intent.putExtra(TbWebViewActivityConfig.TAG_TITLE, str3);
        intent.putExtra("tag_position", i);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        d(bundle);
        initCookie();
    }

    private void initUI() {
        setContentView(ca.face_buy_webview_activity);
        this.mWebView = (BaseWebView) findViewById(bz.webview);
        this.asV = (NavigationBar) findViewById(bz.view_navigation_bar);
        this.asV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        this.asV.setTitleText("");
        this.mWebView.setOnLoadUrlListener(this);
        this.mWebView.setOnPageFinishedListener(this);
        this.mWebView.setOnPageStartedListener(this);
        this.mWebView.setHorizontalScrollBarEnabled(false);
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(TbWebViewActivityConfig.TAG_URL);
            this.asW = bundle.getString("tag_hook_url");
            this.mTitle = bundle.getString(TbWebViewActivityConfig.TAG_TITLE);
            this.Uy = bundle.getInt("tag_position");
        } else {
            this.mUrl = getIntent().getStringExtra(TbWebViewActivityConfig.TAG_URL);
            this.asW = getIntent().getStringExtra("tag_hook_url");
            this.mTitle = getIntent().getStringExtra(TbWebViewActivityConfig.TAG_TITLE);
            this.Uy = getIntent().getIntExtra("tag_position", -1);
        }
        this.asV.setTitleText(this.mTitle);
        this.mHandler.postDelayed(this.mRunnable, 150L);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(TbWebViewActivityConfig.TAG_URL, this.mUrl);
        bundle.putString("tag_hook_url", this.asW);
        bundle.putString(TbWebViewActivityConfig.TAG_TITLE, this.mTitle);
        bundle.putInt("tag_position", this.Uy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.asV != null) {
            this.asV.onChangeSkinType(i);
        }
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.aw.d(this.mWebView, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            CR();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void initCookie() {
        try {
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + parseBDUSS.mBduss + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + parseBDUSS.mPtoken + "; domain=.baidu.com;");
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR() {
        if (this.asX == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(cb.alert_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(cb.quit_buy_confirm);
            builder.setPositiveButton(cb.alert_yes_button, new ac(this));
            builder.setNegativeButton(cb.alert_no_button, new ad(this));
            this.asX = builder.create();
        }
        com.baidu.adp.lib.g.j.a(this.asX, this);
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            if (com.baidu.tbadk.core.util.ay.aA(str) || com.baidu.tbadk.core.util.ay.aA(this.asW)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(this.asW.toLowerCase())) {
                Matcher matcher = asY.matcher(str);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        Intent intent = new Intent();
                        intent.putExtra("tag_order_id", group);
                        intent.putExtra("tag_position", this.Uy);
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

    @Override // com.baidu.tbadk.coreExtra.view.g
    public void onPageFinished(WebView webView, String str) {
        hideProgressBar();
    }

    @Override // com.baidu.tbadk.coreExtra.view.h
    public void a(WebView webView, String str) {
        showProgressBar();
    }
}
