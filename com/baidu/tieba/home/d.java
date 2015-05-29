package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    private String aYK;
    final /* synthetic */ CreateBarActivity aYM;
    private aa aaG = null;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.aaG != null) {
            this.aaG.gS();
        }
        progressBar = this.aYM.mProgress;
        progressBar.setVisibility(8);
        this.aYM.aYE = null;
    }

    public d(CreateBarActivity createBarActivity, String str, String str2) {
        this.aYM = createBarActivity;
        this.aYK = null;
        this.mVcode = null;
        this.aYK = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.aaG.sX().tS().mIsNeedTbs = true;
            this.aaG.o("kw", this.aYK);
            this.aaG.o("vcode", this.mVcode);
            aa aaVar = this.aaG;
            str = this.aYM.aYG;
            aaVar.o("vcode_md5", str);
            this.aaG.sw();
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
        super.onPostExecute((d) str);
        progressBar = this.aYM.mProgress;
        progressBar.setVisibility(8);
        this.aYM.aYE = null;
        if (this.aaG.sX().tT().qa()) {
            CreateBarSuccessActivity.L(this.aYM.getPageContext().getPageActivity(), this.aYK);
            this.aYM.finish();
            return;
        }
        this.aYM.showToast(this.aaG.getErrorString());
        if (this.aaG.ta()) {
            this.aYM.OL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aYM.mProgress;
        progressBar.setVisibility(0);
    }
}
