package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.j> {
    final /* synthetic */ ActivationActivity a;
    private ae b;

    private r(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ActivationActivity activationActivity, r rVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tbadk.core.data.j doInBackground(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.b = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            ae aeVar = this.b;
            registData = this.a.q;
            aeVar.a("un", registData.getName());
            ae aeVar2 = this.b;
            registData2 = this.a.q;
            aeVar2.a("phonenum", registData2.getPhone());
            ae aeVar3 = this.b;
            registData3 = this.a.q;
            aeVar3.a("passwd", registData3.getPsw());
            registData4 = this.a.q;
            if (registData4.getVcode() != null) {
                ae aeVar4 = this.b;
                registData7 = this.a.q;
                aeVar4.a("vcode", registData7.getVcode());
            }
            registData5 = this.a.q;
            if (registData5.getVcodeMd5() != null) {
                ae aeVar5 = this.b;
                registData6 = this.a.q;
                aeVar5.a("vcode_md5", registData6.getVcodeMd5());
            }
            ae aeVar6 = this.b;
            editText = this.a.j;
            aeVar6.a("smscode", editText.getText().toString());
            String h = this.b.h();
            if (this.b.a().b().b()) {
                com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
                jVar.a(h);
                return jVar;
            }
            return null;
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
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(jVar);
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.n = null;
        this.a.a(true);
        z = this.a.o;
        if (z) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (jVar != null) {
            this.a.a(jVar);
            return;
        }
        String e = this.b.e();
        if (e != null && e.length() > 0) {
            textView = this.a.i;
            textView.setVisibility(0);
            textView2 = this.a.i;
            textView2.setText(e);
        }
        if (this.b.c() == 26) {
            this.a.y = 26;
            linearLayout = this.a.d;
            linearLayout.setBackgroundResource(com.baidu.tieba.t.pass_input_wrong);
            linearLayout2 = this.a.d;
            i = this.a.w;
            i2 = this.a.x;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
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
        this.a.a(false);
        textView = this.a.i;
        textView.setVisibility(4);
        textView2 = this.a.i;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.d;
        linearLayout.setBackgroundResource(com.baidu.tieba.t.pass_input);
        linearLayout2 = this.a.d;
        i = this.a.w;
        i2 = this.a.x;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
            this.b.f();
        }
        this.a.a(true);
        super.cancel(true);
    }
}
