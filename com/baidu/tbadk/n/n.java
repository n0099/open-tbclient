package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eeY = null;
    private boolean eew = false;
    private boolean eex = false;
    private boolean eey = false;
    private boolean eez = false;
    private long eeA = -1;
    private long eeB = -1;
    private long eeC = -1;
    private long eeD = -1;
    private long eeE = -1;
    private long eeF = -1;
    private long eeG = -1;
    private long eeH = -1;
    private long eeI = -1;
    private long eeJ = -1;
    private long eeK = -1;
    private long eeL = -1;
    private long eeM = -1;
    private long eeN = -1;
    private long eeO = -1;
    private long eeP = -1;
    private long eeQ = -1;
    private long eeR = -1;
    private long eeS = -1;
    private long eeT = -1;
    private long eeU = -1;
    private long eeV = -1;
    private long eeW = -1;
    private long eeX = -1;

    public boolean aZB() {
        return this.eex;
    }

    public void hU(boolean z) {
        this.eew = z;
    }

    public void cs(long j) {
        this.eeA = j;
    }

    public long aZC() {
        return this.eeA;
    }

    public void hV(boolean z) {
        this.eez = z;
    }

    public void ct(long j) {
        this.eeB = j;
    }

    public void cu(long j) {
        this.eeC = j;
    }

    public void cv(long j) {
        this.eeD = j;
    }

    public void cw(long j) {
        this.eeH = j;
    }

    public void cx(long j) {
        this.eeG = j;
    }

    public void cy(long j) {
        this.eeE = j;
    }

    public void cz(long j) {
        this.eeF = j;
    }

    public void cA(long j) {
        this.eeV = j;
    }

    public void cB(long j) {
        this.eeQ = j;
    }

    public void cC(long j) {
        this.eeR = j;
    }

    public void cD(long j) {
        this.eeS = j;
    }

    public void cE(long j) {
        this.eeT = j;
    }

    public void cF(long j) {
        this.eeW = j;
    }

    public void cG(long j) {
        this.eeX = j;
        this.eex = true;
    }

    public void cH(long j) {
        this.eeI = j;
    }

    public void cI(long j) {
        this.eeJ = j;
    }

    public void cJ(long j) {
        this.eeL = j;
    }

    public void cK(long j) {
        this.eeK = j;
    }

    public void cL(long j) {
        this.eeM = j;
    }

    public void cM(long j) {
        this.eeN = j;
    }

    public void cN(long j) {
        this.eeO = j;
    }

    public void cO(long j) {
        this.eeP = j;
    }

    public static n aZD() {
        if (eeY == null) {
            synchronized (n.class) {
                if (eeY == null) {
                    eeY = new n();
                }
            }
        }
        return eeY;
    }

    public void aZE() {
        if (this.eeX - this.eeA > 0 && !this.eey && m.aZy().aZz()) {
            this.eey = true;
            long j = this.eeB - this.eeA;
            long j2 = -1;
            if (this.eeS > 0) {
                j2 = this.eeT - this.eeS;
            }
            long j3 = this.eeX - this.eeW;
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("procname", "main");
            kW.append("appc", String.valueOf(j));
            kW.append("loadclass", String.valueOf(this.eeC));
            kW.append("sapiinit", String.valueOf(this.eeD));
            kW.append("acctinit", String.valueOf(this.eeE));
            kW.append("iminit", String.valueOf(this.eeF));
            kW.append("plugininit", String.valueOf(this.eeG));
            kW.append("patchloaded", String.valueOf(this.eeH));
            kW.append("naslibinit", String.valueOf(this.eeI));
            kW.append("websocketinit", String.valueOf(this.eeJ));
            kW.append("settinginit", String.valueOf(this.eeK));
            kW.append("toastinit", String.valueOf(this.eeL));
            kW.append("tiebastaticinit", String.valueOf(this.eeM));
            kW.append("locationinit", String.valueOf(this.eeN));
            kW.append("cdninit", String.valueOf(this.eeO));
            kW.append("messagesetinit", String.valueOf(this.eeP));
            kW.append("logores", String.valueOf(this.eeV));
            if (this.eeQ > 0 && this.eeS > 0 && j2 > 0) {
                kW.append("adc", String.valueOf(this.eeQ + this.eeR));
                kW.append("adshow", String.valueOf(j2));
                kW.append("adrequest", String.valueOf(this.eeR));
                kW.append("hasad", "1");
            } else {
                kW.append("hasad", "0");
            }
            kW.append("tabc", String.valueOf(j3));
            kW.append("costt", String.valueOf(j2 + j + this.eeQ + this.eeR + j3 + this.eeU));
            kW.append("newinst", this.eew ? "1" : "0");
            kW.append("pluginloadsync", Boolean.valueOf(this.eez));
            kW.append("hptotal", String.valueOf(this.eeU));
            BdStatisticsManager.getInstance().performance("startt", kW);
            aHk();
        }
    }

    public void cP(long j) {
        if (m.aZy().aZz() && j > 0) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("procname", "remote");
            kW.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", kW);
        }
    }

    private void aHk() {
        this.eew = false;
        this.eex = false;
        this.eeA = -1L;
        this.eeB = -1L;
        this.eeC = -1L;
        this.eeD = -1L;
        this.eeE = -1L;
        this.eeF = -1L;
        this.eeG = -1L;
        this.eeH = -1L;
        this.eeV = -1L;
        this.eeS = -1L;
        this.eeT = -1L;
        this.eeQ = -1L;
        this.eeW = -1L;
        this.eeX = -1L;
        this.eeI = -1L;
        this.eeJ = -1L;
        this.eeK = -1L;
        this.eeL = -1L;
        this.eeM = -1L;
        this.eeN = -1L;
        this.eeO = -1L;
        this.eeP = -1L;
        this.eeR = -1L;
        this.eeU = -1L;
    }

    public void cQ(long j) {
        this.eeU = j;
    }
}
