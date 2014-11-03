package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
    private volatile boolean atE;
    private int auR;
    final /* synthetic */ bo auS;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private bp(bo boVar) {
        this.auS = boVar;
        this.atE = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(bo boVar, bp bpVar) {
        this(boVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public FaceShopData doInBackground(Object... objArr) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        String str;
        this.auR = ((Integer) objArr[0]).intValue();
        try {
            if (!this.atE) {
                this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_PACKAGE_LIST);
                if (this.auR == 1) {
                    this.auS.mPage = 0;
                } else if (this.auR == 2) {
                    bo boVar = this.auS;
                    i = boVar.mPage;
                    boVar.mPage = i + 1;
                }
                com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
                i2 = this.auS.atB;
                acVar.k("scr_w", String.valueOf(i2));
                com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
                i3 = this.auS.atC;
                acVar2.k("scr_h", String.valueOf(i3));
                com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
                f = this.auS.atD;
                acVar3.k("scr_dip", String.valueOf(f));
                com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
                i4 = this.auS.mPage;
                acVar4.k("offset", String.valueOf(i4));
                this.mNetWork.k("limit", String.valueOf(10));
                com.baidu.tbadk.core.util.ac acVar5 = this.mNetWork;
                str = this.auS.aot;
                acVar5.k("st_type", str);
                return (FaceShopData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.mNetWork.lA(), FaceShopData.class);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(FaceShopData faceShopData) {
        com.baidu.adp.base.h hVar;
        FaceShopData faceShopData2;
        FaceShopData faceShopData3;
        super.onPostExecute(faceShopData);
        this.auS.auQ = null;
        if (faceShopData != null) {
            this.auS.mHasMore = faceShopData.has_more == 1;
            if (this.auR == 1) {
                this.auS.auy = faceShopData;
            } else if (this.auR == 2) {
                faceShopData3 = this.auS.auy;
                faceShopData3.add(faceShopData);
            }
        }
        hVar = this.auS.mLoadDataCallBack;
        faceShopData2 = this.auS.auy;
        hVar.a(faceShopData2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.atE = true;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
            this.mNetWork = null;
        }
        this.auS.auQ = null;
    }
}
