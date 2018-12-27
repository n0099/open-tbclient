package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bhd = null;
    private boolean bgD = false;
    private boolean bgE = false;
    private boolean bgF = false;
    private boolean bgG = false;
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
    private long bha = -1;
    private long bhb = -1;
    private long bhc = -1;

    public boolean Pp() {
        return this.bgE;
    }

    public void cN(boolean z) {
        this.bgD = z;
    }

    public void at(long j) {
        this.bgH = j;
    }

    public long Pq() {
        return this.bgH;
    }

    public void cO(boolean z) {
        this.bgG = z;
    }

    public void au(long j) {
        this.bgI = j;
    }

    public void av(long j) {
        this.bgJ = j;
    }

    public void aw(long j) {
        this.bgK = j;
    }

    public void ax(long j) {
        this.bgO = j;
    }

    public void ay(long j) {
        this.bgN = j;
    }

    public void az(long j) {
        this.bgL = j;
    }

    public void aA(long j) {
        this.bgM = j;
    }

    public void aB(long j) {
        this.bha = j;
    }

    public void aC(long j) {
        this.bgX = j;
    }

    public void aD(long j) {
        this.bgY = j;
    }

    public void aE(long j) {
        this.bgZ = j;
    }

    public void aF(long j) {
        this.bhb = j;
    }

    public void aG(long j) {
        this.bhc = j;
        this.bgE = true;
    }

    public void aH(long j) {
        this.bgP = j;
    }

    public void aI(long j) {
        this.bgQ = j;
    }

    public void aJ(long j) {
        this.bgS = j;
    }

    public void aK(long j) {
        this.bgR = j;
    }

    public void aL(long j) {
        this.bgT = j;
    }

    public void aM(long j) {
        this.bgU = j;
    }

    public void aN(long j) {
        this.bgV = j;
    }

    public void aO(long j) {
        this.bgW = j;
    }

    public static n Pr() {
        if (bhd == null) {
            synchronized (n.class) {
                if (bhd == null) {
                    bhd = new n();
                }
            }
        }
        return bhd;
    }

    public void Ps() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bhc - this.bgH) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bgF && m.Pl().Pm()) {
            this.bgF = true;
            long j = this.bgI - this.bgH;
            long j2 = -1;
            if (this.bgY > 0) {
                j2 = this.bgZ - this.bgY;
            }
            long j3 = this.bhc - this.bhb;
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "main");
            jB.append("appc", String.valueOf(j));
            jB.append("loadclass", String.valueOf(this.bgJ));
            jB.append("sapiinit", String.valueOf(this.bgK));
            jB.append("acctinit", String.valueOf(this.bgL));
            jB.append("iminit", String.valueOf(this.bgM));
            jB.append("plugininit", String.valueOf(this.bgN));
            jB.append("patchloaded", String.valueOf(this.bgO));
            jB.append("naslibinit", String.valueOf(this.bgP));
            jB.append("websocketinit", String.valueOf(this.bgQ));
            jB.append("settinginit", String.valueOf(this.bgR));
            jB.append("toastinit", String.valueOf(this.bgS));
            jB.append("tiebastaticinit", String.valueOf(this.bgT));
            jB.append("locationinit", String.valueOf(this.bgU));
            jB.append("cdninit", String.valueOf(this.bgV));
            jB.append("messagesetinit", String.valueOf(this.bgW));
            jB.append("logores", String.valueOf(this.bha));
            if (this.bgX > 0 && this.bgY > 0 && j2 > 0) {
                jB.append("adc", String.valueOf(this.bgX));
                jB.append("adshow", String.valueOf(j2));
                jB.append("hasad", "1");
            } else {
                jB.append("hasad", "0");
            }
            jB.append("tabc", String.valueOf(j3));
            jB.append("costt", String.valueOf(this.bha + j + j3));
            jB.append("newinst", this.bgD ? "1" : "0");
            jB.f("pluginloadsync", Boolean.valueOf(this.bgG));
            BdStatisticsManager.getInstance().performance("startt", jB);
            wF();
        }
    }

    public void aP(long j) {
        if (m.Pl().Pm() && j > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "remote");
            jB.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jB);
        }
    }

    private void wF() {
        this.bgD = false;
        this.bgE = false;
        this.bgH = -1L;
        this.bgI = -1L;
        this.bgJ = -1L;
        this.bgK = -1L;
        this.bgL = -1L;
        this.bgM = -1L;
        this.bgN = -1L;
        this.bgO = -1L;
        this.bha = -1L;
        this.bgY = -1L;
        this.bgZ = -1L;
        this.bgX = -1L;
        this.bhb = -1L;
        this.bhc = -1L;
        this.bgP = -1L;
        this.bgQ = -1L;
        this.bgR = -1L;
        this.bgS = -1L;
        this.bgT = -1L;
        this.bgU = -1L;
        this.bgV = -1L;
        this.bgW = -1L;
    }
}
