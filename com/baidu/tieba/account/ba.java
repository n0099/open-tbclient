package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1074a;
    private com.baidu.tieba.util.am b;

    private ba(Register2Activity register2Activity) {
        this.f1074a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(Register2Activity register2Activity, au auVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
        }
        this.f1074a.O = null;
        progressBar = this.f1074a.D;
        progressBar.setVisibility(8);
        this.f1074a.l();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        RegistData m;
        be beVar = new be();
        try {
            m = this.f1074a.m();
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/regreal");
            this.b.a("un", m.getName());
            this.b.a("phonenum", m.getPhone());
            this.b.a("passwd", m.getPsw());
            if (m.getVcode() != null) {
                this.b.a("vcode", m.getVcode());
            }
            if (m.getVcodeMd5() != null) {
                this.b.a("vcode_md5", m.getVcodeMd5());
            }
            String l = this.b.l();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                be beVar2 = new be();
                beVar2.a(l);
                return beVar2;
            }
            return beVar;
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        ProgressBar progressBar;
        RegistData m;
        int i;
        int i2;
        int i3;
        super.a((ba) beVar);
        this.f1074a.O = null;
        progressBar = this.f1074a.D;
        progressBar.setVisibility(8);
        this.f1074a.l();
        this.f1074a.P = beVar;
        if (!this.b.d()) {
            this.f1074a.K = -1;
            this.f1074a.L = this.b.i();
            this.f1074a.k();
        } else if (this.b.e() == 36) {
            this.f1074a.a(beVar.c());
            Register2Activity register2Activity = this.f1074a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.f1074a.L = this.b.i();
            this.f1074a.k();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f1074a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            this.f1074a.a(true);
        } else if (this.b.e() == 0) {
            m = this.f1074a.m();
            Register2Activity register2Activity3 = this.f1074a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, m, i);
            this.f1074a.a(false);
        } else {
            this.f1074a.K = this.b.e();
            this.f1074a.L = this.b.i();
            this.f1074a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f1074a.D;
        progressBar.setVisibility(0);
        this.f1074a.i();
        this.f1074a.K = -1;
        this.f1074a.L = null;
        this.f1074a.k();
        linearLayout = this.f1074a.z;
        linearLayout.setVisibility(8);
        textView = this.f1074a.s;
        textView.setVisibility(4);
        textView2 = this.f1074a.s;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
