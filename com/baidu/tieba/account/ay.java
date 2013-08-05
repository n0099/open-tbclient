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
    final /* synthetic */ Register2Activity f873a;
    private com.baidu.tieba.util.u b;

    private ay(Register2Activity register2Activity) {
        this.f873a = register2Activity;
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
            this.b.i();
        }
        this.f873a.R = null;
        progressBar = this.f873a.H;
        progressBar.setVisibility(8);
        this.f873a.s();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.at a(String... strArr) {
        RegistData t;
        com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
        try {
            t = this.f873a.t();
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/regreal");
            this.b.a("un", t.getName());
            this.b.a("phonenum", t.getPhone());
            this.b.a("passwd", t.getPsw());
            if (t.getVcode() != null) {
                this.b.a("vcode", t.getVcode());
            }
            if (t.getVcodeMd5() != null) {
                this.b.a("vcode_md5", t.getVcodeMd5());
            }
            String k = this.b.k();
            if ((this.b.e() && (this.b.f() == 0 || this.b.f() == 36)) || this.b.f() == 5) {
                com.baidu.tieba.model.at atVar2 = new com.baidu.tieba.model.at();
                atVar2.a(k);
                return atVar2;
            }
            return atVar;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.at atVar) {
        ProgressBar progressBar;
        RegistData t;
        int i;
        int i2;
        int i3;
        super.a((Object) atVar);
        this.f873a.R = null;
        progressBar = this.f873a.H;
        progressBar.setVisibility(8);
        this.f873a.s();
        this.f873a.S = atVar;
        if (!this.b.e()) {
            this.f873a.O = -1;
            this.f873a.P = this.b.h();
            this.f873a.r();
        } else if (this.b.f() == 36) {
            this.f873a.a(atVar.c());
            Register2Activity register2Activity = this.f873a;
            i3 = Register2Activity.f;
            register2Activity.O = i3;
            this.f873a.P = this.b.h();
            this.f873a.r();
        } else if (this.b.f() == 5) {
            Register2Activity register2Activity2 = this.f873a;
            i2 = Register2Activity.k;
            register2Activity2.O = i2;
            this.f873a.a(true);
        } else if (this.b.f() == 0) {
            t = this.f873a.t();
            Register2Activity register2Activity3 = this.f873a;
            i = Register2Activity.e;
            ActivationActivity.a(register2Activity3, t, i);
            this.f873a.a(false);
        } else {
            this.f873a.O = this.b.f();
            this.f873a.P = this.b.h();
            this.f873a.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.f873a.H;
        progressBar.setVisibility(0);
        this.f873a.p();
        this.f873a.O = -1;
        this.f873a.P = null;
        this.f873a.r();
        linearLayout = this.f873a.D;
        linearLayout.setVisibility(8);
        textView = this.f873a.w;
        textView.setVisibility(4);
        textView2 = this.f873a.w;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
