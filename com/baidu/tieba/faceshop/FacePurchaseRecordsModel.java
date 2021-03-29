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
    public b f15676e;

    /* renamed from: f  reason: collision with root package name */
    public String f15677f;

    /* renamed from: g  reason: collision with root package name */
    public int f15678g;

    /* renamed from: h  reason: collision with root package name */
    public int f15679h;
    public float i;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15680a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.f15680a = netWork;
                netWork.addPostData("st_type", FacePurchaseRecordsModel.this.f15677f);
                this.f15680a.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.f15678g));
                this.f15680a.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.f15679h));
                this.f15680a.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.i));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f15680a.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.f15676e = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.c(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15680a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.f15676e = null;
        }
    }

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.f15678g = 0;
        this.f15679h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f15678g = l.k(app);
        this.f15679h = l.i(app);
        this.i = app.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15676e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void setStType(String str) {
        this.f15677f = str;
    }

    public void y() {
        if (this.f15676e == null) {
            b bVar = new b();
            this.f15676e = bVar;
            bVar.setPriority(3);
            this.f15676e.execute(new Object[0]);
        }
    }
}
