package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aKO = null;
    private boolean aKo = false;
    private boolean aKp = false;
    private boolean aKq = false;
    private boolean aKr = false;
    private long aKs = -1;
    private long aKt = -1;
    private long aKu = -1;
    private long aKv = -1;
    private long aKw = -1;
    private long aKx = -1;
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

    public boolean GC() {
        return this.aKp;
    }

    public void cb(boolean z) {
        this.aKo = z;
    }

    public void S(long j) {
        this.aKs = j;
    }

    public void cc(boolean z) {
        this.aKr = z;
    }

    public void T(long j) {
        this.aKt = j;
    }

    public void U(long j) {
        this.aKu = j;
    }

    public void V(long j) {
        this.aKv = j;
    }

    public void W(long j) {
        this.aKz = j;
    }

    public void X(long j) {
        this.aKy = j;
    }

    public void Y(long j) {
        this.aKw = j;
    }

    public void Z(long j) {
        this.aKx = j;
    }

    public void aa(long j) {
        this.aKL = j;
    }

    public void ab(long j) {
        this.aKI = j;
    }

    public void ac(long j) {
        this.aKJ = j;
    }

    public void ad(long j) {
        this.aKK = j;
    }

    public void ae(long j) {
        this.aKM = j;
    }

    public void af(long j) {
        this.aKN = j;
        this.aKp = true;
    }

    public void ag(long j) {
        this.aKA = j;
    }

    public void ah(long j) {
        this.aKB = j;
    }

    public void ai(long j) {
        this.aKD = j;
    }

    public void aj(long j) {
        this.aKC = j;
    }

    public void ak(long j) {
        this.aKE = j;
    }

    public void al(long j) {
        this.aKF = j;
    }

    public void am(long j) {
        this.aKG = j;
    }

    public void an(long j) {
        this.aKH = j;
    }

    public static s GD() {
        if (aKO == null) {
            synchronized (s.class) {
                if (aKO == null) {
                    aKO = new s();
                }
            }
        }
        return aKO;
    }

    public void GE() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aKN - this.aKs) - j;
        if (j2 > 0 && !this.aKq && r.Gx().Gy()) {
            this.aKq = true;
            long j3 = this.aKt - this.aKs;
            long j4 = this.aKL - this.aKs;
            long j5 = -1;
            if (this.aKJ > 0) {
                j5 = this.aKK - this.aKJ;
            }
            long j6 = this.aKN - this.aKM;
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("procname", "main");
            fL.p("appc", String.valueOf(j3));
            fL.p("loadclass", String.valueOf(this.aKu));
            fL.p("sapiinit", String.valueOf(this.aKv));
            fL.p("acctinit", String.valueOf(this.aKw));
            fL.p("iminit", String.valueOf(this.aKx));
            fL.p("plugininit", String.valueOf(this.aKy));
            fL.p("patchloaded", String.valueOf(this.aKz));
            fL.p("naslibinit", String.valueOf(this.aKA));
            fL.p("websocketinit", String.valueOf(this.aKB));
            fL.p("settinginit", String.valueOf(this.aKC));
            fL.p("toastinit", String.valueOf(this.aKD));
            fL.p("tiebastaticinit", String.valueOf(this.aKE));
            fL.p("locationinit", String.valueOf(this.aKF));
            fL.p("cdninit", String.valueOf(this.aKG));
            fL.p("messagesetinit", String.valueOf(this.aKH));
            fL.p("logores", String.valueOf(j4));
            if (this.aKI > 0 && this.aKJ > 0 && j5 > 0) {
                fL.p("adc", String.valueOf(this.aKI));
                fL.p("adshow", String.valueOf(j5));
                fL.p("hasad", "1");
            } else {
                fL.p("hasad", "0");
            }
            fL.p("tabc", String.valueOf(j6));
            fL.p("costt", String.valueOf(j2));
            fL.p("newinst", this.aKo ? "1" : "0");
            fL.c("pluginloadsync", Boolean.valueOf(this.aKr));
            BdStatisticsManager.getInstance().performance("startt", fL);
            nX();
        }
    }

    public void ao(long j) {
        if (r.Gx().Gy() && j > 0) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("procname", "remote");
            fL.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fL);
        }
    }

    private void nX() {
        this.aKo = false;
        this.aKp = false;
        this.aKs = -1L;
        this.aKt = -1L;
        this.aKu = -1L;
        this.aKv = -1L;
        this.aKw = -1L;
        this.aKx = -1L;
        this.aKy = -1L;
        this.aKz = -1L;
        this.aKL = -1L;
        this.aKJ = -1L;
        this.aKK = -1L;
        this.aKI = -1L;
        this.aKM = -1L;
        this.aKN = -1L;
        this.aKA = -1L;
        this.aKB = -1L;
        this.aKC = -1L;
        this.aKD = -1L;
        this.aKE = -1L;
        this.aKF = -1L;
        this.aKG = -1L;
        this.aKH = -1L;
    }
}
