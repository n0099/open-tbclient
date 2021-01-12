package com.baidu.tieba.faceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes8.dex */
public class FacePackageDetailModel extends BdBaseModel<l> {
    private boolean gcL;
    private ProxyAdkBaseActivity.LoadDataCallBack iPl;
    private int iPn;
    private String iPo;
    private FacePackageDetailData iPp;
    private a iPq;
    private float iPr;
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
        this.iPl = null;
        this.iPq = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(inst);
        this.mScreenHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(inst);
        this.iPr = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData cxE() {
        return this.iPp;
    }

    public void IY(String str) {
        this.mDownloadUrl = str;
    }

    public String cxF() {
        return this.mDownloadUrl;
    }

    public void pX(boolean z) {
        this.gcL = z;
    }

    public boolean cxG() {
        return this.gcL;
    }

    public int cxH() {
        return this.iPn;
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

    public void IZ(String str) {
        this.iPo = str;
    }

    public String cxI() {
        return this.iPo;
    }

    public void loadData() {
        if (this.iPq == null) {
            this.iPq = new a();
            this.iPq.setPriority(3);
            this.iPq.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.iPn = 5;
            } else if (i4 == 1) {
                this.iPn = 1;
            } else if (i == 2) {
                this.iPn = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.iPn = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.iPn = 3;
                } else {
                    this.iPn = 4;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, String, FacePackageDetailData> {
        private com.baidu.tbadk.core.util.z chV;
        private volatile boolean iPs;

        private a() {
            this.iPs = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public FacePackageDetailData doInBackground(Object... objArr) {
            FacePackageDetailData facePackageDetailData;
            try {
                if (FacePackageDetailModel.this.mPid == null || FacePackageDetailModel.this.mPid.length() <= 0 || this.iPs) {
                    return null;
                }
                com.baidu.adp.lib.cache.l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb_face_package");
                if (Ab != null) {
                    String str = Ab.get(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid);
                    if (!at.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                this.chV = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.chV.addPostData("scr_w", String.valueOf(FacePackageDetailModel.this.mScreenWidth));
                this.chV.addPostData("scr_h", String.valueOf(FacePackageDetailModel.this.mScreenHeight));
                this.chV.addPostData("scr_dip", String.valueOf(FacePackageDetailModel.this.iPr));
                this.chV.addPostData("pid", FacePackageDetailModel.this.mPid);
                this.chV.addPostData("st_type", FacePackageDetailModel.this.mStType);
                String postNetData = this.chV.postNetData();
                facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData != null) {
                    try {
                        if (facePackageDetailData.faces_list != null) {
                            Ja(postNetData);
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
            FacePackageDetailModel.this.iPq = null;
            if (facePackageDetailData != null) {
                FacePackageDetailModel.this.iPp = facePackageDetailData;
            }
            FacePackageDetailModel.this.iPl.callback(facePackageDetailData, false);
        }

        private void Ja(String str) {
            com.baidu.adp.lib.cache.l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb_face_package");
            if (Ab != null) {
                Ab.set(TbadkApplication.getCurrentAccount() + FacePackageDetailModel.this.mPid, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
            FacePackageDetailModel.this.iPp = facePackageDetailData;
            FacePackageDetailModel.this.iPl.callback(facePackageDetailData, true);
            super.onProgressUpdate((Object[]) strArr);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.iPs = true;
            if (this.chV != null) {
                this.chV.cancelNetConnect();
                this.chV = null;
            }
            FacePackageDetailModel.this.iPq = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iPq != null) {
            this.iPq.cancel();
            return true;
        }
        return true;
    }

    public void a(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        this.iPl = loadDataCallBack;
    }
}
