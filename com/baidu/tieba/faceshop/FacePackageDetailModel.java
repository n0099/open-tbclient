package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes8.dex */
public class FacePackageDetailModel extends BdBaseModel<l> {
    private boolean ggI;
    private ProxyAdkBaseActivity.LoadDataCallBack iWP;
    private int iWR;
    private String iWS;
    private FacePackageDetailData iWT;
    private a iWU;
    private float iWV;
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
        this.iWP = null;
        this.iWU = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iWV = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData czc() {
        return this.iWT;
    }

    public void JT(String str) {
        this.mDownloadUrl = str;
    }

    public String czd() {
        return this.mDownloadUrl;
    }

    public void qh(boolean z) {
        this.ggI = z;
    }

    public boolean cze() {
        return this.ggI;
    }

    public int czf() {
        return this.iWR;
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

    public void JU(String str) {
        this.iWS = str;
    }

    public String czg() {
        return this.iWS;
    }

    public void loadData() {
        if (this.iWU == null) {
            this.iWU = new a();
            this.iWU.setPriority(3);
            this.iWU.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.iWR = 5;
            } else if (i4 == 1) {
                this.iWR = 1;
            } else if (i == 2) {
                this.iWR = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.iWR = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.iWR = 3;
                } else {
                    this.iWR = 4;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, String, FacePackageDetailData> {
        private com.baidu.tbadk.core.util.aa cnM;
        private volatile boolean iWW;

        private a() {
            this.iWW = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData;
            try {
                if (FacePackageDetailModel.this.mPid == null || FacePackageDetailModel.this.mPid.length() <= 0 || this.iWW) {
                    return null;
                }
                com.baidu.adp.lib.cache.l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb_face_package");
                if (Az != null) {
                    String str = Az.get(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid);
                    if (!au.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                this.cnM = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.cnM.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.mScreenWidth));
                this.cnM.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.mScreenHeight));
                this.cnM.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.iWV));
                this.cnM.addPostData("pid", FacePackageDetailModel.this.mPid);
                this.cnM.addPostData("st_type", FacePackageDetailModel.this.mStType);
                String postNetData = this.cnM.postNetData();
                facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData != null) {
                    try {
                        if (facePackageDetailData.faces_list != null) {
                            JV(postNetData);
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
            FacePackageDetailModel.this.iWU = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.iWT = facePackageDetailData;
            }
            FacePackageDetailModel.this.iWP.callback(facePackageDetailData, false);
        }

        private void JV(String str) {
            com.baidu.adp.lib.cache.l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb_face_package");
            if (Az != null) {
                Az.set(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
            FacePackageDetailModel.this.iWT = facePackageDetailData;
            FacePackageDetailModel.this.iWP.callback(facePackageDetailData, true);
            super.onProgressUpdate((Object[]) strArr);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iWW = true;
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
                this.cnM = null;
            }
            FacePackageDetailModel.this.iWU = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iWU != null) {
            this.iWU.cancel();
            return true;
        }
        return true;
    }

    public void a(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.iWP = loadDataCallBack;
    }
}
