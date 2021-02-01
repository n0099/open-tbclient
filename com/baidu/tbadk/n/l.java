package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l extends j {
    private static l fKE = null;
    private boolean fJX = false;
    private boolean fJY = false;
    private boolean fJZ = false;
    private boolean fKa = false;
    private long fKb = -1;
    private long fKc = -1;
    private long fKd = -1;
    private long fKe = -1;
    private long fKf = -1;
    private long fKg = -1;
    private long fKh = -1;
    private long fKi = -1;
    private long fKj = -1;
    private long fKk = -1;
    private long fKl = -1;
    private long fKm = -1;
    private long fKn = -1;
    private long fKo = -1;
    private long fKp = -1;
    private long fKq = -1;
    private long fKr = -1;
    private long fKs = -1;
    private long fKt = -1;
    private long fKu = -1;
    private long fKv = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fKw = -1;
    private long fKx = -1;
    private long fKy = -1;
    private long fKz = -1;
    private long fKA = -1;
    private long fKB = -1;
    private long fKC = -1;
    private long fKD = -1;

    public boolean bEj() {
        return this.fJY;
    }

    public void lo(boolean z) {
        this.fJX = z;
    }

    public void em(long j) {
        this.fKb = j;
    }

    public long bEk() {
        return this.fKb;
    }

    public void lp(boolean z) {
        this.fKa = z;
    }

    public void en(long j) {
        this.fKc = j;
    }

    public void eo(long j) {
        this.fKd = j;
    }

    public void ep(long j) {
        this.fKe = j;
    }

    public void eq(long j) {
        this.fKi = j;
    }

    public void er(long j) {
        this.fKh = j;
    }

    public void es(long j) {
        this.fKf = j;
    }

    public void et(long j) {
        this.fKg = j;
    }

    public void eu(long j) {
        this.fKB = j;
    }

    public void ev(long j) {
        this.fKr = j;
    }

    public void ew(long j) {
        this.fKs = j;
    }

    public void ex(long j) {
        this.fKt = j;
    }

    public void ey(long j) {
        this.fKu = j;
    }

    public void ez(long j) {
        this.fKC = j;
    }

    public void eA(long j) {
        this.fKD = j;
        this.fJY = true;
    }

    public void eB(long j) {
        this.fKj = j;
    }

    public void eC(long j) {
        this.fKk = j;
    }

    public void eD(long j) {
        this.fKm = j;
    }

    public void eE(long j) {
        this.fKl = j;
    }

    public void eF(long j) {
        this.fKn = j;
    }

    public void eG(long j) {
        this.fKo = j;
    }

    public void eH(long j) {
        this.fKp = j;
    }

    public void eI(long j) {
        this.fKq = j;
    }

    public static l bEl() {
        if (fKE == null) {
            synchronized (l.class) {
                if (fKE == null) {
                    fKE = new l();
                }
            }
        }
        return fKE;
    }

    public void bEm() {
        long j = 0;
        if (this.fKD - this.fKb > 0 && !this.fJZ && this.fKv > 0 && k.bEg().isSmallFlow()) {
            long j2 = this.fKc - this.fKb;
            long j3 = -1;
            if (this.fKt > 0) {
                j3 = this.fKu - this.fKt;
            }
            this.fJZ = true;
            long j4 = this.fKD - this.fKC;
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("procname", "main");
            pg.append("appc", String.valueOf(j2));
            pg.append("loadclass", String.valueOf(this.fKd));
            pg.append("sapiinit", String.valueOf(this.fKe));
            pg.append("acctinit", String.valueOf(this.fKz));
            pg.append("iminit", String.valueOf(this.fKx));
            pg.append("plugininit", String.valueOf(this.fKy));
            pg.append("patchloaded", String.valueOf(this.fKi));
            pg.append("naslibinit", String.valueOf(this.fKj));
            pg.append("websocketinit", String.valueOf(this.fKk));
            pg.append("settinginit", String.valueOf(this.fKl));
            pg.append("toastinit", String.valueOf(this.fKm));
            pg.append("tiebastaticinit", String.valueOf(this.fKn));
            pg.append("cdninit", String.valueOf(this.fKp));
            pg.append("messagesetinit", String.valueOf(this.fKq));
            pg.append("logores", String.valueOf(this.fKB));
            pg.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eXw ? 1 : 0));
            if (this.fKr > 0 && this.fKt > 0 && j3 > 0) {
                pg.append("adc", String.valueOf(this.fKr + this.fKs));
                pg.append("adshow", String.valueOf(j3));
                pg.append("adrequest", String.valueOf(this.fKs));
                j = this.fKr + this.fKs + j3;
                pg.append("hasad", "1");
            } else {
                pg.append("hasad", "0");
                if (this.fKs > 0) {
                    j = this.fKs;
                }
            }
            pg.append("tabc", String.valueOf(j4));
            pg.append("costt", String.valueOf(this.totalTime - j));
            pg.append("newinst", this.fJX ? "1" : "0");
            pg.append("pluginloadsync", Boolean.valueOf(this.fKa));
            pg.append("hptotal", String.valueOf(this.fKv));
            pg.append("locationinit", String.valueOf(j3 + j2 + this.fKB + this.fKr + this.fKs + j4 + this.fKv));
            pg.append("userperceptiont", String.valueOf(this.fKw - j));
            BdStatisticsManager.getInstance().performance("startt", pg);
            bkm();
        }
    }

    public void eJ(long j) {
        if (k.bEg().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("procname", "remote");
            pg.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", pg);
        }
    }

    private void bkm() {
        this.fJX = false;
        this.fJY = false;
        this.fKb = -1L;
        this.fKc = -1L;
        this.totalTime = -1L;
        this.fKd = -1L;
        this.fKe = -1L;
        this.fKf = -1L;
        this.fKg = -1L;
        this.fKh = -1L;
        this.fKi = -1L;
        this.fKB = -1L;
        this.fKt = -1L;
        this.fKu = -1L;
        this.fKr = -1L;
        this.fKC = -1L;
        this.fKD = -1L;
        this.fKj = -1L;
        this.fKk = -1L;
        this.fKl = -1L;
        this.fKm = -1L;
        this.fKn = -1L;
        this.fKo = -1L;
        this.fKp = -1L;
        this.fKq = -1L;
        this.fKs = -1L;
        this.startTime = -1L;
        this.fKv = -1L;
        this.fKw = -1L;
        this.fKx = -1L;
        this.fKy = -1L;
        this.fKz = -1L;
        this.fKA = -1L;
    }

    public void eK(long j) {
        if (this.fKv <= 0) {
            this.fKv = j;
            this.totalTime = System.currentTimeMillis() - this.fKb;
        }
    }

    public long bEn() {
        return this.totalTime;
    }

    public void eL(long j) {
        this.fKw = j;
    }

    public void eM(long j) {
        this.fKx = j;
    }

    public void eN(long j) {
        if (this.fKy <= 0) {
            this.fKy = j;
        }
    }

    public void eO(long j) {
        this.fKz = j;
    }

    public void eP(long j) {
        this.fKA = j - this.fKD;
    }
}
