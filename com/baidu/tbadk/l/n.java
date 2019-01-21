package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bhO = null;
    private boolean bho = false;
    private boolean bhp = false;
    private boolean bhq = false;
    private boolean bhr = false;
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
    private long bhN = -1;

    public boolean PH() {
        return this.bhp;
    }

    public void cQ(boolean z) {
        this.bho = z;
    }

    public void at(long j) {
        this.bhs = j;
    }

    public long PI() {
        return this.bhs;
    }

    public void cR(boolean z) {
        this.bhr = z;
    }

    public void au(long j) {
        this.bht = j;
    }

    public void av(long j) {
        this.bhu = j;
    }

    public void aw(long j) {
        this.bhv = j;
    }

    public void ax(long j) {
        this.bhz = j;
    }

    public void ay(long j) {
        this.bhy = j;
    }

    public void az(long j) {
        this.bhw = j;
    }

    public void aA(long j) {
        this.bhx = j;
    }

    public void aB(long j) {
        this.bhL = j;
    }

    public void aC(long j) {
        this.bhI = j;
    }

    public void aD(long j) {
        this.bhJ = j;
    }

    public void aE(long j) {
        this.bhK = j;
    }

    public void aF(long j) {
        this.bhM = j;
    }

    public void aG(long j) {
        this.bhN = j;
        this.bhp = true;
    }

    public void aH(long j) {
        this.bhA = j;
    }

    public void aI(long j) {
        this.bhB = j;
    }

    public void aJ(long j) {
        this.bhD = j;
    }

    public void aK(long j) {
        this.bhC = j;
    }

    public void aL(long j) {
        this.bhE = j;
    }

    public void aM(long j) {
        this.bhF = j;
    }

    public void aN(long j) {
        this.bhG = j;
    }

    public void aO(long j) {
        this.bhH = j;
    }

    public static n PJ() {
        if (bhO == null) {
            synchronized (n.class) {
                if (bhO == null) {
                    bhO = new n();
                }
            }
        }
        return bhO;
    }

    public void PK() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bhN - this.bhs) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bhq && m.PD().PE()) {
            this.bhq = true;
            long j = this.bht - this.bhs;
            long j2 = -1;
            if (this.bhJ > 0) {
                j2 = this.bhK - this.bhJ;
            }
            long j3 = this.bhN - this.bhM;
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "main");
            jB.append("appc", String.valueOf(j));
            jB.append("loadclass", String.valueOf(this.bhu));
            jB.append("sapiinit", String.valueOf(this.bhv));
            jB.append("acctinit", String.valueOf(this.bhw));
            jB.append("iminit", String.valueOf(this.bhx));
            jB.append("plugininit", String.valueOf(this.bhy));
            jB.append("patchloaded", String.valueOf(this.bhz));
            jB.append("naslibinit", String.valueOf(this.bhA));
            jB.append("websocketinit", String.valueOf(this.bhB));
            jB.append("settinginit", String.valueOf(this.bhC));
            jB.append("toastinit", String.valueOf(this.bhD));
            jB.append("tiebastaticinit", String.valueOf(this.bhE));
            jB.append("locationinit", String.valueOf(this.bhF));
            jB.append("cdninit", String.valueOf(this.bhG));
            jB.append("messagesetinit", String.valueOf(this.bhH));
            jB.append("logores", String.valueOf(this.bhL));
            if (this.bhI > 0 && this.bhJ > 0 && j2 > 0) {
                jB.append("adc", String.valueOf(this.bhI));
                jB.append("adshow", String.valueOf(j2));
                jB.append("hasad", "1");
            } else {
                jB.append("hasad", "0");
            }
            jB.append("tabc", String.valueOf(j3));
            jB.append("costt", String.valueOf(this.bhL + j + j3));
            jB.append("newinst", this.bho ? "1" : "0");
            jB.f("pluginloadsync", Boolean.valueOf(this.bhr));
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
        this.bho = false;
        this.bhp = false;
        this.bhs = -1L;
        this.bht = -1L;
        this.bhu = -1L;
        this.bhv = -1L;
        this.bhw = -1L;
        this.bhx = -1L;
        this.bhy = -1L;
        this.bhz = -1L;
        this.bhL = -1L;
        this.bhJ = -1L;
        this.bhK = -1L;
        this.bhI = -1L;
        this.bhM = -1L;
        this.bhN = -1L;
        this.bhA = -1L;
        this.bhB = -1L;
        this.bhC = -1L;
        this.bhD = -1L;
        this.bhE = -1L;
        this.bhF = -1L;
        this.bhG = -1L;
        this.bhH = -1L;
    }
}
