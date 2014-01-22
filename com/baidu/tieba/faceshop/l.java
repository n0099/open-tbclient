package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
    final /* synthetic */ j a;
    private com.baidu.tieba.util.ax b;
    private volatile boolean c;

    private l(j jVar) {
        this.a = jVar;
        this.c = false;
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
        if (!bu.c(obj)) {
            Gson create = new GsonBuilder().create();
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/e/faces/querybuyresult");
            this.b.a("order_id", obj);
            while (!this.c) {
                i = this.a.c;
                if (i2 < i) {
                    faceBuyQueryData = (FaceBuyQueryData) create.fromJson(this.b.m(), (Class<Object>) FaceBuyQueryData.class);
                    if (faceBuyQueryData != null && faceBuyQueryData.buyResult != null) {
                        if (faceBuyQueryData.buyResult.status == 2) {
                            break;
                        }
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e) {
                            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.toString());
                        }
                        i2++;
                    } else {
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e2) {
                            com.baidu.adp.lib.g.e.b(getClass().getName(), "FaceBuyQueryTask doInBackground", e2.toString());
                        }
                        i2++;
                    }
                } else {
                    break;
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
        super.a((l) faceBuyQueryData);
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
