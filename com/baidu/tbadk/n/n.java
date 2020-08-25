package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes2.dex */
public class n extends l {
    private static n eSY = null;
    private boolean eSw = false;
    private boolean eSx = false;
    private boolean eSy = false;
    private boolean eSz = false;
    private long eSA = -1;
    private long eSB = -1;
    private long eSC = -1;
    private long eSD = -1;
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

    public boolean buq() {
        return this.eSx;
    }

    public void jC(boolean z) {
        this.eSw = z;
    }

    public void db(long j) {
        this.eSA = j;
    }

    public long bur() {
        return this.eSA;
    }

    public void jD(boolean z) {
        this.eSz = z;
    }

    public void dc(long j) {
        this.eSB = j;
    }

    public void dd(long j) {
        this.eSC = j;
    }

    public void de(long j) {
        this.eSD = j;
    }

    public void df(long j) {
        this.eSH = j;
    }

    public void dg(long j) {
        this.eSG = j;
    }

    public void dh(long j) {
        this.eSE = j;
    }

    public void di(long j) {
        this.eSF = j;
    }

    public void dj(long j) {
        this.eSV = j;
    }

    public void dk(long j) {
        this.eSQ = j;
    }

    public void dl(long j) {
        this.eSR = j;
    }

    public void dm(long j) {
        this.eSS = j;
    }

    public void dn(long j) {
        this.eST = j;
    }

    /* renamed from: do  reason: not valid java name */
    public void m40do(long j) {
        this.eSW = j;
    }

    public void dp(long j) {
        this.eSX = j;
        this.eSx = true;
    }

    public void dq(long j) {
        this.eSI = j;
    }

    public void dr(long j) {
        this.eSJ = j;
    }

    public void ds(long j) {
        this.eSL = j;
    }

    public void dt(long j) {
        this.eSK = j;
    }

    public void du(long j) {
        this.eSM = j;
    }

    public void dv(long j) {
        this.eSN = j;
    }

    public void dw(long j) {
        this.eSO = j;
    }

    public void dx(long j) {
        this.eSP = j;
    }

    public static n bus() {
        if (eSY == null) {
            synchronized (n.class) {
                if (eSY == null) {
                    eSY = new n();
                }
            }
        }
        return eSY;
    }

    public void but() {
        if (this.eSX - this.eSA > 0 && !this.eSy && this.eSU > 0 && m.bun().buo()) {
            this.eSy = true;
            long j = this.eSB - this.eSA;
            long j2 = -1;
            if (this.eSS > 0) {
                j2 = this.eST - this.eSS;
            }
            long j3 = this.eSX - this.eSW;
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("procname", "main");
            mN.append("appc", String.valueOf(j));
            mN.append("loadclass", String.valueOf(this.eSC));
            mN.append("sapiinit", String.valueOf(this.eSD));
            mN.append("acctinit", String.valueOf(this.eSE));
            mN.append("iminit", String.valueOf(this.eSF));
            mN.append("plugininit", String.valueOf(this.eSG));
            mN.append("patchloaded", String.valueOf(this.eSH));
            mN.append("naslibinit", String.valueOf(this.eSI));
            mN.append("websocketinit", String.valueOf(this.eSJ));
            mN.append("settinginit", String.valueOf(this.eSK));
            mN.append("toastinit", String.valueOf(this.eSL));
            mN.append("tiebastaticinit", String.valueOf(this.eSM));
            mN.append("locationinit", String.valueOf(this.eSN));
            mN.append("cdninit", String.valueOf(this.eSO));
            mN.append("messagesetinit", String.valueOf(this.eSP));
            mN.append("logores", String.valueOf(this.eSV));
            mN.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.egT ? 1 : 0));
            if (this.eSQ > 0 && this.eSS > 0 && j2 > 0) {
                mN.append("adc", String.valueOf(this.eSQ + this.eSR));
                mN.append("adshow", String.valueOf(j2));
                mN.append("adrequest", String.valueOf(this.eSR));
                mN.append("hasad", "1");
            } else {
                mN.append("hasad", "0");
            }
            mN.append("tabc", String.valueOf(j3));
            mN.append("costt", String.valueOf(j2 + j + this.eSQ + this.eSR + j3 + this.eSU));
            mN.append("newinst", this.eSw ? "1" : "0");
            mN.append("pluginloadsync", Boolean.valueOf(this.eSz));
            mN.append("hptotal", String.valueOf(this.eSU));
            BdStatisticsManager.getInstance().performance("startt", mN);
            baN();
        }
    }

    public void dy(long j) {
        if (m.bun().buo() && j > 0) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("procname", "remote");
            mN.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mN);
        }
    }

    private void baN() {
        this.eSw = false;
        this.eSx = false;
        this.eSA = -1L;
        this.eSB = -1L;
        this.eSC = -1L;
        this.eSD = -1L;
        this.eSE = -1L;
        this.eSF = -1L;
        this.eSG = -1L;
        this.eSH = -1L;
        this.eSV = -1L;
        this.eSS = -1L;
        this.eST = -1L;
        this.eSQ = -1L;
        this.eSW = -1L;
        this.eSX = -1L;
        this.eSI = -1L;
        this.eSJ = -1L;
        this.eSK = -1L;
        this.eSL = -1L;
        this.eSM = -1L;
        this.eSN = -1L;
        this.eSO = -1L;
        this.eSP = -1L;
        this.eSR = -1L;
        this.eSU = -1L;
    }

    public void dz(long j) {
        if (this.eSU <= 0) {
            this.eSU = j;
        }
    }
}
