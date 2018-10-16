package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bcM = null;
    private boolean bcm = false;
    private boolean bcn = false;
    private boolean bco = false;
    private boolean bcp = false;
    private long bcq = -1;
    private long bcr = -1;
    private long bcs = -1;
    private long bct = -1;
    private long bcu = -1;
    private long bcv = -1;
    private long bcw = -1;
    private long bcx = -1;
    private long bcy = -1;
    private long bcz = -1;
    private long bcA = -1;
    private long bcB = -1;
    private long bcC = -1;
    private long bcD = -1;
    private long bcE = -1;
    private long bcF = -1;
    private long bcG = -1;
    private long bcH = -1;
    private long bcI = -1;
    private long bcJ = -1;
    private long bcK = -1;
    private long bcL = -1;

    public boolean Ob() {
        return this.bcn;
    }

    public void cv(boolean z) {
        this.bcm = z;
    }

    public void aj(long j) {
        this.bcq = j;
    }

    public void cw(boolean z) {
        this.bcp = z;
    }

    public void ak(long j) {
        this.bcr = j;
    }

    public void al(long j) {
        this.bcs = j;
    }

    public void am(long j) {
        this.bct = j;
    }

    public void an(long j) {
        this.bcx = j;
    }

    public void ao(long j) {
        this.bcw = j;
    }

    public void ap(long j) {
        this.bcu = j;
    }

    public void aq(long j) {
        this.bcv = j;
    }

    public void ar(long j) {
        this.bcJ = j;
    }

    public void as(long j) {
        this.bcG = j;
    }

    public void at(long j) {
        this.bcH = j;
    }

    public void au(long j) {
        this.bcI = j;
    }

    public void av(long j) {
        this.bcK = j;
    }

    public void aw(long j) {
        this.bcL = j;
        this.bcn = true;
    }

    public void ax(long j) {
        this.bcy = j;
    }

    public void ay(long j) {
        this.bcz = j;
    }

    public void az(long j) {
        this.bcB = j;
    }

    public void aA(long j) {
        this.bcA = j;
    }

    public void aB(long j) {
        this.bcC = j;
    }

    public void aC(long j) {
        this.bcD = j;
    }

    public void aD(long j) {
        this.bcE = j;
    }

    public void aE(long j) {
        this.bcF = j;
    }

    public static n Oc() {
        if (bcM == null) {
            synchronized (n.class) {
                if (bcM == null) {
                    bcM = new n();
                }
            }
        }
        return bcM;
    }

    public void Od() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bcL - this.bcq) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bco && m.NX().NY()) {
            this.bco = true;
            long j = this.bcr - this.bcq;
            long j2 = -1;
            if (this.bcH > 0) {
                j2 = this.bcI - this.bcH;
            }
            long j3 = this.bcL - this.bcK;
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("procname", "main");
            jD.append("appc", String.valueOf(j));
            jD.append("loadclass", String.valueOf(this.bcs));
            jD.append("sapiinit", String.valueOf(this.bct));
            jD.append("acctinit", String.valueOf(this.bcu));
            jD.append("iminit", String.valueOf(this.bcv));
            jD.append("plugininit", String.valueOf(this.bcw));
            jD.append("patchloaded", String.valueOf(this.bcx));
            jD.append("naslibinit", String.valueOf(this.bcy));
            jD.append("websocketinit", String.valueOf(this.bcz));
            jD.append("settinginit", String.valueOf(this.bcA));
            jD.append("toastinit", String.valueOf(this.bcB));
            jD.append("tiebastaticinit", String.valueOf(this.bcC));
            jD.append("locationinit", String.valueOf(this.bcD));
            jD.append("cdninit", String.valueOf(this.bcE));
            jD.append("messagesetinit", String.valueOf(this.bcF));
            jD.append("logores", String.valueOf(this.bcJ));
            if (this.bcG > 0 && this.bcH > 0 && j2 > 0) {
                jD.append("adc", String.valueOf(this.bcG));
                jD.append("adshow", String.valueOf(j2));
                jD.append("hasad", "1");
            } else {
                jD.append("hasad", "0");
            }
            jD.append("tabc", String.valueOf(j3));
            jD.append("costt", String.valueOf(this.bcJ + j + j3));
            jD.append("newinst", this.bcm ? "1" : "0");
            jD.f("pluginloadsync", Boolean.valueOf(this.bcp));
            BdStatisticsManager.getInstance().performance("startt", jD);
            vr();
        }
    }

    public void aF(long j) {
        if (m.NX().NY() && j > 0) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("procname", "remote");
            jD.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jD);
        }
    }

    private void vr() {
        this.bcm = false;
        this.bcn = false;
        this.bcq = -1L;
        this.bcr = -1L;
        this.bcs = -1L;
        this.bct = -1L;
        this.bcu = -1L;
        this.bcv = -1L;
        this.bcw = -1L;
        this.bcx = -1L;
        this.bcJ = -1L;
        this.bcH = -1L;
        this.bcI = -1L;
        this.bcG = -1L;
        this.bcK = -1L;
        this.bcL = -1L;
        this.bcy = -1L;
        this.bcz = -1L;
        this.bcA = -1L;
        this.bcB = -1L;
        this.bcC = -1L;
        this.bcD = -1L;
        this.bcE = -1L;
        this.bcF = -1L;
    }
}
