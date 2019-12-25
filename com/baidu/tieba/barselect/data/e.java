package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes5.dex */
public class e {
    private long fxI;
    private long fxJ;
    private long fxK;
    private long fxL;
    private int fxM;
    private int fxN;
    private boolean fxO;
    private int status = 0;

    public int brr() {
        return this.fxM;
    }

    public int getStatus() {
        return this.status;
    }

    public int brs() {
        return this.fxN;
    }

    public long brt() {
        return this.fxI;
    }

    public long bru() {
        return this.fxK;
    }

    public long brv() {
        return this.fxL;
    }

    public long brw() {
        return this.fxJ;
    }

    public boolean brx() {
        return this.fxO;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dc(zo(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.qT(basic.candidate_num.intValue());
        eVar.qU(basic.total_vote_num.intValue());
        eVar.da(zo(basic.begin_apply_time));
        eVar.dd(zo(basic.begin_vote_time));
        eVar.db(zo(basic.begin_public_time));
        eVar.jR(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long zo(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void qT(int i) {
        this.fxM = i;
    }

    public void da(long j) {
        this.fxI = j;
    }

    public void db(long j) {
        this.fxK = j;
    }

    public void dc(long j) {
        this.fxL = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void qU(int i) {
        this.fxN = i;
    }

    public void dd(long j) {
        this.fxJ = j;
    }

    public void jR(boolean z) {
        this.fxO = z;
    }
}
