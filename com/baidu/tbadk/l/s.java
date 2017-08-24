package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aLn = null;
    private boolean aKN = false;
    private boolean aKO = false;
    private boolean aKP = false;
    private boolean aKQ = false;
    private long aKR = -1;
    private long aKS = -1;
    private long aKT = -1;
    private long aKU = -1;
    private long aKV = -1;
    private long aKW = -1;
    private long aKX = -1;
    private long aKY = -1;
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

    public boolean GE() {
        return this.aKO;
    }

    public void cb(boolean z) {
        this.aKN = z;
    }

    public void T(long j) {
        this.aKR = j;
    }

    public void cc(boolean z) {
        this.aKQ = z;
    }

    public void U(long j) {
        this.aKS = j;
    }

    public void V(long j) {
        this.aKT = j;
    }

    public void W(long j) {
        this.aKU = j;
    }

    public void X(long j) {
        this.aKY = j;
    }

    public void Y(long j) {
        this.aKX = j;
    }

    public void Z(long j) {
        this.aKV = j;
    }

    public void aa(long j) {
        this.aKW = j;
    }

    public void ab(long j) {
        this.aLk = j;
    }

    public void ac(long j) {
        this.aLh = j;
    }

    public void ad(long j) {
        this.aLi = j;
    }

    public void ae(long j) {
        this.aLj = j;
    }

    public void af(long j) {
        this.aLl = j;
    }

    public void ag(long j) {
        this.aLm = j;
        this.aKO = true;
    }

    public void ah(long j) {
        this.aKZ = j;
    }

    public void ai(long j) {
        this.aLa = j;
    }

    public void aj(long j) {
        this.aLc = j;
    }

    public void ak(long j) {
        this.aLb = j;
    }

    public void al(long j) {
        this.aLd = j;
    }

    public void am(long j) {
        this.aLe = j;
    }

    public void an(long j) {
        this.aLf = j;
    }

    public void ao(long j) {
        this.aLg = j;
    }

    public static s GF() {
        if (aLn == null) {
            synchronized (s.class) {
                if (aLn == null) {
                    aLn = new s();
                }
            }
        }
        return aLn;
    }

    public void GG() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aLm - this.aKR) - j;
        if (j2 > 0 && !this.aKP && r.Gz().GA()) {
            this.aKP = true;
            long j3 = this.aKS - this.aKR;
            long j4 = this.aLk - this.aKR;
            long j5 = -1;
            if (this.aLi > 0) {
                j5 = this.aLj - this.aLi;
            }
            long j6 = this.aLm - this.aLl;
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("procname", "main");
            fV.p("appc", String.valueOf(j3));
            fV.p("loadclass", String.valueOf(this.aKT));
            fV.p("sapiinit", String.valueOf(this.aKU));
            fV.p("acctinit", String.valueOf(this.aKV));
            fV.p("iminit", String.valueOf(this.aKW));
            fV.p("plugininit", String.valueOf(this.aKX));
            fV.p("patchloaded", String.valueOf(this.aKY));
            fV.p("naslibinit", String.valueOf(this.aKZ));
            fV.p("websocketinit", String.valueOf(this.aLa));
            fV.p("settinginit", String.valueOf(this.aLb));
            fV.p("toastinit", String.valueOf(this.aLc));
            fV.p("tiebastaticinit", String.valueOf(this.aLd));
            fV.p("locationinit", String.valueOf(this.aLe));
            fV.p("cdninit", String.valueOf(this.aLf));
            fV.p("messagesetinit", String.valueOf(this.aLg));
            fV.p("logores", String.valueOf(j4));
            if (this.aLh > 0 && this.aLi > 0 && j5 > 0) {
                fV.p("adc", String.valueOf(this.aLh));
                fV.p("adshow", String.valueOf(j5));
                fV.p("hasad", "1");
            } else {
                fV.p("hasad", "0");
            }
            fV.p("tabc", String.valueOf(j6));
            fV.p("costt", String.valueOf(j2));
            fV.p("newinst", this.aKN ? "1" : "0");
            fV.d("pluginloadsync", Boolean.valueOf(this.aKQ));
            BdStatisticsManager.getInstance().performance("startt", fV);
            od();
        }
    }

    public void ap(long j) {
        if (r.Gz().GA() && j > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("procname", "remote");
            fV.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fV);
        }
    }

    private void od() {
        this.aKN = false;
        this.aKO = false;
        this.aKR = -1L;
        this.aKS = -1L;
        this.aKT = -1L;
        this.aKU = -1L;
        this.aKV = -1L;
        this.aKW = -1L;
        this.aKX = -1L;
        this.aKY = -1L;
        this.aLk = -1L;
        this.aLi = -1L;
        this.aLj = -1L;
        this.aLh = -1L;
        this.aLl = -1L;
        this.aLm = -1L;
        this.aKZ = -1L;
        this.aLa = -1L;
        this.aLb = -1L;
        this.aLc = -1L;
        this.aLd = -1L;
        this.aLe = -1L;
        this.aLf = -1L;
        this.aLg = -1L;
    }
}
