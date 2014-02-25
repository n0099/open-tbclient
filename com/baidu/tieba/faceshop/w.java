package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Object, String, FacePackageDetailData> {
    final /* synthetic */ v a;
    private com.baidu.tieba.util.ba b;
    private volatile boolean c;

    private w(v vVar) {
        this.a = vVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(v vVar, w wVar) {
        this(vVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FacePackageDetailData a(Object... objArr) {
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
        String str5;
        try {
            str = this.a.d;
            if (str != null) {
                str2 = this.a.d;
                if (str2.length() > 0 && !this.c) {
                    com.baidu.adp.lib.cache.s<String> x = com.baidu.tieba.c.a.a().x();
                    if (x != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(TiebaApplication.A()));
                        str5 = this.a.d;
                        String a = x.a(sb.append(str5).toString());
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
                    String m = this.b.m();
                    gsonBuilder = this.a.g;
                    facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(m, (Class<Object>) FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.facePackage != null) {
                                a(m);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FacePackageDetailData facePackageDetailData) {
        com.baidu.tieba.i iVar;
        super.a((w) facePackageDetailData);
        this.a.i = null;
        if (facePackageDetailData != null) {
            this.a.h = facePackageDetailData;
        }
        iVar = this.a.m;
        iVar.a(facePackageDetailData, false);
    }

    private void a(String str) {
        String str2;
        com.baidu.adp.lib.cache.s<String> x = com.baidu.tieba.c.a.a().x();
        if (x != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(TiebaApplication.A()));
            str2 = this.a.d;
            x.a(sb.append(str2).toString(), str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        GsonBuilder gsonBuilder;
        com.baidu.tieba.i iVar;
        String str = strArr[0];
        gsonBuilder = this.a.g;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(str, (Class<Object>) FacePackageDetailData.class);
        this.a.h = facePackageDetailData;
        iVar = this.a.m;
        iVar.a(facePackageDetailData, true);
        super.b((Object[]) strArr);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.i = null;
    }
}
