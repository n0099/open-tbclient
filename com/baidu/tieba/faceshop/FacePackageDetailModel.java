package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes9.dex */
public class FacePackageDetailModel extends BdBaseModel<l> {
    private boolean ght;
    private ProxyAdkBaseActivity.LoadDataCallBack iTS;
    private int iTU;
    private String iTV;
    private FacePackageDetailData iTW;
    private a iTX;
    private float iTY;
    private String mDownloadUrl;
    private String mPid;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mStType;

    public FacePackageDetailModel(l lVar) {
        super(lVar.getPageContext());
        this.mDownloadUrl = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.iTS = null;
        this.iTX = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iTY = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData cBw() {
        return this.iTW;
    }

    public void Kj(String str) {
        this.mDownloadUrl = str;
    }

    public String cBx() {
        return this.mDownloadUrl;
    }

    public void qb(boolean z) {
        this.ght = z;
    }

    public boolean cBy() {
        return this.ght;
    }

    public int cBz() {
        return this.iTU;
    }

    public void setPid(String str) {
        this.mPid = str;
    }

    public String getPid() {
        return this.mPid;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public String getStType() {
        return this.mStType;
    }

    public void Kk(String str) {
        this.iTV = str;
    }

    public String cBA() {
        return this.iTV;
    }

    public void loadData() {
        if (this.iTX == null) {
            this.iTX = new a();
            this.iTX.setPriority(3);
            this.iTX.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.iTU = 5;
            } else if (i4 == 1) {
                this.iTU = 1;
            } else if (i == 2) {
                this.iTU = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.iTU = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.iTU = 3;
                } else {
                    this.iTU = 4;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, String, FacePackageDetailData> {
        private com.baidu.tbadk.core.util.z cmJ;
        private volatile boolean iTZ;

        private a() {
            this.iTZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData;
            try {
                if (FacePackageDetailModel.this.mPid == null || FacePackageDetailModel.this.mPid.length() <= 0 || this.iTZ) {
                    return null;
                }
                com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb_face_package");
                if (Bm != null) {
                    String str = Bm.get(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid);
                    if (!at.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                this.cmJ = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.cmJ.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.mScreenWidth));
                this.cmJ.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.mScreenHeight));
                this.cmJ.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.iTY));
                this.cmJ.addPostData("pid", FacePackageDetailModel.this.mPid);
                this.cmJ.addPostData("st_type", FacePackageDetailModel.this.mStType);
                String postNetData = this.cmJ.postNetData();
                facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData != null) {
                    try {
                        if (facePackageDetailData.faces_list != null) {
                            Kl(postNetData);
                            return facePackageDetailData;
                        }
                        return facePackageDetailData;
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        return facePackageDetailData;
                    }
                }
                return facePackageDetailData;
            } catch (Exception e2) {
                e = e2;
                facePackageDetailData = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(FacePackageDetailData facePackageDetailData) {
            super.onPostExecute(facePackageDetailData);
            FacePackageDetailModel.this.iTX = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.iTW = facePackageDetailData;
            }
            FacePackageDetailModel.this.iTS.callback(facePackageDetailData, false);
        }

        private void Kl(String str) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb_face_package");
            if (Bm != null) {
                Bm.set(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
            FacePackageDetailModel.this.iTW = facePackageDetailData;
            FacePackageDetailModel.this.iTS.callback(facePackageDetailData, true);
            super.onProgressUpdate((Object[]) strArr);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iTZ = true;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
                this.cmJ = null;
            }
            FacePackageDetailModel.this.iTX = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iTX != null) {
            this.iTX.cancel();
            return true;
        }
        return true;
    }

    public void a(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.iTS = loadDataCallBack;
    }
}
