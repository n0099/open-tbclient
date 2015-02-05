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
    private com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ ActivationActivity ann;

    private t(ActivationActivity activationActivity) {
        this.ann = activationActivity;
        this.AO = null;
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
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            com.baidu.tbadk.core.util.ad adVar = this.AO;
            registData = this.ann.ane;
            adVar.o("un", registData.getName());
            com.baidu.tbadk.core.util.ad adVar2 = this.AO;
            registData2 = this.ann.ane;
            adVar2.o("phonenum", registData2.getPhone());
            com.baidu.tbadk.core.util.ad adVar3 = this.AO;
            registData3 = this.ann.ane;
            adVar3.o("passwd", registData3.getPsw());
            registData4 = this.ann.ane;
            if (registData4.getVcode() != null) {
                com.baidu.tbadk.core.util.ad adVar4 = this.AO;
                registData7 = this.ann.ane;
                adVar4.o("vcode", registData7.getVcode());
            }
            registData5 = this.ann.ane;
            if (registData5.getVcodeMd5() != null) {
                com.baidu.tbadk.core.util.ad adVar5 = this.AO;
                registData6 = this.ann.ane;
                adVar5.o("vcode_md5", registData6.getVcodeMd5());
            }
            com.baidu.tbadk.core.util.ad adVar6 = this.AO;
            editText = this.ann.amY;
            adVar6.o("smscode", editText.getText().toString());
            String or = this.AO.or();
            if (this.AO.oS().qa().lT()) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.parserJson(or);
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
        progressBar = this.ann.amW;
        progressBar.setVisibility(8);
        this.ann.anc = null;
        this.ann.bg(true);
        z = this.ann.and;
        if (z) {
            relativeLayout = this.ann.ana;
            relativeLayout.setEnabled(true);
        }
        if (nVar != null) {
            this.ann.b(nVar);
            return;
        }
        String errorString = this.AO.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.ann.UK;
            textView.setVisibility(0);
            textView2 = this.ann.UK;
            textView2.setText(errorString);
        }
        if (this.AO.oW() == 26) {
            this.ann.ank = 26;
            linearLayout = this.ann.amT;
            linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input_wrong);
            linearLayout2 = this.ann.amT;
            i = this.ann.ani;
            i2 = this.ann.anj;
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
        progressBar = this.ann.amW;
        progressBar.setVisibility(0);
        relativeLayout = this.ann.ana;
        relativeLayout.setEnabled(false);
        this.ann.bg(false);
        textView = this.ann.UK;
        textView.setVisibility(4);
        textView2 = this.ann.UK;
        textView2.setText((CharSequence) null);
        linearLayout = this.ann.amT;
        linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input);
        linearLayout2 = this.ann.amT;
        i = this.ann.ani;
        i2 = this.ann.anj;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.ann.anc = null;
        progressBar = this.ann.amW;
        progressBar.setVisibility(8);
        z = this.ann.and;
        if (z) {
            relativeLayout = this.ann.ana;
            relativeLayout.setEnabled(true);
        }
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.ann.bg(true);
        super.cancel(true);
    }
}
