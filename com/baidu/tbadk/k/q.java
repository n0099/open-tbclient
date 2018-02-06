package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q extends o {
    private static q bBM = null;
    private boolean bBm = false;
    private boolean bBn = false;
    private boolean bBo = false;
    private boolean bBp = false;
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
    private long bBC = -1;
    private long bBD = -1;
    private long bBE = -1;
    private long bBF = -1;
    private long bBG = -1;
    private long bBH = -1;
    private long bBI = -1;
    private long bBJ = -1;
    private long bBK = -1;
    private long bBL = -1;

    public boolean OA() {
        return this.bBn;
    }

    public void cB(boolean z) {
        this.bBm = z;
    }

    public void ae(long j) {
        this.bBq = j;
    }

    public void cC(boolean z) {
        this.bBp = z;
    }

    public void af(long j) {
        this.bBr = j;
    }

    public void ag(long j) {
        this.bBs = j;
    }

    public void ah(long j) {
        this.bBt = j;
    }

    public void ai(long j) {
        this.bBx = j;
    }

    public void aj(long j) {
        this.bBw = j;
    }

    public void ak(long j) {
        this.bBu = j;
    }

    public void al(long j) {
        this.bBv = j;
    }

    public void am(long j) {
        this.bBJ = j;
    }

    public void an(long j) {
        this.bBG = j;
    }

    public void ao(long j) {
        this.bBH = j;
    }

    public void ap(long j) {
        this.bBI = j;
    }

    public void aq(long j) {
        this.bBK = j;
    }

    public void ar(long j) {
        this.bBL = j;
        this.bBn = true;
    }

    public void as(long j) {
        this.bBy = j;
    }

    public void at(long j) {
        this.bBz = j;
    }

    public void au(long j) {
        this.bBB = j;
    }

    public void av(long j) {
        this.bBA = j;
    }

    public void aw(long j) {
        this.bBC = j;
    }

    public void ax(long j) {
        this.bBD = j;
    }

    public void ay(long j) {
        this.bBE = j;
    }

    public void az(long j) {
        this.bBF = j;
    }

    public static q OB() {
        if (bBM == null) {
            synchronized (q.class) {
                if (bBM == null) {
                    bBM = new q();
                }
            }
        }
        return bBM;
    }

    public void OC() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bBL - this.bBq) - j;
        if (j2 > 0 && !this.bBo && p.Ow().Ox()) {
            this.bBo = true;
            long j3 = this.bBr - this.bBq;
            long j4 = this.bBJ - this.bBq;
            long j5 = -1;
            if (this.bBH > 0) {
                j5 = this.bBI - this.bBH;
            }
            long j6 = this.bBL - this.bBK;
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "main");
            nn.append("appc", String.valueOf(j3));
            nn.append("loadclass", String.valueOf(this.bBs));
            nn.append("sapiinit", String.valueOf(this.bBt));
            nn.append("acctinit", String.valueOf(this.bBu));
            nn.append("iminit", String.valueOf(this.bBv));
            nn.append("plugininit", String.valueOf(this.bBw));
            nn.append("patchloaded", String.valueOf(this.bBx));
            nn.append("naslibinit", String.valueOf(this.bBy));
            nn.append("websocketinit", String.valueOf(this.bBz));
            nn.append("settinginit", String.valueOf(this.bBA));
            nn.append("toastinit", String.valueOf(this.bBB));
            nn.append("tiebastaticinit", String.valueOf(this.bBC));
            nn.append("locationinit", String.valueOf(this.bBD));
            nn.append("cdninit", String.valueOf(this.bBE));
            nn.append("messagesetinit", String.valueOf(this.bBF));
            nn.append("logores", String.valueOf(j4));
            if (this.bBG > 0 && this.bBH > 0 && j5 > 0) {
                nn.append("adc", String.valueOf(this.bBG));
                nn.append("adshow", String.valueOf(j5));
                nn.append("hasad", "1");
            } else {
                nn.append("hasad", "0");
            }
            nn.append("tabc", String.valueOf(j6));
            nn.append("costt", String.valueOf(j2));
            nn.append("newinst", this.bBm ? "1" : "0");
            nn.h("pluginloadsync", Boolean.valueOf(this.bBp));
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
        this.bBm = false;
        this.bBn = false;
        this.bBq = -1L;
        this.bBr = -1L;
        this.bBs = -1L;
        this.bBt = -1L;
        this.bBu = -1L;
        this.bBv = -1L;
        this.bBw = -1L;
        this.bBx = -1L;
        this.bBJ = -1L;
        this.bBH = -1L;
        this.bBI = -1L;
        this.bBG = -1L;
        this.bBK = -1L;
        this.bBL = -1L;
        this.bBy = -1L;
        this.bBz = -1L;
        this.bBA = -1L;
        this.bBB = -1L;
        this.bBC = -1L;
        this.bBD = -1L;
        this.bBE = -1L;
        this.bBF = -1L;
    }
}
