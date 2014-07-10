package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
    final /* synthetic */ z a;
    private com.baidu.tbadk.core.util.aq b;
    private volatile boolean c;

    private aa(z zVar) {
        this.a = zVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(z zVar, aa aaVar) {
        this(zVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FaceBuyQueryData doInBackground(Object... objArr) {
        int i;
        int i2 = 0;
        FaceBuyQueryData faceBuyQueryData = null;
        String obj = objArr[0].toString();
        if (!com.baidu.tbadk.core.util.bm.c(obj)) {
            Gson create = new GsonBuilder().create();
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/querybuyresult");
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
                        BdLog.detailException(e);
                    }
                    i2++;
                } else {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
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
    /* renamed from: a */
    public void onPostExecute(FaceBuyQueryData faceBuyQueryData) {
        com.baidu.adp.base.h hVar;
        super.onPostExecute(faceBuyQueryData);
        this.a.b = null;
        this.c = true;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(faceBuyQueryData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
