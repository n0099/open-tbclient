package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long fDr;
    private long fDs;
    private long fDt;
    private long fDu;
    private int fDv;
    private int fDw;
    private boolean fDx;
    private int status = 0;

    public int btX() {
        return this.fDv;
    }

    public int getStatus() {
        return this.status;
    }

    public int btY() {
        return this.fDw;
    }

    public long btZ() {
        return this.fDr;
    }

    public long bua() {
        return this.fDt;
    }

    public long bub() {
        return this.fDu;
    }

    public long buc() {
        return this.fDs;
    }

    public boolean bud() {
        return this.fDx;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dj(zO(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.rf(basic.candidate_num.intValue());
        eVar.rg(basic.total_vote_num.intValue());
        eVar.dh(zO(basic.begin_apply_time));
        eVar.dk(zO(basic.begin_vote_time));
        eVar.di(zO(basic.begin_public_time));
        eVar.ke(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long zO(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void rf(int i) {
        this.fDv = i;
    }

    public void dh(long j) {
        this.fDr = j;
    }

    public void di(long j) {
        this.fDt = j;
    }

    public void dj(long j) {
        this.fDu = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void rg(int i) {
        this.fDw = i;
    }

    public void dk(long j) {
        this.fDs = j;
    }

    public void ke(boolean z) {
        this.fDx = z;
    }
}
