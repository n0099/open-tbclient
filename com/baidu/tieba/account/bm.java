package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bm extends BdAsyncTask<String, Integer, com.baidu.tieba.model.at> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.model.at a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.model.at atVar) {
        ProgressBar progressBar;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.model.at atVar2 = atVar;
        super.a((bm) atVar2);
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.a(true);
        this.a.P = atVar2;
        if (!this.b.d()) {
            this.a.K = -1;
            this.a.L = this.b.i();
            this.a.g();
        } else if (this.b.e() == 36) {
            Register2Activity.a(this.a, atVar2.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.a.L = this.b.i();
            this.a.g();
        } else if (this.b.e() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            Register2Activity.a(this.a, true);
        } else if (this.b.e() == 0) {
            RegistData w = Register2Activity.w(this.a);
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, w, i);
            Register2Activity.a(this.a, false);
        } else {
            this.a.K = this.b.e();
            this.a.L = this.b.i();
            this.a.g();
        }
    }

    private bm(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bm(Register2Activity register2Activity, byte b) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
        }
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.a(true);
        super.cancel(true);
    }

    private com.baidu.tieba.model.at d() {
        com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
        try {
            RegistData w = Register2Activity.w(this.a);
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/regreal");
            this.b.a("un", w.getName());
            this.b.a("phonenum", w.getPhone());
            this.b.a("passwd", w.getPsw());
            if (w.getVcode() != null) {
                this.b.a("vcode", w.getVcode());
            }
            if (w.getVcodeMd5() != null) {
                this.b.a("vcode_md5", w.getVcodeMd5());
            }
            String l = this.b.l();
            if ((this.b.d() && (this.b.e() == 0 || this.b.e() == 36)) || this.b.e() == 5) {
                com.baidu.tieba.model.at atVar2 = new com.baidu.tieba.model.at();
                atVar2.a(l);
                return atVar2;
            }
            return atVar;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.a.D;
        progressBar.setVisibility(0);
        this.a.a(false);
        this.a.K = -1;
        this.a.L = null;
        this.a.g();
        linearLayout = this.a.z;
        linearLayout.setVisibility(8);
        textView = this.a.s;
        textView.setVisibility(4);
        textView2 = this.a.s;
        textView2.setText((CharSequence) null);
        super.b();
    }
}
