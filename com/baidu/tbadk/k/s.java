package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aKc = null;
    private boolean aJC = false;
    private boolean aJD = false;
    private boolean aJE = false;
    private boolean aJF = false;
    private long aJG = -1;
    private long aJH = -1;
    private long aJI = -1;
    private long aJJ = -1;
    private long aJK = -1;
    private long aJL = -1;
    private long aJM = -1;
    private long aJN = -1;
    private long aJO = -1;
    private long aJP = -1;
    private long aJQ = -1;
    private long aJR = -1;
    private long aJS = -1;
    private long aJT = -1;
    private long aJU = -1;
    private long aJV = -1;
    private long aJW = -1;
    private long aJX = -1;
    private long aJY = -1;
    private long aJZ = -1;
    private long aKa = -1;
    private long aKb = -1;

    public boolean Gb() {
        return this.aJD;
    }

    public void bZ(boolean z) {
        this.aJC = z;
    }

    public void T(long j) {
        this.aJG = j;
    }

    public void ca(boolean z) {
        this.aJF = z;
    }

    public void U(long j) {
        this.aJH = j;
    }

    public void V(long j) {
        this.aJI = j;
    }

    public void W(long j) {
        this.aJJ = j;
    }

    public void X(long j) {
        this.aJN = j;
    }

    public void Y(long j) {
        this.aJM = j;
    }

    public void Z(long j) {
        this.aJK = j;
    }

    public void aa(long j) {
        this.aJL = j;
    }

    public void ab(long j) {
        this.aJZ = j;
    }

    public void ac(long j) {
        this.aJW = j;
    }

    public void ad(long j) {
        this.aJX = j;
    }

    public void ae(long j) {
        this.aJY = j;
    }

    public void af(long j) {
        this.aKa = j;
    }

    public void ag(long j) {
        this.aKb = j;
        this.aJD = true;
    }

    public void ah(long j) {
        this.aJO = j;
    }

    public void ai(long j) {
        this.aJP = j;
    }

    public void aj(long j) {
        this.aJR = j;
    }

    public void ak(long j) {
        this.aJQ = j;
    }

    public void al(long j) {
        this.aJS = j;
    }

    public void am(long j) {
        this.aJT = j;
    }

    public void an(long j) {
        this.aJU = j;
    }

    public void ao(long j) {
        this.aJV = j;
    }

    public static s Gc() {
        if (aKc == null) {
            synchronized (s.class) {
                if (aKc == null) {
                    aKc = new s();
                }
            }
        }
        return aKc;
    }

    public void Gd() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aKb - this.aJG) - j;
        if (j2 > 0 && !this.aJE && r.FW().FX()) {
            this.aJE = true;
            long j3 = this.aJH - this.aJG;
            long j4 = this.aJZ - this.aJG;
            long j5 = -1;
            if (this.aJX > 0) {
                j5 = this.aJY - this.aJX;
            }
            long j6 = this.aKb - this.aKa;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aJI));
            fK.p("sapiinit", String.valueOf(this.aJJ));
            fK.p("acctinit", String.valueOf(this.aJK));
            fK.p("iminit", String.valueOf(this.aJL));
            fK.p("plugininit", String.valueOf(this.aJM));
            fK.p("patchloaded", String.valueOf(this.aJN));
            fK.p("naslibinit", String.valueOf(this.aJO));
            fK.p("websocketinit", String.valueOf(this.aJP));
            fK.p("settinginit", String.valueOf(this.aJQ));
            fK.p("toastinit", String.valueOf(this.aJR));
            fK.p("tiebastaticinit", String.valueOf(this.aJS));
            fK.p("locationinit", String.valueOf(this.aJT));
            fK.p("cdninit", String.valueOf(this.aJU));
            fK.p("messagesetinit", String.valueOf(this.aJV));
            fK.p("logores", String.valueOf(j4));
            if (this.aJW > 0 && this.aJX > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aJW));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aJC ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aJF));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nQ();
        }
    }

    public void ap(long j) {
        if (r.FW().FX() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nQ() {
        this.aJC = false;
        this.aJD = false;
        this.aJG = -1L;
        this.aJH = -1L;
        this.aJI = -1L;
        this.aJJ = -1L;
        this.aJK = -1L;
        this.aJL = -1L;
        this.aJM = -1L;
        this.aJN = -1L;
        this.aJZ = -1L;
        this.aJX = -1L;
        this.aJY = -1L;
        this.aJW = -1L;
        this.aKa = -1L;
        this.aKb = -1L;
        this.aJO = -1L;
        this.aJP = -1L;
        this.aJQ = -1L;
        this.aJR = -1L;
        this.aJS = -1L;
        this.aJT = -1L;
        this.aJU = -1L;
        this.aJV = -1L;
    }
}
