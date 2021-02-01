package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes8.dex */
public class e {
    private NoticeContent iqA;
    private long iqt;
    private long iqu;
    private long iqv;
    private long iqw;
    private int iqx;
    private int iqy;
    private boolean iqz;
    private int status = 0;

    public int crg() {
        return this.iqx;
    }

    public int getStatus() {
        return this.status;
    }

    public long crh() {
        return this.iqt;
    }

    public long cri() {
        return this.iqv;
    }

    public long crj() {
        return this.iqw;
    }

    public long crk() {
        return this.iqu;
    }

    public boolean crl() {
        return this.iqz;
    }

    public NoticeContent crm() {
        return this.iqA;
    }

    public void a(NoticeContent noticeContent) {
        this.iqA = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.gd(II(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wP(basic.candidate_num.intValue());
        eVar.wQ(basic.total_vote_num.intValue());
        eVar.gb(II(basic.begin_apply_time));
        eVar.ge(II(basic.begin_vote_time));
        eVar.gc(II(basic.begin_public_time));
        eVar.pq(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long II(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wP(int i) {
        this.iqx = i;
    }

    public void gb(long j) {
        this.iqt = j;
    }

    public void gc(long j) {
        this.iqv = j;
    }

    public void gd(long j) {
        this.iqw = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wQ(int i) {
        this.iqy = i;
    }

    public void ge(long j) {
        this.iqu = j;
    }

    public void pq(boolean z) {
        this.iqz = z;
    }
}
