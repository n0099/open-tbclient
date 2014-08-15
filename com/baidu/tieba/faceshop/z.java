package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
    final /* synthetic */ x a;
    private com.baidu.tbadk.core.util.ae b;

    private z(x xVar) {
        this.a = xVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(x xVar, z zVar) {
        this(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FaceBuyData doInBackground(Object... objArr) {
        String obj = objArr[0].toString();
        try {
            this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/buyfacepack");
            this.b.a("pid", obj);
            return (FaceBuyData) new GsonBuilder().create().fromJson(this.b.h(), (Class<Object>) FaceBuyData.class);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
        }
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FaceBuyData faceBuyData) {
        com.baidu.adp.base.h hVar;
        super.onPostExecute(faceBuyData);
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(faceBuyData);
    }
}
