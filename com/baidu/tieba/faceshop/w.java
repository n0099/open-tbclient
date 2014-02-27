package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends BdAsyncTask<Object, String, FacePackageDetailData> {
    final /* synthetic */ v a;
    private com.baidu.tieba.util.ba b;
    private volatile boolean c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ FacePackageDetailData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FacePackageDetailData facePackageDetailData) {
        com.baidu.tieba.i iVar;
        FacePackageDetailData facePackageDetailData2 = facePackageDetailData;
        super.a((w) facePackageDetailData2);
        this.a.i = null;
        if (facePackageDetailData2 != null) {
            this.a.h = facePackageDetailData2;
        }
        iVar = this.a.m;
        iVar.a(facePackageDetailData2, false);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        GsonBuilder gsonBuilder;
        com.baidu.tieba.i iVar;
        String[] strArr2 = strArr;
        String str = strArr2[0];
        gsonBuilder = this.a.g;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(str, (Class<Object>) FacePackageDetailData.class);
        this.a.h = facePackageDetailData;
        iVar = this.a.m;
        iVar.a(facePackageDetailData, true);
        super.b((Object[]) strArr2);
    }

    private w(v vVar) {
        this.a = vVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(v vVar, byte b) {
        this(vVar);
    }

    private FacePackageDetailData d() {
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
        com.baidu.adp.lib.cache.s<String> x;
        String str5;
        String str6;
        try {
            str = this.a.d;
            if (str != null) {
                str2 = this.a.d;
                if (str2.length() > 0 && !this.c) {
                    com.baidu.adp.lib.cache.s<String> x2 = com.baidu.tieba.c.a.a().x();
                    if (x2 != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(TiebaApplication.v()));
                        str6 = this.a.d;
                        String a = x2.a(sb.append(str6).toString());
                        if (!bs.c(a)) {
                            c((Object[]) new String[]{a});
                        }
                    }
                    this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/e/faces/getfacelist");
                    com.baidu.tieba.util.ba baVar = this.b;
                    i = this.a.j;
                    baVar.a("scr_w", String.valueOf(i));
                    com.baidu.tieba.util.ba baVar2 = this.b;
                    i2 = this.a.k;
                    baVar2.a("scr_h", String.valueOf(i2));
                    com.baidu.tieba.util.ba baVar3 = this.b;
                    f = this.a.l;
                    baVar3.a("scr_dip", String.valueOf(f));
                    com.baidu.tieba.util.ba baVar4 = this.b;
                    str3 = this.a.d;
                    baVar4.a("pid", str3);
                    com.baidu.tieba.util.ba baVar5 = this.b;
                    str4 = this.a.c;
                    baVar5.a("st_type", str4);
                    String l = this.b.l();
                    gsonBuilder = this.a.g;
                    facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(l, (Class<Object>) FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.facePackage != null && (x = com.baidu.tieba.c.a.a().x()) != null) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(TiebaApplication.v()));
                                str5 = this.a.d;
                                x.a(sb2.append(str5).toString(), l, 604800000L);
                                return facePackageDetailData;
                            }
                            return facePackageDetailData;
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.toString());
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
            this.b.j();
            this.b = null;
        }
        this.a.i = null;
    }
}
