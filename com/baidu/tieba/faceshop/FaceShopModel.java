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
    private int cdp;
    private float iUY;
    private FaceShopData iVO;
    private a iWf;
    private boolean mHasMore;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    static /* synthetic */ int a(FaceShopModel faceShopModel) {
        int i = faceShopModel.cdp;
        faceShopModel.cdp = i + 1;
        return i;
    }

    public FaceShopModel(r rVar) {
        super(rVar.getPageContext());
        this.iWf = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iVO = null;
        this.mHasMore = false;
        this.cdp = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iUY = inst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData czo() {
        return this.iVO;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void JO(String str) {
        this.mStType = str;
    }

    public void loadData(int i) {
        if (this.iWf == null) {
            this.iWf = new a();
            this.iWf.setPriority(3);
            this.iWf.execute(Integer.valueOf(i));
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        private com.baidu.tbadk.core.util.aa cml;
        private int fUt;
        private volatile boolean iUZ;

        private a() {
            this.iUZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public FaceShopData doInBackground(Object... objArr) {
            this.fUt = ((Integer) objArr[0]).intValue();
            try {
                if (!this.iUZ) {
                    this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.fUt == 1) {
                        FaceShopModel.this.cdp = 0;
                    } else if (this.fUt == 2) {
                        FaceShopModel.a(FaceShopModel.this);
                    }
                    this.cml.addPostData("scr_w", String.valueOf(FaceShopModel.this.mScreenWidth));
                    this.cml.addPostData("scr_h", String.valueOf(FaceShopModel.this.mScreenHeight));
                    this.cml.addPostData("scr_dip", String.valueOf(FaceShopModel.this.iUY));
                    this.cml.addPostData("offset", String.valueOf(FaceShopModel.this.cdp));
                    this.cml.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.cml.addPostData("st_type", FaceShopModel.this.mStType);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.cml.postNetData(), FaceShopData.class);
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
            FaceShopModel.this.iWf = null;
            if (faceShopData != null) {
                FaceShopModel.this.mHasMore = faceShopData.has_more == 1;
                if (this.fUt == 1) {
                    FaceShopModel.this.iVO = faceShopData;
                } else if (this.fUt == 2) {
                    FaceShopModel.this.iVO.add(faceShopData);
                }
            }
            FaceShopModel.this.mLoadDataCallBack.callback(FaceShopModel.this.iVO);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iUZ = true;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
                this.cml = null;
            }
            FaceShopModel.this.iWf = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iWf != null) {
            this.iWf.cancel();
            return true;
        }
        return true;
    }
}
