package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.recommend.WebviewHelper;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CommonWebviewActivity extends j implements com.baidu.tieba.view.d {
    private static boolean q = false;
    private static long r = 0;
    private String t;
    private NavigationBar u;
    private String a = null;
    private String b = null;
    private boolean c = true;
    private ImageView d = null;
    private RelativeLayout e = null;
    private View f = null;
    private TextView g = null;
    private BaseWebView h = null;
    private ProgressBar i = null;
    private LinearLayout j = null;
    private r k = null;
    private boolean l = false;
    private boolean m = true;
    private TextView n = null;
    private TextView o = null;
    private boolean p = false;
    private String s = SocialConstants.TRUE;
    private View.OnClickListener v = new o(this);
    private View.OnClickListener w = new p(this);
    private View.OnClickListener x = new q(this);

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.h().u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_webview_activity);
        a(bundle);
        if (this.b == null || this.b.length() == 0) {
            com.baidu.adp.lib.g.g.a((Context) this, getResources().getString(R.string.url_is_null));
        } else {
            d();
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.a = intent.getStringExtra("tag_title");
        this.b = intent.getStringExtra("tag_url");
        this.c = intent.getBooleanExtra("tag_back", true);
        this.t = intent.getStringExtra("tag_http_method");
    }

    private void d() {
        this.e = (RelativeLayout) findViewById(R.id.parent);
        this.u = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.g = this.u.a(this.a);
        this.d = this.u.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.w);
        this.f = this.u.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_refresh, (View.OnClickListener) null);
        this.f.setOnClickListener(this.x);
        this.j = (LinearLayout) findViewById(R.id.common_webview_item);
        if (this.c) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(4);
        }
        this.n = (TextView) this.j.findViewById(R.id.webview_fail);
        this.o = (TextView) this.j.findViewById(R.id.webview_crash_tip);
        this.i = (ProgressBar) findViewById(R.id.common_progress);
        if (TiebaApplication.h().am() >= 5) {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
        } else if (f()) {
            this.o.setVisibility(8);
            a();
        } else {
            this.o.setVisibility(0);
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, CommonWebviewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_back", z);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, boolean z, String str3) {
        Intent intent = new Intent(context, CommonWebviewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_back", z);
        intent.putExtra("tag_http_method", str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bs.a(this.e, i);
        if (this.h != null) {
            bs.a(this.h, i);
            a();
        }
        if (this.u != null) {
            this.u.c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void a() {
        if (TiebaApplication.h().am() == 0 && !f()) {
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
        if (!this.p) {
            this.p = true;
            this.i.setVisibility(0);
            this.l = false;
            this.m = true;
            g();
            this.k = new r(this, null);
            this.k.setPriority(3);
            this.k.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.l) {
            if (!this.m) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.p = false;
            this.i.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!WebviewHelper.commonJumpHelper(this, str)) {
            UtilHelper.d(this, str + "&_client_version=" + com.baidu.tieba.data.h.j());
        }
        return true;
    }

    private boolean f() {
        boolean z = false;
        if (this.h == null) {
            try {
                if (UtilHelper.d(this) && TiebaApplication.h().am() >= 5) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.h = new BaseWebView(this);
                    bs.a(this.h, TiebaApplication.h().al());
                    this.h.setOnLoadUrlListener(this);
                    this.h.setHorizontalScrollBarEnabled(false);
                    this.h.setHorizontalScrollbarOverlay(false);
                    this.h.setScrollBarStyle(33554432);
                    this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.j.addView(this.h);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "", "CommonWebviewActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void g() {
        if (this.k != null) {
            this.k.cancel();
        }
    }
}
