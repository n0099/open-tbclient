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
    private LinearLayout s;
    private TextView t;
    private Button u;
    private Button v;
    private ah w;
    private View.OnClickListener x;
    private View.OnClickListener y;

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
        this.n = (TextView) findViewById(v.otherApp);
        this.o = (TextView) findViewById(v.app_size);
        this.m = this.k.getText().toString();
        this.s = (LinearLayout) findViewById(v.cancel_dialog);
        this.u = (Button) findViewById(v.sure_cancel);
        this.v = (Button) findViewById(v.cancel_button);
        this.t = (TextView) findViewById(v.cancel_tip);
        this.u.setOnClickListener(this.x);
        this.v.setOnClickListener(this.y);
        String size = this.b.getSize();
        String newVersion = this.b.getNewVersion();
        String newVersionDesc = this.b.getNewVersionDesc();
        if (!TextUtils.isEmpty(size)) {
            this.o.setVisibility(0);
            this.o.setText(((Object) this.o.getText()) + size + "MB");
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
        if (this.b == null || TextUtils.isEmpty(this.b.getPatch())) {
            this.r.setVisibility(8);
        }
        if (this.r.isShown() && !bd.a(this.a.getPackageManager())) {
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
            this.w.c();
            this.h.setVisibility(8);
            if (this.g) {
                this.t.setText(getContext().getString(y.download_exit));
            }
            this.s.setVisibility(0);
            return;
        }
        this.w.b();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ah ahVar) {
        this.b = versionData;
        this.c = combineDownload;
        this.w = ahVar;
    }

    public void a() {
        this.s.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void b(int i) {
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a(findViewById(v.dialog_layout));
        }
    }
}
