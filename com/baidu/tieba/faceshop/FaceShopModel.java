package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FaceShopModel extends BdBaseModel<FaceShopActivity> {
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f14788e;

    /* renamed from: f  reason: collision with root package name */
    public b f14789f;

    /* renamed from: g  reason: collision with root package name */
    public int f14790g;

    /* renamed from: h  reason: collision with root package name */
    public String f14791h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14792i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f14793a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f14794b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f14795c;

        public b() {
            this.f14795c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f14793a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f14795c) {
                    return null;
                }
                this.f14794b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f14793a == 1) {
                    FaceShopModel.this.f14790g = 0;
                } else if (this.f14793a == 2) {
                    FaceShopModel.y(FaceShopModel.this);
                }
                this.f14794b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f14794b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f14794b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f14794b.addPostData("offset", String.valueOf(FaceShopModel.this.f14790g));
                this.f14794b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f14794b.addPostData("st_type", FaceShopModel.this.f14791h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f14794b.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.f14789f = null;
            if (faceShopData != null) {
                FaceShopModel.this.f14792i = faceShopData.has_more == 1;
                int i2 = this.f14793a;
                if (i2 == 1) {
                    FaceShopModel.this.f14788e = faceShopData;
                } else if (i2 == 2) {
                    FaceShopModel.this.f14788e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f14788e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f14795c = true;
            NetWork netWork = this.f14794b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f14794b = null;
            }
            FaceShopModel.this.f14789f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f14789f = null;
        this.j = 0;
        this.k = 0;
        this.f14788e = null;
        this.f14792i = false;
        this.f14790g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int y(FaceShopModel faceShopModel) {
        int i2 = faceShopModel.f14790g;
        faceShopModel.f14790g = i2 + 1;
        return i2;
    }

    public FaceShopData I() {
        return this.f14788e;
    }

    public boolean J() {
        return this.f14792i;
    }

    public void K(int i2) {
        if (this.f14789f == null) {
            b bVar = new b();
            this.f14789f = bVar;
            bVar.setPriority(3);
            this.f14789f.execute(Integer.valueOf(i2));
        }
    }

    public void L(String str) {
        this.f14791h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f14789f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
