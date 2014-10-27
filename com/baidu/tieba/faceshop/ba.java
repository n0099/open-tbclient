package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ az auj;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private ba(az azVar) {
        this.auj = azVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(az azVar, ba baVar) {
        this(azVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public FacePurchaseRecordsData doInBackground(Object... objArr) {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
            com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
            str = this.auj.aok;
            acVar.k("st_type", str);
            com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
            i = this.auj.ats;
            acVar2.k("scr_w", String.valueOf(i));
            com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
            i2 = this.auj.att;
            acVar3.k("scr_h", String.valueOf(i2));
            com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
            f = this.auj.atu;
            acVar4.k("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.mNetWork.lA(), FacePurchaseRecordsData.class);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.base.h hVar;
        this.auj.aui = null;
        hVar = this.auj.mLoadDataCallBack;
        hVar.a(facePurchaseRecordsData);
        super.onPostExecute(facePurchaseRecordsData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.auj.aui = null;
    }
}
