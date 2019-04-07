package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n crC = null;
    private boolean crb = false;
    private boolean crd = false;
    private boolean cre = false;
    private boolean crf = false;
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
    private long crA = -1;
    private long crB = -1;

    public boolean apl() {
        return this.crd;
    }

    public void fg(boolean z) {
        this.crb = z;
    }

    public void aV(long j) {
        this.crg = j;
    }

    public long apm() {
        return this.crg;
    }

    public void fh(boolean z) {
        this.crf = z;
    }

    public void aW(long j) {
        this.crh = j;
    }

    public void aX(long j) {
        this.cri = j;
    }

    public void aY(long j) {
        this.crj = j;
    }

    public void aZ(long j) {
        this.crn = j;
    }

    public void ba(long j) {
        this.crm = j;
    }

    public void bb(long j) {
        this.crk = j;
    }

    public void bc(long j) {
        this.crl = j;
    }

    public void bd(long j) {
        this.crz = j;
    }

    public void be(long j) {
        this.crw = j;
    }

    public void bf(long j) {
        this.crx = j;
    }

    public void bg(long j) {
        this.cry = j;
    }

    public void bh(long j) {
        this.crA = j;
    }

    public void bi(long j) {
        this.crB = j;
        this.crd = true;
    }

    public void bj(long j) {
        this.cro = j;
    }

    public void bk(long j) {
        this.crp = j;
    }

    public void bl(long j) {
        this.crr = j;
    }

    public void bm(long j) {
        this.crq = j;
    }

    public void bn(long j) {
        this.crs = j;
    }

    public void bo(long j) {
        this.crt = j;
    }

    public void bp(long j) {
        this.cru = j;
    }

    public void bq(long j) {
        this.crv = j;
    }

    public static n apn() {
        if (crC == null) {
            synchronized (n.class) {
                if (crC == null) {
                    crC = new n();
                }
            }
        }
        return crC;
    }

    public void apo() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.crB - this.crg) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.cre && m.apg().aph()) {
            this.cre = true;
            long j = this.crh - this.crg;
            long j2 = -1;
            if (this.crx > 0) {
                j2 = this.cry - this.crx;
            }
            long j3 = this.crB - this.crA;
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("procname", "main");
            jC.append("appc", String.valueOf(j));
            jC.append("loadclass", String.valueOf(this.cri));
            jC.append("sapiinit", String.valueOf(this.crj));
            jC.append("acctinit", String.valueOf(this.crk));
            jC.append("iminit", String.valueOf(this.crl));
            jC.append("plugininit", String.valueOf(this.crm));
            jC.append("patchloaded", String.valueOf(this.crn));
            jC.append("naslibinit", String.valueOf(this.cro));
            jC.append("websocketinit", String.valueOf(this.crp));
            jC.append("settinginit", String.valueOf(this.crq));
            jC.append("toastinit", String.valueOf(this.crr));
            jC.append("tiebastaticinit", String.valueOf(this.crs));
            jC.append("locationinit", String.valueOf(this.crt));
            jC.append("cdninit", String.valueOf(this.cru));
            jC.append("messagesetinit", String.valueOf(this.crv));
            jC.append("logores", String.valueOf(this.crz));
            if (this.crw > 0 && this.crx > 0 && j2 > 0) {
                jC.append("adc", String.valueOf(this.crw));
                jC.append("adshow", String.valueOf(j2));
                jC.append("hasad", "1");
            } else {
                jC.append("hasad", "0");
            }
            jC.append("tabc", String.valueOf(j3));
            jC.append("costt", String.valueOf(this.crz + j + j3));
            jC.append("newinst", this.crb ? "1" : "0");
            jC.f("pluginloadsync", Boolean.valueOf(this.crf));
            BdStatisticsManager.getInstance().performance("startt", jC);
            Vn();
        }
    }

    public void br(long j) {
        if (m.apg().aph() && j > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("procname", "remote");
            jC.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jC);
        }
    }

    private void Vn() {
        this.crb = false;
        this.crd = false;
        this.crg = -1L;
        this.crh = -1L;
        this.cri = -1L;
        this.crj = -1L;
        this.crk = -1L;
        this.crl = -1L;
        this.crm = -1L;
        this.crn = -1L;
        this.crz = -1L;
        this.crx = -1L;
        this.cry = -1L;
        this.crw = -1L;
        this.crA = -1L;
        this.crB = -1L;
        this.cro = -1L;
        this.crp = -1L;
        this.crq = -1L;
        this.crr = -1L;
        this.crs = -1L;
        this.crt = -1L;
        this.cru = -1L;
        this.crv = -1L;
    }
}
