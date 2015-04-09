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
    private com.baidu.tbadk.core.util.aa Ok;
    final /* synthetic */ Register2Activity awk;

    private ah(Register2Activity register2Activity) {
        this.awk = register2Activity;
        this.Ok = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(Register2Activity register2Activity, ah ahVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.awk.awg = null;
        progressBar = this.awk.mProgressBar;
        progressBar.setVisibility(8);
        this.awk.Ev();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Ew;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Ew = this.awk.Ew();
            this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.Ok.o("un", Ew.getName());
            this.Ok.o("phonenum", Ew.getPhone());
            this.Ok.o("passwd", Ew.getPsw());
            if (Ew.getVcode() != null) {
                this.Ok.o("vcode", Ew.getVcode());
            }
            if (Ew.getVcodeMd5() != null) {
                this.Ok.o("vcode_md5", Ew.getVcodeMd5());
            }
            String rO = this.Ok.rO();
            if ((this.Ok.ss() && (this.Ok.st() == 0 || this.Ok.st() == 36)) || this.Ok.st() == 5) {
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
        RegistData Ew;
        int i;
        int i2;
        int i3;
        super.onPostExecute(nVar);
        this.awk.awg = null;
        progressBar = this.awk.mProgressBar;
        progressBar.setVisibility(8);
        this.awk.Ev();
        this.awk.awh = nVar;
        if (!this.Ok.ss()) {
            this.awk.awd = -1;
            this.awk.mErrorString = this.Ok.getErrorString();
            this.awk.Eu();
        } else if (this.Ok.st() == 36) {
            this.awk.r(nVar.qf());
            Register2Activity register2Activity = this.awk;
            i3 = Register2Activity.avz;
            register2Activity.awd = i3;
            this.awk.mErrorString = this.Ok.getErrorString();
            this.awk.Eu();
        } else if (this.Ok.st() == 5) {
            Register2Activity register2Activity2 = this.awk;
            i2 = Register2Activity.avC;
            register2Activity2.awd = i2;
            this.awk.bl(true);
        } else if (this.Ok.st() == 0) {
            Ew = this.awk.Ew();
            Activity pageActivity = this.awk.getPageContext().getPageActivity();
            i = Register2Activity.avy;
            ActivationActivity.a(pageActivity, Ew, i);
            this.awk.bl(false);
        } else {
            this.awk.awd = this.Ok.st();
            this.awk.mErrorString = this.Ok.getErrorString();
            this.awk.Eu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.awk.mProgressBar;
        progressBar.setVisibility(0);
        this.awk.Es();
        this.awk.awd = -1;
        this.awk.mErrorString = null;
        this.awk.Eu();
        linearLayout = this.awk.avV;
        linearLayout.setVisibility(8);
        textView = this.awk.avO;
        textView.setVisibility(4);
        textView2 = this.awk.avO;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
