package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumTopicActivity extends com.baidu.tieba.j implements com.baidu.tieba.view.d {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.recommend.ad f1392a;
    private String m;
    private String n;
    private ImageView b = null;
    private RelativeLayout c = null;
    private RelativeLayout d = null;
    private TextView e = null;
    private View.OnClickListener f = null;
    private BaseWebView g = null;
    private ProgressBar h = null;
    private LinearLayout i = null;
    private TextView j = null;
    private TextView k = null;
    private boolean l = false;
    private Handler o = new Handler();
    private Runnable p = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_topic_activity);
        Intent intent = getIntent();
        if (bundle != null) {
            this.n = bundle.getString("forum_topic_title");
            this.m = bundle.getString("forum_topic_url");
        } else {
            this.n = intent.getStringExtra("forum_topic_title");
            this.m = intent.getStringExtra("forum_topic_url");
        }
        if (this.m == null) {
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
        bundle.putString("forum_topic_title", this.n);
        bundle.putString("forum_topic_url", this.m);
    }

    private void c() {
        StringBuffer stringBuffer = new StringBuffer(this.m);
        if (this.m.indexOf("nohead") < 0) {
            stringBuffer.append("&nohead=1");
        }
        if (this.m.indexOf("_client_version") < 0) {
            try {
                stringBuffer.append("&_client_version=" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.m = stringBuffer.toString();
        this.o.postDelayed(this.p, 500L);
    }

    private void d() {
        this.c = (RelativeLayout) findViewById(R.id.parent);
        this.d = (RelativeLayout) findViewById(R.id.forum_topic_title);
        this.e = (TextView) findViewById(R.id.forum_topic_title_text);
        this.e.setText(this.n);
        this.b = (ImageView) findViewById(R.id.forum_topic_title_back);
        this.i = (LinearLayout) findViewById(R.id.forum_topic_webview_item);
        this.j = (TextView) this.i.findViewById(R.id.webview_fail);
        this.k = (TextView) this.i.findViewById(R.id.webview_crash_tip);
        this.h = (ProgressBar) findViewById(R.id.forum_topic_progress);
        this.f = new w(this);
        this.b.setOnClickListener(this.f);
        if (e()) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public void a() {
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.D());
        if (b != null) {
            CookieSyncManager.createInstance(this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + b.mBduss + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + b.mPtoken + "; domain=.baidu.com;");
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
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.D());
        if (b != null) {
            if (b.mBduss != null) {
                str3 = b.mBduss;
            }
            if (b.mPtoken != null) {
                str = str3;
                str2 = b.mPtoken;
                com.baidu.tieba.recommend.ad adVar = new com.baidu.tieba.recommend.ad(str, str2);
                if (this.f1392a == null && (this.f1392a == null || !this.f1392a.equals(adVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.f1392a = adVar;
                if (this.g == null && z) {
                    a();
                    this.o.postDelayed(this.p, 150L);
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        com.baidu.tieba.recommend.ad adVar2 = new com.baidu.tieba.recommend.ad(str, str2);
        if (this.f1392a == null) {
        }
        z = false;
        this.f1392a = adVar2;
        if (this.g == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bd.a(this.c, i);
        com.baidu.tieba.util.bd.d(this.d, i);
        com.baidu.tieba.util.bd.e(this.e, i);
        com.baidu.tieba.util.bd.a(this.b, i);
        if (this.g != null) {
            com.baidu.tieba.util.bd.a(this.g, i);
        }
    }

    public void b() {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        if (!this.l) {
            this.l = true;
            if (this.g != null && URLUtil.isNetworkUrl(this.m)) {
                this.h.setVisibility(0);
                this.g.loadUrl(this.m);
            }
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!com.baidu.tieba.recommend.ac.a(this, str)) {
            if (str != null && str.contains("jump_tieba_native=1") && str.contains("jumptologin=1")) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else if (!TextUtils.isEmpty(str)) {
                UtilHelper.d(this, str);
            }
        }
        return true;
    }

    private boolean e() {
        if (this.g == null) {
            try {
                this.g = new BaseWebView(this);
                com.baidu.tieba.util.bd.a(this.g, TiebaApplication.g().ap());
                this.g.setOnLoadUrlListener(this);
                this.g.setHorizontalScrollBarEnabled(false);
                this.g.setHorizontalScrollbarOverlay(false);
                this.g.setScrollBarStyle(33554432);
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.g.setWebChromeClient(new x(this));
                this.i.addView(this.g);
                return true;
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "ForumTopicActivity.refreshFrs error = " + e.getMessage());
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
        this.l = false;
        this.h.setVisibility(8);
    }
}
