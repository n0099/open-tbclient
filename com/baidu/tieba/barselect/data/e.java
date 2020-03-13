package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long fDG;
    private long fDH;
    private long fDI;
    private long fDJ;
    private int fDK;
    private int fDL;
    private boolean fDM;
    private int status = 0;

    public int bua() {
        return this.fDK;
    }

    public int getStatus() {
        return this.status;
    }

    public int bub() {
        return this.fDL;
    }

    public long buc() {
        return this.fDG;
    }

    public long bud() {
        return this.fDI;
    }

    public long bue() {
        return this.fDJ;
    }

    public long buf() {
        return this.fDH;
    }

    public boolean bug() {
        return this.fDM;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dj(zP(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.rf(basic.candidate_num.intValue());
        eVar.rg(basic.total_vote_num.intValue());
        eVar.dh(zP(basic.begin_apply_time));
        eVar.dk(zP(basic.begin_vote_time));
        eVar.di(zP(basic.begin_public_time));
        eVar.ke(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long zP(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void rf(int i) {
        this.fDK = i;
    }

    public void dh(long j) {
        this.fDG = j;
    }

    public void di(long j) {
        this.fDI = j;
    }

    public void dj(long j) {
        this.fDJ = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void rg(int i) {
        this.fDL = i;
    }

    public void dk(long j) {
        this.fDH = j;
    }

    public void ke(boolean z) {
        this.fDM = z;
    }
}
