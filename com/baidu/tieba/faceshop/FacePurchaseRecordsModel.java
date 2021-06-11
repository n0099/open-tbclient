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
    public b f14769e;

    /* renamed from: f  reason: collision with root package name */
    public String f14770f;

    /* renamed from: g  reason: collision with root package name */
    public int f14771g;

    /* renamed from: h  reason: collision with root package name */
    public int f14772h;

    /* renamed from: i  reason: collision with root package name */
    public float f14773i;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14774a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.f14774a = netWork;
                netWork.addPostData("st_type", FacePurchaseRecordsModel.this.f14770f);
                this.f14774a.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.f14771g));
                this.f14774a.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.f14772h));
                this.f14774a.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.f14773i));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f14774a.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.f14769e = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.c(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f14774a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.f14769e = null;
        }
    }

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.f14771g = 0;
        this.f14772h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f14771g = l.k(app);
        this.f14772h = l.i(app);
        this.f14773i = app.getResources().getDisplayMetrics().density;
    }

    public void C() {
        if (this.f14769e == null) {
            b bVar = new b();
            this.f14769e = bVar;
            bVar.setPriority(3);
            this.f14769e.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f14769e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void setStType(String str) {
        this.f14770f = str;
    }
}
