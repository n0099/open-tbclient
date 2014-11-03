package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
    final /* synthetic */ x atd;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private z(x xVar) {
        this.atd = xVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(x xVar, z zVar) {
        this(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public FaceBuyData doInBackground(Object... objArr) {
        String obj = objArr[0].toString();
        try {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.BUY_FACE_PACKAGE_URL);
            this.mNetWork.k("pid", obj);
            return (FaceBuyData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.mNetWork.lA(), FaceBuyData.class);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.atd.ata = null;
        hVar = this.atd.mLoadDataCallBack;
        hVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FaceBuyData faceBuyData) {
        com.baidu.adp.base.h hVar;
        super.onPostExecute(faceBuyData);
        this.atd.ata = null;
        hVar = this.atd.mLoadDataCallBack;
        hVar.a(faceBuyData);
    }
}
