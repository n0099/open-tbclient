package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aLv = null;
    private boolean aKV = false;
    private boolean aKW = false;
    private boolean aKX = false;
    private boolean aKY = false;
    private long aKZ = -1;
    private long aLa = -1;
    private long aLb = -1;
    private long aLc = -1;
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

    public boolean GF() {
        return this.aKW;
    }

    public void bU(boolean z) {
        this.aKV = z;
    }

    public void W(long j) {
        this.aKZ = j;
    }

    public void bV(boolean z) {
        this.aKY = z;
    }

    public void X(long j) {
        this.aLa = j;
    }

    public void Y(long j) {
        this.aLb = j;
    }

    public void Z(long j) {
        this.aLc = j;
    }

    public void aa(long j) {
        this.aLg = j;
    }

    public void ab(long j) {
        this.aLf = j;
    }

    public void ac(long j) {
        this.aLd = j;
    }

    public void ad(long j) {
        this.aLe = j;
    }

    public void ae(long j) {
        this.aLs = j;
    }

    public void af(long j) {
        this.aLp = j;
    }

    public void ag(long j) {
        this.aLq = j;
    }

    public void ah(long j) {
        this.aLr = j;
    }

    public void ai(long j) {
        this.aLt = j;
    }

    public void aj(long j) {
        this.aLu = j;
        this.aKW = true;
    }

    public void ak(long j) {
        this.aLh = j;
    }

    public void al(long j) {
        this.aLi = j;
    }

    public void am(long j) {
        this.aLk = j;
    }

    public void an(long j) {
        this.aLj = j;
    }

    public void ao(long j) {
        this.aLl = j;
    }

    public void ap(long j) {
        this.aLm = j;
    }

    public void aq(long j) {
        this.aLn = j;
    }

    public void ar(long j) {
        this.aLo = j;
    }

    public static s GG() {
        if (aLv == null) {
            synchronized (s.class) {
                if (aLv == null) {
                    aLv = new s();
                }
            }
        }
        return aLv;
    }

    public void GH() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aLu - this.aKZ) - j;
        if (j2 > 0 && !this.aKX && r.GA().GB()) {
            this.aKX = true;
            long j3 = this.aLa - this.aKZ;
            long j4 = this.aLs - this.aKZ;
            long j5 = -1;
            if (this.aLq > 0) {
                j5 = this.aLr - this.aLq;
            }
            long j6 = this.aLu - this.aLt;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aLb));
            fK.p("sapiinit", String.valueOf(this.aLc));
            fK.p("acctinit", String.valueOf(this.aLd));
            fK.p("iminit", String.valueOf(this.aLe));
            fK.p("plugininit", String.valueOf(this.aLf));
            fK.p("patchloaded", String.valueOf(this.aLg));
            fK.p("naslibinit", String.valueOf(this.aLh));
            fK.p("websocketinit", String.valueOf(this.aLi));
            fK.p("settinginit", String.valueOf(this.aLj));
            fK.p("toastinit", String.valueOf(this.aLk));
            fK.p("tiebastaticinit", String.valueOf(this.aLl));
            fK.p("locationinit", String.valueOf(this.aLm));
            fK.p("cdninit", String.valueOf(this.aLn));
            fK.p("messagesetinit", String.valueOf(this.aLo));
            fK.p("logores", String.valueOf(j4));
            if (this.aLp > 0 && this.aLq > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aLp));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aKV ? "1" : "0");
            fK.c("pluginloadsync", Boolean.valueOf(this.aKY));
            BdStatisticsManager.getInstance().performance("startt", fK);
            oa();
        }
    }

    public void as(long j) {
        if (r.GA().GB() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void oa() {
        this.aKV = false;
        this.aKW = false;
        this.aKZ = -1L;
        this.aLa = -1L;
        this.aLb = -1L;
        this.aLc = -1L;
        this.aLd = -1L;
        this.aLe = -1L;
        this.aLf = -1L;
        this.aLg = -1L;
        this.aLs = -1L;
        this.aLq = -1L;
        this.aLr = -1L;
        this.aLp = -1L;
        this.aLt = -1L;
        this.aLu = -1L;
        this.aLh = -1L;
        this.aLi = -1L;
        this.aLj = -1L;
        this.aLk = -1L;
        this.aLl = -1L;
        this.aLm = -1L;
        this.aLn = -1L;
        this.aLo = -1L;
    }
}
