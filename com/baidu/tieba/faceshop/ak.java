package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.e {
    private boolean acU;
    private String aok;
    private BaseActivity.LoadDataCallBack atj;
    private int atm;
    private String atn;
    private String ato;
    private String atp;
    private FacePackageDetailData atq;
    private al atr;
    private int ats;
    private int att;
    private float atu;

    public ak(Context context) {
        super(context);
        this.ato = null;
        this.ats = 0;
        this.att = 0;
        this.atj = null;
        this.atr = null;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.ats = com.baidu.adp.lib.util.m.n(m251getInst);
        this.att = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atu = m251getInst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData CY() {
        return this.atq;
    }

    public void eQ(String str) {
        this.ato = str;
    }

    public String CZ() {
        return this.ato;
    }

    public void bD(boolean z) {
        this.acU = z;
    }

    public boolean Da() {
        return this.acU;
    }

    public int Db() {
        return this.atm;
    }

    public void setPid(String str) {
        this.atn = str;
    }

    public String getPid() {
        return this.atn;
    }

    public void setStType(String str) {
        this.aok = str;
    }

    public String getStType() {
        return this.aok;
    }

    public void eR(String str) {
        this.atp = str;
    }

    public String Dc() {
        return this.atp;
    }

    public void yh() {
        if (this.atr == null) {
            this.atr = new al(this, null);
            this.atr.setPriority(3);
            this.atr.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.atm = 5;
            } else if (i4 == 1) {
                this.atm = 1;
            } else if (i == 2) {
                this.atm = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.atm = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.atm = 3;
                } else {
                    this.atm = 4;
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
        if (this.atr != null) {
            this.atr.cancel();
            return true;
        }
        return true;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.atj = loadDataCallBack;
    }
}
