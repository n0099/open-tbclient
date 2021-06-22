package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class FacePackageDetailModel extends BdBaseModel<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f14827e;

    /* renamed from: f  reason: collision with root package name */
    public int f14828f;

    /* renamed from: g  reason: collision with root package name */
    public String f14829g;

    /* renamed from: h  reason: collision with root package name */
    public String f14830h;

    /* renamed from: i  reason: collision with root package name */
    public String f14831i;
    public String j;
    public FacePackageDetailData k;
    public b l;
    public int m;
    public int n;
    public float o;
    public ProxyAdkBaseActivity.LoadDataCallBack p;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, String, FacePackageDetailData> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14832a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f14833b;

        public b() {
            this.f14833b = false;
        }

        public final void b(String str) {
            l<String> g2 = d.a.n0.r.r.a.f().g("tb_face_package");
            if (g2 != null) {
                g2.e(TbadkCoreApplication.getCurrentAccount() + FacePackageDetailModel.this.f14830h, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData = null;
            try {
                if (FacePackageDetailModel.this.f14830h == null || FacePackageDetailModel.this.f14830h.length() <= 0 || this.f14833b) {
                    return null;
                }
                l<String> g2 = d.a.n0.r.r.a.f().g("tb_face_package");
                if (g2 != null) {
                    String str = g2.get(TbadkCoreApplication.getCurrentAccount() + FacePackageDetailModel.this.f14830h);
                    if (!k.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.f14832a = netWork;
                netWork.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.m));
                this.f14832a.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.n));
                this.f14832a.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.o));
                this.f14832a.addPostData("pid", FacePackageDetailModel.this.f14830h);
                this.f14832a.addPostData("st_type", FacePackageDetailModel.this.f14829g);
                String postNetData = this.f14832a.postNetData();
                FacePackageDetailData facePackageDetailData2 = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData2 != null) {
                    try {
                        if (facePackageDetailData2.faces_list != null) {
                            b(postNetData);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        facePackageDetailData = facePackageDetailData2;
                        BdLog.detailException(e);
                        return facePackageDetailData;
                    }
                }
                return facePackageDetailData2;
            } catch (Exception e3) {
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f14833b = true;
            NetWork netWork = this.f14832a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f14832a = null;
            }
            FacePackageDetailModel.this.l = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(FacePackageDetailData facePackageDetailData) {
            super.onPostExecute(facePackageDetailData);
            FacePackageDetailModel.this.l = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.k = facePackageDetailData;
            }
            FacePackageDetailModel.this.p.callback(facePackageDetailData, Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
            FacePackageDetailModel.this.k = facePackageDetailData;
            FacePackageDetailModel.this.p.callback(facePackageDetailData, Boolean.TRUE);
            super.onProgressUpdate((Object[]) strArr);
        }
    }

    public FacePackageDetailModel(FacePackageDetailActivity facePackageDetailActivity) {
        super(facePackageDetailActivity.getPageContext());
        this.f14831i = null;
        this.m = 0;
        this.n = 0;
        this.p = null;
        this.l = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.m = d.a.c.e.p.l.k(inst);
        this.n = d.a.c.e.p.l.i(inst);
        this.o = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData E() {
        return this.k;
    }

    public String F() {
        return this.f14831i;
    }

    public boolean G() {
        return this.f14827e;
    }

    public String H() {
        return this.j;
    }

    public int I() {
        return this.f14828f;
    }

    public void J() {
        if (this.l == null) {
            b bVar = new b();
            this.l = bVar;
            bVar.setPriority(3);
            this.l.execute(new Object[0]);
        }
    }

    public void K(String str) {
        this.f14831i = str;
    }

    public void L(boolean z) {
        this.f14827e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.p = loadDataCallBack;
    }

    public void N(String str) {
        this.j = str;
    }

    public void O(FacePackageData facePackageData) {
        if (facePackageData == null) {
            return;
        }
        int i2 = facePackageData.buy_status;
        int i3 = facePackageData.can_download;
        int i4 = facePackageData.downloading;
        int i5 = facePackageData.downloaded;
        if (i4 == 1) {
            this.f14828f = 5;
        } else if (i5 == 1) {
            this.f14828f = 1;
        } else if (i2 == 2) {
            this.f14828f = 6;
        } else if (i2 == 1) {
            if (i3 == 1) {
                this.f14828f = 2;
            }
        } else if (i2 == 0) {
            if (i3 == 1) {
                this.f14828f = 3;
            } else {
                this.f14828f = 4;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public String getPid() {
        return this.f14830h;
    }

    public String getStType() {
        return this.f14829g;
    }

    public void setPid(String str) {
        this.f14830h = str;
    }

    public void setStType(String str) {
        this.f14829g = str;
    }
}
