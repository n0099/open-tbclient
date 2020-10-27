package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes21.dex */
public class e {
    private long hLD;
    private long hLE;
    private long hLF;
    private long hLG;
    private int hLH;
    private int hLI;
    private boolean hLJ;
    private NoticeContent hLK;
    private int status = 0;

    public int ckC() {
        return this.hLH;
    }

    public int getStatus() {
        return this.status;
    }

    public long ckD() {
        return this.hLD;
    }

    public long ckE() {
        return this.hLF;
    }

    public long ckF() {
        return this.hLG;
    }

    public long ckG() {
        return this.hLE;
    }

    public boolean ckH() {
        return this.hLJ;
    }

    public NoticeContent ckI() {
        return this.hLK;
    }

    public void a(NoticeContent noticeContent) {
        this.hLK = noticeContent;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.eV(IE(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.wG(basic.candidate_num.intValue());
        eVar.wH(basic.total_vote_num.intValue());
        eVar.eT(IE(basic.begin_apply_time));
        eVar.eW(IE(basic.begin_vote_time));
        eVar.eU(IE(basic.begin_public_time));
        eVar.oe(basic.is_voted.booleanValue());
        eVar.a(basic.notice);
        return eVar;
    }

    private static long IE(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void wG(int i) {
        this.hLH = i;
    }

    public void eT(long j) {
        this.hLD = j;
    }

    public void eU(long j) {
        this.hLF = j;
    }

    public void eV(long j) {
        this.hLG = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wH(int i) {
        this.hLI = i;
    }

    public void eW(long j) {
        this.hLE = j;
    }

    public void oe(boolean z) {
        this.hLJ = z;
    }
}
