package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab ayH = null;
    private boolean ayh = false;
    private boolean ayi = false;
    private boolean ayj = false;
    private boolean ayk = false;
    private long ayl = -1;
    private long aym = -1;
    private long ayn = -1;
    private long ayo = -1;
    private long ayp = -1;
    private long ayq = -1;
    private long ayr = -1;
    private long ays = -1;
    private long ayt = -1;
    private long ayu = -1;
    private long ayv = -1;
    private long ayw = -1;
    private long ayx = -1;
    private long ayy = -1;
    private long ayz = -1;
    private long ayA = -1;
    private long ayB = -1;
    private long ayC = -1;
    private long ayD = -1;
    private long ayE = -1;
    private long ayF = -1;
    private long ayG = -1;

    public boolean ES() {
        return this.ayi;
    }

    public void bR(boolean z) {
        this.ayh = z;
    }

    public void R(long j) {
        this.ayl = j;
    }

    public void bS(boolean z) {
        this.ayk = z;
    }

    public void S(long j) {
        this.aym = j;
    }

    public void T(long j) {
        this.ayn = j;
    }

    public void U(long j) {
        this.ayo = j;
    }

    public void V(long j) {
        this.ays = j;
    }

    public void W(long j) {
        this.ayr = j;
    }

    public void X(long j) {
        this.ayp = j;
    }

    public void Y(long j) {
        this.ayq = j;
    }

    public void Z(long j) {
        this.ayE = j;
    }

    public void aa(long j) {
        this.ayB = j;
    }

    public void ab(long j) {
        this.ayC = j;
    }

    public void ac(long j) {
        this.ayD = j;
    }

    public void ad(long j) {
        this.ayF = j;
    }

    public void ae(long j) {
        this.ayG = j;
        this.ayi = true;
    }

    public void af(long j) {
        this.ayt = j;
    }

    public void ag(long j) {
        this.ayu = j;
    }

    public void ah(long j) {
        this.ayw = j;
    }

    public void ai(long j) {
        this.ayv = j;
    }

    public void aj(long j) {
        this.ayx = j;
    }

    public void ak(long j) {
        this.ayy = j;
    }

    public void al(long j) {
        this.ayz = j;
    }

    public void am(long j) {
        this.ayA = j;
    }

    public static ab ET() {
        if (ayH == null) {
            synchronized (ab.class) {
                if (ayH == null) {
                    ayH = new ab();
                }
            }
        }
        return ayH;
    }

    public void EU() {
        long j = this.ayG - this.ayl;
        if (j > 0 && !this.ayj && aa.EN().EO()) {
            this.ayj = true;
            long j2 = this.aym - this.ayl;
            long j3 = this.ayE - this.ayl;
            long j4 = -1;
            if (this.ayC > 0) {
                j4 = this.ayD - this.ayC;
            }
            long j5 = this.ayG - this.ayF;
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("procname", "main");
            dG.q("appc", String.valueOf(j2));
            dG.q("loadclass", String.valueOf(this.ayn));
            dG.q("sapiinit", String.valueOf(this.ayo));
            dG.q("acctinit", String.valueOf(this.ayp));
            dG.q("iminit", String.valueOf(this.ayq));
            dG.q("plugininit", String.valueOf(this.ayr));
            dG.q("patchloaded", String.valueOf(this.ays));
            dG.q("naslibinit", String.valueOf(this.ayt));
            dG.q("websocketinit", String.valueOf(this.ayu));
            dG.q("settinginit", String.valueOf(this.ayv));
            dG.q("toastinit", String.valueOf(this.ayw));
            dG.q("tiebastaticinit", String.valueOf(this.ayx));
            dG.q("locationinit", String.valueOf(this.ayy));
            dG.q("cdninit", String.valueOf(this.ayz));
            dG.q("messagesetinit", String.valueOf(this.ayA));
            dG.q("logores", String.valueOf(j3));
            if (this.ayB > 0 && this.ayC > 0 && j4 > 0) {
                dG.q("adc", String.valueOf(this.ayB));
                dG.q("adshow", String.valueOf(j4));
                dG.q("hasad", "1");
            } else {
                dG.q("hasad", "0");
            }
            dG.q("tabc", String.valueOf(j5));
            dG.q("costt", String.valueOf(j));
            dG.q("newinst", this.ayh ? "1" : "0");
            dG.b("pluginloadsync", Boolean.valueOf(this.ayk));
            com.baidu.adp.lib.stats.a.dN().a("startt", dG);
            ng();
        }
    }

    public void an(long j) {
        if (aa.EN().EO() && j > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("procname", "remote");
            dG.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dN().a("startt", dG);
        }
    }

    private void ng() {
        this.ayh = false;
        this.ayi = false;
        this.ayl = -1L;
        this.aym = -1L;
        this.ayn = -1L;
        this.ayo = -1L;
        this.ayp = -1L;
        this.ayq = -1L;
        this.ayr = -1L;
        this.ays = -1L;
        this.ayE = -1L;
        this.ayC = -1L;
        this.ayD = -1L;
        this.ayB = -1L;
        this.ayF = -1L;
        this.ayG = -1L;
        this.ayt = -1L;
        this.ayu = -1L;
        this.ayv = -1L;
        this.ayw = -1L;
        this.ayx = -1L;
        this.ayy = -1L;
        this.ayz = -1L;
        this.ayA = -1L;
    }
}
