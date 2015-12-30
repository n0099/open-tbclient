package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z aAR = null;
    private boolean aAu = false;
    private boolean aAv = false;
    private long aAw = -1;
    private long aAx = -1;
    private long aAy = -1;
    private long aAz = -1;
    private long aAA = -1;
    private long aAB = -1;
    private long aAC = -1;
    private long aAD = -1;
    private long aAE = -1;
    private long aAF = -1;
    private long aAG = -1;
    private long aAH = -1;
    private long aAI = -1;
    private long aAJ = -1;
    private long aAK = -1;
    private long aAL = -1;
    private long aAM = -1;
    private long aAN = -1;
    private long aAO = -1;
    private long aAP = -1;
    private long aAQ = -1;

    public boolean EM() {
        return this.aAv;
    }

    public void bD(boolean z) {
        this.aAu = z;
    }

    public void K(long j) {
        this.aAw = j;
    }

    public void L(long j) {
        this.aAx = j;
    }

    public void M(long j) {
        this.aAy = j;
    }

    public void N(long j) {
        this.aAz = j;
    }

    public void O(long j) {
        this.aAC = j;
    }

    public void P(long j) {
        this.aAA = j;
    }

    public void Q(long j) {
        this.aAB = j;
    }

    public void R(long j) {
        this.aAO = j;
    }

    public void S(long j) {
        this.aAL = j;
    }

    public void T(long j) {
        this.aAM = j;
    }

    public void U(long j) {
        this.aAN = j;
    }

    public void V(long j) {
        this.aAP = j;
    }

    public void W(long j) {
        this.aAQ = j;
        this.aAv = true;
    }

    public void X(long j) {
        this.aAD = j;
    }

    public void Y(long j) {
        this.aAE = j;
    }

    public void Z(long j) {
        this.aAG = j;
    }

    public void aa(long j) {
        this.aAF = j;
    }

    public void ab(long j) {
        this.aAH = j;
    }

    public void ac(long j) {
        this.aAI = j;
    }

    public void ad(long j) {
        this.aAJ = j;
    }

    public void ae(long j) {
        this.aAK = j;
    }

    public static z EN() {
        if (aAR == null) {
            synchronized (z.class) {
                if (aAR == null) {
                    aAR = new z();
                }
            }
        }
        return aAR;
    }

    public void EO() {
        if (this.aAw > 0) {
            if (y.EH().EI()) {
                long j = this.aAx - this.aAw;
                long j2 = this.aAO - this.aAw;
                long j3 = -1;
                if (this.aAM > 0) {
                    j3 = this.aAN - this.aAM;
                }
                long j4 = this.aAQ - this.aAP;
                long j5 = this.aAQ - this.aAw;
                com.baidu.adp.lib.stats.d he = he();
                he.q("procname", "main");
                he.q("appc", String.valueOf(j));
                he.q("loadclass", String.valueOf(this.aAy));
                he.q("sapiinit", String.valueOf(this.aAz));
                he.q("acctinit", String.valueOf(this.aAA));
                he.q("iminit", String.valueOf(this.aAB));
                he.q("plugininit", String.valueOf(this.aAC));
                he.q("naslibinit", String.valueOf(this.aAD));
                he.q("websocketinit", String.valueOf(this.aAE));
                he.q("settinginit", String.valueOf(this.aAF));
                he.q("toastinit", String.valueOf(this.aAG));
                he.q("tiebastaticinit", String.valueOf(this.aAH));
                he.q("locationinit", String.valueOf(this.aAI));
                he.q("cdninit", String.valueOf(this.aAJ));
                he.q("messagesetinit", String.valueOf(this.aAK));
                he.q("logores", String.valueOf(j2));
                if (this.aAL > 0 && this.aAM > 0 && j3 > 0) {
                    he.q("adc", String.valueOf(this.aAL));
                    he.q("adshow", String.valueOf(j3));
                    he.q("hasad", "1");
                } else {
                    he.q("hasad", "0");
                }
                he.q("tabc", String.valueOf(j4));
                he.q("costt", String.valueOf(j5));
                he.q("newinst", this.aAu ? "1" : "0");
                com.baidu.adp.lib.stats.a.hl().a("startt", he);
            } else {
                return;
            }
        }
        qe();
    }

    public void af(long j) {
        if (y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("procname", "remote");
            he.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hl().a("startt", he);
        }
    }

    private void qe() {
        this.aAu = false;
        this.aAv = false;
        this.aAw = -1L;
        this.aAx = -1L;
        this.aAy = -1L;
        this.aAz = -1L;
        this.aAA = -1L;
        this.aAB = -1L;
        this.aAC = -1L;
        this.aAO = -1L;
        this.aAM = -1L;
        this.aAN = -1L;
        this.aAL = -1L;
        this.aAP = -1L;
        this.aAQ = -1L;
        this.aAD = -1L;
        this.aAE = -1L;
        this.aAF = -1L;
        this.aAG = -1L;
        this.aAH = -1L;
        this.aAI = -1L;
        this.aAJ = -1L;
        this.aAK = -1L;
    }
}
