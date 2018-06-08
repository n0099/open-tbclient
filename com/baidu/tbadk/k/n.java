package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n aUa = null;
    private boolean aTA = false;
    private boolean aTB = false;
    private boolean aTC = false;
    private boolean aTD = false;
    private long aTE = -1;
    private long aTF = -1;
    private long aTG = -1;
    private long aTH = -1;
    private long aTI = -1;
    private long aTJ = -1;
    private long aTK = -1;
    private long aTL = -1;
    private long aTM = -1;
    private long aTN = -1;
    private long aTO = -1;
    private long aTP = -1;
    private long aTQ = -1;
    private long aTR = -1;
    private long aTS = -1;
    private long aTT = -1;
    private long aTU = -1;
    private long aTV = -1;
    private long aTW = -1;
    private long aTX = -1;
    private long aTY = -1;
    private long aTZ = -1;

    public boolean Kw() {
        return this.aTB;
    }

    public void bY(boolean z) {
        this.aTA = z;
    }

    public void aa(long j) {
        this.aTE = j;
    }

    public void bZ(boolean z) {
        this.aTD = z;
    }

    public void ab(long j) {
        this.aTF = j;
    }

    public void ac(long j) {
        this.aTG = j;
    }

    public void ad(long j) {
        this.aTH = j;
    }

    public void ae(long j) {
        this.aTL = j;
    }

    public void af(long j) {
        this.aTK = j;
    }

    public void ag(long j) {
        this.aTI = j;
    }

    public void ah(long j) {
        this.aTJ = j;
    }

    public void ai(long j) {
        this.aTX = j;
    }

    public void aj(long j) {
        this.aTU = j;
    }

    public void ak(long j) {
        this.aTV = j;
    }

    public void al(long j) {
        this.aTW = j;
    }

    public void am(long j) {
        this.aTY = j;
    }

    public void an(long j) {
        this.aTZ = j;
        this.aTB = true;
    }

    public void ao(long j) {
        this.aTM = j;
    }

    public void ap(long j) {
        this.aTN = j;
    }

    public void aq(long j) {
        this.aTP = j;
    }

    public void ar(long j) {
        this.aTO = j;
    }

    public void as(long j) {
        this.aTQ = j;
    }

    public void at(long j) {
        this.aTR = j;
    }

    public void au(long j) {
        this.aTS = j;
    }

    public void av(long j) {
        this.aTT = j;
    }

    public static n Kx() {
        if (aUa == null) {
            synchronized (n.class) {
                if (aUa == null) {
                    aUa = new n();
                }
            }
        }
        return aUa;
    }

    public void Ky() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.aTZ - this.aTE) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.aTC && m.Ks().Kt()) {
            this.aTC = true;
            long j = this.aTF - this.aTE;
            long j2 = -1;
            if (this.aTV > 0) {
                j2 = this.aTW - this.aTV;
            }
            long j3 = this.aTZ - this.aTY;
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append("procname", "main");
            ih.append("appc", String.valueOf(j));
            ih.append("loadclass", String.valueOf(this.aTG));
            ih.append("sapiinit", String.valueOf(this.aTH));
            ih.append("acctinit", String.valueOf(this.aTI));
            ih.append("iminit", String.valueOf(this.aTJ));
            ih.append("plugininit", String.valueOf(this.aTK));
            ih.append("patchloaded", String.valueOf(this.aTL));
            ih.append("naslibinit", String.valueOf(this.aTM));
            ih.append("websocketinit", String.valueOf(this.aTN));
            ih.append("settinginit", String.valueOf(this.aTO));
            ih.append("toastinit", String.valueOf(this.aTP));
            ih.append("tiebastaticinit", String.valueOf(this.aTQ));
            ih.append("locationinit", String.valueOf(this.aTR));
            ih.append("cdninit", String.valueOf(this.aTS));
            ih.append("messagesetinit", String.valueOf(this.aTT));
            ih.append("logores", String.valueOf(this.aTX));
            if (this.aTU > 0 && this.aTV > 0 && j2 > 0) {
                ih.append("adc", String.valueOf(this.aTU));
                ih.append("adshow", String.valueOf(j2));
                ih.append("hasad", "1");
            } else {
                ih.append("hasad", "0");
            }
            ih.append("tabc", String.valueOf(j3));
            ih.append("costt", String.valueOf(this.aTX + j + j3));
            ih.append("newinst", this.aTA ? "1" : "0");
            ih.f("pluginloadsync", Boolean.valueOf(this.aTD));
            BdStatisticsManager.getInstance().performance("startt", ih);
            sr();
        }
    }

    public void aw(long j) {
        if (m.Ks().Kt() && j > 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append("procname", "remote");
            ih.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", ih);
        }
    }

    private void sr() {
        this.aTA = false;
        this.aTB = false;
        this.aTE = -1L;
        this.aTF = -1L;
        this.aTG = -1L;
        this.aTH = -1L;
        this.aTI = -1L;
        this.aTJ = -1L;
        this.aTK = -1L;
        this.aTL = -1L;
        this.aTX = -1L;
        this.aTV = -1L;
        this.aTW = -1L;
        this.aTU = -1L;
        this.aTY = -1L;
        this.aTZ = -1L;
        this.aTM = -1L;
        this.aTN = -1L;
        this.aTO = -1L;
        this.aTP = -1L;
        this.aTQ = -1L;
        this.aTR = -1L;
        this.aTS = -1L;
        this.aTT = -1L;
    }
}
