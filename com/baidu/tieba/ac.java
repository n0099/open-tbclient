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
public class ac extends Dialog {
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
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ah u;
    private View.OnClickListener v;
    private View.OnClickListener w;

    public ac(Context context, int i) {
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
        setContentView(w.app_download_dialog);
        this.h = (LinearLayout) findViewById(v.app_info);
        this.i = (TextView) findViewById(v.app_version_and_size);
        this.j = (TextView) findViewById(v.app_description);
        this.o = (TextView) findViewById(v.fullsize_download_button);
        this.n = (TextView) findViewById(v.cancel_download_button);
        this.k = (TextView) findViewById(v.download_process);
        this.p = (TextView) findViewById(v.incremental_download_button);
        this.m = (TextView) findViewById(v.other_app_recommend);
        this.l = this.k.getText().toString();
        this.q = (LinearLayout) findViewById(v.cancel_dialog);
        this.s = (TextView) findViewById(v.sure_cancel);
        this.t = (TextView) findViewById(v.cancel_button);
        this.r = (TextView) findViewById(v.cancel_tip);
        this.s.setOnClickListener(this.v);
        this.t.setOnClickListener(this.w);
        String size = this.b.getSize();
        String newVersion = this.b.getNewVersion();
        String newVersionDesc = this.b.getNewVersionDesc();
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.getString(y.new_version_format));
        if (!TextUtils.isEmpty(newVersion)) {
            sb.append(newVersion);
        }
        if (!TextUtils.isEmpty(size)) {
            sb.append(" / " + String.format("%.2f", Float.valueOf(com.baidu.adp.lib.f.b.a(size, 0.0f) / 1048576.0f)) + "MB");
        }
        this.i.setText(sb.toString());
        this.j.setText(newVersionDesc);
        if (this.b.forceUpdate()) {
            this.g = true;
            this.n.setText(this.a.getString(y.quit));
        } else {
            this.n.setText(this.a.getString(y.update_after));
        }
        if (this.c != null && this.c.showCombineDownload()) {
            this.m.setText(this.c.getAppName());
            if (!com.baidu.tieba.util.r.a(this.a, this.c.getAppProc()) && !TextUtils.isEmpty(this.c.getAppUrl())) {
                this.m.setVisibility(0);
                Drawable drawable = this.a.getResources().getDrawable(u.btn_dailog_choose_s);
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
            this.p.setVisibility(8);
            this.o.setBackgroundResource(u.update_button);
        } else {
            this.p.setVisibility(0);
            this.o.setBackgroundResource(u.cancel_button);
        }
        this.o.setOnClickListener(new ad(this));
        this.p.setOnClickListener(new ae(this));
        this.n.setOnClickListener(new af(this));
        this.m.setOnClickListener(new ag(this));
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
            this.u.c();
            this.h.setVisibility(8);
            if (this.g) {
                this.r.setText(getContext().getString(y.download_exit));
            }
            this.q.setVisibility(0);
            return;
        }
        this.u.b();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.b = versionData;
        this.c = combineDownload;
        this.u = ahVar;
    }

    public void a() {
        this.q.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void b(int i) {
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a(findViewById(v.app_download_dialog_layout));
        }
    }
}
