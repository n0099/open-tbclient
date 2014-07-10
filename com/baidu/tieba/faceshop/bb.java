package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ ba a;
    private com.baidu.tbadk.core.util.aq b;

    private bb(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(ba baVar, bb bbVar) {
        this(baVar);
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
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/getpackhis");
            com.baidu.tbadk.core.util.aq aqVar = this.b;
            str = this.a.b;
            aqVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
            com.baidu.tbadk.core.util.aq aqVar2 = this.b;
            i = this.a.c;
            aqVar2.a("scr_w", String.valueOf(i));
            com.baidu.tbadk.core.util.aq aqVar3 = this.b;
            i2 = this.a.d;
            aqVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tbadk.core.util.aq aqVar4 = this.b;
            f = this.a.e;
            aqVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.i(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.base.h hVar;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(facePurchaseRecordsData);
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
