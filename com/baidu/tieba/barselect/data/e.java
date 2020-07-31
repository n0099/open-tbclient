package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes15.dex */
public class e {
    private long gQr;
    private long gQs;
    private long gQt;
    private long gQu;
    private int gQv;
    private int gQw;
    private boolean gQx;
    private int status = 0;

    public int bQz() {
        return this.gQv;
    }

    public int getStatus() {
        return this.status;
    }

    public long bQA() {
        return this.gQr;
    }

    public long bQB() {
        return this.gQt;
    }

    public long bQC() {
        return this.gQu;
    }

    public long bQD() {
        return this.gQs;
    }

    public boolean bQE() {
        return this.gQx;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.ei(Ev(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.sU(basic.candidate_num.intValue());
        eVar.sV(basic.total_vote_num.intValue());
        eVar.eg(Ev(basic.begin_apply_time));
        eVar.ej(Ev(basic.begin_vote_time));
        eVar.eh(Ev(basic.begin_public_time));
        eVar.mw(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long Ev(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void sU(int i) {
        this.gQv = i;
    }

    public void eg(long j) {
        this.gQr = j;
    }

    public void eh(long j) {
        this.gQt = j;
    }

    public void ei(long j) {
        this.gQu = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void sV(int i) {
        this.gQw = i;
    }

    public void ej(long j) {
        this.gQs = j;
    }

    public void mw(boolean z) {
        this.gQx = z;
    }
}
