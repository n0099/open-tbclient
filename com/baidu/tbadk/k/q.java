package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q extends o {
    private static q aMb = null;
    private boolean aLB = false;
    private boolean aLC = false;
    private boolean aLD = false;
    private boolean aLE = false;
    private long aLF = -1;
    private long aLG = -1;
    private long aLH = -1;
    private long aLI = -1;
    private long aLJ = -1;
    private long aLK = -1;
    private long aLL = -1;
    private long aLM = -1;
    private long aLN = -1;
    private long aLO = -1;
    private long aLP = -1;
    private long aLQ = -1;
    private long aLR = -1;
    private long aLS = -1;
    private long aLT = -1;
    private long aLU = -1;
    private long aLV = -1;
    private long aLW = -1;
    private long aLX = -1;
    private long aLY = -1;
    private long aLZ = -1;
    private long aMa = -1;

    public boolean He() {
        return this.aLC;
    }

    public void bT(boolean z) {
        this.aLB = z;
    }

    public void W(long j) {
        this.aLF = j;
    }

    public void bU(boolean z) {
        this.aLE = z;
    }

    public void X(long j) {
        this.aLG = j;
    }

    public void Y(long j) {
        this.aLH = j;
    }

    public void Z(long j) {
        this.aLI = j;
    }

    public void aa(long j) {
        this.aLM = j;
    }

    public void ab(long j) {
        this.aLL = j;
    }

    public void ac(long j) {
        this.aLJ = j;
    }

    public void ad(long j) {
        this.aLK = j;
    }

    public void ae(long j) {
        this.aLY = j;
    }

    public void af(long j) {
        this.aLV = j;
    }

    public void ag(long j) {
        this.aLW = j;
    }

    public void ah(long j) {
        this.aLX = j;
    }

    public void ai(long j) {
        this.aLZ = j;
    }

    public void aj(long j) {
        this.aMa = j;
        this.aLC = true;
    }

    public void ak(long j) {
        this.aLN = j;
    }

    public void al(long j) {
        this.aLO = j;
    }

    public void am(long j) {
        this.aLQ = j;
    }

    public void an(long j) {
        this.aLP = j;
    }

    public void ao(long j) {
        this.aLR = j;
    }

    public void ap(long j) {
        this.aLS = j;
    }

    public void aq(long j) {
        this.aLT = j;
    }

    public void ar(long j) {
        this.aLU = j;
    }

    public static q Hf() {
        if (aMb == null) {
            synchronized (q.class) {
                if (aMb == null) {
                    aMb = new q();
                }
            }
        }
        return aMb;
    }

    public void Hg() {
        long j;
        long j2;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j3 = (this.aMa - this.aLF) - j;
        if (j3 > 0 && !this.aLD && p.Ha().Hb()) {
            this.aLD = true;
            long j4 = this.aLG - this.aLF;
            long j5 = this.aLY - this.aLF;
            long j6 = -1;
            if (this.aLW > 0) {
                j6 = this.aLX - this.aLW;
            }
            long j7 = this.aMa - this.aLZ;
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append("procname", "main");
            fq.append("appc", String.valueOf(j4));
            fq.append("loadclass", String.valueOf(this.aLH));
            fq.append("sapiinit", String.valueOf(this.aLI));
            fq.append("acctinit", String.valueOf(this.aLJ));
            fq.append("iminit", String.valueOf(this.aLK));
            fq.append("plugininit", String.valueOf(this.aLL));
            fq.append("patchloaded", String.valueOf(this.aLM));
            fq.append("naslibinit", String.valueOf(this.aLN));
            fq.append("websocketinit", String.valueOf(this.aLO));
            fq.append("settinginit", String.valueOf(this.aLP));
            fq.append("toastinit", String.valueOf(this.aLQ));
            fq.append("tiebastaticinit", String.valueOf(this.aLR));
            fq.append("locationinit", String.valueOf(this.aLS));
            fq.append("cdninit", String.valueOf(this.aLT));
            fq.append("messagesetinit", String.valueOf(this.aLU));
            fq.append("logores", String.valueOf(j5));
            if (this.aLV > 0 && this.aLW > 0 && j6 > 0) {
                fq.append("adc", String.valueOf(this.aLV));
                fq.append("adshow", String.valueOf(j6));
                fq.append("hasad", "1");
                j2 = j3 - (j6 + this.aLV);
            } else {
                fq.append("hasad", "0");
                j2 = j3;
            }
            fq.append("tabc", String.valueOf(j7));
            fq.append("costt", String.valueOf(j2));
            fq.append("newinst", this.aLB ? "1" : "0");
            fq.f("pluginloadsync", Boolean.valueOf(this.aLE));
            BdStatisticsManager.getInstance().performance("startt", fq);
            oX();
        }
    }

    public void as(long j) {
        if (p.Ha().Hb() && j > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append("procname", "remote");
            fq.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fq);
        }
    }

    private void oX() {
        this.aLB = false;
        this.aLC = false;
        this.aLF = -1L;
        this.aLG = -1L;
        this.aLH = -1L;
        this.aLI = -1L;
        this.aLJ = -1L;
        this.aLK = -1L;
        this.aLL = -1L;
        this.aLM = -1L;
        this.aLY = -1L;
        this.aLW = -1L;
        this.aLX = -1L;
        this.aLV = -1L;
        this.aLZ = -1L;
        this.aMa = -1L;
        this.aLN = -1L;
        this.aLO = -1L;
        this.aLP = -1L;
        this.aLQ = -1L;
        this.aLR = -1L;
        this.aLS = -1L;
        this.aLT = -1L;
        this.aLU = -1L;
    }
}
