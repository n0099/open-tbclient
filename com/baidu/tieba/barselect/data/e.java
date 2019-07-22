package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long ewb;
    private long ewc;
    private long ewd;
    private long ewe;
    private int ewf;
    private int ewg;
    private boolean ewh;
    private int status = 0;

    public int aYG() {
        return this.ewf;
    }

    public int getStatus() {
        return this.status;
    }

    public int aYH() {
        return this.ewg;
    }

    public long aYI() {
        return this.ewb;
    }

    public long aYJ() {
        return this.ewd;
    }

    public long aYK() {
        return this.ewe;
    }

    public long aYL() {
        return this.ewc;
    }

    public boolean aYM() {
        return this.ewh;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.cD(vs(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.pt(basic.candidate_num.intValue());
        eVar.pu(basic.total_vote_num.intValue());
        eVar.cB(vs(basic.begin_apply_time));
        eVar.cE(vs(basic.begin_vote_time));
        eVar.cC(vs(basic.begin_public_time));
        eVar.iu(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long vs(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void pt(int i) {
        this.ewf = i;
    }

    public void cB(long j) {
        this.ewb = j;
    }

    public void cC(long j) {
        this.ewd = j;
    }

    public void cD(long j) {
        this.ewe = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void pu(int i) {
        this.ewg = i;
    }

    public void cE(long j) {
        this.ewc = j;
    }

    public void iu(boolean z) {
        this.ewh = z;
    }
}
