package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private ad CU = null;
    private String aPu;
    final /* synthetic */ CreateBarActivity aPw;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.CU != null) {
            this.CU.dJ();
        }
        progressBar = this.aPw.mProgress;
        progressBar.setVisibility(8);
        this.aPw.aPo = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aPw = createBarActivity;
        this.aPu = null;
        this.mVcode = null;
        this.aPu = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.CU.oS().pZ().mIsNeedTbs = true;
            this.CU.o("kw", this.aPu);
            this.CU.o("vcode", this.mVcode);
            ad adVar = this.CU;
            str = this.aPw.aPq;
            adVar.o("vcode_md5", str);
            this.CU.or();
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((c) str);
        progressBar = this.aPw.mProgress;
        progressBar.setVisibility(8);
        this.aPw.aPo = null;
        if (this.CU.oS().qa().lT()) {
            CreateBarSuccessActivity.K(this.aPw.getPageContext().getPageActivity(), this.aPu);
            this.aPw.finish();
            return;
        }
        this.aPw.showToast(this.CU.getErrorString());
        if (this.CU.oV()) {
            this.aPw.Jt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aPw.mProgress;
        progressBar.setVisibility(0);
    }
}
