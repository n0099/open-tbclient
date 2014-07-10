package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask<Object, String, FacePackageDetailData> {
    final /* synthetic */ am a;
    private com.baidu.tbadk.core.util.aq b;
    private volatile boolean c;

    private an(am amVar) {
        this.a = amVar;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(am amVar, an anVar) {
        this(amVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public FacePackageDetailData doInBackground(Object... objArr) {
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
                    com.baidu.adp.lib.cache.s<String> B = com.baidu.tbadk.core.a.b.a().B();
                    if (B != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount()));
                        str5 = this.a.d;
                        String a = B.a(sb.append(str5).toString());
                        if (!com.baidu.tbadk.core.util.bm.c(a)) {
                            publishProgress(a);
                        }
                    }
                    this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/faces/getfacelist");
                    com.baidu.tbadk.core.util.aq aqVar = this.b;
                    i = this.a.j;
                    aqVar.a("scr_w", String.valueOf(i));
                    com.baidu.tbadk.core.util.aq aqVar2 = this.b;
                    i2 = this.a.k;
                    aqVar2.a("scr_h", String.valueOf(i2));
                    com.baidu.tbadk.core.util.aq aqVar3 = this.b;
                    f = this.a.l;
                    aqVar3.a("scr_dip", String.valueOf(f));
                    com.baidu.tbadk.core.util.aq aqVar4 = this.b;
                    str3 = this.a.d;
                    aqVar4.a("pid", str3);
                    com.baidu.tbadk.core.util.aq aqVar5 = this.b;
                    str4 = this.a.c;
                    aqVar5.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str4);
                    String i3 = this.b.i();
                    gsonBuilder = this.a.g;
                    facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(i3, (Class<Object>) FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.facePackage != null) {
                                a(i3);
                                return facePackageDetailData;
                            }
                            return facePackageDetailData;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.detailException(e);
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
    /* renamed from: a */
    public void onPostExecute(FacePackageDetailData facePackageDetailData) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        super.onPostExecute(facePackageDetailData);
        this.a.i = null;
        if (facePackageDetailData != null) {
            this.a.h = facePackageDetailData;
        }
        loadDataCallBack = this.a.m;
        loadDataCallBack.callback(facePackageDetailData, false);
    }

    private void a(String str) {
        String str2;
        com.baidu.adp.lib.cache.s<String> B = com.baidu.tbadk.core.a.b.a().B();
        if (B != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount()));
            str2 = this.a.d;
            B.a(sb.append(str2).toString(), str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(String... strArr) {
        GsonBuilder gsonBuilder;
        BaseActivity.LoadDataCallBack loadDataCallBack;
        String str = strArr[0];
        gsonBuilder = this.a.g;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) gsonBuilder.create().fromJson(str, (Class<Object>) FacePackageDetailData.class);
        this.a.h = facePackageDetailData;
        loadDataCallBack = this.a.m;
        loadDataCallBack.callback(facePackageDetailData, true);
        super.onProgressUpdate(strArr);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.i = null;
    }
}
