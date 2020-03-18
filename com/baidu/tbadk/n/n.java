package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n dFm = null;
    private boolean dEK = false;
    private boolean dEL = false;
    private boolean dEM = false;
    private boolean dEN = false;
    private long dEO = -1;
    private long dEP = -1;
    private long dEQ = -1;
    private long dER = -1;
    private long dES = -1;
    private long dET = -1;
    private long dEU = -1;
    private long dEV = -1;
    private long dEW = -1;
    private long dEX = -1;
    private long dEY = -1;
    private long dEZ = -1;
    private long dFa = -1;
    private long dFb = -1;
    private long dFc = -1;
    private long dFd = -1;
    private long dFe = -1;
    private long dFf = -1;
    private long dFg = -1;
    private long dFh = -1;
    private long dFi = -1;
    private long dFj = -1;
    private long dFk = -1;
    private long dFl = -1;

    public boolean aRt() {
        return this.dEL;
    }

    public void gW(boolean z) {
        this.dEK = z;
    }

    public void bL(long j) {
        this.dEO = j;
    }

    public long aRu() {
        return this.dEO;
    }

    public void gX(boolean z) {
        this.dEN = z;
    }

    public void bM(long j) {
        this.dEP = j;
    }

    public void bN(long j) {
        this.dEQ = j;
    }

    public void bO(long j) {
        this.dER = j;
    }

    public void bP(long j) {
        this.dEV = j;
    }

    public void bQ(long j) {
        this.dEU = j;
    }

    public void bR(long j) {
        this.dES = j;
    }

    public void bS(long j) {
        this.dET = j;
    }

    public void bT(long j) {
        this.dFj = j;
    }

    public void bU(long j) {
        this.dFe = j;
    }

    public void bV(long j) {
        this.dFf = j;
    }

    public void bW(long j) {
        this.dFg = j;
    }

    public void bX(long j) {
        this.dFh = j;
    }

    public void bY(long j) {
        this.dFk = j;
    }

    public void bZ(long j) {
        this.dFl = j;
        this.dEL = true;
    }

    public void ca(long j) {
        this.dEW = j;
    }

    public void cb(long j) {
        this.dEX = j;
    }

    public void cc(long j) {
        this.dEZ = j;
    }

    public void cd(long j) {
        this.dEY = j;
    }

    public void ce(long j) {
        this.dFa = j;
    }

    public void cf(long j) {
        this.dFb = j;
    }

    public void cg(long j) {
        this.dFc = j;
    }

    public void ch(long j) {
        this.dFd = j;
    }

    public static n aRv() {
        if (dFm == null) {
            synchronized (n.class) {
                if (dFm == null) {
                    dFm = new n();
                }
            }
        }
        return dFm;
    }

    public void aRw() {
        if (this.dFl - this.dEO > 0 && !this.dEM && m.aRq().aRr()) {
            this.dEM = true;
            long j = this.dEP - this.dEO;
            long j2 = -1;
            if (this.dFg > 0) {
                j2 = this.dFh - this.dFg;
            }
            long j3 = this.dFl - this.dFk;
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "main");
            gs.append("appc", String.valueOf(j));
            gs.append("loadclass", String.valueOf(this.dEQ));
            gs.append("sapiinit", String.valueOf(this.dER));
            gs.append("acctinit", String.valueOf(this.dES));
            gs.append("iminit", String.valueOf(this.dET));
            gs.append("plugininit", String.valueOf(this.dEU));
            gs.append("patchloaded", String.valueOf(this.dEV));
            gs.append("naslibinit", String.valueOf(this.dEW));
            gs.append("websocketinit", String.valueOf(this.dEX));
            gs.append("settinginit", String.valueOf(this.dEY));
            gs.append("toastinit", String.valueOf(this.dEZ));
            gs.append("tiebastaticinit", String.valueOf(this.dFa));
            gs.append("locationinit", String.valueOf(this.dFb));
            gs.append("cdninit", String.valueOf(this.dFc));
            gs.append("messagesetinit", String.valueOf(this.dFd));
            gs.append("logores", String.valueOf(this.dFj));
            if (this.dFe > 0 && this.dFg > 0 && j2 > 0) {
                gs.append("adc", String.valueOf(this.dFe + this.dFf));
                gs.append("adshow", String.valueOf(j2));
                gs.append("adrequest", String.valueOf(this.dFf));
                gs.append("hasad", "1");
            } else {
                gs.append("hasad", "0");
            }
            gs.append("tabc", String.valueOf(j3));
            gs.append("costt", String.valueOf(j2 + j + this.dFe + this.dFf + j3 + this.dFi));
            gs.append("newinst", this.dEK ? "1" : "0");
            gs.append("pluginloadsync", Boolean.valueOf(this.dEN));
            gs.append("hptotal", String.valueOf(this.dFi));
            BdStatisticsManager.getInstance().performance("startt", gs);
            azb();
        }
    }

    public void ci(long j) {
        if (m.aRq().aRr() && j > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "remote");
            gs.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gs);
        }
    }

    private void azb() {
        this.dEK = false;
        this.dEL = false;
        this.dEO = -1L;
        this.dEP = -1L;
        this.dEQ = -1L;
        this.dER = -1L;
        this.dES = -1L;
        this.dET = -1L;
        this.dEU = -1L;
        this.dEV = -1L;
        this.dFj = -1L;
        this.dFg = -1L;
        this.dFh = -1L;
        this.dFe = -1L;
        this.dFk = -1L;
        this.dFl = -1L;
        this.dEW = -1L;
        this.dEX = -1L;
        this.dEY = -1L;
        this.dEZ = -1L;
        this.dFa = -1L;
        this.dFb = -1L;
        this.dFc = -1L;
        this.dFd = -1L;
        this.dFf = -1L;
        this.dFi = -1L;
    }

    public void cj(long j) {
        this.dFi = j;
    }
}
