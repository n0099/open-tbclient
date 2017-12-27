package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s bzq = null;
    private boolean byQ = false;
    private boolean byR = false;
    private boolean byS = false;
    private boolean byT = false;
    private long byU = -1;
    private long byV = -1;
    private long byW = -1;
    private long byX = -1;
    private long byY = -1;
    private long byZ = -1;
    private long bza = -1;
    private long bzb = -1;
    private long bzc = -1;
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

    public boolean Of() {
        return this.byR;
    }

    public void cy(boolean z) {
        this.byQ = z;
    }

    public void ae(long j) {
        this.byU = j;
    }

    public void cz(boolean z) {
        this.byT = z;
    }

    public void af(long j) {
        this.byV = j;
    }

    public void ag(long j) {
        this.byW = j;
    }

    public void ah(long j) {
        this.byX = j;
    }

    public void ai(long j) {
        this.bzb = j;
    }

    public void aj(long j) {
        this.bza = j;
    }

    public void ak(long j) {
        this.byY = j;
    }

    public void al(long j) {
        this.byZ = j;
    }

    public void am(long j) {
        this.bzn = j;
    }

    public void an(long j) {
        this.bzk = j;
    }

    public void ao(long j) {
        this.bzl = j;
    }

    public void ap(long j) {
        this.bzm = j;
    }

    public void aq(long j) {
        this.bzo = j;
    }

    public void ar(long j) {
        this.bzp = j;
        this.byR = true;
    }

    public void as(long j) {
        this.bzc = j;
    }

    public void at(long j) {
        this.bzd = j;
    }

    public void au(long j) {
        this.bzf = j;
    }

    public void av(long j) {
        this.bze = j;
    }

    public void aw(long j) {
        this.bzg = j;
    }

    public void ax(long j) {
        this.bzh = j;
    }

    public void ay(long j) {
        this.bzi = j;
    }

    public void az(long j) {
        this.bzj = j;
    }

    public static s Og() {
        if (bzq == null) {
            synchronized (s.class) {
                if (bzq == null) {
                    bzq = new s();
                }
            }
        }
        return bzq;
    }

    public void Oh() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bzp - this.byU) - j;
        if (j2 > 0 && !this.byS && r.Oa().Ob()) {
            this.byS = true;
            long j3 = this.byV - this.byU;
            long j4 = this.bzn - this.byU;
            long j5 = -1;
            if (this.bzl > 0) {
                j5 = this.bzm - this.bzl;
            }
            long j6 = this.bzp - this.bzo;
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("procname", "main");
            nm.append("appc", String.valueOf(j3));
            nm.append("loadclass", String.valueOf(this.byW));
            nm.append("sapiinit", String.valueOf(this.byX));
            nm.append("acctinit", String.valueOf(this.byY));
            nm.append("iminit", String.valueOf(this.byZ));
            nm.append("plugininit", String.valueOf(this.bza));
            nm.append("patchloaded", String.valueOf(this.bzb));
            nm.append("naslibinit", String.valueOf(this.bzc));
            nm.append("websocketinit", String.valueOf(this.bzd));
            nm.append("settinginit", String.valueOf(this.bze));
            nm.append("toastinit", String.valueOf(this.bzf));
            nm.append("tiebastaticinit", String.valueOf(this.bzg));
            nm.append("locationinit", String.valueOf(this.bzh));
            nm.append("cdninit", String.valueOf(this.bzi));
            nm.append("messagesetinit", String.valueOf(this.bzj));
            nm.append("logores", String.valueOf(j4));
            if (this.bzk > 0 && this.bzl > 0 && j5 > 0) {
                nm.append("adc", String.valueOf(this.bzk));
                nm.append("adshow", String.valueOf(j5));
                nm.append("hasad", "1");
            } else {
                nm.append("hasad", "0");
            }
            nm.append("tabc", String.valueOf(j6));
            nm.append("costt", String.valueOf(j2));
            nm.append("newinst", this.byQ ? "1" : "0");
            nm.h("pluginloadsync", Boolean.valueOf(this.byT));
            BdStatisticsManager.getInstance().performance("startt", nm);
            vB();
        }
    }

    public void aA(long j) {
        if (r.Oa().Ob() && j > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("procname", "remote");
            nm.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", nm);
        }
    }

    private void vB() {
        this.byQ = false;
        this.byR = false;
        this.byU = -1L;
        this.byV = -1L;
        this.byW = -1L;
        this.byX = -1L;
        this.byY = -1L;
        this.byZ = -1L;
        this.bza = -1L;
        this.bzb = -1L;
        this.bzn = -1L;
        this.bzl = -1L;
        this.bzm = -1L;
        this.bzk = -1L;
        this.bzo = -1L;
        this.bzp = -1L;
        this.bzc = -1L;
        this.bzd = -1L;
        this.bze = -1L;
        this.bzf = -1L;
        this.bzg = -1L;
        this.bzh = -1L;
        this.bzi = -1L;
        this.bzj = -1L;
    }
}
