package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aDO = null;
    private boolean aDo = false;
    private boolean aDp = false;
    private boolean aDq = false;
    private boolean aDr = false;
    private long aDs = -1;
    private long aDt = -1;
    private long aDu = -1;
    private long aDv = -1;
    private long aDw = -1;
    private long aDx = -1;
    private long aDy = -1;
    private long aDz = -1;
    private long aDA = -1;
    private long aDB = -1;
    private long aDC = -1;
    private long aDD = -1;
    private long aDE = -1;
    private long aDF = -1;
    private long aDG = -1;
    private long aDH = -1;
    private long aDI = -1;
    private long aDJ = -1;
    private long aDK = -1;
    private long aDL = -1;
    private long aDM = -1;
    private long aDN = -1;

    public boolean Gz() {
        return this.aDp;
    }

    public void bY(boolean z) {
        this.aDo = z;
    }

    public void S(long j) {
        this.aDs = j;
    }

    public void bZ(boolean z) {
        this.aDr = z;
    }

    public void T(long j) {
        this.aDt = j;
    }

    public void U(long j) {
        this.aDu = j;
    }

    public void V(long j) {
        this.aDv = j;
    }

    public void W(long j) {
        this.aDz = j;
    }

    public void X(long j) {
        this.aDy = j;
    }

    public void Y(long j) {
        this.aDw = j;
    }

    public void Z(long j) {
        this.aDx = j;
    }

    public void aa(long j) {
        this.aDL = j;
    }

    public void ab(long j) {
        this.aDI = j;
    }

    public void ac(long j) {
        this.aDJ = j;
    }

    public void ad(long j) {
        this.aDK = j;
    }

    public void ae(long j) {
        this.aDM = j;
    }

    public void af(long j) {
        this.aDN = j;
        this.aDp = true;
    }

    public void ag(long j) {
        this.aDA = j;
    }

    public void ah(long j) {
        this.aDB = j;
    }

    public void ai(long j) {
        this.aDD = j;
    }

    public void aj(long j) {
        this.aDC = j;
    }

    public void ak(long j) {
        this.aDE = j;
    }

    public void al(long j) {
        this.aDF = j;
    }

    public void am(long j) {
        this.aDG = j;
    }

    public void an(long j) {
        this.aDH = j;
    }

    public static ab GA() {
        if (aDO == null) {
            synchronized (ab.class) {
                if (aDO == null) {
                    aDO = new ab();
                }
            }
        }
        return aDO;
    }

    public void GB() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aDN - this.aDs) - j;
        if (j2 > 0 && !this.aDq && aa.Gu().Gv()) {
            this.aDq = true;
            long j3 = this.aDt - this.aDs;
            long j4 = this.aDL - this.aDs;
            long j5 = -1;
            if (this.aDJ > 0) {
                j5 = this.aDK - this.aDJ;
            }
            long j6 = this.aDN - this.aDM;
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "main");
            eB.q("appc", String.valueOf(j3));
            eB.q("loadclass", String.valueOf(this.aDu));
            eB.q("sapiinit", String.valueOf(this.aDv));
            eB.q("acctinit", String.valueOf(this.aDw));
            eB.q("iminit", String.valueOf(this.aDx));
            eB.q("plugininit", String.valueOf(this.aDy));
            eB.q("patchloaded", String.valueOf(this.aDz));
            eB.q("naslibinit", String.valueOf(this.aDA));
            eB.q("websocketinit", String.valueOf(this.aDB));
            eB.q("settinginit", String.valueOf(this.aDC));
            eB.q("toastinit", String.valueOf(this.aDD));
            eB.q("tiebastaticinit", String.valueOf(this.aDE));
            eB.q("locationinit", String.valueOf(this.aDF));
            eB.q("cdninit", String.valueOf(this.aDG));
            eB.q("messagesetinit", String.valueOf(this.aDH));
            eB.q("logores", String.valueOf(j4));
            if (this.aDI > 0 && this.aDJ > 0 && j5 > 0) {
                eB.q("adc", String.valueOf(this.aDI));
                eB.q("adshow", String.valueOf(j5));
                eB.q("hasad", "1");
            } else {
                eB.q("hasad", "0");
            }
            eB.q("tabc", String.valueOf(j6));
            eB.q("costt", String.valueOf(j2));
            eB.q("newinst", this.aDo ? "1" : "0");
            eB.d("pluginloadsync", Boolean.valueOf(this.aDr));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
            nQ();
        }
    }

    public void ao(long j) {
        if (aa.Gu().Gv() && j > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "remote");
            eB.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
        }
    }

    private void nQ() {
        this.aDo = false;
        this.aDp = false;
        this.aDs = -1L;
        this.aDt = -1L;
        this.aDu = -1L;
        this.aDv = -1L;
        this.aDw = -1L;
        this.aDx = -1L;
        this.aDy = -1L;
        this.aDz = -1L;
        this.aDL = -1L;
        this.aDJ = -1L;
        this.aDK = -1L;
        this.aDI = -1L;
        this.aDM = -1L;
        this.aDN = -1L;
        this.aDA = -1L;
        this.aDB = -1L;
        this.aDC = -1L;
        this.aDD = -1L;
        this.aDE = -1L;
        this.aDF = -1L;
        this.aDG = -1L;
        this.aDH = -1L;
    }
}
