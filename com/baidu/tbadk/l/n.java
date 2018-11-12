package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n bdz = null;
    private boolean bcZ = false;
    private boolean bda = false;
    private boolean bdb = false;
    private boolean bdc = false;
    private long bdd = -1;
    private long bde = -1;
    private long bdf = -1;
    private long bdg = -1;
    private long bdh = -1;
    private long bdi = -1;
    private long bdj = -1;
    private long bdk = -1;
    private long bdl = -1;
    private long bdm = -1;
    private long bdn = -1;
    private long bdo = -1;
    private long bdp = -1;
    private long bdq = -1;
    private long bdr = -1;
    private long bds = -1;
    private long bdt = -1;
    private long bdu = -1;
    private long bdv = -1;
    private long bdw = -1;
    private long bdx = -1;
    private long bdy = -1;

    public boolean Ok() {
        return this.bda;
    }

    public void cM(boolean z) {
        this.bcZ = z;
    }

    public void al(long j) {
        this.bdd = j;
    }

    public void cN(boolean z) {
        this.bdc = z;
    }

    public void am(long j) {
        this.bde = j;
    }

    public void an(long j) {
        this.bdf = j;
    }

    public void ao(long j) {
        this.bdg = j;
    }

    public void ap(long j) {
        this.bdk = j;
    }

    public void aq(long j) {
        this.bdj = j;
    }

    public void ar(long j) {
        this.bdh = j;
    }

    public void as(long j) {
        this.bdi = j;
    }

    public void at(long j) {
        this.bdw = j;
    }

    public void au(long j) {
        this.bdt = j;
    }

    public void av(long j) {
        this.bdu = j;
    }

    public void aw(long j) {
        this.bdv = j;
    }

    public void ax(long j) {
        this.bdx = j;
    }

    public void ay(long j) {
        this.bdy = j;
        this.bda = true;
    }

    public void az(long j) {
        this.bdl = j;
    }

    public void aA(long j) {
        this.bdm = j;
    }

    public void aB(long j) {
        this.bdo = j;
    }

    public void aC(long j) {
        this.bdn = j;
    }

    public void aD(long j) {
        this.bdp = j;
    }

    public void aE(long j) {
        this.bdq = j;
    }

    public void aF(long j) {
        this.bdr = j;
    }

    public void aG(long j) {
        this.bds = j;
    }

    public static n Ol() {
        if (bdz == null) {
            synchronized (n.class) {
                if (bdz == null) {
                    bdz = new n();
                }
            }
        }
        return bdz;
    }

    public void Om() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.bdy - this.bdd) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.bdb && m.Og().Oh()) {
            this.bdb = true;
            long j = this.bde - this.bdd;
            long j2 = -1;
            if (this.bdu > 0) {
                j2 = this.bdv - this.bdu;
            }
            long j3 = this.bdy - this.bdx;
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "main");
            jB.append("appc", String.valueOf(j));
            jB.append("loadclass", String.valueOf(this.bdf));
            jB.append("sapiinit", String.valueOf(this.bdg));
            jB.append("acctinit", String.valueOf(this.bdh));
            jB.append("iminit", String.valueOf(this.bdi));
            jB.append("plugininit", String.valueOf(this.bdj));
            jB.append("patchloaded", String.valueOf(this.bdk));
            jB.append("naslibinit", String.valueOf(this.bdl));
            jB.append("websocketinit", String.valueOf(this.bdm));
            jB.append("settinginit", String.valueOf(this.bdn));
            jB.append("toastinit", String.valueOf(this.bdo));
            jB.append("tiebastaticinit", String.valueOf(this.bdp));
            jB.append("locationinit", String.valueOf(this.bdq));
            jB.append("cdninit", String.valueOf(this.bdr));
            jB.append("messagesetinit", String.valueOf(this.bds));
            jB.append("logores", String.valueOf(this.bdw));
            if (this.bdt > 0 && this.bdu > 0 && j2 > 0) {
                jB.append("adc", String.valueOf(this.bdt));
                jB.append("adshow", String.valueOf(j2));
                jB.append("hasad", "1");
            } else {
                jB.append("hasad", "0");
            }
            jB.append("tabc", String.valueOf(j3));
            jB.append("costt", String.valueOf(this.bdw + j + j3));
            jB.append("newinst", this.bcZ ? "1" : "0");
            jB.f("pluginloadsync", Boolean.valueOf(this.bdc));
            BdStatisticsManager.getInstance().performance("startt", jB);
            vB();
        }
    }

    public void aH(long j) {
        if (m.Og().Oh() && j > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("procname", "remote");
            jB.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jB);
        }
    }

    private void vB() {
        this.bcZ = false;
        this.bda = false;
        this.bdd = -1L;
        this.bde = -1L;
        this.bdf = -1L;
        this.bdg = -1L;
        this.bdh = -1L;
        this.bdi = -1L;
        this.bdj = -1L;
        this.bdk = -1L;
        this.bdw = -1L;
        this.bdu = -1L;
        this.bdv = -1L;
        this.bdt = -1L;
        this.bdx = -1L;
        this.bdy = -1L;
        this.bdl = -1L;
        this.bdm = -1L;
        this.bdn = -1L;
        this.bdo = -1L;
        this.bdp = -1L;
        this.bdq = -1L;
        this.bdr = -1L;
        this.bds = -1L;
    }
}
