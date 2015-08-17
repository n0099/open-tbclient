package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z ayc = null;
    private boolean axP = false;
    private boolean axQ = false;
    private long axR = -1;
    private long axS = -1;
    private long axT = -1;
    private long axU = -1;
    private long axV = -1;
    private long axW = -1;
    private long axX = -1;
    private long axY = -1;
    private long axZ = -1;
    private long aya = -1;
    private long ayb = -1;

    public boolean Ej() {
        return this.axQ;
    }

    public void bm(boolean z) {
        this.axP = z;
    }

    public void w(long j) {
        this.axR = j;
    }

    public void x(long j) {
        this.axS = j;
    }

    public void y(long j) {
        this.axT = j;
    }

    public void z(long j) {
        this.axU = j;
    }

    public void A(long j) {
        this.axV = j;
    }

    public void B(long j) {
        this.axW = j;
    }

    public void C(long j) {
        this.axX = j;
    }

    public void D(long j) {
        this.aya = j;
    }

    public void E(long j) {
        this.ayb = j;
        this.axQ = true;
    }

    public static z Ek() {
        if (ayc == null) {
            synchronized (z.class) {
                if (ayc == null) {
                    ayc = new z();
                }
            }
        }
        return ayc;
    }

    public void El() {
        if (this.axR > 0) {
            if (y.Ee().Ef()) {
                long j = this.axS - this.axR;
                long j2 = this.axX - this.axS;
                long j3 = this.axZ - this.axY;
                long j4 = this.aya - this.axZ;
                long j5 = this.ayb - this.aya;
                long j6 = this.ayb - this.axR;
                com.baidu.adp.lib.stats.d hd = hd();
                hd.q("procname", "main");
                hd.q("appc", String.valueOf(j));
                hd.q("loadclass", String.valueOf(this.axT));
                hd.q("sapiinit", String.valueOf(this.axU));
                hd.q("acctinit", String.valueOf(this.axV));
                hd.q("iminit", String.valueOf(this.axW));
                hd.q("logores", String.valueOf(j2));
                if (this.axY > 0 && j3 > 0 && this.axZ > 0 && j4 > 0) {
                    hd.q("adc", String.valueOf(j3));
                    hd.q("adshow", String.valueOf(j4));
                    hd.q("hasad", "1");
                } else {
                    hd.q("hasad", "0");
                }
                hd.q("tabc", String.valueOf(j5));
                hd.q("costt", String.valueOf(j6));
                hd.q("newinst", this.axP ? "1" : "0");
                com.baidu.adp.lib.stats.a.hk().a("startt", hd);
            } else {
                return;
            }
        }
        Em();
    }

    public void F(long j) {
        if (y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("procname", "remote");
            hd.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hk().a("startt", hd);
        }
    }

    private void Em() {
        this.axP = false;
        this.axQ = false;
        this.axR = -1L;
        this.axS = -1L;
        this.axT = -1L;
        this.axU = -1L;
        this.axV = -1L;
        this.axW = -1L;
        this.axX = -1L;
        this.axY = -1L;
        this.axZ = -1L;
        this.aya = -1L;
        this.ayb = -1L;
    }
}
