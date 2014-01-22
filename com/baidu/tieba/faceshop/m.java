package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
    final /* synthetic */ j a;
    private com.baidu.tieba.util.ax b;

    private m(j jVar) {
        this.a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceBuyData a(Object... objArr) {
        String obj = objArr[0].toString();
        try {
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/e/faces/buyfacepack");
            this.b.a("pid", obj);
            return (FaceBuyData) new GsonBuilder().create().fromJson(this.b.m(), (Class<Object>) FaceBuyData.class);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
        }
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FaceBuyData faceBuyData) {
        com.baidu.adp.a.g gVar;
        super.a((m) faceBuyData);
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(faceBuyData);
    }
}
