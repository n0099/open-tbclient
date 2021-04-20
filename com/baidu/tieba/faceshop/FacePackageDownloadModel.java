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
    public a f15325e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f15326f;

    /* renamed from: g  reason: collision with root package name */
    public int f15327g;

    /* renamed from: h  reason: collision with root package name */
    public int f15328h;
    public float i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15329a;

        /* renamed from: b  reason: collision with root package name */
        public String f15330b;

        public a(String str) {
            this.f15330b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.f15330b != null && this.f15330b.length() > 0) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.f15329a = netWork;
                    netWork.addPostData("pid", this.f15330b);
                    this.f15329a.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.f15327g));
                    this.f15329a.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.f15328h));
                    this.f15329a.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.i));
                    String postNetData = this.f15329a.postNetData();
                    FacePackageDownloadModel.this.f15326f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return FacePackageDownloadModel.this.f15326f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.f15325e = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.c(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15329a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15329a = null;
            }
            FacePackageDownloadModel.this.f15325e = null;
        }
    }

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.f15326f = null;
        this.f15327g = 0;
        this.f15328h = 0;
        this.f15325e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f15327g = l.k(inst);
        this.f15328h = l.i(inst);
        this.i = inst.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f15325e;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z(String str) {
        if (this.f15325e == null) {
            a aVar = new a(str);
            this.f15325e = aVar;
            aVar.setPriority(3);
            this.f15325e.execute(new Object[0]);
        }
    }
}
