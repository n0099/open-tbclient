package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
    final /* synthetic */ x atd;
    private volatile boolean kJ;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private y(x xVar) {
        this.atd = xVar;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(x xVar, y yVar) {
        this(xVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public FaceBuyQueryData doInBackground(Object... objArr) {
        int i;
        int i2 = 0;
        FaceBuyQueryData faceBuyQueryData = null;
        String obj = objArr[0].toString();
        if (!com.baidu.tbadk.core.util.az.aA(obj)) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.QUERY_BUY_RESULT_URL);
            this.mNetWork.k("order_id", obj);
            while (!this.kJ) {
                i = this.atd.atc;
                if (i2 >= i) {
                    break;
                }
                faceBuyQueryData = (FaceBuyQueryData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.mNetWork.lA(), FaceBuyQueryData.class);
                if (faceBuyQueryData != null && faceBuyQueryData.buy_result != null) {
                    if (faceBuyQueryData.buy_result.status == 2) {
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
        this.atd.atb = null;
        this.kJ = true;
        hVar = this.atd.mLoadDataCallBack;
        hVar.a(faceBuyQueryData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.atd.atb = null;
        hVar = this.atd.mLoadDataCallBack;
        hVar.a(null);
    }
}
