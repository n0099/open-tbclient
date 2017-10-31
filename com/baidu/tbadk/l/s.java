package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aKM = null;
    private boolean aKm = false;
    private boolean aKn = false;
    private boolean aKo = false;
    private boolean aKp = false;
    private long aKq = -1;
    private long aKr = -1;
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

    public boolean Gn() {
        return this.aKn;
    }

    public void bU(boolean z) {
        this.aKm = z;
    }

    public void T(long j) {
        this.aKq = j;
    }

    public void bV(boolean z) {
        this.aKp = z;
    }

    public void U(long j) {
        this.aKr = j;
    }

    public void V(long j) {
        this.aKs = j;
    }

    public void W(long j) {
        this.aKt = j;
    }

    public void X(long j) {
        this.aKx = j;
    }

    public void Y(long j) {
        this.aKw = j;
    }

    public void Z(long j) {
        this.aKu = j;
    }

    public void aa(long j) {
        this.aKv = j;
    }

    public void ab(long j) {
        this.aKJ = j;
    }

    public void ac(long j) {
        this.aKG = j;
    }

    public void ad(long j) {
        this.aKH = j;
    }

    public void ae(long j) {
        this.aKI = j;
    }

    public void af(long j) {
        this.aKK = j;
    }

    public void ag(long j) {
        this.aKL = j;
        this.aKn = true;
    }

    public void ah(long j) {
        this.aKy = j;
    }

    public void ai(long j) {
        this.aKz = j;
    }

    public void aj(long j) {
        this.aKB = j;
    }

    public void ak(long j) {
        this.aKA = j;
    }

    public void al(long j) {
        this.aKC = j;
    }

    public void am(long j) {
        this.aKD = j;
    }

    public void an(long j) {
        this.aKE = j;
    }

    public void ao(long j) {
        this.aKF = j;
    }

    public static s Go() {
        if (aKM == null) {
            synchronized (s.class) {
                if (aKM == null) {
                    aKM = new s();
                }
            }
        }
        return aKM;
    }

    public void Gp() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aKL - this.aKq) - j;
        if (j2 > 0 && !this.aKo && r.Gi().Gj()) {
            this.aKo = true;
            long j3 = this.aKr - this.aKq;
            long j4 = this.aKJ - this.aKq;
            long j5 = -1;
            if (this.aKH > 0) {
                j5 = this.aKI - this.aKH;
            }
            long j6 = this.aKL - this.aKK;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aKs));
            fK.p("sapiinit", String.valueOf(this.aKt));
            fK.p("acctinit", String.valueOf(this.aKu));
            fK.p("iminit", String.valueOf(this.aKv));
            fK.p("plugininit", String.valueOf(this.aKw));
            fK.p("patchloaded", String.valueOf(this.aKx));
            fK.p("naslibinit", String.valueOf(this.aKy));
            fK.p("websocketinit", String.valueOf(this.aKz));
            fK.p("settinginit", String.valueOf(this.aKA));
            fK.p("toastinit", String.valueOf(this.aKB));
            fK.p("tiebastaticinit", String.valueOf(this.aKC));
            fK.p("locationinit", String.valueOf(this.aKD));
            fK.p("cdninit", String.valueOf(this.aKE));
            fK.p("messagesetinit", String.valueOf(this.aKF));
            fK.p("logores", String.valueOf(j4));
            if (this.aKG > 0 && this.aKH > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aKG));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aKm ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aKp));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nT();
        }
    }

    public void ap(long j) {
        if (r.Gi().Gj() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nT() {
        this.aKm = false;
        this.aKn = false;
        this.aKq = -1L;
        this.aKr = -1L;
        this.aKs = -1L;
        this.aKt = -1L;
        this.aKu = -1L;
        this.aKv = -1L;
        this.aKw = -1L;
        this.aKx = -1L;
        this.aKJ = -1L;
        this.aKH = -1L;
        this.aKI = -1L;
        this.aKG = -1L;
        this.aKK = -1L;
        this.aKL = -1L;
        this.aKy = -1L;
        this.aKz = -1L;
        this.aKA = -1L;
        this.aKB = -1L;
        this.aKC = -1L;
        this.aKD = -1L;
        this.aKE = -1L;
        this.aKF = -1L;
    }
}
