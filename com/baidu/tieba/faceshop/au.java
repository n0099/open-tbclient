package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    final /* synthetic */ at a;
    private com.baidu.tbadk.core.util.ak b;
    private String c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ FacePackageDownloadData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.a.h hVar;
        FacePackageDownloadData facePackageDownloadData2 = facePackageDownloadData;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(facePackageDownloadData2);
        super.a((au) facePackageDownloadData2);
    }

    public au(at atVar, String str) {
        this.a = atVar;
        this.c = str;
    }

    private FacePackageDownloadData a() {
        FacePackageDownloadData facePackageDownloadData;
        int i;
        int i2;
        float f;
        try {
            if (this.c != null && this.c.length() > 0) {
                this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/dpack");
                this.b.a("pid", this.c);
                com.baidu.tbadk.core.util.ak akVar = this.b;
                i = this.a.c;
                akVar.a("scr_w", String.valueOf(i));
                com.baidu.tbadk.core.util.ak akVar2 = this.b;
                i2 = this.a.d;
                akVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tbadk.core.util.ak akVar3 = this.b;
                f = this.a.e;
                akVar3.a("scr_dip", String.valueOf(f));
                String i3 = this.b.i();
                Gson create = new GsonBuilder().create();
                this.a.b = (FacePackageDownloadData) create.fromJson(i3, (Class<Object>) FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
        }
        facePackageDownloadData = this.a.b;
        return facePackageDownloadData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a = null;
    }
}
