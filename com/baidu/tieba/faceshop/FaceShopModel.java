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
    public FaceShopData f15693e;

    /* renamed from: f  reason: collision with root package name */
    public b f15694f;

    /* renamed from: g  reason: collision with root package name */
    public int f15695g;

    /* renamed from: h  reason: collision with root package name */
    public String f15696h;
    public boolean i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f15697a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f15698b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f15699c;

        public b() {
            this.f15699c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f15697a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f15699c) {
                    return null;
                }
                this.f15698b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f15697a == 1) {
                    FaceShopModel.this.f15695g = 0;
                } else if (this.f15697a == 2) {
                    FaceShopModel.u(FaceShopModel.this);
                }
                this.f15698b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f15698b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f15698b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f15698b.addPostData("offset", String.valueOf(FaceShopModel.this.f15695g));
                this.f15698b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f15698b.addPostData("st_type", FaceShopModel.this.f15696h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f15698b.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.f15694f = null;
            if (faceShopData != null) {
                FaceShopModel.this.i = faceShopData.has_more == 1;
                int i = this.f15697a;
                if (i == 1) {
                    FaceShopModel.this.f15693e = faceShopData;
                } else if (i == 2) {
                    FaceShopModel.this.f15693e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f15693e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f15699c = true;
            NetWork netWork = this.f15698b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15698b = null;
            }
            FaceShopModel.this.f15694f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f15694f = null;
        this.j = 0;
        this.k = 0;
        this.f15693e = null;
        this.i = false;
        this.f15695g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int u(FaceShopModel faceShopModel) {
        int i = faceShopModel.f15695g;
        faceShopModel.f15695g = i + 1;
        return i;
    }

    public FaceShopData E() {
        return this.f15693e;
    }

    public boolean F() {
        return this.i;
    }

    public void G(int i) {
        if (this.f15694f == null) {
            b bVar = new b();
            this.f15694f = bVar;
            bVar.setPriority(3);
            this.f15694f.execute(Integer.valueOf(i));
        }
    }

    public void H(String str) {
        this.f15696h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15694f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
