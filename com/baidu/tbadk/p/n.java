package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n cBg = null;
    private boolean cAG = false;
    private boolean cAH = false;
    private boolean cAI = false;
    private boolean cAJ = false;
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
    private long cAZ = -1;
    private long cBa = -1;
    private long cBb = -1;
    private long cBc = -1;
    private long cBd = -1;
    private long cBe = -1;
    private long cBf = -1;

    public boolean avz() {
        return this.cAH;
    }

    public void fG(boolean z) {
        this.cAG = z;
    }

    public void bl(long j) {
        this.cAK = j;
    }

    public long avA() {
        return this.cAK;
    }

    public void fH(boolean z) {
        this.cAJ = z;
    }

    public void bm(long j) {
        this.cAL = j;
    }

    public void bn(long j) {
        this.cAM = j;
    }

    public void bo(long j) {
        this.cAN = j;
    }

    public void bp(long j) {
        this.cAR = j;
    }

    public void bq(long j) {
        this.cAQ = j;
    }

    public void br(long j) {
        this.cAO = j;
    }

    public void bs(long j) {
        this.cAP = j;
    }

    public void bt(long j) {
        this.cBd = j;
    }

    public void bu(long j) {
        this.cBa = j;
    }

    public void bv(long j) {
        this.cBb = j;
    }

    public void bw(long j) {
        this.cBc = j;
    }

    public void bx(long j) {
        this.cBe = j;
    }

    public void by(long j) {
        this.cBf = j;
        this.cAH = true;
    }

    public void bz(long j) {
        this.cAS = j;
    }

    public void bA(long j) {
        this.cAT = j;
    }

    public void bB(long j) {
        this.cAV = j;
    }

    public void bC(long j) {
        this.cAU = j;
    }

    public void bD(long j) {
        this.cAW = j;
    }

    public void bE(long j) {
        this.cAX = j;
    }

    public void bF(long j) {
        this.cAY = j;
    }

    public void bG(long j) {
        this.cAZ = j;
    }

    public static n avB() {
        if (cBg == null) {
            synchronized (n.class) {
                if (cBg == null) {
                    cBg = new n();
                }
            }
        }
        return cBg;
    }

    public void avC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.cBf - this.cAK) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cAI && m.avv().avw()) {
            this.cAI = true;
            long j = this.cAL - this.cAK;
            long j2 = -1;
            if (this.cBb > 0) {
                j2 = this.cBc - this.cBb;
            }
            long j3 = this.cBf - this.cBe;
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "main");
            iF.append("appc", String.valueOf(j));
            iF.append("loadclass", String.valueOf(this.cAM));
            iF.append("sapiinit", String.valueOf(this.cAN));
            iF.append("acctinit", String.valueOf(this.cAO));
            iF.append("iminit", String.valueOf(this.cAP));
            iF.append("plugininit", String.valueOf(this.cAQ));
            iF.append("patchloaded", String.valueOf(this.cAR));
            iF.append("naslibinit", String.valueOf(this.cAS));
            iF.append("websocketinit", String.valueOf(this.cAT));
            iF.append("settinginit", String.valueOf(this.cAU));
            iF.append("toastinit", String.valueOf(this.cAV));
            iF.append("tiebastaticinit", String.valueOf(this.cAW));
            iF.append("locationinit", String.valueOf(this.cAX));
            iF.append("cdninit", String.valueOf(this.cAY));
            iF.append("messagesetinit", String.valueOf(this.cAZ));
            iF.append("logores", String.valueOf(this.cBd));
            if (this.cBa > 0 && this.cBb > 0 && j2 > 0) {
                iF.append("adc", String.valueOf(this.cBa));
                iF.append("adshow", String.valueOf(j2));
                iF.append("hasad", "1");
            } else {
                iF.append("hasad", "0");
            }
            iF.append("tabc", String.valueOf(j3));
            iF.append("costt", String.valueOf(this.cBd + j + j3));
            iF.append("newinst", this.cAG ? "1" : "0");
            iF.c("pluginloadsync", Boolean.valueOf(this.cAJ));
            BdStatisticsManager.getInstance().performance("startt", iF);
            aaQ();
        }
    }

    public void bH(long j) {
        if (m.avv().avw() && j > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "remote");
            iF.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", iF);
        }
    }

    private void aaQ() {
        this.cAG = false;
        this.cAH = false;
        this.cAK = -1L;
        this.cAL = -1L;
        this.cAM = -1L;
        this.cAN = -1L;
        this.cAO = -1L;
        this.cAP = -1L;
        this.cAQ = -1L;
        this.cAR = -1L;
        this.cBd = -1L;
        this.cBb = -1L;
        this.cBc = -1L;
        this.cBa = -1L;
        this.cBe = -1L;
        this.cBf = -1L;
        this.cAS = -1L;
        this.cAT = -1L;
        this.cAU = -1L;
        this.cAV = -1L;
        this.cAW = -1L;
        this.cAX = -1L;
        this.cAY = -1L;
        this.cAZ = -1L;
    }
}
