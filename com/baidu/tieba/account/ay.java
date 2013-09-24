package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, com.baidu.tieba.model.au> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f908a;
    private com.baidu.tieba.util.z b;

    private ay(Register2Activity register2Activity) {
        this.f908a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(Register2Activity register2Activity, ay ayVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f908a.R = null;
        progressBar = this.f908a.H;
        progressBar.setVisibility(8);
        this.f908a.t();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.au a(String... strArr) {
        RegistData u;
        com.baidu.tieba.model.au auVar = new com.baidu.tieba.model.au();
        try {
            u = this.f908a.u();
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/regreal");
            this.b.a("un", u.getName());
            this.b.a("phonenum", u.getPhone());
            this.b.a("passwd", u.getPsw());
            if (u.getVcode() != null) {
                this.b.a("vcode", u.getVcode());
            }
            if (u.getVcodeMd5() != null) {
                this.b.a("vcode_md5", u.getVcodeMd5());
            }
            String j = this.b.j();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                com.baidu.tieba.model.au auVar2 = new com.baidu.tieba.model.au();
                auVar2.a(j);
                return auVar2;
            }
            return auVar;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.au auVar) {
        ProgressBar progressBar;
        RegistData u;
        int i;
        int i2;
        int i3;
        super.a((ay) auVar);
        this.f908a.R = null;
        progressBar = this.f908a.H;
        progressBar.setVisibility(8);
        this.f908a.t();
        this.f908a.S = auVar;
        if (!this.b.d()) {
            this.f908a.O = -1;
            this.f908a.P = this.b.g();
            this.f908a.s();
        } else if (this.b.e() == 36) {
            this.f908a.a(auVar.c());
            Register2Activity register2Activity = this.f908a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.f908a.P = this.b.g();
            this.f908a.s();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f908a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.f908a.a(true);
        } else if (this.b.e() == 0) {
            u = this.f908a.u();
            Register2Activity register2Activity3 = this.f908a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, u, i);
            this.f908a.a(false);
        } else {
            this.f908a.O = this.b.e();
            this.f908a.P = this.b.g();
            this.f908a.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f908a.H;
        progressBar.setVisibility(0);
        this.f908a.q();
        this.f908a.O = -1;
        this.f908a.P = null;
        this.f908a.s();
        linearLayout = this.f908a.D;
        linearLayout.setVisibility(8);
        textView = this.f908a.w;
        textView.setVisibility(4);
        textView2 = this.f908a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
