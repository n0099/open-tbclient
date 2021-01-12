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
    private float iPr;
    private a iQa;
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
        this.iPr = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void loadData() {
        if (this.iQa == null) {
            this.iQa = new a();
            this.iQa.setPriority(3);
            this.iQa.execute(new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        private com.baidu.tbadk.core.util.z chV;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.chV.addPostData("st_type", FacePurchaseRecordsModel.this.mStType);
                this.chV.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.mScreenWidth));
                this.chV.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.mScreenHeight));
                this.chV.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.iPr));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.chV.postNetData(), FacePurchaseRecordsData.class);
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
            FacePurchaseRecordsModel.this.iQa = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.callback(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.iQa = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iQa != null) {
            this.iQa.cancel();
            return true;
        }
        return true;
    }
}
