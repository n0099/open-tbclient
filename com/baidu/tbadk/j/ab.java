package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aHH = null;
    private boolean aHh = false;
    private boolean aHi = false;
    private boolean aHj = false;
    private boolean aHk = false;
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
    private long aHA = -1;
    private long aHB = -1;
    private long aHC = -1;
    private long aHD = -1;
    private long aHE = -1;
    private long aHF = -1;
    private long aHG = -1;

    public boolean GL() {
        return this.aHi;
    }

    public void bY(boolean z) {
        this.aHh = z;
    }

    public void Q(long j) {
        this.aHl = j;
    }

    public void bZ(boolean z) {
        this.aHk = z;
    }

    public void R(long j) {
        this.aHm = j;
    }

    public void S(long j) {
        this.aHn = j;
    }

    public void T(long j) {
        this.aHo = j;
    }

    public void U(long j) {
        this.aHs = j;
    }

    public void V(long j) {
        this.aHr = j;
    }

    public void W(long j) {
        this.aHp = j;
    }

    public void X(long j) {
        this.aHq = j;
    }

    public void Y(long j) {
        this.aHE = j;
    }

    public void Z(long j) {
        this.aHB = j;
    }

    public void aa(long j) {
        this.aHC = j;
    }

    public void ab(long j) {
        this.aHD = j;
    }

    public void ac(long j) {
        this.aHF = j;
    }

    public void ad(long j) {
        this.aHG = j;
        this.aHi = true;
    }

    public void ae(long j) {
        this.aHt = j;
    }

    public void af(long j) {
        this.aHu = j;
    }

    public void ag(long j) {
        this.aHw = j;
    }

    public void ah(long j) {
        this.aHv = j;
    }

    public void ai(long j) {
        this.aHx = j;
    }

    public void aj(long j) {
        this.aHy = j;
    }

    public void ak(long j) {
        this.aHz = j;
    }

    public void al(long j) {
        this.aHA = j;
    }

    public static ab GM() {
        if (aHH == null) {
            synchronized (ab.class) {
                if (aHH == null) {
                    aHH = new ab();
                }
            }
        }
        return aHH;
    }

    public void GN() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aHG - this.aHl) - j;
        if (j2 > 0 && !this.aHj && aa.GG().GH()) {
            this.aHj = true;
            long j3 = this.aHm - this.aHl;
            long j4 = this.aHE - this.aHl;
            long j5 = -1;
            if (this.aHC > 0) {
                j5 = this.aHD - this.aHC;
            }
            long j6 = this.aHG - this.aHF;
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("procname", "main");
            fM.p("appc", String.valueOf(j3));
            fM.p("loadclass", String.valueOf(this.aHn));
            fM.p("sapiinit", String.valueOf(this.aHo));
            fM.p("acctinit", String.valueOf(this.aHp));
            fM.p("iminit", String.valueOf(this.aHq));
            fM.p("plugininit", String.valueOf(this.aHr));
            fM.p("patchloaded", String.valueOf(this.aHs));
            fM.p("naslibinit", String.valueOf(this.aHt));
            fM.p("websocketinit", String.valueOf(this.aHu));
            fM.p("settinginit", String.valueOf(this.aHv));
            fM.p("toastinit", String.valueOf(this.aHw));
            fM.p("tiebastaticinit", String.valueOf(this.aHx));
            fM.p("locationinit", String.valueOf(this.aHy));
            fM.p("cdninit", String.valueOf(this.aHz));
            fM.p("messagesetinit", String.valueOf(this.aHA));
            fM.p("logores", String.valueOf(j4));
            if (this.aHB > 0 && this.aHC > 0 && j5 > 0) {
                fM.p("adc", String.valueOf(this.aHB));
                fM.p("adshow", String.valueOf(j5));
                fM.p("hasad", "1");
            } else {
                fM.p("hasad", "0");
            }
            fM.p("tabc", String.valueOf(j6));
            fM.p("costt", String.valueOf(j2));
            fM.p("newinst", this.aHh ? "1" : "0");
            fM.d("pluginloadsync", Boolean.valueOf(this.aHk));
            BdStatisticsManager.getInstance().performance("startt", fM);
            ov();
        }
    }

    public void am(long j) {
        if (aa.GG().GH() && j > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("procname", "remote");
            fM.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fM);
        }
    }

    private void ov() {
        this.aHh = false;
        this.aHi = false;
        this.aHl = -1L;
        this.aHm = -1L;
        this.aHn = -1L;
        this.aHo = -1L;
        this.aHp = -1L;
        this.aHq = -1L;
        this.aHr = -1L;
        this.aHs = -1L;
        this.aHE = -1L;
        this.aHC = -1L;
        this.aHD = -1L;
        this.aHB = -1L;
        this.aHF = -1L;
        this.aHG = -1L;
        this.aHt = -1L;
        this.aHu = -1L;
        this.aHv = -1L;
        this.aHw = -1L;
        this.aHx = -1L;
        this.aHy = -1L;
        this.aHz = -1L;
        this.aHA = -1L;
    }
}
