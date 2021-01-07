package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l extends j {
    private static l fNa = null;
    private boolean fMt = false;
    private boolean fMu = false;
    private boolean fMv = false;
    private boolean fMw = false;
    private long fMx = -1;
    private long fMy = -1;
    private long fMz = -1;
    private long fMA = -1;
    private long fMB = -1;
    private long fMC = -1;
    private long fMD = -1;
    private long fME = -1;
    private long fMF = -1;
    private long fMG = -1;
    private long fMH = -1;
    private long fMI = -1;
    private long fMJ = -1;
    private long fMK = -1;
    private long fML = -1;
    private long fMM = -1;
    private long fMN = -1;
    private long fMO = -1;
    private long fMP = -1;
    private long fMQ = -1;
    private long fMR = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fMS = -1;
    private long fMT = -1;
    private long fMU = -1;
    private long fMV = -1;
    private long fMW = -1;
    private long fMX = -1;
    private long fMY = -1;
    private long fMZ = -1;

    public boolean bHJ() {
        return this.fMu;
    }

    public void lp(boolean z) {
        this.fMt = z;
    }

    public void eg(long j) {
        this.fMx = j;
    }

    public long bHK() {
        return this.fMx;
    }

    public void lq(boolean z) {
        this.fMw = z;
    }

    public void eh(long j) {
        this.fMy = j;
    }

    public void ei(long j) {
        this.fMz = j;
    }

    public void ej(long j) {
        this.fMA = j;
    }

    public void ek(long j) {
        this.fME = j;
    }

    public void el(long j) {
        this.fMD = j;
    }

    public void em(long j) {
        this.fMB = j;
    }

    public void en(long j) {
        this.fMC = j;
    }

    public void eo(long j) {
        this.fMX = j;
    }

    public void ep(long j) {
        this.fMN = j;
    }

    public void eq(long j) {
        this.fMO = j;
    }

    public void er(long j) {
        this.fMP = j;
    }

    public void es(long j) {
        this.fMQ = j;
    }

    public void et(long j) {
        this.fMY = j;
    }

    public void eu(long j) {
        this.fMZ = j;
        this.fMu = true;
    }

    public void ev(long j) {
        this.fMF = j;
    }

    public void ew(long j) {
        this.fMG = j;
    }

    public void ex(long j) {
        this.fMI = j;
    }

    public void ey(long j) {
        this.fMH = j;
    }

    public void ez(long j) {
        this.fMJ = j;
    }

    public void eA(long j) {
        this.fMK = j;
    }

    public void eB(long j) {
        this.fML = j;
    }

    public void eC(long j) {
        this.fMM = j;
    }

    public static l bHL() {
        if (fNa == null) {
            synchronized (l.class) {
                if (fNa == null) {
                    fNa = new l();
                }
            }
        }
        return fNa;
    }

    public void bHM() {
        long j = 0;
        if (this.fMZ - this.fMx > 0 && !this.fMv && this.fMR > 0 && k.bHG().isSmallFlow()) {
            long j2 = this.fMy - this.fMx;
            long j3 = -1;
            if (this.fMP > 0) {
                j3 = this.fMQ - this.fMP;
            }
            this.fMv = true;
            long j4 = this.fMZ - this.fMY;
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("procname", "main");
            pi.append("appc", String.valueOf(j2));
            pi.append("loadclass", String.valueOf(this.fMz));
            pi.append("sapiinit", String.valueOf(this.fMA));
            pi.append("acctinit", String.valueOf(this.fMV));
            pi.append("iminit", String.valueOf(this.fMT));
            pi.append("plugininit", String.valueOf(this.fMU));
            pi.append("patchloaded", String.valueOf(this.fME));
            pi.append("naslibinit", String.valueOf(this.fMF));
            pi.append("websocketinit", String.valueOf(this.fMG));
            pi.append("settinginit", String.valueOf(this.fMH));
            pi.append("toastinit", String.valueOf(this.fMI));
            pi.append("tiebastaticinit", String.valueOf(this.fMJ));
            pi.append("cdninit", String.valueOf(this.fML));
            pi.append("messagesetinit", String.valueOf(this.fMM));
            pi.append("logores", String.valueOf(this.fMX));
            pi.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eZR ? 1 : 0));
            if (this.fMN > 0 && this.fMP > 0 && j3 > 0) {
                pi.append("adc", String.valueOf(this.fMN + this.fMO));
                pi.append("adshow", String.valueOf(j3));
                pi.append("adrequest", String.valueOf(this.fMO));
                j = this.fMN + this.fMO + j3;
                pi.append("hasad", "1");
            } else {
                pi.append("hasad", "0");
                if (this.fMO > 0) {
                    j = this.fMO;
                }
            }
            pi.append("tabc", String.valueOf(j4));
            pi.append("costt", String.valueOf(this.totalTime - j));
            pi.append("newinst", this.fMt ? "1" : "0");
            pi.append("pluginloadsync", Boolean.valueOf(this.fMw));
            pi.append("hptotal", String.valueOf(this.fMR));
            pi.append("locationinit", String.valueOf(j3 + j2 + this.fMX + this.fMN + this.fMO + j4 + this.fMR));
            pi.append("userperceptiont", String.valueOf(this.fMS - j));
            BdStatisticsManager.getInstance().performance("startt", pi);
            bnM();
        }
    }

    public void eD(long j) {
        if (k.bHG().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("procname", "remote");
            pi.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", pi);
        }
    }

    private void bnM() {
        this.fMt = false;
        this.fMu = false;
        this.fMx = -1L;
        this.fMy = -1L;
        this.totalTime = -1L;
        this.fMz = -1L;
        this.fMA = -1L;
        this.fMB = -1L;
        this.fMC = -1L;
        this.fMD = -1L;
        this.fME = -1L;
        this.fMX = -1L;
        this.fMP = -1L;
        this.fMQ = -1L;
        this.fMN = -1L;
        this.fMY = -1L;
        this.fMZ = -1L;
        this.fMF = -1L;
        this.fMG = -1L;
        this.fMH = -1L;
        this.fMI = -1L;
        this.fMJ = -1L;
        this.fMK = -1L;
        this.fML = -1L;
        this.fMM = -1L;
        this.fMO = -1L;
        this.startTime = -1L;
        this.fMR = -1L;
        this.fMS = -1L;
        this.fMT = -1L;
        this.fMU = -1L;
        this.fMV = -1L;
        this.fMW = -1L;
    }

    public void eE(long j) {
        if (this.fMR <= 0) {
            this.fMR = j;
            this.totalTime = System.currentTimeMillis() - this.fMx;
        }
    }

    public long bHN() {
        return this.totalTime;
    }

    public void eF(long j) {
        this.fMS = j;
    }

    public void eG(long j) {
        this.fMT = j;
    }

    public void eH(long j) {
        if (this.fMU <= 0) {
            this.fMU = j;
        }
    }

    public void eI(long j) {
        this.fMV = j;
    }

    public void eJ(long j) {
        this.fMW = j - this.fMZ;
    }
}
