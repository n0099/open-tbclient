package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ad extends ab {
    private static ad ahf = null;
    private boolean agT = false;
    private long agU = -1;
    private long agV = -1;
    private long agW = -1;
    private long agX = -1;
    private long agY = -1;
    private long agZ = -1;
    private long aha = -1;
    private long ahb = -1;
    private long ahc = -1;
    private long ahd = -1;
    private long ahe = -1;

    public void aX(boolean z) {
        this.agT = z;
    }

    public void w(long j) {
        this.agU = j;
    }

    public void x(long j) {
        this.agV = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.agW = j;
        this.agX = j2;
        this.agY = j3;
        this.agZ = j4;
    }

    public void y(long j) {
        this.aha = j;
    }

    public void z(long j) {
        this.ahb = j;
    }

    public void A(long j) {
        this.ahc = j;
    }

    public void B(long j) {
        this.ahd = j;
    }

    public void C(long j) {
        this.ahe = j;
    }

    public static ad zl() {
        if (ahf == null) {
            synchronized (ad.class) {
                if (ahf == null) {
                    ahf = new ad();
                }
            }
        }
        return ahf;
    }

    public void zm() {
        if (this.agU > 0) {
            if (ac.zh().zi()) {
                long j = this.agV - this.agU;
                long j2 = this.aha - this.agV;
                long j3 = this.ahc - this.ahb;
                long j4 = this.ahd - this.ahc;
                long j5 = this.ahe - this.ahd;
                long j6 = this.ahe - this.agU;
                com.baidu.adp.lib.stats.q ef = ef();
                ef.r("procname", "main");
                ef.r("appc", String.valueOf(j));
                ef.r("loadclass", String.valueOf(this.agW));
                ef.r("sapiinit", String.valueOf(this.agX));
                ef.r("acctinit", String.valueOf(this.agY));
                ef.r("iminit", String.valueOf(this.agZ));
                ef.r("logores", String.valueOf(j2));
                if (this.ahb > 0 && j3 > 0 && this.ahc > 0 && j4 > 0) {
                    ef.r("adc", String.valueOf(j3));
                    ef.r("adshow", String.valueOf(j4));
                    ef.r("hasad", "1");
                } else {
                    ef.r("hasad", "0");
                }
                ef.r("tabc", String.valueOf(j5));
                ef.r("costt", String.valueOf(j6));
                ef.r("newinst", this.agT ? "1" : "0");
                com.baidu.adp.lib.stats.f.es().b("startt", ef);
            } else {
                return;
            }
        }
        zn();
    }

    public void D(long j) {
        if (ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("procname", "remote");
            ef.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.es().b("startt", ef);
        }
    }

    private void zn() {
        this.agT = false;
        this.agU = -1L;
        this.agV = -1L;
        this.agW = -1L;
        this.agX = -1L;
        this.agY = -1L;
        this.agZ = -1L;
        this.aha = -1L;
        this.ahb = -1L;
        this.ahc = -1L;
        this.ahd = -1L;
        this.ahe = -1L;
    }
}
