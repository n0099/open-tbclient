package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class FaceBuyWebViewActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.g, com.baidu.tbadk.coreExtra.view.h, com.baidu.tbadk.coreExtra.view.i {
    private static final Pattern h = Pattern.compile("[?|&]order_id=(\\w+)&+");
    private BaseWebView a;
    private NavigationBar b;
    private String c;
    private String d;
    private String e;
    private int f;
    private AlertDialog g;
    private final Handler i = new Handler();
    private final Runnable j = new ad(this);

    public static void a(Activity activity, String str, String str2, String str3, int i, int i2) {
        Intent intent = new Intent(activity, FaceBuyWebViewActivity.class);
        intent.putExtra("tag_url", str);
        intent.putExtra("tag_hook_url", str2);
        intent.putExtra("tag_title", str3);
        intent.putExtra("tag_position", i);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a(bundle);
        a();
    }

    private void b() {
        setContentView(com.baidu.tieba.w.face_buy_webview_activity);
        this.a = (BaseWebView) findViewById(com.baidu.tieba.v.webview);
        this.b = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ae(this));
        this.b.a("");
        this.a.setOnLoadUrlListener(this);
        this.a.setOnPageFinishedListener(this);
        this.a.setOnPageStartedListener(this);
        this.a.setHorizontalScrollBarEnabled(false);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getString("tag_url");
            this.d = bundle.getString("tag_hook_url");
            this.e = bundle.getString("tag_title");
            this.f = bundle.getInt("tag_position");
        } else {
            this.c = getIntent().getStringExtra("tag_url");
            this.d = getIntent().getStringExtra("tag_hook_url");
            this.e = getIntent().getStringExtra("tag_title");
            this.f = getIntent().getIntExtra("tag_position", -1);
        }
        this.b.a(this.e);
        this.i.postDelayed(this.j, 150L);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tag_url", this.c);
        bundle.putString("tag_hook_url", this.d);
        bundle.putString("tag_title", this.e);
        bundle.putInt("tag_position", this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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
        this.i.removeCallbacks(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.c(i);
        }
        if (this.a != null) {
            com.baidu.tbadk.core.util.bc.a(this.a, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void a() {
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
    public void c() {
        if (this.g == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(com.baidu.tieba.y.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(com.baidu.tieba.y.quit_buy_confirm);
            builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new af(this));
            builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new ag(this));
            this.g = builder.create();
        }
        this.g.show();
    }

    @Override // com.baidu.tbadk.coreExtra.view.g
    public boolean a(WebView webView, String str) {
        if (str != null) {
            if (com.baidu.tbadk.core.util.be.c(str) || com.baidu.tbadk.core.util.be.c(this.d)) {
                return false;
            }
            if (str.toLowerCase().contains(this.d.toLowerCase())) {
                Matcher matcher = h.matcher(str);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        Intent intent = new Intent();
                        intent.putExtra("tag_order_id", group);
                        intent.putExtra("tag_position", this.f);
                        setResult(-1, intent);
                        closeActivity();
                        return true;
                    } catch (Exception e) {
                        BdLog.e(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
                    }
                }
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.coreExtra.view.h
    public void b(WebView webView, String str) {
        hideProgressBar();
    }

    @Override // com.baidu.tbadk.coreExtra.view.i
    public void c(WebView webView, String str) {
        showProgressBar();
    }
}
