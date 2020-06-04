package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n etm = null;
    private boolean esJ = false;
    private boolean esK = false;
    private boolean esL = false;
    private boolean esM = false;
    private long esN = -1;
    private long esO = -1;
    private long esP = -1;
    private long esQ = -1;
    private long esR = -1;
    private long esS = -1;
    private long esT = -1;
    private long esU = -1;
    private long esV = -1;
    private long esW = -1;
    private long esX = -1;
    private long esY = -1;
    private long esZ = -1;
    private long eta = -1;
    private long etb = -1;
    private long etd = -1;
    private long ete = -1;
    private long etf = -1;
    private long etg = -1;
    private long eth = -1;
    private long eti = -1;
    private long etj = -1;
    private long etk = -1;
    private long etl = -1;

    public boolean bfM() {
        return this.esK;
    }

    public void iq(boolean z) {
        this.esJ = z;
    }

    public void cu(long j) {
        this.esN = j;
    }

    public long bfN() {
        return this.esN;
    }

    public void ir(boolean z) {
        this.esM = z;
    }

    public void cv(long j) {
        this.esO = j;
    }

    public void cw(long j) {
        this.esP = j;
    }

    public void cx(long j) {
        this.esQ = j;
    }

    public void cy(long j) {
        this.esU = j;
    }

    public void cz(long j) {
        this.esT = j;
    }

    public void cA(long j) {
        this.esR = j;
    }

    public void cB(long j) {
        this.esS = j;
    }

    public void cC(long j) {
        this.etj = j;
    }

    public void cD(long j) {
        this.ete = j;
    }

    public void cE(long j) {
        this.etf = j;
    }

    public void cF(long j) {
        this.etg = j;
    }

    public void cG(long j) {
        this.eth = j;
    }

    public void cH(long j) {
        this.etk = j;
    }

    public void cI(long j) {
        this.etl = j;
        this.esK = true;
    }

    public void cJ(long j) {
        this.esV = j;
    }

    public void cK(long j) {
        this.esW = j;
    }

    public void cL(long j) {
        this.esY = j;
    }

    public void cM(long j) {
        this.esX = j;
    }

    public void cN(long j) {
        this.esZ = j;
    }

    public void cO(long j) {
        this.eta = j;
    }

    public void cP(long j) {
        this.etb = j;
    }

    public void cQ(long j) {
        this.etd = j;
    }

    public static n bfO() {
        if (etm == null) {
            synchronized (n.class) {
                if (etm == null) {
                    etm = new n();
                }
            }
        }
        return etm;
    }

    public void bfP() {
        if (this.etl - this.esN > 0 && !this.esL && this.eti > 0 && m.bfJ().bfK()) {
            this.esL = true;
            long j = this.esO - this.esN;
            long j2 = -1;
            if (this.etg > 0) {
                j2 = this.eth - this.etg;
            }
            long j3 = this.etl - this.etk;
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("procname", "main");
            kY.append("appc", String.valueOf(j));
            kY.append("loadclass", String.valueOf(this.esP));
            kY.append("sapiinit", String.valueOf(this.esQ));
            kY.append("acctinit", String.valueOf(this.esR));
            kY.append("iminit", String.valueOf(this.esS));
            kY.append("plugininit", String.valueOf(this.esT));
            kY.append("patchloaded", String.valueOf(this.esU));
            kY.append("naslibinit", String.valueOf(this.esV));
            kY.append("websocketinit", String.valueOf(this.esW));
            kY.append("settinginit", String.valueOf(this.esX));
            kY.append("toastinit", String.valueOf(this.esY));
            kY.append("tiebastaticinit", String.valueOf(this.esZ));
            kY.append("locationinit", String.valueOf(this.eta));
            kY.append("cdninit", String.valueOf(this.etb));
            kY.append("messagesetinit", String.valueOf(this.etd));
            kY.append("logores", String.valueOf(this.etj));
            kY.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.dKf ? 1 : 0));
            if (this.ete > 0 && this.etg > 0 && j2 > 0) {
                kY.append("adc", String.valueOf(this.ete + this.etf));
                kY.append("adshow", String.valueOf(j2));
                kY.append("adrequest", String.valueOf(this.etf));
                kY.append("hasad", "1");
            } else {
                kY.append("hasad", "0");
            }
            kY.append("tabc", String.valueOf(j3));
            kY.append("costt", String.valueOf(j2 + j + this.ete + this.etf + j3 + this.eti));
            kY.append("newinst", this.esJ ? "1" : "0");
            kY.append("pluginloadsync", Boolean.valueOf(this.esM));
            kY.append("hptotal", String.valueOf(this.eti));
            BdStatisticsManager.getInstance().performance("startt", kY);
            aMY();
        }
    }

    public void cR(long j) {
        if (m.bfJ().bfK() && j > 0) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("procname", "remote");
            kY.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", kY);
        }
    }

    private void aMY() {
        this.esJ = false;
        this.esK = false;
        this.esN = -1L;
        this.esO = -1L;
        this.esP = -1L;
        this.esQ = -1L;
        this.esR = -1L;
        this.esS = -1L;
        this.esT = -1L;
        this.esU = -1L;
        this.etj = -1L;
        this.etg = -1L;
        this.eth = -1L;
        this.ete = -1L;
        this.etk = -1L;
        this.etl = -1L;
        this.esV = -1L;
        this.esW = -1L;
        this.esX = -1L;
        this.esY = -1L;
        this.esZ = -1L;
        this.eta = -1L;
        this.etb = -1L;
        this.etd = -1L;
        this.etf = -1L;
        this.eti = -1L;
    }

    public void cS(long j) {
        if (this.eti <= 0) {
            this.eti = j;
        }
    }
}
