package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ am a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ FacePurchaseRecordsData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.a.g gVar;
        FacePurchaseRecordsData facePurchaseRecordsData2 = facePurchaseRecordsData;
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(facePurchaseRecordsData2);
        super.a((an) facePurchaseRecordsData2);
    }

    private an(am amVar) {
        this.a = amVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(am amVar, byte b) {
        this(amVar);
    }

    private FacePurchaseRecordsData d() {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/e/faces/getpackhis");
            com.baidu.tieba.util.ba baVar = this.b;
            str = this.a.b;
            baVar.a("st_type", str);
            com.baidu.tieba.util.ba baVar2 = this.b;
            i = this.a.c;
            baVar2.a("scr_w", String.valueOf(i));
            com.baidu.tieba.util.ba baVar3 = this.b;
            i2 = this.a.d;
            baVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tieba.util.ba baVar4 = this.b;
            f = this.a.e;
            baVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.l(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.a = null;
    }
}
