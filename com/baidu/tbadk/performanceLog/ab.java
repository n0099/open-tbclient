package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends z {
    private static ab azx = null;
    private boolean ayX = false;
    private boolean ayY = false;
    private boolean ayZ = false;
    private boolean aza = false;
    private long azb = -1;
    private long azc = -1;
    private long azd = -1;
    private long aze = -1;
    private long azf = -1;
    private long azg = -1;
    private long azh = -1;
    private long azi = -1;
    private long azj = -1;
    private long azk = -1;
    private long azl = -1;
    private long azm = -1;
    private long azn = -1;
    private long azo = -1;
    private long azp = -1;
    private long azq = -1;
    private long azr = -1;
    private long azs = -1;
    private long azt = -1;
    private long azu = -1;
    private long azv = -1;
    private long azw = -1;

    public boolean Fb() {
        return this.ayY;
    }

    public void bQ(boolean z) {
        this.ayX = z;
    }

    public void U(long j) {
        this.azb = j;
    }

    public void bR(boolean z) {
        this.aza = z;
    }

    public void V(long j) {
        this.azc = j;
    }

    public void W(long j) {
        this.azd = j;
    }

    public void X(long j) {
        this.aze = j;
    }

    public void Y(long j) {
        this.azi = j;
    }

    public void Z(long j) {
        this.azh = j;
    }

    public void aa(long j) {
        this.azf = j;
    }

    public void ab(long j) {
        this.azg = j;
    }

    public void ac(long j) {
        this.azu = j;
    }

    public void ad(long j) {
        this.azr = j;
    }

    public void ae(long j) {
        this.azs = j;
    }

    public void af(long j) {
        this.azt = j;
    }

    public void ag(long j) {
        this.azv = j;
    }

    public void ah(long j) {
        this.azw = j;
        this.ayY = true;
    }

    public void ai(long j) {
        this.azj = j;
    }

    public void aj(long j) {
        this.azk = j;
    }

    public void ak(long j) {
        this.azm = j;
    }

    public void al(long j) {
        this.azl = j;
    }

    public void am(long j) {
        this.azn = j;
    }

    public void an(long j) {
        this.azo = j;
    }

    public void ao(long j) {
        this.azp = j;
    }

    public void ap(long j) {
        this.azq = j;
    }

    public static ab Fc() {
        if (azx == null) {
            synchronized (ab.class) {
                if (azx == null) {
                    azx = new ab();
                }
            }
        }
        return azx;
    }

    public void Fd() {
        long j = this.azw - this.azb;
        if (j > 0 && !this.ayZ && aa.EW().EX()) {
            this.ayZ = true;
            long j2 = this.azc - this.azb;
            long j3 = this.azu - this.azb;
            long j4 = -1;
            if (this.azs > 0) {
                j4 = this.azt - this.azs;
            }
            long j5 = this.azw - this.azv;
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("procname", "main");
            dH.q("appc", String.valueOf(j2));
            dH.q("loadclass", String.valueOf(this.azd));
            dH.q("sapiinit", String.valueOf(this.aze));
            dH.q("acctinit", String.valueOf(this.azf));
            dH.q("iminit", String.valueOf(this.azg));
            dH.q("plugininit", String.valueOf(this.azh));
            dH.q("patchloaded", String.valueOf(this.azi));
            dH.q("naslibinit", String.valueOf(this.azj));
            dH.q("websocketinit", String.valueOf(this.azk));
            dH.q("settinginit", String.valueOf(this.azl));
            dH.q("toastinit", String.valueOf(this.azm));
            dH.q("tiebastaticinit", String.valueOf(this.azn));
            dH.q("locationinit", String.valueOf(this.azo));
            dH.q("cdninit", String.valueOf(this.azp));
            dH.q("messagesetinit", String.valueOf(this.azq));
            dH.q("logores", String.valueOf(j3));
            if (this.azr > 0 && this.azs > 0 && j4 > 0) {
                dH.q("adc", String.valueOf(this.azr));
                dH.q("adshow", String.valueOf(j4));
                dH.q("hasad", "1");
            } else {
                dH.q("hasad", "0");
            }
            dH.q("tabc", String.valueOf(j5));
            dH.q("costt", String.valueOf(j));
            dH.q("newinst", this.ayX ? "1" : "0");
            dH.b("pluginloadsync", Boolean.valueOf(this.aza));
            com.baidu.adp.lib.stats.a.dO().a("startt", dH);
            nb();
        }
    }

    public void aq(long j) {
        if (aa.EW().EX() && j > 0) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("procname", "remote");
            dH.q("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dO().a("startt", dH);
        }
    }

    private void nb() {
        this.ayX = false;
        this.ayY = false;
        this.azb = -1L;
        this.azc = -1L;
        this.azd = -1L;
        this.aze = -1L;
        this.azf = -1L;
        this.azg = -1L;
        this.azh = -1L;
        this.azi = -1L;
        this.azu = -1L;
        this.azs = -1L;
        this.azt = -1L;
        this.azr = -1L;
        this.azv = -1L;
        this.azw = -1L;
        this.azj = -1L;
        this.azk = -1L;
        this.azl = -1L;
        this.azm = -1L;
        this.azn = -1L;
        this.azo = -1L;
        this.azp = -1L;
        this.azq = -1L;
    }
}
