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
import d.b.c.e.d.l;
import d.b.c.e.p.k;
/* loaded from: classes4.dex */
public class FacePackageDetailModel extends BdBaseModel<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f15318e;

    /* renamed from: f  reason: collision with root package name */
    public int f15319f;

    /* renamed from: g  reason: collision with root package name */
    public String f15320g;

    /* renamed from: h  reason: collision with root package name */
    public String f15321h;
    public String i;
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
        public NetWork f15322a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f15323b;

        public b() {
            this.f15323b = false;
        }

        public final void b(String str) {
            l<String> g2 = d.b.h0.r.r.a.f().g("tb_face_package");
            if (g2 != null) {
                g2.e(TbadkCoreApplication.getCurrentAccount() + FacePackageDetailModel.this.f15321h, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData = null;
            try {
                if (FacePackageDetailModel.this.f15321h == null || FacePackageDetailModel.this.f15321h.length() <= 0 || this.f15323b) {
                    return null;
                }
                l<String> g2 = d.b.h0.r.r.a.f().g("tb_face_package");
                if (g2 != null) {
                    String str = g2.get(TbadkCoreApplication.getCurrentAccount() + FacePackageDetailModel.this.f15321h);
                    if (!k.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.f15322a = netWork;
                netWork.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.m));
                this.f15322a.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.n));
                this.f15322a.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.o));
                this.f15322a.addPostData("pid", FacePackageDetailModel.this.f15321h);
                this.f15322a.addPostData("st_type", FacePackageDetailModel.this.f15320g);
                String postNetData = this.f15322a.postNetData();
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
            this.f15323b = true;
            NetWork netWork = this.f15322a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15322a = null;
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
        this.i = null;
        this.m = 0;
        this.n = 0;
        this.p = null;
        this.l = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.m = d.b.c.e.p.l.k(inst);
        this.n = d.b.c.e.p.l.i(inst);
        this.o = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData A() {
        return this.k;
    }

    public String B() {
        return this.i;
    }

    public boolean C() {
        return this.f15318e;
    }

    public String D() {
        return this.j;
    }

    public int E() {
        return this.f15319f;
    }

    public void F() {
        if (this.l == null) {
            b bVar = new b();
            this.l = bVar;
            bVar.setPriority(3);
            this.l.execute(new Object[0]);
        }
    }

    public void G(String str) {
        this.i = str;
    }

    public void H(boolean z) {
        this.f15318e = z;
    }

    public void I(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.p = loadDataCallBack;
    }

    public void J(String str) {
        this.j = str;
    }

    public void K(FacePackageData facePackageData) {
        if (facePackageData == null) {
            return;
        }
        int i = facePackageData.buy_status;
        int i2 = facePackageData.can_download;
        int i3 = facePackageData.downloading;
        int i4 = facePackageData.downloaded;
        if (i3 == 1) {
            this.f15319f = 5;
        } else if (i4 == 1) {
            this.f15319f = 1;
        } else if (i == 2) {
            this.f15319f = 6;
        } else if (i == 1) {
            if (i2 == 1) {
                this.f15319f = 2;
            }
        } else if (i == 0) {
            if (i2 == 1) {
                this.f15319f = 3;
            } else {
                this.f15319f = 4;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
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
        return this.f15321h;
    }

    public String getStType() {
        return this.f15320g;
    }

    public void setPid(String str) {
        this.f15321h = str;
    }

    public void setStType(String str) {
        this.f15320g = str;
    }
}
