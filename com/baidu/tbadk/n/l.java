package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l extends j {
    private static l fIt = null;
    private boolean fHM = false;
    private boolean fHN = false;
    private boolean fHO = false;
    private boolean fHP = false;
    private long fHQ = -1;
    private long fHR = -1;
    private long fHS = -1;
    private long fHT = -1;
    private long fHU = -1;
    private long fHV = -1;
    private long fHW = -1;
    private long fHX = -1;
    private long fHY = -1;
    private long fHZ = -1;
    private long fIa = -1;
    private long fIb = -1;
    private long fIc = -1;
    private long fId = -1;
    private long fIe = -1;
    private long fIf = -1;
    private long fIg = -1;
    private long fIh = -1;
    private long fIi = -1;
    private long fIj = -1;
    private long fIk = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fIl = -1;
    private long fIm = -1;
    private long fIn = -1;
    private long fIo = -1;
    private long fIp = -1;
    private long fIq = -1;
    private long fIr = -1;
    private long fIs = -1;

    public boolean bDR() {
        return this.fHN;
    }

    public void ll(boolean z) {
        this.fHM = z;
    }

    public void eg(long j) {
        this.fHQ = j;
    }

    public long bDS() {
        return this.fHQ;
    }

    public void lm(boolean z) {
        this.fHP = z;
    }

    public void eh(long j) {
        this.fHR = j;
    }

    public void ei(long j) {
        this.fHS = j;
    }

    public void ej(long j) {
        this.fHT = j;
    }

    public void ek(long j) {
        this.fHX = j;
    }

    public void el(long j) {
        this.fHW = j;
    }

    public void em(long j) {
        this.fHU = j;
    }

    public void en(long j) {
        this.fHV = j;
    }

    public void eo(long j) {
        this.fIq = j;
    }

    public void ep(long j) {
        this.fIg = j;
    }

    public void eq(long j) {
        this.fIh = j;
    }

    public void er(long j) {
        this.fIi = j;
    }

    public void es(long j) {
        this.fIj = j;
    }

    public void et(long j) {
        this.fIr = j;
    }

    public void eu(long j) {
        this.fIs = j;
        this.fHN = true;
    }

    public void ev(long j) {
        this.fHY = j;
    }

    public void ew(long j) {
        this.fHZ = j;
    }

    public void ex(long j) {
        this.fIb = j;
    }

    public void ey(long j) {
        this.fIa = j;
    }

    public void ez(long j) {
        this.fIc = j;
    }

    public void eA(long j) {
        this.fId = j;
    }

    public void eB(long j) {
        this.fIe = j;
    }

    public void eC(long j) {
        this.fIf = j;
    }

    public static l bDT() {
        if (fIt == null) {
            synchronized (l.class) {
                if (fIt == null) {
                    fIt = new l();
                }
            }
        }
        return fIt;
    }

    public void bDU() {
        long j = 0;
        if (this.fIs - this.fHQ > 0 && !this.fHO && this.fIk > 0 && k.bDO().isSmallFlow()) {
            long j2 = this.fHR - this.fHQ;
            long j3 = -1;
            if (this.fIi > 0) {
                j3 = this.fIj - this.fIi;
            }
            this.fHO = true;
            long j4 = this.fIs - this.fIr;
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("procname", "main");
            pi.append("appc", String.valueOf(j2));
            pi.append("loadclass", String.valueOf(this.fHS));
            pi.append("sapiinit", String.valueOf(this.fHT));
            pi.append("acctinit", String.valueOf(this.fIo));
            pi.append("iminit", String.valueOf(this.fIm));
            pi.append("plugininit", String.valueOf(this.fIn));
            pi.append("patchloaded", String.valueOf(this.fHX));
            pi.append("naslibinit", String.valueOf(this.fHY));
            pi.append("websocketinit", String.valueOf(this.fHZ));
            pi.append("settinginit", String.valueOf(this.fIa));
            pi.append("toastinit", String.valueOf(this.fIb));
            pi.append("tiebastaticinit", String.valueOf(this.fIc));
            pi.append("cdninit", String.valueOf(this.fIe));
            pi.append("messagesetinit", String.valueOf(this.fIf));
            pi.append("logores", String.valueOf(this.fIq));
            pi.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eVg ? 1 : 0));
            if (this.fIg > 0 && this.fIi > 0 && j3 > 0) {
                pi.append("adc", String.valueOf(this.fIg + this.fIh));
                pi.append("adshow", String.valueOf(j3));
                pi.append("adrequest", String.valueOf(this.fIh));
                j = this.fIg + this.fIh + j3;
                pi.append("hasad", "1");
            } else {
                pi.append("hasad", "0");
                if (this.fIh > 0) {
                    j = this.fIh;
                }
            }
            pi.append("tabc", String.valueOf(j4));
            pi.append("costt", String.valueOf(this.totalTime - j));
            pi.append("newinst", this.fHM ? "1" : "0");
            pi.append("pluginloadsync", Boolean.valueOf(this.fHP));
            pi.append("hptotal", String.valueOf(this.fIk));
            pi.append("locationinit", String.valueOf(j3 + j2 + this.fIq + this.fIg + this.fIh + j4 + this.fIk));
            pi.append("userperceptiont", String.valueOf(this.fIl - j));
            BdStatisticsManager.getInstance().performance("startt", pi);
            bjS();
        }
    }

    public void eD(long j) {
        if (k.bDO().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("procname", "remote");
            pi.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", pi);
        }
    }

    private void bjS() {
        this.fHM = false;
        this.fHN = false;
        this.fHQ = -1L;
        this.fHR = -1L;
        this.totalTime = -1L;
        this.fHS = -1L;
        this.fHT = -1L;
        this.fHU = -1L;
        this.fHV = -1L;
        this.fHW = -1L;
        this.fHX = -1L;
        this.fIq = -1L;
        this.fIi = -1L;
        this.fIj = -1L;
        this.fIg = -1L;
        this.fIr = -1L;
        this.fIs = -1L;
        this.fHY = -1L;
        this.fHZ = -1L;
        this.fIa = -1L;
        this.fIb = -1L;
        this.fIc = -1L;
        this.fId = -1L;
        this.fIe = -1L;
        this.fIf = -1L;
        this.fIh = -1L;
        this.startTime = -1L;
        this.fIk = -1L;
        this.fIl = -1L;
        this.fIm = -1L;
        this.fIn = -1L;
        this.fIo = -1L;
        this.fIp = -1L;
    }

    public void eE(long j) {
        if (this.fIk <= 0) {
            this.fIk = j;
            this.totalTime = System.currentTimeMillis() - this.fHQ;
        }
    }

    public long bDV() {
        return this.totalTime;
    }

    public void eF(long j) {
        this.fIl = j;
    }

    public void eG(long j) {
        this.fIm = j;
    }

    public void eH(long j) {
        if (this.fIn <= 0) {
            this.fIn = j;
        }
    }

    public void eI(long j) {
        this.fIo = j;
    }

    public void eJ(long j) {
        this.fIp = j - this.fIs;
    }
}
