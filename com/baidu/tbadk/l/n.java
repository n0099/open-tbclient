package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends l {
    private static n aYm = null;
    private boolean aXM = false;
    private boolean aXN = false;
    private boolean aXO = false;
    private boolean aXP = false;
    private long aXQ = -1;
    private long aXR = -1;
    private long aXS = -1;
    private long aXT = -1;
    private long aXU = -1;
    private long aXV = -1;
    private long aXW = -1;
    private long aXX = -1;
    private long aXY = -1;
    private long aXZ = -1;
    private long aYa = -1;
    private long aYb = -1;
    private long aYc = -1;
    private long aYd = -1;
    private long aYe = -1;
    private long aYf = -1;
    private long aYg = -1;
    private long aYh = -1;
    private long aYi = -1;
    private long aYj = -1;
    private long aYk = -1;
    private long aYl = -1;

    public boolean Md() {
        return this.aXN;
    }

    public void cm(boolean z) {
        this.aXM = z;
    }

    public void ah(long j) {
        this.aXQ = j;
    }

    public void cn(boolean z) {
        this.aXP = z;
    }

    public void ai(long j) {
        this.aXR = j;
    }

    public void aj(long j) {
        this.aXS = j;
    }

    public void ak(long j) {
        this.aXT = j;
    }

    public void al(long j) {
        this.aXX = j;
    }

    public void am(long j) {
        this.aXW = j;
    }

    public void an(long j) {
        this.aXU = j;
    }

    public void ao(long j) {
        this.aXV = j;
    }

    public void ap(long j) {
        this.aYj = j;
    }

    public void aq(long j) {
        this.aYg = j;
    }

    public void ar(long j) {
        this.aYh = j;
    }

    public void as(long j) {
        this.aYi = j;
    }

    public void at(long j) {
        this.aYk = j;
    }

    public void au(long j) {
        this.aYl = j;
        this.aXN = true;
    }

    public void av(long j) {
        this.aXY = j;
    }

    public void aw(long j) {
        this.aXZ = j;
    }

    public void ax(long j) {
        this.aYb = j;
    }

    public void ay(long j) {
        this.aYa = j;
    }

    public void az(long j) {
        this.aYc = j;
    }

    public void aA(long j) {
        this.aYd = j;
    }

    public void aB(long j) {
        this.aYe = j;
    }

    public void aC(long j) {
        this.aYf = j;
    }

    public static n Me() {
        if (aYm == null) {
            synchronized (n.class) {
                if (aYm == null) {
                    aYm = new n();
                }
            }
        }
        return aYm;
    }

    public void Mf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016482, (Class) null);
        if ((this.aYl - this.aXQ) - ((runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) ? 0L : ((Long) runTask.getData()).longValue()) > 0 && !this.aXO && m.LZ().Ma()) {
            this.aXO = true;
            long j = this.aXR - this.aXQ;
            long j2 = -1;
            if (this.aYh > 0) {
                j2 = this.aYi - this.aYh;
            }
            long j3 = this.aYl - this.aYk;
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append("procname", "main");
            jo.append("appc", String.valueOf(j));
            jo.append("loadclass", String.valueOf(this.aXS));
            jo.append("sapiinit", String.valueOf(this.aXT));
            jo.append("acctinit", String.valueOf(this.aXU));
            jo.append("iminit", String.valueOf(this.aXV));
            jo.append("plugininit", String.valueOf(this.aXW));
            jo.append("patchloaded", String.valueOf(this.aXX));
            jo.append("naslibinit", String.valueOf(this.aXY));
            jo.append("websocketinit", String.valueOf(this.aXZ));
            jo.append("settinginit", String.valueOf(this.aYa));
            jo.append("toastinit", String.valueOf(this.aYb));
            jo.append("tiebastaticinit", String.valueOf(this.aYc));
            jo.append("locationinit", String.valueOf(this.aYd));
            jo.append("cdninit", String.valueOf(this.aYe));
            jo.append("messagesetinit", String.valueOf(this.aYf));
            jo.append("logores", String.valueOf(this.aYj));
            if (this.aYg > 0 && this.aYh > 0 && j2 > 0) {
                jo.append("adc", String.valueOf(this.aYg));
                jo.append("adshow", String.valueOf(j2));
                jo.append("hasad", "1");
            } else {
                jo.append("hasad", "0");
            }
            jo.append("tabc", String.valueOf(j3));
            jo.append("costt", String.valueOf(this.aYj + j + j3));
            jo.append("newinst", this.aXM ? "1" : "0");
            jo.f("pluginloadsync", Boolean.valueOf(this.aXP));
            BdStatisticsManager.getInstance().performance("startt", jo);
            th();
        }
    }

    public void aD(long j) {
        if (m.LZ().Ma() && j > 0) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append("procname", "remote");
            jo.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", jo);
        }
    }

    private void th() {
        this.aXM = false;
        this.aXN = false;
        this.aXQ = -1L;
        this.aXR = -1L;
        this.aXS = -1L;
        this.aXT = -1L;
        this.aXU = -1L;
        this.aXV = -1L;
        this.aXW = -1L;
        this.aXX = -1L;
        this.aYj = -1L;
        this.aYh = -1L;
        this.aYi = -1L;
        this.aYg = -1L;
        this.aYk = -1L;
        this.aYl = -1L;
        this.aXY = -1L;
        this.aXZ = -1L;
        this.aYa = -1L;
        this.aYb = -1L;
        this.aYc = -1L;
        this.aYd = -1L;
        this.aYe = -1L;
        this.aYf = -1L;
    }
}
