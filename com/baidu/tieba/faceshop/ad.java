package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ ac a;
    private com.baidu.tieba.util.ba b;
    private String c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ FacePackageDownloadData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.a.g gVar;
        FacePackageDownloadData facePackageDownloadData2 = facePackageDownloadData;
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(facePackageDownloadData2);
        super.a((ad) facePackageDownloadData2);
    }

    public ad(ac acVar, String str) {
        this.a = acVar;
        this.c = str;
    }

    private FacePackageDownloadData d() {
        FacePackageDownloadData facePackageDownloadData;
        int i;
        int i2;
        float f;
        try {
            if (this.c != null && this.c.length() > 0) {
                this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tieba.util.ba baVar = this.b;
                i = this.a.c;
                baVar.a("scr_w", String.valueOf(i));
                com.baidu.tieba.util.ba baVar2 = this.b;
                i2 = this.a.d;
                baVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tieba.util.ba baVar3 = this.b;
                f = this.a.e;
                baVar3.a("scr_dip", String.valueOf(f));
                String l = this.b.l();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(l, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.toString());
        }
        facePackageDownloadData = this.a.b;
        return facePackageDownloadData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.a = null;
    }
}
