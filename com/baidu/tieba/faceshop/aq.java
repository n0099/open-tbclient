package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
    private String atw;
    final /* synthetic */ ap auh;
    private com.baidu.tbadk.core.util.ac mNetWork;

    public aq(ap apVar, String str) {
        this.auh = apVar;
        this.atw = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public FacePackageDownloadData doInBackground(Object... objArr) {
        FacePackageDownloadData facePackageDownloadData;
        int i;
        int i2;
        float f;
        try {
            if (this.atw != null && this.atw.length() > 0) {
                this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                this.mNetWork.k("pid", this.atw);
                com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
                i = this.auh.atB;
                acVar.k("scr_w", String.valueOf(i));
                com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
                i2 = this.auh.atC;
                acVar2.k("scr_h", String.valueOf(i2));
                com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
                f = this.auh.atD;
                acVar3.k("scr_dip", String.valueOf(f));
                String lA = this.mNetWork.lA();
                this.auh.aug = (FacePackageDownloadData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, FacePackageDownloadData.class);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        facePackageDownloadData = this.auh.aug;
        return facePackageDownloadData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
        com.baidu.adp.base.h hVar;
        this.auh.auf = null;
        hVar = this.auh.mLoadDataCallBack;
        hVar.a(facePackageDownloadData);
        super.onPostExecute(facePackageDownloadData);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
            this.mNetWork = null;
        }
        this.auh.auf = null;
    }
}
