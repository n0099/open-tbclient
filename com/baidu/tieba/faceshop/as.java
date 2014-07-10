package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ ar a;
    private com.baidu.tbadk.core.util.aq b;
    private String c;

    public as(ar arVar, String str) {
        this.a = arVar;
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
                this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tbadk.core.util.aq aqVar = this.b;
                i = this.a.c;
                aqVar.a("scr_w", String.valueOf(i));
                com.baidu.tbadk.core.util.aq aqVar2 = this.b;
                i2 = this.a.d;
                aqVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tbadk.core.util.aq aqVar3 = this.b;
                f = this.a.e;
                aqVar3.a("scr_dip", String.valueOf(f));
                String i3 = this.b.i();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(i3, (Class<Object>) FacePackageDownloadData.class);
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
            this.b.g();
            this.b = null;
        }
        this.a.a = null;
    }
}
