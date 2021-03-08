package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l extends j {
    private static l fMe = null;
    private boolean fLx = false;
    private boolean fLy = false;
    private boolean fLz = false;
    private boolean fLA = false;
    private long fLB = -1;
    private long fLC = -1;
    private long fLD = -1;
    private long fLE = -1;
    private long fLF = -1;
    private long fLG = -1;
    private long fLH = -1;
    private long fLI = -1;
    private long fLJ = -1;
    private long fLK = -1;
    private long fLL = -1;
    private long fLM = -1;
    private long fLN = -1;
    private long fLO = -1;
    private long fLP = -1;
    private long fLQ = -1;
    private long fLR = -1;
    private long fLS = -1;
    private long fLT = -1;
    private long fLU = -1;
    private long fLV = -1;
    private long totalTime = -1;
    private long startTime = -1;
    private long fLW = -1;
    private long fLX = -1;
    private long fLY = -1;
    private long fLZ = -1;
    private long fMa = -1;
    private long fMb = -1;
    private long fMc = -1;
    private long fMd = -1;

    public boolean bEn() {
        return this.fLy;
    }

    public void lo(boolean z) {
        this.fLx = z;
    }

    public void em(long j) {
        this.fLB = j;
    }

    public long bEo() {
        return this.fLB;
    }

    public void lp(boolean z) {
        this.fLA = z;
    }

    public void en(long j) {
        this.fLC = j;
    }

    public void eo(long j) {
        this.fLD = j;
    }

    public void ep(long j) {
        this.fLE = j;
    }

    public void eq(long j) {
        this.fLI = j;
    }

    public void er(long j) {
        this.fLH = j;
    }

    public void es(long j) {
        this.fLF = j;
    }

    public void et(long j) {
        this.fLG = j;
    }

    public void eu(long j) {
        this.fMb = j;
    }

    public void ev(long j) {
        this.fLR = j;
    }

    public void ew(long j) {
        this.fLS = j;
    }

    public void ex(long j) {
        this.fLT = j;
    }

    public void ey(long j) {
        this.fLU = j;
    }

    public void ez(long j) {
        this.fMc = j;
    }

    public void eA(long j) {
        this.fMd = j;
        this.fLy = true;
    }

    public void eB(long j) {
        this.fLJ = j;
    }

    public void eC(long j) {
        this.fLK = j;
    }

    public void eD(long j) {
        this.fLM = j;
    }

    public void eE(long j) {
        this.fLL = j;
    }

    public void eF(long j) {
        this.fLN = j;
    }

    public void eG(long j) {
        this.fLO = j;
    }

    public void eH(long j) {
        this.fLP = j;
    }

    public void eI(long j) {
        this.fLQ = j;
    }

    public static l bEp() {
        if (fMe == null) {
            synchronized (l.class) {
                if (fMe == null) {
                    fMe = new l();
                }
            }
        }
        return fMe;
    }

    public void bEq() {
        long j = 0;
        if (this.fMd - this.fLB > 0 && !this.fLz && this.fLV > 0 && k.bEk().isSmallFlow()) {
            long j2 = this.fLC - this.fLB;
            long j3 = -1;
            if (this.fLT > 0) {
                j3 = this.fLU - this.fLT;
            }
            this.fLz = true;
            long j4 = this.fMd - this.fMc;
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("procname", "main");
            pg.append("appc", String.valueOf(j2));
            pg.append("loadclass", String.valueOf(this.fLD));
            pg.append("sapiinit", String.valueOf(this.fLE));
            pg.append("acctinit", String.valueOf(this.fLZ));
            pg.append("iminit", String.valueOf(this.fLX));
            pg.append("plugininit", String.valueOf(this.fLY));
            pg.append("patchloaded", String.valueOf(this.fLI));
            pg.append("naslibinit", String.valueOf(this.fLJ));
            pg.append("websocketinit", String.valueOf(this.fLK));
            pg.append("settinginit", String.valueOf(this.fLL));
            pg.append("toastinit", String.valueOf(this.fLM));
            pg.append("tiebastaticinit", String.valueOf(this.fLN));
            pg.append("cdninit", String.valueOf(this.fLP));
            pg.append("messagesetinit", String.valueOf(this.fLQ));
            pg.append("logores", String.valueOf(this.fMb));
            pg.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eYV ? 1 : 0));
            if (this.fLR > 0 && this.fLT > 0 && j3 > 0) {
                pg.append("adc", String.valueOf(this.fLR + this.fLS));
                pg.append("adshow", String.valueOf(j3));
                pg.append("adrequest", String.valueOf(this.fLS));
                j = this.fLR + this.fLS + j3;
                pg.append("hasad", "1");
            } else {
                pg.append("hasad", "0");
                if (this.fLS > 0) {
                    j = this.fLS;
                }
            }
            pg.append("tabc", String.valueOf(j4));
            pg.append("costt", String.valueOf(this.totalTime - j));
            pg.append("newinst", this.fLx ? "1" : "0");
            pg.append("pluginloadsync", Boolean.valueOf(this.fLA));
            pg.append("hptotal", String.valueOf(this.fLV));
            pg.append("locationinit", String.valueOf(j3 + j2 + this.fMb + this.fLR + this.fLS + j4 + this.fLV));
            pg.append("userperceptiont", String.valueOf(this.fLW - j));
            BdStatisticsManager.getInstance().performance("startt", pg);
            bko();
        }
    }

    public void eJ(long j) {
        if (k.bEk().isSmallFlow() && j > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("procname", "remote");
            pg.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", pg);
        }
    }

    private void bko() {
        this.fLx = false;
        this.fLy = false;
        this.fLB = -1L;
        this.fLC = -1L;
        this.totalTime = -1L;
        this.fLD = -1L;
        this.fLE = -1L;
        this.fLF = -1L;
        this.fLG = -1L;
        this.fLH = -1L;
        this.fLI = -1L;
        this.fMb = -1L;
        this.fLT = -1L;
        this.fLU = -1L;
        this.fLR = -1L;
        this.fMc = -1L;
        this.fMd = -1L;
        this.fLJ = -1L;
        this.fLK = -1L;
        this.fLL = -1L;
        this.fLM = -1L;
        this.fLN = -1L;
        this.fLO = -1L;
        this.fLP = -1L;
        this.fLQ = -1L;
        this.fLS = -1L;
        this.startTime = -1L;
        this.fLV = -1L;
        this.fLW = -1L;
        this.fLX = -1L;
        this.fLY = -1L;
        this.fLZ = -1L;
        this.fMa = -1L;
    }

    public void eK(long j) {
        if (this.fLV <= 0) {
            this.fLV = j;
            this.totalTime = System.currentTimeMillis() - this.fLB;
        }
    }

    public long bEr() {
        return this.totalTime;
    }

    public void eL(long j) {
        this.fLW = j;
    }

    public void eM(long j) {
        this.fLX = j;
    }

    public void eN(long j) {
        if (this.fLY <= 0) {
            this.fLY = j;
        }
    }

    public void eO(long j) {
        this.fLZ = j;
    }

    public void eP(long j) {
        this.fMa = j - this.fMd;
    }
}
