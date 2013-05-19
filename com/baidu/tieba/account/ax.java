package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.a.a {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.d.t b;

    private ax(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(Register2Activity register2Activity, ax axVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.u();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.af a(String... strArr) {
        com.baidu.tieba.a.at v;
        com.baidu.tieba.c.af afVar = new com.baidu.tieba.c.af();
        try {
            v = this.a.v();
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/regreal");
            this.b.a("un", v.a());
            this.b.a("phonenum", v.c());
            this.b.a("passwd", v.b());
            if (v.d() != null) {
                this.b.a("vcode", v.d());
            }
            if (v.e() != null) {
                this.b.a("vcode_md5", v.e());
            }
            String i = this.b.i();
            if ((this.b.c() && (this.b.d() == 0 || this.b.d() == 36)) || this.b.d() == 5) {
                com.baidu.tieba.c.af afVar2 = new com.baidu.tieba.c.af();
                afVar2.a(i);
                return afVar2;
            }
            return afVar;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.af afVar) {
        ProgressBar progressBar;
        com.baidu.tieba.a.at v;
        int i;
        int i2;
        int i3;
        super.a((Object) afVar);
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.u();
        this.a.S = afVar;
        if (!this.b.c()) {
            this.a.O = -1;
            this.a.P = this.b.f();
            this.a.t();
        } else if (this.b.d() == 36) {
            this.a.a(afVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.h;
            register2Activity.O = i3;
            this.a.P = this.b.f();
            this.a.t();
        } else if (this.b.d() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.a.a(true);
        } else if (this.b.d() == 0) {
            v = this.a.v();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.g;
            ActivationActivity.a(register2Activity3, v, i);
            this.a.a(false);
        } else {
            this.a.O = this.b.d();
            this.a.P = this.b.f();
            this.a.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.a.H;
        progressBar.setVisibility(0);
        this.a.r();
        this.a.O = -1;
        this.a.P = null;
        this.a.t();
        linearLayout = this.a.D;
        linearLayout.setVisibility(8);
        textView = this.a.w;
        textView.setVisibility(4);
        textView2 = this.a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
