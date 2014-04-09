package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
    final /* synthetic */ z a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(FaceBuyData faceBuyData) {
        com.baidu.adp.a.h hVar;
        FaceBuyData faceBuyData2 = faceBuyData;
        super.a((ab) faceBuyData2);
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(faceBuyData2);
    }

    private ab(z zVar) {
        this.a = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(z zVar, byte b) {
        this(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceBuyData a(Object... objArr) {
        String obj = objArr[0].toString();
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/buyfacepack");
            this.b.a("pid", obj);
            return (FaceBuyData) new GsonBuilder().create().fromJson(this.b.i(), (Class<Object>) FaceBuyData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
