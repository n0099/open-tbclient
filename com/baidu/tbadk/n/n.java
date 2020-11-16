package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n fvG = null;
    private boolean fvd = false;
    private boolean fve = false;
    private boolean fvf = false;
    private boolean fvg = false;
    private long fvh = -1;
    private long fvi = -1;
    private long fvj = -1;
    private long fvk = -1;
    private long fvl = -1;
    private long fvm = -1;
    private long fvn = -1;
    private long fvo = -1;
    private long fvp = -1;
    private long fvq = -1;
    private long fvr = -1;
    private long fvs = -1;
    private long fvt = -1;
    private long fvu = -1;
    private long fvv = -1;
    private long fvw = -1;
    private long fvx = -1;
    private long fvy = -1;
    private long fvz = -1;
    private long fvA = -1;
    private long fvB = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fvC = -1;
    private long fvD = -1;
    private long fvE = -1;
    private long fvF = -1;

    public boolean bBM() {
        return this.fve;
    }

    public void kA(boolean z) {
        this.fvd = z;
    }

    public void dH(long j) {
        this.fvh = j;
    }

    public long bBN() {
        return this.fvh;
    }

    public void kB(boolean z) {
        this.fvg = z;
    }

    public void dI(long j) {
        this.fvi = j;
    }

    public void dJ(long j) {
        this.fvj = j;
    }

    public void dK(long j) {
        this.fvk = j;
    }

    public void dL(long j) {
        this.fvo = j;
    }

    public void dM(long j) {
        this.fvn = j;
    }

    public void dN(long j) {
        this.fvl = j;
    }

    public void dO(long j) {
        this.fvm = j;
    }

    public void dP(long j) {
        this.fvD = j;
    }

    public void dQ(long j) {
        this.fvx = j;
    }

    public void dR(long j) {
        this.fvy = j;
    }

    public void dS(long j) {
        this.fvz = j;
    }

    public void dT(long j) {
        this.fvA = j;
    }

    public void dU(long j) {
        this.fvE = j;
    }

    public void dV(long j) {
        this.fvF = j;
        this.fve = true;
    }

    public void dW(long j) {
        this.fvp = j;
    }

    public void dX(long j) {
        this.fvq = j;
    }

    public void dY(long j) {
        this.fvs = j;
    }

    public void dZ(long j) {
        this.fvr = j;
    }

    public void ea(long j) {
        this.fvt = j;
    }

    public void eb(long j) {
        this.fvu = j;
    }

    public void ec(long j) {
        this.fvv = j;
    }

    public void ed(long j) {
        this.fvw = j;
    }

    public static n bBO() {
        if (fvG == null) {
            synchronized (n.class) {
                if (fvG == null) {
                    fvG = new n();
                }
            }
        }
        return fvG;
    }

    public void bBP() {
        if (this.fvF - this.fvh > 0 && !this.fvf && this.fvB > 0 && m.bBK().isSmallFlow()) {
            long j = this.fvi - this.fvh;
            long j2 = -1;
            if (this.fvz > 0) {
                j2 = this.fvA - this.fvz;
            }
            if (j2 <= 0) {
                this.fvf = true;
                long j3 = this.fvF - this.fvE;
                com.baidu.adp.lib.stats.a mT = mT();
                mT.append("procname", "main");
                mT.append("appc", String.valueOf(j));
                mT.append("loadclass", String.valueOf(this.fvj));
                mT.append("sapiinit", String.valueOf(this.fvk));
                mT.append("acctinit", String.valueOf(this.fvl));
                mT.append("iminit", String.valueOf(this.fvm));
                mT.append("plugininit", String.valueOf(this.fvn));
                mT.append("patchloaded", String.valueOf(this.fvo));
                mT.append("naslibinit", String.valueOf(this.fvp));
                mT.append("websocketinit", String.valueOf(this.fvq));
                mT.append("settinginit", String.valueOf(this.fvr));
                mT.append("toastinit", String.valueOf(this.fvs));
                mT.append("tiebastaticinit", String.valueOf(this.fvt));
                mT.append("cdninit", String.valueOf(this.fvv));
                mT.append("messagesetinit", String.valueOf(this.fvw));
                mT.append("logores", String.valueOf(this.fvD));
                mT.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eIH ? 1 : 0));
                mT.append("adc", String.valueOf(this.fvx + this.fvy));
                mT.append("hasad", "0");
                mT.append("tabc", String.valueOf(j3));
                mT.append("costt", String.valueOf(this.totalTime));
                mT.append("newinst", this.fvd ? "1" : "0");
                mT.append("pluginloadsync", Boolean.valueOf(this.fvg));
                mT.append("hptotal", String.valueOf(this.fvB));
                mT.append("locationinit", String.valueOf(j2 + j + this.fvD + this.fvx + this.fvy + j3 + this.fvB));
                mT.append("userperceptiont", String.valueOf(this.fvC));
                BdStatisticsManager.getInstance().performance("startt", mT);
                bic();
            }
        }
    }

    public void ee(long j) {
        if (m.bBK().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "remote");
            mT.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mT);
        }
    }

    private void bic() {
        this.fvd = false;
        this.fve = false;
        this.fvh = -1L;
        this.fvi = -1L;
        this.totalTime = -1L;
        this.fvj = -1L;
        this.fvk = -1L;
        this.fvl = -1L;
        this.fvm = -1L;
        this.fvn = -1L;
        this.fvo = -1L;
        this.fvD = -1L;
        this.fvz = -1L;
        this.fvA = -1L;
        this.fvx = -1L;
        this.fvE = -1L;
        this.fvF = -1L;
        this.fvp = -1L;
        this.fvq = -1L;
        this.fvr = -1L;
        this.fvs = -1L;
        this.fvt = -1L;
        this.fvu = -1L;
        this.fvv = -1L;
        this.fvw = -1L;
        this.fvy = -1L;
        this.startTime = -1L;
        this.fvB = -1L;
        this.fvC = -1L;
    }

    public void ef(long j) {
        if (this.fvB <= 0) {
            this.fvB = j;
            this.totalTime = System.currentTimeMillis() - this.fvh;
        }
    }

    public long bBQ() {
        return this.totalTime;
    }

    public void eg(long j) {
        this.fvC = j;
    }
}
