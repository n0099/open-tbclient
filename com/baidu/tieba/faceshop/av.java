package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ au a;
    private com.baidu.tbadk.core.util.an b;
    private String c;

    public av(au auVar, String str) {
        this.a = auVar;
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
                this.b = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tbadk.core.util.an anVar = this.b;
                i = this.a.c;
                anVar.a("scr_w", String.valueOf(i));
                com.baidu.tbadk.core.util.an anVar2 = this.b;
                i2 = this.a.d;
                anVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tbadk.core.util.an anVar3 = this.b;
                f = this.a.e;
                anVar3.a("scr_dip", String.valueOf(f));
                String i3 = this.b.i();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(i3, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.toString());
        }
        facePackageDownloadData = this.a.b;
        return facePackageDownloadData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.base.e eVar;
        this.a.a = null;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(facePackageDownloadData);
        super.onPostExecute(facePackageDownloadData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a = null;
    }
}
