package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aLz = null;
    private boolean aKZ = false;
    private boolean aLa = false;
    private boolean aLb = false;
    private boolean aLc = false;
    private long aLd = -1;
    private long aLe = -1;
    private long aLf = -1;
    private long aLg = -1;
    private long aLh = -1;
    private long aLi = -1;
    private long aLj = -1;
    private long aLk = -1;
    private long aLl = -1;
    private long aLm = -1;
    private long aLn = -1;
    private long aLo = -1;
    private long aLp = -1;
    private long aLq = -1;
    private long aLr = -1;
    private long aLs = -1;
    private long aLt = -1;
    private long aLu = -1;
    private long aLv = -1;
    private long aLw = -1;
    private long aLx = -1;
    private long aLy = -1;

    public boolean GG() {
        return this.aLa;
    }

    public void bV(boolean z) {
        this.aKZ = z;
    }

    public void W(long j) {
        this.aLd = j;
    }

    public void bW(boolean z) {
        this.aLc = z;
    }

    public void X(long j) {
        this.aLe = j;
    }

    public void Y(long j) {
        this.aLf = j;
    }

    public void Z(long j) {
        this.aLg = j;
    }

    public void aa(long j) {
        this.aLk = j;
    }

    public void ab(long j) {
        this.aLj = j;
    }

    public void ac(long j) {
        this.aLh = j;
    }

    public void ad(long j) {
        this.aLi = j;
    }

    public void ae(long j) {
        this.aLw = j;
    }

    public void af(long j) {
        this.aLt = j;
    }

    public void ag(long j) {
        this.aLu = j;
    }

    public void ah(long j) {
        this.aLv = j;
    }

    public void ai(long j) {
        this.aLx = j;
    }

    public void aj(long j) {
        this.aLy = j;
        this.aLa = true;
    }

    public void ak(long j) {
        this.aLl = j;
    }

    public void al(long j) {
        this.aLm = j;
    }

    public void am(long j) {
        this.aLo = j;
    }

    public void an(long j) {
        this.aLn = j;
    }

    public void ao(long j) {
        this.aLp = j;
    }

    public void ap(long j) {
        this.aLq = j;
    }

    public void aq(long j) {
        this.aLr = j;
    }

    public void ar(long j) {
        this.aLs = j;
    }

    public static s GH() {
        if (aLz == null) {
            synchronized (s.class) {
                if (aLz == null) {
                    aLz = new s();
                }
            }
        }
        return aLz;
    }

    public void GI() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aLy - this.aLd) - j;
        if (j2 > 0 && !this.aLb && r.GB().GC()) {
            this.aLb = true;
            long j3 = this.aLe - this.aLd;
            long j4 = this.aLw - this.aLd;
            long j5 = -1;
            if (this.aLu > 0) {
                j5 = this.aLv - this.aLu;
            }
            long j6 = this.aLy - this.aLx;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aLf));
            fK.p("sapiinit", String.valueOf(this.aLg));
            fK.p("acctinit", String.valueOf(this.aLh));
            fK.p("iminit", String.valueOf(this.aLi));
            fK.p("plugininit", String.valueOf(this.aLj));
            fK.p("patchloaded", String.valueOf(this.aLk));
            fK.p("naslibinit", String.valueOf(this.aLl));
            fK.p("websocketinit", String.valueOf(this.aLm));
            fK.p("settinginit", String.valueOf(this.aLn));
            fK.p("toastinit", String.valueOf(this.aLo));
            fK.p("tiebastaticinit", String.valueOf(this.aLp));
            fK.p("locationinit", String.valueOf(this.aLq));
            fK.p("cdninit", String.valueOf(this.aLr));
            fK.p("messagesetinit", String.valueOf(this.aLs));
            fK.p("logores", String.valueOf(j4));
            if (this.aLt > 0 && this.aLu > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aLt));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aKZ ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aLc));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nY();
        }
    }

    public void as(long j) {
        if (r.GB().GC() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nY() {
        this.aKZ = false;
        this.aLa = false;
        this.aLd = -1L;
        this.aLe = -1L;
        this.aLf = -1L;
        this.aLg = -1L;
        this.aLh = -1L;
        this.aLi = -1L;
        this.aLj = -1L;
        this.aLk = -1L;
        this.aLw = -1L;
        this.aLu = -1L;
        this.aLv = -1L;
        this.aLt = -1L;
        this.aLx = -1L;
        this.aLy = -1L;
        this.aLl = -1L;
        this.aLm = -1L;
        this.aLn = -1L;
        this.aLo = -1L;
        this.aLp = -1L;
        this.aLq = -1L;
        this.aLr = -1L;
        this.aLs = -1L;
    }
}
