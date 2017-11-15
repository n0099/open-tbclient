package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aKU = null;
    private boolean aKu = false;
    private boolean aKv = false;
    private boolean aKw = false;
    private boolean aKx = false;
    private long aKy = -1;
    private long aKz = -1;
    private long aKA = -1;
    private long aKB = -1;
    private long aKC = -1;
    private long aKD = -1;
    private long aKE = -1;
    private long aKF = -1;
    private long aKG = -1;
    private long aKH = -1;
    private long aKI = -1;
    private long aKJ = -1;
    private long aKK = -1;
    private long aKL = -1;
    private long aKM = -1;
    private long aKN = -1;
    private long aKO = -1;
    private long aKP = -1;
    private long aKQ = -1;
    private long aKR = -1;
    private long aKS = -1;
    private long aKT = -1;

    public boolean Gy() {
        return this.aKv;
    }

    public void bV(boolean z) {
        this.aKu = z;
    }

    public void T(long j) {
        this.aKy = j;
    }

    public void bW(boolean z) {
        this.aKx = z;
    }

    public void U(long j) {
        this.aKz = j;
    }

    public void V(long j) {
        this.aKA = j;
    }

    public void W(long j) {
        this.aKB = j;
    }

    public void X(long j) {
        this.aKF = j;
    }

    public void Y(long j) {
        this.aKE = j;
    }

    public void Z(long j) {
        this.aKC = j;
    }

    public void aa(long j) {
        this.aKD = j;
    }

    public void ab(long j) {
        this.aKR = j;
    }

    public void ac(long j) {
        this.aKO = j;
    }

    public void ad(long j) {
        this.aKP = j;
    }

    public void ae(long j) {
        this.aKQ = j;
    }

    public void af(long j) {
        this.aKS = j;
    }

    public void ag(long j) {
        this.aKT = j;
        this.aKv = true;
    }

    public void ah(long j) {
        this.aKG = j;
    }

    public void ai(long j) {
        this.aKH = j;
    }

    public void aj(long j) {
        this.aKJ = j;
    }

    public void ak(long j) {
        this.aKI = j;
    }

    public void al(long j) {
        this.aKK = j;
    }

    public void am(long j) {
        this.aKL = j;
    }

    public void an(long j) {
        this.aKM = j;
    }

    public void ao(long j) {
        this.aKN = j;
    }

    public static s Gz() {
        if (aKU == null) {
            synchronized (s.class) {
                if (aKU == null) {
                    aKU = new s();
                }
            }
        }
        return aKU;
    }

    public void GA() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aKT - this.aKy) - j;
        if (j2 > 0 && !this.aKw && r.Gt().Gu()) {
            this.aKw = true;
            long j3 = this.aKz - this.aKy;
            long j4 = this.aKR - this.aKy;
            long j5 = -1;
            if (this.aKP > 0) {
                j5 = this.aKQ - this.aKP;
            }
            long j6 = this.aKT - this.aKS;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aKA));
            fK.p("sapiinit", String.valueOf(this.aKB));
            fK.p("acctinit", String.valueOf(this.aKC));
            fK.p("iminit", String.valueOf(this.aKD));
            fK.p("plugininit", String.valueOf(this.aKE));
            fK.p("patchloaded", String.valueOf(this.aKF));
            fK.p("naslibinit", String.valueOf(this.aKG));
            fK.p("websocketinit", String.valueOf(this.aKH));
            fK.p("settinginit", String.valueOf(this.aKI));
            fK.p("toastinit", String.valueOf(this.aKJ));
            fK.p("tiebastaticinit", String.valueOf(this.aKK));
            fK.p("locationinit", String.valueOf(this.aKL));
            fK.p("cdninit", String.valueOf(this.aKM));
            fK.p("messagesetinit", String.valueOf(this.aKN));
            fK.p("logores", String.valueOf(j4));
            if (this.aKO > 0 && this.aKP > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aKO));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aKu ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aKx));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nT();
        }
    }

    public void ap(long j) {
        if (r.Gt().Gu() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nT() {
        this.aKu = false;
        this.aKv = false;
        this.aKy = -1L;
        this.aKz = -1L;
        this.aKA = -1L;
        this.aKB = -1L;
        this.aKC = -1L;
        this.aKD = -1L;
        this.aKE = -1L;
        this.aKF = -1L;
        this.aKR = -1L;
        this.aKP = -1L;
        this.aKQ = -1L;
        this.aKO = -1L;
        this.aKS = -1L;
        this.aKT = -1L;
        this.aKG = -1L;
        this.aKH = -1L;
        this.aKI = -1L;
        this.aKJ = -1L;
        this.aKK = -1L;
        this.aKL = -1L;
        this.aKM = -1L;
        this.aKN = -1L;
    }
}
