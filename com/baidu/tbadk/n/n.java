package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n fqB = null;
    private boolean fpZ = false;
    private boolean fqa = false;
    private boolean fqb = false;
    private boolean fqc = false;
    private long fqd = -1;
    private long fqe = -1;
    private long fqf = -1;
    private long fqg = -1;
    private long fqh = -1;
    private long fqi = -1;
    private long fqj = -1;
    private long fqk = -1;
    private long fql = -1;
    private long fqm = -1;
    private long fqn = -1;
    private long fqo = -1;
    private long fqp = -1;
    private long fqq = -1;
    private long fqr = -1;
    private long fqs = -1;
    private long fqt = -1;
    private long fqu = -1;
    private long fqv = -1;
    private long fqw = -1;
    private long fqx = -1;
    private long fqy = -1;
    private long fqz = -1;
    private long fqA = -1;

    public boolean bzY() {
        return this.fqa;
    }

    public void kq(boolean z) {
        this.fpZ = z;
    }

    public void dm(long j) {
        this.fqd = j;
    }

    public long bzZ() {
        return this.fqd;
    }

    public void kr(boolean z) {
        this.fqc = z;
    }

    public void dn(long j) {
        this.fqe = j;
    }

    /* renamed from: do  reason: not valid java name */
    public void m39do(long j) {
        this.fqf = j;
    }

    public void dp(long j) {
        this.fqg = j;
    }

    public void dq(long j) {
        this.fqk = j;
    }

    public void dr(long j) {
        this.fqj = j;
    }

    public void ds(long j) {
        this.fqh = j;
    }

    public void dt(long j) {
        this.fqi = j;
    }

    public void du(long j) {
        this.fqy = j;
    }

    public void dv(long j) {
        this.fqt = j;
    }

    public void dw(long j) {
        this.fqu = j;
    }

    public void dx(long j) {
        this.fqv = j;
    }

    public void dy(long j) {
        this.fqw = j;
    }

    public void dz(long j) {
        this.fqz = j;
    }

    public void dA(long j) {
        this.fqA = j;
        this.fqa = true;
    }

    public void dB(long j) {
        this.fql = j;
    }

    public void dC(long j) {
        this.fqm = j;
    }

    public void dD(long j) {
        this.fqo = j;
    }

    public void dE(long j) {
        this.fqn = j;
    }

    public void dF(long j) {
        this.fqp = j;
    }

    public void dG(long j) {
        this.fqq = j;
    }

    public void dH(long j) {
        this.fqr = j;
    }

    public void dI(long j) {
        this.fqs = j;
    }

    public static n bAa() {
        if (fqB == null) {
            synchronized (n.class) {
                if (fqB == null) {
                    fqB = new n();
                }
            }
        }
        return fqB;
    }

    public void bAb() {
        if (this.fqA - this.fqd > 0 && !this.fqb && this.fqx > 0 && m.bzV().bzW()) {
            this.fqb = true;
            long j = this.fqe - this.fqd;
            long j2 = -1;
            if (this.fqv > 0) {
                j2 = this.fqw - this.fqv;
            }
            long j3 = this.fqA - this.fqz;
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "main");
            mT.append("appc", String.valueOf(j));
            mT.append("loadclass", String.valueOf(this.fqf));
            mT.append("sapiinit", String.valueOf(this.fqg));
            mT.append("acctinit", String.valueOf(this.fqh));
            mT.append("iminit", String.valueOf(this.fqi));
            mT.append("plugininit", String.valueOf(this.fqj));
            mT.append("patchloaded", String.valueOf(this.fqk));
            mT.append("naslibinit", String.valueOf(this.fql));
            mT.append("websocketinit", String.valueOf(this.fqm));
            mT.append("settinginit", String.valueOf(this.fqn));
            mT.append("toastinit", String.valueOf(this.fqo));
            mT.append("tiebastaticinit", String.valueOf(this.fqp));
            mT.append("locationinit", String.valueOf(this.fqq));
            mT.append("cdninit", String.valueOf(this.fqr));
            mT.append("messagesetinit", String.valueOf(this.fqs));
            mT.append("logores", String.valueOf(this.fqy));
            mT.append("opttest", String.valueOf(com.baidu.tbadk.core.frameworkData.d.eDT ? 1 : 0));
            if (this.fqt > 0 && this.fqv > 0 && j2 > 0) {
                mT.append("adc", String.valueOf(this.fqt + this.fqu));
                mT.append("adshow", String.valueOf(j2));
                mT.append("adrequest", String.valueOf(this.fqu));
                mT.append("hasad", "1");
            } else {
                mT.append("hasad", "0");
            }
            mT.append("tabc", String.valueOf(j3));
            mT.append("costt", String.valueOf(j2 + j + this.fqt + this.fqu + j3 + this.fqx));
            mT.append("newinst", this.fpZ ? "1" : "0");
            mT.append("pluginloadsync", Boolean.valueOf(this.fqc));
            mT.append("hptotal", String.valueOf(this.fqx));
            BdStatisticsManager.getInstance().performance("startt", mT);
            bgi();
        }
    }

    public void dJ(long j) {
        if (m.bzV().bzW() && j > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("procname", "remote");
            mT.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", mT);
        }
    }

    private void bgi() {
        this.fpZ = false;
        this.fqa = false;
        this.fqd = -1L;
        this.fqe = -1L;
        this.fqf = -1L;
        this.fqg = -1L;
        this.fqh = -1L;
        this.fqi = -1L;
        this.fqj = -1L;
        this.fqk = -1L;
        this.fqy = -1L;
        this.fqv = -1L;
        this.fqw = -1L;
        this.fqt = -1L;
        this.fqz = -1L;
        this.fqA = -1L;
        this.fql = -1L;
        this.fqm = -1L;
        this.fqn = -1L;
        this.fqo = -1L;
        this.fqp = -1L;
        this.fqq = -1L;
        this.fqr = -1L;
        this.fqs = -1L;
        this.fqu = -1L;
        this.fqx = -1L;
    }

    public void dK(long j) {
        if (this.fqx <= 0) {
            this.fqx = j;
        }
    }
}
