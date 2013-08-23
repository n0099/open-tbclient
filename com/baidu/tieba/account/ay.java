package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f892a;
    private com.baidu.tieba.util.v b;

    private ay(Register2Activity register2Activity) {
        this.f892a = register2Activity;
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
        this.f892a.R = null;
        progressBar = this.f892a.H;
        progressBar.setVisibility(8);
        this.f892a.s();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.as a(String... strArr) {
        RegistData t;
        com.baidu.tieba.model.as asVar = new com.baidu.tieba.model.as();
        try {
            t = this.f892a.t();
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/regreal");
            this.b.a("un", t.getName());
            this.b.a("phonenum", t.getPhone());
            this.b.a("passwd", t.getPsw());
            if (t.getVcode() != null) {
                this.b.a("vcode", t.getVcode());
            }
            if (t.getVcodeMd5() != null) {
                this.b.a("vcode_md5", t.getVcodeMd5());
            }
            String j = this.b.j();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                com.baidu.tieba.model.as asVar2 = new com.baidu.tieba.model.as();
                asVar2.a(j);
                return asVar2;
            }
            return asVar;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.as asVar) {
        ProgressBar progressBar;
        RegistData t;
        int i;
        int i2;
        int i3;
        super.a((Object) asVar);
        this.f892a.R = null;
        progressBar = this.f892a.H;
        progressBar.setVisibility(8);
        this.f892a.s();
        this.f892a.S = asVar;
        if (!this.b.d()) {
            this.f892a.O = -1;
            this.f892a.P = this.b.g();
            this.f892a.r();
        } else if (this.b.e() == 36) {
            this.f892a.a(asVar.c());
            Register2Activity register2Activity = this.f892a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.f892a.P = this.b.g();
            this.f892a.r();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f892a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.f892a.a(true);
        } else if (this.b.e() == 0) {
            t = this.f892a.t();
            Register2Activity register2Activity3 = this.f892a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, t, i);
            this.f892a.a(false);
        } else {
            this.f892a.O = this.b.e();
            this.f892a.P = this.b.g();
            this.f892a.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f892a.H;
        progressBar.setVisibility(0);
        this.f892a.p();
        this.f892a.O = -1;
        this.f892a.P = null;
        this.f892a.r();
        linearLayout = this.f892a.D;
        linearLayout.setVisibility(8);
        textView = this.f892a.w;
        textView.setVisibility(4);
        textView2 = this.f892a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
