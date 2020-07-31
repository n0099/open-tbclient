package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n eIs = null;
    private boolean eHQ = false;
    private boolean eHR = false;
    private boolean eHS = false;
    private boolean eHT = false;
    private long eHU = -1;
    private long eHV = -1;
    private long eHW = -1;
    private long eHX = -1;
    private long eHY = -1;
    private long eHZ = -1;
    private long eIa = -1;
    private long eIb = -1;
    private long eIc = -1;
    private long eId = -1;
    private long eIe = -1;
    private long eIf = -1;
    private long eIg = -1;
    private long eIh = -1;
    private long eIi = -1;
    private long eIj = -1;
    private long eIk = -1;
    private long eIl = -1;
    private long eIm = -1;
    private long eIn = -1;
    private long eIo = -1;
    private long eIp = -1;
    private long eIq = -1;
    private long eIr = -1;

    public boolean blD() {
        return this.eHR;
    }

    public void je(boolean z) {
        this.eHQ = z;
    }

    public void cQ(long j) {
        this.eHU = j;
    }

    public long blE() {
        return this.eHU;
    }

    public void jf(boolean z) {
        this.eHT = z;
    }

    public void cR(long j) {
        this.eHV = j;
    }

    public void cS(long j) {
        this.eHW = j;
    }

    public void cT(long j) {
        this.eHX = j;
    }

    public void cU(long j) {
        this.eIb = j;
    }

    public void cV(long j) {
        this.eIa = j;
    }

    public void cW(long j) {
        this.eHY = j;
    }

    public void cX(long j) {
        this.eHZ = j;
    }

    public void cY(long j) {
        this.eIp = j;
    }

    public void cZ(long j) {
        this.eIk = j;
    }

    public void da(long j) {
        this.eIl = j;
    }

    public void db(long j) {
        this.eIm = j;
    }

    public void dc(long j) {
        this.eIn = j;
    }

    public void dd(long j) {
        this.eIq = j;
    }

    public void de(long j) {
        this.eIr = j;
        this.eHR = true;
    }

    public void df(long j) {
        this.eIc = j;
    }

    public void dg(long j) {
        this.eId = j;
    }

    public void dh(long j) {
        this.eIf = j;
    }

    public void di(long j) {
        this.eIe = j;
    }

    public void dj(long j) {
        this.eIg = j;
    }

    public void dk(long j) {
        this.eIh = j;
    }

    public void dl(long j) {
        this.eIi = j;
    }

    public void dm(long j) {
        this.eIj = j;
    }

    public static n blF() {
        if (eIs == null) {
            synchronized (n.class) {
                if (eIs == null) {
                    eIs = new n();
                }
            }
        }
        return eIs;
    }

    public void blG() {
        if (this.eIr - this.eHU > 0 && !this.eHS && this.eIo > 0 && m.blA().blB()) {
            this.eHS = true;
            long j = this.eHV - this.eHU;
            long j2 = -1;
            if (this.eIm > 0) {
                j2 = this.eIn - this.eIm;
            }
            long j3 = this.eIr - this.eIq;
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("procname", "main");
            lo.append("appc", String.valueOf(j));
            lo.append("loadclass", String.valueOf(this.eHW));
            lo.append("sapiinit", String.valueOf(this.eHX));
            lo.append("acctinit", String.valueOf(this.eHY));
            lo.append("iminit", String.valueOf(this.eHZ));
            lo.append("plugininit", String.valueOf(this.eIa));
            lo.append("patchloaded", String.valueOf(this.eIb));
            lo.append("naslibinit", String.valueOf(this.eIc));
            lo.append("websocketinit", String.valueOf(this.eId));
            lo.append("settinginit", String.valueOf(this.eIe));
            lo.append("toastinit", String.valueOf(this.eIf));
            lo.append("tiebastaticinit", String.valueOf(this.eIg));
            lo.append("locationinit", String.valueOf(this.eIh));
            lo.append("cdninit", String.valueOf(this.eIi));
            lo.append("messagesetinit", String.valueOf(this.eIj));
            lo.append("logores", String.valueOf(this.eIp));
            lo.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.dXn ? 1 : 0));
            if (this.eIk > 0 && this.eIm > 0 && j2 > 0) {
                lo.append("adc", String.valueOf(this.eIk + this.eIl));
                lo.append("adshow", String.valueOf(j2));
                lo.append("adrequest", String.valueOf(this.eIl));
                lo.append("hasad", "1");
            } else {
                lo.append("hasad", "0");
            }
            lo.append("tabc", String.valueOf(j3));
            lo.append("costt", String.valueOf(j2 + j + this.eIk + this.eIl + j3 + this.eIo));
            lo.append("newinst", this.eHQ ? "1" : "0");
            lo.append("pluginloadsync", Boolean.valueOf(this.eHT));
            lo.append("hptotal", String.valueOf(this.eIo));
            BdStatisticsManager.getInstance().performance("startt", lo);
            aSw();
        }
    }

    public void dn(long j) {
        if (m.blA().blB() && j > 0) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("procname", "remote");
            lo.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", lo);
        }
    }

    private void aSw() {
        this.eHQ = false;
        this.eHR = false;
        this.eHU = -1L;
        this.eHV = -1L;
        this.eHW = -1L;
        this.eHX = -1L;
        this.eHY = -1L;
        this.eHZ = -1L;
        this.eIa = -1L;
        this.eIb = -1L;
        this.eIp = -1L;
        this.eIm = -1L;
        this.eIn = -1L;
        this.eIk = -1L;
        this.eIq = -1L;
        this.eIr = -1L;
        this.eIc = -1L;
        this.eId = -1L;
        this.eIe = -1L;
        this.eIf = -1L;
        this.eIg = -1L;
        this.eIh = -1L;
        this.eIi = -1L;
        this.eIj = -1L;
        this.eIl = -1L;
        this.eIo = -1L;
    }

    /* renamed from: do  reason: not valid java name */
    public void m33do(long j) {
        if (this.eIo <= 0) {
            this.eIo = j;
        }
    }
}
