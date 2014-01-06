package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, String, FacePackageDetailData> {
    final /* synthetic */ w a;
    private com.baidu.tieba.util.at b;
    private volatile boolean c;

    private y(w wVar) {
        this.a = wVar;
        this.c = false;
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
                    com.baidu.adp.lib.cache.s<String> w = com.baidu.tieba.b.a.a().w();
                    if (w != null) {
                        StringBuilder append = new StringBuilder().append(TiebaApplication.A());
                        str5 = this.a.d;
                        String a = w.a(append.append(str5).toString());
                        if (!bm.c(a)) {
                            c((Object[]) new String[]{a});
                        }
                    }
                    this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/e/faces/getfacelist");
                    com.baidu.tieba.util.at atVar = this.b;
                    i = this.a.j;
                    atVar.a("scr_w", String.valueOf(i));
                    com.baidu.tieba.util.at atVar2 = this.b;
                    i2 = this.a.k;
                    atVar2.a("scr_h", String.valueOf(i2));
                    com.baidu.tieba.util.at atVar3 = this.b;
                    f = this.a.l;
                    atVar3.a("scr_dip", String.valueOf(f));
                    com.baidu.tieba.util.at atVar4 = this.b;
                    str3 = this.a.d;
                    atVar4.a("pid", str3);
                    com.baidu.tieba.util.at atVar5 = this.b;
                    str4 = this.a.c;
                    atVar5.a("st_type", str4);
                    String l = this.b.l();
                    gsonBuilder = this.a.g;
                    facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(l, (Class<Object>) FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.facePackage != null) {
                                a(l);
                                return facePackageDetailData;
                            }
                            return facePackageDetailData;
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.h.e.b(getClass().getName(), "doInBackground", e.toString());
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
        com.baidu.tieba.m mVar;
        super.a((y) facePackageDetailData);
        this.a.i = null;
        this.a.h = facePackageDetailData;
        mVar = this.a.m;
        mVar.a(facePackageDetailData, false);
    }

    private void a(String str) {
        String str2;
        com.baidu.adp.lib.cache.s<String> w = com.baidu.tieba.b.a.a().w();
        if (w != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.A());
            str2 = this.a.d;
            w.a(append.append(str2).toString(), str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        GsonBuilder gsonBuilder;
        com.baidu.tieba.m mVar;
        String str = strArr[0];
        gsonBuilder = this.a.g;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(str, (Class<Object>) FacePackageDetailData.class);
        this.a.h = facePackageDetailData;
        mVar = this.a.m;
        mVar.a(facePackageDetailData, true);
        super.b((Object[]) strArr);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.i = null;
    }
}
