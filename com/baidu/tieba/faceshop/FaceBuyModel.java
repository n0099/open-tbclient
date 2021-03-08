package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes8.dex */
public class FaceBuyModel extends BdBaseModel {
    private b iWB;
    private a iWC;
    private int iWD;

    public FaceBuyModel(Context context) {
        super(null);
        this.iWD = 3;
        this.iWB = null;
        this.iWC = null;
    }

    public void JR(String str) {
        if (this.iWB == null) {
            this.iWB = new b();
            this.iWB.setPriority(3);
            this.iWB.execute(str);
        }
    }

    public void JS(String str) {
        if (this.iWC == null) {
            this.iWC = new a();
            this.iWC.setPriority(3);
            this.iWC.execute(str);
        }
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        private com.baidu.tbadk.core.util.aa cnM;

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public FaceBuyData doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            try {
                this.cnM = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                this.cnM.addPostData("pid", obj);
                return (FaceBuyData) OrmObject.objectWithJsonStr(this.cnM.postNetData(), FaceBuyData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            FaceBuyModel.this.iWB = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FaceBuyData faceBuyData) {
            super.onPostExecute(faceBuyData);
            FaceBuyModel.this.iWB = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyData);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        private com.baidu.tbadk.core.util.aa cnM;
        private volatile boolean mCanceled;

        private a() {
            this.mCanceled = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public FaceBuyQueryData doInBackground(Object... objArr) {
            int i = 0;
            FaceBuyQueryData faceBuyQueryData = null;
            String obj = objArr[0].toString();
            if (!au.isEmpty(obj)) {
                this.cnM = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                this.cnM.addPostData("order_id", obj);
                while (!this.mCanceled && i < FaceBuyModel.this.iWD) {
                    faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.cnM.postNetData(), FaceBuyQueryData.class);
                    if (faceBuyQueryData != null && faceBuyQueryData.buy_result != null) {
                        if (faceBuyQueryData.buy_result.status == 2) {
                            break;
                        }
                        try {
                            Thread.sleep(IMConnection.RETRY_DELAY_TIMES);
                        } catch (InterruptedException e) {
                            BdLog.detailException(e);
                        }
                        i++;
                    } else {
                        try {
                            Thread.sleep(IMConnection.RETRY_DELAY_TIMES);
                        } catch (InterruptedException e2) {
                            BdLog.detailException(e2);
                        }
                        i++;
                    }
                }
            }
            return faceBuyQueryData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FaceBuyQueryData faceBuyQueryData) {
            super.onPostExecute(faceBuyQueryData);
            FaceBuyModel.this.iWC = null;
            this.mCanceled = true;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyQueryData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            FaceBuyModel.this.iWC = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iWB != null) {
            this.iWB.cancel();
            return true;
        }
        return true;
    }
}
