package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aHJ = null;
    private boolean aHj = false;
    private boolean aHk = false;
    private boolean aHl = false;
    private boolean aHm = false;
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
    private long aHH = -1;
    private long aHI = -1;

    public boolean GL() {
        return this.aHk;
    }

    public void bY(boolean z) {
        this.aHj = z;
    }

    public void Q(long j) {
        this.aHn = j;
    }

    public void bZ(boolean z) {
        this.aHm = z;
    }

    public void R(long j) {
        this.aHo = j;
    }

    public void S(long j) {
        this.aHp = j;
    }

    public void T(long j) {
        this.aHq = j;
    }

    public void U(long j) {
        this.aHu = j;
    }

    public void V(long j) {
        this.aHt = j;
    }

    public void W(long j) {
        this.aHr = j;
    }

    public void X(long j) {
        this.aHs = j;
    }

    public void Y(long j) {
        this.aHG = j;
    }

    public void Z(long j) {
        this.aHD = j;
    }

    public void aa(long j) {
        this.aHE = j;
    }

    public void ab(long j) {
        this.aHF = j;
    }

    public void ac(long j) {
        this.aHH = j;
    }

    public void ad(long j) {
        this.aHI = j;
        this.aHk = true;
    }

    public void ae(long j) {
        this.aHv = j;
    }

    public void af(long j) {
        this.aHw = j;
    }

    public void ag(long j) {
        this.aHy = j;
    }

    public void ah(long j) {
        this.aHx = j;
    }

    public void ai(long j) {
        this.aHz = j;
    }

    public void aj(long j) {
        this.aHA = j;
    }

    public void ak(long j) {
        this.aHB = j;
    }

    public void al(long j) {
        this.aHC = j;
    }

    public static ab GM() {
        if (aHJ == null) {
            synchronized (ab.class) {
                if (aHJ == null) {
                    aHJ = new ab();
                }
            }
        }
        return aHJ;
    }

    public void GN() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aHI - this.aHn) - j;
        if (j2 > 0 && !this.aHl && aa.GG().GH()) {
            this.aHl = true;
            long j3 = this.aHo - this.aHn;
            long j4 = this.aHG - this.aHn;
            long j5 = -1;
            if (this.aHE > 0) {
                j5 = this.aHF - this.aHE;
            }
            long j6 = this.aHI - this.aHH;
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "main");
            fN.p("appc", String.valueOf(j3));
            fN.p("loadclass", String.valueOf(this.aHp));
            fN.p("sapiinit", String.valueOf(this.aHq));
            fN.p("acctinit", String.valueOf(this.aHr));
            fN.p("iminit", String.valueOf(this.aHs));
            fN.p("plugininit", String.valueOf(this.aHt));
            fN.p("patchloaded", String.valueOf(this.aHu));
            fN.p("naslibinit", String.valueOf(this.aHv));
            fN.p("websocketinit", String.valueOf(this.aHw));
            fN.p("settinginit", String.valueOf(this.aHx));
            fN.p("toastinit", String.valueOf(this.aHy));
            fN.p("tiebastaticinit", String.valueOf(this.aHz));
            fN.p("locationinit", String.valueOf(this.aHA));
            fN.p("cdninit", String.valueOf(this.aHB));
            fN.p("messagesetinit", String.valueOf(this.aHC));
            fN.p("logores", String.valueOf(j4));
            if (this.aHD > 0 && this.aHE > 0 && j5 > 0) {
                fN.p("adc", String.valueOf(this.aHD));
                fN.p("adshow", String.valueOf(j5));
                fN.p("hasad", "1");
            } else {
                fN.p("hasad", "0");
            }
            fN.p("tabc", String.valueOf(j6));
            fN.p("costt", String.valueOf(j2));
            fN.p("newinst", this.aHj ? "1" : "0");
            fN.d("pluginloadsync", Boolean.valueOf(this.aHm));
            BdStatisticsManager.getInstance().performance("startt", fN);
            ov();
        }
    }

    public void am(long j) {
        if (aa.GG().GH() && j > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "remote");
            fN.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fN);
        }
    }

    private void ov() {
        this.aHj = false;
        this.aHk = false;
        this.aHn = -1L;
        this.aHo = -1L;
        this.aHp = -1L;
        this.aHq = -1L;
        this.aHr = -1L;
        this.aHs = -1L;
        this.aHt = -1L;
        this.aHu = -1L;
        this.aHG = -1L;
        this.aHE = -1L;
        this.aHF = -1L;
        this.aHD = -1L;
        this.aHH = -1L;
        this.aHI = -1L;
        this.aHv = -1L;
        this.aHw = -1L;
        this.aHx = -1L;
        this.aHy = -1L;
        this.aHz = -1L;
        this.aHA = -1L;
        this.aHB = -1L;
        this.aHC = -1L;
    }
}
