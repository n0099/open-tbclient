package com.baidu.tieba.faceshop;

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
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f15661e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f15662f;

    /* renamed from: g  reason: collision with root package name */
    public int f15663g;

    /* renamed from: h  reason: collision with root package name */
    public int f15664h;
    public float i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15665a;

        /* renamed from: b  reason: collision with root package name */
        public String f15666b;

        public a(String str) {
            this.f15666b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.f15666b != null && this.f15666b.length() > 0) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.f15665a = netWork;
                    netWork.addPostData("pid", this.f15666b);
                    this.f15665a.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.f15663g));
                    this.f15665a.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.f15664h));
                    this.f15665a.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.i));
                    String postNetData = this.f15665a.postNetData();
                    FacePackageDownloadModel.this.f15662f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return FacePackageDownloadModel.this.f15662f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.f15661e = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.c(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15665a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15665a = null;
            }
            FacePackageDownloadModel.this.f15661e = null;
        }
    }

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.f15662f = null;
        this.f15663g = 0;
        this.f15664h = 0;
        this.f15661e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f15663g = l.k(inst);
        this.f15664h = l.i(inst);
        this.i = inst.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f15661e;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z(String str) {
        if (this.f15661e == null) {
            a aVar = new a(str);
            this.f15661e = aVar;
            aVar.setPriority(3);
            this.f15661e.execute(new Object[0]);
        }
    }
}
