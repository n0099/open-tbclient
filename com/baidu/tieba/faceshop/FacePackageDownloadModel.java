package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes9.dex */
public class FacePackageDownloadModel extends BdBaseModel<l> {
    private a iVK;
    private FacePackageDownloadData iVL;
    private float iVm;
    private int mScreenHeight;
    private int mScreenWidth;

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.iVL = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iVK = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iVm = inst.getResources().getDisplayMetrics().density;
    }

    public void JO(String str) {
        if (this.iVK == null) {
            this.iVK = new a(str);
            this.iVK.setPriority(3);
            this.iVK.execute(new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        private com.baidu.tbadk.core.util.aa cml;
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
                    this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.cml.addPostData("pid", this.mPid);
                    this.cml.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.mScreenWidth));
                    this.cml.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.mScreenHeight));
                    this.cml.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.iVm));
                    String postNetData = this.cml.postNetData();
                    FacePackageDownloadModel.this.iVL = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return FacePackageDownloadModel.this.iVL;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.iVK = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.callback(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
                this.cml = null;
            }
            FacePackageDownloadModel.this.iVK = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVK != null) {
            this.iVK.cancel();
            return false;
        }
        return false;
    }
}
