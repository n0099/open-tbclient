package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class FaceShopModel extends BdBaseModel<FaceShopActivity> {
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f15692e;

    /* renamed from: f  reason: collision with root package name */
    public b f15693f;

    /* renamed from: g  reason: collision with root package name */
    public int f15694g;

    /* renamed from: h  reason: collision with root package name */
    public String f15695h;
    public boolean i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f15696a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f15697b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f15698c;

        public b() {
            this.f15698c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f15696a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f15698c) {
                    return null;
                }
                this.f15697b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f15696a == 1) {
                    FaceShopModel.this.f15694g = 0;
                } else if (this.f15696a == 2) {
                    FaceShopModel.u(FaceShopModel.this);
                }
                this.f15697b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f15697b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f15697b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f15697b.addPostData("offset", String.valueOf(FaceShopModel.this.f15694g));
                this.f15697b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f15697b.addPostData("st_type", FaceShopModel.this.f15695h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f15697b.postNetData(), FaceShopData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceShopData faceShopData) {
            super.onPostExecute(faceShopData);
            FaceShopModel.this.f15693f = null;
            if (faceShopData != null) {
                FaceShopModel.this.i = faceShopData.has_more == 1;
                int i = this.f15696a;
                if (i == 1) {
                    FaceShopModel.this.f15692e = faceShopData;
                } else if (i == 2) {
                    FaceShopModel.this.f15692e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f15692e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f15698c = true;
            NetWork netWork = this.f15697b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15697b = null;
            }
            FaceShopModel.this.f15693f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f15693f = null;
        this.j = 0;
        this.k = 0;
        this.f15692e = null;
        this.i = false;
        this.f15694g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int u(FaceShopModel faceShopModel) {
        int i = faceShopModel.f15694g;
        faceShopModel.f15694g = i + 1;
        return i;
    }

    public FaceShopData E() {
        return this.f15692e;
    }

    public boolean F() {
        return this.i;
    }

    public void G(int i) {
        if (this.f15693f == null) {
            b bVar = new b();
            this.f15693f = bVar;
            bVar.setPriority(3);
            this.f15693f.execute(Integer.valueOf(i));
        }
    }

    public void H(String str) {
        this.f15695h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15693f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
