package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aHA = null;
    private boolean aHa = false;
    private boolean aHb = false;
    private boolean aHc = false;
    private boolean aHd = false;
    private long aHe = -1;
    private long aHf = -1;
    private long aHg = -1;
    private long aHh = -1;
    private long aHi = -1;
    private long aHj = -1;
    private long aHk = -1;
    private long aHl = -1;
    private long aHm = -1;
    private long aHn = -1;
    private long aHo = -1;
    private long aHp = -1;
    private long aHq = -1;
    private long aHr = -1;
    private long aHs = -1;
    private long aHt = -1;
    private long aHu = -1;
    private long aHv = -1;
    private long aHw = -1;
    private long aHx = -1;
    private long aHy = -1;
    private long aHz = -1;

    public boolean FJ() {
        return this.aHb;
    }

    public void bW(boolean z) {
        this.aHa = z;
    }

    public void R(long j) {
        this.aHe = j;
    }

    public void bX(boolean z) {
        this.aHd = z;
    }

    public void S(long j) {
        this.aHf = j;
    }

    public void T(long j) {
        this.aHg = j;
    }

    public void U(long j) {
        this.aHh = j;
    }

    public void V(long j) {
        this.aHl = j;
    }

    public void W(long j) {
        this.aHk = j;
    }

    public void X(long j) {
        this.aHi = j;
    }

    public void Y(long j) {
        this.aHj = j;
    }

    public void Z(long j) {
        this.aHx = j;
    }

    public void aa(long j) {
        this.aHu = j;
    }

    public void ab(long j) {
        this.aHv = j;
    }

    public void ac(long j) {
        this.aHw = j;
    }

    public void ad(long j) {
        this.aHy = j;
    }

    public void ae(long j) {
        this.aHz = j;
        this.aHb = true;
    }

    public void af(long j) {
        this.aHm = j;
    }

    public void ag(long j) {
        this.aHn = j;
    }

    public void ah(long j) {
        this.aHp = j;
    }

    public void ai(long j) {
        this.aHo = j;
    }

    public void aj(long j) {
        this.aHq = j;
    }

    public void ak(long j) {
        this.aHr = j;
    }

    public void al(long j) {
        this.aHs = j;
    }

    public void am(long j) {
        this.aHt = j;
    }

    public static ab FK() {
        if (aHA == null) {
            synchronized (ab.class) {
                if (aHA == null) {
                    aHA = new ab();
                }
            }
        }
        return aHA;
    }

    public void FL() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aHz - this.aHe) - j;
        if (j2 > 0 && !this.aHc && aa.FE().FF()) {
            this.aHc = true;
            long j3 = this.aHf - this.aHe;
            long j4 = this.aHx - this.aHe;
            long j5 = -1;
            if (this.aHv > 0) {
                j5 = this.aHw - this.aHv;
            }
            long j6 = this.aHz - this.aHy;
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "main");
            fN.p("appc", String.valueOf(j3));
            fN.p("loadclass", String.valueOf(this.aHg));
            fN.p("sapiinit", String.valueOf(this.aHh));
            fN.p("acctinit", String.valueOf(this.aHi));
            fN.p("iminit", String.valueOf(this.aHj));
            fN.p("plugininit", String.valueOf(this.aHk));
            fN.p("patchloaded", String.valueOf(this.aHl));
            fN.p("naslibinit", String.valueOf(this.aHm));
            fN.p("websocketinit", String.valueOf(this.aHn));
            fN.p("settinginit", String.valueOf(this.aHo));
            fN.p("toastinit", String.valueOf(this.aHp));
            fN.p("tiebastaticinit", String.valueOf(this.aHq));
            fN.p("locationinit", String.valueOf(this.aHr));
            fN.p("cdninit", String.valueOf(this.aHs));
            fN.p("messagesetinit", String.valueOf(this.aHt));
            fN.p("logores", String.valueOf(j4));
            if (this.aHu > 0 && this.aHv > 0 && j5 > 0) {
                fN.p("adc", String.valueOf(this.aHu));
                fN.p("adshow", String.valueOf(j5));
                fN.p("hasad", "1");
            } else {
                fN.p("hasad", "0");
            }
            fN.p("tabc", String.valueOf(j6));
            fN.p("costt", String.valueOf(j2));
            fN.p("newinst", this.aHa ? "1" : "0");
            fN.d("pluginloadsync", Boolean.valueOf(this.aHd));
            BdStatisticsManager.getInstance().performance("startt", fN);
            nU();
        }
    }

    public void an(long j) {
        if (aa.FE().FF() && j > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "remote");
            fN.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fN);
        }
    }

    private void nU() {
        this.aHa = false;
        this.aHb = false;
        this.aHe = -1L;
        this.aHf = -1L;
        this.aHg = -1L;
        this.aHh = -1L;
        this.aHi = -1L;
        this.aHj = -1L;
        this.aHk = -1L;
        this.aHl = -1L;
        this.aHx = -1L;
        this.aHv = -1L;
        this.aHw = -1L;
        this.aHu = -1L;
        this.aHy = -1L;
        this.aHz = -1L;
        this.aHm = -1L;
        this.aHn = -1L;
        this.aHo = -1L;
        this.aHp = -1L;
        this.aHq = -1L;
        this.aHr = -1L;
        this.aHs = -1L;
        this.aHt = -1L;
    }
}
