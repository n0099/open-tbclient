package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.faceshop.FaceBuyQueryData;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class FaceBuyModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public c f14659e;

    /* renamed from: f  reason: collision with root package name */
    public b f14660f;

    /* renamed from: g  reason: collision with root package name */
    public int f14661g;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14662a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f14663b;

        public b() {
            this.f14663b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceBuyQueryData doInBackground(Object... objArr) {
            FaceBuyQueryData.BuyResult buyResult;
            String obj = objArr[0].toString();
            FaceBuyQueryData faceBuyQueryData = null;
            if (!k.isEmpty(obj)) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                this.f14662a = netWork;
                netWork.addPostData("order_id", obj);
                for (int i2 = 0; !this.f14663b && i2 < FaceBuyModel.this.f14661g; i2++) {
                    faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.f14662a.postNetData(), FaceBuyQueryData.class);
                    if (faceBuyQueryData != null && (buyResult = faceBuyQueryData.buy_result) != null) {
                        if (buyResult.status == 2) {
                            break;
                        }
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e2) {
                            BdLog.detailException(e2);
                        }
                    } else {
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e3) {
                            BdLog.detailException(e3);
                        }
                    }
                }
            }
            return faceBuyQueryData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceBuyQueryData faceBuyQueryData) {
            super.onPostExecute(faceBuyQueryData);
            FaceBuyModel.this.f14660f = null;
            this.f14663b = true;
            FaceBuyModel.this.mLoadDataCallBack.c(faceBuyQueryData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f14662a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FaceBuyModel.this.f14660f = null;
            FaceBuyModel.this.mLoadDataCallBack.c(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14665a;

        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceBuyData doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                this.f14665a = netWork;
                netWork.addPostData("pid", obj);
                return (FaceBuyData) OrmObject.objectWithJsonStr(this.f14665a.postNetData(), FaceBuyData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceBuyData faceBuyData) {
            super.onPostExecute(faceBuyData);
            FaceBuyModel.this.f14659e = null;
            FaceBuyModel.this.mLoadDataCallBack.c(faceBuyData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f14665a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FaceBuyModel.this.f14659e = null;
            FaceBuyModel.this.mLoadDataCallBack.c(null);
        }
    }

    public FaceBuyModel(Context context) {
        super(null);
        this.f14661g = 3;
        this.f14659e = null;
        this.f14660f = null;
    }

    public void A(String str) {
        if (this.f14660f == null) {
            b bVar = new b();
            this.f14660f = bVar;
            bVar.setPriority(3);
            this.f14660f.execute(str);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        c cVar = this.f14659e;
        if (cVar != null) {
            cVar.cancel();
            return true;
        }
        return true;
    }

    public void z(String str) {
        if (this.f14659e == null) {
            c cVar = new c();
            this.f14659e = cVar;
            cVar.setPriority(3);
            this.f14659e.execute(str);
        }
    }
}
