package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n fib = null;
    private boolean fhz = false;
    private boolean fhA = false;
    private boolean fhB = false;
    private boolean fhC = false;
    private long fhD = -1;
    private long fhE = -1;
    private long fhF = -1;
    private long fhG = -1;
    private long fhH = -1;
    private long fhI = -1;
    private long fhJ = -1;
    private long fhK = -1;
    private long fhL = -1;
    private long fhM = -1;
    private long fhN = -1;
    private long fhO = -1;
    private long fhP = -1;
    private long fhQ = -1;
    private long fhR = -1;
    private long fhS = -1;
    private long fhT = -1;
    private long fhU = -1;
    private long fhV = -1;
    private long fhW = -1;
    private long fhX = -1;
    private long fhY = -1;
    private long fhZ = -1;
    private long fia = -1;

    public boolean byf() {
        return this.fhA;
    }

    public void kd(boolean z) {
        this.fhz = z;
    }

    public void dk(long j) {
        this.fhD = j;
    }

    public long byg() {
        return this.fhD;
    }

    public void ke(boolean z) {
        this.fhC = z;
    }

    public void dl(long j) {
        this.fhE = j;
    }

    public void dm(long j) {
        this.fhF = j;
    }

    public void dn(long j) {
        this.fhG = j;
    }

    /* renamed from: do  reason: not valid java name */
    public void m38do(long j) {
        this.fhK = j;
    }

    public void dp(long j) {
        this.fhJ = j;
    }

    public void dq(long j) {
        this.fhH = j;
    }

    public void dr(long j) {
        this.fhI = j;
    }

    public void ds(long j) {
        this.fhY = j;
    }

    public void dt(long j) {
        this.fhT = j;
    }

    public void du(long j) {
        this.fhU = j;
    }

    public void dv(long j) {
        this.fhV = j;
    }

    public void dw(long j) {
        this.fhW = j;
    }

    public void dx(long j) {
        this.fhZ = j;
    }

    public void dy(long j) {
        this.fia = j;
        this.fhA = true;
    }

    public void dz(long j) {
        this.fhL = j;
    }

    public void dA(long j) {
        this.fhM = j;
    }

    public void dB(long j) {
        this.fhO = j;
    }

    public void dC(long j) {
        this.fhN = j;
    }

    public void dD(long j) {
        this.fhP = j;
    }

    public void dE(long j) {
        this.fhQ = j;
    }

    public void dF(long j) {
        this.fhR = j;
    }

    public void dG(long j) {
        this.fhS = j;
    }

    public static n byh() {
        if (fib == null) {
            synchronized (n.class) {
                if (fib == null) {
                    fib = new n();
                }
            }
        }
        return fib;
    }

    public void byi() {
        if (this.fia - this.fhD > 0 && !this.fhB && this.fhX > 0 && m.byc().byd()) {
            this.fhB = true;
            long j = this.fhE - this.fhD;
            long j2 = -1;
            if (this.fhV > 0) {
                j2 = this.fhW - this.fhV;
            }
            long j3 = this.fia - this.fhZ;
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "main");
            mT.append("appc", String.valueOf(j));
            mT.append("loadclass", String.valueOf(this.fhF));
            mT.append("sapiinit", String.valueOf(this.fhG));
            mT.append("acctinit", String.valueOf(this.fhH));
            mT.append("iminit", String.valueOf(this.fhI));
            mT.append("plugininit", String.valueOf(this.fhJ));
            mT.append("patchloaded", String.valueOf(this.fhK));
            mT.append("naslibinit", String.valueOf(this.fhL));
            mT.append("websocketinit", String.valueOf(this.fhM));
            mT.append("settinginit", String.valueOf(this.fhN));
            mT.append("toastinit", String.valueOf(this.fhO));
            mT.append("tiebastaticinit", String.valueOf(this.fhP));
            mT.append("locationinit", String.valueOf(this.fhQ));
            mT.append("cdninit", String.valueOf(this.fhR));
            mT.append("messagesetinit", String.valueOf(this.fhS));
            mT.append("logores", String.valueOf(this.fhY));
            mT.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.evu ? 1 : 0));
            if (this.fhT > 0 && this.fhV > 0 && j2 > 0) {
                mT.append("adc", String.valueOf(this.fhT + this.fhU));
                mT.append("adshow", String.valueOf(j2));
                mT.append("adrequest", String.valueOf(this.fhU));
                mT.append("hasad", "1");
            } else {
                mT.append("hasad", "0");
            }
            mT.append("tabc", String.valueOf(j3));
            mT.append("costt", String.valueOf(j2 + j + this.fhT + this.fhU + j3 + this.fhX));
            mT.append("newinst", this.fhz ? "1" : "0");
            mT.append("pluginloadsync", Boolean.valueOf(this.fhC));
            mT.append("hptotal", String.valueOf(this.fhX));
            BdStatisticsManager.getInstance().performance("startt", mT);
            bep();
        }
    }

    public void dH(long j) {
        if (m.byc().byd() && j > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "remote");
            mT.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mT);
        }
    }

    private void bep() {
        this.fhz = false;
        this.fhA = false;
        this.fhD = -1L;
        this.fhE = -1L;
        this.fhF = -1L;
        this.fhG = -1L;
        this.fhH = -1L;
        this.fhI = -1L;
        this.fhJ = -1L;
        this.fhK = -1L;
        this.fhY = -1L;
        this.fhV = -1L;
        this.fhW = -1L;
        this.fhT = -1L;
        this.fhZ = -1L;
        this.fia = -1L;
        this.fhL = -1L;
        this.fhM = -1L;
        this.fhN = -1L;
        this.fhO = -1L;
        this.fhP = -1L;
        this.fhQ = -1L;
        this.fhR = -1L;
        this.fhS = -1L;
        this.fhU = -1L;
        this.fhX = -1L;
    }

    public void dI(long j) {
        if (this.fhX <= 0) {
            this.fhX = j;
        }
    }
}
