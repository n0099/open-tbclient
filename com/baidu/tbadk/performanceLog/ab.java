package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aHs = null;
    private boolean aGS = false;
    private boolean aGT = false;
    private boolean aGU = false;
    private boolean aGV = false;
    private long aGW = -1;
    private long aGX = -1;
    private long aGY = -1;
    private long aGZ = -1;
    private long aHa = -1;
    private long aHb = -1;
    private long aHc = -1;
    private long aHd = -1;
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

    public boolean Gn() {
        return this.aGT;
    }

    public void bW(boolean z) {
        this.aGS = z;
    }

    public void Q(long j) {
        this.aGW = j;
    }

    public void bX(boolean z) {
        this.aGV = z;
    }

    public void R(long j) {
        this.aGX = j;
    }

    public void S(long j) {
        this.aGY = j;
    }

    public void T(long j) {
        this.aGZ = j;
    }

    public void U(long j) {
        this.aHd = j;
    }

    public void V(long j) {
        this.aHc = j;
    }

    public void W(long j) {
        this.aHa = j;
    }

    public void X(long j) {
        this.aHb = j;
    }

    public void Y(long j) {
        this.aHp = j;
    }

    public void Z(long j) {
        this.aHm = j;
    }

    public void aa(long j) {
        this.aHn = j;
    }

    public void ab(long j) {
        this.aHo = j;
    }

    public void ac(long j) {
        this.aHq = j;
    }

    public void ad(long j) {
        this.aHr = j;
        this.aGT = true;
    }

    public void ae(long j) {
        this.aHe = j;
    }

    public void af(long j) {
        this.aHf = j;
    }

    public void ag(long j) {
        this.aHh = j;
    }

    public void ah(long j) {
        this.aHg = j;
    }

    public void ai(long j) {
        this.aHi = j;
    }

    public void aj(long j) {
        this.aHj = j;
    }

    public void ak(long j) {
        this.aHk = j;
    }

    public void al(long j) {
        this.aHl = j;
    }

    public static ab Go() {
        if (aHs == null) {
            synchronized (ab.class) {
                if (aHs == null) {
                    aHs = new ab();
                }
            }
        }
        return aHs;
    }

    public void Gp() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aHr - this.aGW) - j;
        if (j2 > 0 && !this.aGU && aa.Gi().Gj()) {
            this.aGU = true;
            long j3 = this.aGX - this.aGW;
            long j4 = this.aHp - this.aGW;
            long j5 = -1;
            if (this.aHn > 0) {
                j5 = this.aHo - this.aHn;
            }
            long j6 = this.aHr - this.aHq;
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("procname", "main");
            fH.p("appc", String.valueOf(j3));
            fH.p("loadclass", String.valueOf(this.aGY));
            fH.p("sapiinit", String.valueOf(this.aGZ));
            fH.p("acctinit", String.valueOf(this.aHa));
            fH.p("iminit", String.valueOf(this.aHb));
            fH.p("plugininit", String.valueOf(this.aHc));
            fH.p("patchloaded", String.valueOf(this.aHd));
            fH.p("naslibinit", String.valueOf(this.aHe));
            fH.p("websocketinit", String.valueOf(this.aHf));
            fH.p("settinginit", String.valueOf(this.aHg));
            fH.p("toastinit", String.valueOf(this.aHh));
            fH.p("tiebastaticinit", String.valueOf(this.aHi));
            fH.p("locationinit", String.valueOf(this.aHj));
            fH.p("cdninit", String.valueOf(this.aHk));
            fH.p("messagesetinit", String.valueOf(this.aHl));
            fH.p("logores", String.valueOf(j4));
            if (this.aHm > 0 && this.aHn > 0 && j5 > 0) {
                fH.p("adc", String.valueOf(this.aHm));
                fH.p("adshow", String.valueOf(j5));
                fH.p("hasad", "1");
            } else {
                fH.p("hasad", "0");
            }
            fH.p("tabc", String.valueOf(j6));
            fH.p("costt", String.valueOf(j2));
            fH.p("newinst", this.aGS ? "1" : "0");
            fH.d("pluginloadsync", Boolean.valueOf(this.aGV));
            BdStatisticsManager.getInstance().performance("startt", fH);
            nY();
        }
    }

    public void am(long j) {
        if (aa.Gi().Gj() && j > 0) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("procname", "remote");
            fH.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fH);
        }
    }

    private void nY() {
        this.aGS = false;
        this.aGT = false;
        this.aGW = -1L;
        this.aGX = -1L;
        this.aGY = -1L;
        this.aGZ = -1L;
        this.aHa = -1L;
        this.aHb = -1L;
        this.aHc = -1L;
        this.aHd = -1L;
        this.aHp = -1L;
        this.aHn = -1L;
        this.aHo = -1L;
        this.aHm = -1L;
        this.aHq = -1L;
        this.aHr = -1L;
        this.aHe = -1L;
        this.aHf = -1L;
        this.aHg = -1L;
        this.aHh = -1L;
        this.aHi = -1L;
        this.aHj = -1L;
        this.aHk = -1L;
        this.aHl = -1L;
    }
}
