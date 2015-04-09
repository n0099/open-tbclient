package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private aa ZF = null;
    private String aWf;
    final /* synthetic */ CreateBarActivity aWh;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.ZF != null) {
            this.ZF.hh();
        }
        progressBar = this.aWh.mProgress;
        progressBar.setVisibility(8);
        this.aWh.aVZ = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aWh = createBarActivity;
        this.aWf = null;
        this.mVcode = null;
        this.aWf = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.ZF.sp().tp().mIsNeedTbs = true;
            this.ZF.o("kw", this.aWf);
            this.ZF.o("vcode", this.mVcode);
            aa aaVar = this.ZF;
            str = this.aWh.aWb;
            aaVar.o("vcode_md5", str);
            this.ZF.rO();
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
        progressBar = this.aWh.mProgress;
        progressBar.setVisibility(8);
        this.aWh.aVZ = null;
        if (this.ZF.sp().tq().pv()) {
            CreateBarSuccessActivity.J(this.aWh.getPageContext().getPageActivity(), this.aWf);
            this.aWh.finish();
            return;
        }
        this.aWh.showToast(this.ZF.getErrorString());
        if (this.ZF.ss()) {
            this.aWh.Nw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aWh.mProgress;
        progressBar.setVisibility(0);
    }
}
