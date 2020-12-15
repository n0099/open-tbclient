package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes21.dex */
public class e {
    private long icV;
    private long icW;
    private long icX;
    private long icY;
    private int icZ;
    private int ida;
    private boolean idb;
    private NoticeContent idc;
    private int status = 0;

    public int cqU() {
        return this.icZ;
    }

    public int getStatus() {
        return this.status;
    }

    public long cqV() {
        return this.icV;
    }

    public long cqW() {
        return this.icX;
    }

    public long cqX() {
        return this.icY;
    }

    public long cqY() {
        return this.icW;
    }

    public boolean cqZ() {
        return this.idb;
    }

    public NoticeContent cra() {
        return this.idc;
    }

    public void a(NoticeContent noticeContent) {
        this.idc = noticeContent;
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
        this.icZ = i;
    }

    public void fW(long j) {
        this.icV = j;
    }

    public void fX(long j) {
        this.icX = j;
    }

    public void fY(long j) {
        this.icY = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xY(int i) {
        this.ida = i;
    }

    public void fZ(long j) {
        this.icW = j;
    }

    public void oL(boolean z) {
        this.idb = z;
    }
}
