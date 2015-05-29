package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class ai extends ag {
    private static ai arp = null;
    private boolean arc = false;
    private boolean ard = false;
    private long are = -1;
    private long arf = -1;
    private long arg = -1;
    private long arh = -1;
    private long ari = -1;
    private long arj = -1;
    private long ark = -1;
    private long arl = -1;
    private long arm = -1;
    private long arn = -1;
    private long aro = -1;

    public boolean DG() {
        return this.ard;
    }

    public void bl(boolean z) {
        this.arc = z;
    }

    public void y(long j) {
        this.are = j;
    }

    public void z(long j) {
        this.arf = j;
    }

    public void a(long j, long j2, long j3, long j4) {
        this.arg = j;
        this.arh = j2;
        this.ari = j3;
        this.arj = j4;
    }

    public void A(long j) {
        this.ark = j;
    }

    public void B(long j) {
        this.arn = j;
    }

    public void C(long j) {
        this.aro = j;
        this.ard = true;
    }

    public static ai DH() {
        if (arp == null) {
            synchronized (ai.class) {
                if (arp == null) {
                    arp = new ai();
                }
            }
        }
        return arp;
    }

    public void DI() {
        if (this.are > 0) {
            if (ah.DB().DC()) {
                long j = this.arf - this.are;
                long j2 = this.ark - this.arf;
                long j3 = this.arm - this.arl;
                long j4 = this.arn - this.arm;
                long j5 = this.aro - this.arn;
                long j6 = this.aro - this.are;
                com.baidu.adp.lib.stats.q hm = hm();
                hm.r("procname", "main");
                hm.r("appc", String.valueOf(j));
                hm.r("loadclass", String.valueOf(this.arg));
                hm.r("sapiinit", String.valueOf(this.arh));
                hm.r("acctinit", String.valueOf(this.ari));
                hm.r("iminit", String.valueOf(this.arj));
                hm.r("logores", String.valueOf(j2));
                if (this.arl > 0 && j3 > 0 && this.arm > 0 && j4 > 0) {
                    hm.r("adc", String.valueOf(j3));
                    hm.r("adshow", String.valueOf(j4));
                    hm.r("hasad", "1");
                } else {
                    hm.r("hasad", GameInfoData.NOT_FROM_DETAIL);
                }
                hm.r("tabc", String.valueOf(j5));
                hm.r("costt", String.valueOf(j6));
                hm.r("newinst", this.arc ? "1" : GameInfoData.NOT_FROM_DETAIL);
                com.baidu.adp.lib.stats.f.hz().a("startt", -1L, (String) null, hm);
            } else {
                return;
            }
        }
        DJ();
    }

    public void D(long j) {
        if (ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("procname", "remote");
            hm.r("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.hz().a("startt", -1L, (String) null, hm);
        }
    }

    private void DJ() {
        this.arc = false;
        this.ard = false;
        this.are = -1L;
        this.arf = -1L;
        this.arg = -1L;
        this.arh = -1L;
        this.ari = -1L;
        this.arj = -1L;
        this.ark = -1L;
        this.arl = -1L;
        this.arm = -1L;
        this.arn = -1L;
        this.aro = -1L;
    }
}
