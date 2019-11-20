package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long eFK;
    private long eFL;
    private long eFM;
    private long eFN;
    private int eFO;
    private int eFP;
    private boolean eFQ;
    private int status = 0;

    public int aZn() {
        return this.eFO;
    }

    public int getStatus() {
        return this.status;
    }

    public int aZo() {
        return this.eFP;
    }

    public long aZp() {
        return this.eFK;
    }

    public long aZq() {
        return this.eFM;
    }

    public long aZr() {
        return this.eFN;
    }

    public long aZs() {
        return this.eFL;
    }

    public boolean aZt() {
        return this.eFQ;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.ct(uv(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.oz(basic.candidate_num.intValue());
        eVar.oA(basic.total_vote_num.intValue());
        eVar.cr(uv(basic.begin_apply_time));
        eVar.cu(uv(basic.begin_vote_time));
        eVar.cs(uv(basic.begin_public_time));
        eVar.iA(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long uv(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void oz(int i) {
        this.eFO = i;
    }

    public void cr(long j) {
        this.eFK = j;
    }

    public void cs(long j) {
        this.eFM = j;
    }

    public void ct(long j) {
        this.eFN = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void oA(int i) {
        this.eFP = i;
    }

    public void cu(long j) {
        this.eFL = j;
    }

    public void iA(boolean z) {
        this.eFQ = z;
    }
}
