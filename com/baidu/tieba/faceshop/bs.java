package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
    final /* synthetic */ br a;
    private int b;
    private com.baidu.tbadk.core.util.aq c;
    private volatile boolean d;

    private bs(br brVar) {
        this.a = brVar;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(br brVar, bs bsVar) {
        this(brVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FaceShopData doInBackground(Object... objArr) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        String str;
        this.b = ((Integer) objArr[0]).intValue();
        try {
            if (!this.d) {
                this.c = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/getpacklist");
                if (this.b == 1) {
                    this.a.c = 0;
                } else if (this.b == 2) {
                    br brVar = this.a;
                    i = brVar.c;
                    brVar.c = i + 1;
                }
                com.baidu.tbadk.core.util.aq aqVar = this.c;
                i2 = this.a.f;
                aqVar.a("scr_w", String.valueOf(i2));
                com.baidu.tbadk.core.util.aq aqVar2 = this.c;
                i3 = this.a.g;
                aqVar2.a("scr_h", String.valueOf(i3));
                com.baidu.tbadk.core.util.aq aqVar3 = this.c;
                f = this.a.h;
                aqVar3.a("scr_dip", String.valueOf(f));
                com.baidu.tbadk.core.util.aq aqVar4 = this.c;
                i4 = this.a.c;
                aqVar4.a("offset", String.valueOf(i4));
                this.c.a("limit", String.valueOf(10));
                com.baidu.tbadk.core.util.aq aqVar5 = this.c;
                str = this.a.d;
                aqVar5.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
                return (FaceShopData) new GsonBuilder().create().fromJson(this.c.i(), (Class<Object>) FaceShopData.class);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FaceShopData faceShopData) {
        com.baidu.adp.base.h hVar;
        FaceShopData faceShopData2;
        FaceShopData faceShopData3;
        super.onPostExecute(faceShopData);
        this.a.b = null;
        if (faceShopData != null) {
            this.a.e = faceShopData.hasMore == 1;
            if (this.b == 1) {
                this.a.a = faceShopData;
            } else if (this.b == 2) {
                faceShopData3 = this.a.a;
                faceShopData3.add(faceShopData);
            }
        }
        hVar = this.a.mLoadDataCallBack;
        faceShopData2 = this.a.a;
        hVar.a(faceShopData2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.d = true;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        this.a.b = null;
    }
}
