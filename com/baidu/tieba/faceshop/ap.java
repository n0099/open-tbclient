package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ an a;
    private com.baidu.tieba.util.at b;

    private ap(an anVar) {
        this.a = anVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FacePurchaseRecordsData a(Object... objArr) {
        String str;
        try {
            this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/e/faces/getpackhis");
            com.baidu.tieba.util.at atVar = this.b;
            str = this.a.b;
            atVar.a("st_type", str);
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.l(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.a.g gVar;
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(facePurchaseRecordsData);
        super.a((ap) facePurchaseRecordsData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.a = null;
    }
}
