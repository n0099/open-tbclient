package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aAn = null;
    private boolean azN = false;
    private boolean azO = false;
    private boolean azP = false;
    private boolean azQ = false;
    private long azR = -1;
    private long azS = -1;
    private long azT = -1;
    private long azU = -1;
    private long azV = -1;
    private long azW = -1;
    private long azX = -1;
    private long azY = -1;
    private long azZ = -1;
    private long aAa = -1;
    private long aAb = -1;
    private long aAc = -1;
    private long aAd = -1;
    private long aAe = -1;
    private long aAf = -1;
    private long aAg = -1;
    private long aAh = -1;
    private long aAi = -1;
    private long aAj = -1;
    private long aAk = -1;
    private long aAl = -1;
    private long aAm = -1;

    public boolean Fa() {
        return this.azO;
    }

    public void bT(boolean z) {
        this.azN = z;
    }

    public void P(long j) {
        this.azR = j;
    }

    public void bU(boolean z) {
        this.azQ = z;
    }

    public void Q(long j) {
        this.azS = j;
    }

    public void R(long j) {
        this.azT = j;
    }

    public void S(long j) {
        this.azU = j;
    }

    public void T(long j) {
        this.azY = j;
    }

    public void U(long j) {
        this.azX = j;
    }

    public void V(long j) {
        this.azV = j;
    }

    public void W(long j) {
        this.azW = j;
    }

    public void X(long j) {
        this.aAk = j;
    }

    public void Y(long j) {
        this.aAh = j;
    }

    public void Z(long j) {
        this.aAi = j;
    }

    public void aa(long j) {
        this.aAj = j;
    }

    public void ab(long j) {
        this.aAl = j;
    }

    public void ac(long j) {
        this.aAm = j;
        this.azO = true;
    }

    public void ad(long j) {
        this.azZ = j;
    }

    public void ae(long j) {
        this.aAa = j;
    }

    public void af(long j) {
        this.aAc = j;
    }

    public void ag(long j) {
        this.aAb = j;
    }

    public void ah(long j) {
        this.aAd = j;
    }

    public void ai(long j) {
        this.aAe = j;
    }

    public void aj(long j) {
        this.aAf = j;
    }

    public void ak(long j) {
        this.aAg = j;
    }

    public static ab Fb() {
        if (aAn == null) {
            synchronized (ab.class) {
                if (aAn == null) {
                    aAn = new ab();
                }
            }
        }
        return aAn;
    }

    public void Fc() {
        long j = this.aAm - this.azR;
        if (j > 0 && !this.azP && aa.EV().EW()) {
            this.azP = true;
            long j2 = this.azS - this.azR;
            long j3 = this.aAk - this.azR;
            long j4 = -1;
            if (this.aAi > 0) {
                j4 = this.aAj - this.aAi;
            }
            long j5 = this.aAm - this.aAl;
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("procname", "main");
            dG.q("appc", String.valueOf(j2));
            dG.q("loadclass", String.valueOf(this.azT));
            dG.q("sapiinit", String.valueOf(this.azU));
            dG.q("acctinit", String.valueOf(this.azV));
            dG.q("iminit", String.valueOf(this.azW));
            dG.q("plugininit", String.valueOf(this.azX));
            dG.q("patchloaded", String.valueOf(this.azY));
            dG.q("naslibinit", String.valueOf(this.azZ));
            dG.q("websocketinit", String.valueOf(this.aAa));
            dG.q("settinginit", String.valueOf(this.aAb));
            dG.q("toastinit", String.valueOf(this.aAc));
            dG.q("tiebastaticinit", String.valueOf(this.aAd));
            dG.q("locationinit", String.valueOf(this.aAe));
            dG.q("cdninit", String.valueOf(this.aAf));
            dG.q("messagesetinit", String.valueOf(this.aAg));
            dG.q("logores", String.valueOf(j3));
            if (this.aAh > 0 && this.aAi > 0 && j4 > 0) {
                dG.q("adc", String.valueOf(this.aAh));
                dG.q("adshow", String.valueOf(j4));
                dG.q("hasad", "1");
            } else {
                dG.q("hasad", "0");
            }
            dG.q("tabc", String.valueOf(j5));
            dG.q("costt", String.valueOf(j));
            dG.q("newinst", this.azN ? "1" : "0");
            dG.d("pluginloadsync", Boolean.valueOf(this.azQ));
            com.baidu.adp.lib.stats.a.dN().a("startt", dG);
            mR();
        }
    }

    public void al(long j) {
        if (aa.EV().EW() && j > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("procname", "remote");
            dG.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dN().a("startt", dG);
        }
    }

    private void mR() {
        this.azN = false;
        this.azO = false;
        this.azR = -1L;
        this.azS = -1L;
        this.azT = -1L;
        this.azU = -1L;
        this.azV = -1L;
        this.azW = -1L;
        this.azX = -1L;
        this.azY = -1L;
        this.aAk = -1L;
        this.aAi = -1L;
        this.aAj = -1L;
        this.aAh = -1L;
        this.aAl = -1L;
        this.aAm = -1L;
        this.azZ = -1L;
        this.aAa = -1L;
        this.aAb = -1L;
        this.aAc = -1L;
        this.aAd = -1L;
        this.aAe = -1L;
        this.aAf = -1L;
        this.aAg = -1L;
    }
}
