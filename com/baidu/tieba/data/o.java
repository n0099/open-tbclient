package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class o {
    private boolean Ln;
    private boolean Vh;
    private int aks;
    private int akt;
    private int aku;
    private String akv;
    private int akw;
    private int time = 0;
    private z akp = new z();
    private ap akq = new ap();
    private com.baidu.tieba.square.al akr = new com.baidu.tieba.square.al();

    public boolean yN() {
        return this.Vh;
    }

    public void bp(boolean z) {
        this.Vh = z;
    }

    public o() {
        this.Ln = true;
        this.Ln = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void dZ(int i) {
        this.aku = i;
    }

    public void setIsMem(int i) {
        this.akw = i;
    }

    public int yO() {
        return this.aks;
    }

    public void ea(int i) {
        this.aks = i;
    }

    public int yP() {
        return this.akt;
    }

    public void eb(int i) {
        this.akt = i;
    }

    public String yQ() {
        return this.akv;
    }

    public void eq(String str) {
        this.akv = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                ea(dataRes.msign_valid.intValue());
                eb(dataRes.msign_level.intValue());
                dZ(dataRes.is_login.intValue());
                eq(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.akp.setLevel(this.akt);
                if (dataRes.like_forum != null) {
                    this.akp.A(dataRes.like_forum);
                }
                if (dataRes.new_recommend != null) {
                    this.akq.A(dataRes.new_recommend);
                }
                if (dataRes.banner != null) {
                    this.akr.A(dataRes.banner);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public com.baidu.tieba.square.al yR() {
        return this.akr;
    }

    public void a(com.baidu.tieba.square.al alVar) {
        this.akr = alVar;
    }

    public z yS() {
        return this.akp;
    }

    public void a(z zVar) {
        this.akp = zVar;
    }

    public ap yT() {
        return this.akq;
    }

    public void a(ap apVar) {
        this.akq = apVar;
    }

    public void ab(boolean z) {
        this.Ln = z;
    }

    public boolean isSuccess() {
        return this.Ln;
    }

    public boolean yU() {
        return System.currentTimeMillis() / e.ajG.longValue() == (((long) this.time) * 1000) / e.ajG.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Ln) {
            if (this.akp == null || this.akp.zz() == null || this.akp.zz().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean yV() {
        if (this.akp != null) {
            return this.akp.yV();
        }
        return false;
    }
}
