package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class o {
    private boolean Lk;
    private boolean Vd;
    private int akj;
    private int akk;
    private int akl;
    private String akm;
    private int akn;
    private int time = 0;
    private z akg = new z();
    private ap akh = new ap();
    private com.baidu.tieba.square.al aki = new com.baidu.tieba.square.al();

    public boolean yL() {
        return this.Vd;
    }

    public void bp(boolean z) {
        this.Vd = z;
    }

    public o() {
        this.Lk = true;
        this.Lk = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void dZ(int i) {
        this.akl = i;
    }

    public void setIsMem(int i) {
        this.akn = i;
    }

    public int yM() {
        return this.akj;
    }

    public void ea(int i) {
        this.akj = i;
    }

    public int yN() {
        return this.akk;
    }

    public void eb(int i) {
        this.akk = i;
    }

    public String yO() {
        return this.akm;
    }

    public void eq(String str) {
        this.akm = str;
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
                this.akg.setLevel(this.akk);
                if (dataRes.like_forum != null) {
                    this.akg.A(dataRes.like_forum);
                }
                if (dataRes.new_recommend != null) {
                    this.akh.A(dataRes.new_recommend);
                }
                if (dataRes.banner != null) {
                    this.aki.A(dataRes.banner);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public com.baidu.tieba.square.al yP() {
        return this.aki;
    }

    public void a(com.baidu.tieba.square.al alVar) {
        this.aki = alVar;
    }

    public z yQ() {
        return this.akg;
    }

    public void a(z zVar) {
        this.akg = zVar;
    }

    public ap yR() {
        return this.akh;
    }

    public void a(ap apVar) {
        this.akh = apVar;
    }

    public void ab(boolean z) {
        this.Lk = z;
    }

    public boolean isSuccess() {
        return this.Lk;
    }

    public boolean yS() {
        return System.currentTimeMillis() / e.ajx.longValue() == (((long) this.time) * 1000) / e.ajx.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Lk) {
            if (this.akg == null || this.akg.zx() == null || this.akg.zx().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean yT() {
        if (this.akg != null) {
            return this.akg.yT();
        }
        return false;
    }
}
