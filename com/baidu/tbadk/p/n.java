package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class n extends l {
    private static n cMu = null;
    private boolean cLU = false;
    private boolean cLV = false;
    private boolean cLW = false;
    private boolean cLX = false;
    private long cLY = -1;
    private long cLZ = -1;
    private long cMa = -1;
    private long cMb = -1;
    private long cMc = -1;
    private long cMd = -1;
    private long cMe = -1;
    private long cMf = -1;
    private long cMg = -1;
    private long cMh = -1;
    private long cMi = -1;
    private long cMj = -1;
    private long cMk = -1;
    private long cMl = -1;
    private long cMm = -1;
    private long cMn = -1;
    private long cMo = -1;
    private long cMp = -1;
    private long cMq = -1;
    private long cMr = -1;
    private long cMs = -1;
    private long cMt = -1;

    public boolean awO() {
        return this.cLV;
    }

    public void fy(boolean z) {
        this.cLU = z;
    }

    public void bc(long j) {
        this.cLY = j;
    }

    public long awP() {
        return this.cLY;
    }

    public void fz(boolean z) {
        this.cLX = z;
    }

    public void bd(long j) {
        this.cLZ = j;
    }

    public void be(long j) {
        this.cMa = j;
    }

    public void bf(long j) {
        this.cMb = j;
    }

    public void bg(long j) {
        this.cMf = j;
    }

    public void bh(long j) {
        this.cMe = j;
    }

    public void bi(long j) {
        this.cMc = j;
    }

    public void bj(long j) {
        this.cMd = j;
    }

    public void bk(long j) {
        this.cMr = j;
    }

    public void bl(long j) {
        this.cMo = j;
    }

    public void bm(long j) {
        this.cMp = j;
    }

    public void bn(long j) {
        this.cMq = j;
    }

    public void bo(long j) {
        this.cMs = j;
    }

    public void bp(long j) {
        this.cMt = j;
        this.cLV = true;
    }

    public void bq(long j) {
        this.cMg = j;
    }

    public void br(long j) {
        this.cMh = j;
    }

    public void bs(long j) {
        this.cMj = j;
    }

    public void bt(long j) {
        this.cMi = j;
    }

    public void bu(long j) {
        this.cMk = j;
    }

    public void bv(long j) {
        this.cMl = j;
    }

    public void bw(long j) {
        this.cMm = j;
    }

    public void bx(long j) {
        this.cMn = j;
    }

    public static n awQ() {
        if (cMu == null) {
            synchronized (n.class) {
                if (cMu == null) {
                    cMu = new n();
                }
            }
        }
        return cMu;
    }

    public void awR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if ((this.cMt - this.cLY) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cLW && m.awL().awM()) {
            this.cLW = true;
            long j = this.cLZ - this.cLY;
            long j2 = -1;
            if (this.cMp > 0) {
                j2 = this.cMq - this.cMp;
            }
            long j3 = this.cMt - this.cMs;
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("procname", "main");
            fU.append("appc", String.valueOf(j));
            fU.append("loadclass", String.valueOf(this.cMa));
            fU.append("sapiinit", String.valueOf(this.cMb));
            fU.append("acctinit", String.valueOf(this.cMc));
            fU.append("iminit", String.valueOf(this.cMd));
            fU.append("plugininit", String.valueOf(this.cMe));
            fU.append("patchloaded", String.valueOf(this.cMf));
            fU.append("naslibinit", String.valueOf(this.cMg));
            fU.append("websocketinit", String.valueOf(this.cMh));
            fU.append("settinginit", String.valueOf(this.cMi));
            fU.append("toastinit", String.valueOf(this.cMj));
            fU.append("tiebastaticinit", String.valueOf(this.cMk));
            fU.append("locationinit", String.valueOf(this.cMl));
            fU.append("cdninit", String.valueOf(this.cMm));
            fU.append("messagesetinit", String.valueOf(this.cMn));
            fU.append("logores", String.valueOf(this.cMr));
            if (this.cMo > 0 && this.cMp > 0 && j2 > 0) {
                fU.append("adc", String.valueOf(this.cMo));
                fU.append("adshow", String.valueOf(j2));
                fU.append("hasad", "1");
            } else {
                fU.append("hasad", "0");
            }
            fU.append("tabc", String.valueOf(j3));
            fU.append("costt", String.valueOf(this.cMr + j + j3));
            fU.append("newinst", this.cLU ? "1" : "0");
            fU.append("pluginloadsync", Boolean.valueOf(this.cLX));
            BdStatisticsManager.getInstance().performance("startt", fU);
            afy();
        }
    }

    public void by(long j) {
        if (m.awL().awM() && j > 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("procname", "remote");
            fU.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fU);
        }
    }

    private void afy() {
        this.cLU = false;
        this.cLV = false;
        this.cLY = -1L;
        this.cLZ = -1L;
        this.cMa = -1L;
        this.cMb = -1L;
        this.cMc = -1L;
        this.cMd = -1L;
        this.cMe = -1L;
        this.cMf = -1L;
        this.cMr = -1L;
        this.cMp = -1L;
        this.cMq = -1L;
        this.cMo = -1L;
        this.cMs = -1L;
        this.cMt = -1L;
        this.cMg = -1L;
        this.cMh = -1L;
        this.cMi = -1L;
        this.cMj = -1L;
        this.cMk = -1L;
        this.cMl = -1L;
        this.cMm = -1L;
        this.cMn = -1L;
    }
}
