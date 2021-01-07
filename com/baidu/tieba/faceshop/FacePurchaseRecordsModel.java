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
    private float iTY;
    private a iUH;
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
        this.iTY = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void loadData() {
        if (this.iUH == null) {
            this.iUH = new a();
            this.iUH.setPriority(3);
            this.iUH.execute(new Object[0]);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        private com.baidu.tbadk.core.util.z cmJ;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.cmJ.addPostData("st_type", FacePurchaseRecordsModel.this.mStType);
                this.cmJ.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.mScreenWidth));
                this.cmJ.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.mScreenHeight));
                this.cmJ.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.iTY));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.cmJ.postNetData(), FacePurchaseRecordsData.class);
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
            FacePurchaseRecordsModel.this.iUH = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.callback(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.iUH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iUH != null) {
            this.iUH.cancel();
            return true;
        }
        return true;
    }
}
