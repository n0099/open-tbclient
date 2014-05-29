package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.apache.commons.io.FileUtils;
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
    private TextView l;
    private String m;
    private TextView n;
    private TextView o;
    private Button p;
    private Button q;
    private Button r;
    private TextView s;
    private LinearLayout t;
    private TextView u;
    private Button v;
    private Button w;
    private ah x;
    private View.OnClickListener y;
    private View.OnClickListener z;

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
        setContentView(w.update_dialog);
        this.h = (LinearLayout) findViewById(v.down_dialog);
        this.i = (TextView) findViewById(v.newversion);
        this.j = (TextView) findViewById(v.desc);
        this.q = (Button) findViewById(v.update_button);
        this.p = (Button) findViewById(v.update_cancel);
        this.k = (TextView) findViewById(v.downloading);
        this.l = (TextView) findViewById(v.warning);
        this.r = (Button) findViewById(v.incremental_button);
        this.s = (TextView) findViewById(v.incremental_size);
        this.n = (TextView) findViewById(v.otherApp);
        this.o = (TextView) findViewById(v.app_size);
        this.m = this.k.getText().toString();
        this.t = (LinearLayout) findViewById(v.cancel_dialog);
        this.v = (Button) findViewById(v.sure_cancel);
        this.w = (Button) findViewById(v.cancel_button);
        this.u = (TextView) findViewById(v.cancel_tip);
        this.v.setOnClickListener(this.y);
        this.w.setOnClickListener(this.z);
        String size = this.b.getSize();
        String newVersion = this.b.getNewVersion();
        String newVersionDesc = this.b.getNewVersionDesc();
        if (!TextUtils.isEmpty(size)) {
            this.o.setVisibility(0);
            this.o.setText(((Object) this.o.getText()) + (String.valueOf((int) (com.baidu.adp.lib.f.b.a(size, 0L) / FileUtils.ONE_MB)) + "MB"));
        } else {
            this.o.setVisibility(8);
        }
        this.i.setText(String.valueOf(this.a.getString(y.new_version_format)) + newVersion);
        this.j.setText(newVersionDesc);
        if (this.b.forceUpdate()) {
            this.g = true;
            this.p.setText(this.a.getString(y.quit));
        } else {
            this.p.setText(this.a.getString(y.update_later));
        }
        if (this.c != null && this.c.showCombineDownload()) {
            this.n.setText(this.c.getAppName());
            if (!com.baidu.tieba.util.r.a(this.a, this.c.getAppProc()) && !TextUtils.isEmpty(this.c.getAppUrl())) {
                this.n.setVisibility(0);
                Drawable drawable = this.a.getResources().getDrawable(u.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.n.setCompoundDrawables(drawable, null, null, null);
                this.d = true;
            } else {
                this.n.setVisibility(8);
                this.d = false;
            }
        } else {
            this.n.setVisibility(8);
            this.d = false;
        }
        if (this.b == null || TextUtils.isEmpty(this.b.getPatch()) || this.b.getNewVersionCode() < 0) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.b.getPatchSize())) {
            this.s.setText(((Object) this.s.getText()) + (String.valueOf((int) (com.baidu.adp.lib.f.b.a(this.b.getPatchSize(), 0L) / FileUtils.ONE_MB)) + "MB"));
        }
        if (this.r.getVisibility() == 0 && !bd.a(this.a.getPackageManager())) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.q.setOnClickListener(new ad(this));
        this.r.setOnClickListener(new ae(this));
        this.p.setOnClickListener(new af(this));
        this.n.setOnClickListener(new ag(this));
    }

    public void a(int i) {
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.p.setVisibility(8);
        this.k.setVisibility(0);
        this.k.setText(String.valueOf(this.m) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f) {
            this.x.c();
            this.h.setVisibility(8);
            if (this.g) {
                this.u.setText(getContext().getString(y.download_exit));
            }
            this.t.setVisibility(0);
            return;
        }
        this.x.b();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.b = versionData;
        this.c = combineDownload;
        this.x = ahVar;
    }

    public void a() {
        this.t.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void b(int i) {
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a(findViewById(v.dialog_layout));
        }
    }
}
