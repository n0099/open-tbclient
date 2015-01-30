package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.ad CX = null;
    final /* synthetic */ t UV;
    private String mAccount;
    private String mUrl;

    public z(t tVar, String str, String str2) {
        this.UV = tVar;
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
        progressBar = this.UV.UO;
        progressBar.setVisibility(8);
        button = this.UV.UK;
        button.setEnabled(true);
        this.UV.UM = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.CX = new com.baidu.tbadk.core.util.ad(this.mUrl);
        this.CX.o("un", this.mAccount);
        String oy = this.CX.oy();
        if (!this.CX.pc() || this.CX.pd() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(oy);
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
        this.UV.UM = null;
        progressBar = this.UV.UO;
        progressBar.setVisibility(8);
        button = this.UV.UK;
        button.setEnabled(true);
        if (!this.CX.pc()) {
            this.UV.dH(this.CX.getErrorString());
        } else if (this.CX.pd() == 0) {
            t tVar = this.UV;
            baseActivity = this.UV.UJ;
            tVar.dH(baseActivity.getPageContext().getString(com.baidu.tieba.z.name_not_use));
        } else if (this.CX.pd() == 36) {
            this.UV.dH(this.CX.getErrorString());
            if (aVar != null) {
                this.UV.u(aVar.mS());
            }
        } else {
            this.UV.dH(this.CX.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.UV.UO;
        progressBar.setVisibility(0);
        button = this.UV.UK;
        button.setEnabled(false);
        this.UV.dH(null);
        this.UV.tL();
        super.onPreExecute();
    }
}
