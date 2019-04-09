package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n crD = null;
    private boolean crd = false;
    private boolean cre = false;
    private boolean crf = false;
    private boolean crg = false;
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
    private long crC = -1;

    public boolean apl() {
        return this.cre;
    }

    public void fg(boolean z) {
        this.crd = z;
    }

    public void aV(long j) {
        this.crh = j;
    }

    public long apm() {
        return this.crh;
    }

    public void fh(boolean z) {
        this.crg = z;
    }

    public void aW(long j) {
        this.cri = j;
    }

    public void aX(long j) {
        this.crj = j;
    }

    public void aY(long j) {
        this.crk = j;
    }

    public void aZ(long j) {
        this.cro = j;
    }

    public void ba(long j) {
        this.crn = j;
    }

    public void bb(long j) {
        this.crl = j;
    }

    public void bc(long j) {
        this.crm = j;
    }

    public void bd(long j) {
        this.crA = j;
    }

    public void be(long j) {
        this.crx = j;
    }

    public void bf(long j) {
        this.cry = j;
    }

    public void bg(long j) {
        this.crz = j;
    }

    public void bh(long j) {
        this.crB = j;
    }

    public void bi(long j) {
        this.crC = j;
        this.cre = true;
    }

    public void bj(long j) {
        this.crp = j;
    }

    public void bk(long j) {
        this.crq = j;
    }

    public void bl(long j) {
        this.crs = j;
    }

    public void bm(long j) {
        this.crr = j;
    }

    public void bn(long j) {
        this.crt = j;
    }

    public void bo(long j) {
        this.cru = j;
    }

    public void bp(long j) {
        this.crv = j;
    }

    public void bq(long j) {
        this.crw = j;
    }

    public static n apn() {
        if (crD == null) {
            synchronized (n.class) {
                if (crD == null) {
                    crD = new n();
                }
            }
        }
        return crD;
    }

    public void apo() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.crC - this.crh) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.crf && m.apg().aph()) {
            this.crf = true;
            long j = this.cri - this.crh;
            long j2 = -1;
            if (this.cry > 0) {
                j2 = this.crz - this.cry;
            }
            long j3 = this.crC - this.crB;
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("procname", "main");
            jC.append("appc", String.valueOf(j));
            jC.append("loadclass", String.valueOf(this.crj));
            jC.append("sapiinit", String.valueOf(this.crk));
            jC.append("acctinit", String.valueOf(this.crl));
            jC.append("iminit", String.valueOf(this.crm));
            jC.append("plugininit", String.valueOf(this.crn));
            jC.append("patchloaded", String.valueOf(this.cro));
            jC.append("naslibinit", String.valueOf(this.crp));
            jC.append("websocketinit", String.valueOf(this.crq));
            jC.append("settinginit", String.valueOf(this.crr));
            jC.append("toastinit", String.valueOf(this.crs));
            jC.append("tiebastaticinit", String.valueOf(this.crt));
            jC.append("locationinit", String.valueOf(this.cru));
            jC.append("cdninit", String.valueOf(this.crv));
            jC.append("messagesetinit", String.valueOf(this.crw));
            jC.append("logores", String.valueOf(this.crA));
            if (this.crx > 0 && this.cry > 0 && j2 > 0) {
                jC.append("adc", String.valueOf(this.crx));
                jC.append("adshow", String.valueOf(j2));
                jC.append("hasad", "1");
            } else {
                jC.append("hasad", "0");
            }
            jC.append("tabc", String.valueOf(j3));
            jC.append("costt", String.valueOf(this.crA + j + j3));
            jC.append("newinst", this.crd ? "1" : "0");
            jC.f("pluginloadsync", Boolean.valueOf(this.crg));
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
        this.crd = false;
        this.cre = false;
        this.crh = -1L;
        this.cri = -1L;
        this.crj = -1L;
        this.crk = -1L;
        this.crl = -1L;
        this.crm = -1L;
        this.crn = -1L;
        this.cro = -1L;
        this.crA = -1L;
        this.cry = -1L;
        this.crz = -1L;
        this.crx = -1L;
        this.crB = -1L;
        this.crC = -1L;
        this.crp = -1L;
        this.crq = -1L;
        this.crr = -1L;
        this.crs = -1L;
        this.crt = -1L;
        this.cru = -1L;
        this.crv = -1L;
        this.crw = -1L;
    }
}
