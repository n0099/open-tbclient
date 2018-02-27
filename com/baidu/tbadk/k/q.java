package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q extends o {
    private static q bBz = null;
    private boolean bAZ = false;
    private boolean bBa = false;
    private boolean bBb = false;
    private boolean bBc = false;
    private long bBd = -1;
    private long bBe = -1;
    private long bBf = -1;
    private long bBg = -1;
    private long bBh = -1;
    private long bBi = -1;
    private long bBj = -1;
    private long bBk = -1;
    private long bBl = -1;
    private long bBm = -1;
    private long bBn = -1;
    private long bBo = -1;
    private long bBp = -1;
    private long bBq = -1;
    private long bBr = -1;
    private long bBs = -1;
    private long bBt = -1;
    private long bBu = -1;
    private long bBv = -1;
    private long bBw = -1;
    private long bBx = -1;
    private long bBy = -1;

    public boolean Oz() {
        return this.bBa;
    }

    public void cB(boolean z) {
        this.bAZ = z;
    }

    public void ae(long j) {
        this.bBd = j;
    }

    public void cC(boolean z) {
        this.bBc = z;
    }

    public void af(long j) {
        this.bBe = j;
    }

    public void ag(long j) {
        this.bBf = j;
    }

    public void ah(long j) {
        this.bBg = j;
    }

    public void ai(long j) {
        this.bBk = j;
    }

    public void aj(long j) {
        this.bBj = j;
    }

    public void ak(long j) {
        this.bBh = j;
    }

    public void al(long j) {
        this.bBi = j;
    }

    public void am(long j) {
        this.bBw = j;
    }

    public void an(long j) {
        this.bBt = j;
    }

    public void ao(long j) {
        this.bBu = j;
    }

    public void ap(long j) {
        this.bBv = j;
    }

    public void aq(long j) {
        this.bBx = j;
    }

    public void ar(long j) {
        this.bBy = j;
        this.bBa = true;
    }

    public void as(long j) {
        this.bBl = j;
    }

    public void at(long j) {
        this.bBm = j;
    }

    public void au(long j) {
        this.bBo = j;
    }

    public void av(long j) {
        this.bBn = j;
    }

    public void aw(long j) {
        this.bBp = j;
    }

    public void ax(long j) {
        this.bBq = j;
    }

    public void ay(long j) {
        this.bBr = j;
    }

    public void az(long j) {
        this.bBs = j;
    }

    public static q OA() {
        if (bBz == null) {
            synchronized (q.class) {
                if (bBz == null) {
                    bBz = new q();
                }
            }
        }
        return bBz;
    }

    public void OB() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bBy - this.bBd) - j;
        if (j2 > 0 && !this.bBb && p.Ov().Ow()) {
            this.bBb = true;
            long j3 = this.bBe - this.bBd;
            long j4 = this.bBw - this.bBd;
            long j5 = -1;
            if (this.bBu > 0) {
                j5 = this.bBv - this.bBu;
            }
            long j6 = this.bBy - this.bBx;
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "main");
            nn.append("appc", String.valueOf(j3));
            nn.append("loadclass", String.valueOf(this.bBf));
            nn.append("sapiinit", String.valueOf(this.bBg));
            nn.append("acctinit", String.valueOf(this.bBh));
            nn.append("iminit", String.valueOf(this.bBi));
            nn.append("plugininit", String.valueOf(this.bBj));
            nn.append("patchloaded", String.valueOf(this.bBk));
            nn.append("naslibinit", String.valueOf(this.bBl));
            nn.append("websocketinit", String.valueOf(this.bBm));
            nn.append("settinginit", String.valueOf(this.bBn));
            nn.append("toastinit", String.valueOf(this.bBo));
            nn.append("tiebastaticinit", String.valueOf(this.bBp));
            nn.append("locationinit", String.valueOf(this.bBq));
            nn.append("cdninit", String.valueOf(this.bBr));
            nn.append("messagesetinit", String.valueOf(this.bBs));
            nn.append("logores", String.valueOf(j4));
            if (this.bBt > 0 && this.bBu > 0 && j5 > 0) {
                nn.append("adc", String.valueOf(this.bBt));
                nn.append("adshow", String.valueOf(j5));
                nn.append("hasad", "1");
            } else {
                nn.append("hasad", "0");
            }
            nn.append("tabc", String.valueOf(j6));
            nn.append("costt", String.valueOf(j2));
            nn.append("newinst", this.bAZ ? "1" : "0");
            nn.h("pluginloadsync", Boolean.valueOf(this.bBc));
            BdStatisticsManager.getInstance().performance("startt", nn);
            wn();
        }
    }

    public void aA(long j) {
        if (p.Ov().Ow() && j > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "remote");
            nn.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", nn);
        }
    }

    private void wn() {
        this.bAZ = false;
        this.bBa = false;
        this.bBd = -1L;
        this.bBe = -1L;
        this.bBf = -1L;
        this.bBg = -1L;
        this.bBh = -1L;
        this.bBi = -1L;
        this.bBj = -1L;
        this.bBk = -1L;
        this.bBw = -1L;
        this.bBu = -1L;
        this.bBv = -1L;
        this.bBt = -1L;
        this.bBx = -1L;
        this.bBy = -1L;
        this.bBl = -1L;
        this.bBm = -1L;
        this.bBn = -1L;
        this.bBo = -1L;
        this.bBp = -1L;
        this.bBq = -1L;
        this.bBr = -1L;
        this.bBs = -1L;
    }
}
