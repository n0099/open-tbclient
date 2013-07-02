package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumTopicActivity extends com.baidu.tieba.g implements com.baidu.tieba.view.d {
    private com.baidu.tieba.recommend.j a;
    private String o;
    private String p;
    private ImageView b = null;
    private RelativeLayout c = null;
    private RelativeLayout d = null;
    private TextView e = null;
    private View.OnClickListener f = null;
    private BaseWebView g = null;
    private ProgressBar j = null;
    private LinearLayout k = null;
    private TextView l = null;
    private TextView m = null;
    private boolean n = false;
    private Handler q = new Handler();
    private Runnable r = new o(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_topic_activity);
        Intent intent = getIntent();
        if (bundle != null) {
            this.p = bundle.getString("forum_topic_title");
            this.o = bundle.getString("forum_topic_url");
        } else {
            this.p = intent.getStringExtra("forum_topic_title");
            this.o = intent.getStringExtra("forum_topic_url");
        }
        if (this.o == null) {
            finish();
            return;
        }
        m();
        b();
        d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_topic_title", this.p);
        bundle.putString("forum_topic_url", this.o);
    }

    private void d() {
        StringBuffer stringBuffer = new StringBuffer(this.o);
        if (this.o.indexOf("nohead") < 0) {
            stringBuffer.append("&nohead=1");
        }
        if (this.o.indexOf("_client_version") < 0) {
            try {
                stringBuffer.append("&_client_version=" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.o = stringBuffer.toString();
        this.q.postDelayed(this.r, 500L);
    }

    private void m() {
        this.c = (RelativeLayout) findViewById(R.id.parent);
        this.d = (RelativeLayout) findViewById(R.id.forum_topic_title);
        this.e = (TextView) findViewById(R.id.forum_topic_title_text);
        this.e.setText(this.p);
        this.b = (ImageView) findViewById(R.id.forum_topic_title_back);
        this.k = (LinearLayout) findViewById(R.id.forum_topic_webview_item);
        this.l = (TextView) this.k.findViewById(R.id.webview_fail);
        this.m = (TextView) this.k.findViewById(R.id.webview_crash_tip);
        this.j = (ProgressBar) findViewById(R.id.forum_topic_progress);
        this.f = new p(this);
        this.b.setOnClickListener(this.f);
        if (n()) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
        }
    }

    public void b() {
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.F());
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
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        String str3 = "";
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.F());
        if (b != null) {
            if (b.mBduss != null) {
                str3 = b.mBduss;
            }
            if (b.mPtoken != null) {
                str = str3;
                str2 = b.mPtoken;
                com.baidu.tieba.recommend.j jVar = new com.baidu.tieba.recommend.j(str, str2);
                if (this.a == null && (this.a == null || !this.a.equals(jVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = jVar;
                if (this.g == null && z) {
                    b();
                    this.q.postDelayed(this.r, 150L);
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        com.baidu.tieba.recommend.j jVar2 = new com.baidu.tieba.recommend.j(str, str2);
        if (this.a == null) {
        }
        z = false;
        this.a = jVar2;
        if (this.g == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.c, i);
        com.baidu.tieba.util.x.d(this.d, i);
        com.baidu.tieba.util.x.f(this.e, i);
        com.baidu.tieba.util.x.a(this.b, i);
        if (this.g != null) {
            com.baidu.tieba.util.x.a(this.g, i);
        }
    }

    public void c() {
        this.m.setVisibility(8);
        this.l.setVisibility(8);
        if (!this.n) {
            this.n = true;
            if (this.g != null && URLUtil.isNetworkUrl(this.o)) {
                this.j.setVisibility(0);
                this.g.loadUrl(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!com.baidu.tieba.recommend.i.a(this, str)) {
            if (str != null && str.contains("jump_tieba_native=1") && str.contains("jumptologin=1")) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                com.baidu.tieba.util.ab.d(this, str);
            }
        }
        return true;
    }

    private boolean n() {
        if (this.g == null) {
            try {
                this.g = new BaseWebView(this);
                com.baidu.tieba.util.x.a(this.g, TiebaApplication.f().at());
                this.g.setOnLoadUrlListener(this);
                this.g.setHorizontalScrollBarEnabled(false);
                this.g.setHorizontalScrollbarOverlay(false);
                this.g.setScrollBarStyle(33554432);
                this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.g.setWebChromeClient(new q(this));
                this.k.addView(this.g);
                return true;
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "", "ForumTopicActivity.refreshFrs error = " + e.getMessage());
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
    public void o() {
        this.n = false;
        this.j.setVisibility(8);
    }
}
