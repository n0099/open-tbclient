package com.baidu.tbadk.n;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class n extends l {
    private static n dAx = null;
    private boolean dzX = false;
    private boolean dzY = false;
    private boolean dzZ = false;
    private boolean dAa = false;
    private long dAb = -1;
    private long dAc = -1;
    private long dAd = -1;
    private long dAe = -1;
    private long dAf = -1;
    private long dAg = -1;
    private long dAh = -1;
    private long dAi = -1;
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

    public boolean aOD() {
        return this.dzY;
    }

    public void gJ(boolean z) {
        this.dzX = z;
    }

    public void bE(long j) {
        this.dAb = j;
    }

    public long aOE() {
        return this.dAb;
    }

    public void gK(boolean z) {
        this.dAa = z;
    }

    public void bF(long j) {
        this.dAc = j;
    }

    public void bG(long j) {
        this.dAd = j;
    }

    public void bH(long j) {
        this.dAe = j;
    }

    public void bI(long j) {
        this.dAi = j;
    }

    public void bJ(long j) {
        this.dAh = j;
    }

    public void bK(long j) {
        this.dAf = j;
    }

    public void bL(long j) {
        this.dAg = j;
    }

    public void bM(long j) {
        this.dAu = j;
    }

    public void bN(long j) {
        this.dAr = j;
    }

    public void bO(long j) {
        this.dAs = j;
    }

    public void bP(long j) {
        this.dAt = j;
    }

    public void bQ(long j) {
        this.dAv = j;
    }

    public void bR(long j) {
        this.dAw = j;
        this.dzY = true;
    }

    public void bS(long j) {
        this.dAj = j;
    }

    public void bT(long j) {
        this.dAk = j;
    }

    public void bU(long j) {
        this.dAm = j;
    }

    public void bV(long j) {
        this.dAl = j;
    }

    public void bW(long j) {
        this.dAn = j;
    }

    public void bX(long j) {
        this.dAo = j;
    }

    public void bY(long j) {
        this.dAp = j;
    }

    public void bZ(long j) {
        this.dAq = j;
    }

    public static n aOF() {
        if (dAx == null) {
            synchronized (n.class) {
                if (dAx == null) {
                    dAx = new n();
                }
            }
        }
        return dAx;
    }

    public void aOG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if ((this.dAw - this.dAb) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.dzZ && m.aOA().aOB()) {
            this.dzZ = true;
            long j = this.dAc - this.dAb;
            long j2 = -1;
            if (this.dAs > 0) {
                j2 = this.dAt - this.dAs;
            }
            long j3 = this.dAw - this.dAv;
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("procname", "main");
            gt.append("appc", String.valueOf(j));
            gt.append("loadclass", String.valueOf(this.dAd));
            gt.append("sapiinit", String.valueOf(this.dAe));
            gt.append("acctinit", String.valueOf(this.dAf));
            gt.append("iminit", String.valueOf(this.dAg));
            gt.append("plugininit", String.valueOf(this.dAh));
            gt.append("patchloaded", String.valueOf(this.dAi));
            gt.append("naslibinit", String.valueOf(this.dAj));
            gt.append("websocketinit", String.valueOf(this.dAk));
            gt.append("settinginit", String.valueOf(this.dAl));
            gt.append("toastinit", String.valueOf(this.dAm));
            gt.append("tiebastaticinit", String.valueOf(this.dAn));
            gt.append("locationinit", String.valueOf(this.dAo));
            gt.append("cdninit", String.valueOf(this.dAp));
            gt.append("messagesetinit", String.valueOf(this.dAq));
            gt.append("logores", String.valueOf(this.dAu));
            if (this.dAr > 0 && this.dAs > 0 && j2 > 0) {
                gt.append("adc", String.valueOf(this.dAr));
                gt.append("adshow", String.valueOf(j2));
                gt.append("hasad", "1");
            } else {
                gt.append("hasad", "0");
            }
            gt.append("tabc", String.valueOf(j3));
            gt.append("costt", String.valueOf(this.dAu + j + j3));
            gt.append("newinst", this.dzX ? "1" : "0");
            gt.append("pluginloadsync", Boolean.valueOf(this.dAa));
            BdStatisticsManager.getInstance().performance("startt", gt);
            awq();
        }
    }

    public void ca(long j) {
        if (m.aOA().aOB() && j > 0) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("procname", "remote");
            gt.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", gt);
        }
    }

    private void awq() {
        this.dzX = false;
        this.dzY = false;
        this.dAb = -1L;
        this.dAc = -1L;
        this.dAd = -1L;
        this.dAe = -1L;
        this.dAf = -1L;
        this.dAg = -1L;
        this.dAh = -1L;
        this.dAi = -1L;
        this.dAu = -1L;
        this.dAs = -1L;
        this.dAt = -1L;
        this.dAr = -1L;
        this.dAv = -1L;
        this.dAw = -1L;
        this.dAj = -1L;
        this.dAk = -1L;
        this.dAl = -1L;
        this.dAm = -1L;
        this.dAn = -1L;
        this.dAo = -1L;
        this.dAp = -1L;
        this.dAq = -1L;
    }
}
