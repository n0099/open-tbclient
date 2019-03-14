package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n crA = null;
    private boolean cqZ = false;
    private boolean cra = false;
    private boolean crb = false;
    private boolean crd = false;
    private long cre = -1;
    private long crf = -1;
    private long crg = -1;
    private long crh = -1;
    private long cri = -1;
    private long crj = -1;
    private long crk = -1;
    private long crl = -1;
    private long crm = -1;
    private long crn = -1;
    private long cro = -1;
    private long crp = -1;
    private long crq = -1;
    private long crr = -1;
    private long crs = -1;
    private long crt = -1;
    private long cru = -1;
    private long crv = -1;
    private long crw = -1;
    private long crx = -1;
    private long cry = -1;
    private long crz = -1;

    public boolean apo() {
        return this.cra;
    }

    public void fg(boolean z) {
        this.cqZ = z;
    }

    public void aV(long j) {
        this.cre = j;
    }

    public long app() {
        return this.cre;
    }

    public void fh(boolean z) {
        this.crd = z;
    }

    public void aW(long j) {
        this.crf = j;
    }

    public void aX(long j) {
        this.crg = j;
    }

    public void aY(long j) {
        this.crh = j;
    }

    public void aZ(long j) {
        this.crl = j;
    }

    public void ba(long j) {
        this.crk = j;
    }

    public void bb(long j) {
        this.cri = j;
    }

    public void bc(long j) {
        this.crj = j;
    }

    public void bd(long j) {
        this.crx = j;
    }

    public void be(long j) {
        this.cru = j;
    }

    public void bf(long j) {
        this.crv = j;
    }

    public void bg(long j) {
        this.crw = j;
    }

    public void bh(long j) {
        this.cry = j;
    }

    public void bi(long j) {
        this.crz = j;
        this.cra = true;
    }

    public void bj(long j) {
        this.crm = j;
    }

    public void bk(long j) {
        this.crn = j;
    }

    public void bl(long j) {
        this.crp = j;
    }

    public void bm(long j) {
        this.cro = j;
    }

    public void bn(long j) {
        this.crq = j;
    }

    public void bo(long j) {
        this.crr = j;
    }

    public void bp(long j) {
        this.crs = j;
    }

    public void bq(long j) {
        this.crt = j;
    }

    public static n apq() {
        if (crA == null) {
            synchronized (n.class) {
                if (crA == null) {
                    crA = new n();
                }
            }
        }
        return crA;
    }

    public void apr() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.crz - this.cre) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.crb && m.apk().apl()) {
            this.crb = true;
            long j = this.crf - this.cre;
            long j2 = -1;
            if (this.crv > 0) {
                j2 = this.crw - this.crv;
            }
            long j3 = this.crz - this.cry;
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("procname", "main");
            jC.append("appc", String.valueOf(j));
            jC.append("loadclass", String.valueOf(this.crg));
            jC.append("sapiinit", String.valueOf(this.crh));
            jC.append("acctinit", String.valueOf(this.cri));
            jC.append("iminit", String.valueOf(this.crj));
            jC.append("plugininit", String.valueOf(this.crk));
            jC.append("patchloaded", String.valueOf(this.crl));
            jC.append("naslibinit", String.valueOf(this.crm));
            jC.append("websocketinit", String.valueOf(this.crn));
            jC.append("settinginit", String.valueOf(this.cro));
            jC.append("toastinit", String.valueOf(this.crp));
            jC.append("tiebastaticinit", String.valueOf(this.crq));
            jC.append("locationinit", String.valueOf(this.crr));
            jC.append("cdninit", String.valueOf(this.crs));
            jC.append("messagesetinit", String.valueOf(this.crt));
            jC.append("logores", String.valueOf(this.crx));
            if (this.cru > 0 && this.crv > 0 && j2 > 0) {
                jC.append("adc", String.valueOf(this.cru));
                jC.append("adshow", String.valueOf(j2));
                jC.append("hasad", "1");
            } else {
                jC.append("hasad", "0");
            }
            jC.append("tabc", String.valueOf(j3));
            jC.append("costt", String.valueOf(this.crx + j + j3));
            jC.append("newinst", this.cqZ ? "1" : "0");
            jC.f("pluginloadsync", Boolean.valueOf(this.crd));
            BdStatisticsManager.getInstance().performance("startt", jC);
            Vq();
        }
    }

    public void br(long j) {
        if (m.apk().apl() && j > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("procname", "remote");
            jC.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jC);
        }
    }

    private void Vq() {
        this.cqZ = false;
        this.cra = false;
        this.cre = -1L;
        this.crf = -1L;
        this.crg = -1L;
        this.crh = -1L;
        this.cri = -1L;
        this.crj = -1L;
        this.crk = -1L;
        this.crl = -1L;
        this.crx = -1L;
        this.crv = -1L;
        this.crw = -1L;
        this.cru = -1L;
        this.cry = -1L;
        this.crz = -1L;
        this.crm = -1L;
        this.crn = -1L;
        this.cro = -1L;
        this.crp = -1L;
        this.crq = -1L;
        this.crr = -1L;
        this.crs = -1L;
        this.crt = -1L;
    }
}
