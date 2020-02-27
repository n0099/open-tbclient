package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n dEI = null;
    private boolean dEg = false;
    private boolean dEh = false;
    private boolean dEi = false;
    private boolean dEj = false;
    private long dEk = -1;
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

    public boolean aRm() {
        return this.dEh;
    }

    public void gV(boolean z) {
        this.dEg = z;
    }

    public void bL(long j) {
        this.dEk = j;
    }

    public long aRn() {
        return this.dEk;
    }

    public void gW(boolean z) {
        this.dEj = z;
    }

    public void bM(long j) {
        this.dEl = j;
    }

    public void bN(long j) {
        this.dEm = j;
    }

    public void bO(long j) {
        this.dEn = j;
    }

    public void bP(long j) {
        this.dEr = j;
    }

    public void bQ(long j) {
        this.dEq = j;
    }

    public void bR(long j) {
        this.dEo = j;
    }

    public void bS(long j) {
        this.dEp = j;
    }

    public void bT(long j) {
        this.dEF = j;
    }

    public void bU(long j) {
        this.dEA = j;
    }

    public void bV(long j) {
        this.dEB = j;
    }

    public void bW(long j) {
        this.dEC = j;
    }

    public void bX(long j) {
        this.dED = j;
    }

    public void bY(long j) {
        this.dEG = j;
    }

    public void bZ(long j) {
        this.dEH = j;
        this.dEh = true;
    }

    public void ca(long j) {
        this.dEs = j;
    }

    public void cb(long j) {
        this.dEt = j;
    }

    public void cc(long j) {
        this.dEv = j;
    }

    public void cd(long j) {
        this.dEu = j;
    }

    public void ce(long j) {
        this.dEw = j;
    }

    public void cf(long j) {
        this.dEx = j;
    }

    public void cg(long j) {
        this.dEy = j;
    }

    public void ch(long j) {
        this.dEz = j;
    }

    public static n aRo() {
        if (dEI == null) {
            synchronized (n.class) {
                if (dEI == null) {
                    dEI = new n();
                }
            }
        }
        return dEI;
    }

    public void aRp() {
        if (this.dEH - this.dEk > 0 && !this.dEi && m.aRj().aRk()) {
            this.dEi = true;
            long j = this.dEl - this.dEk;
            long j2 = -1;
            if (this.dEC > 0) {
                j2 = this.dED - this.dEC;
            }
            long j3 = this.dEH - this.dEG;
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "main");
            gs.append("appc", String.valueOf(j));
            gs.append("loadclass", String.valueOf(this.dEm));
            gs.append("sapiinit", String.valueOf(this.dEn));
            gs.append("acctinit", String.valueOf(this.dEo));
            gs.append("iminit", String.valueOf(this.dEp));
            gs.append("plugininit", String.valueOf(this.dEq));
            gs.append("patchloaded", String.valueOf(this.dEr));
            gs.append("naslibinit", String.valueOf(this.dEs));
            gs.append("websocketinit", String.valueOf(this.dEt));
            gs.append("settinginit", String.valueOf(this.dEu));
            gs.append("toastinit", String.valueOf(this.dEv));
            gs.append("tiebastaticinit", String.valueOf(this.dEw));
            gs.append("locationinit", String.valueOf(this.dEx));
            gs.append("cdninit", String.valueOf(this.dEy));
            gs.append("messagesetinit", String.valueOf(this.dEz));
            gs.append("logores", String.valueOf(this.dEF));
            if (this.dEA > 0 && this.dEC > 0 && j2 > 0) {
                gs.append("adc", String.valueOf(this.dEA + this.dEB));
                gs.append("adshow", String.valueOf(j2));
                gs.append("adrequest", String.valueOf(this.dEB));
                gs.append("hasad", "1");
            } else {
                gs.append("hasad", "0");
            }
            gs.append("tabc", String.valueOf(j3));
            gs.append("costt", String.valueOf(j2 + j + this.dEA + this.dEB + j3 + this.dEE));
            gs.append("newinst", this.dEg ? "1" : "0");
            gs.append("pluginloadsync", Boolean.valueOf(this.dEj));
            gs.append("hptotal", String.valueOf(this.dEE));
            BdStatisticsManager.getInstance().performance("startt", gs);
            ayW();
        }
    }

    public void ci(long j) {
        if (m.aRj().aRk() && j > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "remote");
            gs.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gs);
        }
    }

    private void ayW() {
        this.dEg = false;
        this.dEh = false;
        this.dEk = -1L;
        this.dEl = -1L;
        this.dEm = -1L;
        this.dEn = -1L;
        this.dEo = -1L;
        this.dEp = -1L;
        this.dEq = -1L;
        this.dEr = -1L;
        this.dEF = -1L;
        this.dEC = -1L;
        this.dED = -1L;
        this.dEA = -1L;
        this.dEG = -1L;
        this.dEH = -1L;
        this.dEs = -1L;
        this.dEt = -1L;
        this.dEu = -1L;
        this.dEv = -1L;
        this.dEw = -1L;
        this.dEx = -1L;
        this.dEy = -1L;
        this.dEz = -1L;
        this.dEB = -1L;
        this.dEE = -1L;
    }

    public void cj(long j) {
        this.dEE = j;
    }
}
