package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes8.dex */
public class FaceShopModel extends BdBaseModel<r> {
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;
    private int bZk;
    private float iPr;
    private FaceShopData iQh;
    private a iQy;
    private boolean mHasMore;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    static /* synthetic */ int a(FaceShopModel faceShopModel) {
        int i = faceShopModel.bZk;
        faceShopModel.bZk = i + 1;
        return i;
    }

    public FaceShopModel(r rVar) {
        super(rVar.getPageContext());
        this.iQy = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iQh = null;
        this.mHasMore = false;
        this.bZk = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iPr = inst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData cyd() {
        return this.iQh;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void Jd(String str) {
        this.mStType = str;
    }

    public void loadData(int i) {
        if (this.iQy == null) {
            this.iQy = new a();
            this.iQy.setPriority(3);
            this.iQy.execute(Integer.valueOf(i));
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        private com.baidu.tbadk.core.util.z chV;
        private int fSe;
        private volatile boolean iPs;

        private a() {
            this.iPs = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public FaceShopData doInBackground(Object... objArr) {
            this.fSe = ((Integer) objArr[0]).intValue();
            try {
                if (!this.iPs) {
                    this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.fSe == 1) {
                        FaceShopModel.this.bZk = 0;
                    } else if (this.fSe == 2) {
                        FaceShopModel.a(FaceShopModel.this);
                    }
                    this.chV.addPostData("scr_w", String.valueOf(FaceShopModel.this.mScreenWidth));
                    this.chV.addPostData("scr_h", String.valueOf(FaceShopModel.this.mScreenHeight));
                    this.chV.addPostData("scr_dip", String.valueOf(FaceShopModel.this.iPr));
                    this.chV.addPostData("offset", String.valueOf(FaceShopModel.this.bZk));
                    this.chV.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.chV.addPostData("st_type", FaceShopModel.this.mStType);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.chV.postNetData(), FaceShopData.class);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(FaceShopData faceShopData) {
            super.onPostExecute(faceShopData);
            FaceShopModel.this.iQy = null;
            if (faceShopData != null) {
                FaceShopModel.this.mHasMore = faceShopData.has_more == 1;
                if (this.fSe == 1) {
                    FaceShopModel.this.iQh = faceShopData;
                } else if (this.fSe == 2) {
                    FaceShopModel.this.iQh.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.callback(FaceShopModel.this.iQh);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iPs = true;
            if (this.chV != null) {
                this.chV.cancelNetConnect();
                this.chV = null;
            }
            FaceShopModel.this.iQy = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iQy != null) {
            this.iQy.cancel();
            return true;
        }
        return true;
    }
}
