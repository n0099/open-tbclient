package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes9.dex */
public class FaceBuyModel extends BdBaseModel {
    private b iTE;
    private a iTF;
    private int iTG;

    public FaceBuyModel(Context context) {
        super(null);
        this.iTG = 3;
        this.iTE = null;
        this.iTF = null;
    }

    public void Kh(String str) {
        if (this.iTE == null) {
            this.iTE = new b();
            this.iTE.setPriority(3);
            this.iTE.execute(str);
        }
    }

    public void Ki(String str) {
        if (this.iTF == null) {
            this.iTF = new a();
            this.iTF.setPriority(3);
            this.iTF.execute(str);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        private com.baidu.tbadk.core.util.z cmJ;

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public FaceBuyData doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            try {
                this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                this.cmJ.addPostData("pid", obj);
                return (FaceBuyData) OrmObject.objectWithJsonStr(this.cmJ.postNetData(), FaceBuyData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            FaceBuyModel.this.iTE = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FaceBuyData faceBuyData) {
            super.onPostExecute(faceBuyData);
            FaceBuyModel.this.iTE = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyData);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        private com.baidu.tbadk.core.util.z cmJ;
        private volatile boolean mCanceled;

        private a() {
            this.mCanceled = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public FaceBuyQueryData doInBackground(Object... objArr) {
            int i = 0;
            FaceBuyQueryData faceBuyQueryData = null;
            String obj = objArr[0].toString();
            if (!at.isEmpty(obj)) {
                this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                this.cmJ.addPostData("order_id", obj);
                while (!this.mCanceled && i < FaceBuyModel.this.iTG) {
                    faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.cmJ.postNetData(), FaceBuyQueryData.class);
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
            FaceBuyModel.this.iTF = null;
            this.mCanceled = true;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyQueryData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            FaceBuyModel.this.iTF = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iTE != null) {
            this.iTE.cancel();
            return true;
        }
        return true;
    }
}
