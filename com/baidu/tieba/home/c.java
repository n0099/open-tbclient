package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private ad CV = null;
    private String aOm;
    final /* synthetic */ CreateBarActivity aOo;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.CV != null) {
            this.CV.dL();
        }
        progressBar = this.aOo.mProgress;
        progressBar.setVisibility(8);
        this.aOo.aOg = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aOo = createBarActivity;
        this.aOm = null;
        this.mVcode = null;
        this.aOm = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.CV.oW().pV().mIsNeedTbs = true;
            this.CV.o("kw", this.aOm);
            this.CV.o("vcode", this.mVcode);
            ad adVar = this.CV;
            str = this.aOo.aOi;
            adVar.o("vcode_md5", str);
            this.CV.ov();
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
        progressBar = this.aOo.mProgress;
        progressBar.setVisibility(8);
        this.aOo.aOg = null;
        if (this.CV.oW().pW().ma()) {
            CreateBarSuccessActivity.L(this.aOo.getPageContext().getPageActivity(), this.aOm);
            this.aOo.finish();
            return;
        }
        this.aOo.showToast(this.CV.getErrorString());
        if (this.CV.oZ()) {
            this.aOo.Ja();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aOo.mProgress;
        progressBar.setVisibility(0);
    }
}
