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
    public FaceShopData f14828e;

    /* renamed from: f  reason: collision with root package name */
    public b f14829f;

    /* renamed from: g  reason: collision with root package name */
    public int f14830g;

    /* renamed from: h  reason: collision with root package name */
    public String f14831h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14832i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {

        /* renamed from: a  reason: collision with root package name */
        public int f14833a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f14834b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f14835c;

        public b() {
            this.f14835c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            this.f14833a = ((Integer) objArr[0]).intValue();
            try {
                if (this.f14835c) {
                    return null;
                }
                this.f14834b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                if (this.f14833a == 1) {
                    FaceShopModel.this.f14830g = 0;
                } else if (this.f14833a == 2) {
                    FaceShopModel.u(FaceShopModel.this);
                }
                this.f14834b.addPostData("scr_w", String.valueOf(FaceShopModel.this.j));
                this.f14834b.addPostData("scr_h", String.valueOf(FaceShopModel.this.k));
                this.f14834b.addPostData("scr_dip", String.valueOf(FaceShopModel.this.l));
                this.f14834b.addPostData("offset", String.valueOf(FaceShopModel.this.f14830g));
                this.f14834b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                this.f14834b.addPostData("st_type", FaceShopModel.this.f14831h);
                return (FaceShopData) OrmObject.objectWithJsonStr(this.f14834b.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.f14829f = null;
            if (faceShopData != null) {
                FaceShopModel.this.f14832i = faceShopData.has_more == 1;
                int i2 = this.f14833a;
                if (i2 == 1) {
                    FaceShopModel.this.f14828e = faceShopData;
                } else if (i2 == 2) {
                    FaceShopModel.this.f14828e.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.c(FaceShopModel.this.f14828e);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f14835c = true;
            NetWork netWork = this.f14834b;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f14834b = null;
            }
            FaceShopModel.this.f14829f = null;
        }
    }

    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        this.f14829f = null;
        this.j = 0;
        this.k = 0;
        this.f14828e = null;
        this.f14832i = false;
        this.f14830g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int u(FaceShopModel faceShopModel) {
        int i2 = faceShopModel.f14830g;
        faceShopModel.f14830g = i2 + 1;
        return i2;
    }

    public FaceShopData E() {
        return this.f14828e;
    }

    public boolean F() {
        return this.f14832i;
    }

    public void G(int i2) {
        if (this.f14829f == null) {
            b bVar = new b();
            this.f14829f = bVar;
            bVar.setPriority(3);
            this.f14829f.execute(Integer.valueOf(i2));
        }
    }

    public void H(String str) {
        this.f14831h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f14829f;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }
}
