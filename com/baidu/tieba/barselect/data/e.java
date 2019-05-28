package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes3.dex */
public class e {
    private long erd;
    private long ere;
    private long erf;
    private long erg;
    private int erh;
    private int eri;
    private boolean erj;
    private int status = 0;

    public int aWK() {
        return this.erh;
    }

    public int getStatus() {
        return this.status;
    }

    public int aWL() {
        return this.eri;
    }

    public long aWM() {
        return this.erd;
    }

    public long aWN() {
        return this.erf;
    }

    public long aWO() {
        return this.erg;
    }

    public long aWP() {
        return this.ere;
    }

    public boolean aWQ() {
        return this.erj;
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
        this.erh = i;
    }

    public void cw(long j) {
        this.erd = j;
    }

    public void cx(long j) {
        this.erf = j;
    }

    public void cy(long j) {
        this.erg = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void pd(int i) {
        this.eri = i;
    }

    public void cz(long j) {
        this.ere = j;
    }

    public void il(boolean z) {
        this.erj = z;
    }
}
