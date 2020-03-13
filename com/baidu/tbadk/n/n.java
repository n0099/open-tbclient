package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n dEW = null;
    private boolean dEu = false;
    private boolean dEv = false;
    private boolean dEw = false;
    private boolean dEx = false;
    private long dEy = -1;
    private long dEz = -1;
    private long dEA = -1;
    private long dEB = -1;
    private long dEC = -1;
    private long dED = -1;
    private long dEE = -1;
    private long dEF = -1;
    private long dEG = -1;
    private long dEH = -1;
    private long dEI = -1;
    private long dEJ = -1;
    private long dEK = -1;
    private long dEL = -1;
    private long dEM = -1;
    private long dEN = -1;
    private long dEO = -1;
    private long dEP = -1;
    private long dEQ = -1;
    private long dER = -1;
    private long dES = -1;
    private long dET = -1;
    private long dEU = -1;
    private long dEV = -1;

    public boolean aRp() {
        return this.dEv;
    }

    public void gV(boolean z) {
        this.dEu = z;
    }

    public void bL(long j) {
        this.dEy = j;
    }

    public long aRq() {
        return this.dEy;
    }

    public void gW(boolean z) {
        this.dEx = z;
    }

    public void bM(long j) {
        this.dEz = j;
    }

    public void bN(long j) {
        this.dEA = j;
    }

    public void bO(long j) {
        this.dEB = j;
    }

    public void bP(long j) {
        this.dEF = j;
    }

    public void bQ(long j) {
        this.dEE = j;
    }

    public void bR(long j) {
        this.dEC = j;
    }

    public void bS(long j) {
        this.dED = j;
    }

    public void bT(long j) {
        this.dET = j;
    }

    public void bU(long j) {
        this.dEO = j;
    }

    public void bV(long j) {
        this.dEP = j;
    }

    public void bW(long j) {
        this.dEQ = j;
    }

    public void bX(long j) {
        this.dER = j;
    }

    public void bY(long j) {
        this.dEU = j;
    }

    public void bZ(long j) {
        this.dEV = j;
        this.dEv = true;
    }

    public void ca(long j) {
        this.dEG = j;
    }

    public void cb(long j) {
        this.dEH = j;
    }

    public void cc(long j) {
        this.dEJ = j;
    }

    public void cd(long j) {
        this.dEI = j;
    }

    public void ce(long j) {
        this.dEK = j;
    }

    public void cf(long j) {
        this.dEL = j;
    }

    public void cg(long j) {
        this.dEM = j;
    }

    public void ch(long j) {
        this.dEN = j;
    }

    public static n aRr() {
        if (dEW == null) {
            synchronized (n.class) {
                if (dEW == null) {
                    dEW = new n();
                }
            }
        }
        return dEW;
    }

    public void aRs() {
        if (this.dEV - this.dEy > 0 && !this.dEw && m.aRm().aRn()) {
            this.dEw = true;
            long j = this.dEz - this.dEy;
            long j2 = -1;
            if (this.dEQ > 0) {
                j2 = this.dER - this.dEQ;
            }
            long j3 = this.dEV - this.dEU;
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "main");
            gs.append("appc", String.valueOf(j));
            gs.append("loadclass", String.valueOf(this.dEA));
            gs.append("sapiinit", String.valueOf(this.dEB));
            gs.append("acctinit", String.valueOf(this.dEC));
            gs.append("iminit", String.valueOf(this.dED));
            gs.append("plugininit", String.valueOf(this.dEE));
            gs.append("patchloaded", String.valueOf(this.dEF));
            gs.append("naslibinit", String.valueOf(this.dEG));
            gs.append("websocketinit", String.valueOf(this.dEH));
            gs.append("settinginit", String.valueOf(this.dEI));
            gs.append("toastinit", String.valueOf(this.dEJ));
            gs.append("tiebastaticinit", String.valueOf(this.dEK));
            gs.append("locationinit", String.valueOf(this.dEL));
            gs.append("cdninit", String.valueOf(this.dEM));
            gs.append("messagesetinit", String.valueOf(this.dEN));
            gs.append("logores", String.valueOf(this.dET));
            if (this.dEO > 0 && this.dEQ > 0 && j2 > 0) {
                gs.append("adc", String.valueOf(this.dEO + this.dEP));
                gs.append("adshow", String.valueOf(j2));
                gs.append("adrequest", String.valueOf(this.dEP));
                gs.append("hasad", "1");
            } else {
                gs.append("hasad", "0");
            }
            gs.append("tabc", String.valueOf(j3));
            gs.append("costt", String.valueOf(j2 + j + this.dEO + this.dEP + j3 + this.dES));
            gs.append("newinst", this.dEu ? "1" : "0");
            gs.append("pluginloadsync", Boolean.valueOf(this.dEx));
            gs.append("hptotal", String.valueOf(this.dES));
            BdStatisticsManager.getInstance().performance("startt", gs);
            ayY();
        }
    }

    public void ci(long j) {
        if (m.aRm().aRn() && j > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "remote");
            gs.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gs);
        }
    }

    private void ayY() {
        this.dEu = false;
        this.dEv = false;
        this.dEy = -1L;
        this.dEz = -1L;
        this.dEA = -1L;
        this.dEB = -1L;
        this.dEC = -1L;
        this.dED = -1L;
        this.dEE = -1L;
        this.dEF = -1L;
        this.dET = -1L;
        this.dEQ = -1L;
        this.dER = -1L;
        this.dEO = -1L;
        this.dEU = -1L;
        this.dEV = -1L;
        this.dEG = -1L;
        this.dEH = -1L;
        this.dEI = -1L;
        this.dEJ = -1L;
        this.dEK = -1L;
        this.dEL = -1L;
        this.dEM = -1L;
        this.dEN = -1L;
        this.dEP = -1L;
        this.dES = -1L;
    }

    public void cj(long j) {
        this.dES = j;
    }
}
