package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aKp = null;
    private boolean aJP = false;
    private boolean aJQ = false;
    private boolean aJR = false;
    private boolean aJS = false;
    private long aJT = -1;
    private long aJU = -1;
    private long aJV = -1;
    private long aJW = -1;
    private long aJX = -1;
    private long aJY = -1;
    private long aJZ = -1;
    private long aKa = -1;
    private long aKb = -1;
    private long aKc = -1;
    private long aKd = -1;
    private long aKe = -1;
    private long aKf = -1;
    private long aKg = -1;
    private long aKh = -1;
    private long aKi = -1;
    private long aKj = -1;
    private long aKk = -1;
    private long aKl = -1;
    private long aKm = -1;
    private long aKn = -1;
    private long aKo = -1;

    public boolean Gh() {
        return this.aJQ;
    }

    public void ca(boolean z) {
        this.aJP = z;
    }

    public void S(long j) {
        this.aJT = j;
    }

    public void cb(boolean z) {
        this.aJS = z;
    }

    public void T(long j) {
        this.aJU = j;
    }

    public void U(long j) {
        this.aJV = j;
    }

    public void V(long j) {
        this.aJW = j;
    }

    public void W(long j) {
        this.aKa = j;
    }

    public void X(long j) {
        this.aJZ = j;
    }

    public void Y(long j) {
        this.aJX = j;
    }

    public void Z(long j) {
        this.aJY = j;
    }

    public void aa(long j) {
        this.aKm = j;
    }

    public void ab(long j) {
        this.aKj = j;
    }

    public void ac(long j) {
        this.aKk = j;
    }

    public void ad(long j) {
        this.aKl = j;
    }

    public void ae(long j) {
        this.aKn = j;
    }

    public void af(long j) {
        this.aKo = j;
        this.aJQ = true;
    }

    public void ag(long j) {
        this.aKb = j;
    }

    public void ah(long j) {
        this.aKc = j;
    }

    public void ai(long j) {
        this.aKe = j;
    }

    public void aj(long j) {
        this.aKd = j;
    }

    public void ak(long j) {
        this.aKf = j;
    }

    public void al(long j) {
        this.aKg = j;
    }

    public void am(long j) {
        this.aKh = j;
    }

    public void an(long j) {
        this.aKi = j;
    }

    public static s Gi() {
        if (aKp == null) {
            synchronized (s.class) {
                if (aKp == null) {
                    aKp = new s();
                }
            }
        }
        return aKp;
    }

    public void Gj() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aKo - this.aJT) - j;
        if (j2 > 0 && !this.aJR && r.Gc().Gd()) {
            this.aJR = true;
            long j3 = this.aJU - this.aJT;
            long j4 = this.aKm - this.aJT;
            long j5 = -1;
            if (this.aKk > 0) {
                j5 = this.aKl - this.aKk;
            }
            long j6 = this.aKo - this.aKn;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aJV));
            fK.p("sapiinit", String.valueOf(this.aJW));
            fK.p("acctinit", String.valueOf(this.aJX));
            fK.p("iminit", String.valueOf(this.aJY));
            fK.p("plugininit", String.valueOf(this.aJZ));
            fK.p("patchloaded", String.valueOf(this.aKa));
            fK.p("naslibinit", String.valueOf(this.aKb));
            fK.p("websocketinit", String.valueOf(this.aKc));
            fK.p("settinginit", String.valueOf(this.aKd));
            fK.p("toastinit", String.valueOf(this.aKe));
            fK.p("tiebastaticinit", String.valueOf(this.aKf));
            fK.p("locationinit", String.valueOf(this.aKg));
            fK.p("cdninit", String.valueOf(this.aKh));
            fK.p("messagesetinit", String.valueOf(this.aKi));
            fK.p("logores", String.valueOf(j4));
            if (this.aKj > 0 && this.aKk > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aKj));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aJP ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aJS));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nX();
        }
    }

    public void ao(long j) {
        if (r.Gc().Gd() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nX() {
        this.aJP = false;
        this.aJQ = false;
        this.aJT = -1L;
        this.aJU = -1L;
        this.aJV = -1L;
        this.aJW = -1L;
        this.aJX = -1L;
        this.aJY = -1L;
        this.aJZ = -1L;
        this.aKa = -1L;
        this.aKm = -1L;
        this.aKk = -1L;
        this.aKl = -1L;
        this.aKj = -1L;
        this.aKn = -1L;
        this.aKo = -1L;
        this.aKb = -1L;
        this.aKc = -1L;
        this.aKd = -1L;
        this.aKe = -1L;
        this.aKf = -1L;
        this.aKg = -1L;
        this.aKh = -1L;
        this.aKi = -1L;
    }
}
