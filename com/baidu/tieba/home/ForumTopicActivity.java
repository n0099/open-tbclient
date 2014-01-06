package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumTopicActivity extends com.baidu.tieba.j implements com.baidu.tieba.view.h {
    private com.baidu.tieba.recommend.ac a;
    private NavigationBar b;
    private String j;
    private String k;
    private RelativeLayout c = null;
    private BaseWebView d = null;
    private ProgressBar e = null;
    private LinearLayout f = null;
    private TextView g = null;
    private TextView h = null;
    private boolean i = false;
    private Handler l = new Handler();
    private Runnable m = new r(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_topic_activity);
        Intent intent = getIntent();
        if (bundle != null) {
            this.k = bundle.getString("forum_topic_title");
            this.j = bundle.getString("forum_topic_url");
        } else {
            this.k = intent.getStringExtra("forum_topic_title");
            this.j = intent.getStringExtra("forum_topic_url");
        }
        if (this.j == null) {
            finish();
            return;
        }
        d();
        a();
        c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_topic_title", this.k);
        bundle.putString("forum_topic_url", this.j);
    }

    private void c() {
        StringBuffer stringBuffer = new StringBuffer(this.j);
        if (this.j.indexOf("nohead") < 0) {
            stringBuffer.append("&nohead=1");
        }
        if (this.j.indexOf("_client_version") < 0) {
            try {
                stringBuffer.append("&_client_version=" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.j = stringBuffer.toString();
        this.l.postDelayed(this.m, 500L);
    }

    private void d() {
        this.c = (RelativeLayout) findViewById(R.id.parent);
        this.b = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        this.b.a(this.k);
        this.f = (LinearLayout) findViewById(R.id.forum_topic_webview_item);
        this.g = (TextView) this.f.findViewById(R.id.webview_fail);
        this.h = (TextView) this.f.findViewById(R.id.webview_crash_tip);
        this.e = (ProgressBar) findViewById(R.id.forum_topic_progress);
        if (e()) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
        }
    }

    public void a() {
        Token a = com.baidu.tieba.account.a.a(TiebaApplication.E());
        if (a != null) {
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + a.mBduss + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + a.mPtoken + "; domain=.baidu.com;");
            CookieSyncManager.getInstance().sync();
            return;
        }
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        String str3 = "";
        Token a = com.baidu.tieba.account.a.a(TiebaApplication.E());
        if (a != null) {
            if (a.mBduss != null) {
                str3 = a.mBduss;
            }
            if (a.mPtoken != null) {
                str = str3;
                str2 = a.mPtoken;
                com.baidu.tieba.recommend.ac acVar = new com.baidu.tieba.recommend.ac(str, str2);
                if (this.a == null && (this.a == null || !this.a.equals(acVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = acVar;
                if (this.d == null && z) {
                    a();
                    this.l.postDelayed(this.m, 150L);
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        com.baidu.tieba.recommend.ac acVar2 = new com.baidu.tieba.recommend.ac(str, str2);
        if (this.a == null) {
        }
        z = false;
        this.a = acVar2;
        if (this.d == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bl.a(this.c, i);
        this.b.c(i);
        if (this.d != null) {
            com.baidu.tieba.util.bl.a(this.d, i);
        }
    }

    public void b() {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        if (!this.i) {
            this.i = true;
            if (this.d != null && URLUtil.isNetworkUrl(this.j)) {
                this.e.setVisibility(0);
                this.d.loadUrl(this.j);
            }
        }
    }

    @Override // com.baidu.tieba.view.h
    public boolean a(WebView webView, String str) {
        if (!com.baidu.tieba.recommend.ab.a(this, str)) {
            if (str != null && str.contains("jump_tieba_native=1") && str.contains("jumptologin=1")) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else if (!TextUtils.isEmpty(str)) {
                this.d.loadUrl(str);
            }
        }
        return true;
    }

    private boolean e() {
        if (this.d == null) {
            try {
                this.d = new BaseWebView(this);
                com.baidu.tieba.util.bl.a(this.d, TiebaApplication.g().an());
                this.d.setOnLoadUrlListener(this);
                this.d.setHorizontalScrollBarEnabled(false);
                this.d.setHorizontalScrollbarOverlay(false);
                this.d.setScrollBarStyle(33554432);
                this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.d.setWebChromeClient(new t(this));
                this.f.addView(this.d);
                return true;
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "", "ForumTopicActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, ForumTopicActivity.class);
        intent.putExtra("forum_topic_title", str);
        intent.putExtra("forum_topic_url", str2);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i = false;
        this.e.setVisibility(8);
    }
}
