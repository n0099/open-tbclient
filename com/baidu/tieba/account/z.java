package com.baidu.tieba.account;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.j> {
    final /* synthetic */ Register2Activity afJ;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private z(Register2Activity register2Activity) {
        this.afJ = register2Activity;
        this.mNetWork = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(Register2Activity register2Activity, z zVar) {
        this(register2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.afJ.afF = null;
        progressBar = this.afJ.mProgressBar;
        progressBar.setVisibility(8);
        this.afJ.xk();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public com.baidu.tbadk.core.data.j doInBackground(String... strArr) {
        RegistData xl;
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        try {
            xl = this.afJ.xl();
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.mNetWork.k("un", xl.getName());
            this.mNetWork.k("phonenum", xl.getPhone());
            this.mNetWork.k("passwd", xl.getPsw());
            if (xl.getVcode() != null) {
                this.mNetWork.k("vcode", xl.getVcode());
            }
            if (xl.getVcodeMd5() != null) {
                this.mNetWork.k("vcode_md5", xl.getVcodeMd5());
            }
            String lA = this.mNetWork.lA();
            if ((this.mNetWork.mf() && (this.mNetWork.mg() == 0 || this.mNetWork.mg() == 36)) || this.mNetWork.mg() == 5) {
                com.baidu.tbadk.core.data.j jVar2 = new com.baidu.tbadk.core.data.j();
                jVar2.parserJson(lA);
                return jVar2;
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.j jVar) {
        ProgressBar progressBar;
        RegistData xl;
        int i;
        int i2;
        int i3;
        super.onPostExecute(jVar);
        this.afJ.afF = null;
        progressBar = this.afJ.mProgressBar;
        progressBar.setVisibility(8);
        this.afJ.xk();
        this.afJ.afG = jVar;
        if (!this.mNetWork.mf()) {
            this.afJ.afC = -1;
            this.afJ.mErrorString = this.mNetWork.getErrorString();
            this.afJ.xj();
        } else if (this.mNetWork.mg() == 36) {
            this.afJ.i(jVar.ka());
            Register2Activity register2Activity = this.afJ;
            i3 = Register2Activity.afc;
            register2Activity.afC = i3;
            this.afJ.mErrorString = this.mNetWork.getErrorString();
            this.afJ.xj();
        } else if (this.mNetWork.mg() == 5) {
            Register2Activity register2Activity2 = this.afJ;
            i2 = Register2Activity.aff;
            register2Activity2.afC = i2;
            this.afJ.bg(true);
        } else if (this.mNetWork.mg() == 0) {
            xl = this.afJ.xl();
            Register2Activity register2Activity3 = this.afJ;
            i = Register2Activity.afb;
            ActivationActivity.a(register2Activity3, xl, i);
            this.afJ.bg(false);
        } else {
            this.afJ.afC = this.mNetWork.mg();
            this.afJ.mErrorString = this.mNetWork.getErrorString();
            this.afJ.xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.afJ.mProgressBar;
        progressBar.setVisibility(0);
        this.afJ.xh();
        this.afJ.afC = -1;
        this.afJ.mErrorString = null;
        this.afJ.xj();
        linearLayout = this.afJ.afv;
        linearLayout.setVisibility(8);
        textView = this.afJ.KJ;
        textView.setVisibility(4);
        textView2 = this.afJ.KJ;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
