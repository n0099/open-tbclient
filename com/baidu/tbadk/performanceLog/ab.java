package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aCX = null;
    private boolean aCx = false;
    private boolean aCy = false;
    private boolean aCz = false;
    private boolean aCA = false;
    private long aCB = -1;
    private long aCC = -1;
    private long aCD = -1;
    private long aCE = -1;
    private long aCF = -1;
    private long aCG = -1;
    private long aCH = -1;
    private long aCI = -1;
    private long aCJ = -1;
    private long aCK = -1;
    private long aCL = -1;
    private long aCM = -1;
    private long aCN = -1;
    private long aCO = -1;
    private long aCP = -1;
    private long aCQ = -1;
    private long aCR = -1;
    private long aCS = -1;
    private long aCT = -1;
    private long aCU = -1;
    private long aCV = -1;
    private long aCW = -1;

    public boolean Gt() {
        return this.aCy;
    }

    public void bU(boolean z) {
        this.aCx = z;
    }

    public void U(long j) {
        this.aCB = j;
    }

    public void bV(boolean z) {
        this.aCA = z;
    }

    public void V(long j) {
        this.aCC = j;
    }

    public void W(long j) {
        this.aCD = j;
    }

    public void X(long j) {
        this.aCE = j;
    }

    public void Y(long j) {
        this.aCI = j;
    }

    public void Z(long j) {
        this.aCH = j;
    }

    public void aa(long j) {
        this.aCF = j;
    }

    public void ab(long j) {
        this.aCG = j;
    }

    public void ac(long j) {
        this.aCU = j;
    }

    public void ad(long j) {
        this.aCR = j;
    }

    public void ae(long j) {
        this.aCS = j;
    }

    public void af(long j) {
        this.aCT = j;
    }

    public void ag(long j) {
        this.aCV = j;
    }

    public void ah(long j) {
        this.aCW = j;
        this.aCy = true;
    }

    public void ai(long j) {
        this.aCJ = j;
    }

    public void aj(long j) {
        this.aCK = j;
    }

    public void ak(long j) {
        this.aCM = j;
    }

    public void al(long j) {
        this.aCL = j;
    }

    public void am(long j) {
        this.aCN = j;
    }

    public void an(long j) {
        this.aCO = j;
    }

    public void ao(long j) {
        this.aCP = j;
    }

    public void ap(long j) {
        this.aCQ = j;
    }

    public static ab Gu() {
        if (aCX == null) {
            synchronized (ab.class) {
                if (aCX == null) {
                    aCX = new ab();
                }
            }
        }
        return aCX;
    }

    public void Gv() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aCW - this.aCB) - j;
        if (j2 > 0 && !this.aCz && aa.Go().Gp()) {
            this.aCz = true;
            long j3 = this.aCC - this.aCB;
            long j4 = this.aCU - this.aCB;
            long j5 = -1;
            if (this.aCS > 0) {
                j5 = this.aCT - this.aCS;
            }
            long j6 = this.aCW - this.aCV;
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "main");
            eB.q("appc", String.valueOf(j3));
            eB.q("loadclass", String.valueOf(this.aCD));
            eB.q("sapiinit", String.valueOf(this.aCE));
            eB.q("acctinit", String.valueOf(this.aCF));
            eB.q("iminit", String.valueOf(this.aCG));
            eB.q("plugininit", String.valueOf(this.aCH));
            eB.q("patchloaded", String.valueOf(this.aCI));
            eB.q("naslibinit", String.valueOf(this.aCJ));
            eB.q("websocketinit", String.valueOf(this.aCK));
            eB.q("settinginit", String.valueOf(this.aCL));
            eB.q("toastinit", String.valueOf(this.aCM));
            eB.q("tiebastaticinit", String.valueOf(this.aCN));
            eB.q("locationinit", String.valueOf(this.aCO));
            eB.q("cdninit", String.valueOf(this.aCP));
            eB.q("messagesetinit", String.valueOf(this.aCQ));
            eB.q("logores", String.valueOf(j4));
            if (this.aCR > 0 && this.aCS > 0 && j5 > 0) {
                eB.q("adc", String.valueOf(this.aCR));
                eB.q("adshow", String.valueOf(j5));
                eB.q("hasad", "1");
            } else {
                eB.q("hasad", "0");
            }
            eB.q("tabc", String.valueOf(j6));
            eB.q("costt", String.valueOf(j2));
            eB.q("newinst", this.aCx ? "1" : "0");
            eB.d("pluginloadsync", Boolean.valueOf(this.aCA));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
            nM();
        }
    }

    public void aq(long j) {
        if (aa.Go().Gp() && j > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "remote");
            eB.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
        }
    }

    private void nM() {
        this.aCx = false;
        this.aCy = false;
        this.aCB = -1L;
        this.aCC = -1L;
        this.aCD = -1L;
        this.aCE = -1L;
        this.aCF = -1L;
        this.aCG = -1L;
        this.aCH = -1L;
        this.aCI = -1L;
        this.aCU = -1L;
        this.aCS = -1L;
        this.aCT = -1L;
        this.aCR = -1L;
        this.aCV = -1L;
        this.aCW = -1L;
        this.aCJ = -1L;
        this.aCK = -1L;
        this.aCL = -1L;
        this.aCM = -1L;
        this.aCN = -1L;
        this.aCO = -1L;
        this.aCP = -1L;
        this.aCQ = -1L;
    }
}
