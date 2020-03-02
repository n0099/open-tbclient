package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n dEJ = null;
    private boolean dEh = false;
    private boolean dEi = false;
    private boolean dEj = false;
    private boolean dEk = false;
    private long dEl = -1;
    private long dEm = -1;
    private long dEn = -1;
    private long dEo = -1;
    private long dEp = -1;
    private long dEq = -1;
    private long dEr = -1;
    private long dEs = -1;
    private long dEt = -1;
    private long dEu = -1;
    private long dEv = -1;
    private long dEw = -1;
    private long dEx = -1;
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

    public boolean aRo() {
        return this.dEi;
    }

    public void gV(boolean z) {
        this.dEh = z;
    }

    public void bL(long j) {
        this.dEl = j;
    }

    public long aRp() {
        return this.dEl;
    }

    public void gW(boolean z) {
        this.dEk = z;
    }

    public void bM(long j) {
        this.dEm = j;
    }

    public void bN(long j) {
        this.dEn = j;
    }

    public void bO(long j) {
        this.dEo = j;
    }

    public void bP(long j) {
        this.dEs = j;
    }

    public void bQ(long j) {
        this.dEr = j;
    }

    public void bR(long j) {
        this.dEp = j;
    }

    public void bS(long j) {
        this.dEq = j;
    }

    public void bT(long j) {
        this.dEG = j;
    }

    public void bU(long j) {
        this.dEB = j;
    }

    public void bV(long j) {
        this.dEC = j;
    }

    public void bW(long j) {
        this.dED = j;
    }

    public void bX(long j) {
        this.dEE = j;
    }

    public void bY(long j) {
        this.dEH = j;
    }

    public void bZ(long j) {
        this.dEI = j;
        this.dEi = true;
    }

    public void ca(long j) {
        this.dEt = j;
    }

    public void cb(long j) {
        this.dEu = j;
    }

    public void cc(long j) {
        this.dEw = j;
    }

    public void cd(long j) {
        this.dEv = j;
    }

    public void ce(long j) {
        this.dEx = j;
    }

    public void cf(long j) {
        this.dEy = j;
    }

    public void cg(long j) {
        this.dEz = j;
    }

    public void ch(long j) {
        this.dEA = j;
    }

    public static n aRq() {
        if (dEJ == null) {
            synchronized (n.class) {
                if (dEJ == null) {
                    dEJ = new n();
                }
            }
        }
        return dEJ;
    }

    public void aRr() {
        if (this.dEI - this.dEl > 0 && !this.dEj && m.aRl().aRm()) {
            this.dEj = true;
            long j = this.dEm - this.dEl;
            long j2 = -1;
            if (this.dED > 0) {
                j2 = this.dEE - this.dED;
            }
            long j3 = this.dEI - this.dEH;
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "main");
            gs.append("appc", String.valueOf(j));
            gs.append("loadclass", String.valueOf(this.dEn));
            gs.append("sapiinit", String.valueOf(this.dEo));
            gs.append("acctinit", String.valueOf(this.dEp));
            gs.append("iminit", String.valueOf(this.dEq));
            gs.append("plugininit", String.valueOf(this.dEr));
            gs.append("patchloaded", String.valueOf(this.dEs));
            gs.append("naslibinit", String.valueOf(this.dEt));
            gs.append("websocketinit", String.valueOf(this.dEu));
            gs.append("settinginit", String.valueOf(this.dEv));
            gs.append("toastinit", String.valueOf(this.dEw));
            gs.append("tiebastaticinit", String.valueOf(this.dEx));
            gs.append("locationinit", String.valueOf(this.dEy));
            gs.append("cdninit", String.valueOf(this.dEz));
            gs.append("messagesetinit", String.valueOf(this.dEA));
            gs.append("logores", String.valueOf(this.dEG));
            if (this.dEB > 0 && this.dED > 0 && j2 > 0) {
                gs.append("adc", String.valueOf(this.dEB + this.dEC));
                gs.append("adshow", String.valueOf(j2));
                gs.append("adrequest", String.valueOf(this.dEC));
                gs.append("hasad", "1");
            } else {
                gs.append("hasad", "0");
            }
            gs.append("tabc", String.valueOf(j3));
            gs.append("costt", String.valueOf(j2 + j + this.dEB + this.dEC + j3 + this.dEF));
            gs.append("newinst", this.dEh ? "1" : "0");
            gs.append("pluginloadsync", Boolean.valueOf(this.dEk));
            gs.append("hptotal", String.valueOf(this.dEF));
            BdStatisticsManager.getInstance().performance("startt", gs);
            ayY();
        }
    }

    public void ci(long j) {
        if (m.aRl().aRm() && j > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "remote");
            gs.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gs);
        }
    }

    private void ayY() {
        this.dEh = false;
        this.dEi = false;
        this.dEl = -1L;
        this.dEm = -1L;
        this.dEn = -1L;
        this.dEo = -1L;
        this.dEp = -1L;
        this.dEq = -1L;
        this.dEr = -1L;
        this.dEs = -1L;
        this.dEG = -1L;
        this.dED = -1L;
        this.dEE = -1L;
        this.dEB = -1L;
        this.dEH = -1L;
        this.dEI = -1L;
        this.dEt = -1L;
        this.dEu = -1L;
        this.dEv = -1L;
        this.dEw = -1L;
        this.dEx = -1L;
        this.dEy = -1L;
        this.dEz = -1L;
        this.dEA = -1L;
        this.dEC = -1L;
        this.dEF = -1L;
    }

    public void cj(long j) {
        this.dEF = j;
    }
}
