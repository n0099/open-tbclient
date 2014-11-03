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
    final /* synthetic */ Register2Activity afR;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private z(Register2Activity register2Activity) {
        this.afR = register2Activity;
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
        this.afR.afN = null;
        progressBar = this.afR.mProgressBar;
        progressBar.setVisibility(8);
        this.afR.xm();
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public com.baidu.tbadk.core.data.j doInBackground(String... strArr) {
        RegistData xn;
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        try {
            xn = this.afR.xn();
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
            this.mNetWork.k("un", xn.getName());
            this.mNetWork.k("phonenum", xn.getPhone());
            this.mNetWork.k("passwd", xn.getPsw());
            if (xn.getVcode() != null) {
                this.mNetWork.k("vcode", xn.getVcode());
            }
            if (xn.getVcodeMd5() != null) {
                this.mNetWork.k("vcode_md5", xn.getVcodeMd5());
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
        RegistData xn;
        int i;
        int i2;
        int i3;
        super.onPostExecute(jVar);
        this.afR.afN = null;
        progressBar = this.afR.mProgressBar;
        progressBar.setVisibility(8);
        this.afR.xm();
        this.afR.afO = jVar;
        if (!this.mNetWork.mf()) {
            this.afR.afK = -1;
            this.afR.mErrorString = this.mNetWork.getErrorString();
            this.afR.xl();
        } else if (this.mNetWork.mg() == 36) {
            this.afR.j(jVar.ka());
            Register2Activity register2Activity = this.afR;
            i3 = Register2Activity.afk;
            register2Activity.afK = i3;
            this.afR.mErrorString = this.mNetWork.getErrorString();
            this.afR.xl();
        } else if (this.mNetWork.mg() == 5) {
            Register2Activity register2Activity2 = this.afR;
            i2 = Register2Activity.afn;
            register2Activity2.afK = i2;
            this.afR.bg(true);
        } else if (this.mNetWork.mg() == 0) {
            xn = this.afR.xn();
            Register2Activity register2Activity3 = this.afR;
            i = Register2Activity.afj;
            ActivationActivity.a(register2Activity3, xn, i);
            this.afR.bg(false);
        } else {
            this.afR.afK = this.mNetWork.mg();
            this.afR.mErrorString = this.mNetWork.getErrorString();
            this.afR.xl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        progressBar = this.afR.mProgressBar;
        progressBar.setVisibility(0);
        this.afR.xj();
        this.afR.afK = -1;
        this.afR.mErrorString = null;
        this.afR.xl();
        linearLayout = this.afR.afD;
        linearLayout.setVisibility(8);
        textView = this.afR.KK;
        textView.setVisibility(4);
        textView2 = this.afR.KK;
        textView2.setText((CharSequence) null);
        super.onPreExecute();
    }
}
