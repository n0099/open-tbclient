package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long erc;
    private long erd;
    private long ere;
    private long erf;
    private int erg;
    private int erh;
    private boolean eri;
    private int status = 0;

    public int aWH() {
        return this.erg;
    }

    public int getStatus() {
        return this.status;
    }

    public int aWI() {
        return this.erh;
    }

    public long aWJ() {
        return this.erc;
    }

    public long aWK() {
        return this.ere;
    }

    public long aWL() {
        return this.erf;
    }

    public long aWM() {
        return this.erd;
    }

    public boolean aWN() {
        return this.eri;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.cy(uO(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.pc(basic.candidate_num.intValue());
        eVar.pd(basic.total_vote_num.intValue());
        eVar.cw(uO(basic.begin_apply_time));
        eVar.cz(uO(basic.begin_vote_time));
        eVar.cx(uO(basic.begin_public_time));
        eVar.il(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long uO(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void pc(int i) {
        this.erg = i;
    }

    public void cw(long j) {
        this.erc = j;
    }

    public void cx(long j) {
        this.ere = j;
    }

    public void cy(long j) {
        this.erf = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void pd(int i) {
        this.erh = i;
    }

    public void cz(long j) {
        this.erd = j;
    }

    public void il(boolean z) {
        this.eri = z;
    }
}
