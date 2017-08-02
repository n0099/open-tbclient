package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s aJW = null;
    private boolean aJw = false;
    private boolean aJx = false;
    private boolean aJy = false;
    private boolean aJz = false;
    private long aJA = -1;
    private long aJB = -1;
    private long aJC = -1;
    private long aJD = -1;
    private long aJE = -1;
    private long aJF = -1;
    private long aJG = -1;
    private long aJH = -1;
    private long aJI = -1;
    private long aJJ = -1;
    private long aJK = -1;
    private long aJL = -1;
    private long aJM = -1;
    private long aJN = -1;
    private long aJO = -1;
    private long aJP = -1;
    private long aJQ = -1;
    private long aJR = -1;
    private long aJS = -1;
    private long aJT = -1;
    private long aJU = -1;
    private long aJV = -1;

    public boolean Gw() {
        return this.aJx;
    }

    public void cb(boolean z) {
        this.aJw = z;
    }

    public void T(long j) {
        this.aJA = j;
    }

    public void cc(boolean z) {
        this.aJz = z;
    }

    public void U(long j) {
        this.aJB = j;
    }

    public void V(long j) {
        this.aJC = j;
    }

    public void W(long j) {
        this.aJD = j;
    }

    public void X(long j) {
        this.aJH = j;
    }

    public void Y(long j) {
        this.aJG = j;
    }

    public void Z(long j) {
        this.aJE = j;
    }

    public void aa(long j) {
        this.aJF = j;
    }

    public void ab(long j) {
        this.aJT = j;
    }

    public void ac(long j) {
        this.aJQ = j;
    }

    public void ad(long j) {
        this.aJR = j;
    }

    public void ae(long j) {
        this.aJS = j;
    }

    public void af(long j) {
        this.aJU = j;
    }

    public void ag(long j) {
        this.aJV = j;
        this.aJx = true;
    }

    public void ah(long j) {
        this.aJI = j;
    }

    public void ai(long j) {
        this.aJJ = j;
    }

    public void aj(long j) {
        this.aJL = j;
    }

    public void ak(long j) {
        this.aJK = j;
    }

    public void al(long j) {
        this.aJM = j;
    }

    public void am(long j) {
        this.aJN = j;
    }

    public void an(long j) {
        this.aJO = j;
    }

    public void ao(long j) {
        this.aJP = j;
    }

    public static s Gx() {
        if (aJW == null) {
            synchronized (s.class) {
                if (aJW == null) {
                    aJW = new s();
                }
            }
        }
        return aJW;
    }

    public void Gy() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aJV - this.aJA) - j;
        if (j2 > 0 && !this.aJy && r.Gr().Gs()) {
            this.aJy = true;
            long j3 = this.aJB - this.aJA;
            long j4 = this.aJT - this.aJA;
            long j5 = -1;
            if (this.aJR > 0) {
                j5 = this.aJS - this.aJR;
            }
            long j6 = this.aJV - this.aJU;
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "main");
            fK.p("appc", String.valueOf(j3));
            fK.p("loadclass", String.valueOf(this.aJC));
            fK.p("sapiinit", String.valueOf(this.aJD));
            fK.p("acctinit", String.valueOf(this.aJE));
            fK.p("iminit", String.valueOf(this.aJF));
            fK.p("plugininit", String.valueOf(this.aJG));
            fK.p("patchloaded", String.valueOf(this.aJH));
            fK.p("naslibinit", String.valueOf(this.aJI));
            fK.p("websocketinit", String.valueOf(this.aJJ));
            fK.p("settinginit", String.valueOf(this.aJK));
            fK.p("toastinit", String.valueOf(this.aJL));
            fK.p("tiebastaticinit", String.valueOf(this.aJM));
            fK.p("locationinit", String.valueOf(this.aJN));
            fK.p("cdninit", String.valueOf(this.aJO));
            fK.p("messagesetinit", String.valueOf(this.aJP));
            fK.p("logores", String.valueOf(j4));
            if (this.aJQ > 0 && this.aJR > 0 && j5 > 0) {
                fK.p("adc", String.valueOf(this.aJQ));
                fK.p("adshow", String.valueOf(j5));
                fK.p("hasad", "1");
            } else {
                fK.p("hasad", "0");
            }
            fK.p("tabc", String.valueOf(j6));
            fK.p("costt", String.valueOf(j2));
            fK.p("newinst", this.aJw ? "1" : "0");
            fK.d("pluginloadsync", Boolean.valueOf(this.aJz));
            BdStatisticsManager.getInstance().performance("startt", fK);
            nS();
        }
    }

    public void ap(long j) {
        if (r.Gr().Gs() && j > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("procname", "remote");
            fK.p("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", fK);
        }
    }

    private void nS() {
        this.aJw = false;
        this.aJx = false;
        this.aJA = -1L;
        this.aJB = -1L;
        this.aJC = -1L;
        this.aJD = -1L;
        this.aJE = -1L;
        this.aJF = -1L;
        this.aJG = -1L;
        this.aJH = -1L;
        this.aJT = -1L;
        this.aJR = -1L;
        this.aJS = -1L;
        this.aJQ = -1L;
        this.aJU = -1L;
        this.aJV = -1L;
        this.aJI = -1L;
        this.aJJ = -1L;
        this.aJK = -1L;
        this.aJL = -1L;
        this.aJM = -1L;
        this.aJN = -1L;
        this.aJO = -1L;
        this.aJP = -1L;
    }
}
