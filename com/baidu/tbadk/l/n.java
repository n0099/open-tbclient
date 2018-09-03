package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n aUX = null;
    private boolean aUx = false;
    private boolean aUy = false;
    private boolean aUz = false;
    private boolean aUA = false;
    private long aUB = -1;
    private long aUC = -1;
    private long aUD = -1;
    private long aUE = -1;
    private long aUF = -1;
    private long aUG = -1;
    private long aUH = -1;
    private long aUI = -1;
    private long aUJ = -1;
    private long aUK = -1;
    private long aUL = -1;
    private long aUM = -1;
    private long aUN = -1;
    private long aUO = -1;
    private long aUP = -1;
    private long aUQ = -1;
    private long aUR = -1;
    private long aUS = -1;
    private long aUT = -1;
    private long aUU = -1;
    private long aUV = -1;
    private long aUW = -1;

    public boolean KN() {
        return this.aUy;
    }

    public void ca(boolean z) {
        this.aUx = z;
    }

    public void ad(long j) {
        this.aUB = j;
    }

    public void cb(boolean z) {
        this.aUA = z;
    }

    public void ae(long j) {
        this.aUC = j;
    }

    public void af(long j) {
        this.aUD = j;
    }

    public void ag(long j) {
        this.aUE = j;
    }

    public void ah(long j) {
        this.aUI = j;
    }

    public void ai(long j) {
        this.aUH = j;
    }

    public void aj(long j) {
        this.aUF = j;
    }

    public void ak(long j) {
        this.aUG = j;
    }

    public void al(long j) {
        this.aUU = j;
    }

    public void am(long j) {
        this.aUR = j;
    }

    public void an(long j) {
        this.aUS = j;
    }

    public void ao(long j) {
        this.aUT = j;
    }

    public void ap(long j) {
        this.aUV = j;
    }

    public void aq(long j) {
        this.aUW = j;
        this.aUy = true;
    }

    public void ar(long j) {
        this.aUJ = j;
    }

    public void as(long j) {
        this.aUK = j;
    }

    public void at(long j) {
        this.aUM = j;
    }

    public void au(long j) {
        this.aUL = j;
    }

    public void av(long j) {
        this.aUN = j;
    }

    public void aw(long j) {
        this.aUO = j;
    }

    public void ax(long j) {
        this.aUP = j;
    }

    public void ay(long j) {
        this.aUQ = j;
    }

    public static n KO() {
        if (aUX == null) {
            synchronized (n.class) {
                if (aUX == null) {
                    aUX = new n();
                }
            }
        }
        return aUX;
    }

    public void KP() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.aUW - this.aUB) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.aUz && m.KJ().KK()) {
            this.aUz = true;
            long j = this.aUC - this.aUB;
            long j2 = -1;
            if (this.aUS > 0) {
                j2 = this.aUT - this.aUS;
            }
            long j3 = this.aUW - this.aUV;
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append("procname", "main");
            ii.append("appc", String.valueOf(j));
            ii.append("loadclass", String.valueOf(this.aUD));
            ii.append("sapiinit", String.valueOf(this.aUE));
            ii.append("acctinit", String.valueOf(this.aUF));
            ii.append("iminit", String.valueOf(this.aUG));
            ii.append("plugininit", String.valueOf(this.aUH));
            ii.append("patchloaded", String.valueOf(this.aUI));
            ii.append("naslibinit", String.valueOf(this.aUJ));
            ii.append("websocketinit", String.valueOf(this.aUK));
            ii.append("settinginit", String.valueOf(this.aUL));
            ii.append("toastinit", String.valueOf(this.aUM));
            ii.append("tiebastaticinit", String.valueOf(this.aUN));
            ii.append("locationinit", String.valueOf(this.aUO));
            ii.append("cdninit", String.valueOf(this.aUP));
            ii.append("messagesetinit", String.valueOf(this.aUQ));
            ii.append("logores", String.valueOf(this.aUU));
            if (this.aUR > 0 && this.aUS > 0 && j2 > 0) {
                ii.append("adc", String.valueOf(this.aUR));
                ii.append("adshow", String.valueOf(j2));
                ii.append("hasad", "1");
            } else {
                ii.append("hasad", "0");
            }
            ii.append("tabc", String.valueOf(j3));
            ii.append("costt", String.valueOf(this.aUU + j + j3));
            ii.append("newinst", this.aUx ? "1" : "0");
            ii.f("pluginloadsync", Boolean.valueOf(this.aUA));
            BdStatisticsManager.getInstance().performance("startt", ii);
            sb();
        }
    }

    public void az(long j) {
        if (m.KJ().KK() && j > 0) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append("procname", "remote");
            ii.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", ii);
        }
    }

    private void sb() {
        this.aUx = false;
        this.aUy = false;
        this.aUB = -1L;
        this.aUC = -1L;
        this.aUD = -1L;
        this.aUE = -1L;
        this.aUF = -1L;
        this.aUG = -1L;
        this.aUH = -1L;
        this.aUI = -1L;
        this.aUU = -1L;
        this.aUS = -1L;
        this.aUT = -1L;
        this.aUR = -1L;
        this.aUV = -1L;
        this.aUW = -1L;
        this.aUJ = -1L;
        this.aUK = -1L;
        this.aUL = -1L;
        this.aUM = -1L;
        this.aUN = -1L;
        this.aUO = -1L;
        this.aUP = -1L;
        this.aUQ = -1L;
    }
}
