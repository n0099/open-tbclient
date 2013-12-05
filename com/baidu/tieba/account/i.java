package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1094a;
    private com.baidu.tieba.util.am b;

    private i(ActivationActivity activationActivity) {
        this.f1094a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ActivationActivity activationActivity, e eVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/regreal");
            com.baidu.tieba.util.am amVar = this.b;
            registData = this.f1094a.p;
            amVar.a("un", registData.getName());
            com.baidu.tieba.util.am amVar2 = this.b;
            registData2 = this.f1094a.p;
            amVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.am amVar3 = this.b;
            registData3 = this.f1094a.p;
            amVar3.a("passwd", registData3.getPsw());
            registData4 = this.f1094a.p;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.am amVar4 = this.b;
                registData7 = this.f1094a.p;
                amVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f1094a.p;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.am amVar5 = this.b;
                registData6 = this.f1094a.p;
                amVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.am amVar6 = this.b;
            editText = this.f1094a.i;
            amVar6.a("smscode", editText.getText().toString());
            String l = this.b.l();
            if (this.b.c()) {
                be beVar = new be();
                beVar.a(l);
                return beVar;
            }
            return null;
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((i) beVar);
        progressBar = this.f1094a.f;
        progressBar.setVisibility(8);
        this.f1094a.m = null;
        this.f1094a.a(true);
        z = this.f1094a.n;
        if (z) {
            relativeLayout = this.f1094a.k;
            relativeLayout.setEnabled(true);
        }
        if (beVar != null) {
            this.f1094a.a(beVar);
            return;
        }
        String i3 = this.b.i();
        if (i3 != null && i3.length() > 0) {
            textView = this.f1094a.h;
            textView.setVisibility(0);
            textView2 = this.f1094a.h;
            textView2.setText(i3);
        }
        if (this.b.e() == 26) {
            this.f1094a.y = 26;
            linearLayout = this.f1094a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f1094a.c;
            i = this.f1094a.w;
            i2 = this.f1094a.x;
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
        progressBar = this.f1094a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f1094a.k;
        relativeLayout.setEnabled(false);
        this.f1094a.a(false);
        textView = this.f1094a.h;
        textView.setVisibility(4);
        textView2 = this.f1094a.h;
        textView2.setText((CharSequence) null);
        linearLayout = this.f1094a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f1094a.c;
        i = this.f1094a.w;
        i2 = this.f1094a.x;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f1094a.m = null;
        progressBar = this.f1094a.f;
        progressBar.setVisibility(8);
        z = this.f1094a.n;
        if (z) {
            relativeLayout = this.f1094a.k;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.j();
        }
        this.f1094a.a(true);
        super.cancel(true);
    }
}
