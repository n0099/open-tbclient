package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes21.dex */
public class e {
    private long icT;
    private long icU;
    private long icV;
    private long icW;
    private int icX;
    private int icY;
    private boolean icZ;
    private NoticeContent ida;
    private int status = 0;

    public int cqT() {
        return this.icX;
    }

    public int getStatus() {
        return this.status;
    }

    public long cqU() {
        return this.icT;
    }

    public long cqV() {
        return this.icV;
    }

    public long cqW() {
        return this.icW;
    }

    public long cqX() {
        return this.icU;
    }

    public boolean cqY() {
        return this.icZ;
    }

    public NoticeContent cqZ() {
        return this.ida;
    }

    public void a(NoticeContent noticeContent) {
        this.ida = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.fY(Jm(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.xX(basic.candidate_num.intValue());
        eVar.xY(basic.total_vote_num.intValue());
        eVar.fW(Jm(basic.begin_apply_time));
        eVar.fZ(Jm(basic.begin_vote_time));
        eVar.fX(Jm(basic.begin_public_time));
        eVar.oL(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long Jm(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void xX(int i) {
        this.icX = i;
    }

    public void fW(long j) {
        this.icT = j;
    }

    public void fX(long j) {
        this.icV = j;
    }

    public void fY(long j) {
        this.icW = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xY(int i) {
        this.icY = i;
    }

    public void fZ(long j) {
        this.icU = j;
    }

    public void oL(boolean z) {
        this.icZ = z;
    }
}
