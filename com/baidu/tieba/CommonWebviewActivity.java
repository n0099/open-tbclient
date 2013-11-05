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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CommonWebviewActivity extends j implements com.baidu.tieba.view.d {
    private static boolean u = false;
    private static long v = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f982a = null;
    private String b = null;
    private boolean c = true;
    private ImageView d = null;
    private RelativeLayout e = null;
    private ImageView f = null;
    private RelativeLayout g = null;
    private TextView j = null;
    private View.OnClickListener k = null;
    private BaseWebView l = null;
    private ProgressBar m = null;
    private LinearLayout n = null;
    private p o = null;
    private boolean p = false;
    private boolean q = true;
    private TextView r = null;
    private TextView s = null;
    private boolean t = false;
    private String w = SocialConstants.TRUE;
    private String x;

    @Override // com.baidu.tieba.j
    public boolean g() {
        return TiebaApplication.g().u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_webview_activity);
        a(bundle);
        if (this.b == null || this.b.length() == 0) {
            UtilHelper.a((Context) this, getResources().getString(R.string.url_is_null));
        } else {
            e();
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.f982a = intent.getStringExtra("tag_title");
        this.b = intent.getStringExtra("tag_url");
        this.c = intent.getBooleanExtra("tag_back", true);
        this.x = intent.getStringExtra("tag_http_method");
    }

    private void e() {
        this.e = (RelativeLayout) findViewById(R.id.parent);
        this.g = (RelativeLayout) findViewById(R.id.title);
        this.f = (ImageView) findViewById(R.id.refresh);
        this.j = (TextView) findViewById(R.id.title_text);
        this.n = (LinearLayout) findViewById(R.id.common_webview_item);
        this.d = (ImageView) findViewById(R.id.back);
        if (this.c) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        this.j.setText(this.f982a);
        this.r = (TextView) this.n.findViewById(R.id.webview_fail);
        this.s = (TextView) this.n.findViewById(R.id.webview_crash_tip);
        this.m = (ProgressBar) findViewById(R.id.common_progress);
        this.k = new o(this);
        this.d.setOnClickListener(this.k);
        this.f.setOnClickListener(this.k);
        if (TiebaApplication.g().at() >= 5) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
        } else if (n()) {
            this.s.setVisibility(8);
            b();
        } else {
            this.s.setVisibility(0);
        }
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
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.bb.a(this.e, i);
        com.baidu.tieba.util.bb.d(this.g, i);
        com.baidu.tieba.util.bb.f(this.j, i);
        com.baidu.tieba.util.bb.b(this.f, i);
        com.baidu.tieba.util.bb.a(this.d, i);
        if (this.l != null) {
            com.baidu.tieba.util.bb.a(this.l, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void b() {
        if (TiebaApplication.g().at() == 0 && !n()) {
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
        if (!this.t) {
            this.t = true;
            this.m.setVisibility(0);
            this.p = false;
            this.q = true;
            o();
            this.o = new p(this, null);
            this.o.setPriority(3);
            this.o.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.p) {
            if (!this.q) {
                a(getResources().getString(R.string.neterror));
            }
            this.t = false;
            this.m.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!com.baidu.tieba.recommend.ae.a(this, str)) {
            UtilHelper.d(this, str + "&_client_version=" + com.baidu.tieba.data.h.j());
        }
        return true;
    }

    private boolean n() {
        boolean z = false;
        if (this.l == null) {
            try {
                if (UtilHelper.f(this) && TiebaApplication.g().at() >= 5) {
                    super.a(getString(R.string.web_view_corrupted));
                } else {
                    this.l = new BaseWebView(this);
                    com.baidu.tieba.util.bb.a(this.l, TiebaApplication.g().as());
                    this.l.setOnLoadUrlListener(this);
                    this.l.setHorizontalScrollBarEnabled(false);
                    this.l.setHorizontalScrollbarOverlay(false);
                    this.l.setScrollBarStyle(33554432);
                    this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.n.addView(this.l);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                be.b(getClass().getName(), "", "CommonWebviewActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void o() {
        if (this.o != null) {
            this.o.cancel();
        }
    }
}
