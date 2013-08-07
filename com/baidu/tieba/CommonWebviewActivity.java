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
import com.baidu.tieba.recommend.bf;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CommonWebviewActivity extends g implements com.baidu.tieba.view.d {
    private static boolean u = false;
    private static long v = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f817a = null;
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
    private m o = null;
    private boolean p = false;
    private boolean q = true;
    private TextView r = null;
    private TextView s = null;
    private boolean t = false;
    private String w = "1";
    private String x;

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_webview_activity);
        a(bundle);
        if (this.b == null || this.b.length() == 0) {
            com.baidu.tieba.util.am.a((Context) this, getResources().getString(R.string.url_is_null));
        } else {
            k();
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.f817a = intent.getStringExtra("tag_title");
        this.b = intent.getStringExtra("tag_url");
        this.c = intent.getBooleanExtra("tag_back", true);
        this.x = intent.getStringExtra("tag_http_method");
    }

    private void k() {
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
        this.j.setText(this.f817a);
        this.r = (TextView) this.n.findViewById(R.id.webview_fail);
        this.s = (TextView) this.n.findViewById(R.id.webview_crash_tip);
        this.m = (ProgressBar) findViewById(R.id.common_progress);
        this.k = new l(this);
        this.d.setOnClickListener(this.k);
        this.f.setOnClickListener(this.k);
        if (TiebaApplication.f().av() >= 5) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
        } else if (m()) {
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
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.e, i);
        com.baidu.tieba.util.ah.d(this.g, i);
        com.baidu.tieba.util.ah.f(this.j, i);
        com.baidu.tieba.util.ah.b(this.f, i);
        com.baidu.tieba.util.ah.a(this.d, i);
        if (this.l != null) {
            com.baidu.tieba.util.ah.a(this.l, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void b() {
        if (TiebaApplication.f().av() == 0 && !m()) {
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
        if (!this.t) {
            this.t = true;
            this.m.setVisibility(0);
            this.p = false;
            this.q = true;
            n();
            this.o = new m(this, null);
            this.o.setPriority(3);
            this.o.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
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
        if (!bf.a(this, str)) {
            com.baidu.tieba.util.am.d(this, String.valueOf(str) + "&_client_version=" + com.baidu.tieba.data.g.i());
        }
        return true;
    }

    private boolean m() {
        boolean z = false;
        if (this.l == null) {
            try {
                if (com.baidu.tieba.util.am.f(this) && TiebaApplication.f().av() >= 5) {
                    super.a(getString(R.string.web_view_corrupted));
                } else {
                    this.l = new BaseWebView(this);
                    com.baidu.tieba.util.ah.a(this.l, TiebaApplication.f().au());
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
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "CommonWebviewActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void n() {
        if (this.o != null) {
            this.o.cancel();
        }
    }
}
