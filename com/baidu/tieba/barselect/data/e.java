package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long gKL;
    private long gKM;
    private long gKN;
    private long gKO;
    private int gKP;
    private int gKQ;
    private boolean gKR;
    private int status = 0;

    public int bNo() {
        return this.gKP;
    }

    public int getStatus() {
        return this.status;
    }

    public long bNp() {
        return this.gKL;
    }

    public long bNq() {
        return this.gKN;
    }

    public long bNr() {
        return this.gKO;
    }

    public long bNs() {
        return this.gKM;
    }

    public boolean bNt() {
        return this.gKR;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dV(DK(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.sC(basic.candidate_num.intValue());
        eVar.sD(basic.total_vote_num.intValue());
        eVar.dT(DK(basic.begin_apply_time));
        eVar.dW(DK(basic.begin_vote_time));
        eVar.dU(DK(basic.begin_public_time));
        eVar.lR(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long DK(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void sC(int i) {
        this.gKP = i;
    }

    public void dT(long j) {
        this.gKL = j;
    }

    public void dU(long j) {
        this.gKN = j;
    }

    public void dV(long j) {
        this.gKO = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void sD(int i) {
        this.gKQ = i;
    }

    public void dW(long j) {
        this.gKM = j;
    }

    public void lR(boolean z) {
        this.gKR = z;
    }
}
