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
    private int ceQ;
    private float iWV;
    private FaceShopData iXL;
    private a iYc;
    private boolean mHasMore;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    static /* synthetic */ int a(FaceShopModel faceShopModel) {
        int i = faceShopModel.ceQ;
        faceShopModel.ceQ = i + 1;
        return i;
    }

    public FaceShopModel(r rVar) {
        super(rVar.getPageContext());
        this.iYc = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iXL = null;
        this.mHasMore = false;
        this.ceQ = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iWV = inst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData czB() {
        return this.iXL;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void JY(String str) {
        this.mStType = str;
    }

    public void loadData(int i) {
        if (this.iYc == null) {
            this.iYc = new a();
            this.iYc.setPriority(3);
            this.iYc.execute(Integer.valueOf(i));
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        private com.baidu.tbadk.core.util.aa cnM;
        private int fVT;
        private volatile boolean iWW;

        private a() {
            this.iWW = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public FaceShopData doInBackground(Object... objArr) {
            this.fVT = ((Integer) objArr[0]).intValue();
            try {
                if (!this.iWW) {
                    this.cnM = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.fVT == 1) {
                        FaceShopModel.this.ceQ = 0;
                    } else if (this.fVT == 2) {
                        FaceShopModel.a(FaceShopModel.this);
                    }
                    this.cnM.addPostData("scr_w", String.valueOf(FaceShopModel.this.mScreenWidth));
                    this.cnM.addPostData("scr_h", String.valueOf(FaceShopModel.this.mScreenHeight));
                    this.cnM.addPostData("scr_dip", String.valueOf(FaceShopModel.this.iWV));
                    this.cnM.addPostData("offset", String.valueOf(FaceShopModel.this.ceQ));
                    this.cnM.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.cnM.addPostData("st_type", FaceShopModel.this.mStType);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.cnM.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.iYc = null;
            if (faceShopData != null) {
                FaceShopModel.this.mHasMore = faceShopData.has_more == 1;
                if (this.fVT == 1) {
                    FaceShopModel.this.iXL = faceShopData;
                } else if (this.fVT == 2) {
                    FaceShopModel.this.iXL.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.callback(FaceShopModel.this.iXL);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iWW = true;
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
                this.cnM = null;
            }
            FaceShopModel.this.iYc = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iYc != null) {
            this.iYc.cancel();
            return true;
        }
        return true;
    }
}
