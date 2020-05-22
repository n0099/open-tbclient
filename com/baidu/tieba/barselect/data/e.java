package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long gxO;
    private long gxP;
    private long gxQ;
    private long gxR;
    private int gxS;
    private int gxT;
    private boolean gxU;
    private int status = 0;

    public int bKg() {
        return this.gxS;
    }

    public int getStatus() {
        return this.status;
    }

    public long bKh() {
        return this.gxO;
    }

    public long bKi() {
        return this.gxQ;
    }

    public long bKj() {
        return this.gxR;
    }

    public long bKk() {
        return this.gxP;
    }

    public boolean bKl() {
        return this.gxU;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dS(Dj(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.sc(basic.candidate_num.intValue());
        eVar.sd(basic.total_vote_num.intValue());
        eVar.dQ(Dj(basic.begin_apply_time));
        eVar.dT(Dj(basic.begin_vote_time));
        eVar.dR(Dj(basic.begin_public_time));
        eVar.lI(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long Dj(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void sc(int i) {
        this.gxS = i;
    }

    public void dQ(long j) {
        this.gxO = j;
    }

    public void dR(long j) {
        this.gxQ = j;
    }

    public void dS(long j) {
        this.gxR = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void sd(int i) {
        this.gxT = i;
    }

    public void dT(long j) {
        this.gxP = j;
    }

    public void lI(boolean z) {
        this.gxU = z;
    }
}
