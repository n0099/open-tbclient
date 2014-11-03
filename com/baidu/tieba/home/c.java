package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    private String aMm;
    final /* synthetic */ CreateBarActivity aMo;
    private String mVcode;
    private ac yV = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
        }
        progressBar = this.aMo.mProgress;
        progressBar.setVisibility(8);
        this.aMo.aMg = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.aMo = createBarActivity;
        this.aMm = null;
        this.mVcode = null;
        this.aMm = str;
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
            this.yV.k("kw", this.aMm);
            this.yV.k("vcode", this.mVcode);
            ac acVar = this.yV;
            str = this.aMo.aMi;
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
        progressBar = this.aMo.mProgress;
        progressBar.setVisibility(8);
        this.aMo.aMg = null;
        if (this.yV.mc().nb().jq()) {
            CreateBarSuccessActivity.startActivity(this.aMo, this.aMm);
            this.aMo.finish();
            return;
        }
        this.aMo.showToast(this.yV.getErrorString());
        if (this.yV.mf()) {
            this.aMo.IH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.aMo.mProgress;
        progressBar.setVisibility(0);
    }
}
