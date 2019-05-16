package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n czI = null;
    private boolean czi = false;
    private boolean czj = false;
    private boolean czk = false;
    private boolean czl = false;
    private long czm = -1;
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

    public boolean auo() {
        return this.czj;
    }

    public void fC(boolean z) {
        this.czi = z;
    }

    public void bk(long j) {
        this.czm = j;
    }

    public long aup() {
        return this.czm;
    }

    public void fD(boolean z) {
        this.czl = z;
    }

    public void bl(long j) {
        this.czn = j;
    }

    public void bm(long j) {
        this.czo = j;
    }

    public void bn(long j) {
        this.czp = j;
    }

    public void bo(long j) {
        this.czt = j;
    }

    public void bp(long j) {
        this.czs = j;
    }

    public void bq(long j) {
        this.czq = j;
    }

    public void br(long j) {
        this.czr = j;
    }

    public void bs(long j) {
        this.czF = j;
    }

    public void bt(long j) {
        this.czC = j;
    }

    public void bu(long j) {
        this.czD = j;
    }

    public void bv(long j) {
        this.czE = j;
    }

    public void bw(long j) {
        this.czG = j;
    }

    public void bx(long j) {
        this.czH = j;
        this.czj = true;
    }

    public void by(long j) {
        this.czu = j;
    }

    public void bz(long j) {
        this.czv = j;
    }

    public void bA(long j) {
        this.czx = j;
    }

    public void bB(long j) {
        this.czw = j;
    }

    public void bC(long j) {
        this.czy = j;
    }

    public void bD(long j) {
        this.czz = j;
    }

    public void bE(long j) {
        this.czA = j;
    }

    public void bF(long j) {
        this.czB = j;
    }

    public static n auq() {
        if (czI == null) {
            synchronized (n.class) {
                if (czI == null) {
                    czI = new n();
                }
            }
        }
        return czI;
    }

    public void aur() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.czH - this.czm) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.czk && m.auk().aul()) {
            this.czk = true;
            long j = this.czn - this.czm;
            long j2 = -1;
            if (this.czD > 0) {
                j2 = this.czE - this.czD;
            }
            long j3 = this.czH - this.czG;
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("procname", "main");
            iw.append("appc", String.valueOf(j));
            iw.append("loadclass", String.valueOf(this.czo));
            iw.append("sapiinit", String.valueOf(this.czp));
            iw.append("acctinit", String.valueOf(this.czq));
            iw.append("iminit", String.valueOf(this.czr));
            iw.append("plugininit", String.valueOf(this.czs));
            iw.append("patchloaded", String.valueOf(this.czt));
            iw.append("naslibinit", String.valueOf(this.czu));
            iw.append("websocketinit", String.valueOf(this.czv));
            iw.append("settinginit", String.valueOf(this.czw));
            iw.append("toastinit", String.valueOf(this.czx));
            iw.append("tiebastaticinit", String.valueOf(this.czy));
            iw.append("locationinit", String.valueOf(this.czz));
            iw.append("cdninit", String.valueOf(this.czA));
            iw.append("messagesetinit", String.valueOf(this.czB));
            iw.append("logores", String.valueOf(this.czF));
            if (this.czC > 0 && this.czD > 0 && j2 > 0) {
                iw.append("adc", String.valueOf(this.czC));
                iw.append("adshow", String.valueOf(j2));
                iw.append("hasad", "1");
            } else {
                iw.append("hasad", "0");
            }
            iw.append("tabc", String.valueOf(j3));
            iw.append("costt", String.valueOf(this.czF + j + j3));
            iw.append("newinst", this.czi ? "1" : "0");
            iw.c("pluginloadsync", Boolean.valueOf(this.czl));
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
        this.czi = false;
        this.czj = false;
        this.czm = -1L;
        this.czn = -1L;
        this.czo = -1L;
        this.czp = -1L;
        this.czq = -1L;
        this.czr = -1L;
        this.czs = -1L;
        this.czt = -1L;
        this.czF = -1L;
        this.czD = -1L;
        this.czE = -1L;
        this.czC = -1L;
        this.czG = -1L;
        this.czH = -1L;
        this.czu = -1L;
        this.czv = -1L;
        this.czw = -1L;
        this.czx = -1L;
        this.czy = -1L;
        this.czz = -1L;
        this.czA = -1L;
        this.czB = -1L;
    }
}
