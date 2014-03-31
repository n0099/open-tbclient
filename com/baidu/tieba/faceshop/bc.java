package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ bb a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ FacePurchaseRecordsData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.a.h hVar;
        FacePurchaseRecordsData facePurchaseRecordsData2 = facePurchaseRecordsData;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(facePurchaseRecordsData2);
        super.a((bc) facePurchaseRecordsData2);
    }

    private bc(bb bbVar) {
        this.a = bbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(bb bbVar, byte b) {
        this(bbVar);
    }

    private FacePurchaseRecordsData a() {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/getpackhis");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            str = this.a.b;
            akVar.a("st_type", str);
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            i = this.a.c;
            akVar2.a("scr_w", String.valueOf(i));
            com.baidu.tbadk.core.util.ak akVar3 = this.b;
            i2 = this.a.d;
            akVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tbadk.core.util.ak akVar4 = this.b;
            f = this.a.e;
            akVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.i(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
    }
}
