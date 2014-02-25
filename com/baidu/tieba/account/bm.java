package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends BdAsyncTask<String, Integer, com.baidu.tieba.model.at> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.ba b;

    private bm(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bm(Register2Activity register2Activity, bm bmVar) {
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
    public com.baidu.tieba.model.at a(String... strArr) {
        RegistData m;
        com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
        try {
            m = this.a.m();
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/regreal");
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
                com.baidu.tieba.model.at atVar2 = new com.baidu.tieba.model.at();
                atVar2.a(m2);
                return atVar2;
            }
            return atVar;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.at atVar) {
        ProgressBar progressBar;
        RegistData m;
        int i;
        int i2;
        int i3;
        super.a((bm) atVar);
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.l();
        this.a.P = atVar;
        if (!this.b.e()) {
            this.a.K = -1;
            this.a.L = this.b.j();
            this.a.k();
        } else if (this.b.f() == 36) {
            this.a.a(atVar.c());
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
