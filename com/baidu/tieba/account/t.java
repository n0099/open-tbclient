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
public class t extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ ActivationActivity anq;

    private t(ActivationActivity activationActivity) {
        this.anq = activationActivity;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(ActivationActivity activationActivity, t tVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData registData;
        RegistData registData2;
        RegistData registData3;
        RegistData registData4;
        RegistData registData5;
        EditText editText;
        RegistData registData6;
        RegistData registData7;
        try {
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.ad adVar = this.AR;
            registData = this.anq.anh;
            adVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.ad adVar2 = this.AR;
            registData2 = this.anq.anh;
            adVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ad adVar3 = this.AR;
            registData3 = this.anq.anh;
            adVar3.o("passwd", registData3.getPsw());
            registData4 = this.anq.anh;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ad adVar4 = this.AR;
                registData7 = this.anq.anh;
                adVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.anq.anh;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ad adVar5 = this.AR;
                registData6 = this.anq.anh;
                adVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ad adVar6 = this.AR;
            editText = this.anq.anb;
            adVar6.o("smscode", editText.getText().toString());
            String oy = this.AR.oy();
            if (this.AR.oZ().qh().ma()) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.parserJson(oy);
                return nVar;
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
    public void onPostExecute(com.baidu.tbadk.core.data.n nVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(nVar);
        progressBar = this.anq.amZ;
        progressBar.setVisibility(8);
        this.anq.anf = null;
        this.anq.bg(true);
        z = this.anq.ang;
        if (z) {
            relativeLayout = this.anq.and;
            relativeLayout.setEnabled(true);
        }
        if (nVar != null) {
            this.anq.b(nVar);
            return;
        }
        String errorString = this.AR.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.anq.UN;
            textView.setVisibility(0);
            textView2 = this.anq.UN;
            textView2.setText(errorString);
        }
        if (this.AR.pd() == 26) {
            this.anq.ann = 26;
            linearLayout = this.anq.amW;
            linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input_wrong);
            linearLayout2 = this.anq.amW;
            i = this.anq.anl;
            i2 = this.anq.anm;
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
        progressBar = this.anq.amZ;
        progressBar.setVisibility(0);
        relativeLayout = this.anq.and;
        relativeLayout.setEnabled(false);
        this.anq.bg(false);
        textView = this.anq.UN;
        textView.setVisibility(4);
        textView2 = this.anq.UN;
        textView2.setText((CharSequence) null);
        linearLayout = this.anq.amW;
        linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input);
        linearLayout2 = this.anq.amW;
        i = this.anq.anl;
        i2 = this.anq.anm;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.anq.anf = null;
        progressBar = this.anq.amZ;
        progressBar.setVisibility(8);
        z = this.anq.ang;
        if (z) {
            relativeLayout = this.anq.and;
            relativeLayout.setEnabled(true);
        }
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.anq.bg(true);
        super.cancel(true);
    }
}
