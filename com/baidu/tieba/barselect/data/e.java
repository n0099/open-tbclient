package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long gxZ;
    private long gya;
    private long gyb;
    private long gyc;
    private int gyd;
    private int gye;
    private boolean gyf;
    private int status = 0;

    public int bKi() {
        return this.gyd;
    }

    public int getStatus() {
        return this.status;
    }

    public long bKj() {
        return this.gxZ;
    }

    public long bKk() {
        return this.gyb;
    }

    public long bKl() {
        return this.gyc;
    }

    public long bKm() {
        return this.gya;
    }

    public boolean bKn() {
        return this.gyf;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dS(Dj(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.se(basic.candidate_num.intValue());
        eVar.sf(basic.total_vote_num.intValue());
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

    public void se(int i) {
        this.gyd = i;
    }

    public void dQ(long j) {
        this.gxZ = j;
    }

    public void dR(long j) {
        this.gyb = j;
    }

    public void dS(long j) {
        this.gyc = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void sf(int i) {
        this.gye = i;
    }

    public void dT(long j) {
        this.gya = j;
    }

    public void lI(boolean z) {
        this.gyf = z;
    }
}
