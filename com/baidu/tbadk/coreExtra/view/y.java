package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ t afh;
    private String mAccount;
    private String mUrl;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.afh.aeV = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.ZF = new com.baidu.tbadk.core.util.aa(this.mUrl);
        this.ZF.o("un", this.mAccount);
        String rO = this.ZF.rO();
        if (!this.ZF.ss() || this.ZF.st() != 36) {
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
        this.afh.aeV = null;
        if (!this.ZF.ss()) {
            this.afh.dQ(this.ZF.getErrorString());
        } else if (this.ZF.st() == 0) {
            t tVar = this.afh;
            tbPageContext = this.afh.LP;
            tVar.dQ(tbPageContext.getString(com.baidu.tieba.y.name_not_use));
        } else if (this.ZF.st() == 36) {
            this.afh.dQ(this.ZF.getErrorString());
            if (aVar != null) {
                this.afh.r(aVar.qf());
            }
        } else {
            this.afh.dQ(this.ZF.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.afh.dQ(null);
        this.afh.xf();
        super.onPreExecute();
    }
}
