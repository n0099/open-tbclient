package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<Object, String, FacePackageDetailData> {
    private volatile boolean atE;
    final /* synthetic */ ak atF;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private al(ak akVar) {
        this.atF = akVar;
        this.atE = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(ak akVar, al alVar) {
        this(akVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
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
        String str5;
        try {
            str = this.atF.atw;
            if (str != null) {
                str2 = this.atF.atw;
                if (str2.length() > 0 && !this.atE) {
                    com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb_face_package");
                    if (bd != null) {
                        StringBuilder sb = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount()));
                        str5 = this.atF.atw;
                        String str6 = bd.get(sb.append(str5).toString());
                        if (!com.baidu.tbadk.core.util.az.aA(str6)) {
                            publishProgress(str6);
                        }
                    }
                    this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_PACKAGE_DETAIL);
                    com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
                    i = this.atF.atB;
                    acVar.k("scr_w", String.valueOf(i));
                    com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
                    i2 = this.atF.atC;
                    acVar2.k("scr_h", String.valueOf(i2));
                    com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
                    f = this.atF.atD;
                    acVar3.k("scr_dip", String.valueOf(f));
                    com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
                    str3 = this.atF.atw;
                    acVar4.k("pid", str3);
                    com.baidu.tbadk.core.util.ac acVar5 = this.mNetWork;
                    str4 = this.atF.aot;
                    acVar5.k("st_type", str4);
                    String lA = this.mNetWork.lA();
                    facePackageDetailData = (FacePackageDetailData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, FacePackageDetailData.class);
                    if (facePackageDetailData != null) {
                        try {
                            if (facePackageDetailData.faces_list != null) {
                                eS(lA);
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
        this.atF.atA = null;
        if (facePackageDetailData != null) {
            this.atF.atz = facePackageDetailData;
        }
        loadDataCallBack = this.atF.ats;
        loadDataCallBack.callback(facePackageDetailData, false);
    }

    private void eS(String str) {
        String str2;
        com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb_face_package");
        if (bd != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount()));
            str2 = this.atF.atw;
            bd.a(sb.append(str2).toString(), str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public void onProgressUpdate(String... strArr) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
        this.atF.atz = facePackageDetailData;
        loadDataCallBack = this.atF.ats;
        loadDataCallBack.callback(facePackageDetailData, true);
        super.onProgressUpdate(strArr);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.atE = true;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
            this.mNetWork = null;
        }
        this.atF.atA = null;
    }
}
