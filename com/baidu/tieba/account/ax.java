package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f661a;
    private com.baidu.tieba.util.r b;

    private ax(Register2Activity register2Activity) {
        this.f661a = register2Activity;
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
        this.f661a.R = null;
        progressBar = this.f661a.H;
        progressBar.setVisibility(8);
        this.f661a.u();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.al a(String... strArr) {
        RegistData v;
        com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
        try {
            v = this.f661a.v();
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/regreal");
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
        this.f661a.R = null;
        progressBar = this.f661a.H;
        progressBar.setVisibility(8);
        this.f661a.u();
        this.f661a.S = alVar;
        if (!this.b.d()) {
            this.f661a.O = -1;
            this.f661a.P = this.b.g();
            this.f661a.t();
        } else if (this.b.e() == 36) {
            this.f661a.a(alVar.c());
            Register2Activity register2Activity = this.f661a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.f661a.P = this.b.g();
            this.f661a.t();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f661a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.f661a.a(true);
        } else if (this.b.e() == 0) {
            v = this.f661a.v();
            Register2Activity register2Activity3 = this.f661a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, v, i);
            this.f661a.a(false);
        } else {
            this.f661a.O = this.b.e();
            this.f661a.P = this.b.g();
            this.f661a.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f661a.H;
        progressBar.setVisibility(0);
        this.f661a.r();
        this.f661a.O = -1;
        this.f661a.P = null;
        this.f661a.t();
        linearLayout = this.f661a.D;
        linearLayout.setVisibility(8);
        textView = this.f661a.w;
        textView.setVisibility(4);
        textView2 = this.f661a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
