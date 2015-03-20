package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class ai extends ag {
    private static ai aqf = null;
    private boolean apS = false;
    private boolean apT = false;
    private long apU = -1;
    private long apV = -1;
    private long apW = -1;
    private long apX = -1;
    private long apY = -1;
    private long apZ = -1;
    private long aqa = -1;
    private long aqb = -1;
    private long aqc = -1;
    private long aqd = -1;
    private long aqe = -1;

    public boolean CP() {
        return this.apT;
    }

    public void be(boolean z) {
        this.apS = z;
    }

    public void w(long j) {
        this.apU = j;
    }

    public void x(long j) {
        this.apV = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.apW = j;
        this.apX = j2;
        this.apY = j3;
        this.apZ = j4;
    }

    public void y(long j) {
        this.aqa = j;
    }

    public void z(long j) {
        this.aqb = j;
    }

    public void A(long j) {
        this.aqc = j;
    }

    public void B(long j) {
        this.aqd = j;
    }

    public void C(long j) {
        this.aqe = j;
        this.apT = true;
    }

    public static ai CQ() {
        if (aqf == null) {
            synchronized (ai.class) {
                if (aqf == null) {
                    aqf = new ai();
                }
            }
        }
        return aqf;
    }

    public void CR() {
        if (this.apU > 0) {
            if (ah.CK().CL()) {
                long j = this.apV - this.apU;
                long j2 = this.aqa - this.apV;
                long j3 = this.aqc - this.aqb;
                long j4 = this.aqd - this.aqc;
                long j5 = this.aqe - this.aqd;
                long j6 = this.aqe - this.apU;
                com.baidu.adp.lib.stats.q hC = hC();
                hC.r("procname", "main");
                hC.r("appc", String.valueOf(j));
                hC.r("loadclass", String.valueOf(this.apW));
                hC.r("sapiinit", String.valueOf(this.apX));
                hC.r("acctinit", String.valueOf(this.apY));
                hC.r("iminit", String.valueOf(this.apZ));
                hC.r("logores", String.valueOf(j2));
                if (this.aqb > 0 && j3 > 0 && this.aqc > 0 && j4 > 0) {
                    hC.r("adc", String.valueOf(j3));
                    hC.r("adshow", String.valueOf(j4));
                    hC.r("hasad", "1");
                } else {
                    hC.r("hasad", GameInfoData.NOT_FROM_DETAIL);
                }
                hC.r("tabc", String.valueOf(j5));
                hC.r("costt", String.valueOf(j6));
                hC.r("newinst", this.apS ? "1" : GameInfoData.NOT_FROM_DETAIL);
                com.baidu.adp.lib.stats.f.hP().b("startt", hC);
            } else {
                return;
            }
        }
        CS();
    }

    public void D(long j) {
        if (ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("procname", "remote");
            hC.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.hP().b("startt", hC);
        }
    }

    private void CS() {
        this.apS = false;
        this.apT = false;
        this.apU = -1L;
        this.apV = -1L;
        this.apW = -1L;
        this.apX = -1L;
        this.apY = -1L;
        this.apZ = -1L;
        this.aqa = -1L;
        this.aqb = -1L;
        this.aqc = -1L;
        this.aqd = -1L;
        this.aqe = -1L;
    }
}
