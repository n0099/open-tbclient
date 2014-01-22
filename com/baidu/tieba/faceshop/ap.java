package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ an a;
    private com.baidu.tieba.util.ax b;

    private ap(an anVar) {
        this.a = anVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FacePurchaseRecordsData a(Object... objArr) {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/e/faces/getpackhis");
            com.baidu.tieba.util.ax axVar = this.b;
            str = this.a.b;
            axVar.a("st_type", str);
            com.baidu.tieba.util.ax axVar2 = this.b;
            i = this.a.c;
            axVar2.a("scr_w", String.valueOf(i));
            com.baidu.tieba.util.ax axVar3 = this.b;
            i2 = this.a.d;
            axVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tieba.util.ax axVar4 = this.b;
            f = this.a.e;
            axVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.m(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.toString());
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
            this.b.k();
        }
        this.a.a = null;
    }
}
