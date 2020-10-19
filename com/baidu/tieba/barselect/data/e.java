package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes21.dex */
public class e {
    private long hzh;
    private long hzi;
    private long hzj;
    private long hzk;
    private int hzl;
    private int hzm;
    private boolean hzn;
    private NoticeContent hzo;
    private int status = 0;

    public int chv() {
        return this.hzl;
    }

    public int getStatus() {
        return this.status;
    }

    public long chw() {
        return this.hzh;
    }

    public long chx() {
        return this.hzj;
    }

    public long chy() {
        return this.hzk;
    }

    public long chz() {
        return this.hzi;
    }

    public boolean chA() {
        return this.hzn;
    }

    public NoticeContent chB() {
        return this.hzo;
    }

    public void a(NoticeContent noticeContent) {
        this.hzo = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.eU(If(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wn(basic.candidate_num.intValue());
        eVar.wo(basic.total_vote_num.intValue());
        eVar.eS(If(basic.begin_apply_time));
        eVar.eV(If(basic.begin_vote_time));
        eVar.eT(If(basic.begin_public_time));
        eVar.nM(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long If(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wn(int i) {
        this.hzl = i;
    }

    public void eS(long j) {
        this.hzh = j;
    }

    public void eT(long j) {
        this.hzj = j;
    }

    public void eU(long j) {
        this.hzk = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wo(int i) {
        this.hzm = i;
    }

    public void eV(long j) {
        this.hzi = j;
    }

    public void nM(boolean z) {
        this.hzn = z;
    }
}
