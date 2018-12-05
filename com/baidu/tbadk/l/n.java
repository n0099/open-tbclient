package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bha = null;
    private boolean bgA = false;
    private boolean bgB = false;
    private boolean bgC = false;
    private boolean bgD = false;
    private long bgE = -1;
    private long bgF = -1;
    private long bgG = -1;
    private long bgH = -1;
    private long bgI = -1;
    private long bgJ = -1;
    private long bgK = -1;
    private long bgL = -1;
    private long bgM = -1;
    private long bgN = -1;
    private long bgO = -1;
    private long bgP = -1;
    private long bgQ = -1;
    private long bgR = -1;
    private long bgS = -1;
    private long bgT = -1;
    private long bgU = -1;
    private long bgV = -1;
    private long bgW = -1;
    private long bgX = -1;
    private long bgY = -1;
    private long bgZ = -1;

    public boolean Po() {
        return this.bgB;
    }

    public void cN(boolean z) {
        this.bgA = z;
    }

    public void as(long j) {
        this.bgE = j;
    }

    public void cO(boolean z) {
        this.bgD = z;
    }

    public void at(long j) {
        this.bgF = j;
    }

    public void au(long j) {
        this.bgG = j;
    }

    public void av(long j) {
        this.bgH = j;
    }

    public void aw(long j) {
        this.bgL = j;
    }

    public void ax(long j) {
        this.bgK = j;
    }

    public void ay(long j) {
        this.bgI = j;
    }

    public void az(long j) {
        this.bgJ = j;
    }

    public void aA(long j) {
        this.bgX = j;
    }

    public void aB(long j) {
        this.bgU = j;
    }

    public void aC(long j) {
        this.bgV = j;
    }

    public void aD(long j) {
        this.bgW = j;
    }

    public void aE(long j) {
        this.bgY = j;
    }

    public void aF(long j) {
        this.bgZ = j;
        this.bgB = true;
    }

    public void aG(long j) {
        this.bgM = j;
    }

    public void aH(long j) {
        this.bgN = j;
    }

    public void aI(long j) {
        this.bgP = j;
    }

    public void aJ(long j) {
        this.bgO = j;
    }

    public void aK(long j) {
        this.bgQ = j;
    }

    public void aL(long j) {
        this.bgR = j;
    }

    public void aM(long j) {
        this.bgS = j;
    }

    public void aN(long j) {
        this.bgT = j;
    }

    public static n Pp() {
        if (bha == null) {
            synchronized (n.class) {
                if (bha == null) {
                    bha = new n();
                }
            }
        }
        return bha;
    }

    public void Pq() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bgZ - this.bgE) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bgC && m.Pk().Pl()) {
            this.bgC = true;
            long j = this.bgF - this.bgE;
            long j2 = -1;
            if (this.bgV > 0) {
                j2 = this.bgW - this.bgV;
            }
            long j3 = this.bgZ - this.bgY;
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "main");
            jB.append("appc", String.valueOf(j));
            jB.append("loadclass", String.valueOf(this.bgG));
            jB.append("sapiinit", String.valueOf(this.bgH));
            jB.append("acctinit", String.valueOf(this.bgI));
            jB.append("iminit", String.valueOf(this.bgJ));
            jB.append("plugininit", String.valueOf(this.bgK));
            jB.append("patchloaded", String.valueOf(this.bgL));
            jB.append("naslibinit", String.valueOf(this.bgM));
            jB.append("websocketinit", String.valueOf(this.bgN));
            jB.append("settinginit", String.valueOf(this.bgO));
            jB.append("toastinit", String.valueOf(this.bgP));
            jB.append("tiebastaticinit", String.valueOf(this.bgQ));
            jB.append("locationinit", String.valueOf(this.bgR));
            jB.append("cdninit", String.valueOf(this.bgS));
            jB.append("messagesetinit", String.valueOf(this.bgT));
            jB.append("logores", String.valueOf(this.bgX));
            if (this.bgU > 0 && this.bgV > 0 && j2 > 0) {
                jB.append("adc", String.valueOf(this.bgU));
                jB.append("adshow", String.valueOf(j2));
                jB.append("hasad", "1");
            } else {
                jB.append("hasad", "0");
            }
            jB.append("tabc", String.valueOf(j3));
            jB.append("costt", String.valueOf(this.bgX + j + j3));
            jB.append("newinst", this.bgA ? "1" : "0");
            jB.f("pluginloadsync", Boolean.valueOf(this.bgD));
            BdStatisticsManager.getInstance().performance("startt", jB);
            wF();
        }
    }

    public void aO(long j) {
        if (m.Pk().Pl() && j > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "remote");
            jB.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jB);
        }
    }

    private void wF() {
        this.bgA = false;
        this.bgB = false;
        this.bgE = -1L;
        this.bgF = -1L;
        this.bgG = -1L;
        this.bgH = -1L;
        this.bgI = -1L;
        this.bgJ = -1L;
        this.bgK = -1L;
        this.bgL = -1L;
        this.bgX = -1L;
        this.bgV = -1L;
        this.bgW = -1L;
        this.bgU = -1L;
        this.bgY = -1L;
        this.bgZ = -1L;
        this.bgM = -1L;
        this.bgN = -1L;
        this.bgO = -1L;
        this.bgP = -1L;
        this.bgQ = -1L;
        this.bgR = -1L;
        this.bgS = -1L;
        this.bgT = -1L;
    }
}
