package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.j> {
    final /* synthetic */ ActivationActivity afg;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private r(ActivationActivity activationActivity) {
        this.afg = activationActivity;
        this.mNetWork = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ActivationActivity activationActivity, r rVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
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
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
            registData = this.afg.aeX;
            acVar.k("un", registData.getName());
            com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
            registData2 = this.afg.aeX;
            acVar2.k("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
            registData3 = this.afg.aeX;
            acVar3.k("passwd", registData3.getPsw());
            registData4 = this.afg.aeX;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
                registData7 = this.afg.aeX;
                acVar4.k("vcode", registData7.getVcode());
            }
            registData5 = this.afg.aeX;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ac acVar5 = this.mNetWork;
                registData6 = this.afg.aeX;
                acVar5.k("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ac acVar6 = this.mNetWork;
            editText = this.afg.aeQ;
            acVar6.k("smscode", editText.getText().toString());
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mc().nb().jq()) {
                com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
                jVar.parserJson(lA);
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
        progressBar = this.afg.aeO;
        progressBar.setVisibility(8);
        this.afg.aeU = null;
        this.afg.bf(true);
        z = this.afg.aeV;
        if (z) {
            relativeLayout = this.afg.aeS;
            relativeLayout.setEnabled(true);
        }
        if (jVar != null) {
            this.afg.b(jVar);
            return;
        }
        String errorString = this.mNetWork.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.afg.Ov;
            textView.setVisibility(0);
            textView2 = this.afg.Ov;
            textView2.setText(errorString);
        }
        if (this.mNetWork.mg() == 26) {
            this.afg.afd = 26;
            linearLayout = this.afg.aeL;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input_wrong);
            linearLayout2 = this.afg.aeL;
            i = this.afg.afb;
            i2 = this.afg.afc;
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
        progressBar = this.afg.aeO;
        progressBar.setVisibility(0);
        relativeLayout = this.afg.aeS;
        relativeLayout.setEnabled(false);
        this.afg.bf(false);
        textView = this.afg.Ov;
        textView.setVisibility(4);
        textView2 = this.afg.Ov;
        textView2.setText((CharSequence) null);
        linearLayout = this.afg.aeL;
        linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
        linearLayout2 = this.afg.aeL;
        i = this.afg.afb;
        i2 = this.afg.afc;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.afg.aeU = null;
        progressBar = this.afg.aeO;
        progressBar.setVisibility(8);
        z = this.afg.aeV;
        if (z) {
            relativeLayout = this.afg.aeS;
            relativeLayout.setEnabled(true);
        }
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.afg.bf(true);
        super.cancel(true);
    }
}
