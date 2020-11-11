package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes21.dex */
public class e {
    private long hRA;
    private long hRB;
    private long hRC;
    private long hRD;
    private int hRE;
    private int hRF;
    private boolean hRG;
    private NoticeContent hRH;
    private int status = 0;

    public int cne() {
        return this.hRE;
    }

    public int getStatus() {
        return this.status;
    }

    public long cnf() {
        return this.hRA;
    }

    public long cng() {
        return this.hRC;
    }

    public long cnh() {
        return this.hRD;
    }

    public long cni() {
        return this.hRB;
    }

    public boolean cnj() {
        return this.hRG;
    }

    public NoticeContent cnk() {
        return this.hRH;
    }

    public void a(NoticeContent noticeContent) {
        this.hRH = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.fr(IV(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wT(basic.candidate_num.intValue());
        eVar.wU(basic.total_vote_num.intValue());
        eVar.fp(IV(basic.begin_apply_time));
        eVar.fs(IV(basic.begin_vote_time));
        eVar.fq(IV(basic.begin_public_time));
        eVar.on(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long IV(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wT(int i) {
        this.hRE = i;
    }

    public void fp(long j) {
        this.hRA = j;
    }

    public void fq(long j) {
        this.hRC = j;
    }

    public void fr(long j) {
        this.hRD = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wU(int i) {
        this.hRF = i;
    }

    public void fs(long j) {
        this.hRB = j;
    }

    public void on(boolean z) {
        this.hRG = z;
    }
}
