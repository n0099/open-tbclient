package com.baidu.tieba.account;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.aa Oi;
    final /* synthetic */ Register2Activity awc;

    private ah(Register2Activity register2Activity) {
        this.awc = register2Activity;
        this.Oi = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(Register2Activity register2Activity, ah ahVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.awc.avY = null;
        progressBar = this.awc.mProgressBar;
        progressBar.setVisibility(8);
        this.awc.Ep();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Eq;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Eq = this.awc.Eq();
            this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.Oi.o("un", Eq.getName());
            this.Oi.o("phonenum", Eq.getPhone());
            this.Oi.o("passwd", Eq.getPsw());
            if (Eq.getVcode() != null) {
                this.Oi.o("vcode", Eq.getVcode());
            }
            if (Eq.getVcodeMd5() != null) {
                this.Oi.o("vcode_md5", Eq.getVcodeMd5());
            }
            String rO = this.Oi.rO();
            if ((this.Oi.ss() && (this.Oi.st() == 0 || this.Oi.st() == 36)) || this.Oi.st() == 5) {
                com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                nVar2.parserJson(rO);
                return nVar2;
            }
            return nVar;
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
        RegistData Eq;
        int i;
        int i2;
        int i3;
        super.onPostExecute(nVar);
        this.awc.avY = null;
        progressBar = this.awc.mProgressBar;
        progressBar.setVisibility(8);
        this.awc.Ep();
        this.awc.avZ = nVar;
        if (!this.Oi.ss()) {
            this.awc.avV = -1;
            this.awc.mErrorString = this.Oi.getErrorString();
            this.awc.Eo();
        } else if (this.Oi.st() == 36) {
            this.awc.r(nVar.qf());
            Register2Activity register2Activity = this.awc;
            i3 = Register2Activity.avr;
            register2Activity.avV = i3;
            this.awc.mErrorString = this.Oi.getErrorString();
            this.awc.Eo();
        } else if (this.Oi.st() == 5) {
            Register2Activity register2Activity2 = this.awc;
            i2 = Register2Activity.avu;
            register2Activity2.avV = i2;
            this.awc.bl(true);
        } else if (this.Oi.st() == 0) {
            Eq = this.awc.Eq();
            Activity pageActivity = this.awc.getPageContext().getPageActivity();
            i = Register2Activity.avq;
            ActivationActivity.a(pageActivity, Eq, i);
            this.awc.bl(false);
        } else {
            this.awc.avV = this.Oi.st();
            this.awc.mErrorString = this.Oi.getErrorString();
            this.awc.Eo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.awc.mProgressBar;
        progressBar.setVisibility(0);
        this.awc.Em();
        this.awc.avV = -1;
        this.awc.mErrorString = null;
        this.awc.Eo();
        linearLayout = this.awc.avN;
        linearLayout.setVisibility(8);
        textView = this.awc.avG;
        textView.setVisibility(4);
        textView2 = this.awc.avG;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
