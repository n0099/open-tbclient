package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n czJ = null;
    private boolean czj = false;
    private boolean czk = false;
    private boolean czl = false;
    private boolean czm = false;
    private long czn = -1;
    private long czo = -1;
    private long czp = -1;
    private long czq = -1;
    private long czr = -1;
    private long czs = -1;
    private long czt = -1;
    private long czu = -1;
    private long czv = -1;
    private long czw = -1;
    private long czx = -1;
    private long czy = -1;
    private long czz = -1;
    private long czA = -1;
    private long czB = -1;
    private long czC = -1;
    private long czD = -1;
    private long czE = -1;
    private long czF = -1;
    private long czG = -1;
    private long czH = -1;
    private long czI = -1;

    public boolean auo() {
        return this.czk;
    }

    public void fC(boolean z) {
        this.czj = z;
    }

    public void bk(long j) {
        this.czn = j;
    }

    public long aup() {
        return this.czn;
    }

    public void fD(boolean z) {
        this.czm = z;
    }

    public void bl(long j) {
        this.czo = j;
    }

    public void bm(long j) {
        this.czp = j;
    }

    public void bn(long j) {
        this.czq = j;
    }

    public void bo(long j) {
        this.czu = j;
    }

    public void bp(long j) {
        this.czt = j;
    }

    public void bq(long j) {
        this.czr = j;
    }

    public void br(long j) {
        this.czs = j;
    }

    public void bs(long j) {
        this.czG = j;
    }

    public void bt(long j) {
        this.czD = j;
    }

    public void bu(long j) {
        this.czE = j;
    }

    public void bv(long j) {
        this.czF = j;
    }

    public void bw(long j) {
        this.czH = j;
    }

    public void bx(long j) {
        this.czI = j;
        this.czk = true;
    }

    public void by(long j) {
        this.czv = j;
    }

    public void bz(long j) {
        this.czw = j;
    }

    public void bA(long j) {
        this.czy = j;
    }

    public void bB(long j) {
        this.czx = j;
    }

    public void bC(long j) {
        this.czz = j;
    }

    public void bD(long j) {
        this.czA = j;
    }

    public void bE(long j) {
        this.czB = j;
    }

    public void bF(long j) {
        this.czC = j;
    }

    public static n auq() {
        if (czJ == null) {
            synchronized (n.class) {
                if (czJ == null) {
                    czJ = new n();
                }
            }
        }
        return czJ;
    }

    public void aur() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.czI - this.czn) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.czl && m.auk().aul()) {
            this.czl = true;
            long j = this.czo - this.czn;
            long j2 = -1;
            if (this.czE > 0) {
                j2 = this.czF - this.czE;
            }
            long j3 = this.czI - this.czH;
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("procname", "main");
            iw.append("appc", String.valueOf(j));
            iw.append("loadclass", String.valueOf(this.czp));
            iw.append("sapiinit", String.valueOf(this.czq));
            iw.append("acctinit", String.valueOf(this.czr));
            iw.append("iminit", String.valueOf(this.czs));
            iw.append("plugininit", String.valueOf(this.czt));
            iw.append("patchloaded", String.valueOf(this.czu));
            iw.append("naslibinit", String.valueOf(this.czv));
            iw.append("websocketinit", String.valueOf(this.czw));
            iw.append("settinginit", String.valueOf(this.czx));
            iw.append("toastinit", String.valueOf(this.czy));
            iw.append("tiebastaticinit", String.valueOf(this.czz));
            iw.append("locationinit", String.valueOf(this.czA));
            iw.append("cdninit", String.valueOf(this.czB));
            iw.append("messagesetinit", String.valueOf(this.czC));
            iw.append("logores", String.valueOf(this.czG));
            if (this.czD > 0 && this.czE > 0 && j2 > 0) {
                iw.append("adc", String.valueOf(this.czD));
                iw.append("adshow", String.valueOf(j2));
                iw.append("hasad", "1");
            } else {
                iw.append("hasad", "0");
            }
            iw.append("tabc", String.valueOf(j3));
            iw.append("costt", String.valueOf(this.czG + j + j3));
            iw.append("newinst", this.czj ? "1" : "0");
            iw.c("pluginloadsync", Boolean.valueOf(this.czm));
            BdStatisticsManager.getInstance().performance("startt", iw);
            ZR();
        }
    }

    public void bG(long j) {
        if (m.auk().aul() && j > 0) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("procname", "remote");
            iw.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", iw);
        }
    }

    private void ZR() {
        this.czj = false;
        this.czk = false;
        this.czn = -1L;
        this.czo = -1L;
        this.czp = -1L;
        this.czq = -1L;
        this.czr = -1L;
        this.czs = -1L;
        this.czt = -1L;
        this.czu = -1L;
        this.czG = -1L;
        this.czE = -1L;
        this.czF = -1L;
        this.czD = -1L;
        this.czH = -1L;
        this.czI = -1L;
        this.czv = -1L;
        this.czw = -1L;
        this.czx = -1L;
        this.czy = -1L;
        this.czz = -1L;
        this.czA = -1L;
        this.czB = -1L;
        this.czC = -1L;
    }
}
