package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes7.dex */
public class e {
    private long ikL;
    private long ikM;
    private long ikN;
    private long ikO;
    private int ikP;
    private int ikQ;
    private boolean ikR;
    private NoticeContent ikS;
    private int status = 0;

    public int cpW() {
        return this.ikP;
    }

    public int getStatus() {
        return this.status;
    }

    public long cpX() {
        return this.ikL;
    }

    public long cpY() {
        return this.ikN;
    }

    public long cpZ() {
        return this.ikO;
    }

    public long cqa() {
        return this.ikM;
    }

    public boolean cqb() {
        return this.ikR;
    }

    public NoticeContent cqc() {
        return this.ikS;
    }

    public void a(NoticeContent noticeContent) {
        this.ikS = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.fY(HY(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wE(basic.candidate_num.intValue());
        eVar.wF(basic.total_vote_num.intValue());
        eVar.fW(HY(basic.begin_apply_time));
        eVar.fZ(HY(basic.begin_vote_time));
        eVar.fX(HY(basic.begin_public_time));
        eVar.pg(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long HY(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wE(int i) {
        this.ikP = i;
    }

    public void fW(long j) {
        this.ikL = j;
    }

    public void fX(long j) {
        this.ikN = j;
    }

    public void fY(long j) {
        this.ikO = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wF(int i) {
        this.ikQ = i;
    }

    public void fZ(long j) {
        this.ikM = j;
    }

    public void pg(boolean z) {
        this.ikR = z;
    }
}
