package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ad extends ab {
    private static ad ahD = null;
    private boolean ahr = false;
    private long ahs = -1;
    private long aht = -1;
    private long ahu = -1;
    private long ahv = -1;
    private long ahw = -1;
    private long ahx = -1;
    private long ahy = -1;
    private long ahz = -1;
    private long ahA = -1;
    private long ahB = -1;
    private long ahC = -1;

    public void aZ(boolean z) {
        this.ahr = z;
    }

    public void w(long j) {
        this.ahs = j;
    }

    public void x(long j) {
        this.aht = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.ahu = j;
        this.ahv = j2;
        this.ahw = j3;
        this.ahx = j4;
    }

    public void y(long j) {
        this.ahy = j;
    }

    public void z(long j) {
        this.ahz = j;
    }

    public void A(long j) {
        this.ahA = j;
    }

    public void B(long j) {
        this.ahB = j;
    }

    public void C(long j) {
        this.ahC = j;
    }

    public static ad zC() {
        if (ahD == null) {
            synchronized (ad.class) {
                if (ahD == null) {
                    ahD = new ad();
                }
            }
        }
        return ahD;
    }

    public void zD() {
        if (this.ahs > 0) {
            if (ac.zy().zz()) {
                long j = this.aht - this.ahs;
                long j2 = this.ahy - this.aht;
                long j3 = this.ahA - this.ahz;
                long j4 = this.ahB - this.ahA;
                long j5 = this.ahC - this.ahB;
                long j6 = this.ahC - this.ahs;
                com.baidu.adp.lib.stats.q ed = ed();
                ed.r("procname", "main");
                ed.r("appc", String.valueOf(j));
                ed.r("loadclass", String.valueOf(this.ahu));
                ed.r("sapiinit", String.valueOf(this.ahv));
                ed.r("acctinit", String.valueOf(this.ahw));
                ed.r("iminit", String.valueOf(this.ahx));
                ed.r("logores", String.valueOf(j2));
                if (this.ahz > 0 && j3 > 0 && this.ahA > 0 && j4 > 0) {
                    ed.r("adc", String.valueOf(j3));
                    ed.r("adshow", String.valueOf(j4));
                    ed.r("hasad", "1");
                } else {
                    ed.r("hasad", "0");
                }
                ed.r("tabc", String.valueOf(j5));
                ed.r("costt", String.valueOf(j6));
                ed.r("newinst", this.ahr ? "1" : "0");
                com.baidu.adp.lib.stats.f.eq().b("startt", ed);
            } else {
                return;
            }
        }
        zE();
    }

    public void D(long j) {
        if (ac.zy().zz()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("procname", "remote");
            ed.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.eq().b("startt", ed);
        }
    }

    private void zE() {
        this.ahr = false;
        this.ahs = -1L;
        this.aht = -1L;
        this.ahu = -1L;
        this.ahv = -1L;
        this.ahw = -1L;
        this.ahx = -1L;
        this.ahy = -1L;
        this.ahz = -1L;
        this.ahA = -1L;
        this.ahB = -1L;
        this.ahC = -1L;
    }
}
