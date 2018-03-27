package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q extends o {
    private static q bBC = null;
    private boolean bBc = false;
    private boolean bBd = false;
    private boolean bBe = false;
    private boolean bBf = false;
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
    private long bBz = -1;
    private long bBA = -1;
    private long bBB = -1;

    public boolean OA() {
        return this.bBd;
    }

    public void cB(boolean z) {
        this.bBc = z;
    }

    public void ae(long j) {
        this.bBg = j;
    }

    public void cC(boolean z) {
        this.bBf = z;
    }

    public void af(long j) {
        this.bBh = j;
    }

    public void ag(long j) {
        this.bBi = j;
    }

    public void ah(long j) {
        this.bBj = j;
    }

    public void ai(long j) {
        this.bBn = j;
    }

    public void aj(long j) {
        this.bBm = j;
    }

    public void ak(long j) {
        this.bBk = j;
    }

    public void al(long j) {
        this.bBl = j;
    }

    public void am(long j) {
        this.bBz = j;
    }

    public void an(long j) {
        this.bBw = j;
    }

    public void ao(long j) {
        this.bBx = j;
    }

    public void ap(long j) {
        this.bBy = j;
    }

    public void aq(long j) {
        this.bBA = j;
    }

    public void ar(long j) {
        this.bBB = j;
        this.bBd = true;
    }

    public void as(long j) {
        this.bBo = j;
    }

    public void at(long j) {
        this.bBp = j;
    }

    public void au(long j) {
        this.bBr = j;
    }

    public void av(long j) {
        this.bBq = j;
    }

    public void aw(long j) {
        this.bBs = j;
    }

    public void ax(long j) {
        this.bBt = j;
    }

    public void ay(long j) {
        this.bBu = j;
    }

    public void az(long j) {
        this.bBv = j;
    }

    public static q OB() {
        if (bBC == null) {
            synchronized (q.class) {
                if (bBC == null) {
                    bBC = new q();
                }
            }
        }
        return bBC;
    }

    public void OC() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bBB - this.bBg) - j;
        if (j2 > 0 && !this.bBe && p.Ow().Ox()) {
            this.bBe = true;
            long j3 = this.bBh - this.bBg;
            long j4 = this.bBz - this.bBg;
            long j5 = -1;
            if (this.bBx > 0) {
                j5 = this.bBy - this.bBx;
            }
            long j6 = this.bBB - this.bBA;
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "main");
            nn.append("appc", String.valueOf(j3));
            nn.append("loadclass", String.valueOf(this.bBi));
            nn.append("sapiinit", String.valueOf(this.bBj));
            nn.append("acctinit", String.valueOf(this.bBk));
            nn.append("iminit", String.valueOf(this.bBl));
            nn.append("plugininit", String.valueOf(this.bBm));
            nn.append("patchloaded", String.valueOf(this.bBn));
            nn.append("naslibinit", String.valueOf(this.bBo));
            nn.append("websocketinit", String.valueOf(this.bBp));
            nn.append("settinginit", String.valueOf(this.bBq));
            nn.append("toastinit", String.valueOf(this.bBr));
            nn.append("tiebastaticinit", String.valueOf(this.bBs));
            nn.append("locationinit", String.valueOf(this.bBt));
            nn.append("cdninit", String.valueOf(this.bBu));
            nn.append("messagesetinit", String.valueOf(this.bBv));
            nn.append("logores", String.valueOf(j4));
            if (this.bBw > 0 && this.bBx > 0 && j5 > 0) {
                nn.append("adc", String.valueOf(this.bBw));
                nn.append("adshow", String.valueOf(j5));
                nn.append("hasad", "1");
            } else {
                nn.append("hasad", "0");
            }
            nn.append("tabc", String.valueOf(j6));
            nn.append("costt", String.valueOf(j2));
            nn.append("newinst", this.bBc ? "1" : "0");
            nn.h("pluginloadsync", Boolean.valueOf(this.bBf));
            BdStatisticsManager.getInstance().performance("startt", nn);
            wn();
        }
    }

    public void aA(long j) {
        if (p.Ow().Ox() && j > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "remote");
            nn.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", nn);
        }
    }

    private void wn() {
        this.bBc = false;
        this.bBd = false;
        this.bBg = -1L;
        this.bBh = -1L;
        this.bBi = -1L;
        this.bBj = -1L;
        this.bBk = -1L;
        this.bBl = -1L;
        this.bBm = -1L;
        this.bBn = -1L;
        this.bBz = -1L;
        this.bBx = -1L;
        this.bBy = -1L;
        this.bBw = -1L;
        this.bBA = -1L;
        this.bBB = -1L;
        this.bBo = -1L;
        this.bBp = -1L;
        this.bBq = -1L;
        this.bBr = -1L;
        this.bBs = -1L;
        this.bBt = -1L;
        this.bBu = -1L;
        this.bBv = -1L;
    }
}
