package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private aa ZD = null;
    private String aVP;
    final /* synthetic */ CreateBarActivity aVR;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.ZD != null) {
            this.ZD.hh();
        }
        progressBar = this.aVR.mProgress;
        progressBar.setVisibility(8);
        this.aVR.aVJ = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aVR = createBarActivity;
        this.aVP = null;
        this.mVcode = null;
        this.aVP = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.ZD.sp().tp().mIsNeedTbs = true;
            this.ZD.o("kw", this.aVP);
            this.ZD.o("vcode", this.mVcode);
            aa aaVar = this.ZD;
            str = this.aVR.aVL;
            aaVar.o("vcode_md5", str);
            this.ZD.rO();
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
        progressBar = this.aVR.mProgress;
        progressBar.setVisibility(8);
        this.aVR.aVJ = null;
        if (this.ZD.sp().tq().pv()) {
            CreateBarSuccessActivity.J(this.aVR.getPageContext().getPageActivity(), this.aVP);
            this.aVR.finish();
            return;
        }
        this.aVR.showToast(this.ZD.getErrorString());
        if (this.ZD.ss()) {
            this.aVR.Nj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aVR.mProgress;
        progressBar.setVisibility(0);
    }
}
