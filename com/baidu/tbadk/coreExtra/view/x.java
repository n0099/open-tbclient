package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    final /* synthetic */ r Oy;
    private String mAccount;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;

    public x(r rVar, String str, String str2) {
        this.Oy = rVar;
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
        progressBar = this.Oy.Os;
        progressBar.setVisibility(8);
        button = this.Oy.Oo;
        button.setEnabled(true);
        this.Oy.Oq = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
        this.yV.k("un", this.mAccount);
        String lA = this.yV.lA();
        if (!this.yV.mf() || this.yV.mg() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(lA);
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
        this.Oy.Oq = null;
        progressBar = this.Oy.Os;
        progressBar.setVisibility(8);
        button = this.Oy.Oo;
        button.setEnabled(true);
        if (!this.yV.mf()) {
            this.Oy.cM(this.yV.getErrorString());
        } else if (this.yV.mg() == 0) {
            r rVar = this.Oy;
            baseActivity = this.Oy.On;
            rVar.cM(baseActivity.getString(com.baidu.tieba.y.name_not_use));
        } else if (this.yV.mg() == 36) {
            this.Oy.cM(this.yV.getErrorString());
            if (aVar != null) {
                this.Oy.i(aVar.ka());
            }
        } else {
            this.Oy.cM(this.yV.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.Oy.Os;
        progressBar.setVisibility(0);
        button = this.Oy.Oo;
        button.setEnabled(false);
        this.Oy.cM(null);
        this.Oy.pZ();
        super.onPreExecute();
    }
}
