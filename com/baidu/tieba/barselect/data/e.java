package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long ewi;
    private long ewj;
    private long ewk;
    private long ewl;
    private int ewm;
    private int ewn;
    private boolean ewo;
    private int status = 0;

    public int aYI() {
        return this.ewm;
    }

    public int getStatus() {
        return this.status;
    }

    public int aYJ() {
        return this.ewn;
    }

    public long aYK() {
        return this.ewi;
    }

    public long aYL() {
        return this.ewk;
    }

    public long aYM() {
        return this.ewl;
    }

    public long aYN() {
        return this.ewj;
    }

    public boolean aYO() {
        return this.ewo;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.cD(vt(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.pu(basic.candidate_num.intValue());
        eVar.pv(basic.total_vote_num.intValue());
        eVar.cB(vt(basic.begin_apply_time));
        eVar.cE(vt(basic.begin_vote_time));
        eVar.cC(vt(basic.begin_public_time));
        eVar.iu(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long vt(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void pu(int i) {
        this.ewm = i;
    }

    public void cB(long j) {
        this.ewi = j;
    }

    public void cC(long j) {
        this.ewk = j;
    }

    public void cD(long j) {
        this.ewl = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void pv(int i) {
        this.ewn = i;
    }

    public void cE(long j) {
        this.ewj = j;
    }

    public void iu(boolean z) {
        this.ewo = z;
    }
}
