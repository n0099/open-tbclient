package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ ac a;
    private com.baidu.tieba.util.ax b;
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
                this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tieba.util.ax axVar = this.b;
                i = this.a.c;
                axVar.a("scr_w", String.valueOf(i));
                com.baidu.tieba.util.ax axVar2 = this.b;
                i2 = this.a.d;
                axVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tieba.util.ax axVar3 = this.b;
                f = this.a.e;
                axVar3.a("scr_dip", String.valueOf(f));
                String m = this.b.m();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(m, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.toString());
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
            this.b.k();
            this.b = null;
        }
        this.a.a = null;
    }
}
