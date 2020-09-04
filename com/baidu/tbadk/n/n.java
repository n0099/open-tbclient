package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eTc = null;
    private boolean eSA = false;
    private boolean eSB = false;
    private boolean eSC = false;
    private boolean eSD = false;
    private long eSE = -1;
    private long eSF = -1;
    private long eSG = -1;
    private long eSH = -1;
    private long eSI = -1;
    private long eSJ = -1;
    private long eSK = -1;
    private long eSL = -1;
    private long eSM = -1;
    private long eSN = -1;
    private long eSO = -1;
    private long eSP = -1;
    private long eSQ = -1;
    private long eSR = -1;
    private long eSS = -1;
    private long eST = -1;
    private long eSU = -1;
    private long eSV = -1;
    private long eSW = -1;
    private long eSX = -1;
    private long eSY = -1;
    private long eSZ = -1;
    private long eTa = -1;
    private long eTb = -1;

    public boolean bur() {
        return this.eSB;
    }

    public void jE(boolean z) {
        this.eSA = z;
    }

    public void db(long j) {
        this.eSE = j;
    }

    public long bus() {
        return this.eSE;
    }

    public void jF(boolean z) {
        this.eSD = z;
    }

    public void dc(long j) {
        this.eSF = j;
    }

    public void dd(long j) {
        this.eSG = j;
    }

    public void de(long j) {
        this.eSH = j;
    }

    public void df(long j) {
        this.eSL = j;
    }

    public void dg(long j) {
        this.eSK = j;
    }

    public void dh(long j) {
        this.eSI = j;
    }

    public void di(long j) {
        this.eSJ = j;
    }

    public void dj(long j) {
        this.eSZ = j;
    }

    public void dk(long j) {
        this.eSU = j;
    }

    public void dl(long j) {
        this.eSV = j;
    }

    public void dm(long j) {
        this.eSW = j;
    }

    public void dn(long j) {
        this.eSX = j;
    }

    /* renamed from: do  reason: not valid java name */
    public void m40do(long j) {
        this.eTa = j;
    }

    public void dp(long j) {
        this.eTb = j;
        this.eSB = true;
    }

    public void dq(long j) {
        this.eSM = j;
    }

    public void dr(long j) {
        this.eSN = j;
    }

    public void ds(long j) {
        this.eSP = j;
    }

    public void dt(long j) {
        this.eSO = j;
    }

    public void du(long j) {
        this.eSQ = j;
    }

    public void dv(long j) {
        this.eSR = j;
    }

    public void dw(long j) {
        this.eSS = j;
    }

    public void dx(long j) {
        this.eST = j;
    }

    public static n but() {
        if (eTc == null) {
            synchronized (n.class) {
                if (eTc == null) {
                    eTc = new n();
                }
            }
        }
        return eTc;
    }

    public void buu() {
        if (this.eTb - this.eSE > 0 && !this.eSC && this.eSY > 0 && m.buo().bup()) {
            this.eSC = true;
            long j = this.eSF - this.eSE;
            long j2 = -1;
            if (this.eSW > 0) {
                j2 = this.eSX - this.eSW;
            }
            long j3 = this.eTb - this.eTa;
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("procname", "main");
            mN.append("appc", String.valueOf(j));
            mN.append("loadclass", String.valueOf(this.eSG));
            mN.append("sapiinit", String.valueOf(this.eSH));
            mN.append("acctinit", String.valueOf(this.eSI));
            mN.append("iminit", String.valueOf(this.eSJ));
            mN.append("plugininit", String.valueOf(this.eSK));
            mN.append("patchloaded", String.valueOf(this.eSL));
            mN.append("naslibinit", String.valueOf(this.eSM));
            mN.append("websocketinit", String.valueOf(this.eSN));
            mN.append("settinginit", String.valueOf(this.eSO));
            mN.append("toastinit", String.valueOf(this.eSP));
            mN.append("tiebastaticinit", String.valueOf(this.eSQ));
            mN.append("locationinit", String.valueOf(this.eSR));
            mN.append("cdninit", String.valueOf(this.eSS));
            mN.append("messagesetinit", String.valueOf(this.eST));
            mN.append("logores", String.valueOf(this.eSZ));
            mN.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.egX ? 1 : 0));
            if (this.eSU > 0 && this.eSW > 0 && j2 > 0) {
                mN.append("adc", String.valueOf(this.eSU + this.eSV));
                mN.append("adshow", String.valueOf(j2));
                mN.append("adrequest", String.valueOf(this.eSV));
                mN.append("hasad", "1");
            } else {
                mN.append("hasad", "0");
            }
            mN.append("tabc", String.valueOf(j3));
            mN.append("costt", String.valueOf(j2 + j + this.eSU + this.eSV + j3 + this.eSY));
            mN.append("newinst", this.eSA ? "1" : "0");
            mN.append("pluginloadsync", Boolean.valueOf(this.eSD));
            mN.append("hptotal", String.valueOf(this.eSY));
            BdStatisticsManager.getInstance().performance("startt", mN);
            baN();
        }
    }

    public void dy(long j) {
        if (m.buo().bup() && j > 0) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("procname", "remote");
            mN.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mN);
        }
    }

    private void baN() {
        this.eSA = false;
        this.eSB = false;
        this.eSE = -1L;
        this.eSF = -1L;
        this.eSG = -1L;
        this.eSH = -1L;
        this.eSI = -1L;
        this.eSJ = -1L;
        this.eSK = -1L;
        this.eSL = -1L;
        this.eSZ = -1L;
        this.eSW = -1L;
        this.eSX = -1L;
        this.eSU = -1L;
        this.eTa = -1L;
        this.eTb = -1L;
        this.eSM = -1L;
        this.eSN = -1L;
        this.eSO = -1L;
        this.eSP = -1L;
        this.eSQ = -1L;
        this.eSR = -1L;
        this.eSS = -1L;
        this.eST = -1L;
        this.eSV = -1L;
        this.eSY = -1L;
    }

    public void dz(long j) {
        if (this.eSY <= 0) {
            this.eSY = j;
        }
    }
}
