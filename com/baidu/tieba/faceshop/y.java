package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
    final /* synthetic */ x a;
    private com.baidu.tbadk.core.util.ak b;
    private volatile boolean c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(FaceBuyQueryData faceBuyQueryData) {
        com.baidu.adp.a.h hVar;
        FaceBuyQueryData faceBuyQueryData2 = faceBuyQueryData;
        super.a((y) faceBuyQueryData2);
        this.a.b = null;
        this.c = true;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(faceBuyQueryData2);
    }

    private y(x xVar) {
        this.a = xVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(x xVar, byte b) {
        this(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceBuyQueryData a(Object... objArr) {
        int i;
        int i2 = 0;
        FaceBuyQueryData faceBuyQueryData = null;
        String obj = objArr[0].toString();
        if (!com.baidu.tbadk.core.util.bc.c(obj)) {
            Gson create = new GsonBuilder().create();
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/querybuyresult");
            this.b.a("order_id", obj);
            while (!this.c) {
                i = this.a.c;
                if (i2 >= i) {
                    break;
                }
                faceBuyQueryData = (FaceBuyQueryData) create.fromJson(this.b.i(), (Class<Object>) FaceBuyQueryData.class);
                if (faceBuyQueryData != null && faceBuyQueryData.buyResult != null) {
                    if (faceBuyQueryData.buyResult.status == 2) {
                        break;
                    }
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
                    }
                    i2++;
                } else {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e2) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "FaceBuyQueryTask doInBackground", e2.toString());
                    }
                    i2++;
                }
            }
        }
        return faceBuyQueryData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
