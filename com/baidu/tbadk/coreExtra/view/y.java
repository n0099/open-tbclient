package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.aa aaG;
    final /* synthetic */ t agi;
    private String mAccount;
    private String mUrl;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.agi.afX = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.aaG = new com.baidu.tbadk.core.util.aa(this.mUrl);
        this.aaG.o("un", this.mAccount);
        String sw = this.aaG.sw();
        if (!this.aaG.ta() || this.aaG.tb() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.parserJson(sw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        TbPageContext tbPageContext;
        super.onPostExecute(aVar);
        this.agi.afX = null;
        if (!this.aaG.ta()) {
            this.agi.eh(this.aaG.getErrorString());
        } else if (this.aaG.tb() == 0) {
            t tVar = this.agi;
            tbPageContext = this.agi.LH;
            tVar.eh(tbPageContext.getString(com.baidu.tieba.t.name_not_use));
        } else if (this.aaG.tb() == 36) {
            this.agi.eh(this.aaG.getErrorString());
            if (aVar != null) {
                this.agi.p(aVar.qL());
            }
        } else {
            this.agi.eh(this.aaG.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.agi.eh(null);
        this.agi.xS();
        super.onPreExecute();
    }
}
