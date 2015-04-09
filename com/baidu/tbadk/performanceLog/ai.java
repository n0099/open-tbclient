package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class ai extends ag {
    private static ai aqn = null;
    private boolean aqa = false;
    private boolean aqb = false;
    private long aqc = -1;
    private long aqd = -1;
    private long aqe = -1;
    private long aqf = -1;
    private long aqg = -1;
    private long aqh = -1;
    private long aqi = -1;
    private long aqj = -1;
    private long aqk = -1;
    private long aql = -1;
    private long aqm = -1;

    public boolean CV() {
        return this.aqb;
    }

    public void be(boolean z) {
        this.aqa = z;
    }

    public void w(long j) {
        this.aqc = j;
    }

    public void x(long j) {
        this.aqd = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.aqe = j;
        this.aqf = j2;
        this.aqg = j3;
        this.aqh = j4;
    }

    public void y(long j) {
        this.aqi = j;
    }

    public void z(long j) {
        this.aqj = j;
    }

    public void A(long j) {
        this.aqk = j;
    }

    public void B(long j) {
        this.aql = j;
    }

    public void C(long j) {
        this.aqm = j;
        this.aqb = true;
    }

    public static ai CW() {
        if (aqn == null) {
            synchronized (ai.class) {
                if (aqn == null) {
                    aqn = new ai();
                }
            }
        }
        return aqn;
    }

    public void CX() {
        if (this.aqc > 0) {
            if (ah.CQ().CR()) {
                long j = this.aqd - this.aqc;
                long j2 = this.aqi - this.aqd;
                long j3 = this.aqk - this.aqj;
                long j4 = this.aql - this.aqk;
                long j5 = this.aqm - this.aql;
                long j6 = this.aqm - this.aqc;
                com.baidu.adp.lib.stats.q hC = hC();
                hC.r("procname", "main");
                hC.r("appc", String.valueOf(j));
                hC.r("loadclass", String.valueOf(this.aqe));
                hC.r("sapiinit", String.valueOf(this.aqf));
                hC.r("acctinit", String.valueOf(this.aqg));
                hC.r("iminit", String.valueOf(this.aqh));
                hC.r("logores", String.valueOf(j2));
                if (this.aqj > 0 && j3 > 0 && this.aqk > 0 && j4 > 0) {
                    hC.r("adc", String.valueOf(j3));
                    hC.r("adshow", String.valueOf(j4));
                    hC.r("hasad", "1");
                } else {
                    hC.r("hasad", GameInfoData.NOT_FROM_DETAIL);
                }
                hC.r("tabc", String.valueOf(j5));
                hC.r("costt", String.valueOf(j6));
                hC.r("newinst", this.aqa ? "1" : GameInfoData.NOT_FROM_DETAIL);
                com.baidu.adp.lib.stats.f.hP().b("startt", hC);
            } else {
                return;
            }
        }
        CY();
    }

    public void D(long j) {
        if (ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("procname", "remote");
            hC.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.hP().b("startt", hC);
        }
    }

    private void CY() {
        this.aqa = false;
        this.aqb = false;
        this.aqc = -1L;
        this.aqd = -1L;
        this.aqe = -1L;
        this.aqf = -1L;
        this.aqg = -1L;
        this.aqh = -1L;
        this.aqi = -1L;
        this.aqj = -1L;
        this.aqk = -1L;
        this.aql = -1L;
        this.aqm = -1L;
    }
}
