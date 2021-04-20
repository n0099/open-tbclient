package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class FaceShopModel extends BdBaseModel<FaceShopActivity> {
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f15356e;

    /* renamed from: f  reason: collision with root package name */
    public b f15357f;

    /* renamed from: g  reason: collision with root package name */
    public int f15358g;

    /* renamed from: h  reason: collision with root package name */
    public String f15359h;
    public boolean i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f15360a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f15361b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f15362c;

        public b() {
            this.f15362c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f15360a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f15362c) {
                    return null;
                }
                this.f15361b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f15360a == 1) {
                    FaceShopModel.this.f15358g = 0;
                } else if (this.f15360a == 2) {
                    FaceShopModel.u(FaceShopModel.this);
                }
                this.f15361b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f15361b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f15361b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f15361b.addPostData("offset", String.valueOf(FaceShopModel.this.f15358g));
                this.f15361b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f15361b.addPostData("st_type", FaceShopModel.this.f15359h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f15361b.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.f15357f = null;
            if (faceShopData != null) {
                FaceShopModel.this.i = faceShopData.has_more == 1;
                int i = this.f15360a;
                if (i == 1) {
                    FaceShopModel.this.f15356e = faceShopData;
                } else if (i == 2) {
                    FaceShopModel.this.f15356e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f15356e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f15362c = true;
            NetWork netWork = this.f15361b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15361b = null;
            }
            FaceShopModel.this.f15357f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f15357f = null;
        this.j = 0;
        this.k = 0;
        this.f15356e = null;
        this.i = false;
        this.f15358g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int u(FaceShopModel faceShopModel) {
        int i = faceShopModel.f15358g;
        faceShopModel.f15358g = i + 1;
        return i;
    }

    public FaceShopData E() {
        return this.f15356e;
    }

    public boolean F() {
        return this.i;
    }

    public void G(int i) {
        if (this.f15357f == null) {
            b bVar = new b();
            this.f15357f = bVar;
            bVar.setPriority(3);
            this.f15357f.execute(Integer.valueOf(i));
        }
    }

    public void H(String str) {
        this.f15359h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15357f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
