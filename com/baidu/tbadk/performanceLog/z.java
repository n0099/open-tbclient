package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z ayj = null;
    private boolean axW = false;
    private boolean axX = false;
    private long axY = -1;
    private long axZ = -1;
    private long aya = -1;
    private long ayb = -1;
    private long ayc = -1;
    private long ayd = -1;
    private long aye = -1;
    private long ayf = -1;
    private long ayg = -1;
    private long ayh = -1;
    private long ayi = -1;

    public boolean Eg() {
        return this.axX;
    }

    public void br(boolean z) {
        this.axW = z;
    }

    public void E(long j) {
        this.axY = j;
    }

    public void F(long j) {
        this.axZ = j;
    }

    public void G(long j) {
        this.aya = j;
    }

    public void H(long j) {
        this.ayb = j;
    }

    public void I(long j) {
        this.ayc = j;
    }

    public void J(long j) {
        this.ayd = j;
    }

    public void K(long j) {
        this.aye = j;
    }

    public void L(long j) {
        this.ayf = j;
    }

    public void M(long j) {
        this.ayg = j;
    }

    public void N(long j) {
        this.ayh = j;
    }

    public void O(long j) {
        this.ayi = j;
        this.axX = true;
    }

    public static z Eh() {
        if (ayj == null) {
            synchronized (z.class) {
                if (ayj == null) {
                    ayj = new z();
                }
            }
        }
        return ayj;
    }

    public void Ei() {
        if (this.axY > 0) {
            if (y.Eb().Ec()) {
                long j = this.axZ - this.axY;
                long j2 = this.aye - this.axZ;
                long j3 = this.ayg - this.ayf;
                long j4 = this.ayh - this.ayg;
                long j5 = this.ayi - this.ayh;
                long j6 = this.ayi - this.axY;
                com.baidu.adp.lib.stats.d hb = hb();
                hb.q("procname", "main");
                hb.q("appc", String.valueOf(j));
                hb.q("loadclass", String.valueOf(this.aya));
                hb.q("sapiinit", String.valueOf(this.ayb));
                hb.q("acctinit", String.valueOf(this.ayc));
                hb.q("iminit", String.valueOf(this.ayd));
                hb.q("logores", String.valueOf(j2));
                if (this.ayf > 0 && j3 > 0 && this.ayg > 0 && j4 > 0) {
                    hb.q("adc", String.valueOf(j3));
                    hb.q("adshow", String.valueOf(j4));
                    hb.q("hasad", "1");
                } else {
                    hb.q("hasad", "0");
                }
                hb.q("tabc", String.valueOf(j5));
                hb.q("costt", String.valueOf(j6));
                hb.q("newinst", this.axW ? "1" : "0");
                com.baidu.adp.lib.stats.a.hi().a("startt", hb);
            } else {
                return;
            }
        }
        Ej();
    }

    public void P(long j) {
        if (y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("procname", "remote");
            hb.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hi().a("startt", hb);
        }
    }

    private void Ej() {
        this.axW = false;
        this.axX = false;
        this.axY = -1L;
        this.axZ = -1L;
        this.aya = -1L;
        this.ayb = -1L;
        this.ayc = -1L;
        this.ayd = -1L;
        this.aye = -1L;
        this.ayf = -1L;
        this.ayg = -1L;
        this.ayh = -1L;
        this.ayi = -1L;
    }
}
