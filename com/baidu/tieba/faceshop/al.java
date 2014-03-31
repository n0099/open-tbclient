package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends BdAsyncTask<Object, String, FacePackageDetailData> {
    final /* synthetic */ ak a;
    private com.baidu.tbadk.core.util.ak b;
    private volatile boolean c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ FacePackageDetailData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePackageDetailData facePackageDetailData) {
        com.baidu.tbadk.d dVar;
        FacePackageDetailData facePackageDetailData2 = facePackageDetailData;
        super.a((al) facePackageDetailData2);
        this.a.i = null;
        if (facePackageDetailData2 != null) {
            this.a.h = facePackageDetailData2;
        }
        dVar = this.a.m;
        dVar.a(facePackageDetailData2, false);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        GsonBuilder gsonBuilder;
        com.baidu.tbadk.d dVar;
        String[] strArr2 = strArr;
        String str = strArr2[0];
        gsonBuilder = this.a.g;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(str, (Class<Object>) FacePackageDetailData.class);
        this.a.h = facePackageDetailData;
        dVar = this.a.m;
        dVar.a(facePackageDetailData, true);
        super.b((Object[]) strArr2);
    }

    private al(ak akVar) {
        this.a = akVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(ak akVar, byte b) {
        this(akVar);
    }

    private FacePackageDetailData a() {
        FacePackageDetailData facePackageDetailData;
        Exception e;
        String str;
        String str2;
        int i;
        int i2;
        float f;
        String str3;
        String str4;
        GsonBuilder gsonBuilder;
        com.baidu.adp.lib.cache.s<String> y;
        String str5;
        String str6;
        try {
            str = this.a.d;
            if (str != null) {
                str2 = this.a.d;
                if (str2.length() > 0 && !this.c) {
                    com.baidu.adp.lib.cache.s<String> y2 = com.baidu.tbadk.core.c.b.a().y();
                    if (y2 != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(TbadkApplication.E()));
                        str6 = this.a.d;
                        String a = y2.a(sb.append(str6).toString());
                        if (!com.baidu.tbadk.core.util.bc.c(a)) {
                            c((Object[]) new String[]{a});
                        }
                    }
                    this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/getfacelist");
                    com.baidu.tbadk.core.util.ak akVar = this.b;
                    i = this.a.j;
                    akVar.a("scr_w", String.valueOf(i));
                    com.baidu.tbadk.core.util.ak akVar2 = this.b;
                    i2 = this.a.k;
                    akVar2.a("scr_h", String.valueOf(i2));
                    com.baidu.tbadk.core.util.ak akVar3 = this.b;
                    f = this.a.l;
                    akVar3.a("scr_dip", String.valueOf(f));
                    com.baidu.tbadk.core.util.ak akVar4 = this.b;
                    str3 = this.a.d;
                    akVar4.a("pid", str3);
                    com.baidu.tbadk.core.util.ak akVar5 = this.b;
                    str4 = this.a.c;
                    akVar5.a("st_type", str4);
                    String i3 = this.b.i();
                    gsonBuilder = this.a.g;
                    facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(i3, (Class<Object>) FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.facePackage != null && (y = com.baidu.tbadk.core.c.b.a().y()) != null) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(TbadkApplication.E()));
                                str5 = this.a.d;
                                y.a(sb2.append(str5).toString(), i3, 604800000L);
                                return facePackageDetailData;
                            }
                            return facePackageDetailData;
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
                            return facePackageDetailData;
                        }
                    }
                    return facePackageDetailData;
                }
            }
            return null;
        } catch (Exception e3) {
            facePackageDetailData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.i = null;
    }
}
