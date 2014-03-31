package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.h> {
    final /* synthetic */ ActivationActivity a;
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
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        com.baidu.tbadk.core.data.h hVar2 = hVar;
        super.a((r) hVar2);
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.n = null;
        ActivationActivity.b(this.a, true);
        z = this.a.o;
        if (z) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (hVar2 != null) {
            ActivationActivity.a(this.a, hVar2);
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.i;
            textView.setVisibility(0);
            textView2 = this.a.i;
            textView2.setText(f);
        }
        if (this.b.d() == 26) {
            this.a.y = 26;
            linearLayout = this.a.d;
            linearLayout.setBackgroundResource(com.baidu.tieba.a.g.pass_input_wrong);
            linearLayout2 = this.a.d;
            i = this.a.w;
            i2 = this.a.x;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    private r(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ActivationActivity activationActivity, byte b) {
        this(activationActivity);
    }

    private com.baidu.tbadk.core.data.h a() {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/regreal");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            registData = this.a.q;
            akVar.a(PersonInfoActivity.TAG_ID, registData.getName());
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            registData2 = this.a.q;
            akVar2.a("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ak akVar3 = this.b;
            registData3 = this.a.q;
            akVar3.a("passwd", registData3.getPsw());
            registData4 = this.a.q;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ak akVar4 = this.b;
                registData7 = this.a.q;
                akVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.a.q;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ak akVar5 = this.b;
                registData6 = this.a.q;
                akVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ak akVar6 = this.b;
            editText = this.a.j;
            akVar6.a("smscode", editText.getText().toString());
            String i = this.b.i();
            if (this.b.a().b().b()) {
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.a(i);
                return hVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        relativeLayout = this.a.l;
        relativeLayout.setEnabled(false);
        ActivationActivity.b(this.a, false);
        textView = this.a.i;
        textView.setVisibility(4);
        textView2 = this.a.i;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.d;
        linearLayout.setBackgroundResource(com.baidu.tieba.a.g.pass_input);
        linearLayout2 = this.a.d;
        i = this.a.w;
        i2 = this.a.x;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.n = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        z = this.a.o;
        if (z) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        ActivationActivity.b(this.a, true);
        super.cancel(true);
    }
}
