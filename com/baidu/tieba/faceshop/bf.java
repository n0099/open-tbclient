package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ be a;
    private com.baidu.tbadk.core.util.an b;

    private bf(be beVar) {
        this.a = beVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(be beVar, bf bfVar) {
        this(beVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FacePurchaseRecordsData doInBackground(Object... objArr) {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.b = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/getpackhis");
            com.baidu.tbadk.core.util.an anVar = this.b;
            str = this.a.b;
            anVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
            com.baidu.tbadk.core.util.an anVar2 = this.b;
            i = this.a.c;
            anVar2.a("scr_w", String.valueOf(i));
            com.baidu.tbadk.core.util.an anVar3 = this.b;
            i2 = this.a.d;
            anVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tbadk.core.util.an anVar4 = this.b;
            f = this.a.e;
            anVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.i(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.base.e eVar;
        this.a.a = null;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(facePurchaseRecordsData);
        super.onPostExecute(facePurchaseRecordsData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
    }
}
