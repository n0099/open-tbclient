package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class n extends l {
    private static n cNl = null;
    private boolean cML = false;
    private boolean cMM = false;
    private boolean cMN = false;
    private boolean cMO = false;
    private long cMP = -1;
    private long cMQ = -1;
    private long cMR = -1;
    private long cMS = -1;
    private long cMT = -1;
    private long cMU = -1;
    private long cMV = -1;
    private long cMW = -1;
    private long cMX = -1;
    private long cMY = -1;
    private long cMZ = -1;
    private long cNa = -1;
    private long cNb = -1;
    private long cNc = -1;
    private long cNd = -1;
    private long cNe = -1;
    private long cNf = -1;
    private long cNg = -1;
    private long cNh = -1;
    private long cNi = -1;
    private long cNj = -1;
    private long cNk = -1;

    public boolean awQ() {
        return this.cMM;
    }

    public void fy(boolean z) {
        this.cML = z;
    }

    public void bd(long j) {
        this.cMP = j;
    }

    public long awR() {
        return this.cMP;
    }

    public void fz(boolean z) {
        this.cMO = z;
    }

    public void be(long j) {
        this.cMQ = j;
    }

    public void bf(long j) {
        this.cMR = j;
    }

    public void bg(long j) {
        this.cMS = j;
    }

    public void bh(long j) {
        this.cMW = j;
    }

    public void bi(long j) {
        this.cMV = j;
    }

    public void bj(long j) {
        this.cMT = j;
    }

    public void bk(long j) {
        this.cMU = j;
    }

    public void bl(long j) {
        this.cNi = j;
    }

    public void bm(long j) {
        this.cNf = j;
    }

    public void bn(long j) {
        this.cNg = j;
    }

    public void bo(long j) {
        this.cNh = j;
    }

    public void bp(long j) {
        this.cNj = j;
    }

    public void bq(long j) {
        this.cNk = j;
        this.cMM = true;
    }

    public void br(long j) {
        this.cMX = j;
    }

    public void bs(long j) {
        this.cMY = j;
    }

    public void bt(long j) {
        this.cNa = j;
    }

    public void bu(long j) {
        this.cMZ = j;
    }

    public void bv(long j) {
        this.cNb = j;
    }

    public void bw(long j) {
        this.cNc = j;
    }

    public void bx(long j) {
        this.cNd = j;
    }

    public void by(long j) {
        this.cNe = j;
    }

    public static n awS() {
        if (cNl == null) {
            synchronized (n.class) {
                if (cNl == null) {
                    cNl = new n();
                }
            }
        }
        return cNl;
    }

    public void awT() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if ((this.cNk - this.cMP) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cMN && m.awN().awO()) {
            this.cMN = true;
            long j = this.cMQ - this.cMP;
            long j2 = -1;
            if (this.cNg > 0) {
                j2 = this.cNh - this.cNg;
            }
            long j3 = this.cNk - this.cNj;
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("procname", "main");
            fU.append("appc", String.valueOf(j));
            fU.append("loadclass", String.valueOf(this.cMR));
            fU.append("sapiinit", String.valueOf(this.cMS));
            fU.append("acctinit", String.valueOf(this.cMT));
            fU.append("iminit", String.valueOf(this.cMU));
            fU.append("plugininit", String.valueOf(this.cMV));
            fU.append("patchloaded", String.valueOf(this.cMW));
            fU.append("naslibinit", String.valueOf(this.cMX));
            fU.append("websocketinit", String.valueOf(this.cMY));
            fU.append("settinginit", String.valueOf(this.cMZ));
            fU.append("toastinit", String.valueOf(this.cNa));
            fU.append("tiebastaticinit", String.valueOf(this.cNb));
            fU.append("locationinit", String.valueOf(this.cNc));
            fU.append("cdninit", String.valueOf(this.cNd));
            fU.append("messagesetinit", String.valueOf(this.cNe));
            fU.append("logores", String.valueOf(this.cNi));
            if (this.cNf > 0 && this.cNg > 0 && j2 > 0) {
                fU.append("adc", String.valueOf(this.cNf));
                fU.append("adshow", String.valueOf(j2));
                fU.append("hasad", "1");
            } else {
                fU.append("hasad", "0");
            }
            fU.append("tabc", String.valueOf(j3));
            fU.append("costt", String.valueOf(this.cNi + j + j3));
            fU.append("newinst", this.cML ? "1" : "0");
            fU.append("pluginloadsync", Boolean.valueOf(this.cMO));
            BdStatisticsManager.getInstance().performance("startt", fU);
            afA();
        }
    }

    public void bz(long j) {
        if (m.awN().awO() && j > 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("procname", "remote");
            fU.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fU);
        }
    }

    private void afA() {
        this.cML = false;
        this.cMM = false;
        this.cMP = -1L;
        this.cMQ = -1L;
        this.cMR = -1L;
        this.cMS = -1L;
        this.cMT = -1L;
        this.cMU = -1L;
        this.cMV = -1L;
        this.cMW = -1L;
        this.cNi = -1L;
        this.cNg = -1L;
        this.cNh = -1L;
        this.cNf = -1L;
        this.cNj = -1L;
        this.cNk = -1L;
        this.cMX = -1L;
        this.cMY = -1L;
        this.cMZ = -1L;
        this.cNa = -1L;
        this.cNb = -1L;
        this.cNc = -1L;
        this.cNd = -1L;
        this.cNe = -1L;
    }
}
