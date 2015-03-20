package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ t aeZ;
    private String mAccount;
    private String mUrl;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.aeZ.aeN = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.ZD = new com.baidu.tbadk.core.util.aa(this.mUrl);
        this.ZD.o("un", this.mAccount);
        String rO = this.ZD.rO();
        if (!this.ZD.ss() || this.ZD.st() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(rO);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        TbPageContext tbPageContext;
        super.onPostExecute(aVar);
        this.aeZ.aeN = null;
        if (!this.ZD.ss()) {
            this.aeZ.dN(this.ZD.getErrorString());
        } else if (this.ZD.st() == 0) {
            t tVar = this.aeZ;
            tbPageContext = this.aeZ.LN;
            tVar.dN(tbPageContext.getString(com.baidu.tieba.y.name_not_use));
        } else if (this.ZD.st() == 36) {
            this.aeZ.dN(this.ZD.getErrorString());
            if (aVar != null) {
                this.aeZ.r(aVar.qf());
            }
        } else {
            this.aeZ.dN(this.ZD.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aeZ.dN(null);
        this.aeZ.wZ();
        super.onPreExecute();
    }
}
