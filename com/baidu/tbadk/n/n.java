package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n fwv = null;
    private boolean fvT = false;
    private boolean fvU = false;
    private boolean fvV = false;
    private boolean fvW = false;
    private long fvX = -1;
    private long fvY = -1;
    private long fvZ = -1;
    private long fwa = -1;
    private long fwb = -1;
    private long fwc = -1;
    private long fwd = -1;
    private long fwe = -1;
    private long fwf = -1;
    private long fwg = -1;
    private long fwh = -1;
    private long fwi = -1;
    private long fwj = -1;
    private long fwk = -1;
    private long fwl = -1;
    private long fwm = -1;
    private long fwn = -1;
    private long fwo = -1;
    private long fwp = -1;
    private long fwq = -1;
    private long fwr = -1;
    private long fws = -1;
    private long fwt = -1;
    private long fwu = -1;

    public boolean bCx() {
        return this.fvU;
    }

    public void kz(boolean z) {
        this.fvT = z;
    }

    public void dI(long j) {
        this.fvX = j;
    }

    public long bCy() {
        return this.fvX;
    }

    public void kA(boolean z) {
        this.fvW = z;
    }

    public void dJ(long j) {
        this.fvY = j;
    }

    public void dK(long j) {
        this.fvZ = j;
    }

    public void dL(long j) {
        this.fwa = j;
    }

    public void dM(long j) {
        this.fwe = j;
    }

    public void dN(long j) {
        this.fwd = j;
    }

    public void dO(long j) {
        this.fwb = j;
    }

    public void dP(long j) {
        this.fwc = j;
    }

    public void dQ(long j) {
        this.fws = j;
    }

    public void dR(long j) {
        this.fwn = j;
    }

    public void dS(long j) {
        this.fwo = j;
    }

    public void dT(long j) {
        this.fwp = j;
    }

    public void dU(long j) {
        this.fwq = j;
    }

    public void dV(long j) {
        this.fwt = j;
    }

    public void dW(long j) {
        this.fwu = j;
        this.fvU = true;
    }

    public void dX(long j) {
        this.fwf = j;
    }

    public void dY(long j) {
        this.fwg = j;
    }

    public void dZ(long j) {
        this.fwi = j;
    }

    public void ea(long j) {
        this.fwh = j;
    }

    public void eb(long j) {
        this.fwj = j;
    }

    public void ec(long j) {
        this.fwk = j;
    }

    public void ed(long j) {
        this.fwl = j;
    }

    public void ee(long j) {
        this.fwm = j;
    }

    public static n bCz() {
        if (fwv == null) {
            synchronized (n.class) {
                if (fwv == null) {
                    fwv = new n();
                }
            }
        }
        return fwv;
    }

    public void bCA() {
        if (this.fwu - this.fvX > 0 && !this.fvV && this.fwr > 0 && m.bCu().bCv()) {
            this.fvV = true;
            long j = this.fvY - this.fvX;
            long j2 = -1;
            if (this.fwp > 0) {
                j2 = this.fwq - this.fwp;
            }
            long j3 = this.fwu - this.fwt;
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "main");
            mT.append("appc", String.valueOf(j));
            mT.append("loadclass", String.valueOf(this.fvZ));
            mT.append("sapiinit", String.valueOf(this.fwa));
            mT.append("acctinit", String.valueOf(this.fwb));
            mT.append("iminit", String.valueOf(this.fwc));
            mT.append("plugininit", String.valueOf(this.fwd));
            mT.append("patchloaded", String.valueOf(this.fwe));
            mT.append("naslibinit", String.valueOf(this.fwf));
            mT.append("websocketinit", String.valueOf(this.fwg));
            mT.append("settinginit", String.valueOf(this.fwh));
            mT.append("toastinit", String.valueOf(this.fwi));
            mT.append("tiebastaticinit", String.valueOf(this.fwj));
            mT.append("locationinit", String.valueOf(this.fwk));
            mT.append("cdninit", String.valueOf(this.fwl));
            mT.append("messagesetinit", String.valueOf(this.fwm));
            mT.append("logores", String.valueOf(this.fws));
            mT.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eJI ? 1 : 0));
            if (this.fwn > 0 && this.fwp > 0 && j2 > 0) {
                mT.append("adc", String.valueOf(this.fwn + this.fwo));
                mT.append("adshow", String.valueOf(j2));
                mT.append("adrequest", String.valueOf(this.fwo));
                mT.append("hasad", "1");
            } else {
                mT.append("hasad", "0");
            }
            mT.append("tabc", String.valueOf(j3));
            mT.append("costt", String.valueOf(j2 + j + this.fwn + this.fwo + j3 + this.fwr));
            mT.append("newinst", this.fvT ? "1" : "0");
            mT.append("pluginloadsync", Boolean.valueOf(this.fvW));
            mT.append("hptotal", String.valueOf(this.fwr));
            BdStatisticsManager.getInstance().performance("startt", mT);
            biI();
        }
    }

    public void ef(long j) {
        if (m.bCu().bCv() && j > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "remote");
            mT.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mT);
        }
    }

    private void biI() {
        this.fvT = false;
        this.fvU = false;
        this.fvX = -1L;
        this.fvY = -1L;
        this.fvZ = -1L;
        this.fwa = -1L;
        this.fwb = -1L;
        this.fwc = -1L;
        this.fwd = -1L;
        this.fwe = -1L;
        this.fws = -1L;
        this.fwp = -1L;
        this.fwq = -1L;
        this.fwn = -1L;
        this.fwt = -1L;
        this.fwu = -1L;
        this.fwf = -1L;
        this.fwg = -1L;
        this.fwh = -1L;
        this.fwi = -1L;
        this.fwj = -1L;
        this.fwk = -1L;
        this.fwl = -1L;
        this.fwm = -1L;
        this.fwo = -1L;
        this.fwr = -1L;
    }

    public void eg(long j) {
        if (this.fwr <= 0) {
            this.fwr = j;
        }
    }
}
