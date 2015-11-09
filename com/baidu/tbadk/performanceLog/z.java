package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z axj = null;
    private boolean awM = false;
    private boolean awN = false;
    private long awO = -1;
    private long awP = -1;
    private long awQ = -1;
    private long awR = -1;
    private long awS = -1;
    private long awT = -1;
    private long awU = -1;
    private long awV = -1;
    private long awW = -1;
    private long awX = -1;
    private long awY = -1;
    private long awZ = -1;
    private long axa = -1;
    private long axb = -1;
    private long axc = -1;
    private long axd = -1;
    private long axe = -1;
    private long axf = -1;
    private long axg = -1;
    private long axh = -1;
    private long axi = -1;

    public boolean DW() {
        return this.awN;
    }

    public void bu(boolean z) {
        this.awM = z;
    }

    public void C(long j) {
        this.awO = j;
    }

    public void D(long j) {
        this.awP = j;
    }

    public void E(long j) {
        this.awQ = j;
    }

    public void F(long j) {
        this.awR = j;
    }

    public void G(long j) {
        this.awU = j;
    }

    public void H(long j) {
        this.awS = j;
    }

    public void I(long j) {
        this.awT = j;
    }

    public void J(long j) {
        this.axg = j;
    }

    public void K(long j) {
        this.axd = j;
    }

    public void L(long j) {
        this.axe = j;
    }

    public void M(long j) {
        this.axf = j;
    }

    public void N(long j) {
        this.axh = j;
    }

    public void O(long j) {
        this.axi = j;
        this.awN = true;
    }

    public void P(long j) {
        this.awV = j;
    }

    public void Q(long j) {
        this.awW = j;
    }

    public void R(long j) {
        this.awY = j;
    }

    public void S(long j) {
        this.awX = j;
    }

    public void T(long j) {
        this.awZ = j;
    }

    public void U(long j) {
        this.axa = j;
    }

    public void V(long j) {
        this.axb = j;
    }

    public void W(long j) {
        this.axc = j;
    }

    public static z DX() {
        if (axj == null) {
            synchronized (z.class) {
                if (axj == null) {
                    axj = new z();
                }
            }
        }
        return axj;
    }

    public void DY() {
        if (this.awO > 0) {
            if (y.DR().DS()) {
                long j = this.awP - this.awO;
                long j2 = this.axg - this.awO;
                long j3 = -1;
                if (this.axe > 0) {
                    j3 = this.axf - this.axe;
                }
                long j4 = this.axi - this.axh;
                long j5 = this.axi - this.awO;
                com.baidu.adp.lib.stats.d hc = hc();
                hc.q("procname", "main");
                hc.q("appc", String.valueOf(j));
                hc.q("loadclass", String.valueOf(this.awQ));
                hc.q("sapiinit", String.valueOf(this.awR));
                hc.q("acctinit", String.valueOf(this.awS));
                hc.q("iminit", String.valueOf(this.awT));
                hc.q("plugininit", String.valueOf(this.awU));
                hc.q("naslibinit", String.valueOf(this.awV));
                hc.q("websocketinit", String.valueOf(this.awW));
                hc.q("settinginit", String.valueOf(this.awX));
                hc.q("toastinit", String.valueOf(this.awY));
                hc.q("tiebastaticinit", String.valueOf(this.awZ));
                hc.q("locationinit", String.valueOf(this.axa));
                hc.q("cdninit", String.valueOf(this.axb));
                hc.q("messagesetinit", String.valueOf(this.axc));
                hc.q("logores", String.valueOf(j2));
                if (this.axd > 0 && this.axe > 0 && j3 > 0) {
                    hc.q("adc", String.valueOf(this.axd));
                    hc.q("adshow", String.valueOf(j3));
                    hc.q("hasad", "1");
                } else {
                    hc.q("hasad", "0");
                }
                hc.q("tabc", String.valueOf(j4));
                hc.q("costt", String.valueOf(j5));
                hc.q("newinst", this.awM ? "1" : "0");
                com.baidu.adp.lib.stats.a.hj().a("startt", hc);
            } else {
                return;
            }
        }
        DZ();
    }

    public void X(long j) {
        if (y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("procname", "remote");
            hc.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hj().a("startt", hc);
        }
    }

    private void DZ() {
        this.awM = false;
        this.awN = false;
        this.awO = -1L;
        this.awP = -1L;
        this.awQ = -1L;
        this.awR = -1L;
        this.awS = -1L;
        this.awT = -1L;
        this.awU = -1L;
        this.axg = -1L;
        this.axe = -1L;
        this.axf = -1L;
        this.axd = -1L;
        this.axh = -1L;
        this.axi = -1L;
        this.awV = -1L;
        this.awW = -1L;
        this.awX = -1L;
        this.awY = -1L;
        this.awZ = -1L;
        this.axa = -1L;
        this.axb = -1L;
        this.axc = -1L;
    }
}
