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
public class am extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.aa OE;
    final /* synthetic */ Register2Activity axQ;

    private am(Register2Activity register2Activity) {
        this.axQ = register2Activity;
        this.OE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(Register2Activity register2Activity, am amVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.OE != null) {
            this.OE.gS();
        }
        this.axQ.axM = null;
        progressBar = this.axQ.mProgressBar;
        progressBar.setVisibility(8);
        this.axQ.Fn();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Fo;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Fo = this.axQ.Fo();
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.OE.o("un", Fo.getName());
            this.OE.o("phonenum", Fo.getPhone());
            this.OE.o("passwd", Fo.getPsw());
            if (Fo.getVcode() != null) {
                this.OE.o("vcode", Fo.getVcode());
            }
            if (Fo.getVcodeMd5() != null) {
                this.OE.o("vcode_md5", Fo.getVcodeMd5());
            }
            String sw = this.OE.sw();
            if ((this.OE.ta() && (this.OE.tb() == 0 || this.OE.tb() == 36)) || this.OE.tb() == 5) {
                com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                nVar2.parserJson(sw);
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
        RegistData Fo;
        int i;
        int i2;
        int i3;
        int i4;
        super.onPostExecute(nVar);
        this.axQ.axM = null;
        progressBar = this.axQ.mProgressBar;
        progressBar.setVisibility(8);
        this.axQ.Fn();
        this.axQ.axN = nVar;
        if (!this.OE.ta()) {
            this.axQ.axJ = -1;
            this.axQ.mErrorString = this.OE.getErrorString();
            this.axQ.Fm();
        } else if (this.OE.tb() == 36) {
            this.axQ.p(nVar.qL());
            Register2Activity register2Activity = this.axQ;
            i4 = Register2Activity.axf;
            register2Activity.axJ = i4;
            this.axQ.mErrorString = this.OE.getErrorString();
            this.axQ.Fm();
        } else if (this.OE.tb() == 5) {
            Register2Activity register2Activity2 = this.axQ;
            i3 = Register2Activity.axi;
            register2Activity2.axJ = i3;
            this.axQ.bu(true);
        } else if (this.OE.tb() != 0) {
            this.axQ.axJ = this.OE.tb();
            this.axQ.mErrorString = this.OE.getErrorString();
            this.axQ.Fm();
        } else {
            Fo = this.axQ.Fo();
            i = this.axQ.mFrom;
            boolean z = i == 3;
            Activity pageActivity = this.axQ.getPageContext().getPageActivity();
            i2 = Register2Activity.axe;
            ActivationActivity.a(pageActivity, Fo, i2, z);
            this.axQ.bu(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.axQ.mProgressBar;
        progressBar.setVisibility(0);
        this.axQ.Fk();
        this.axQ.axJ = -1;
        this.axQ.mErrorString = null;
        this.axQ.Fm();
        linearLayout = this.axQ.axB;
        linearLayout.setVisibility(8);
        textView = this.axQ.axu;
        textView.setVisibility(4);
        textView2 = this.axQ.axu;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
