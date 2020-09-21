package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes20.dex */
public class e {
    private long hkm;
    private long hkn;
    private long hko;
    private long hkp;
    private int hkq;
    private int hkr;
    private boolean hks;
    private NoticeContent hkt;
    private int status = 0;

    public int cdZ() {
        return this.hkq;
    }

    public int getStatus() {
        return this.status;
    }

    public long cea() {
        return this.hkm;
    }

    public long ceb() {
        return this.hko;
    }

    public long cec() {
        return this.hkp;
    }

    public long ced() {
        return this.hkn;
    }

    public boolean cee() {
        return this.hks;
    }

    public NoticeContent cef() {
        return this.hkt;
    }

    public void a(NoticeContent noticeContent) {
        this.hkt = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.eD(Hs(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.vH(basic.candidate_num.intValue());
        eVar.vI(basic.total_vote_num.intValue());
        eVar.eB(Hs(basic.begin_apply_time));
        eVar.eE(Hs(basic.begin_vote_time));
        eVar.eC(Hs(basic.begin_public_time));
        eVar.nh(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long Hs(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void vH(int i) {
        this.hkq = i;
    }

    public void eB(long j) {
        this.hkm = j;
    }

    public void eC(long j) {
        this.hko = j;
    }

    public void eD(long j) {
        this.hkp = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void vI(int i) {
        this.hkr = i;
    }

    public void eE(long j) {
        this.hkn = j;
    }

    public void nh(boolean z) {
        this.hks = z;
    }
}
