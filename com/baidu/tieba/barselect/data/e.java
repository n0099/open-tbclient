package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long giY;
    private long giZ;
    private long gja;
    private long gjb;
    private int gjc;
    private int gjd;
    private boolean gje;
    private int status = 0;

    public int bDP() {
        return this.gjc;
    }

    public int getStatus() {
        return this.status;
    }

    public long bDQ() {
        return this.giY;
    }

    public long bDR() {
        return this.gja;
    }

    public long bDS() {
        return this.gjb;
    }

    public long bDT() {
        return this.giZ;
    }

    public boolean bDU() {
        return this.gje;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dR(BA(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.rz(basic.candidate_num.intValue());
        eVar.rA(basic.total_vote_num.intValue());
        eVar.dP(BA(basic.begin_apply_time));
        eVar.dS(BA(basic.begin_vote_time));
        eVar.dQ(BA(basic.begin_public_time));
        eVar.lm(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long BA(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void rz(int i) {
        this.gjc = i;
    }

    public void dP(long j) {
        this.giY = j;
    }

    public void dQ(long j) {
        this.gja = j;
    }

    public void dR(long j) {
        this.gjb = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void rA(int i) {
        this.gjd = i;
    }

    public void dS(long j) {
        this.giZ = j;
    }

    public void lm(boolean z) {
        this.gje = z;
    }
}
