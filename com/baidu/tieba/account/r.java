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
    final /* synthetic */ ActivationActivity aeY;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private r(ActivationActivity activationActivity) {
        this.aeY = activationActivity;
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
            registData = this.aeY.aeP;
            acVar.k("un", registData.getName());
            com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
            registData2 = this.aeY.aeP;
            acVar2.k("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
            registData3 = this.aeY.aeP;
            acVar3.k("passwd", registData3.getPsw());
            registData4 = this.aeY.aeP;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
                registData7 = this.aeY.aeP;
                acVar4.k("vcode", registData7.getVcode());
            }
            registData5 = this.aeY.aeP;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ac acVar5 = this.mNetWork;
                registData6 = this.aeY.aeP;
                acVar5.k("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ac acVar6 = this.mNetWork;
            editText = this.aeY.aeI;
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
        progressBar = this.aeY.aeG;
        progressBar.setVisibility(8);
        this.aeY.aeM = null;
        this.aeY.bf(true);
        z = this.aeY.aeN;
        if (z) {
            relativeLayout = this.aeY.aeK;
            relativeLayout.setEnabled(true);
        }
        if (jVar != null) {
            this.aeY.b(jVar);
            return;
        }
        String errorString = this.mNetWork.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.aeY.Or;
            textView.setVisibility(0);
            textView2 = this.aeY.Or;
            textView2.setText(errorString);
        }
        if (this.mNetWork.mg() == 26) {
            this.aeY.aeV = 26;
            linearLayout = this.aeY.aeD;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input_wrong);
            linearLayout2 = this.aeY.aeD;
            i = this.aeY.aeT;
            i2 = this.aeY.aeU;
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
        progressBar = this.aeY.aeG;
        progressBar.setVisibility(0);
        relativeLayout = this.aeY.aeK;
        relativeLayout.setEnabled(false);
        this.aeY.bf(false);
        textView = this.aeY.Or;
        textView.setVisibility(4);
        textView2 = this.aeY.Or;
        textView2.setText((CharSequence) null);
        linearLayout = this.aeY.aeD;
        linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
        linearLayout2 = this.aeY.aeD;
        i = this.aeY.aeT;
        i2 = this.aeY.aeU;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.aeY.aeM = null;
        progressBar = this.aeY.aeG;
        progressBar.setVisibility(8);
        z = this.aeY.aeN;
        if (z) {
            relativeLayout = this.aeY.aeK;
            relativeLayout.setEnabled(true);
        }
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.aeY.bf(true);
        super.cancel(true);
    }
}
