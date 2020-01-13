package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes6.dex */
public class e {
    private long fAT;
    private long fAU;
    private long fAV;
    private long fAW;
    private int fAX;
    private int fAY;
    private boolean fAZ;
    private int status = 0;

    public int bst() {
        return this.fAX;
    }

    public int getStatus() {
        return this.status;
    }

    public int bsu() {
        return this.fAY;
    }

    public long bsv() {
        return this.fAT;
    }

    public long bsw() {
        return this.fAV;
    }

    public long bsx() {
        return this.fAW;
    }

    public long bsy() {
        return this.fAU;
    }

    public boolean bsz() {
        return this.fAZ;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.dh(zy(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.qY(basic.candidate_num.intValue());
        eVar.qZ(basic.total_vote_num.intValue());
        eVar.df(zy(basic.begin_apply_time));
        eVar.di(zy(basic.begin_vote_time));
        eVar.dg(zy(basic.begin_public_time));
        eVar.kc(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long zy(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void qY(int i) {
        this.fAX = i;
    }

    public void df(long j) {
        this.fAT = j;
    }

    public void dg(long j) {
        this.fAV = j;
    }

    public void dh(long j) {
        this.fAW = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void qZ(int i) {
        this.fAY = i;
    }

    public void di(long j) {
        this.fAU = j;
    }

    public void kc(boolean z) {
        this.fAZ = z;
    }
}
