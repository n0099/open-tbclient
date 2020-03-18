package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long fEo;
    private long fEp;
    private long fEq;
    private long fEr;
    private int fEs;
    private int fEt;
    private boolean fEu;
    private int status = 0;

    public int buf() {
        return this.fEs;
    }

    public int getStatus() {
        return this.status;
    }

    public int bug() {
        return this.fEt;
    }

    public long buh() {
        return this.fEo;
    }

    public long bui() {
        return this.fEq;
    }

    public long buj() {
        return this.fEr;
    }

    public long buk() {
        return this.fEp;
    }

    public boolean bul() {
        return this.fEu;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dj(zQ(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.rh(basic.candidate_num.intValue());
        eVar.ri(basic.total_vote_num.intValue());
        eVar.dh(zQ(basic.begin_apply_time));
        eVar.dk(zQ(basic.begin_vote_time));
        eVar.di(zQ(basic.begin_public_time));
        eVar.kj(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long zQ(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void rh(int i) {
        this.fEs = i;
    }

    public void dh(long j) {
        this.fEo = j;
    }

    public void di(long j) {
        this.fEq = j;
    }

    public void dj(long j) {
        this.fEr = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void ri(int i) {
        this.fEt = i;
    }

    public void dk(long j) {
        this.fEp = j;
    }

    public void kj(boolean z) {
        this.fEu = z;
    }
}
