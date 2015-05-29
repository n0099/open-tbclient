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
    final /* synthetic */ Register2Activity axP;

    private am(Register2Activity register2Activity) {
        this.axP = register2Activity;
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
        this.axP.axL = null;
        progressBar = this.axP.mProgressBar;
        progressBar.setVisibility(8);
        this.axP.Fm();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Fn;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Fn = this.axP.Fn();
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.OE.o("un", Fn.getName());
            this.OE.o("phonenum", Fn.getPhone());
            this.OE.o("passwd", Fn.getPsw());
            if (Fn.getVcode() != null) {
                this.OE.o("vcode", Fn.getVcode());
            }
            if (Fn.getVcodeMd5() != null) {
                this.OE.o("vcode_md5", Fn.getVcodeMd5());
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
        RegistData Fn;
        int i;
        int i2;
        int i3;
        int i4;
        super.onPostExecute(nVar);
        this.axP.axL = null;
        progressBar = this.axP.mProgressBar;
        progressBar.setVisibility(8);
        this.axP.Fm();
        this.axP.axM = nVar;
        if (!this.OE.ta()) {
            this.axP.axI = -1;
            this.axP.mErrorString = this.OE.getErrorString();
            this.axP.Fl();
        } else if (this.OE.tb() == 36) {
            this.axP.p(nVar.qL());
            Register2Activity register2Activity = this.axP;
            i4 = Register2Activity.axe;
            register2Activity.axI = i4;
            this.axP.mErrorString = this.OE.getErrorString();
            this.axP.Fl();
        } else if (this.OE.tb() == 5) {
            Register2Activity register2Activity2 = this.axP;
            i3 = Register2Activity.axh;
            register2Activity2.axI = i3;
            this.axP.bu(true);
        } else if (this.OE.tb() != 0) {
            this.axP.axI = this.OE.tb();
            this.axP.mErrorString = this.OE.getErrorString();
            this.axP.Fl();
        } else {
            Fn = this.axP.Fn();
            i = this.axP.mFrom;
            boolean z = i == 3;
            Activity pageActivity = this.axP.getPageContext().getPageActivity();
            i2 = Register2Activity.axd;
            ActivationActivity.a(pageActivity, Fn, i2, z);
            this.axP.bu(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.axP.mProgressBar;
        progressBar.setVisibility(0);
        this.axP.Fj();
        this.axP.axI = -1;
        this.axP.mErrorString = null;
        this.axP.Fl();
        linearLayout = this.axP.axA;
        linearLayout.setVisibility(8);
        textView = this.axP.axt;
        textView.setVisibility(4);
        textView2 = this.axP.axt;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
