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
    final /* synthetic */ ActivationActivity f900a;
    private com.baidu.tieba.util.v b;

    private h(ActivationActivity activationActivity) {
        this.f900a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ActivationActivity activationActivity, h hVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.as a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/regreal");
            com.baidu.tieba.util.v vVar = this.b;
            registData = this.f900a.r;
            vVar.a("un", registData.getName());
            com.baidu.tieba.util.v vVar2 = this.b;
            registData2 = this.f900a.r;
            vVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.v vVar3 = this.b;
            registData3 = this.f900a.r;
            vVar3.a("passwd", registData3.getPsw());
            registData4 = this.f900a.r;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.v vVar4 = this.b;
                registData7 = this.f900a.r;
                vVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f900a.r;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.v vVar5 = this.b;
                registData6 = this.f900a.r;
                vVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.v vVar6 = this.b;
            editText = this.f900a.k;
            vVar6.a("smscode", editText.getText().toString());
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.model.as asVar = new com.baidu.tieba.model.as();
                asVar.a(j);
                return asVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.as asVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((Object) asVar);
        progressBar = this.f900a.f;
        progressBar.setVisibility(8);
        this.f900a.o = null;
        this.f900a.a(true);
        z = this.f900a.p;
        if (z) {
            relativeLayout = this.f900a.m;
            relativeLayout.setEnabled(true);
        }
        if (asVar != null) {
            this.f900a.a(asVar);
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f900a.j;
            textView.setVisibility(0);
            textView2 = this.f900a.j;
            textView2.setText(g);
        }
        if (this.b.e() == 26) {
            this.f900a.A = 26;
            linearLayout = this.f900a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f900a.c;
            i = this.f900a.y;
            i2 = this.f900a.z;
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
        progressBar = this.f900a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f900a.m;
        relativeLayout.setEnabled(false);
        this.f900a.a(false);
        textView = this.f900a.j;
        textView.setVisibility(4);
        textView2 = this.f900a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.f900a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f900a.c;
        i = this.f900a.y;
        i2 = this.f900a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f900a.o = null;
        progressBar = this.f900a.f;
        progressBar.setVisibility(8);
        z = this.f900a.p;
        if (z) {
            relativeLayout = this.f900a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
        }
        this.f900a.a(true);
        super.cancel(true);
    }
}
