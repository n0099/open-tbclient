package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f15333e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f15334f;

    /* renamed from: g  reason: collision with root package name */
    public int f15335g;

    /* renamed from: h  reason: collision with root package name */
    public int f15336h;
    public float i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15337a;

        /* renamed from: b  reason: collision with root package name */
        public String f15338b;

        public a(String str) {
            this.f15338b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.f15338b != null && this.f15338b.length() > 0) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.f15337a = netWork;
                    netWork.addPostData("pid", this.f15338b);
                    this.f15337a.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.f15335g));
                    this.f15337a.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.f15336h));
                    this.f15337a.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.i));
                    String postNetData = this.f15337a.postNetData();
                    FacePackageDownloadModel.this.f15334f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return FacePackageDownloadModel.this.f15334f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.f15333e = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.c(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15337a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15337a = null;
            }
            FacePackageDownloadModel.this.f15333e = null;
        }
    }

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.f15334f = null;
        this.f15335g = 0;
        this.f15336h = 0;
        this.f15333e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f15335g = l.k(inst);
        this.f15336h = l.i(inst);
        this.i = inst.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f15333e;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z(String str) {
        if (this.f15333e == null) {
            a aVar = new a(str);
            this.f15333e = aVar;
            aVar.setPriority(3);
            this.f15333e.execute(new Object[0]);
        }
    }
}
