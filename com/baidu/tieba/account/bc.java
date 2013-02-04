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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(String... strArr) {
        com.baidu.tieba.a.ao s;
        com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
        try {
            s = this.a.s();
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/regreal");
            this.b.a("un", s.a());
            this.b.a("phonenum", s.c());
            this.b.a("passwd", s.b());
            if (s.d() != null) {
                this.b.a("vcode", s.d());
            }
            if (s.e() != null) {
                this.b.a("vcode_md5", s.e());
            }
            String i = this.b.i();
            if ((this.b.c() && (this.b.d() == 0 || this.b.d() == 36)) || this.b.d() == 5) {
                com.baidu.tieba.b.g gVar2 = new com.baidu.tieba.b.g();
                gVar2.a(i);
                return gVar2;
            }
            return gVar;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.M = null;
        progressBar = this.a.C;
        progressBar.setVisibility(8);
        this.a.r();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        com.baidu.tieba.a.ao s;
        int i;
        int i2;
        int i3;
        super.onPostExecute(gVar);
        this.a.M = null;
        progressBar = this.a.C;
        progressBar.setVisibility(8);
        this.a.r();
        this.a.N = gVar;
        if (!this.b.c()) {
            this.a.J = -1;
            this.a.K = this.b.f();
            this.a.q();
        } else if (this.b.d() == 36) {
            this.a.a(gVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.c;
            register2Activity.J = i3;
            this.a.K = this.b.f();
            this.a.q();
        } else if (this.b.d() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.f;
            register2Activity2.J = i2;
            this.a.a(true);
        } else if (this.b.d() == 0) {
            s = this.a.s();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.b;
            ActivationActivity.a(register2Activity3, s, i);
            this.a.a(false);
        } else {
            this.a.J = this.b.d();
            this.a.K = this.b.f();
            this.a.q();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.a.C;
        progressBar.setVisibility(0);
        this.a.o();
        this.a.J = -1;
        this.a.K = null;
        this.a.q();
        linearLayout = this.a.y;
        linearLayout.setVisibility(8);
        textView = this.a.r;
        textView.setVisibility(4);
        textView2 = this.a.r;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
