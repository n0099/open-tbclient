package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab aDu = null;
    private boolean aCU = false;
    private boolean aCV = false;
    private boolean aCW = false;
    private boolean aCX = false;
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
    private long aDi = -1;
    private long aDj = -1;
    private long aDk = -1;
    private long aDl = -1;
    private long aDm = -1;
    private long aDn = -1;
    private long aDo = -1;
    private long aDp = -1;
    private long aDq = -1;
    private long aDr = -1;
    private long aDs = -1;
    private long aDt = -1;

    public boolean Gu() {
        return this.aCV;
    }

    public void bV(boolean z) {
        this.aCU = z;
    }

    public void T(long j) {
        this.aCY = j;
    }

    public void bW(boolean z) {
        this.aCX = z;
    }

    public void U(long j) {
        this.aCZ = j;
    }

    public void V(long j) {
        this.aDa = j;
    }

    public void W(long j) {
        this.aDb = j;
    }

    public void X(long j) {
        this.aDf = j;
    }

    public void Y(long j) {
        this.aDe = j;
    }

    public void Z(long j) {
        this.aDc = j;
    }

    public void aa(long j) {
        this.aDd = j;
    }

    public void ab(long j) {
        this.aDr = j;
    }

    public void ac(long j) {
        this.aDo = j;
    }

    public void ad(long j) {
        this.aDp = j;
    }

    public void ae(long j) {
        this.aDq = j;
    }

    public void af(long j) {
        this.aDs = j;
    }

    public void ag(long j) {
        this.aDt = j;
        this.aCV = true;
    }

    public void ah(long j) {
        this.aDg = j;
    }

    public void ai(long j) {
        this.aDh = j;
    }

    public void aj(long j) {
        this.aDj = j;
    }

    public void ak(long j) {
        this.aDi = j;
    }

    public void al(long j) {
        this.aDk = j;
    }

    public void am(long j) {
        this.aDl = j;
    }

    public void an(long j) {
        this.aDm = j;
    }

    public void ao(long j) {
        this.aDn = j;
    }

    public static ab Gv() {
        if (aDu == null) {
            synchronized (ab.class) {
                if (aDu == null) {
                    aDu = new ab();
                }
            }
        }
        return aDu;
    }

    public void Gw() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.aDt - this.aCY) - j;
        if (j2 > 0 && !this.aCW && aa.Gp().Gq()) {
            this.aCW = true;
            long j3 = this.aCZ - this.aCY;
            long j4 = this.aDr - this.aCY;
            long j5 = -1;
            if (this.aDp > 0) {
                j5 = this.aDq - this.aDp;
            }
            long j6 = this.aDt - this.aDs;
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "main");
            eB.q("appc", String.valueOf(j3));
            eB.q("loadclass", String.valueOf(this.aDa));
            eB.q("sapiinit", String.valueOf(this.aDb));
            eB.q("acctinit", String.valueOf(this.aDc));
            eB.q("iminit", String.valueOf(this.aDd));
            eB.q("plugininit", String.valueOf(this.aDe));
            eB.q("patchloaded", String.valueOf(this.aDf));
            eB.q("naslibinit", String.valueOf(this.aDg));
            eB.q("websocketinit", String.valueOf(this.aDh));
            eB.q("settinginit", String.valueOf(this.aDi));
            eB.q("toastinit", String.valueOf(this.aDj));
            eB.q("tiebastaticinit", String.valueOf(this.aDk));
            eB.q("locationinit", String.valueOf(this.aDl));
            eB.q("cdninit", String.valueOf(this.aDm));
            eB.q("messagesetinit", String.valueOf(this.aDn));
            eB.q("logores", String.valueOf(j4));
            if (this.aDo > 0 && this.aDp > 0 && j5 > 0) {
                eB.q("adc", String.valueOf(this.aDo));
                eB.q("adshow", String.valueOf(j5));
                eB.q("hasad", "1");
            } else {
                eB.q("hasad", "0");
            }
            eB.q("tabc", String.valueOf(j6));
            eB.q("costt", String.valueOf(j2));
            eB.q("newinst", this.aCU ? "1" : "0");
            eB.d("pluginloadsync", Boolean.valueOf(this.aCX));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
            nM();
        }
    }

    public void ap(long j) {
        if (aa.Gp().Gq() && j > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("procname", "remote");
            eB.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a("startt", eB);
        }
    }

    private void nM() {
        this.aCU = false;
        this.aCV = false;
        this.aCY = -1L;
        this.aCZ = -1L;
        this.aDa = -1L;
        this.aDb = -1L;
        this.aDc = -1L;
        this.aDd = -1L;
        this.aDe = -1L;
        this.aDf = -1L;
        this.aDr = -1L;
        this.aDp = -1L;
        this.aDq = -1L;
        this.aDo = -1L;
        this.aDs = -1L;
        this.aDt = -1L;
        this.aDg = -1L;
        this.aDh = -1L;
        this.aDi = -1L;
        this.aDj = -1L;
        this.aDk = -1L;
        this.aDl = -1L;
        this.aDm = -1L;
        this.aDn = -1L;
    }
}
