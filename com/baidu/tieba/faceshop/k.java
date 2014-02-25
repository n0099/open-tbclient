package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
    final /* synthetic */ j a;
    private com.baidu.tieba.util.ba b;
    private volatile boolean c;

    private k(j jVar) {
        this.a = jVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(j jVar, k kVar) {
        this(jVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceBuyQueryData a(Object... objArr) {
        int i;
        int i2 = 0;
        FaceBuyQueryData faceBuyQueryData = null;
        String obj = objArr[0].toString();
        if (!bs.c(obj)) {
            Gson create = new GsonBuilder().create();
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/e/faces/querybuyresult");
            this.b.a("order_id", obj);
            while (!this.c) {
                i = this.a.c;
                if (i2 >= i) {
                    break;
                }
                faceBuyQueryData = (FaceBuyQueryData) create.fromJson(this.b.m(), (Class<Object>) FaceBuyQueryData.class);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FaceBuyQueryData faceBuyQueryData) {
        com.baidu.adp.a.g gVar;
        super.a((k) faceBuyQueryData);
        this.a.b = null;
        this.c = true;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(faceBuyQueryData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
        }
        this.a.b = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
