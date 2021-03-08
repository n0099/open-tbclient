package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes7.dex */
public class e {
    private long isq;
    private long isr;
    private long iss;
    private long ist;
    private int isu;
    private int isv;
    private boolean isw;
    private NoticeContent isx;
    private int status = 0;

    public int crt() {
        return this.isu;
    }

    public int getStatus() {
        return this.status;
    }

    public long cru() {
        return this.isq;
    }

    public long crv() {
        return this.iss;
    }

    public long crw() {
        return this.ist;
    }

    public long crx() {
        return this.isr;
    }

    public boolean cry() {
        return this.isw;
    }

    public NoticeContent crz() {
        return this.isx;
    }

    public void a(NoticeContent noticeContent) {
        this.isx = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.gd(IS(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wQ(basic.candidate_num.intValue());
        eVar.wR(basic.total_vote_num.intValue());
        eVar.gb(IS(basic.begin_apply_time));
        eVar.ge(IS(basic.begin_vote_time));
        eVar.gc(IS(basic.begin_public_time));
        eVar.pq(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long IS(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wQ(int i) {
        this.isu = i;
    }

    public void gb(long j) {
        this.isq = j;
    }

    public void gc(long j) {
        this.iss = j;
    }

    public void gd(long j) {
        this.ist = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wR(int i) {
        this.isv = i;
    }

    public void ge(long j) {
        this.isr = j;
    }

    public void pq(boolean z) {
        this.isw = z;
    }
}
