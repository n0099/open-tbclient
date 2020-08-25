package com.baidu.tieba.barselect.data;

import tbclient.ElectionInfo.Basic;
/* loaded from: classes15.dex */
public class e {
    private long hdh;
    private long hdi;
    private long hdj;
    private long hdk;
    private int hdl;
    private int hdm;
    private boolean hdn;
    private int status = 0;

    public int caK() {
        return this.hdl;
    }

    public int getStatus() {
        return this.status;
    }

    public long caL() {
        return this.hdh;
    }

    public long caM() {
        return this.hdj;
    }

    public long caN() {
        return this.hdk;
    }

    public long caO() {
        return this.hdi;
    }

    public boolean caP() {
        return this.hdn;
    }

    public static e a(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.et(GU(basic.remind_time));
        eVar.setStatus(basic.status.intValue());
        eVar.vi(basic.candidate_num.intValue());
        eVar.vj(basic.total_vote_num.intValue());
        eVar.er(GU(basic.begin_apply_time));
        eVar.eu(GU(basic.begin_vote_time));
        eVar.es(GU(basic.begin_public_time));
        eVar.mZ(basic.is_voted.booleanValue());
        return eVar;
    }

    private static long GU(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void vi(int i) {
        this.hdl = i;
    }

    public void er(long j) {
        this.hdh = j;
    }

    public void es(long j) {
        this.hdj = j;
    }

    public void et(long j) {
        this.hdk = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void vj(int i) {
        this.hdm = i;
    }

    public void eu(long j) {
        this.hdi = j;
    }

    public void mZ(boolean z) {
        this.hdn = z;
    }
}
