package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ad extends ab {
    private static ad ahA = null;
    private boolean aho = false;
    private long ahp = -1;
    private long ahq = -1;
    private long ahr = -1;
    private long ahs = -1;
    private long aht = -1;
    private long ahu = -1;
    private long ahv = -1;
    private long ahw = -1;
    private long ahx = -1;
    private long ahy = -1;
    private long ahz = -1;

    public void aZ(boolean z) {
        this.aho = z;
    }

    public void w(long j) {
        this.ahp = j;
    }

    public void x(long j) {
        this.ahq = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.ahr = j;
        this.ahs = j2;
        this.aht = j3;
        this.ahu = j4;
    }

    public void y(long j) {
        this.ahv = j;
    }

    public void z(long j) {
        this.ahw = j;
    }

    public void A(long j) {
        this.ahx = j;
    }

    public void B(long j) {
        this.ahy = j;
    }

    public void C(long j) {
        this.ahz = j;
    }

    public static ad zw() {
        if (ahA == null) {
            synchronized (ad.class) {
                if (ahA == null) {
                    ahA = new ad();
                }
            }
        }
        return ahA;
    }

    public void zx() {
        if (this.ahp > 0) {
            if (ac.zs().zt()) {
                long j = this.ahq - this.ahp;
                long j2 = this.ahv - this.ahq;
                long j3 = this.ahx - this.ahw;
                long j4 = this.ahy - this.ahx;
                long j5 = this.ahz - this.ahy;
                long j6 = this.ahz - this.ahp;
                com.baidu.adp.lib.stats.q ed = ed();
                ed.r("procname", "main");
                ed.r("appc", String.valueOf(j));
                ed.r("loadclass", String.valueOf(this.ahr));
                ed.r("sapiinit", String.valueOf(this.ahs));
                ed.r("acctinit", String.valueOf(this.aht));
                ed.r("iminit", String.valueOf(this.ahu));
                ed.r("logores", String.valueOf(j2));
                if (this.ahw > 0 && j3 > 0 && this.ahx > 0 && j4 > 0) {
                    ed.r("adc", String.valueOf(j3));
                    ed.r("adshow", String.valueOf(j4));
                    ed.r("hasad", "1");
                } else {
                    ed.r("hasad", "0");
                }
                ed.r("tabc", String.valueOf(j5));
                ed.r("costt", String.valueOf(j6));
                ed.r("newinst", this.aho ? "1" : "0");
                com.baidu.adp.lib.stats.f.eq().b("startt", ed);
            } else {
                return;
            }
        }
        zy();
    }

    public void D(long j) {
        if (ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("procname", "remote");
            ed.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.eq().b("startt", ed);
        }
    }

    private void zy() {
        this.aho = false;
        this.ahp = -1L;
        this.ahq = -1L;
        this.ahr = -1L;
        this.ahs = -1L;
        this.aht = -1L;
        this.ahu = -1L;
        this.ahv = -1L;
        this.ahw = -1L;
        this.ahx = -1L;
        this.ahy = -1L;
        this.ahz = -1L;
    }
}
