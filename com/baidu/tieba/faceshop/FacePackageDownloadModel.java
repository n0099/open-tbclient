package com.baidu.tieba.faceshop;

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
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f14793e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f14794f;

    /* renamed from: g  reason: collision with root package name */
    public int f14795g;

    /* renamed from: h  reason: collision with root package name */
    public int f14796h;

    /* renamed from: i  reason: collision with root package name */
    public float f14797i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14798a;

        /* renamed from: b  reason: collision with root package name */
        public String f14799b;

        public a(String str) {
            this.f14799b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.f14799b != null && this.f14799b.length() > 0) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.f14798a = netWork;
                    netWork.addPostData("pid", this.f14799b);
                    this.f14798a.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.f14795g));
                    this.f14798a.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.f14796h));
                    this.f14798a.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.f14797i));
                    String postNetData = this.f14798a.postNetData();
                    FacePackageDownloadModel.this.f14794f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return FacePackageDownloadModel.this.f14794f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.f14793e = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.c(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f14798a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f14798a = null;
            }
            FacePackageDownloadModel.this.f14793e = null;
        }
    }

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.f14794f = null;
        this.f14795g = 0;
        this.f14796h = 0;
        this.f14793e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f14795g = l.k(inst);
        this.f14796h = l.i(inst);
        this.f14797i = inst.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f14793e;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z(String str) {
        if (this.f14793e == null) {
            a aVar = new a(str);
            this.f14793e = aVar;
            aVar.setPriority(3);
            this.f14793e.execute(new Object[0]);
        }
    }
}
