package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes8.dex */
public class e {
    private long fDt;
    private long fDu;
    private long fDv;
    private long fDw;
    private int fDx;
    private int fDy;
    private boolean fDz;
    private int status = 0;

    public int btZ() {
        return this.fDx;
    }

    public int getStatus() {
        return this.status;
    }

    public int bua() {
        return this.fDy;
    }

    public long bub() {
        return this.fDt;
    }

    public long buc() {
        return this.fDv;
    }

    public long bud() {
        return this.fDw;
    }

    public long bue() {
        return this.fDu;
    }

    public boolean buf() {
        return this.fDz;
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
        this.fDx = i;
    }

    public void dh(long j) {
        this.fDt = j;
    }

    public void di(long j) {
        this.fDv = j;
    }

    public void dj(long j) {
        this.fDw = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void rg(int i) {
        this.fDy = i;
    }

    public void dk(long j) {
        this.fDu = j;
    }

    public void ke(boolean z) {
        this.fDz = z;
    }
}
