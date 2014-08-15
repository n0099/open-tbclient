package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
    final /* synthetic */ ay a;
    private com.baidu.tbadk.core.util.ae b;

    private az(ay ayVar) {
        this.a = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(ay ayVar, az azVar) {
        this(ayVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FacePurchaseRecordsData doInBackground(Object... objArr) {
        String str;
        int i;
        int i2;
        float f;
        try {
            this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/getpackhis");
            com.baidu.tbadk.core.util.ae aeVar = this.b;
            str = this.a.b;
            aeVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
            com.baidu.tbadk.core.util.ae aeVar2 = this.b;
            i = this.a.c;
            aeVar2.a("scr_w", String.valueOf(i));
            com.baidu.tbadk.core.util.ae aeVar3 = this.b;
            i2 = this.a.d;
            aeVar3.a("scr_h", String.valueOf(i2));
            com.baidu.tbadk.core.util.ae aeVar4 = this.b;
            f = this.a.e;
            aeVar4.a("scr_dip", String.valueOf(f));
            return (FacePurchaseRecordsData) new GsonBuilder().create().fromJson(this.b.h(), (Class<Object>) FacePurchaseRecordsData.class);
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
        com.baidu.adp.base.h hVar;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(facePurchaseRecordsData);
        super.onPostExecute(facePurchaseRecordsData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
        }
        this.a.a = null;
    }
}
