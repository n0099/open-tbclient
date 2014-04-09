package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.h> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tbadk.core.data.h a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tbadk.core.data.h hVar) {
        ProgressBar progressBar;
        int i;
        int i2;
        int i3;
        com.baidu.tbadk.core.data.h hVar2 = hVar;
        super.a((ah) hVar2);
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.a(true);
        this.a.P = hVar2;
        if (!this.b.c()) {
            this.a.K = -1;
            this.a.L = this.b.f();
            this.a.g();
        } else if (this.b.d() == 36) {
            Register2Activity.a(this.a, hVar2.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.a.L = this.b.f();
            this.a.g();
        } else if (this.b.d() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            Register2Activity.a(this.a, true);
        } else if (this.b.d() == 0) {
            RegistData w = Register2Activity.w(this.a);
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, w, i);
            Register2Activity.a(this.a, false);
        } else {
            this.a.K = this.b.d();
            this.a.L = this.b.f();
            this.a.g();
        }
    }

    private ah(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(Register2Activity register2Activity, byte b) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.a(true);
        super.cancel(true);
    }

    private com.baidu.tbadk.core.data.h a() {
        com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
        try {
            RegistData w = Register2Activity.w(this.a);
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/regreal");
            this.b.a("un", w.getName());
            this.b.a("phonenum", w.getPhone());
            this.b.a("passwd", w.getPsw());
            if (w.getVcode() != null) {
                this.b.a("vcode", w.getVcode());
            }
            if (w.getVcodeMd5() != null) {
                this.b.a("vcode_md5", w.getVcodeMd5());
            }
            String i = this.b.i();
            if ((this.b.c() && (this.b.d() == 0 || this.b.d() == 36)) || this.b.d() == 5) {
                com.baidu.tbadk.core.data.h hVar2 = new com.baidu.tbadk.core.data.h();
                hVar2.a(i);
                return hVar2;
            }
            return hVar;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
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
        super.c();
    }
}
