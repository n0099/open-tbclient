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
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.model.au> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f916a;
    private com.baidu.tieba.util.z b;

    private h(ActivationActivity activationActivity) {
        this.f916a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ActivationActivity activationActivity, h hVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.au a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/regreal");
            com.baidu.tieba.util.z zVar = this.b;
            registData = this.f916a.r;
            zVar.a("un", registData.getName());
            com.baidu.tieba.util.z zVar2 = this.b;
            registData2 = this.f916a.r;
            zVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.z zVar3 = this.b;
            registData3 = this.f916a.r;
            zVar3.a("passwd", registData3.getPsw());
            registData4 = this.f916a.r;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.z zVar4 = this.b;
                registData7 = this.f916a.r;
                zVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f916a.r;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.z zVar5 = this.b;
                registData6 = this.f916a.r;
                zVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.z zVar6 = this.b;
            editText = this.f916a.k;
            zVar6.a("smscode", editText.getText().toString());
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.model.au auVar = new com.baidu.tieba.model.au();
                auVar.a(j);
                return auVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.au auVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((h) auVar);
        progressBar = this.f916a.f;
        progressBar.setVisibility(8);
        this.f916a.o = null;
        this.f916a.a(true);
        z = this.f916a.p;
        if (z) {
            relativeLayout = this.f916a.m;
            relativeLayout.setEnabled(true);
        }
        if (auVar != null) {
            this.f916a.a(auVar);
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f916a.j;
            textView.setVisibility(0);
            textView2 = this.f916a.j;
            textView2.setText(g);
        }
        if (this.b.e() == 26) {
            this.f916a.A = 26;
            linearLayout = this.f916a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f916a.c;
            i = this.f916a.y;
            i2 = this.f916a.z;
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
        progressBar = this.f916a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f916a.m;
        relativeLayout.setEnabled(false);
        this.f916a.a(false);
        textView = this.f916a.j;
        textView.setVisibility(4);
        textView2 = this.f916a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.f916a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f916a.c;
        i = this.f916a.y;
        i2 = this.f916a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f916a.o = null;
        progressBar = this.f916a.f;
        progressBar.setVisibility(8);
        z = this.f916a.p;
        if (z) {
            relativeLayout = this.f916a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
        }
        this.f916a.a(true);
        super.cancel(true);
    }
}
