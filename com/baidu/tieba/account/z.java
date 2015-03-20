package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.aa Oi;
    final /* synthetic */ ActivationActivity avm;

    private z(ActivationActivity activationActivity) {
        this.avm = activationActivity;
        this.Oi = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(ActivationActivity activationActivity, z zVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
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
            this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.aa aaVar = this.Oi;
            registData = this.avm.avd;
            aaVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.aa aaVar2 = this.Oi;
            registData2 = this.avm.avd;
            aaVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.aa aaVar3 = this.Oi;
            registData3 = this.avm.avd;
            aaVar3.o("passwd", registData3.getPsw());
            registData4 = this.avm.avd;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.Oi;
                registData7 = this.avm.avd;
                aaVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.avm.avd;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.Oi;
                registData6 = this.avm.avd;
                aaVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.aa aaVar6 = this.Oi;
            editText = this.avm.auX;
            aaVar6.o("smscode", editText.getText().toString());
            String rO = this.Oi.rO();
            if (this.Oi.sp().tq().pv()) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.parserJson(rO);
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
    /* renamed from: b */
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
        progressBar = this.avm.auV;
        progressBar.setVisibility(8);
        this.avm.avb = null;
        this.avm.bk(true);
        z = this.avm.avc;
        if (z) {
            relativeLayout = this.avm.auZ;
            relativeLayout.setEnabled(true);
        }
        if (nVar != null) {
            this.avm.a(nVar);
            return;
        }
        String errorString = this.Oi.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.avm.aeO;
            textView.setVisibility(0);
            textView2 = this.avm.aeO;
            textView2.setText(errorString);
        }
        if (this.Oi.st() == 26) {
            this.avm.avj = 26;
            linearLayout = this.avm.auS;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input_wrong);
            linearLayout2 = this.avm.auS;
            i = this.avm.avh;
            i2 = this.avm.avi;
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
        progressBar = this.avm.auV;
        progressBar.setVisibility(0);
        relativeLayout = this.avm.auZ;
        relativeLayout.setEnabled(false);
        this.avm.bk(false);
        textView = this.avm.aeO;
        textView.setVisibility(4);
        textView2 = this.avm.aeO;
        textView2.setText((CharSequence) null);
        linearLayout = this.avm.auS;
        linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
        linearLayout2 = this.avm.auS;
        i = this.avm.avh;
        i2 = this.avm.avi;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.avm.avb = null;
        progressBar = this.avm.auV;
        progressBar.setVisibility(8);
        z = this.avm.avc;
        if (z) {
            relativeLayout = this.avm.auZ;
            relativeLayout.setEnabled(true);
        }
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.avm.bk(true);
        super.cancel(true);
    }
}
