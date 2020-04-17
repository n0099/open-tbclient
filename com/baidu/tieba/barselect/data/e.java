package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long giS;
    private long giT;
    private long giU;
    private long giV;
    private int giW;
    private int giX;
    private boolean giY;
    private int status = 0;

    public int bDQ() {
        return this.giW;
    }

    public int getStatus() {
        return this.status;
    }

    public long bDR() {
        return this.giS;
    }

    public long bDS() {
        return this.giU;
    }

    public long bDT() {
        return this.giV;
    }

    public long bDU() {
        return this.giT;
    }

    public boolean bDV() {
        return this.giY;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dR(Bx(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.rz(basic.candidate_num.intValue());
        eVar.rA(basic.total_vote_num.intValue());
        eVar.dP(Bx(basic.begin_apply_time));
        eVar.dS(Bx(basic.begin_vote_time));
        eVar.dQ(Bx(basic.begin_public_time));
        eVar.lm(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long Bx(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void rz(int i) {
        this.giW = i;
    }

    public void dP(long j) {
        this.giS = j;
    }

    public void dQ(long j) {
        this.giU = j;
    }

    public void dR(long j) {
        this.giV = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void rA(int i) {
        this.giX = i;
    }

    public void dS(long j) {
        this.giT = j;
    }

    public void lm(boolean z) {
        this.giY = z;
    }
}
