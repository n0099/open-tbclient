package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s bzz = null;
    private boolean byZ = false;
    private boolean bza = false;
    private boolean bzb = false;
    private boolean bzc = false;
    private long bzd = -1;
    private long bze = -1;
    private long bzf = -1;
    private long bzg = -1;
    private long bzh = -1;
    private long bzi = -1;
    private long bzj = -1;
    private long bzk = -1;
    private long bzl = -1;
    private long bzm = -1;
    private long bzn = -1;
    private long bzo = -1;
    private long bzp = -1;
    private long bzq = -1;
    private long bzr = -1;
    private long bzs = -1;
    private long bzt = -1;
    private long bzu = -1;
    private long bzv = -1;
    private long bzw = -1;
    private long bzx = -1;
    private long bzy = -1;

    public boolean NT() {
        return this.bza;
    }

    public void cw(boolean z) {
        this.byZ = z;
    }

    public void ae(long j) {
        this.bzd = j;
    }

    public void cx(boolean z) {
        this.bzc = z;
    }

    public void af(long j) {
        this.bze = j;
    }

    public void ag(long j) {
        this.bzf = j;
    }

    public void ah(long j) {
        this.bzg = j;
    }

    public void ai(long j) {
        this.bzk = j;
    }

    public void aj(long j) {
        this.bzj = j;
    }

    public void ak(long j) {
        this.bzh = j;
    }

    public void al(long j) {
        this.bzi = j;
    }

    public void am(long j) {
        this.bzw = j;
    }

    public void an(long j) {
        this.bzt = j;
    }

    public void ao(long j) {
        this.bzu = j;
    }

    public void ap(long j) {
        this.bzv = j;
    }

    public void aq(long j) {
        this.bzx = j;
    }

    public void ar(long j) {
        this.bzy = j;
        this.bza = true;
    }

    public void as(long j) {
        this.bzl = j;
    }

    public void at(long j) {
        this.bzm = j;
    }

    public void au(long j) {
        this.bzo = j;
    }

    public void av(long j) {
        this.bzn = j;
    }

    public void aw(long j) {
        this.bzp = j;
    }

    public void ax(long j) {
        this.bzq = j;
    }

    public void ay(long j) {
        this.bzr = j;
    }

    public void az(long j) {
        this.bzs = j;
    }

    public static s NU() {
        if (bzz == null) {
            synchronized (s.class) {
                if (bzz == null) {
                    bzz = new s();
                }
            }
        }
        return bzz;
    }

    public void NV() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bzy - this.bzd) - j;
        if (j2 > 0 && !this.bzb && r.NO().NP()) {
            this.bzb = true;
            long j3 = this.bze - this.bzd;
            long j4 = this.bzw - this.bzd;
            long j5 = -1;
            if (this.bzu > 0) {
                j5 = this.bzv - this.bzu;
            }
            long j6 = this.bzy - this.bzx;
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("procname", "main");
            nm.append("appc", String.valueOf(j3));
            nm.append("loadclass", String.valueOf(this.bzf));
            nm.append("sapiinit", String.valueOf(this.bzg));
            nm.append("acctinit", String.valueOf(this.bzh));
            nm.append("iminit", String.valueOf(this.bzi));
            nm.append("plugininit", String.valueOf(this.bzj));
            nm.append("patchloaded", String.valueOf(this.bzk));
            nm.append("naslibinit", String.valueOf(this.bzl));
            nm.append("websocketinit", String.valueOf(this.bzm));
            nm.append("settinginit", String.valueOf(this.bzn));
            nm.append("toastinit", String.valueOf(this.bzo));
            nm.append("tiebastaticinit", String.valueOf(this.bzp));
            nm.append("locationinit", String.valueOf(this.bzq));
            nm.append("cdninit", String.valueOf(this.bzr));
            nm.append("messagesetinit", String.valueOf(this.bzs));
            nm.append("logores", String.valueOf(j4));
            if (this.bzt > 0 && this.bzu > 0 && j5 > 0) {
                nm.append("adc", String.valueOf(this.bzt));
                nm.append("adshow", String.valueOf(j5));
                nm.append("hasad", "1");
            } else {
                nm.append("hasad", "0");
            }
            nm.append("tabc", String.valueOf(j6));
            nm.append("costt", String.valueOf(j2));
            nm.append("newinst", this.byZ ? "1" : "0");
            nm.h("pluginloadsync", Boolean.valueOf(this.bzc));
            BdStatisticsManager.getInstance().performance("startt", nm);
            vA();
        }
    }

    public void aA(long j) {
        if (r.NO().NP() && j > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("procname", "remote");
            nm.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", nm);
        }
    }

    private void vA() {
        this.byZ = false;
        this.bza = false;
        this.bzd = -1L;
        this.bze = -1L;
        this.bzf = -1L;
        this.bzg = -1L;
        this.bzh = -1L;
        this.bzi = -1L;
        this.bzj = -1L;
        this.bzk = -1L;
        this.bzw = -1L;
        this.bzu = -1L;
        this.bzv = -1L;
        this.bzt = -1L;
        this.bzx = -1L;
        this.bzy = -1L;
        this.bzl = -1L;
        this.bzm = -1L;
        this.bzn = -1L;
        this.bzo = -1L;
        this.bzp = -1L;
        this.bzq = -1L;
        this.bzr = -1L;
        this.bzs = -1L;
    }
}
