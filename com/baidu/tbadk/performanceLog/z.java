package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z azK = null;
    private boolean azx = false;
    private boolean azy = false;
    private long azz = -1;
    private long azA = -1;
    private long azB = -1;
    private long azC = -1;
    private long azD = -1;
    private long azE = -1;
    private long azF = -1;
    private long azG = -1;
    private long azH = -1;
    private long azI = -1;
    private long azJ = -1;

    public boolean Et() {
        return this.azy;
    }

    public void bt(boolean z) {
        this.azx = z;
    }

    public void x(long j) {
        this.azz = j;
    }

    public void y(long j) {
        this.azA = j;
    }

    public void z(long j) {
        this.azB = j;
    }

    public void A(long j) {
        this.azC = j;
    }

    public void B(long j) {
        this.azD = j;
    }

    public void C(long j) {
        this.azE = j;
    }

    public void D(long j) {
        this.azF = j;
    }

    public void E(long j) {
        this.azI = j;
    }

    public void F(long j) {
        this.azJ = j;
        this.azy = true;
    }

    public static z Eu() {
        if (azK == null) {
            synchronized (z.class) {
                if (azK == null) {
                    azK = new z();
                }
            }
        }
        return azK;
    }

    public void Ev() {
        if (this.azz > 0) {
            if (y.Eo().Ep()) {
                long j = this.azA - this.azz;
                long j2 = this.azF - this.azA;
                long j3 = this.azH - this.azG;
                long j4 = this.azI - this.azH;
                long j5 = this.azJ - this.azI;
                long j6 = this.azJ - this.azz;
                com.baidu.adp.lib.stats.d ha = ha();
                ha.q("procname", "main");
                ha.q("appc", String.valueOf(j));
                ha.q("loadclass", String.valueOf(this.azB));
                ha.q("sapiinit", String.valueOf(this.azC));
                ha.q("acctinit", String.valueOf(this.azD));
                ha.q("iminit", String.valueOf(this.azE));
                ha.q("logores", String.valueOf(j2));
                if (this.azG > 0 && j3 > 0 && this.azH > 0 && j4 > 0) {
                    ha.q("adc", String.valueOf(j3));
                    ha.q("adshow", String.valueOf(j4));
                    ha.q("hasad", "1");
                } else {
                    ha.q("hasad", "0");
                }
                ha.q("tabc", String.valueOf(j5));
                ha.q("costt", String.valueOf(j6));
                ha.q("newinst", this.azx ? "1" : "0");
                com.baidu.adp.lib.stats.a.hh().a("startt", ha);
            } else {
                return;
            }
        }
        Ew();
    }

    public void G(long j) {
        if (y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("procname", "remote");
            ha.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hh().a("startt", ha);
        }
    }

    private void Ew() {
        this.azx = false;
        this.azy = false;
        this.azz = -1L;
        this.azA = -1L;
        this.azB = -1L;
        this.azC = -1L;
        this.azD = -1L;
        this.azE = -1L;
        this.azF = -1L;
        this.azG = -1L;
        this.azH = -1L;
        this.azI = -1L;
        this.azJ = -1L;
    }
}
