package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z azo = null;
    private boolean ayR = false;
    private boolean ayS = false;
    private long ayT = -1;
    private long ayU = -1;
    private long ayV = -1;
    private long ayW = -1;
    private long ayX = -1;
    private long ayY = -1;
    private long ayZ = -1;
    private long aza = -1;
    private long azb = -1;
    private long azc = -1;
    private long azd = -1;
    private long aze = -1;
    private long azf = -1;
    private long azg = -1;
    private long azh = -1;
    private long azi = -1;
    private long azj = -1;
    private long azk = -1;
    private long azl = -1;
    private long azm = -1;
    private long azn = -1;

    public boolean EX() {
        return this.ayS;
    }

    public void bD(boolean z) {
        this.ayR = z;
    }

    public void J(long j) {
        this.ayT = j;
    }

    public void K(long j) {
        this.ayU = j;
    }

    public void L(long j) {
        this.ayV = j;
    }

    public void M(long j) {
        this.ayW = j;
    }

    public void N(long j) {
        this.ayZ = j;
    }

    public void O(long j) {
        this.ayX = j;
    }

    public void P(long j) {
        this.ayY = j;
    }

    public void Q(long j) {
        this.azl = j;
    }

    public void R(long j) {
        this.azi = j;
    }

    public void S(long j) {
        this.azj = j;
    }

    public void T(long j) {
        this.azk = j;
    }

    public void U(long j) {
        this.azm = j;
    }

    public void V(long j) {
        this.azn = j;
        this.ayS = true;
    }

    public void W(long j) {
        this.aza = j;
    }

    public void X(long j) {
        this.azb = j;
    }

    public void Y(long j) {
        this.azd = j;
    }

    public void Z(long j) {
        this.azc = j;
    }

    public void aa(long j) {
        this.aze = j;
    }

    public void ab(long j) {
        this.azf = j;
    }

    public void ac(long j) {
        this.azg = j;
    }

    public void ad(long j) {
        this.azh = j;
    }

    public static z EY() {
        if (azo == null) {
            synchronized (z.class) {
                if (azo == null) {
                    azo = new z();
                }
            }
        }
        return azo;
    }

    public void EZ() {
        if (this.ayT > 0) {
            if (y.ES().ET()) {
                long j = this.ayU - this.ayT;
                long j2 = this.azl - this.ayT;
                long j3 = -1;
                if (this.azj > 0) {
                    j3 = this.azk - this.azj;
                }
                long j4 = this.azn - this.azm;
                long j5 = this.azn - this.ayT;
                com.baidu.adp.lib.stats.d he = he();
                he.q("procname", "main");
                he.q("appc", String.valueOf(j));
                he.q("loadclass", String.valueOf(this.ayV));
                he.q("sapiinit", String.valueOf(this.ayW));
                he.q("acctinit", String.valueOf(this.ayX));
                he.q("iminit", String.valueOf(this.ayY));
                he.q("plugininit", String.valueOf(this.ayZ));
                he.q("naslibinit", String.valueOf(this.aza));
                he.q("websocketinit", String.valueOf(this.azb));
                he.q("settinginit", String.valueOf(this.azc));
                he.q("toastinit", String.valueOf(this.azd));
                he.q("tiebastaticinit", String.valueOf(this.aze));
                he.q("locationinit", String.valueOf(this.azf));
                he.q("cdninit", String.valueOf(this.azg));
                he.q("messagesetinit", String.valueOf(this.azh));
                he.q("logores", String.valueOf(j2));
                if (this.azi > 0 && this.azj > 0 && j3 > 0) {
                    he.q("adc", String.valueOf(this.azi));
                    he.q("adshow", String.valueOf(j3));
                    he.q("hasad", "1");
                } else {
                    he.q("hasad", "0");
                }
                he.q("tabc", String.valueOf(j4));
                he.q("costt", String.valueOf(j5));
                he.q("newinst", this.ayR ? "1" : "0");
                com.baidu.adp.lib.stats.a.hl().a("startt", he);
            } else {
                return;
            }
        }
        Fa();
    }

    public void ae(long j) {
        if (y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("procname", "remote");
            he.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hl().a("startt", he);
        }
    }

    private void Fa() {
        this.ayR = false;
        this.ayS = false;
        this.ayT = -1L;
        this.ayU = -1L;
        this.ayV = -1L;
        this.ayW = -1L;
        this.ayX = -1L;
        this.ayY = -1L;
        this.ayZ = -1L;
        this.azl = -1L;
        this.azj = -1L;
        this.azk = -1L;
        this.azi = -1L;
        this.azm = -1L;
        this.azn = -1L;
        this.aza = -1L;
        this.azb = -1L;
        this.azc = -1L;
        this.azd = -1L;
        this.aze = -1L;
        this.azf = -1L;
        this.azg = -1L;
        this.azh = -1L;
    }
}
