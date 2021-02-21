package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes8.dex */
public class e {
    private long iqH;
    private long iqI;
    private long iqJ;
    private long iqK;
    private int iqL;
    private int iqM;
    private boolean iqN;
    private NoticeContent iqO;
    private int status = 0;

    public int crn() {
        return this.iqL;
    }

    public int getStatus() {
        return this.status;
    }

    public long cro() {
        return this.iqH;
    }

    public long crp() {
        return this.iqJ;
    }

    public long crq() {
        return this.iqK;
    }

    public long crr() {
        return this.iqI;
    }

    public boolean crs() {
        return this.iqN;
    }

    public NoticeContent crt() {
        return this.iqO;
    }

    public void a(NoticeContent noticeContent) {
        this.iqO = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.gd(IJ(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wP(basic.candidate_num.intValue());
        eVar.wQ(basic.total_vote_num.intValue());
        eVar.gb(IJ(basic.begin_apply_time));
        eVar.ge(IJ(basic.begin_vote_time));
        eVar.gc(IJ(basic.begin_public_time));
        eVar.pq(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long IJ(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wP(int i) {
        this.iqL = i;
    }

    public void gb(long j) {
        this.iqH = j;
    }

    public void gc(long j) {
        this.iqJ = j;
    }

    public void gd(long j) {
        this.iqK = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wQ(int i) {
        this.iqM = i;
    }

    public void ge(long j) {
        this.iqI = j;
    }

    public void pq(boolean z) {
        this.iqN = z;
    }
}
