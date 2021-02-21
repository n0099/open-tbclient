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
    private boolean gff;
    private ProxyAdkBaseActivity.LoadDataCallBack iVg;
    private int iVi;
    private String iVj;
    private FacePackageDetailData iVk;
    private a iVl;
    private float iVm;
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
        this.iVg = null;
        this.iVl = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iVm = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData cyW() {
        return this.iVk;
    }

    public void JK(String str) {
        this.mDownloadUrl = str;
    }

    public String cyX() {
        return this.mDownloadUrl;
    }

    public void qh(boolean z) {
        this.gff = z;
    }

    public boolean cyY() {
        return this.gff;
    }

    public int cyZ() {
        return this.iVi;
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

    public void JL(String str) {
        this.iVj = str;
    }

    public String cza() {
        return this.iVj;
    }

    public void loadData() {
        if (this.iVl == null) {
            this.iVl = new a();
            this.iVl.setPriority(3);
            this.iVl.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.iVi = 5;
            } else if (i4 == 1) {
                this.iVi = 1;
            } else if (i == 2) {
                this.iVi = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.iVi = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.iVi = 3;
                } else {
                    this.iVi = 4;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<Object, String, FacePackageDetailData> {
        private com.baidu.tbadk.core.util.aa cml;
        private volatile boolean iVn;

        private a() {
            this.iVn = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData;
            try {
                if (FacePackageDetailModel.this.mPid == null || FacePackageDetailModel.this.mPid.length() <= 0 || this.iVn) {
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
                this.cml.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.iVm));
                this.cml.addPostData("pid", FacePackageDetailModel.this.mPid);
                this.cml.addPostData("st_type", FacePackageDetailModel.this.mStType);
                String postNetData = this.cml.postNetData();
                facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData != null) {
                    try {
                        if (facePackageDetailData.faces_list != null) {
                            JM(postNetData);
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
            FacePackageDetailModel.this.iVl = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.iVk = facePackageDetailData;
            }
            FacePackageDetailModel.this.iVg.callback(facePackageDetailData, false);
        }

        private void JM(String str) {
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
            FacePackageDetailModel.this.iVk = facePackageDetailData;
            FacePackageDetailModel.this.iVg.callback(facePackageDetailData, true);
            super.onProgressUpdate((Object[]) strArr);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iVn = true;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
                this.cml = null;
            }
            FacePackageDetailModel.this.iVl = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iVl != null) {
            this.iVl.cancel();
            return true;
        }
        return true;
    }

    public void a(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.iVg = loadDataCallBack;
    }
}
