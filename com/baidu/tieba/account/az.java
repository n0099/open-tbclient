package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<String, Integer, bd> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1038a;
    private com.baidu.tieba.util.ag b;

    private az(Register2Activity register2Activity) {
        this.f1038a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(Register2Activity register2Activity, at atVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1038a.R = null;
        progressBar = this.f1038a.H;
        progressBar.setVisibility(8);
        this.f1038a.t();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bd a(String... strArr) {
        RegistData u;
        bd bdVar = new bd();
        try {
            u = this.f1038a.u();
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/regreal");
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
                bd bdVar2 = new bd();
                bdVar2.a(j);
                return bdVar2;
            }
            return bdVar;
        } catch (Exception e) {
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bd bdVar) {
        ProgressBar progressBar;
        RegistData u;
        int i;
        int i2;
        int i3;
        super.a((az) bdVar);
        this.f1038a.R = null;
        progressBar = this.f1038a.H;
        progressBar.setVisibility(8);
        this.f1038a.t();
        this.f1038a.S = bdVar;
        if (!this.b.d()) {
            this.f1038a.O = -1;
            this.f1038a.P = this.b.g();
            this.f1038a.s();
        } else if (this.b.e() == 36) {
            this.f1038a.a(bdVar.c());
            Register2Activity register2Activity = this.f1038a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.f1038a.P = this.b.g();
            this.f1038a.s();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.f1038a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.f1038a.a(true);
        } else if (this.b.e() == 0) {
            u = this.f1038a.u();
            Register2Activity register2Activity3 = this.f1038a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, u, i);
            this.f1038a.a(false);
        } else {
            this.f1038a.O = this.b.e();
            this.f1038a.P = this.b.g();
            this.f1038a.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f1038a.H;
        progressBar.setVisibility(0);
        this.f1038a.q();
        this.f1038a.O = -1;
        this.f1038a.P = null;
        this.f1038a.s();
        linearLayout = this.f1038a.D;
        linearLayout.setVisibility(8);
        textView = this.f1038a.w;
        textView.setVisibility(4);
        textView2 = this.f1038a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
