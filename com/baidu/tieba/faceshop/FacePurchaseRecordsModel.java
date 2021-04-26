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
    public b f15494e;

    /* renamed from: f  reason: collision with root package name */
    public String f15495f;

    /* renamed from: g  reason: collision with root package name */
    public int f15496g;

    /* renamed from: h  reason: collision with root package name */
    public int f15497h;

    /* renamed from: i  reason: collision with root package name */
    public float f15498i;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15499a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                this.f15499a = netWork;
                netWork.addPostData("st_type", FacePurchaseRecordsModel.this.f15495f);
                this.f15499a.addPostData("scr_w", String.valueOf(FacePurchaseRecordsModel.this.f15496g));
                this.f15499a.addPostData("scr_h", String.valueOf(FacePurchaseRecordsModel.this.f15497h));
                this.f15499a.addPostData("scr_dip", String.valueOf(FacePurchaseRecordsModel.this.f15498i));
                return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f15499a.postNetData(), FacePurchaseRecordsData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            FacePurchaseRecordsModel.this.f15494e = null;
            FacePurchaseRecordsModel.this.mLoadDataCallBack.c(facePurchaseRecordsData);
            super.onPostExecute(facePurchaseRecordsData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15499a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FacePurchaseRecordsModel.this.f15494e = null;
        }
    }

    public FacePurchaseRecordsModel(Context context) {
        super(null);
        this.f15496g = 0;
        this.f15497h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f15496g = l.k(app);
        this.f15497h = l.i(app);
        this.f15498i = app.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15494e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void setStType(String str) {
        this.f15495f = str;
    }

    public void y() {
        if (this.f15494e == null) {
            b bVar = new b();
            this.f15494e = bVar;
            bVar.setPriority(3);
            this.f15494e.execute(new Object[0]);
        }
    }
}
