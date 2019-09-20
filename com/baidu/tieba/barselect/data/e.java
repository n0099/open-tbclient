package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long exS;
    private long exT;
    private long exU;
    private long exV;
    private int exW;
    private int exX;
    private boolean exY;
    private int status = 0;

    public int aZm() {
        return this.exW;
    }

    public int getStatus() {
        return this.status;
    }

    public int aZn() {
        return this.exX;
    }

    public long aZo() {
        return this.exS;
    }

    public long aZp() {
        return this.exU;
    }

    public long aZq() {
        return this.exV;
    }

    public long aZr() {
        return this.exT;
    }

    public boolean aZs() {
        return this.exY;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.cG(vS(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.py(basic.candidate_num.intValue());
        eVar.pz(basic.total_vote_num.intValue());
        eVar.cE(vS(basic.begin_apply_time));
        eVar.cH(vS(basic.begin_vote_time));
        eVar.cF(vS(basic.begin_public_time));
        eVar.ix(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long vS(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void py(int i) {
        this.exW = i;
    }

    public void cE(long j) {
        this.exS = j;
    }

    public void cF(long j) {
        this.exU = j;
    }

    public void cG(long j) {
        this.exV = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void pz(int i) {
        this.exX = i;
    }

    public void cH(long j) {
        this.exT = j;
    }

    public void ix(boolean z) {
        this.exY = z;
    }
}
