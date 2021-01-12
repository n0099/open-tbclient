package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes8.dex */
public class FacePackageDownloadModel extends BdBaseModel<l> {
    private a iPP;
    private FacePackageDownloadData iPQ;
    private float iPr;
    private int mScreenHeight;
    private int mScreenWidth;

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.iPQ = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iPP = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iPr = inst.getResources().getDisplayMetrics().density;
    }

    public void Jc(String str) {
        if (this.iPP == null) {
            this.iPP = new a(str);
            this.iPP.setPriority(3);
            this.iPP.execute(new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        private com.baidu.tbadk.core.util.z chV;
        private String mPid;

        public a(String str) {
            this.mPid = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.mPid != null && this.mPid.length() > 0) {
                    this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.chV.addPostData("pid", this.mPid);
                    this.chV.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.mScreenWidth));
                    this.chV.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.mScreenHeight));
                    this.chV.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.iPr));
                    String postNetData = this.chV.postNetData();
                    FacePackageDownloadModel.this.iPQ = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return FacePackageDownloadModel.this.iPQ;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.iPP = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.callback(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
                this.chV = null;
            }
            FacePackageDownloadModel.this.iPP = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iPP != null) {
            this.iPP.cancel();
            return false;
        }
        return false;
    }
}
