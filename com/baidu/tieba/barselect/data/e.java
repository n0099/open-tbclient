package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes20.dex */
public class e {
    private long hSa;
    private long hSb;
    private long hSc;
    private long hSd;
    private int hSe;
    private int hSf;
    private boolean hSg;
    private NoticeContent hSh;
    private int status = 0;

    public int cmG() {
        return this.hSe;
    }

    public int getStatus() {
        return this.status;
    }

    public long cmH() {
        return this.hSa;
    }

    public long cmI() {
        return this.hSc;
    }

    public long cmJ() {
        return this.hSd;
    }

    public long cmK() {
        return this.hSb;
    }

    public boolean cmL() {
        return this.hSg;
    }

    public NoticeContent cmM() {
        return this.hSh;
    }

    public void a(NoticeContent noticeContent) {
        this.hSh = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.fu(Iw(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.xr(basic.candidate_num.intValue());
        eVar.xs(basic.total_vote_num.intValue());
        eVar.fs(Iw(basic.begin_apply_time));
        eVar.fv(Iw(basic.begin_vote_time));
        eVar.ft(Iw(basic.begin_public_time));
        eVar.op(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long Iw(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void xr(int i) {
        this.hSe = i;
    }

    public void fs(long j) {
        this.hSa = j;
    }

    public void ft(long j) {
        this.hSc = j;
    }

    public void fu(long j) {
        this.hSd = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xs(int i) {
        this.hSf = i;
    }

    public void fv(long j) {
        this.hSb = j;
    }

    public void op(boolean z) {
        this.hSg = z;
    }
}
