package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n cAZ = null;
    private boolean cAz = false;
    private boolean cAA = false;
    private boolean cAB = false;
    private boolean cAC = false;
    private long cAD = -1;
    private long cAE = -1;
    private long cAF = -1;
    private long cAG = -1;
    private long cAH = -1;
    private long cAI = -1;
    private long cAJ = -1;
    private long cAK = -1;
    private long cAL = -1;
    private long cAM = -1;
    private long cAN = -1;
    private long cAO = -1;
    private long cAP = -1;
    private long cAQ = -1;
    private long cAR = -1;
    private long cAS = -1;
    private long cAT = -1;
    private long cAU = -1;
    private long cAV = -1;
    private long cAW = -1;
    private long cAX = -1;
    private long cAY = -1;

    public boolean avx() {
        return this.cAA;
    }

    public void fG(boolean z) {
        this.cAz = z;
    }

    public void bl(long j) {
        this.cAD = j;
    }

    public long avy() {
        return this.cAD;
    }

    public void fH(boolean z) {
        this.cAC = z;
    }

    public void bm(long j) {
        this.cAE = j;
    }

    public void bn(long j) {
        this.cAF = j;
    }

    public void bo(long j) {
        this.cAG = j;
    }

    public void bp(long j) {
        this.cAK = j;
    }

    public void bq(long j) {
        this.cAJ = j;
    }

    public void br(long j) {
        this.cAH = j;
    }

    public void bs(long j) {
        this.cAI = j;
    }

    public void bt(long j) {
        this.cAW = j;
    }

    public void bu(long j) {
        this.cAT = j;
    }

    public void bv(long j) {
        this.cAU = j;
    }

    public void bw(long j) {
        this.cAV = j;
    }

    public void bx(long j) {
        this.cAX = j;
    }

    public void by(long j) {
        this.cAY = j;
        this.cAA = true;
    }

    public void bz(long j) {
        this.cAL = j;
    }

    public void bA(long j) {
        this.cAM = j;
    }

    public void bB(long j) {
        this.cAO = j;
    }

    public void bC(long j) {
        this.cAN = j;
    }

    public void bD(long j) {
        this.cAP = j;
    }

    public void bE(long j) {
        this.cAQ = j;
    }

    public void bF(long j) {
        this.cAR = j;
    }

    public void bG(long j) {
        this.cAS = j;
    }

    public static n avz() {
        if (cAZ == null) {
            synchronized (n.class) {
                if (cAZ == null) {
                    cAZ = new n();
                }
            }
        }
        return cAZ;
    }

    public void avA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.cAY - this.cAD) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cAB && m.avt().avu()) {
            this.cAB = true;
            long j = this.cAE - this.cAD;
            long j2 = -1;
            if (this.cAU > 0) {
                j2 = this.cAV - this.cAU;
            }
            long j3 = this.cAY - this.cAX;
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "main");
            iF.append("appc", String.valueOf(j));
            iF.append("loadclass", String.valueOf(this.cAF));
            iF.append("sapiinit", String.valueOf(this.cAG));
            iF.append("acctinit", String.valueOf(this.cAH));
            iF.append("iminit", String.valueOf(this.cAI));
            iF.append("plugininit", String.valueOf(this.cAJ));
            iF.append("patchloaded", String.valueOf(this.cAK));
            iF.append("naslibinit", String.valueOf(this.cAL));
            iF.append("websocketinit", String.valueOf(this.cAM));
            iF.append("settinginit", String.valueOf(this.cAN));
            iF.append("toastinit", String.valueOf(this.cAO));
            iF.append("tiebastaticinit", String.valueOf(this.cAP));
            iF.append("locationinit", String.valueOf(this.cAQ));
            iF.append("cdninit", String.valueOf(this.cAR));
            iF.append("messagesetinit", String.valueOf(this.cAS));
            iF.append("logores", String.valueOf(this.cAW));
            if (this.cAT > 0 && this.cAU > 0 && j2 > 0) {
                iF.append("adc", String.valueOf(this.cAT));
                iF.append("adshow", String.valueOf(j2));
                iF.append("hasad", "1");
            } else {
                iF.append("hasad", "0");
            }
            iF.append("tabc", String.valueOf(j3));
            iF.append("costt", String.valueOf(this.cAW + j + j3));
            iF.append("newinst", this.cAz ? "1" : "0");
            iF.c("pluginloadsync", Boolean.valueOf(this.cAC));
            BdStatisticsManager.getInstance().performance("startt", iF);
            aaQ();
        }
    }

    public void bH(long j) {
        if (m.avt().avu() && j > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "remote");
            iF.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", iF);
        }
    }

    private void aaQ() {
        this.cAz = false;
        this.cAA = false;
        this.cAD = -1L;
        this.cAE = -1L;
        this.cAF = -1L;
        this.cAG = -1L;
        this.cAH = -1L;
        this.cAI = -1L;
        this.cAJ = -1L;
        this.cAK = -1L;
        this.cAW = -1L;
        this.cAU = -1L;
        this.cAV = -1L;
        this.cAT = -1L;
        this.cAX = -1L;
        this.cAY = -1L;
        this.cAL = -1L;
        this.cAM = -1L;
        this.cAN = -1L;
        this.cAO = -1L;
        this.cAP = -1L;
        this.cAQ = -1L;
        this.cAR = -1L;
        this.cAS = -1L;
    }
}
