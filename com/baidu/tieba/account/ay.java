package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1060a;
    private com.baidu.tieba.util.ap b;

    private ay(Register2Activity register2Activity) {
        this.f1060a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(Register2Activity register2Activity, as asVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1060a.O = null;
        progressBar = this.f1060a.D;
        progressBar.setVisibility(8);
        this.f1060a.l();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        RegistData m;
        be beVar = new be();
        try {
            m = this.f1060a.m();
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/regreal");
            this.b.a("un", m.getName());
            this.b.a("phonenum", m.getPhone());
            this.b.a("passwd", m.getPsw());
            if (m.getVcode() != null) {
                this.b.a("vcode", m.getVcode());
            }
            if (m.getVcodeMd5() != null) {
                this.b.a("vcode_md5", m.getVcodeMd5());
            }
            String j = this.b.j();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                be beVar2 = new be();
                beVar2.a(j);
                return beVar2;
            }
            return beVar;
        } catch (Exception e) {
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        super.a((ay) beVar);
        this.f1060a.O = null;
        progressBar = this.f1060a.D;
        progressBar.setVisibility(8);
        this.f1060a.l();
        this.f1060a.P = beVar;
        if (!this.b.d()) {
            this.f1060a.K = -1;
            this.f1060a.L = this.b.g();
            this.f1060a.k();
        } else if (this.b.e() == 36) {
            this.f1060a.a(beVar.c());
            Register2Activity register2Activity = this.f1060a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.f1060a.L = this.b.g();
            this.f1060a.k();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f1060a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            this.f1060a.a(true);
        } else if (this.b.e() == 0) {
            m = this.f1060a.m();
            Register2Activity register2Activity3 = this.f1060a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, m, i);
            this.f1060a.a(false);
        } else {
            this.f1060a.K = this.b.e();
            this.f1060a.L = this.b.g();
            this.f1060a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f1060a.D;
        progressBar.setVisibility(0);
        this.f1060a.i();
        this.f1060a.K = -1;
        this.f1060a.L = null;
        this.f1060a.k();
        linearLayout = this.f1060a.z;
        linearLayout.setVisibility(8);
        textView = this.f1060a.s;
        textView.setVisibility(4);
        textView2 = this.f1060a.s;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
