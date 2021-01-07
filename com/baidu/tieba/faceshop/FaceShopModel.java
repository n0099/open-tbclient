package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes9.dex */
public class FaceShopModel extends BdBaseModel<r> {
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;
    private int cea;
    private float iTY;
    private FaceShopData iUO;
    private a iVf;
    private boolean mHasMore;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    static /* synthetic */ int a(FaceShopModel faceShopModel) {
        int i = faceShopModel.cea;
        faceShopModel.cea = i + 1;
        return i;
    }

    public FaceShopModel(r rVar) {
        super(rVar.getPageContext());
        this.iVf = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iUO = null;
        this.mHasMore = false;
        this.cea = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iTY = inst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData cBV() {
        return this.iUO;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void Ko(String str) {
        this.mStType = str;
    }

    public void loadData(int i) {
        if (this.iVf == null) {
            this.iVf = new a();
            this.iVf.setPriority(3);
            this.iVf.execute(Integer.valueOf(i));
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        private com.baidu.tbadk.core.util.z cmJ;
        private int fWL;
        private volatile boolean iTZ;

        private a() {
            this.iTZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public FaceShopData doInBackground(Object... objArr) {
            this.fWL = ((Integer) objArr[0]).intValue();
            try {
                if (!this.iTZ) {
                    this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.fWL == 1) {
                        FaceShopModel.this.cea = 0;
                    } else if (this.fWL == 2) {
                        FaceShopModel.a(FaceShopModel.this);
                    }
                    this.cmJ.addPostData("scr_w", String.valueOf(FaceShopModel.this.mScreenWidth));
                    this.cmJ.addPostData("scr_h", String.valueOf(FaceShopModel.this.mScreenHeight));
                    this.cmJ.addPostData("scr_dip", String.valueOf(FaceShopModel.this.iTY));
                    this.cmJ.addPostData("offset", String.valueOf(FaceShopModel.this.cea));
                    this.cmJ.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.cmJ.addPostData("st_type", FaceShopModel.this.mStType);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.cmJ.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.iVf = null;
            if (faceShopData != null) {
                FaceShopModel.this.mHasMore = faceShopData.has_more == 1;
                if (this.fWL == 1) {
                    FaceShopModel.this.iUO = faceShopData;
                } else if (this.fWL == 2) {
                    FaceShopModel.this.iUO.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.callback(FaceShopModel.this.iUO);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iTZ = true;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
                this.cmJ = null;
            }
            FaceShopModel.this.iVf = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVf != null) {
            this.iVf.cancel();
            return true;
        }
        return true;
    }
}
