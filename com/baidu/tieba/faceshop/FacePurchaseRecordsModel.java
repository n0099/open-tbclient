package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes8.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {
    private float iWV;
    private a iXE;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(app);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(app);
        this.iWV = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void loadData() {
        if (this.iXE == null) {
            this.iXE = new a();
            this.iXE.setPriority(3);
            this.iXE.execute(new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        private com.baidu.tbadk.core.util.aa cnM;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                this.cnM = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.cnM.addPostData("st_type", FacePurchaseRecordsModel.this.mStType);
                this.cnM.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.mScreenWidth));
                this.cnM.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.mScreenHeight));
                this.cnM.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.iWV));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.cnM.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.iXE = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.callback(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.iXE = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iXE != null) {
            this.iXE.cancel();
            return true;
        }
        return true;
    }
}
