package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private String aLY;
    final /* synthetic */ CreateBarActivity aMa;
    private String mVcode;
    private ac yV = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
        }
        progressBar = this.aMa.mProgress;
        progressBar.setVisibility(8);
        this.aMa.aLS = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aMa = createBarActivity;
        this.aLY = null;
        this.mVcode = null;
        this.aLY = str;
        this.mVcode = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.yV.mc().na().mIsNeedTbs = true;
            this.yV.k("kw", this.aLY);
            this.yV.k("vcode", this.mVcode);
            ac acVar = this.yV;
            str = this.aMa.aLU;
            acVar.k("vcode_md5", str);
            this.yV.lA();
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
        progressBar = this.aMa.mProgress;
        progressBar.setVisibility(8);
        this.aMa.aLS = null;
        if (this.yV.mc().nb().jq()) {
            CreateBarSuccessActivity.startActivity(this.aMa, this.aLY);
            this.aMa.finish();
            return;
        }
        this.aMa.showToast(this.yV.getErrorString());
        if (this.yV.mf()) {
            this.aMa.ID();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aMa.mProgress;
        progressBar.setVisibility(0);
    }
}
