package com.baidu.tieba.account;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ Register2Activity aod;

    private ab(Register2Activity register2Activity) {
        this.aod = register2Activity;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(Register2Activity register2Activity, ab abVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.aod.anZ = null;
        progressBar = this.aod.mProgressBar;
        progressBar.setVisibility(8);
        this.aod.Bf();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Bg;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Bg = this.aod.Bg();
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.AR.o("un", Bg.getName());
            this.AR.o("phonenum", Bg.getPhone());
            this.AR.o("passwd", Bg.getPsw());
            if (Bg.getVcode() != null) {
                this.AR.o("vcode", Bg.getVcode());
            }
            if (Bg.getVcodeMd5() != null) {
                this.AR.o("vcode_md5", Bg.getVcodeMd5());
            }
            String oy = this.AR.oy();
            if ((this.AR.pc() && (this.AR.pd() == 0 || this.AR.pd() == 36)) || this.AR.pd() == 5) {
                com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                nVar2.parserJson(oy);
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
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.n nVar) {
        ProgressBar progressBar;
        RegistData Bg;
        int i;
        int i2;
        int i3;
        super.onPostExecute(nVar);
        this.aod.anZ = null;
        progressBar = this.aod.mProgressBar;
        progressBar.setVisibility(8);
        this.aod.Bf();
        this.aod.aoa = nVar;
        if (!this.AR.pc()) {
            this.aod.anW = -1;
            this.aod.mErrorString = this.AR.getErrorString();
            this.aod.Be();
        } else if (this.AR.pd() == 36) {
            this.aod.u(nVar.mS());
            Register2Activity register2Activity = this.aod;
            i3 = Register2Activity.anw;
            register2Activity.anW = i3;
            this.aod.mErrorString = this.AR.getErrorString();
            this.aod.Be();
        } else if (this.AR.pd() == 5) {
            Register2Activity register2Activity2 = this.aod;
            i2 = Register2Activity.anz;
            register2Activity2.anW = i2;
            this.aod.bh(true);
        } else if (this.AR.pd() == 0) {
            Bg = this.aod.Bg();
            Activity pageActivity = this.aod.getPageContext().getPageActivity();
            i = Register2Activity.anv;
            ActivationActivity.a(pageActivity, Bg, i);
            this.aod.bh(false);
        } else {
            this.aod.anW = this.AR.pd();
            this.aod.mErrorString = this.AR.getErrorString();
            this.aod.Be();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.aod.mProgressBar;
        progressBar.setVisibility(0);
        this.aod.Bc();
        this.aod.anW = -1;
        this.aod.mErrorString = null;
        this.aod.Be();
        linearLayout = this.aod.anP;
        linearLayout.setVisibility(8);
        textView = this.aod.Qv;
        textView.setVisibility(4);
        textView2 = this.aod.Qv;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
