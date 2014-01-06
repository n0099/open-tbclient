package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ ac a;
    private com.baidu.tieba.util.at b;
    private String c;

    public ad(ac acVar, String str) {
        this.a = acVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FacePackageDownloadData a(Object... objArr) {
        FacePackageDownloadData facePackageDownloadData;
        int i;
        int i2;
        float f;
        try {
            if (this.c != null && this.c.length() > 0) {
                this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tieba.util.at atVar = this.b;
                i = this.a.c;
                atVar.a("scr_w", String.valueOf(i));
                com.baidu.tieba.util.at atVar2 = this.b;
                i2 = this.a.d;
                atVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tieba.util.at atVar3 = this.b;
                f = this.a.e;
                atVar3.a("scr_dip", String.valueOf(f));
                String l = this.b.l();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(l, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "doInBackground", e.toString());
        }
        facePackageDownloadData = this.a.b;
        return facePackageDownloadData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.a.g gVar;
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(facePackageDownloadData);
        super.a((ad) facePackageDownloadData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.a = null;
    }
}
