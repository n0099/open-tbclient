package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aDi = null;
    private boolean aCI = false;
    private boolean aCJ = false;
    private boolean aCK = false;
    private boolean aCL = false;
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
    private long aCX = -1;
    private long aCY = -1;
    private long aCZ = -1;
    private long aDa = -1;
    private long aDb = -1;
    private long aDc = -1;
    private long aDd = -1;
    private long aDe = -1;
    private long aDf = -1;
    private long aDg = -1;
    private long aDh = -1;

    public boolean FZ() {
        return this.aCJ;
    }

    public void bX(boolean z) {
        this.aCI = z;
    }

    public void R(long j) {
        this.aCM = j;
    }

    public void bY(boolean z) {
        this.aCL = z;
    }

    public void S(long j) {
        this.aCN = j;
    }

    public void T(long j) {
        this.aCO = j;
    }

    public void U(long j) {
        this.aCP = j;
    }

    public void V(long j) {
        this.aCT = j;
    }

    public void W(long j) {
        this.aCS = j;
    }

    public void X(long j) {
        this.aCQ = j;
    }

    public void Y(long j) {
        this.aCR = j;
    }

    public void Z(long j) {
        this.aDf = j;
    }

    public void aa(long j) {
        this.aDc = j;
    }

    public void ab(long j) {
        this.aDd = j;
    }

    public void ac(long j) {
        this.aDe = j;
    }

    public void ad(long j) {
        this.aDg = j;
    }

    public void ae(long j) {
        this.aDh = j;
        this.aCJ = true;
    }

    public void af(long j) {
        this.aCU = j;
    }

    public void ag(long j) {
        this.aCV = j;
    }

    public void ah(long j) {
        this.aCX = j;
    }

    public void ai(long j) {
        this.aCW = j;
    }

    public void aj(long j) {
        this.aCY = j;
    }

    public void ak(long j) {
        this.aCZ = j;
    }

    public void al(long j) {
        this.aDa = j;
    }

    public void am(long j) {
        this.aDb = j;
    }

    public static ab Ga() {
        if (aDi == null) {
            synchronized (ab.class) {
                if (aDi == null) {
                    aDi = new ab();
                }
            }
        }
        return aDi;
    }

    public void Gb() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aDh - this.aCM) - j;
        if (j2 > 0 && !this.aCK && aa.FU().FV()) {
            this.aCK = true;
            long j3 = this.aCN - this.aCM;
            long j4 = this.aDf - this.aCM;
            long j5 = -1;
            if (this.aDd > 0) {
                j5 = this.aDe - this.aDd;
            }
            long j6 = this.aDh - this.aDg;
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "main");
            eB.q("appc", String.valueOf(j3));
            eB.q("loadclass", String.valueOf(this.aCO));
            eB.q("sapiinit", String.valueOf(this.aCP));
            eB.q("acctinit", String.valueOf(this.aCQ));
            eB.q("iminit", String.valueOf(this.aCR));
            eB.q("plugininit", String.valueOf(this.aCS));
            eB.q("patchloaded", String.valueOf(this.aCT));
            eB.q("naslibinit", String.valueOf(this.aCU));
            eB.q("websocketinit", String.valueOf(this.aCV));
            eB.q("settinginit", String.valueOf(this.aCW));
            eB.q("toastinit", String.valueOf(this.aCX));
            eB.q("tiebastaticinit", String.valueOf(this.aCY));
            eB.q("locationinit", String.valueOf(this.aCZ));
            eB.q("cdninit", String.valueOf(this.aDa));
            eB.q("messagesetinit", String.valueOf(this.aDb));
            eB.q("logores", String.valueOf(j4));
            if (this.aDc > 0 && this.aDd > 0 && j5 > 0) {
                eB.q("adc", String.valueOf(this.aDc));
                eB.q("adshow", String.valueOf(j5));
                eB.q("hasad", "1");
            } else {
                eB.q("hasad", "0");
            }
            eB.q("tabc", String.valueOf(j6));
            eB.q("costt", String.valueOf(j2));
            eB.q("newinst", this.aCI ? "1" : "0");
            eB.d("pluginloadsync", Boolean.valueOf(this.aCL));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
            nQ();
        }
    }

    public void an(long j) {
        if (aa.FU().FV() && j > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "remote");
            eB.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
        }
    }

    private void nQ() {
        this.aCI = false;
        this.aCJ = false;
        this.aCM = -1L;
        this.aCN = -1L;
        this.aCO = -1L;
        this.aCP = -1L;
        this.aCQ = -1L;
        this.aCR = -1L;
        this.aCS = -1L;
        this.aCT = -1L;
        this.aDf = -1L;
        this.aDd = -1L;
        this.aDe = -1L;
        this.aDc = -1L;
        this.aDg = -1L;
        this.aDh = -1L;
        this.aCU = -1L;
        this.aCV = -1L;
        this.aCW = -1L;
        this.aCX = -1L;
        this.aCY = -1L;
        this.aCZ = -1L;
        this.aDa = -1L;
        this.aDb = -1L;
    }
}
