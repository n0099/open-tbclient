package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aCa = null;
    private boolean aBA = false;
    private boolean aBB = false;
    private boolean aBC = false;
    private boolean aBD = false;
    private long aBE = -1;
    private long aBF = -1;
    private long aBG = -1;
    private long aBH = -1;
    private long aBI = -1;
    private long aBJ = -1;
    private long aBK = -1;
    private long aBL = -1;
    private long aBM = -1;
    private long aBN = -1;
    private long aBO = -1;
    private long aBP = -1;
    private long aBQ = -1;
    private long aBR = -1;
    private long aBS = -1;
    private long aBT = -1;
    private long aBU = -1;
    private long aBV = -1;
    private long aBW = -1;
    private long aBX = -1;
    private long aBY = -1;
    private long aBZ = -1;

    public boolean FT() {
        return this.aBB;
    }

    public void bX(boolean z) {
        this.aBA = z;
    }

    public void Q(long j) {
        this.aBE = j;
    }

    public void bY(boolean z) {
        this.aBD = z;
    }

    public void R(long j) {
        this.aBF = j;
    }

    public void S(long j) {
        this.aBG = j;
    }

    public void T(long j) {
        this.aBH = j;
    }

    public void U(long j) {
        this.aBL = j;
    }

    public void V(long j) {
        this.aBK = j;
    }

    public void W(long j) {
        this.aBI = j;
    }

    public void X(long j) {
        this.aBJ = j;
    }

    public void Y(long j) {
        this.aBX = j;
    }

    public void Z(long j) {
        this.aBU = j;
    }

    public void aa(long j) {
        this.aBV = j;
    }

    public void ab(long j) {
        this.aBW = j;
    }

    public void ac(long j) {
        this.aBY = j;
    }

    public void ad(long j) {
        this.aBZ = j;
        this.aBB = true;
    }

    public void ae(long j) {
        this.aBM = j;
    }

    public void af(long j) {
        this.aBN = j;
    }

    public void ag(long j) {
        this.aBP = j;
    }

    public void ah(long j) {
        this.aBO = j;
    }

    public void ai(long j) {
        this.aBQ = j;
    }

    public void aj(long j) {
        this.aBR = j;
    }

    public void ak(long j) {
        this.aBS = j;
    }

    public void al(long j) {
        this.aBT = j;
    }

    public static ab FU() {
        if (aCa == null) {
            synchronized (ab.class) {
                if (aCa == null) {
                    aCa = new ab();
                }
            }
        }
        return aCa;
    }

    public void FV() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aBZ - this.aBE) - j;
        if (j2 > 0 && !this.aBC && aa.FO().FP()) {
            this.aBC = true;
            long j3 = this.aBF - this.aBE;
            long j4 = this.aBX - this.aBE;
            long j5 = -1;
            if (this.aBV > 0) {
                j5 = this.aBW - this.aBV;
            }
            long j6 = this.aBZ - this.aBY;
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("procname", "main");
            ez.q("appc", String.valueOf(j3));
            ez.q("loadclass", String.valueOf(this.aBG));
            ez.q("sapiinit", String.valueOf(this.aBH));
            ez.q("acctinit", String.valueOf(this.aBI));
            ez.q("iminit", String.valueOf(this.aBJ));
            ez.q("plugininit", String.valueOf(this.aBK));
            ez.q("patchloaded", String.valueOf(this.aBL));
            ez.q("naslibinit", String.valueOf(this.aBM));
            ez.q("websocketinit", String.valueOf(this.aBN));
            ez.q("settinginit", String.valueOf(this.aBO));
            ez.q("toastinit", String.valueOf(this.aBP));
            ez.q("tiebastaticinit", String.valueOf(this.aBQ));
            ez.q("locationinit", String.valueOf(this.aBR));
            ez.q("cdninit", String.valueOf(this.aBS));
            ez.q("messagesetinit", String.valueOf(this.aBT));
            ez.q("logores", String.valueOf(j4));
            if (this.aBU > 0 && this.aBV > 0 && j5 > 0) {
                ez.q("adc", String.valueOf(this.aBU));
                ez.q("adshow", String.valueOf(j5));
                ez.q("hasad", "1");
            } else {
                ez.q("hasad", "0");
            }
            ez.q("tabc", String.valueOf(j6));
            ez.q("costt", String.valueOf(j2));
            ez.q("newinst", this.aBA ? "1" : "0");
            ez.d("pluginloadsync", Boolean.valueOf(this.aBD));
            com.baidu.adp.lib.stats.a.eG().a("startt", ez);
            nK();
        }
    }

    public void am(long j) {
        if (aa.FO().FP() && j > 0) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("procname", "remote");
            ez.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eG().a("startt", ez);
        }
    }

    private void nK() {
        this.aBA = false;
        this.aBB = false;
        this.aBE = -1L;
        this.aBF = -1L;
        this.aBG = -1L;
        this.aBH = -1L;
        this.aBI = -1L;
        this.aBJ = -1L;
        this.aBK = -1L;
        this.aBL = -1L;
        this.aBX = -1L;
        this.aBV = -1L;
        this.aBW = -1L;
        this.aBU = -1L;
        this.aBY = -1L;
        this.aBZ = -1L;
        this.aBM = -1L;
        this.aBN = -1L;
        this.aBO = -1L;
        this.aBP = -1L;
        this.aBQ = -1L;
        this.aBR = -1L;
        this.aBS = -1L;
        this.aBT = -1L;
    }
}
