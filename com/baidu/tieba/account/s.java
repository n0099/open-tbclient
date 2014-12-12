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
public class s extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.m> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ ActivationActivity amw;

    private s(ActivationActivity activationActivity) {
        this.amw = activationActivity;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ActivationActivity activationActivity, s sVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tbadk.core.data.m doInBackground(String... strArr) {
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
            registData = this.amw.amn;
            adVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.ad adVar2 = this.AR;
            registData2 = this.amw.amn;
            adVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ad adVar3 = this.AR;
            registData3 = this.amw.amn;
            adVar3.o("passwd", registData3.getPsw());
            registData4 = this.amw.amn;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ad adVar4 = this.AR;
                registData7 = this.amw.amn;
                adVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.amw.amn;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ad adVar5 = this.AR;
                registData6 = this.amw.amn;
                adVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ad adVar6 = this.AR;
            editText = this.amw.amh;
            adVar6.o("smscode", editText.getText().toString());
            String ov = this.AR.ov();
            if (this.AR.oW().pW().ma()) {
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.parserJson(ov);
                return mVar;
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
    public void onPostExecute(com.baidu.tbadk.core.data.m mVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(mVar);
        progressBar = this.amw.amf;
        progressBar.setVisibility(8);
        this.amw.aml = null;
        this.amw.be(true);
        z = this.amw.amm;
        if (z) {
            relativeLayout = this.amw.amj;
            relativeLayout.setEnabled(true);
        }
        if (mVar != null) {
            this.amw.b(mVar);
            return;
        }
        String errorString = this.AR.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.amw.Uh;
            textView.setVisibility(0);
            textView2 = this.amw.Uh;
            textView2.setText(errorString);
        }
        if (this.AR.pa() == 26) {
            this.amw.amt = 26;
            linearLayout = this.amw.amc;
            linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input_wrong);
            linearLayout2 = this.amw.amc;
            i = this.amw.amr;
            i2 = this.amw.ams;
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
        progressBar = this.amw.amf;
        progressBar.setVisibility(0);
        relativeLayout = this.amw.amj;
        relativeLayout.setEnabled(false);
        this.amw.be(false);
        textView = this.amw.Uh;
        textView.setVisibility(4);
        textView2 = this.amw.Uh;
        textView2.setText((CharSequence) null);
        linearLayout = this.amw.amc;
        linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input);
        linearLayout2 = this.amw.amc;
        i = this.amw.amr;
        i2 = this.amw.ams;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.amw.aml = null;
        progressBar = this.amw.amf;
        progressBar.setVisibility(8);
        z = this.amw.amm;
        if (z) {
            relativeLayout = this.amw.amj;
            relativeLayout.setEnabled(true);
        }
        if (this.AR != null) {
            this.AR.dL();
        }
        this.amw.be(true);
        super.cancel(true);
    }
}
