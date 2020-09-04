package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes15.dex */
public class e {
    private long hdl;
    private long hdm;
    private long hdn;
    private long hdo;
    private int hdp;
    private int hdq;
    private boolean hdr;
    private int status = 0;

    public int caL() {
        return this.hdp;
    }

    public int getStatus() {
        return this.status;
    }

    public long caM() {
        return this.hdl;
    }

    public long caN() {
        return this.hdn;
    }

    public long caO() {
        return this.hdo;
    }

    public long caP() {
        return this.hdm;
    }

    public boolean caQ() {
        return this.hdr;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.et(GV(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.vi(basic.candidate_num.intValue());
        eVar.vj(basic.total_vote_num.intValue());
        eVar.er(GV(basic.begin_apply_time));
        eVar.eu(GV(basic.begin_vote_time));
        eVar.es(GV(basic.begin_public_time));
        eVar.nb(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long GV(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void vi(int i) {
        this.hdp = i;
    }

    public void er(long j) {
        this.hdl = j;
    }

    public void es(long j) {
        this.hdn = j;
    }

    public void et(long j) {
        this.hdo = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void vj(int i) {
        this.hdq = i;
    }

    public void eu(long j) {
        this.hdm = j;
    }

    public void nb(boolean z) {
        this.hdr = z;
    }
}
