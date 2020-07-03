package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eCd = null;
    private boolean eBB = false;
    private boolean eBC = false;
    private boolean eBD = false;
    private boolean eBE = false;
    private long eBF = -1;
    private long eBG = -1;
    private long eBH = -1;
    private long eBI = -1;
    private long eBJ = -1;
    private long eBK = -1;
    private long eBL = -1;
    private long eBM = -1;
    private long eBN = -1;
    private long eBO = -1;
    private long eBP = -1;
    private long eBQ = -1;
    private long eBR = -1;
    private long eBS = -1;
    private long eBT = -1;
    private long eBU = -1;
    private long eBV = -1;
    private long eBW = -1;
    private long eBX = -1;
    private long eBY = -1;
    private long eBZ = -1;
    private long eCa = -1;
    private long eCb = -1;
    private long eCc = -1;

    public boolean bhS() {
        return this.eBC;
    }

    public void iz(boolean z) {
        this.eBB = z;
    }

    public void cw(long j) {
        this.eBF = j;
    }

    public long bhT() {
        return this.eBF;
    }

    public void iA(boolean z) {
        this.eBE = z;
    }

    public void cx(long j) {
        this.eBG = j;
    }

    public void cy(long j) {
        this.eBH = j;
    }

    public void cz(long j) {
        this.eBI = j;
    }

    public void cA(long j) {
        this.eBM = j;
    }

    public void cB(long j) {
        this.eBL = j;
    }

    public void cC(long j) {
        this.eBJ = j;
    }

    public void cD(long j) {
        this.eBK = j;
    }

    public void cE(long j) {
        this.eCa = j;
    }

    public void cF(long j) {
        this.eBV = j;
    }

    public void cG(long j) {
        this.eBW = j;
    }

    public void cH(long j) {
        this.eBX = j;
    }

    public void cI(long j) {
        this.eBY = j;
    }

    public void cJ(long j) {
        this.eCb = j;
    }

    public void cK(long j) {
        this.eCc = j;
        this.eBC = true;
    }

    public void cL(long j) {
        this.eBN = j;
    }

    public void cM(long j) {
        this.eBO = j;
    }

    public void cN(long j) {
        this.eBQ = j;
    }

    public void cO(long j) {
        this.eBP = j;
    }

    public void cP(long j) {
        this.eBR = j;
    }

    public void cQ(long j) {
        this.eBS = j;
    }

    public void cR(long j) {
        this.eBT = j;
    }

    public void cS(long j) {
        this.eBU = j;
    }

    public static n bhU() {
        if (eCd == null) {
            synchronized (n.class) {
                if (eCd == null) {
                    eCd = new n();
                }
            }
        }
        return eCd;
    }

    public void bhV() {
        if (this.eCc - this.eBF > 0 && !this.eBD && this.eBZ > 0 && m.bhP().bhQ()) {
            this.eBD = true;
            long j = this.eBG - this.eBF;
            long j2 = -1;
            if (this.eBX > 0) {
                j2 = this.eBY - this.eBX;
            }
            long j3 = this.eCc - this.eCb;
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("procname", "main");
            lo.append("appc", String.valueOf(j));
            lo.append("loadclass", String.valueOf(this.eBH));
            lo.append("sapiinit", String.valueOf(this.eBI));
            lo.append("acctinit", String.valueOf(this.eBJ));
            lo.append("iminit", String.valueOf(this.eBK));
            lo.append("plugininit", String.valueOf(this.eBL));
            lo.append("patchloaded", String.valueOf(this.eBM));
            lo.append("naslibinit", String.valueOf(this.eBN));
            lo.append("websocketinit", String.valueOf(this.eBO));
            lo.append("settinginit", String.valueOf(this.eBP));
            lo.append("toastinit", String.valueOf(this.eBQ));
            lo.append("tiebastaticinit", String.valueOf(this.eBR));
            lo.append("locationinit", String.valueOf(this.eBS));
            lo.append("cdninit", String.valueOf(this.eBT));
            lo.append("messagesetinit", String.valueOf(this.eBU));
            lo.append("logores", String.valueOf(this.eCa));
            lo.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.dQV ? 1 : 0));
            if (this.eBV > 0 && this.eBX > 0 && j2 > 0) {
                lo.append("adc", String.valueOf(this.eBV + this.eBW));
                lo.append("adshow", String.valueOf(j2));
                lo.append("adrequest", String.valueOf(this.eBW));
                lo.append("hasad", "1");
            } else {
                lo.append("hasad", "0");
            }
            lo.append("tabc", String.valueOf(j3));
            lo.append("costt", String.valueOf(j2 + j + this.eBV + this.eBW + j3 + this.eBZ));
            lo.append("newinst", this.eBB ? "1" : "0");
            lo.append("pluginloadsync", Boolean.valueOf(this.eBE));
            lo.append("hptotal", String.valueOf(this.eBZ));
            BdStatisticsManager.getInstance().performance("startt", lo);
            aOB();
        }
    }

    public void cT(long j) {
        if (m.bhP().bhQ() && j > 0) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("procname", "remote");
            lo.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", lo);
        }
    }

    private void aOB() {
        this.eBB = false;
        this.eBC = false;
        this.eBF = -1L;
        this.eBG = -1L;
        this.eBH = -1L;
        this.eBI = -1L;
        this.eBJ = -1L;
        this.eBK = -1L;
        this.eBL = -1L;
        this.eBM = -1L;
        this.eCa = -1L;
        this.eBX = -1L;
        this.eBY = -1L;
        this.eBV = -1L;
        this.eCb = -1L;
        this.eCc = -1L;
        this.eBN = -1L;
        this.eBO = -1L;
        this.eBP = -1L;
        this.eBQ = -1L;
        this.eBR = -1L;
        this.eBS = -1L;
        this.eBT = -1L;
        this.eBU = -1L;
        this.eBW = -1L;
        this.eBZ = -1L;
    }

    public void cU(long j) {
        if (this.eBZ <= 0) {
            this.eBZ = j;
        }
    }
}
