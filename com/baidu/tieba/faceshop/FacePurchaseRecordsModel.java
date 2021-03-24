package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f15675e;

    /* renamed from: f  reason: collision with root package name */
    public String f15676f;

    /* renamed from: g  reason: collision with root package name */
    public int f15677g;

    /* renamed from: h  reason: collision with root package name */
    public int f15678h;
    public float i;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15679a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.f15679a = netWork;
                netWork.addPostData("st_type", FacePurchaseRecordsModel.this.f15676f);
                this.f15679a.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.f15677g));
                this.f15679a.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.f15678h));
                this.f15679a.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.i));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f15679a.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.f15675e = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.c(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15679a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.f15675e = null;
        }
    }

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.f15677g = 0;
        this.f15678h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f15677g = l.k(app);
        this.f15678h = l.i(app);
        this.i = app.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15675e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void setStType(String str) {
        this.f15676f = str;
    }

    public void y() {
        if (this.f15675e == null) {
            b bVar = new b();
            this.f15675e = bVar;
            bVar.setPriority(3);
            this.f15675e.execute(new Object[0]);
        }
    }
}
