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
public class aa extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.m> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ Register2Activity ani;

    private aa(Register2Activity register2Activity) {
        this.ani = register2Activity;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(Register2Activity register2Activity, aa aaVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AR != null) {
            this.AR.dL();
        }
        this.ani.ane = null;
        progressBar = this.ani.mProgressBar;
        progressBar.setVisibility(8);
        this.ani.AF();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public com.baidu.tbadk.core.data.m doInBackground(String... strArr) {
        RegistData AG;
        com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
        try {
            AG = this.ani.AG();
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.AR.o("un", AG.getName());
            this.AR.o("phonenum", AG.getPhone());
            this.AR.o("passwd", AG.getPsw());
            if (AG.getVcode() != null) {
                this.AR.o("vcode", AG.getVcode());
            }
            if (AG.getVcodeMd5() != null) {
                this.AR.o("vcode_md5", AG.getVcodeMd5());
            }
            String ov = this.AR.ov();
            if ((this.AR.oZ() && (this.AR.pa() == 0 || this.AR.pa() == 36)) || this.AR.pa() == 5) {
                com.baidu.tbadk.core.data.m mVar2 = new com.baidu.tbadk.core.data.m();
                mVar2.parserJson(ov);
                return mVar2;
            }
            return mVar;
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
        RegistData AG;
        int i;
        int i2;
        int i3;
        super.onPostExecute(mVar);
        this.ani.ane = null;
        progressBar = this.ani.mProgressBar;
        progressBar.setVisibility(8);
        this.ani.AF();
        this.ani.anf = mVar;
        if (!this.AR.oZ()) {
            this.ani.anb = -1;
            this.ani.mErrorString = this.AR.getErrorString();
            this.ani.AE();
        } else if (this.AR.pa() == 36) {
            this.ani.t(mVar.mQ());
            Register2Activity register2Activity = this.ani;
            i3 = Register2Activity.amB;
            register2Activity.anb = i3;
            this.ani.mErrorString = this.AR.getErrorString();
            this.ani.AE();
        } else if (this.AR.pa() == 5) {
            Register2Activity register2Activity2 = this.ani;
            i2 = Register2Activity.amE;
            register2Activity2.anb = i2;
            this.ani.bf(true);
        } else if (this.AR.pa() == 0) {
            AG = this.ani.AG();
            Activity pageActivity = this.ani.getPageContext().getPageActivity();
            i = Register2Activity.amA;
            ActivationActivity.a(pageActivity, AG, i);
            this.ani.bf(false);
        } else {
            this.ani.anb = this.AR.pa();
            this.ani.mErrorString = this.AR.getErrorString();
            this.ani.AE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.ani.mProgressBar;
        progressBar.setVisibility(0);
        this.ani.AC();
        this.ani.anb = -1;
        this.ani.mErrorString = null;
        this.ani.AE();
        linearLayout = this.ani.amU;
        linearLayout.setVisibility(8);
        textView = this.ani.PV;
        textView.setVisibility(4);
        textView2 = this.ani.PV;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
