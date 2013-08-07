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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f879a;
    private com.baidu.tieba.util.u b;

    private h(ActivationActivity activationActivity) {
        this.f879a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ActivationActivity activationActivity, h hVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.at a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/regreal");
            com.baidu.tieba.util.u uVar = this.b;
            registData = this.f879a.r;
            uVar.a("un", registData.getName());
            com.baidu.tieba.util.u uVar2 = this.b;
            registData2 = this.f879a.r;
            uVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.u uVar3 = this.b;
            registData3 = this.f879a.r;
            uVar3.a("passwd", registData3.getPsw());
            registData4 = this.f879a.r;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.u uVar4 = this.b;
                registData7 = this.f879a.r;
                uVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f879a.r;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.u uVar5 = this.b;
                registData6 = this.f879a.r;
                uVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.u uVar6 = this.b;
            editText = this.f879a.k;
            uVar6.a("smscode", editText.getText().toString());
            String k = this.b.k();
            if (this.b.d()) {
                com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
                atVar.a(k);
                return atVar;
            }
            return null;
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
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((Object) atVar);
        progressBar = this.f879a.f;
        progressBar.setVisibility(8);
        this.f879a.o = null;
        this.f879a.a(true);
        z = this.f879a.p;
        if (z) {
            relativeLayout = this.f879a.m;
            relativeLayout.setEnabled(true);
        }
        if (atVar != null) {
            this.f879a.a(atVar);
            return;
        }
        String h = this.b.h();
        if (h != null && h.length() > 0) {
            textView = this.f879a.j;
            textView.setVisibility(0);
            textView2 = this.f879a.j;
            textView2.setText(h);
        }
        if (this.b.f() == 26) {
            this.f879a.A = 26;
            linearLayout = this.f879a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f879a.c;
            i = this.f879a.y;
            i2 = this.f879a.z;
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
        progressBar = this.f879a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f879a.m;
        relativeLayout.setEnabled(false);
        this.f879a.a(false);
        textView = this.f879a.j;
        textView.setVisibility(4);
        textView2 = this.f879a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.f879a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f879a.c;
        i = this.f879a.y;
        i2 = this.f879a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f879a.o = null;
        progressBar = this.f879a.f;
        progressBar.setVisibility(8);
        z = this.f879a.p;
        if (z) {
            relativeLayout = this.f879a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.i();
        }
        this.f879a.a(true);
        super.cancel(true);
    }
}
