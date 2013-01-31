package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends AsyncTask {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.c.t b;

    private bc(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(Register2Activity register2Activity, bc bcVar) {
        this(register2Activity);
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.t();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(String... strArr) {
        com.baidu.tieba.a.ap u;
        com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
        try {
            u = this.a.u();
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/regreal");
            this.b.a("un", u.a());
            this.b.a("phonenum", u.c());
            this.b.a("passwd", u.b());
            if (u.d() != null) {
                this.b.a("vcode", u.d());
            }
            if (u.e() != null) {
                this.b.a("vcode_md5", u.e());
            }
            String i = this.b.i();
            if ((this.b.c() && (this.b.d() == 0 || this.b.d() == 36)) || this.b.d() == 5) {
                com.baidu.tieba.b.g gVar2 = new com.baidu.tieba.b.g();
                gVar2.a(i);
                return gVar2;
            }
            return gVar;
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        com.baidu.tieba.a.ap u;
        int i;
        int i2;
        int i3;
        super.onPostExecute(gVar);
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.t();
        this.a.S = gVar;
        if (!this.b.c()) {
            this.a.O = -1;
            this.a.P = this.b.f();
            this.a.s();
        } else if (this.b.d() == 36) {
            this.a.a(gVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.h;
            register2Activity.O = i3;
            this.a.P = this.b.f();
            this.a.s();
        } else if (this.b.d() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.a.a(true);
        } else if (this.b.d() == 0) {
            u = this.a.u();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.g;
            ActivationActivity.a(register2Activity3, u, i);
            this.a.a(false);
        } else {
            this.a.O = this.b.d();
            this.a.P = this.b.f();
            this.a.s();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.a.H;
        progressBar.setVisibility(0);
        this.a.q();
        this.a.O = -1;
        this.a.P = null;
        this.a.s();
        linearLayout = this.a.D;
        linearLayout.setVisibility(8);
        textView = this.a.w;
        textView.setVisibility(4);
        textView2 = this.a.w;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
