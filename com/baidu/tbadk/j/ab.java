package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aHN = null;
    private boolean aHn = false;
    private boolean aHo = false;
    private boolean aHp = false;
    private boolean aHq = false;
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
    private long aHJ = -1;
    private long aHK = -1;
    private long aHL = -1;
    private long aHM = -1;

    public boolean FP() {
        return this.aHo;
    }

    public void bZ(boolean z) {
        this.aHn = z;
    }

    public void R(long j) {
        this.aHr = j;
    }

    public void ca(boolean z) {
        this.aHq = z;
    }

    public void S(long j) {
        this.aHs = j;
    }

    public void T(long j) {
        this.aHt = j;
    }

    public void U(long j) {
        this.aHu = j;
    }

    public void V(long j) {
        this.aHy = j;
    }

    public void W(long j) {
        this.aHx = j;
    }

    public void X(long j) {
        this.aHv = j;
    }

    public void Y(long j) {
        this.aHw = j;
    }

    public void Z(long j) {
        this.aHK = j;
    }

    public void aa(long j) {
        this.aHH = j;
    }

    public void ab(long j) {
        this.aHI = j;
    }

    public void ac(long j) {
        this.aHJ = j;
    }

    public void ad(long j) {
        this.aHL = j;
    }

    public void ae(long j) {
        this.aHM = j;
        this.aHo = true;
    }

    public void af(long j) {
        this.aHz = j;
    }

    public void ag(long j) {
        this.aHA = j;
    }

    public void ah(long j) {
        this.aHC = j;
    }

    public void ai(long j) {
        this.aHB = j;
    }

    public void aj(long j) {
        this.aHD = j;
    }

    public void ak(long j) {
        this.aHE = j;
    }

    public void al(long j) {
        this.aHF = j;
    }

    public void am(long j) {
        this.aHG = j;
    }

    public static ab FQ() {
        if (aHN == null) {
            synchronized (ab.class) {
                if (aHN == null) {
                    aHN = new ab();
                }
            }
        }
        return aHN;
    }

    public void FR() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aHM - this.aHr) - j;
        if (j2 > 0 && !this.aHp && aa.FK().FL()) {
            this.aHp = true;
            long j3 = this.aHs - this.aHr;
            long j4 = this.aHK - this.aHr;
            long j5 = -1;
            if (this.aHI > 0) {
                j5 = this.aHJ - this.aHI;
            }
            long j6 = this.aHM - this.aHL;
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "main");
            fN.p("appc", String.valueOf(j3));
            fN.p("loadclass", String.valueOf(this.aHt));
            fN.p("sapiinit", String.valueOf(this.aHu));
            fN.p("acctinit", String.valueOf(this.aHv));
            fN.p("iminit", String.valueOf(this.aHw));
            fN.p("plugininit", String.valueOf(this.aHx));
            fN.p("patchloaded", String.valueOf(this.aHy));
            fN.p("naslibinit", String.valueOf(this.aHz));
            fN.p("websocketinit", String.valueOf(this.aHA));
            fN.p("settinginit", String.valueOf(this.aHB));
            fN.p("toastinit", String.valueOf(this.aHC));
            fN.p("tiebastaticinit", String.valueOf(this.aHD));
            fN.p("locationinit", String.valueOf(this.aHE));
            fN.p("cdninit", String.valueOf(this.aHF));
            fN.p("messagesetinit", String.valueOf(this.aHG));
            fN.p("logores", String.valueOf(j4));
            if (this.aHH > 0 && this.aHI > 0 && j5 > 0) {
                fN.p("adc", String.valueOf(this.aHH));
                fN.p("adshow", String.valueOf(j5));
                fN.p("hasad", "1");
            } else {
                fN.p("hasad", "0");
            }
            fN.p("tabc", String.valueOf(j6));
            fN.p("costt", String.valueOf(j2));
            fN.p("newinst", this.aHn ? "1" : "0");
            fN.d("pluginloadsync", Boolean.valueOf(this.aHq));
            BdStatisticsManager.getInstance().performance("startt", fN);
            oc();
        }
    }

    public void an(long j) {
        if (aa.FK().FL() && j > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("procname", "remote");
            fN.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fN);
        }
    }

    private void oc() {
        this.aHn = false;
        this.aHo = false;
        this.aHr = -1L;
        this.aHs = -1L;
        this.aHt = -1L;
        this.aHu = -1L;
        this.aHv = -1L;
        this.aHw = -1L;
        this.aHx = -1L;
        this.aHy = -1L;
        this.aHK = -1L;
        this.aHI = -1L;
        this.aHJ = -1L;
        this.aHH = -1L;
        this.aHL = -1L;
        this.aHM = -1L;
        this.aHz = -1L;
        this.aHA = -1L;
        this.aHB = -1L;
        this.aHC = -1L;
        this.aHD = -1L;
        this.aHE = -1L;
        this.aHF = -1L;
        this.aHG = -1L;
    }
}
