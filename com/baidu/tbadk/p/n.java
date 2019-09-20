package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n cCc = null;
    private boolean cBC = false;
    private boolean cBD = false;
    private boolean cBE = false;
    private boolean cBF = false;
    private long cBG = -1;
    private long cBH = -1;
    private long cBI = -1;
    private long cBJ = -1;
    private long cBK = -1;
    private long cBL = -1;
    private long cBM = -1;
    private long cBN = -1;
    private long cBO = -1;
    private long cBP = -1;
    private long cBQ = -1;
    private long cBR = -1;
    private long cBS = -1;
    private long cBT = -1;
    private long cBU = -1;
    private long cBV = -1;
    private long cBW = -1;
    private long cBX = -1;
    private long cBY = -1;
    private long cBZ = -1;
    private long cCa = -1;
    private long cCb = -1;

    public boolean avL() {
        return this.cBD;
    }

    public void fJ(boolean z) {
        this.cBC = z;
    }

    public void bo(long j) {
        this.cBG = j;
    }

    public long avM() {
        return this.cBG;
    }

    public void fK(boolean z) {
        this.cBF = z;
    }

    public void bp(long j) {
        this.cBH = j;
    }

    public void bq(long j) {
        this.cBI = j;
    }

    public void br(long j) {
        this.cBJ = j;
    }

    public void bs(long j) {
        this.cBN = j;
    }

    public void bt(long j) {
        this.cBM = j;
    }

    public void bu(long j) {
        this.cBK = j;
    }

    public void bv(long j) {
        this.cBL = j;
    }

    public void bw(long j) {
        this.cBZ = j;
    }

    public void bx(long j) {
        this.cBW = j;
    }

    public void by(long j) {
        this.cBX = j;
    }

    public void bz(long j) {
        this.cBY = j;
    }

    public void bA(long j) {
        this.cCa = j;
    }

    public void bB(long j) {
        this.cCb = j;
        this.cBD = true;
    }

    public void bC(long j) {
        this.cBO = j;
    }

    public void bD(long j) {
        this.cBP = j;
    }

    public void bE(long j) {
        this.cBR = j;
    }

    public void bF(long j) {
        this.cBQ = j;
    }

    public void bG(long j) {
        this.cBS = j;
    }

    public void bH(long j) {
        this.cBT = j;
    }

    public void bI(long j) {
        this.cBU = j;
    }

    public void bJ(long j) {
        this.cBV = j;
    }

    public static n avN() {
        if (cCc == null) {
            synchronized (n.class) {
                if (cCc == null) {
                    cCc = new n();
                }
            }
        }
        return cCc;
    }

    public void avO() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.cCb - this.cBG) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cBE && m.avH().avI()) {
            this.cBE = true;
            long j = this.cBH - this.cBG;
            long j2 = -1;
            if (this.cBX > 0) {
                j2 = this.cBY - this.cBX;
            }
            long j3 = this.cCb - this.cCa;
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "main");
            iF.append("appc", String.valueOf(j));
            iF.append("loadclass", String.valueOf(this.cBI));
            iF.append("sapiinit", String.valueOf(this.cBJ));
            iF.append("acctinit", String.valueOf(this.cBK));
            iF.append("iminit", String.valueOf(this.cBL));
            iF.append("plugininit", String.valueOf(this.cBM));
            iF.append("patchloaded", String.valueOf(this.cBN));
            iF.append("naslibinit", String.valueOf(this.cBO));
            iF.append("websocketinit", String.valueOf(this.cBP));
            iF.append("settinginit", String.valueOf(this.cBQ));
            iF.append("toastinit", String.valueOf(this.cBR));
            iF.append("tiebastaticinit", String.valueOf(this.cBS));
            iF.append("locationinit", String.valueOf(this.cBT));
            iF.append("cdninit", String.valueOf(this.cBU));
            iF.append("messagesetinit", String.valueOf(this.cBV));
            iF.append("logores", String.valueOf(this.cBZ));
            if (this.cBW > 0 && this.cBX > 0 && j2 > 0) {
                iF.append("adc", String.valueOf(this.cBW));
                iF.append("adshow", String.valueOf(j2));
                iF.append("hasad", "1");
            } else {
                iF.append("hasad", "0");
            }
            iF.append("tabc", String.valueOf(j3));
            iF.append("costt", String.valueOf(this.cBZ + j + j3));
            iF.append("newinst", this.cBC ? "1" : "0");
            iF.c("pluginloadsync", Boolean.valueOf(this.cBF));
            BdStatisticsManager.getInstance().performance("startt", iF);
            aaU();
        }
    }

    public void bK(long j) {
        if (m.avH().avI() && j > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("procname", "remote");
            iF.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", iF);
        }
    }

    private void aaU() {
        this.cBC = false;
        this.cBD = false;
        this.cBG = -1L;
        this.cBH = -1L;
        this.cBI = -1L;
        this.cBJ = -1L;
        this.cBK = -1L;
        this.cBL = -1L;
        this.cBM = -1L;
        this.cBN = -1L;
        this.cBZ = -1L;
        this.cBX = -1L;
        this.cBY = -1L;
        this.cBW = -1L;
        this.cCa = -1L;
        this.cCb = -1L;
        this.cBO = -1L;
        this.cBP = -1L;
        this.cBQ = -1L;
        this.cBR = -1L;
        this.cBS = -1L;
        this.cBT = -1L;
        this.cBU = -1L;
        this.cBV = -1L;
    }
}
