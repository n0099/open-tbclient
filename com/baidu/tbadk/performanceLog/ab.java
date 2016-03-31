package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aCE = null;
    private boolean aCe = false;
    private boolean aCf = false;
    private boolean aCg = false;
    private boolean aCh = false;
    private long aCi = -1;
    private long aCj = -1;
    private long aCk = -1;
    private long aCl = -1;
    private long aCm = -1;
    private long aCn = -1;
    private long aCo = -1;
    private long aCp = -1;
    private long aCq = -1;
    private long aCr = -1;
    private long aCs = -1;
    private long aCt = -1;
    private long aCu = -1;
    private long aCv = -1;
    private long aCw = -1;
    private long aCx = -1;
    private long aCy = -1;
    private long aCz = -1;
    private long aCA = -1;
    private long aCB = -1;
    private long aCC = -1;
    private long aCD = -1;

    public boolean GZ() {
        return this.aCf;
    }

    public void bL(boolean z) {
        this.aCe = z;
    }

    public void Q(long j) {
        this.aCi = j;
    }

    public void bM(boolean z) {
        this.aCh = z;
    }

    public void R(long j) {
        this.aCj = j;
    }

    public void S(long j) {
        this.aCk = j;
    }

    public void T(long j) {
        this.aCl = j;
    }

    public void U(long j) {
        this.aCp = j;
    }

    public void V(long j) {
        this.aCo = j;
    }

    public void W(long j) {
        this.aCm = j;
    }

    public void X(long j) {
        this.aCn = j;
    }

    public void Y(long j) {
        this.aCB = j;
    }

    public void Z(long j) {
        this.aCy = j;
    }

    public void aa(long j) {
        this.aCz = j;
    }

    public void ab(long j) {
        this.aCA = j;
    }

    public void ac(long j) {
        this.aCC = j;
    }

    public void ad(long j) {
        this.aCD = j;
        this.aCf = true;
    }

    public void ae(long j) {
        this.aCq = j;
    }

    public void af(long j) {
        this.aCr = j;
    }

    public void ag(long j) {
        this.aCt = j;
    }

    public void ah(long j) {
        this.aCs = j;
    }

    public void ai(long j) {
        this.aCu = j;
    }

    public void aj(long j) {
        this.aCv = j;
    }

    public void ak(long j) {
        this.aCw = j;
    }

    public void al(long j) {
        this.aCx = j;
    }

    public static ab Ha() {
        if (aCE == null) {
            synchronized (ab.class) {
                if (aCE == null) {
                    aCE = new ab();
                }
            }
        }
        return aCE;
    }

    public void Hb() {
        long j = this.aCD - this.aCi;
        if (j > 0 && !this.aCg && aa.GU().GV()) {
            this.aCg = true;
            long j2 = this.aCj - this.aCi;
            long j3 = this.aCB - this.aCi;
            long j4 = -1;
            if (this.aCz > 0) {
                j4 = this.aCA - this.aCz;
            }
            long j5 = this.aCD - this.aCC;
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("procname", "main");
            hs.r("appc", String.valueOf(j2));
            hs.r("loadclass", String.valueOf(this.aCk));
            hs.r("sapiinit", String.valueOf(this.aCl));
            hs.r("acctinit", String.valueOf(this.aCm));
            hs.r("iminit", String.valueOf(this.aCn));
            hs.r("plugininit", String.valueOf(this.aCo));
            hs.r("patchloaded", String.valueOf(this.aCp));
            hs.r("naslibinit", String.valueOf(this.aCq));
            hs.r("websocketinit", String.valueOf(this.aCr));
            hs.r("settinginit", String.valueOf(this.aCs));
            hs.r("toastinit", String.valueOf(this.aCt));
            hs.r("tiebastaticinit", String.valueOf(this.aCu));
            hs.r("locationinit", String.valueOf(this.aCv));
            hs.r("cdninit", String.valueOf(this.aCw));
            hs.r("messagesetinit", String.valueOf(this.aCx));
            hs.r("logores", String.valueOf(j3));
            if (this.aCy > 0 && this.aCz > 0 && j4 > 0) {
                hs.r("adc", String.valueOf(this.aCy));
                hs.r("adshow", String.valueOf(j4));
                hs.r("hasad", "1");
            } else {
                hs.r("hasad", "0");
            }
            hs.r("tabc", String.valueOf(j5));
            hs.r("costt", String.valueOf(j));
            hs.r("newinst", this.aCe ? "1" : "0");
            hs.b("pluginloadsync", Boolean.valueOf(this.aCh));
            com.baidu.adp.lib.stats.a.hz().a("startt", hs);
            resetValues();
        }
    }

    public void am(long j) {
        if (aa.GU().GV() && j > 0) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("procname", "remote");
            hs.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hz().a("startt", hs);
        }
    }

    private void resetValues() {
        this.aCe = false;
        this.aCf = false;
        this.aCi = -1L;
        this.aCj = -1L;
        this.aCk = -1L;
        this.aCl = -1L;
        this.aCm = -1L;
        this.aCn = -1L;
        this.aCo = -1L;
        this.aCp = -1L;
        this.aCB = -1L;
        this.aCz = -1L;
        this.aCA = -1L;
        this.aCy = -1L;
        this.aCC = -1L;
        this.aCD = -1L;
        this.aCq = -1L;
        this.aCr = -1L;
        this.aCs = -1L;
        this.aCt = -1L;
        this.aCu = -1L;
        this.aCv = -1L;
        this.aCw = -1L;
        this.aCx = -1L;
    }
}
