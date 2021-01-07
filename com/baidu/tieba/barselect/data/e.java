package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes8.dex */
public class e {
    private boolean ipA;
    private NoticeContent ipB;
    private long ipu;
    private long ipv;
    private long ipw;
    private long ipx;
    private int ipy;
    private int ipz;
    private int status = 0;

    public int ctO() {
        return this.ipy;
    }

    public int getStatus() {
        return this.status;
    }

    public long ctP() {
        return this.ipu;
    }

    public long ctQ() {
        return this.ipw;
    }

    public long ctR() {
        return this.ipx;
    }

    public long ctS() {
        return this.ipv;
    }

    public boolean ctT() {
        return this.ipA;
    }

    public NoticeContent ctU() {
        return this.ipB;
    }

    public void a(NoticeContent noticeContent) {
        this.ipB = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.fY(Jj(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.yk(basic.candidate_num.intValue());
        eVar.yl(basic.total_vote_num.intValue());
        eVar.fW(Jj(basic.begin_apply_time));
        eVar.fZ(Jj(basic.begin_vote_time));
        eVar.fX(Jj(basic.begin_public_time));
        eVar.pk(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long Jj(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void yk(int i) {
        this.ipy = i;
    }

    public void fW(long j) {
        this.ipu = j;
    }

    public void fX(long j) {
        this.ipw = j;
    }

    public void fY(long j) {
        this.ipx = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yl(int i) {
        this.ipz = i;
    }

    public void fZ(long j) {
        this.ipv = j;
    }

    public void pk(boolean z) {
        this.ipA = z;
    }
}
