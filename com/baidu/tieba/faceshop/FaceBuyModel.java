package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes9.dex */
public class FaceBuyModel extends BdBaseModel {
    private b iUE;
    private a iUF;
    private int iUG;

    public FaceBuyModel(Context context) {
        super(null);
        this.iUG = 3;
        this.iUE = null;
        this.iUF = null;
    }

    public void JH(String str) {
        if (this.iUE == null) {
            this.iUE = new b();
            this.iUE.setPriority(3);
            this.iUE.execute(str);
        }
    }

    public void JI(String str) {
        if (this.iUF == null) {
            this.iUF = new a();
            this.iUF.setPriority(3);
            this.iUF.execute(str);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        private com.baidu.tbadk.core.util.aa cml;

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public FaceBuyData doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            try {
                this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                this.cml.addPostData("pid", obj);
                return (FaceBuyData) OrmObject.objectWithJsonStr(this.cml.postNetData(), FaceBuyData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            FaceBuyModel.this.iUE = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FaceBuyData faceBuyData) {
            super.onPostExecute(faceBuyData);
            FaceBuyModel.this.iUE = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyData);
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        private com.baidu.tbadk.core.util.aa cml;
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
            if (!au.isEmpty(obj)) {
                this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                this.cml.addPostData("order_id", obj);
                while (!this.mCanceled && i < FaceBuyModel.this.iUG) {
                    faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.cml.postNetData(), FaceBuyQueryData.class);
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
            FaceBuyModel.this.iUF = null;
            this.mCanceled = true;
            FaceBuyModel.this.mLoadDataCallBack.callback(faceBuyQueryData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            FaceBuyModel.this.iUF = null;
            FaceBuyModel.this.mLoadDataCallBack.callback(null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iUE != null) {
            this.iUE.cancel();
            return true;
        }
        return true;
    }
}
