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
    private com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ Register2Activity aoa;

    private ab(Register2Activity register2Activity) {
        this.aoa = register2Activity;
        this.AO = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(Register2Activity register2Activity, ab abVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.aoa.anW = null;
        progressBar = this.aoa.mProgressBar;
        progressBar.setVisibility(8);
        this.aoa.AZ();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
        RegistData Ba;
        com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
        try {
            Ba = this.aoa.Ba();
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.AO.o("un", Ba.getName());
            this.AO.o("phonenum", Ba.getPhone());
            this.AO.o("passwd", Ba.getPsw());
            if (Ba.getVcode() != null) {
                this.AO.o("vcode", Ba.getVcode());
            }
            if (Ba.getVcodeMd5() != null) {
                this.AO.o("vcode_md5", Ba.getVcodeMd5());
            }
            String or = this.AO.or();
            if ((this.AO.oV() && (this.AO.oW() == 0 || this.AO.oW() == 36)) || this.AO.oW() == 5) {
                com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                nVar2.parserJson(or);
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
        RegistData Ba;
        int i;
        int i2;
        int i3;
        super.onPostExecute(nVar);
        this.aoa.anW = null;
        progressBar = this.aoa.mProgressBar;
        progressBar.setVisibility(8);
        this.aoa.AZ();
        this.aoa.anX = nVar;
        if (!this.AO.oV()) {
            this.aoa.anT = -1;
            this.aoa.mErrorString = this.AO.getErrorString();
            this.aoa.AY();
        } else if (this.AO.oW() == 36) {
            this.aoa.u(nVar.mL());
            Register2Activity register2Activity = this.aoa;
            i3 = Register2Activity.ant;
            register2Activity.anT = i3;
            this.aoa.mErrorString = this.AO.getErrorString();
            this.aoa.AY();
        } else if (this.AO.oW() == 5) {
            Register2Activity register2Activity2 = this.aoa;
            i2 = Register2Activity.anw;
            register2Activity2.anT = i2;
            this.aoa.bh(true);
        } else if (this.AO.oW() == 0) {
            Ba = this.aoa.Ba();
            Activity pageActivity = this.aoa.getPageContext().getPageActivity();
            i = Register2Activity.ans;
            ActivationActivity.a(pageActivity, Ba, i);
            this.aoa.bh(false);
        } else {
            this.aoa.anT = this.AO.oW();
            this.aoa.mErrorString = this.AO.getErrorString();
            this.aoa.AY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.aoa.mProgressBar;
        progressBar.setVisibility(0);
        this.aoa.AW();
        this.aoa.anT = -1;
        this.aoa.mErrorString = null;
        this.aoa.AY();
        linearLayout = this.aoa.anM;
        linearLayout.setVisibility(8);
        textView = this.aoa.Qs;
        textView.setVisibility(4);
        textView2 = this.aoa.Qs;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
