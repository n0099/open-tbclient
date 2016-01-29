package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aBG = null;
    private boolean aBj = false;
    private boolean aBk = false;
    private long aBl = -1;
    private long aBm = -1;
    private long aBn = -1;
    private long aBo = -1;
    private long aBp = -1;
    private long aBq = -1;
    private long aBr = -1;
    private long aBs = -1;
    private long aBt = -1;
    private long aBu = -1;
    private long aBv = -1;
    private long aBw = -1;
    private long aBx = -1;
    private long aBy = -1;
    private long aBz = -1;
    private long aBA = -1;
    private long aBB = -1;
    private long aBC = -1;
    private long aBD = -1;
    private long aBE = -1;
    private long aBF = -1;

    public boolean Gd() {
        return this.aBk;
    }

    public void bE(boolean z) {
        this.aBj = z;
    }

    public void N(long j) {
        this.aBl = j;
    }

    public void O(long j) {
        this.aBm = j;
    }

    public void P(long j) {
        this.aBn = j;
    }

    public void Q(long j) {
        this.aBo = j;
    }

    public void R(long j) {
        this.aBr = j;
    }

    public void S(long j) {
        this.aBp = j;
    }

    public void T(long j) {
        this.aBq = j;
    }

    public void U(long j) {
        this.aBD = j;
    }

    public void V(long j) {
        this.aBA = j;
    }

    public void W(long j) {
        this.aBB = j;
    }

    public void X(long j) {
        this.aBC = j;
    }

    public void Y(long j) {
        this.aBE = j;
    }

    public void Z(long j) {
        this.aBF = j;
        this.aBk = true;
    }

    public void aa(long j) {
        this.aBs = j;
    }

    public void ab(long j) {
        this.aBt = j;
    }

    public void ac(long j) {
        this.aBv = j;
    }

    public void ad(long j) {
        this.aBu = j;
    }

    public void ae(long j) {
        this.aBw = j;
    }

    public void af(long j) {
        this.aBx = j;
    }

    public void ag(long j) {
        this.aBy = j;
    }

    public void ah(long j) {
        this.aBz = j;
    }

    public static ab Ge() {
        if (aBG == null) {
            synchronized (ab.class) {
                if (aBG == null) {
                    aBG = new ab();
                }
            }
        }
        return aBG;
    }

    public void Gf() {
        if (this.aBl > 0) {
            if (aa.FY().FZ()) {
                long j = this.aBm - this.aBl;
                long j2 = this.aBD - this.aBl;
                long j3 = -1;
                if (this.aBB > 0) {
                    j3 = this.aBC - this.aBB;
                }
                long j4 = this.aBF - this.aBE;
                long j5 = this.aBF - this.aBl;
                com.baidu.adp.lib.stats.d hm = hm();
                hm.r("procname", "main");
                hm.r("appc", String.valueOf(j));
                hm.r("loadclass", String.valueOf(this.aBn));
                hm.r("sapiinit", String.valueOf(this.aBo));
                hm.r("acctinit", String.valueOf(this.aBp));
                hm.r("iminit", String.valueOf(this.aBq));
                hm.r("plugininit", String.valueOf(this.aBr));
                hm.r("naslibinit", String.valueOf(this.aBs));
                hm.r("websocketinit", String.valueOf(this.aBt));
                hm.r("settinginit", String.valueOf(this.aBu));
                hm.r("toastinit", String.valueOf(this.aBv));
                hm.r("tiebastaticinit", String.valueOf(this.aBw));
                hm.r("locationinit", String.valueOf(this.aBx));
                hm.r("cdninit", String.valueOf(this.aBy));
                hm.r("messagesetinit", String.valueOf(this.aBz));
                hm.r("logores", String.valueOf(j2));
                if (this.aBA > 0 && this.aBB > 0 && j3 > 0) {
                    hm.r("adc", String.valueOf(this.aBA));
                    hm.r("adshow", String.valueOf(j3));
                    hm.r("hasad", "1");
                } else {
                    hm.r("hasad", "0");
                }
                hm.r("tabc", String.valueOf(j4));
                hm.r("costt", String.valueOf(j5));
                hm.r("newinst", this.aBj ? "1" : "0");
                com.baidu.adp.lib.stats.a.ht().a("startt", hm);
            } else {
                return;
            }
        }
        resetValues();
    }

    public void ai(long j) {
        if (aa.FY().FZ()) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("procname", "remote");
            hm.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.ht().a("startt", hm);
        }
    }

    private void resetValues() {
        this.aBj = false;
        this.aBk = false;
        this.aBl = -1L;
        this.aBm = -1L;
        this.aBn = -1L;
        this.aBo = -1L;
        this.aBp = -1L;
        this.aBq = -1L;
        this.aBr = -1L;
        this.aBD = -1L;
        this.aBB = -1L;
        this.aBC = -1L;
        this.aBA = -1L;
        this.aBE = -1L;
        this.aBF = -1L;
        this.aBs = -1L;
        this.aBt = -1L;
        this.aBu = -1L;
        this.aBv = -1L;
        this.aBw = -1L;
        this.aBx = -1L;
        this.aBy = -1L;
        this.aBz = -1L;
    }
}
