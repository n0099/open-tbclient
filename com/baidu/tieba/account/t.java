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
public final class t extends BdAsyncTask<String, Integer, com.baidu.tieba.model.at> {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.model.at a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.model.at atVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        com.baidu.tieba.model.at atVar2 = atVar;
        super.a((t) atVar2);
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.m = null;
        ActivationActivity.b(this.a, true);
        z = this.a.n;
        if (z) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (atVar2 != null) {
            ActivationActivity.a(this.a, atVar2);
            return;
        }
        String i3 = this.b.i();
        if (i3 != null && i3.length() > 0) {
            textView = this.a.h;
            textView.setVisibility(0);
            textView2 = this.a.h;
            textView2.setText(i3);
        }
        if (this.b.e() == 26) {
            this.a.y = 26;
            linearLayout = this.a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.c;
            i = this.a.w;
            i2 = this.a.x;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    private t(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(ActivationActivity activationActivity, byte b) {
        this(activationActivity);
    }

    private com.baidu.tieba.model.at d() {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/regreal");
            com.baidu.tieba.util.ba baVar = this.b;
            registData = this.a.p;
            baVar.a("un", registData.getName());
            com.baidu.tieba.util.ba baVar2 = this.b;
            registData2 = this.a.p;
            baVar2.a("phonenum", registData2.getPhone());
            com.baidu.tieba.util.ba baVar3 = this.b;
            registData3 = this.a.p;
            baVar3.a("passwd", registData3.getPsw());
            registData4 = this.a.p;
            if (registData4.getVcode() != null) {
                com.baidu.tieba.util.ba baVar4 = this.b;
                registData7 = this.a.p;
                baVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.a.p;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tieba.util.ba baVar5 = this.b;
                registData6 = this.a.p;
                baVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tieba.util.ba baVar6 = this.b;
            editText = this.a.i;
            baVar6.a("smscode", editText.getText().toString());
            String l = this.b.l();
            if (this.b.c()) {
                com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
                atVar.a(l);
                return atVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
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
        ActivationActivity.b(this.a, false);
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
    public final void cancel() {
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
            this.b.j();
        }
        ActivationActivity.b(this.a, true);
        super.cancel(true);
    }
}
