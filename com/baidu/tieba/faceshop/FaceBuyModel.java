package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes8.dex */
public class FaceBuyModel extends BdBaseModel {
    private b iOX;
    private a iOY;
    private int iOZ;

    public FaceBuyModel(Context context) {
        super(null);
        this.iOZ = 3;
        this.iOX = null;
        this.iOY = null;
    }

    public void IW(String str) {
        if (this.iOX == null) {
            this.iOX = new b();
            this.iOX.setPriority(3);
            this.iOX.execute(str);
        }
    }

    public void IX(String str) {
        if (this.iOY == null) {
            this.iOY = new a();
            this.iOY.setPriority(3);
            this.iOY.execute(str);
        }
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        private com.baidu.tbadk.core.util.z chV;

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public FaceBuyData doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            try {
                this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                this.chV.addPostData("pid", obj);
                return (FaceBuyData) OrmObject.objectWithJsonStr(this.chV.postNetData(), FaceBuyData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            FaceBuyModel.this.iOX = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FaceBuyData faceBuyData) {
            super.onPostExecute(faceBuyData);
            FaceBuyModel.this.iOX = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyData);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        private com.baidu.tbadk.core.util.z chV;
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
                this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                this.chV.addPostData("order_id", obj);
                while (!this.mCanceled && i < FaceBuyModel.this.iOZ) {
                    faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.chV.postNetData(), FaceBuyQueryData.class);
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
            FaceBuyModel.this.iOY = null;
            this.mCanceled = true;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyQueryData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            FaceBuyModel.this.iOY = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iOX != null) {
            this.iOX.cancel();
            return true;
        }
        return true;
    }
}
