package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.data.b;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class e {
    private boolean Rp;
    private boolean abL;
    private int asU;
    private int asV;
    private int asW;
    private String asX;
    private int asY;
    private int time = 0;
    private j asQ = new j();
    private o asR = new o();
    private w asS = new w();
    private n asT = new n();

    public boolean Cv() {
        return this.abL;
    }

    public void bq(boolean z) {
        this.abL = z;
    }

    public e() {
        this.Rp = true;
        this.Rp = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void et(int i) {
        this.asW = i;
    }

    public void setIsMem(int i) {
        this.asY = i;
    }

    public void eu(int i) {
        this.asU = i;
    }

    public void ev(int i) {
        this.asV = i;
    }

    public void eY(String str) {
        this.asX = str;
    }

    public void a(n nVar) {
        this.asT = nVar;
    }

    public n Cw() {
        return this.asT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            a(dataRes, null);
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                eu(dataRes.msign_valid.intValue());
                ev(dataRes.msign_level.intValue());
                et(dataRes.is_login.intValue());
                eY(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.asQ.setLevel(this.asV);
                if (dataRes.like_forum != null) {
                    this.asQ.i(dataRes.like_forum);
                }
                if (dataRes.new_recommend != null) {
                    this.asR.i(dataRes.new_recommend);
                }
                if (dataRes.banner != null) {
                    this.asS.i(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.asT.H(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public w Cx() {
        return this.asS;
    }

    public void a(w wVar) {
        this.asS = wVar;
    }

    public j Cy() {
        return this.asQ;
    }

    public void a(j jVar) {
        this.asQ = jVar;
    }

    public o Cz() {
        return this.asR;
    }

    public void a(o oVar) {
        this.asR = oVar;
    }

    public void au(boolean z) {
        this.Rp = z;
    }

    public boolean isSuccess() {
        return this.Rp;
    }

    public boolean CA() {
        return System.currentTimeMillis() / b.WC.longValue() == (((long) this.time) * 1000) / b.WC.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Rp) {
            if (this.asQ == null || this.asQ.CN() == null || this.asQ.CN().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
