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
    private float iTY;
    private a iUw;
    private FacePackageDownloadData iUx;
    private int mScreenHeight;
    private int mScreenWidth;

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.iUx = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iUw = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iTY = inst.getResources().getDisplayMetrics().density;
    }

    public void Kn(String str) {
        if (this.iUw == null) {
            this.iUw = new a(str);
            this.iUw.setPriority(3);
            this.iUw.execute(new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        private com.baidu.tbadk.core.util.z cmJ;
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
                    this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.cmJ.addPostData("pid", this.mPid);
                    this.cmJ.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.mScreenWidth));
                    this.cmJ.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.mScreenHeight));
                    this.cmJ.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.iTY));
                    String postNetData = this.cmJ.postNetData();
                    FacePackageDownloadModel.this.iUx = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return FacePackageDownloadModel.this.iUx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.iUw = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.callback(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
                this.cmJ = null;
            }
            FacePackageDownloadModel.this.iUw = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iUw != null) {
            this.iUw.cancel();
            return false;
        }
        return false;
    }
}
