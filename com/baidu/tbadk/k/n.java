package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n aUW = null;
    private boolean aUw = false;
    private boolean aUx = false;
    private boolean aUy = false;
    private boolean aUz = false;
    private long aUA = -1;
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

    public boolean KO() {
        return this.aUx;
    }

    public void cb(boolean z) {
        this.aUw = z;
    }

    public void ab(long j) {
        this.aUA = j;
    }

    public void cc(boolean z) {
        this.aUz = z;
    }

    public void ac(long j) {
        this.aUB = j;
    }

    public void ad(long j) {
        this.aUC = j;
    }

    public void ae(long j) {
        this.aUD = j;
    }

    public void af(long j) {
        this.aUH = j;
    }

    public void ag(long j) {
        this.aUG = j;
    }

    public void ah(long j) {
        this.aUE = j;
    }

    public void ai(long j) {
        this.aUF = j;
    }

    public void aj(long j) {
        this.aUT = j;
    }

    public void ak(long j) {
        this.aUQ = j;
    }

    public void al(long j) {
        this.aUR = j;
    }

    public void am(long j) {
        this.aUS = j;
    }

    public void an(long j) {
        this.aUU = j;
    }

    public void ao(long j) {
        this.aUV = j;
        this.aUx = true;
    }

    public void ap(long j) {
        this.aUI = j;
    }

    public void aq(long j) {
        this.aUJ = j;
    }

    public void ar(long j) {
        this.aUL = j;
    }

    public void as(long j) {
        this.aUK = j;
    }

    public void at(long j) {
        this.aUM = j;
    }

    public void au(long j) {
        this.aUN = j;
    }

    public void av(long j) {
        this.aUO = j;
    }

    public void aw(long j) {
        this.aUP = j;
    }

    public static n KP() {
        if (aUW == null) {
            synchronized (n.class) {
                if (aUW == null) {
                    aUW = new n();
                }
            }
        }
        return aUW;
    }

    public void KQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.aUV - this.aUA) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.aUy && m.KK().KL()) {
            this.aUy = true;
            long j = this.aUB - this.aUA;
            long j2 = -1;
            if (this.aUR > 0) {
                j2 = this.aUS - this.aUR;
            }
            long j3 = this.aUV - this.aUU;
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append("procname", "main");
            ih.append("appc", String.valueOf(j));
            ih.append("loadclass", String.valueOf(this.aUC));
            ih.append("sapiinit", String.valueOf(this.aUD));
            ih.append("acctinit", String.valueOf(this.aUE));
            ih.append("iminit", String.valueOf(this.aUF));
            ih.append("plugininit", String.valueOf(this.aUG));
            ih.append("patchloaded", String.valueOf(this.aUH));
            ih.append("naslibinit", String.valueOf(this.aUI));
            ih.append("websocketinit", String.valueOf(this.aUJ));
            ih.append("settinginit", String.valueOf(this.aUK));
            ih.append("toastinit", String.valueOf(this.aUL));
            ih.append("tiebastaticinit", String.valueOf(this.aUM));
            ih.append("locationinit", String.valueOf(this.aUN));
            ih.append("cdninit", String.valueOf(this.aUO));
            ih.append("messagesetinit", String.valueOf(this.aUP));
            ih.append("logores", String.valueOf(this.aUT));
            if (this.aUQ > 0 && this.aUR > 0 && j2 > 0) {
                ih.append("adc", String.valueOf(this.aUQ));
                ih.append("adshow", String.valueOf(j2));
                ih.append("hasad", "1");
            } else {
                ih.append("hasad", "0");
            }
            ih.append("tabc", String.valueOf(j3));
            ih.append("costt", String.valueOf(this.aUT + j + j3));
            ih.append("newinst", this.aUw ? "1" : "0");
            ih.f("pluginloadsync", Boolean.valueOf(this.aUz));
            BdStatisticsManager.getInstance().performance("startt", ih);
            sr();
        }
    }

    public void ax(long j) {
        if (m.KK().KL() && j > 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append("procname", "remote");
            ih.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", ih);
        }
    }

    private void sr() {
        this.aUw = false;
        this.aUx = false;
        this.aUA = -1L;
        this.aUB = -1L;
        this.aUC = -1L;
        this.aUD = -1L;
        this.aUE = -1L;
        this.aUF = -1L;
        this.aUG = -1L;
        this.aUH = -1L;
        this.aUT = -1L;
        this.aUR = -1L;
        this.aUS = -1L;
        this.aUQ = -1L;
        this.aUU = -1L;
        this.aUV = -1L;
        this.aUI = -1L;
        this.aUJ = -1L;
        this.aUK = -1L;
        this.aUL = -1L;
        this.aUM = -1L;
        this.aUN = -1L;
        this.aUO = -1L;
        this.aUP = -1L;
    }
}
