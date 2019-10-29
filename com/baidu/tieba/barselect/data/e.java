package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long eGB;
    private long eGC;
    private long eGD;
    private long eGE;
    private int eGF;
    private int eGG;
    private boolean eGH;
    private int status = 0;

    public int aZp() {
        return this.eGF;
    }

    public int getStatus() {
        return this.status;
    }

    public int aZq() {
        return this.eGG;
    }

    public long aZr() {
        return this.eGB;
    }

    public long aZs() {
        return this.eGD;
    }

    public long aZt() {
        return this.eGE;
    }

    public long aZu() {
        return this.eGC;
    }

    public boolean aZv() {
        return this.eGH;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.cu(uv(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.oA(basic.candidate_num.intValue());
        eVar.oB(basic.total_vote_num.intValue());
        eVar.cs(uv(basic.begin_apply_time));
        eVar.cv(uv(basic.begin_vote_time));
        eVar.ct(uv(basic.begin_public_time));
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

    public void oA(int i) {
        this.eGF = i;
    }

    public void cs(long j) {
        this.eGB = j;
    }

    public void ct(long j) {
        this.eGD = j;
    }

    public void cu(long j) {
        this.eGE = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void oB(int i) {
        this.eGG = i;
    }

    public void cv(long j) {
        this.eGC = j;
    }

    public void iA(boolean z) {
        this.eGH = z;
    }
}
