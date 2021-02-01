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
    private float iUY;
    private a iVw;
    private FacePackageDownloadData iVx;
    private int mScreenHeight;
    private int mScreenWidth;

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.iVx = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iVw = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iUY = inst.getResources().getDisplayMetrics().density;
    }

    public void JN(String str) {
        if (this.iVw == null) {
            this.iVw = new a(str);
            this.iVw.setPriority(3);
            this.iVw.execute(new Object[0]);
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
                    this.cml.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.iUY));
                    String postNetData = this.cml.postNetData();
                    FacePackageDownloadModel.this.iVx = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return FacePackageDownloadModel.this.iVx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.iVw = null;
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
            FacePackageDownloadModel.this.iVw = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVw != null) {
            this.iVw.cancel();
            return false;
        }
        return false;
    }
}
