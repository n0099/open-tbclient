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
    public FaceShopData f15513e;

    /* renamed from: f  reason: collision with root package name */
    public b f15514f;

    /* renamed from: g  reason: collision with root package name */
    public int f15515g;

    /* renamed from: h  reason: collision with root package name */
    public String f15516h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15517i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f15518a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f15519b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f15520c;

        public b() {
            this.f15520c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f15518a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f15520c) {
                    return null;
                }
                this.f15519b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f15518a == 1) {
                    FaceShopModel.this.f15515g = 0;
                } else if (this.f15518a == 2) {
                    FaceShopModel.u(FaceShopModel.this);
                }
                this.f15519b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f15519b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f15519b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f15519b.addPostData("offset", String.valueOf(FaceShopModel.this.f15515g));
                this.f15519b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f15519b.addPostData("st_type", FaceShopModel.this.f15516h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f15519b.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.f15514f = null;
            if (faceShopData != null) {
                FaceShopModel.this.f15517i = faceShopData.has_more == 1;
                int i2 = this.f15518a;
                if (i2 == 1) {
                    FaceShopModel.this.f15513e = faceShopData;
                } else if (i2 == 2) {
                    FaceShopModel.this.f15513e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f15513e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f15520c = true;
            NetWork netWork = this.f15519b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f15519b = null;
            }
            FaceShopModel.this.f15514f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f15514f = null;
        this.j = 0;
        this.k = 0;
        this.f15513e = null;
        this.f15517i = false;
        this.f15515g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int u(FaceShopModel faceShopModel) {
        int i2 = faceShopModel.f15515g;
        faceShopModel.f15515g = i2 + 1;
        return i2;
    }

    public FaceShopData E() {
        return this.f15513e;
    }

    public boolean F() {
        return this.f15517i;
    }

    public void G(int i2) {
        if (this.f15514f == null) {
            b bVar = new b();
            this.f15514f = bVar;
            bVar.setPriority(3);
            this.f15514f.execute(Integer.valueOf(i2));
        }
    }

    public void H(String str) {
        this.f15516h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f15514f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
