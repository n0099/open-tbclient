package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q extends o {
    private static q aMc = null;
    private boolean aLC = false;
    private boolean aLD = false;
    private boolean aLE = false;
    private boolean aLF = false;
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
    private long aMb = -1;

    public boolean Hc() {
        return this.aLD;
    }

    public void bT(boolean z) {
        this.aLC = z;
    }

    public void W(long j) {
        this.aLG = j;
    }

    public void bU(boolean z) {
        this.aLF = z;
    }

    public void X(long j) {
        this.aLH = j;
    }

    public void Y(long j) {
        this.aLI = j;
    }

    public void Z(long j) {
        this.aLJ = j;
    }

    public void aa(long j) {
        this.aLN = j;
    }

    public void ab(long j) {
        this.aLM = j;
    }

    public void ac(long j) {
        this.aLK = j;
    }

    public void ad(long j) {
        this.aLL = j;
    }

    public void ae(long j) {
        this.aLZ = j;
    }

    public void af(long j) {
        this.aLW = j;
    }

    public void ag(long j) {
        this.aLX = j;
    }

    public void ah(long j) {
        this.aLY = j;
    }

    public void ai(long j) {
        this.aMa = j;
    }

    public void aj(long j) {
        this.aMb = j;
        this.aLD = true;
    }

    public void ak(long j) {
        this.aLO = j;
    }

    public void al(long j) {
        this.aLP = j;
    }

    public void am(long j) {
        this.aLR = j;
    }

    public void an(long j) {
        this.aLQ = j;
    }

    public void ao(long j) {
        this.aLS = j;
    }

    public void ap(long j) {
        this.aLT = j;
    }

    public void aq(long j) {
        this.aLU = j;
    }

    public void ar(long j) {
        this.aLV = j;
    }

    public static q Hd() {
        if (aMc == null) {
            synchronized (q.class) {
                if (aMc == null) {
                    aMc = new q();
                }
            }
        }
        return aMc;
    }

    public void He() {
        long j;
        long j2;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j3 = (this.aMb - this.aLG) - j;
        if (j3 > 0 && !this.aLE && p.GY().GZ()) {
            this.aLE = true;
            long j4 = this.aLH - this.aLG;
            long j5 = this.aLZ - this.aLG;
            long j6 = -1;
            if (this.aLX > 0) {
                j6 = this.aLY - this.aLX;
            }
            long j7 = this.aMb - this.aMa;
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append("procname", "main");
            fq.append("appc", String.valueOf(j4));
            fq.append("loadclass", String.valueOf(this.aLI));
            fq.append("sapiinit", String.valueOf(this.aLJ));
            fq.append("acctinit", String.valueOf(this.aLK));
            fq.append("iminit", String.valueOf(this.aLL));
            fq.append("plugininit", String.valueOf(this.aLM));
            fq.append("patchloaded", String.valueOf(this.aLN));
            fq.append("naslibinit", String.valueOf(this.aLO));
            fq.append("websocketinit", String.valueOf(this.aLP));
            fq.append("settinginit", String.valueOf(this.aLQ));
            fq.append("toastinit", String.valueOf(this.aLR));
            fq.append("tiebastaticinit", String.valueOf(this.aLS));
            fq.append("locationinit", String.valueOf(this.aLT));
            fq.append("cdninit", String.valueOf(this.aLU));
            fq.append("messagesetinit", String.valueOf(this.aLV));
            fq.append("logores", String.valueOf(j5));
            if (this.aLW > 0 && this.aLX > 0 && j6 > 0) {
                fq.append("adc", String.valueOf(this.aLW));
                fq.append("adshow", String.valueOf(j6));
                fq.append("hasad", "1");
                j2 = j3 - (j6 + this.aLW);
            } else {
                fq.append("hasad", "0");
                j2 = j3;
            }
            fq.append("tabc", String.valueOf(j7));
            fq.append("costt", String.valueOf(j2));
            fq.append("newinst", this.aLC ? "1" : "0");
            fq.f("pluginloadsync", Boolean.valueOf(this.aLF));
            BdStatisticsManager.getInstance().performance("startt", fq);
            oW();
        }
    }

    public void as(long j) {
        if (p.GY().GZ() && j > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append("procname", "remote");
            fq.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fq);
        }
    }

    private void oW() {
        this.aLC = false;
        this.aLD = false;
        this.aLG = -1L;
        this.aLH = -1L;
        this.aLI = -1L;
        this.aLJ = -1L;
        this.aLK = -1L;
        this.aLL = -1L;
        this.aLM = -1L;
        this.aLN = -1L;
        this.aLZ = -1L;
        this.aLX = -1L;
        this.aLY = -1L;
        this.aLW = -1L;
        this.aMa = -1L;
        this.aMb = -1L;
        this.aLO = -1L;
        this.aLP = -1L;
        this.aLQ = -1L;
        this.aLR = -1L;
        this.aLS = -1L;
        this.aLT = -1L;
        this.aLU = -1L;
        this.aLV = -1L;
    }
}
