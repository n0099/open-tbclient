package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.j> {
    final /* synthetic */ Register2Activity a;
    private ae b;

    private z(Register2Activity register2Activity) {
        this.a = register2Activity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(Register2Activity register2Activity, z zVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.f();
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
    /* renamed from: a */
    public com.baidu.tbadk.core.data.j doInBackground(String... strArr) {
        RegistData m;
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        try {
            m = this.a.m();
            this.b = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.b.a("un", m.getName());
            this.b.a("phonenum", m.getPhone());
            this.b.a("passwd", m.getPsw());
            if (m.getVcode() != null) {
                this.b.a("vcode", m.getVcode());
            }
            if (m.getVcodeMd5() != null) {
                this.b.a("vcode_md5", m.getVcodeMd5());
            }
            String h = this.b.h();
            if ((this.b.b() && (this.b.c() == 0 || this.b.c() == 36)) || this.b.c() == 5) {
                com.baidu.tbadk.core.data.j jVar2 = new com.baidu.tbadk.core.data.j();
                jVar2.a(h);
                return jVar2;
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.j jVar) {
        ProgressBar progressBar;
        RegistData m;
        int i;
        int i2;
        int i3;
        super.onPostExecute(jVar);
        this.a.O = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        this.a.l();
        this.a.P = jVar;
        if (!this.b.b()) {
            this.a.K = -1;
            this.a.L = this.b.e();
            this.a.k();
        } else if (this.b.c() == 36) {
            this.a.a(jVar.c());
            Register2Activity register2Activity = this.a;
            i3 = Register2Activity.d;
            register2Activity.K = i3;
            this.a.L = this.b.e();
            this.a.k();
        } else if (this.b.c() == 5) {
            Register2Activity register2Activity2 = this.a;
            i2 = Register2Activity.g;
            register2Activity2.K = i2;
            this.a.a(true);
        } else if (this.b.c() == 0) {
            m = this.a.m();
            Register2Activity register2Activity3 = this.a;
            i = Register2Activity.c;
            ActivationActivity.a(register2Activity3, m, i);
            this.a.a(false);
        } else {
            this.a.K = this.b.c();
            this.a.L = this.b.e();
            this.a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
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
        super.onPreExecute();
    }
}
