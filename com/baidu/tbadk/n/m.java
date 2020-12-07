package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class m extends k {
    private static m fDv = null;
    private boolean fCO = false;
    private boolean fCP = false;
    private boolean fCQ = false;
    private boolean fCR = false;
    private long fCS = -1;
    private long fCT = -1;
    private long fCU = -1;
    private long fCV = -1;
    private long fCW = -1;
    private long fCX = -1;
    private long fCY = -1;
    private long fCZ = -1;
    private long fDa = -1;
    private long fDb = -1;
    private long fDc = -1;
    private long fDd = -1;
    private long fDe = -1;
    private long fDf = -1;
    private long fDg = -1;
    private long fDh = -1;
    private long fDi = -1;
    private long fDj = -1;
    private long fDk = -1;
    private long fDl = -1;
    private long fDm = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fDn = -1;
    private long fDo = -1;
    private long fDp = -1;
    private long fDq = -1;
    private long fDr = -1;
    private long fDs = -1;
    private long fDt = -1;
    private long fDu = -1;

    public boolean bFn() {
        return this.fCP;
    }

    public void kT(boolean z) {
        this.fCO = z;
    }

    public void eg(long j) {
        this.fCS = j;
    }

    public long bFo() {
        return this.fCS;
    }

    public void kU(boolean z) {
        this.fCR = z;
    }

    public void eh(long j) {
        this.fCT = j;
    }

    public void ei(long j) {
        this.fCU = j;
    }

    public void ej(long j) {
        this.fCV = j;
    }

    public void ek(long j) {
        this.fCZ = j;
    }

    public void el(long j) {
        this.fCY = j;
    }

    public void em(long j) {
        this.fCW = j;
    }

    public void en(long j) {
        this.fCX = j;
    }

    public void eo(long j) {
        this.fDs = j;
    }

    public void ep(long j) {
        this.fDi = j;
    }

    public void eq(long j) {
        this.fDj = j;
    }

    public void er(long j) {
        this.fDk = j;
    }

    public void es(long j) {
        this.fDl = j;
    }

    public void et(long j) {
        this.fDt = j;
    }

    public void eu(long j) {
        this.fDu = j;
        this.fCP = true;
    }

    public void ev(long j) {
        this.fDa = j;
    }

    public void ew(long j) {
        this.fDb = j;
    }

    public void ex(long j) {
        this.fDd = j;
    }

    public void ey(long j) {
        this.fDc = j;
    }

    public void ez(long j) {
        this.fDe = j;
    }

    public void eA(long j) {
        this.fDf = j;
    }

    public void eB(long j) {
        this.fDg = j;
    }

    public void eC(long j) {
        this.fDh = j;
    }

    public static m bFp() {
        if (fDv == null) {
            synchronized (m.class) {
                if (fDv == null) {
                    fDv = new m();
                }
            }
        }
        return fDv;
    }

    public void bFq() {
        if (this.fDu - this.fCS > 0 && !this.fCQ && this.fDm > 0 && l.bFl().isSmallFlow()) {
            long j = this.fCT - this.fCS;
            long j2 = -1;
            if (this.fDk > 0) {
                j2 = this.fDl - this.fDk;
            }
            if (j2 <= 0) {
                this.fCQ = true;
                long j3 = this.fDu - this.fDt;
                com.baidu.adp.lib.stats.a mT = mT();
                mT.append("procname", "main");
                mT.append("appc", String.valueOf(j));
                mT.append("loadclass", String.valueOf(this.fCU));
                mT.append("sapiinit", String.valueOf(this.fCV));
                mT.append("acctinit", String.valueOf(this.fDq));
                mT.append("iminit", String.valueOf(this.fDo));
                mT.append("plugininit", String.valueOf(this.fDp));
                mT.append("patchloaded", String.valueOf(this.fCZ));
                mT.append("naslibinit", String.valueOf(this.fDa));
                mT.append("websocketinit", String.valueOf(this.fDb));
                mT.append("settinginit", String.valueOf(this.fDc));
                mT.append("toastinit", String.valueOf(this.fDd));
                mT.append("tiebastaticinit", String.valueOf(this.fDe));
                mT.append("cdninit", String.valueOf(this.fDg));
                mT.append("messagesetinit", String.valueOf(this.fDh));
                mT.append("logores", String.valueOf(this.fDs));
                mT.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.ePS ? 1 : 0));
                mT.append("adc", String.valueOf(this.fDi + this.fDj));
                mT.append("hasad", "0");
                mT.append("tabc", String.valueOf(j3));
                mT.append("costt", String.valueOf(this.totalTime));
                mT.append("newinst", this.fCO ? "1" : "0");
                mT.append("pluginloadsync", Boolean.valueOf(this.fCR));
                mT.append("hptotal", String.valueOf(this.fDm));
                mT.append("locationinit", String.valueOf(j2 + j + this.fDs + this.fDi + this.fDj + j3 + this.fDm));
                mT.append("userperceptiont", String.valueOf(this.fDn));
                BdStatisticsManager.getInstance().performance("startt", mT);
                blm();
            }
        }
    }

    public void eD(long j) {
        if (l.bFl().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "remote");
            mT.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mT);
        }
    }

    private void blm() {
        this.fCO = false;
        this.fCP = false;
        this.fCS = -1L;
        this.fCT = -1L;
        this.totalTime = -1L;
        this.fCU = -1L;
        this.fCV = -1L;
        this.fCW = -1L;
        this.fCX = -1L;
        this.fCY = -1L;
        this.fCZ = -1L;
        this.fDs = -1L;
        this.fDk = -1L;
        this.fDl = -1L;
        this.fDi = -1L;
        this.fDt = -1L;
        this.fDu = -1L;
        this.fDa = -1L;
        this.fDb = -1L;
        this.fDc = -1L;
        this.fDd = -1L;
        this.fDe = -1L;
        this.fDf = -1L;
        this.fDg = -1L;
        this.fDh = -1L;
        this.fDj = -1L;
        this.startTime = -1L;
        this.fDm = -1L;
        this.fDn = -1L;
        this.fDo = -1L;
        this.fDp = -1L;
        this.fDq = -1L;
        this.fDr = -1L;
    }

    public void eE(long j) {
        if (this.fDm <= 0) {
            this.fDm = j;
            this.totalTime = System.currentTimeMillis() - this.fCS;
        }
    }

    public long bFr() {
        return this.totalTime;
    }

    public void eF(long j) {
        this.fDn = j;
    }

    public void eG(long j) {
        this.fDo = j;
    }

    public void eH(long j) {
        if (this.fDp <= 0) {
            this.fDp = j;
        }
    }

    public void eI(long j) {
        this.fDq = j;
    }

    public void eJ(long j) {
        this.fDr = j - this.fDu;
    }
}
