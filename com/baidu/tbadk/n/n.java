package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eVS = null;
    private boolean eVq = false;
    private boolean eVr = false;
    private boolean eVs = false;
    private boolean eVt = false;
    private long eVu = -1;
    private long eVv = -1;
    private long eVw = -1;
    private long eVx = -1;
    private long eVy = -1;
    private long eVz = -1;
    private long eVA = -1;
    private long eVB = -1;
    private long eVC = -1;
    private long eVD = -1;
    private long eVE = -1;
    private long eVF = -1;
    private long eVG = -1;
    private long eVH = -1;
    private long eVI = -1;
    private long eVJ = -1;
    private long eVK = -1;
    private long eVL = -1;
    private long eVM = -1;
    private long eVN = -1;
    private long eVO = -1;
    private long eVP = -1;
    private long eVQ = -1;
    private long eVR = -1;

    public boolean bvv() {
        return this.eVr;
    }

    public void jF(boolean z) {
        this.eVq = z;
    }

    public void dc(long j) {
        this.eVu = j;
    }

    public long bvw() {
        return this.eVu;
    }

    public void jG(boolean z) {
        this.eVt = z;
    }

    public void dd(long j) {
        this.eVv = j;
    }

    public void de(long j) {
        this.eVw = j;
    }

    public void df(long j) {
        this.eVx = j;
    }

    public void dg(long j) {
        this.eVB = j;
    }

    public void dh(long j) {
        this.eVA = j;
    }

    public void di(long j) {
        this.eVy = j;
    }

    public void dj(long j) {
        this.eVz = j;
    }

    public void dk(long j) {
        this.eVP = j;
    }

    public void dl(long j) {
        this.eVK = j;
    }

    public void dm(long j) {
        this.eVL = j;
    }

    public void dn(long j) {
        this.eVM = j;
    }

    /* renamed from: do  reason: not valid java name */
    public void m39do(long j) {
        this.eVN = j;
    }

    public void dp(long j) {
        this.eVQ = j;
    }

    public void dq(long j) {
        this.eVR = j;
        this.eVr = true;
    }

    public void dr(long j) {
        this.eVC = j;
    }

    public void ds(long j) {
        this.eVD = j;
    }

    public void dt(long j) {
        this.eVF = j;
    }

    public void du(long j) {
        this.eVE = j;
    }

    public void dv(long j) {
        this.eVG = j;
    }

    public void dw(long j) {
        this.eVH = j;
    }

    public void dx(long j) {
        this.eVI = j;
    }

    public void dy(long j) {
        this.eVJ = j;
    }

    public static n bvx() {
        if (eVS == null) {
            synchronized (n.class) {
                if (eVS == null) {
                    eVS = new n();
                }
            }
        }
        return eVS;
    }

    public void bvy() {
        if (this.eVR - this.eVu > 0 && !this.eVs && this.eVO > 0 && m.bvs().bvt()) {
            this.eVs = true;
            long j = this.eVv - this.eVu;
            long j2 = -1;
            if (this.eVM > 0) {
                j2 = this.eVN - this.eVM;
            }
            long j3 = this.eVR - this.eVQ;
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("procname", "main");
            mS.append("appc", String.valueOf(j));
            mS.append("loadclass", String.valueOf(this.eVw));
            mS.append("sapiinit", String.valueOf(this.eVx));
            mS.append("acctinit", String.valueOf(this.eVy));
            mS.append("iminit", String.valueOf(this.eVz));
            mS.append("plugininit", String.valueOf(this.eVA));
            mS.append("patchloaded", String.valueOf(this.eVB));
            mS.append("naslibinit", String.valueOf(this.eVC));
            mS.append("websocketinit", String.valueOf(this.eVD));
            mS.append("settinginit", String.valueOf(this.eVE));
            mS.append("toastinit", String.valueOf(this.eVF));
            mS.append("tiebastaticinit", String.valueOf(this.eVG));
            mS.append("locationinit", String.valueOf(this.eVH));
            mS.append("cdninit", String.valueOf(this.eVI));
            mS.append("messagesetinit", String.valueOf(this.eVJ));
            mS.append("logores", String.valueOf(this.eVP));
            mS.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.ejm ? 1 : 0));
            if (this.eVK > 0 && this.eVM > 0 && j2 > 0) {
                mS.append("adc", String.valueOf(this.eVK + this.eVL));
                mS.append("adshow", String.valueOf(j2));
                mS.append("adrequest", String.valueOf(this.eVL));
                mS.append("hasad", "1");
            } else {
                mS.append("hasad", "0");
            }
            mS.append("tabc", String.valueOf(j3));
            mS.append("costt", String.valueOf(j2 + j + this.eVK + this.eVL + j3 + this.eVO));
            mS.append("newinst", this.eVq ? "1" : "0");
            mS.append("pluginloadsync", Boolean.valueOf(this.eVt));
            mS.append("hptotal", String.valueOf(this.eVO));
            BdStatisticsManager.getInstance().performance("startt", mS);
            bbH();
        }
    }

    public void dz(long j) {
        if (m.bvs().bvt() && j > 0) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("procname", "remote");
            mS.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mS);
        }
    }

    private void bbH() {
        this.eVq = false;
        this.eVr = false;
        this.eVu = -1L;
        this.eVv = -1L;
        this.eVw = -1L;
        this.eVx = -1L;
        this.eVy = -1L;
        this.eVz = -1L;
        this.eVA = -1L;
        this.eVB = -1L;
        this.eVP = -1L;
        this.eVM = -1L;
        this.eVN = -1L;
        this.eVK = -1L;
        this.eVQ = -1L;
        this.eVR = -1L;
        this.eVC = -1L;
        this.eVD = -1L;
        this.eVE = -1L;
        this.eVF = -1L;
        this.eVG = -1L;
        this.eVH = -1L;
        this.eVI = -1L;
        this.eVJ = -1L;
        this.eVL = -1L;
        this.eVO = -1L;
    }

    public void dA(long j) {
        if (this.eVO <= 0) {
            this.eVO = j;
        }
    }
}
