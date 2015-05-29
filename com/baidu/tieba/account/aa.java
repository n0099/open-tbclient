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
public class aa extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.aa OE;
    final /* synthetic */ ActivationActivity awV;

    private aa(ActivationActivity activationActivity) {
        this.awV = activationActivity;
        this.OE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(ActivationActivity activationActivity, aa aaVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
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
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.aa aaVar = this.OE;
            registData = this.awV.awN;
            aaVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.aa aaVar2 = this.OE;
            registData2 = this.awV.awN;
            aaVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.aa aaVar3 = this.OE;
            registData3 = this.awV.awN;
            aaVar3.o("passwd", registData3.getPsw());
            registData4 = this.awV.awN;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.OE;
                registData7 = this.awV.awN;
                aaVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.awV.awN;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.OE;
                registData6 = this.awV.awN;
                aaVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.aa aaVar6 = this.OE;
            editText = this.awV.awH;
            aaVar6.o("smscode", editText.getText().toString());
            String sw = this.OE.sw();
            if (this.OE.sX().tT().qa()) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.parserJson(sw);
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
        progressBar = this.awV.awF;
        progressBar.setVisibility(8);
        this.awV.awL = null;
        this.awV.bt(true);
        z = this.awV.awM;
        if (z) {
            relativeLayout = this.awV.awJ;
            relativeLayout.setEnabled(true);
        }
        if (nVar != null) {
            this.awV.a(nVar);
            return;
        }
        String errorString = this.OE.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.awV.afY;
            textView.setVisibility(0);
            textView2 = this.awV.afY;
            textView2.setText(errorString);
        }
        if (this.OE.tb() == 26) {
            this.awV.awS = 26;
            linearLayout = this.awV.awC;
            linearLayout.setBackgroundResource(com.baidu.tieba.p.pass_input_wrong);
            linearLayout2 = this.awV.awC;
            i = this.awV.awQ;
            i2 = this.awV.awR;
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
        progressBar = this.awV.awF;
        progressBar.setVisibility(0);
        relativeLayout = this.awV.awJ;
        relativeLayout.setEnabled(false);
        this.awV.bt(false);
        textView = this.awV.afY;
        textView.setVisibility(4);
        textView2 = this.awV.afY;
        textView2.setText((CharSequence) null);
        linearLayout = this.awV.awC;
        linearLayout.setBackgroundResource(com.baidu.tieba.p.pass_input);
        linearLayout2 = this.awV.awC;
        i = this.awV.awQ;
        i2 = this.awV.awR;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.awV.awL = null;
        progressBar = this.awV.awF;
        progressBar.setVisibility(8);
        z = this.awV.awM;
        if (z) {
            relativeLayout = this.awV.awJ;
            relativeLayout.setEnabled(true);
        }
        if (this.OE != null) {
            this.OE.gS();
        }
        this.awV.bt(true);
        super.cancel(true);
    }
}
