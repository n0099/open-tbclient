package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ ap a;
    private com.baidu.tbadk.core.util.ae b;
    private String c;

    public aq(ap apVar, String str) {
        this.a = apVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FacePackageDownloadData doInBackground(Object... objArr) {
        FacePackageDownloadData facePackageDownloadData;
        int i;
        int i2;
        float f;
        try {
            if (this.c != null && this.c.length() > 0) {
                this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tbadk.core.util.ae aeVar = this.b;
                i = this.a.c;
                aeVar.a("scr_w", String.valueOf(i));
                com.baidu.tbadk.core.util.ae aeVar2 = this.b;
                i2 = this.a.d;
                aeVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tbadk.core.util.ae aeVar3 = this.b;
                f = this.a.e;
                aeVar3.a("scr_dip", String.valueOf(f));
                String h = this.b.h();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(h, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        facePackageDownloadData = this.a.b;
        return facePackageDownloadData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.base.h hVar;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(facePackageDownloadData);
        super.onPostExecute(facePackageDownloadData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
        this.a.a = null;
    }
}
