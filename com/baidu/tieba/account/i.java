package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, bd> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1046a;
    private com.baidu.tieba.util.ag b;

    private i(ActivationActivity activationActivity) {
        this.f1046a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ActivationActivity activationActivity, e eVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bd a(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/regreal");
            com.baidu.tieba.util.ag agVar = this.b;
            registData = this.f1046a.r;
            agVar.a("un", registData.getName());
            com.baidu.tieba.util.ag agVar2 = this.b;
            registData2 = this.f1046a.r;
            agVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.ag agVar3 = this.b;
            registData3 = this.f1046a.r;
            agVar3.a("passwd", registData3.getPsw());
            registData4 = this.f1046a.r;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.ag agVar4 = this.b;
                registData7 = this.f1046a.r;
                agVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.f1046a.r;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.ag agVar5 = this.b;
                registData6 = this.f1046a.r;
                agVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.ag agVar6 = this.b;
            editText = this.f1046a.k;
            agVar6.a("smscode", editText.getText().toString());
            String j = this.b.j();
            if (this.b.c()) {
                bd bdVar = new bd();
                bdVar.a(j);
                return bdVar;
            }
            return null;
        } catch (Exception e) {
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bd bdVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((i) bdVar);
        progressBar = this.f1046a.f;
        progressBar.setVisibility(8);
        this.f1046a.o = null;
        this.f1046a.a(true);
        z = this.f1046a.p;
        if (z) {
            relativeLayout = this.f1046a.m;
            relativeLayout.setEnabled(true);
        }
        if (bdVar != null) {
            this.f1046a.a(bdVar);
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f1046a.j;
            textView.setVisibility(0);
            textView2 = this.f1046a.j;
            textView2.setText(g);
        }
        if (this.b.e() == 26) {
            this.f1046a.A = 26;
            linearLayout = this.f1046a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.f1046a.c;
            i = this.f1046a.y;
            i2 = this.f1046a.z;
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
        progressBar = this.f1046a.f;
        progressBar.setVisibility(0);
        relativeLayout = this.f1046a.m;
        relativeLayout.setEnabled(false);
        this.f1046a.a(false);
        textView = this.f1046a.j;
        textView.setVisibility(4);
        textView2 = this.f1046a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.f1046a.c;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.f1046a.c;
        i = this.f1046a.y;
        i2 = this.f1046a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.f1046a.o = null;
        progressBar = this.f1046a.f;
        progressBar.setVisibility(8);
        z = this.f1046a.p;
        if (z) {
            relativeLayout = this.f1046a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
        }
        this.f1046a.a(true);
        super.cancel(true);
    }
}
