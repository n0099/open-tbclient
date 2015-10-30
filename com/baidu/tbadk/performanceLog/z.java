package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends x {
    private static z ayu = null;
    private boolean axX = false;
    private boolean axY = false;
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
    private long ayj = -1;
    private long ayk = -1;
    private long ayl = -1;
    private long aym = -1;
    private long ayn = -1;
    private long ayo = -1;
    private long ayp = -1;
    private long ayq = -1;
    private long ayr = -1;
    private long ays = -1;
    private long ayt = -1;

    public boolean Ed() {
        return this.axY;
    }

    public void br(boolean z) {
        this.axX = z;
    }

    public void C(long j) {
        this.axZ = j;
    }

    public void D(long j) {
        this.aya = j;
    }

    public void E(long j) {
        this.ayb = j;
    }

    public void F(long j) {
        this.ayc = j;
    }

    public void G(long j) {
        this.ayf = j;
    }

    public void H(long j) {
        this.ayd = j;
    }

    public void I(long j) {
        this.aye = j;
    }

    public void J(long j) {
        this.ayr = j;
    }

    public void K(long j) {
        this.ayo = j;
    }

    public void L(long j) {
        this.ayp = j;
    }

    public void M(long j) {
        this.ayq = j;
    }

    public void N(long j) {
        this.ays = j;
    }

    public void O(long j) {
        this.ayt = j;
        this.axY = true;
    }

    public void P(long j) {
        this.ayg = j;
    }

    public void Q(long j) {
        this.ayh = j;
    }

    public void R(long j) {
        this.ayj = j;
    }

    public void S(long j) {
        this.ayi = j;
    }

    public void T(long j) {
        this.ayk = j;
    }

    public void U(long j) {
        this.ayl = j;
    }

    public void V(long j) {
        this.aym = j;
    }

    public void W(long j) {
        this.ayn = j;
    }

    public static z Ee() {
        if (ayu == null) {
            synchronized (z.class) {
                if (ayu == null) {
                    ayu = new z();
                }
            }
        }
        return ayu;
    }

    public void Ef() {
        if (this.axZ > 0) {
            if (y.DY().DZ()) {
                long j = this.aya - this.axZ;
                long j2 = this.ayr - this.axZ;
                long j3 = -1;
                if (this.ayp > 0) {
                    j3 = this.ayq - this.ayp;
                }
                long j4 = this.ayt - this.ays;
                long j5 = this.ayt - this.axZ;
                com.baidu.adp.lib.stats.d hb = hb();
                hb.q("procname", "main");
                hb.q("appc", String.valueOf(j));
                hb.q("loadclass", String.valueOf(this.ayb));
                hb.q("sapiinit", String.valueOf(this.ayc));
                hb.q("acctinit", String.valueOf(this.ayd));
                hb.q("iminit", String.valueOf(this.aye));
                hb.q("plugininit", String.valueOf(this.ayf));
                hb.q("naslibinit", String.valueOf(this.ayg));
                hb.q("websocketinit", String.valueOf(this.ayh));
                hb.q("settinginit", String.valueOf(this.ayi));
                hb.q("toastinit", String.valueOf(this.ayj));
                hb.q("tiebastaticinit", String.valueOf(this.ayk));
                hb.q("locationinit", String.valueOf(this.ayl));
                hb.q("cdninit", String.valueOf(this.aym));
                hb.q("messagesetinit", String.valueOf(this.ayn));
                hb.q("logores", String.valueOf(j2));
                if (this.ayo > 0 && this.ayp > 0 && j3 > 0) {
                    hb.q("adc", String.valueOf(this.ayo));
                    hb.q("adshow", String.valueOf(j3));
                    hb.q("hasad", "1");
                } else {
                    hb.q("hasad", "0");
                }
                hb.q("tabc", String.valueOf(j4));
                hb.q("costt", String.valueOf(j5));
                hb.q("newinst", this.axX ? "1" : "0");
                com.baidu.adp.lib.stats.a.hi().a("startt", hb);
            } else {
                return;
            }
        }
        Eg();
    }

    public void X(long j) {
        if (y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("procname", "remote");
            hb.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hi().a("startt", hb);
        }
    }

    private void Eg() {
        this.axX = false;
        this.axY = false;
        this.axZ = -1L;
        this.aya = -1L;
        this.ayb = -1L;
        this.ayc = -1L;
        this.ayd = -1L;
        this.aye = -1L;
        this.ayf = -1L;
        this.ayr = -1L;
        this.ayp = -1L;
        this.ayq = -1L;
        this.ayo = -1L;
        this.ays = -1L;
        this.ayt = -1L;
        this.ayg = -1L;
        this.ayh = -1L;
        this.ayi = -1L;
        this.ayj = -1L;
        this.ayk = -1L;
        this.ayl = -1L;
        this.aym = -1L;
        this.ayn = -1L;
    }
}
