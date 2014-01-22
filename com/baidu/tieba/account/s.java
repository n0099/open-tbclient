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
public class s extends BdAsyncTask<String, Integer, com.baidu.tieba.model.be> {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.util.ax b;

    private s(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ActivationActivity activationActivity, o oVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.be a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/regreal");
            com.baidu.tieba.util.ax axVar = this.b;
            registData = this.a.p;
            axVar.a("un", registData.getName());
            com.baidu.tieba.util.ax axVar2 = this.b;
            registData2 = this.a.p;
            axVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.ax axVar3 = this.b;
            registData3 = this.a.p;
            axVar3.a("passwd", registData3.getPsw());
            registData4 = this.a.p;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.ax axVar4 = this.b;
                registData7 = this.a.p;
                axVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.a.p;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.ax axVar5 = this.b;
                registData6 = this.a.p;
                axVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.ax axVar6 = this.b;
            editText = this.a.i;
            axVar6.a("smscode", editText.getText().toString());
            String m = this.b.m();
            if (this.b.d()) {
                com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
                beVar.a(m);
                return beVar;
            }
            return null;
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
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((s) beVar);
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.m = null;
        this.a.a(true);
        z = this.a.n;
        if (z) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (beVar != null) {
            this.a.a(beVar);
            return;
        }
        String j = this.b.j();
        if (j != null && j.length() > 0) {
            textView = this.a.h;
            textView.setVisibility(0);
            textView2 = this.a.h;
            textView2.setText(j);
        }
        if (this.b.f() == 26) {
            this.a.y = 26;
            linearLayout = this.a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.c;
            i = this.a.w;
            i2 = this.a.x;
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
        relativeLayout = this.a.k;
        relativeLayout.setEnabled(false);
        this.a.a(false);
        textView = this.a.h;
        textView.setVisibility(4);
        textView2 = this.a.h;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.a.c;
        i = this.a.w;
        i2 = this.a.x;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        z = this.a.n;
        if (z) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.k();
        }
        this.a.a(true);
        super.cancel(true);
    }
}
