package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eeT = null;
    private boolean eer = false;
    private boolean ees = false;
    private boolean eet = false;
    private boolean eeu = false;
    private long eev = -1;
    private long eew = -1;
    private long eex = -1;
    private long eey = -1;
    private long eez = -1;
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

    public boolean aZD() {
        return this.ees;
    }

    public void hU(boolean z) {
        this.eer = z;
    }

    public void cs(long j) {
        this.eev = j;
    }

    public long aZE() {
        return this.eev;
    }

    public void hV(boolean z) {
        this.eeu = z;
    }

    public void ct(long j) {
        this.eew = j;
    }

    public void cu(long j) {
        this.eex = j;
    }

    public void cv(long j) {
        this.eey = j;
    }

    public void cw(long j) {
        this.eeC = j;
    }

    public void cx(long j) {
        this.eeB = j;
    }

    public void cy(long j) {
        this.eez = j;
    }

    public void cz(long j) {
        this.eeA = j;
    }

    public void cA(long j) {
        this.eeQ = j;
    }

    public void cB(long j) {
        this.eeL = j;
    }

    public void cC(long j) {
        this.eeM = j;
    }

    public void cD(long j) {
        this.eeN = j;
    }

    public void cE(long j) {
        this.eeO = j;
    }

    public void cF(long j) {
        this.eeR = j;
    }

    public void cG(long j) {
        this.eeS = j;
        this.ees = true;
    }

    public void cH(long j) {
        this.eeD = j;
    }

    public void cI(long j) {
        this.eeE = j;
    }

    public void cJ(long j) {
        this.eeG = j;
    }

    public void cK(long j) {
        this.eeF = j;
    }

    public void cL(long j) {
        this.eeH = j;
    }

    public void cM(long j) {
        this.eeI = j;
    }

    public void cN(long j) {
        this.eeJ = j;
    }

    public void cO(long j) {
        this.eeK = j;
    }

    public static n aZF() {
        if (eeT == null) {
            synchronized (n.class) {
                if (eeT == null) {
                    eeT = new n();
                }
            }
        }
        return eeT;
    }

    public void aZG() {
        if (this.eeS - this.eev > 0 && !this.eet && m.aZA().aZB()) {
            this.eet = true;
            long j = this.eew - this.eev;
            long j2 = -1;
            if (this.eeN > 0) {
                j2 = this.eeO - this.eeN;
            }
            long j3 = this.eeS - this.eeR;
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("procname", "main");
            kW.append("appc", String.valueOf(j));
            kW.append("loadclass", String.valueOf(this.eex));
            kW.append("sapiinit", String.valueOf(this.eey));
            kW.append("acctinit", String.valueOf(this.eez));
            kW.append("iminit", String.valueOf(this.eeA));
            kW.append("plugininit", String.valueOf(this.eeB));
            kW.append("patchloaded", String.valueOf(this.eeC));
            kW.append("naslibinit", String.valueOf(this.eeD));
            kW.append("websocketinit", String.valueOf(this.eeE));
            kW.append("settinginit", String.valueOf(this.eeF));
            kW.append("toastinit", String.valueOf(this.eeG));
            kW.append("tiebastaticinit", String.valueOf(this.eeH));
            kW.append("locationinit", String.valueOf(this.eeI));
            kW.append("cdninit", String.valueOf(this.eeJ));
            kW.append("messagesetinit", String.valueOf(this.eeK));
            kW.append("logores", String.valueOf(this.eeQ));
            if (this.eeL > 0 && this.eeN > 0 && j2 > 0) {
                kW.append("adc", String.valueOf(this.eeL + this.eeM));
                kW.append("adshow", String.valueOf(j2));
                kW.append("adrequest", String.valueOf(this.eeM));
                kW.append("hasad", "1");
            } else {
                kW.append("hasad", "0");
            }
            kW.append("tabc", String.valueOf(j3));
            kW.append("costt", String.valueOf(j2 + j + this.eeL + this.eeM + j3 + this.eeP));
            kW.append("newinst", this.eer ? "1" : "0");
            kW.append("pluginloadsync", Boolean.valueOf(this.eeu));
            kW.append("hptotal", String.valueOf(this.eeP));
            BdStatisticsManager.getInstance().performance("startt", kW);
            aHm();
        }
    }

    public void cP(long j) {
        if (m.aZA().aZB() && j > 0) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("procname", "remote");
            kW.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", kW);
        }
    }

    private void aHm() {
        this.eer = false;
        this.ees = false;
        this.eev = -1L;
        this.eew = -1L;
        this.eex = -1L;
        this.eey = -1L;
        this.eez = -1L;
        this.eeA = -1L;
        this.eeB = -1L;
        this.eeC = -1L;
        this.eeQ = -1L;
        this.eeN = -1L;
        this.eeO = -1L;
        this.eeL = -1L;
        this.eeR = -1L;
        this.eeS = -1L;
        this.eeD = -1L;
        this.eeE = -1L;
        this.eeF = -1L;
        this.eeG = -1L;
        this.eeH = -1L;
        this.eeI = -1L;
        this.eeJ = -1L;
        this.eeK = -1L;
        this.eeM = -1L;
        this.eeP = -1L;
    }

    public void cQ(long j) {
        this.eeP = j;
    }
}
