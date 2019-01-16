package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bhN = null;
    private boolean bhn = false;
    private boolean bho = false;
    private boolean bhp = false;
    private boolean bhq = false;
    private long bhr = -1;
    private long bhs = -1;
    private long bht = -1;
    private long bhu = -1;
    private long bhv = -1;
    private long bhw = -1;
    private long bhx = -1;
    private long bhy = -1;
    private long bhz = -1;
    private long bhA = -1;
    private long bhB = -1;
    private long bhC = -1;
    private long bhD = -1;
    private long bhE = -1;
    private long bhF = -1;
    private long bhG = -1;
    private long bhH = -1;
    private long bhI = -1;
    private long bhJ = -1;
    private long bhK = -1;
    private long bhL = -1;
    private long bhM = -1;

    public boolean PH() {
        return this.bho;
    }

    public void cQ(boolean z) {
        this.bhn = z;
    }

    public void at(long j) {
        this.bhr = j;
    }

    public long PI() {
        return this.bhr;
    }

    public void cR(boolean z) {
        this.bhq = z;
    }

    public void au(long j) {
        this.bhs = j;
    }

    public void av(long j) {
        this.bht = j;
    }

    public void aw(long j) {
        this.bhu = j;
    }

    public void ax(long j) {
        this.bhy = j;
    }

    public void ay(long j) {
        this.bhx = j;
    }

    public void az(long j) {
        this.bhv = j;
    }

    public void aA(long j) {
        this.bhw = j;
    }

    public void aB(long j) {
        this.bhK = j;
    }

    public void aC(long j) {
        this.bhH = j;
    }

    public void aD(long j) {
        this.bhI = j;
    }

    public void aE(long j) {
        this.bhJ = j;
    }

    public void aF(long j) {
        this.bhL = j;
    }

    public void aG(long j) {
        this.bhM = j;
        this.bho = true;
    }

    public void aH(long j) {
        this.bhz = j;
    }

    public void aI(long j) {
        this.bhA = j;
    }

    public void aJ(long j) {
        this.bhC = j;
    }

    public void aK(long j) {
        this.bhB = j;
    }

    public void aL(long j) {
        this.bhD = j;
    }

    public void aM(long j) {
        this.bhE = j;
    }

    public void aN(long j) {
        this.bhF = j;
    }

    public void aO(long j) {
        this.bhG = j;
    }

    public static n PJ() {
        if (bhN == null) {
            synchronized (n.class) {
                if (bhN == null) {
                    bhN = new n();
                }
            }
        }
        return bhN;
    }

    public void PK() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bhM - this.bhr) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bhp && m.PD().PE()) {
            this.bhp = true;
            long j = this.bhs - this.bhr;
            long j2 = -1;
            if (this.bhI > 0) {
                j2 = this.bhJ - this.bhI;
            }
            long j3 = this.bhM - this.bhL;
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "main");
            jB.append("appc", String.valueOf(j));
            jB.append("loadclass", String.valueOf(this.bht));
            jB.append("sapiinit", String.valueOf(this.bhu));
            jB.append("acctinit", String.valueOf(this.bhv));
            jB.append("iminit", String.valueOf(this.bhw));
            jB.append("plugininit", String.valueOf(this.bhx));
            jB.append("patchloaded", String.valueOf(this.bhy));
            jB.append("naslibinit", String.valueOf(this.bhz));
            jB.append("websocketinit", String.valueOf(this.bhA));
            jB.append("settinginit", String.valueOf(this.bhB));
            jB.append("toastinit", String.valueOf(this.bhC));
            jB.append("tiebastaticinit", String.valueOf(this.bhD));
            jB.append("locationinit", String.valueOf(this.bhE));
            jB.append("cdninit", String.valueOf(this.bhF));
            jB.append("messagesetinit", String.valueOf(this.bhG));
            jB.append("logores", String.valueOf(this.bhK));
            if (this.bhH > 0 && this.bhI > 0 && j2 > 0) {
                jB.append("adc", String.valueOf(this.bhH));
                jB.append("adshow", String.valueOf(j2));
                jB.append("hasad", "1");
            } else {
                jB.append("hasad", "0");
            }
            jB.append("tabc", String.valueOf(j3));
            jB.append("costt", String.valueOf(this.bhK + j + j3));
            jB.append("newinst", this.bhn ? "1" : "0");
            jB.f("pluginloadsync", Boolean.valueOf(this.bhq));
            BdStatisticsManager.getInstance().performance("startt", jB);
            wM();
        }
    }

    public void aP(long j) {
        if (m.PD().PE() && j > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "remote");
            jB.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jB);
        }
    }

    private void wM() {
        this.bhn = false;
        this.bho = false;
        this.bhr = -1L;
        this.bhs = -1L;
        this.bht = -1L;
        this.bhu = -1L;
        this.bhv = -1L;
        this.bhw = -1L;
        this.bhx = -1L;
        this.bhy = -1L;
        this.bhK = -1L;
        this.bhI = -1L;
        this.bhJ = -1L;
        this.bhH = -1L;
        this.bhL = -1L;
        this.bhM = -1L;
        this.bhz = -1L;
        this.bhA = -1L;
        this.bhB = -1L;
        this.bhC = -1L;
        this.bhD = -1L;
        this.bhE = -1L;
        this.bhF = -1L;
        this.bhG = -1L;
    }
}
