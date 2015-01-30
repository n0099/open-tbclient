package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private ad CX = null;
    private String aPv;
    final /* synthetic */ CreateBarActivity aPx;
    private String mVcode;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.CX != null) {
            this.CX.dJ();
        }
        progressBar = this.aPx.mProgress;
        progressBar.setVisibility(8);
        this.aPx.aPp = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aPx = createBarActivity;
        this.aPv = null;
        this.mVcode = null;
        this.aPv = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.CX = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.CX.oZ().qg().mIsNeedTbs = true;
            this.CX.o("kw", this.aPv);
            this.CX.o("vcode", this.mVcode);
            ad adVar = this.CX;
            str = this.aPx.aPr;
            adVar.o("vcode_md5", str);
            this.CX.oy();
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
        progressBar = this.aPx.mProgress;
        progressBar.setVisibility(8);
        this.aPx.aPp = null;
        if (this.CX.oZ().qh().ma()) {
            CreateBarSuccessActivity.K(this.aPx.getPageContext().getPageActivity(), this.aPv);
            this.aPx.finish();
            return;
        }
        this.aPx.showToast(this.CX.getErrorString());
        if (this.CX.pc()) {
            this.aPx.Jy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aPx.mProgress;
        progressBar.setVisibility(0);
    }
}
