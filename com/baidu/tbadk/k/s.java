package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends q {
    private static s bzI = null;
    private boolean bzi = false;
    private boolean bzj = false;
    private boolean bzk = false;
    private boolean bzl = false;
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
    private long bzz = -1;
    private long bzA = -1;
    private long bzB = -1;
    private long bzC = -1;
    private long bzD = -1;
    private long bzE = -1;
    private long bzF = -1;
    private long bzG = -1;
    private long bzH = -1;

    public boolean NV() {
        return this.bzj;
    }

    public void cx(boolean z) {
        this.bzi = z;
    }

    public void ae(long j) {
        this.bzm = j;
    }

    public void cy(boolean z) {
        this.bzl = z;
    }

    public void af(long j) {
        this.bzn = j;
    }

    public void ag(long j) {
        this.bzo = j;
    }

    public void ah(long j) {
        this.bzp = j;
    }

    public void ai(long j) {
        this.bzt = j;
    }

    public void aj(long j) {
        this.bzs = j;
    }

    public void ak(long j) {
        this.bzq = j;
    }

    public void al(long j) {
        this.bzr = j;
    }

    public void am(long j) {
        this.bzF = j;
    }

    public void an(long j) {
        this.bzC = j;
    }

    public void ao(long j) {
        this.bzD = j;
    }

    public void ap(long j) {
        this.bzE = j;
    }

    public void aq(long j) {
        this.bzG = j;
    }

    public void ar(long j) {
        this.bzH = j;
        this.bzj = true;
    }

    public void as(long j) {
        this.bzu = j;
    }

    public void at(long j) {
        this.bzv = j;
    }

    public void au(long j) {
        this.bzx = j;
    }

    public void av(long j) {
        this.bzw = j;
    }

    public void aw(long j) {
        this.bzy = j;
    }

    public void ax(long j) {
        this.bzz = j;
    }

    public void ay(long j) {
        this.bzA = j;
    }

    public void az(long j) {
        this.bzB = j;
    }

    public static s NW() {
        if (bzI == null) {
            synchronized (s.class) {
                if (bzI == null) {
                    bzI = new s();
                }
            }
        }
        return bzI;
    }

    public void NX() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_GET_PAGE_TIME, (Class) null);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        long j2 = (this.bzH - this.bzm) - j;
        if (j2 > 0 && !this.bzk && r.NQ().NR()) {
            this.bzk = true;
            long j3 = this.bzn - this.bzm;
            long j4 = this.bzF - this.bzm;
            long j5 = -1;
            if (this.bzD > 0) {
                j5 = this.bzE - this.bzD;
            }
            long j6 = this.bzH - this.bzG;
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "main");
            nn.append("appc", String.valueOf(j3));
            nn.append("loadclass", String.valueOf(this.bzo));
            nn.append("sapiinit", String.valueOf(this.bzp));
            nn.append("acctinit", String.valueOf(this.bzq));
            nn.append("iminit", String.valueOf(this.bzr));
            nn.append("plugininit", String.valueOf(this.bzs));
            nn.append("patchloaded", String.valueOf(this.bzt));
            nn.append("naslibinit", String.valueOf(this.bzu));
            nn.append("websocketinit", String.valueOf(this.bzv));
            nn.append("settinginit", String.valueOf(this.bzw));
            nn.append("toastinit", String.valueOf(this.bzx));
            nn.append("tiebastaticinit", String.valueOf(this.bzy));
            nn.append("locationinit", String.valueOf(this.bzz));
            nn.append("cdninit", String.valueOf(this.bzA));
            nn.append("messagesetinit", String.valueOf(this.bzB));
            nn.append("logores", String.valueOf(j4));
            if (this.bzC > 0 && this.bzD > 0 && j5 > 0) {
                nn.append("adc", String.valueOf(this.bzC));
                nn.append("adshow", String.valueOf(j5));
                nn.append("hasad", "1");
            } else {
                nn.append("hasad", "0");
            }
            nn.append("tabc", String.valueOf(j6));
            nn.append("costt", String.valueOf(j2));
            nn.append("newinst", this.bzi ? "1" : "0");
            nn.h("pluginloadsync", Boolean.valueOf(this.bzl));
            BdStatisticsManager.getInstance().performance("startt", nn);
            vB();
        }
    }

    public void aA(long j) {
        if (r.NQ().NR() && j > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("procname", "remote");
            nn.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", nn);
        }
    }

    private void vB() {
        this.bzi = false;
        this.bzj = false;
        this.bzm = -1L;
        this.bzn = -1L;
        this.bzo = -1L;
        this.bzp = -1L;
        this.bzq = -1L;
        this.bzr = -1L;
        this.bzs = -1L;
        this.bzt = -1L;
        this.bzF = -1L;
        this.bzD = -1L;
        this.bzE = -1L;
        this.bzC = -1L;
        this.bzG = -1L;
        this.bzH = -1L;
        this.bzu = -1L;
        this.bzv = -1L;
        this.bzw = -1L;
        this.bzx = -1L;
        this.bzy = -1L;
        this.bzz = -1L;
        this.bzA = -1L;
        this.bzB = -1L;
    }
}
