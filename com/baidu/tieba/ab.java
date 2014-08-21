package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class ab extends Dialog {
    private Context a;
    private VersionData b;
    private CombineDownload c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private String l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private TextView u;
    private ag v;
    private View.OnClickListener w;
    private View.OnClickListener x;

    public ab(Context context, int i) {
        super(context, i);
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = false;
        this.a = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.app_download_dialog);
        this.h = (LinearLayout) findViewById(u.app_info);
        this.i = (TextView) findViewById(u.app_version_and_size);
        this.j = (TextView) findViewById(u.app_description);
        this.o = (TextView) findViewById(u.fullsize_download_button);
        this.n = (TextView) findViewById(u.cancel_download_button);
        this.k = (TextView) findViewById(u.download_process);
        this.p = (TextView) findViewById(u.incremental_download_button);
        this.q = findViewById(u.incremental_download_layout);
        this.m = (TextView) findViewById(u.other_app_recommend);
        this.l = this.k.getText().toString();
        this.r = (LinearLayout) findViewById(u.cancel_dialog);
        this.t = (TextView) findViewById(u.sure_cancel);
        this.u = (TextView) findViewById(u.cancel_button);
        this.s = (TextView) findViewById(u.cancel_tip);
        this.t.setOnClickListener(this.w);
        this.u.setOnClickListener(this.x);
        String size = this.b.getSize();
        String newVersion = this.b.getNewVersion();
        String newVersionDesc = this.b.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.getString(x.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.e.c.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.i.setText(sb.toString());
        this.j.setText(newVersionDesc);
        if (this.b.forceUpdate()) {
            this.g = true;
            this.n.setText(this.a.getString(x.quit));
        } else {
            this.n.setText(this.a.getString(x.update_after));
        }
        if (this.c != null && this.c.showCombineDownload()) {
            this.m.setText(this.c.getAppName());
            if (!com.baidu.tieba.d.b.a(this.a, this.c.getAppProc()) && !TextUtils.isEmpty(this.c.getAppUrl())) {
                this.m.setVisibility(0);
                Drawable drawable = this.a.getResources().getDrawable(t.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.m.setCompoundDrawables(drawable, null, null, null);
                this.d = true;
            } else {
                this.m.setVisibility(8);
                this.d = false;
            }
        } else {
            this.m.setVisibility(8);
            this.d = false;
        }
        if (this.b == null || TextUtils.isEmpty(this.b.getPatch()) || this.b.getNewVersionCode() < 0) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
        }
        this.o.setOnClickListener(new ac(this));
        this.p.setOnClickListener(new ad(this));
        this.n.setOnClickListener(new ae(this));
        this.m.setOnClickListener(new af(this));
    }

    public void a(int i) {
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        this.k.setVisibility(0);
        this.k.setText(String.valueOf(this.l) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f) {
            this.v.c();
            this.h.setVisibility(8);
            if (this.g) {
                this.s.setText(getContext().getString(x.download_exit));
            }
            this.r.setVisibility(0);
            return;
        }
        this.v.b();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ag agVar) {
        this.b = versionData;
        this.c = combineDownload;
        this.v = agVar;
    }

    public void a() {
        this.r.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void b(int i) {
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            boolean z = i == 1;
            baseActivity.getLayoutMode().a(z);
            baseActivity.getLayoutMode().a(findViewById(u.app_download_dialog_layout));
            if (this.b == null || TextUtils.isEmpty(this.b.getPatch()) || this.b.getNewVersionCode() < 0) {
                this.o.setBackgroundResource(t.update_button);
                if (z) {
                    this.o.setTextColor(this.a.getResources().getColor(r.cp_cont_g_1));
                } else {
                    this.o.setTextColor(this.a.getResources().getColor(r.cp_cont_g));
                }
            } else if (z) {
                this.o.setBackgroundResource(t.cancel_button_1);
                this.o.setTextColor(this.a.getResources().getColor(r.cp_cont_b_1));
            } else {
                this.o.setBackgroundResource(t.cancel_button);
                this.o.setTextColor(this.a.getResources().getColor(r.cp_cont_b));
            }
        }
    }
}
