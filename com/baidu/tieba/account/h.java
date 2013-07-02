package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.util.r b;

    private h(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ActivationActivity activationActivity, h hVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.al a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/regreal");
            com.baidu.tieba.util.r rVar = this.b;
            registData = this.a.r;
            rVar.a("un", registData.getName());
            com.baidu.tieba.util.r rVar2 = this.b;
            registData2 = this.a.r;
            rVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.r rVar3 = this.b;
            registData3 = this.a.r;
            rVar3.a("passwd", registData3.getPsw());
            registData4 = this.a.r;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.r rVar4 = this.b;
                registData7 = this.a.r;
                rVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.a.r;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.r rVar5 = this.b;
                registData6 = this.a.r;
                rVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.r rVar6 = this.b;
            editText = this.a.k;
            rVar6.a("smscode", editText.getText().toString());
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
                alVar.a(j);
                return alVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.al alVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((Object) alVar);
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.o = null;
        this.a.a(true);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (alVar != null) {
            this.a.a(alVar);
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.a.j;
            textView.setVisibility(0);
            textView2 = this.a.j;
            textView2.setText(g);
        }
        if (this.b.e() == 26) {
            this.a.A = 26;
            linearLayout = this.a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.c;
            i = this.a.y;
            i2 = this.a.z;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.a.m;
        relativeLayout.setEnabled(false);
        this.a.a(false);
        textView = this.a.j;
        textView.setVisibility(4);
        textView2 = this.a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.a.c;
        i = this.a.y;
        i2 = this.a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.o = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
        }
        this.a.a(true);
        super.cancel(true);
    }
}
