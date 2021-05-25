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
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f14712e;

    /* renamed from: f  reason: collision with root package name */
    public String f14713f;

    /* renamed from: g  reason: collision with root package name */
    public int f14714g;

    /* renamed from: h  reason: collision with root package name */
    public int f14715h;

    /* renamed from: i  reason: collision with root package name */
    public float f14716i;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14717a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.f14717a = netWork;
                netWork.addPostData("st_type", FacePurchaseRecordsModel.this.f14713f);
                this.f14717a.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.f14714g));
                this.f14717a.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.f14715h));
                this.f14717a.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.f14716i));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f14717a.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.f14712e = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.c(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f14717a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.f14712e = null;
        }
    }

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.f14714g = 0;
        this.f14715h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f14714g = l.k(app);
        this.f14715h = l.i(app);
        this.f14716i = app.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f14712e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void setStType(String str) {
        this.f14713f = str;
    }

    public void y() {
        if (this.f14712e == null) {
            b bVar = new b();
            this.f14712e = bVar;
            bVar.setPriority(3);
            this.f14712e.execute(new Object[0]);
        }
    }
}
