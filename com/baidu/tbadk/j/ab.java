package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aIO = null;
    private boolean aIo = false;
    private boolean aIp = false;
    private boolean aIq = false;
    private boolean aIr = false;
    private long aIs = -1;
    private long aIt = -1;
    private long aIu = -1;
    private long aIv = -1;
    private long aIw = -1;
    private long aIx = -1;
    private long aIy = -1;
    private long aIz = -1;
    private long aIA = -1;
    private long aIB = -1;
    private long aIC = -1;
    private long aID = -1;
    private long aIE = -1;
    private long aIF = -1;
    private long aIG = -1;
    private long aIH = -1;
    private long aII = -1;
    private long aIJ = -1;
    private long aIK = -1;
    private long aIL = -1;
    private long aIM = -1;
    private long aIN = -1;

    public boolean Gg() {
        return this.aIp;
    }

    public void bY(boolean z) {
        this.aIo = z;
    }

    public void S(long j) {
        this.aIs = j;
    }

    public void bZ(boolean z) {
        this.aIr = z;
    }

    public void T(long j) {
        this.aIt = j;
    }

    public void U(long j) {
        this.aIu = j;
    }

    public void V(long j) {
        this.aIv = j;
    }

    public void W(long j) {
        this.aIz = j;
    }

    public void X(long j) {
        this.aIy = j;
    }

    public void Y(long j) {
        this.aIw = j;
    }

    public void Z(long j) {
        this.aIx = j;
    }

    public void aa(long j) {
        this.aIL = j;
    }

    public void ab(long j) {
        this.aII = j;
    }

    public void ac(long j) {
        this.aIJ = j;
    }

    public void ad(long j) {
        this.aIK = j;
    }

    public void ae(long j) {
        this.aIM = j;
    }

    public void af(long j) {
        this.aIN = j;
        this.aIp = true;
    }

    public void ag(long j) {
        this.aIA = j;
    }

    public void ah(long j) {
        this.aIB = j;
    }

    public void ai(long j) {
        this.aID = j;
    }

    public void aj(long j) {
        this.aIC = j;
    }

    public void ak(long j) {
        this.aIE = j;
    }

    public void al(long j) {
        this.aIF = j;
    }

    public void am(long j) {
        this.aIG = j;
    }

    public void an(long j) {
        this.aIH = j;
    }

    public static ab Gh() {
        if (aIO == null) {
            synchronized (ab.class) {
                if (aIO == null) {
                    aIO = new ab();
                }
            }
        }
        return aIO;
    }

    public void Gi() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aIN - this.aIs) - j;
        if (j2 > 0 && !this.aIq && aa.Gb().Gc()) {
            this.aIq = true;
            long j3 = this.aIt - this.aIs;
            long j4 = this.aIL - this.aIs;
            long j5 = -1;
            if (this.aIJ > 0) {
                j5 = this.aIK - this.aIJ;
            }
            long j6 = this.aIN - this.aIM;
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("procname", "main");
            fM.p("appc", String.valueOf(j3));
            fM.p("loadclass", String.valueOf(this.aIu));
            fM.p("sapiinit", String.valueOf(this.aIv));
            fM.p("acctinit", String.valueOf(this.aIw));
            fM.p("iminit", String.valueOf(this.aIx));
            fM.p("plugininit", String.valueOf(this.aIy));
            fM.p("patchloaded", String.valueOf(this.aIz));
            fM.p("naslibinit", String.valueOf(this.aIA));
            fM.p("websocketinit", String.valueOf(this.aIB));
            fM.p("settinginit", String.valueOf(this.aIC));
            fM.p("toastinit", String.valueOf(this.aID));
            fM.p("tiebastaticinit", String.valueOf(this.aIE));
            fM.p("locationinit", String.valueOf(this.aIF));
            fM.p("cdninit", String.valueOf(this.aIG));
            fM.p("messagesetinit", String.valueOf(this.aIH));
            fM.p("logores", String.valueOf(j4));
            if (this.aII > 0 && this.aIJ > 0 && j5 > 0) {
                fM.p("adc", String.valueOf(this.aII));
                fM.p("adshow", String.valueOf(j5));
                fM.p("hasad", "1");
            } else {
                fM.p("hasad", "0");
            }
            fM.p("tabc", String.valueOf(j6));
            fM.p("costt", String.valueOf(j2));
            fM.p("newinst", this.aIo ? "1" : "0");
            fM.d("pluginloadsync", Boolean.valueOf(this.aIr));
            BdStatisticsManager.getInstance().performance("startt", fM);
            nQ();
        }
    }

    public void ao(long j) {
        if (aa.Gb().Gc() && j > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("procname", "remote");
            fM.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fM);
        }
    }

    private void nQ() {
        this.aIo = false;
        this.aIp = false;
        this.aIs = -1L;
        this.aIt = -1L;
        this.aIu = -1L;
        this.aIv = -1L;
        this.aIw = -1L;
        this.aIx = -1L;
        this.aIy = -1L;
        this.aIz = -1L;
        this.aIL = -1L;
        this.aIJ = -1L;
        this.aIK = -1L;
        this.aII = -1L;
        this.aIM = -1L;
        this.aIN = -1L;
        this.aIA = -1L;
        this.aIB = -1L;
        this.aIC = -1L;
        this.aID = -1L;
        this.aIE = -1L;
        this.aIF = -1L;
        this.aIG = -1L;
        this.aIH = -1L;
    }
}
