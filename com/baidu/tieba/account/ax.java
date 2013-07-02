package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.r b;

    private ax(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(Register2Activity register2Activity, ax axVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.u();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.al a(String... strArr) {
        RegistData v;
        com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
        try {
            v = this.a.v();
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/regreal");
            this.b.a("un", v.getName());
            this.b.a("phonenum", v.getPhone());
            this.b.a("passwd", v.getPsw());
            if (v.getVcode() != null) {
                this.b.a("vcode", v.getVcode());
            }
            if (v.getVcodeMd5() != null) {
                this.b.a("vcode_md5", v.getVcodeMd5());
            }
            String j = this.b.j();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                com.baidu.tieba.model.al alVar2 = new com.baidu.tieba.model.al();
                alVar2.a(j);
                return alVar2;
            }
            return alVar;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.al alVar) {
        ProgressBar progressBar;
        RegistData v;
        int i;
        int i2;
        int i3;
        super.a((Object) alVar);
        this.a.R = null;
        progressBar = this.a.H;
        progressBar.setVisibility(8);
        this.a.u();
        this.a.S = alVar;
        if (!this.b.d()) {
            this.a.O = -1;
            this.a.P = this.b.g();
            this.a.t();
        } else if (this.b.e() == 36) {
            this.a.a(alVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.a.P = this.b.g();
            this.a.t();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.a.a(true);
        } else if (this.b.e() == 0) {
            v = this.a.v();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, v, i);
            this.a.a(false);
        } else {
            this.a.O = this.b.e();
            this.a.P = this.b.g();
            this.a.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
