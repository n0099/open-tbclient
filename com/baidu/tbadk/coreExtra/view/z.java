package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.ad CU = null;
    final /* synthetic */ t US;
    private String mAccount;
    private String mUrl;

    public z(t tVar, String str, String str2) {
        this.US = tVar;
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
        progressBar = this.US.UL;
        progressBar.setVisibility(8);
        button = this.US.UH;
        button.setEnabled(true);
        this.US.UJ = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.CU = new com.baidu.tbadk.core.util.ad(this.mUrl);
        this.CU.o("un", this.mAccount);
        String or = this.CU.or();
        if (!this.CU.oV() || this.CU.oW() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(or);
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
        this.US.UJ = null;
        progressBar = this.US.UL;
        progressBar.setVisibility(8);
        button = this.US.UH;
        button.setEnabled(true);
        if (!this.CU.oV()) {
            this.US.dE(this.CU.getErrorString());
        } else if (this.CU.oW() == 0) {
            t tVar = this.US;
            baseActivity = this.US.UG;
            tVar.dE(baseActivity.getPageContext().getString(com.baidu.tieba.z.name_not_use));
        } else if (this.CU.oW() == 36) {
            this.US.dE(this.CU.getErrorString());
            if (aVar != null) {
                this.US.u(aVar.mL());
            }
        } else {
            this.US.dE(this.CU.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.US.UL;
        progressBar.setVisibility(0);
        button = this.US.UH;
        button.setEnabled(false);
        this.US.dE(null);
        this.US.tF();
        super.onPreExecute();
    }
}
