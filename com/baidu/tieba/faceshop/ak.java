package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.e {
    private boolean acZ;
    private String aot;
    private al atA;
    private int atB;
    private int atC;
    private float atD;
    private BaseActivity.LoadDataCallBack ats;
    private int atv;
    private String atw;
    private String atx;
    private String aty;
    private FacePackageDetailData atz;

    public ak(Context context) {
        super(context);
        this.atx = null;
        this.atB = 0;
        this.atC = 0;
        this.ats = null;
        this.atA = null;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.atB = com.baidu.adp.lib.util.m.n(m251getInst);
        this.atC = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atD = m251getInst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData Da() {
        return this.atz;
    }

    public void eQ(String str) {
        this.atx = str;
    }

    public String Db() {
        return this.atx;
    }

    public void bD(boolean z) {
        this.acZ = z;
    }

    public boolean Dc() {
        return this.acZ;
    }

    public int Dd() {
        return this.atv;
    }

    public void setPid(String str) {
        this.atw = str;
    }

    public String getPid() {
        return this.atw;
    }

    public void setStType(String str) {
        this.aot = str;
    }

    public String getStType() {
        return this.aot;
    }

    public void eR(String str) {
        this.aty = str;
    }

    public String De() {
        return this.aty;
    }

    public void yj() {
        if (this.atA == null) {
            this.atA = new al(this, null);
            this.atA.setPriority(3);
            this.atA.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.atv = 5;
            } else if (i4 == 1) {
                this.atv = 1;
            } else if (i == 2) {
                this.atv = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.atv = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.atv = 3;
                } else {
                    this.atv = 4;
                }
            }
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.atA != null) {
            this.atA.cancel();
            return true;
        }
        return true;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.ats = loadDataCallBack;
    }
}
