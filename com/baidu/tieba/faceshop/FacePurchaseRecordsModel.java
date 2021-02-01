package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes9.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {
    private float iUY;
    private a iVH;
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
        this.iUY = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void loadData() {
        if (this.iVH == null) {
            this.iVH = new a();
            this.iVH.setPriority(3);
            this.iVH.execute(new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        private com.baidu.tbadk.core.util.aa cml;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.cml.addPostData("st_type", FacePurchaseRecordsModel.this.mStType);
                this.cml.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.mScreenWidth));
                this.cml.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.mScreenHeight));
                this.cml.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.iUY));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.cml.postNetData(), FacePurchaseRecordsData.class);
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
            FacePurchaseRecordsModel.this.iVH = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.callback(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.iVH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVH != null) {
            this.iVH.cancel();
            return true;
        }
        return true;
    }
}
