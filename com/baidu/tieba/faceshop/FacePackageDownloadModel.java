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
    public a f15478e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f15479f;

    /* renamed from: g  reason: collision with root package name */
    public int f15480g;

    /* renamed from: h  reason: collision with root package name */
    public int f15481h;

    /* renamed from: i  reason: collision with root package name */
    public float f15482i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15483a;

        /* renamed from: b  reason: collision with root package name */
        public String f15484b;

        public a(String str) {
            this.f15484b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            try {
                if (this.f15484b != null && this.f15484b.length() > 0) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                    this.f15483a = netWork;
                    netWork.addPostData("pid", this.f15484b);
                    this.f15483a.addPostData("scr_w", String.valueOf(FacePackageDownloadModel.this.f15480g));
                    this.f15483a.addPostData("scr_h", String.valueOf(FacePackageDownloadModel.this.f15481h));
                    this.f15483a.addPostData("scr_dip", String.valueOf(FacePackageDownloadModel.this.f15482i));
                    String postNetData = this.f15483a.postNetData();
                    FacePackageDownloadModel.this.f15479f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(postNetData, FacePackageDownloadData.class);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            return FacePackageDownloadModel.this.f15479f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            FacePackageDownloadModel.this.f15478e = null;
            FacePackageDownloadModel.this.mLoadDataCallBack.c(facePackageDownloadData);
            super.onPostExecute(facePackageDownloadData);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f15483a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15483a = null;
            }
            FacePackageDownloadModel.this.f15478e = null;
        }
    }

    public FacePackageDownloadModel(Context context) {
        super(null);
        this.f15479f = null;
        this.f15480g = 0;
        this.f15481h = 0;
        this.f15478e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f15480g = l.k(inst);
        this.f15481h = l.i(inst);
        this.f15482i = inst.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f15478e;
        if (aVar != null) {
            aVar.cancel();
            return false;
        }
        return false;
    }

    public void z(String str) {
        if (this.f15478e == null) {
            a aVar = new a(str);
            this.f15478e = aVar;
            aVar.setPriority(3);
            this.f15478e.execute(new Object[0]);
        }
    }
}
