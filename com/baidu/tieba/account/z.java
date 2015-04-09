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
    private com.baidu.tbadk.core.util.aa Ok;
    final /* synthetic */ ActivationActivity avu;

    private z(ActivationActivity activationActivity) {
        this.avu = activationActivity;
        this.Ok = null;
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
            this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.aa aaVar = this.Ok;
            registData = this.avu.avl;
            aaVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.aa aaVar2 = this.Ok;
            registData2 = this.avu.avl;
            aaVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.aa aaVar3 = this.Ok;
            registData3 = this.avu.avl;
            aaVar3.o("passwd", registData3.getPsw());
            registData4 = this.avu.avl;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.aa aaVar4 = this.Ok;
                registData7 = this.avu.avl;
                aaVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.avu.avl;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.aa aaVar5 = this.Ok;
                registData6 = this.avu.avl;
                aaVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.aa aaVar6 = this.Ok;
            editText = this.avu.avf;
            aaVar6.o("smscode", editText.getText().toString());
            String rO = this.Ok.rO();
            if (this.Ok.sp().tq().pv()) {
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
        progressBar = this.avu.avd;
        progressBar.setVisibility(8);
        this.avu.avj = null;
        this.avu.bk(true);
        z = this.avu.avk;
        if (z) {
            relativeLayout = this.avu.avh;
            relativeLayout.setEnabled(true);
        }
        if (nVar != null) {
            this.avu.a(nVar);
            return;
        }
        String errorString = this.Ok.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.avu.aeW;
            textView.setVisibility(0);
            textView2 = this.avu.aeW;
            textView2.setText(errorString);
        }
        if (this.Ok.st() == 26) {
            this.avu.avr = 26;
            linearLayout = this.avu.ava;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input_wrong);
            linearLayout2 = this.avu.ava;
            i = this.avu.avp;
            i2 = this.avu.avq;
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
        progressBar = this.avu.avd;
        progressBar.setVisibility(0);
        relativeLayout = this.avu.avh;
        relativeLayout.setEnabled(false);
        this.avu.bk(false);
        textView = this.avu.aeW;
        textView.setVisibility(4);
        textView2 = this.avu.aeW;
        textView2.setText((CharSequence) null);
        linearLayout = this.avu.ava;
        linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
        linearLayout2 = this.avu.ava;
        i = this.avu.avp;
        i2 = this.avu.avq;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.avu.avj = null;
        progressBar = this.avu.avd;
        progressBar.setVisibility(8);
        z = this.avu.avk;
        if (z) {
            relativeLayout = this.avu.avh;
            relativeLayout.setEnabled(true);
        }
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.avu.bk(true);
        super.cancel(true);
    }
}
