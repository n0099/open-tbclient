package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.ad CV = null;
    final /* synthetic */ t Uo;
    private String mAccount;
    private String mUrl;

    public z(t tVar, String str, String str2) {
        this.Uo = tVar;
        this.mUrl = null;
        this.mAccount = null;
        this.mUrl = str;
        this.mAccount = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        super.cancel(true);
        progressBar = this.Uo.Ui;
        progressBar.setVisibility(8);
        button = this.Uo.Ue;
        button.setEnabled(true);
        this.Uo.Ug = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.CV = new com.baidu.tbadk.core.util.ad(this.mUrl);
        this.CV.o("un", this.mAccount);
        String ov = this.CV.ov();
        if (!this.CV.oZ() || this.CV.pa() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(ov);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        ProgressBar progressBar;
        Button button;
        BaseActivity baseActivity;
        super.onPostExecute(aVar);
        this.Uo.Ug = null;
        progressBar = this.Uo.Ui;
        progressBar.setVisibility(8);
        button = this.Uo.Ue;
        button.setEnabled(true);
        if (!this.CV.oZ()) {
            this.Uo.dI(this.CV.getErrorString());
        } else if (this.CV.pa() == 0) {
            t tVar = this.Uo;
            baseActivity = this.Uo.Ud;
            tVar.dI(baseActivity.getPageContext().getString(com.baidu.tieba.z.name_not_use));
        } else if (this.CV.pa() == 36) {
            this.Uo.dI(this.CV.getErrorString());
            if (aVar != null) {
                this.Uo.t(aVar.mQ());
            }
        } else {
            this.Uo.dI(this.CV.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.Uo.Ui;
        progressBar.setVisibility(0);
        button = this.Uo.Ue;
        button.setEnabled(false);
        this.Uo.dI(null);
        this.Uo.tu();
        super.onPreExecute();
    }
}
