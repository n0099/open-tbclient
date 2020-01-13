package com.baidu.tbadk.n;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends l {
    private static n dAH = null;
    private boolean dAf = false;
    private boolean dAg = false;
    private boolean dAh = false;
    private boolean dAi = false;
    private long dAj = -1;
    private long dAk = -1;
    private long dAl = -1;
    private long dAm = -1;
    private long dAn = -1;
    private long dAo = -1;
    private long dAp = -1;
    private long dAq = -1;
    private long dAr = -1;
    private long dAs = -1;
    private long dAt = -1;
    private long dAu = -1;
    private long dAv = -1;
    private long dAw = -1;
    private long dAx = -1;
    private long dAy = -1;
    private long dAz = -1;
    private long dAA = -1;
    private long dAB = -1;
    private long dAC = -1;
    private long dAD = -1;
    private long dAE = -1;
    private long dAF = -1;
    private long dAG = -1;

    public boolean aOW() {
        return this.dAg;
    }

    public void gO(boolean z) {
        this.dAf = z;
    }

    public void bH(long j) {
        this.dAj = j;
    }

    public long aOX() {
        return this.dAj;
    }

    public void gP(boolean z) {
        this.dAi = z;
    }

    public void bI(long j) {
        this.dAk = j;
    }

    public void bJ(long j) {
        this.dAl = j;
    }

    public void bK(long j) {
        this.dAm = j;
    }

    public void bL(long j) {
        this.dAq = j;
    }

    public void bM(long j) {
        this.dAp = j;
    }

    public void bN(long j) {
        this.dAn = j;
    }

    public void bO(long j) {
        this.dAo = j;
    }

    public void bP(long j) {
        this.dAE = j;
    }

    public void bQ(long j) {
        this.dAz = j;
    }

    public void bR(long j) {
        this.dAA = j;
    }

    public void bS(long j) {
        this.dAB = j;
    }

    public void bT(long j) {
        this.dAC = j;
    }

    public void bU(long j) {
        this.dAF = j;
    }

    public void bV(long j) {
        this.dAG = j;
        this.dAg = true;
    }

    public void bW(long j) {
        this.dAr = j;
    }

    public void bX(long j) {
        this.dAs = j;
    }

    public void bY(long j) {
        this.dAu = j;
    }

    public void bZ(long j) {
        this.dAt = j;
    }

    public void ca(long j) {
        this.dAv = j;
    }

    public void cb(long j) {
        this.dAw = j;
    }

    public void cc(long j) {
        this.dAx = j;
    }

    public void cd(long j) {
        this.dAy = j;
    }

    public static n aOY() {
        if (dAH == null) {
            synchronized (n.class) {
                if (dAH == null) {
                    dAH = new n();
                }
            }
        }
        return dAH;
    }

    public void aOZ() {
        if (this.dAD > 0) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
            if ((this.dAG - this.dAj) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.dAh && m.aOT().aOU()) {
                this.dAh = true;
                long j = this.dAk - this.dAj;
                long j2 = -1;
                if (this.dAB > 0) {
                    j2 = this.dAC - this.dAB;
                }
                long j3 = this.dAG - this.dAF;
                com.baidu.adp.lib.stats.a gs = gs();
                gs.append("procname", "main");
                gs.append("appc", String.valueOf(j));
                gs.append("loadclass", String.valueOf(this.dAl));
                gs.append("sapiinit", String.valueOf(this.dAm));
                gs.append("acctinit", String.valueOf(this.dAn));
                gs.append("iminit", String.valueOf(this.dAo));
                gs.append("plugininit", String.valueOf(this.dAp));
                gs.append("patchloaded", String.valueOf(this.dAq));
                gs.append("naslibinit", String.valueOf(this.dAr));
                gs.append("websocketinit", String.valueOf(this.dAs));
                gs.append("settinginit", String.valueOf(this.dAt));
                gs.append("toastinit", String.valueOf(this.dAu));
                gs.append("tiebastaticinit", String.valueOf(this.dAv));
                gs.append("locationinit", String.valueOf(this.dAw));
                gs.append("cdninit", String.valueOf(this.dAx));
                gs.append("messagesetinit", String.valueOf(this.dAy));
                gs.append("logores", String.valueOf(this.dAE));
                if (this.dAz > 0 && this.dAB > 0 && j2 > 0) {
                    gs.append("adc", String.valueOf(this.dAz + this.dAA));
                    gs.append("adshow", String.valueOf(j2));
                    gs.append("adrequest", String.valueOf(this.dAA));
                    gs.append("hasad", "1");
                } else {
                    gs.append("hasad", "0");
                }
                gs.append("tabc", String.valueOf(j3));
                gs.append("costt", String.valueOf(j2 + this.dAz + j + this.dAA + j3 + this.dAD));
                gs.append("newcostt", String.valueOf(j + j3 + this.dAD));
                gs.append("newinst", this.dAf ? "1" : "0");
                gs.append("pluginloadsync", Boolean.valueOf(this.dAi));
                gs.append("hptotal", String.valueOf(this.dAD));
                BdStatisticsManager.getInstance().performance("startt", gs);
                awJ();
            }
        }
    }

    public void ce(long j) {
        if (m.aOT().aOU() && j > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("procname", "remote");
            gs.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gs);
        }
    }

    private void awJ() {
        this.dAf = false;
        this.dAg = false;
        this.dAj = -1L;
        this.dAk = -1L;
        this.dAl = -1L;
        this.dAm = -1L;
        this.dAn = -1L;
        this.dAo = -1L;
        this.dAp = -1L;
        this.dAq = -1L;
        this.dAE = -1L;
        this.dAB = -1L;
        this.dAC = -1L;
        this.dAz = -1L;
        this.dAF = -1L;
        this.dAG = -1L;
        this.dAr = -1L;
        this.dAs = -1L;
        this.dAt = -1L;
        this.dAu = -1L;
        this.dAv = -1L;
        this.dAw = -1L;
        this.dAx = -1L;
        this.dAy = -1L;
        this.dAA = -1L;
        this.dAD = -1L;
    }

    public void cf(long j) {
        this.dAD = j;
        if (TbadkCoreApplication.isLogin() && BdStatisticsManager.getInstance().isMainProcess()) {
            aOY().aOZ();
        }
    }
}
