package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes9.dex */
public class FacePackageDetailModel extends BdBaseModel<l> {
    private boolean gfa;
    private ProxyAdkBaseActivity.LoadDataCallBack iUS;
    private int iUU;
    private String iUV;
    private FacePackageDetailData iUW;
    private a iUX;
    private float iUY;
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
        this.iUS = null;
        this.iUX = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iUY = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData cyP() {
        return this.iUW;
    }

    public void JJ(String str) {
        this.mDownloadUrl = str;
    }

    public String cyQ() {
        return this.mDownloadUrl;
    }

    public void qh(boolean z) {
        this.gfa = z;
    }

    public boolean cyR() {
        return this.gfa;
    }

    public int cyS() {
        return this.iUU;
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

    public void JK(String str) {
        this.iUV = str;
    }

    public String cyT() {
        return this.iUV;
    }

    public void loadData() {
        if (this.iUX == null) {
            this.iUX = new a();
            this.iUX.setPriority(3);
            this.iUX.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.iUU = 5;
            } else if (i4 == 1) {
                this.iUU = 1;
            } else if (i == 2) {
                this.iUU = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.iUU = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.iUU = 3;
                } else {
                    this.iUU = 4;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, String, FacePackageDetailData> {
        private com.baidu.tbadk.core.util.aa cml;
        private volatile boolean iUZ;

        private a() {
            this.iUZ = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData;
            try {
                if (FacePackageDetailModel.this.mPid == null || FacePackageDetailModel.this.mPid.length() <= 0 || this.iUZ) {
                    return null;
                }
                com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb_face_package");
                if (As != null) {
                    String str = As.get(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid);
                    if (!au.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                this.cml = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.cml.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.mScreenWidth));
                this.cml.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.mScreenHeight));
                this.cml.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.iUY));
                this.cml.addPostData("pid", FacePackageDetailModel.this.mPid);
                this.cml.addPostData("st_type", FacePackageDetailModel.this.mStType);
                String postNetData = this.cml.postNetData();
                facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData != null) {
                    try {
                        if (facePackageDetailData.faces_list != null) {
                            JL(postNetData);
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
            FacePackageDetailModel.this.iUX = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.iUW = facePackageDetailData;
            }
            FacePackageDetailModel.this.iUS.callback(facePackageDetailData, false);
        }

        private void JL(String str) {
            com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb_face_package");
            if (As != null) {
                As.set(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
            FacePackageDetailModel.this.iUW = facePackageDetailData;
            FacePackageDetailModel.this.iUS.callback(facePackageDetailData, true);
            super.onProgressUpdate((Object[]) strArr);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iUZ = true;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
                this.cml = null;
            }
            FacePackageDetailModel.this.iUX = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iUX != null) {
            this.iUX.cancel();
            return true;
        }
        return true;
    }

    public void a(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.iUS = loadDataCallBack;
    }
}
