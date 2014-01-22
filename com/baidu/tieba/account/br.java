package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends BdAsyncTask<String, Integer, com.baidu.tieba.model.be> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.ax b;

    private br(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ br(Register2Activity register2Activity, bl blVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.k();
        }
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.l();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.be a(String... strArr) {
        RegistData m;
        com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
        try {
            m = this.a.m();
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/regreal");
            this.b.a("un", m.getName());
            this.b.a("phonenum", m.getPhone());
            this.b.a("passwd", m.getPsw());
            if (m.getVcode() != null) {
                this.b.a("vcode", m.getVcode());
            }
            if (m.getVcodeMd5() != null) {
                this.b.a("vcode_md5", m.getVcodeMd5());
            }
            String m2 = this.b.m();
            if ((this.b.e() && (this.b.f() == 0 || this.b.f() == 36)) || this.b.f() == 5) {
                com.baidu.tieba.model.be beVar2 = new com.baidu.tieba.model.be();
                beVar2.a(m2);
                return beVar2;
            }
            return beVar;
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.be beVar) {
        ProgressBar progressBar;
        RegistData m;
        int i;
        int i2;
        int i3;
        super.a((br) beVar);
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.l();
        this.a.P = beVar;
        if (!this.b.e()) {
            this.a.K = -1;
            this.a.L = this.b.j();
            this.a.k();
        } else if (this.b.f() == 36) {
            this.a.a(beVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.a.L = this.b.j();
            this.a.k();
        } else if (this.b.f() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            this.a.a(true);
        } else if (this.b.f() == 0) {
            m = this.a.m();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, m, i);
            this.a.a(false);
        } else {
            this.a.K = this.b.f();
            this.a.L = this.b.j();
            this.a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.a.D;
        progressBar.setVisibility(0);
        this.a.i();
        this.a.K = -1;
        this.a.L = null;
        this.a.k();
        linearLayout = this.a.z;
        linearLayout.setVisibility(8);
        textView = this.a.s;
        textView.setVisibility(4);
        textView2 = this.a.s;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
