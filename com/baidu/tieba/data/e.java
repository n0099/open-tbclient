package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.data.b;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes.dex */
public class e {
    private boolean Rs;
    private boolean abO;
    private int asX;
    private int asY;
    private int asZ;
    private String ata;
    private int atb;
    private int time = 0;
    private j asT = new j();
    private o asU = new o();
    private w asV = new w();
    private n asW = new n();

    public boolean CB() {
        return this.abO;
    }

    public void bq(boolean z) {
        this.abO = z;
    }

    public e() {
        this.Rs = true;
        this.Rs = false;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void et(int i) {
        this.asZ = i;
    }

    public void setIsMem(int i) {
        this.atb = i;
    }

    public void eu(int i) {
        this.asX = i;
    }

    public void ev(int i) {
        this.asY = i;
    }

    public void fb(String str) {
        this.ata = str;
    }

    public void a(n nVar) {
        this.asW = nVar;
    }

    public n CC() {
        return this.asW;
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
                fb(dataRes.msign_text);
                setIsMem(dataRes.is_mem.intValue());
                setTime(dataRes.time.intValue());
                this.asT.setLevel(this.asY);
                if (dataRes.like_forum != null) {
                    this.asT.i(dataRes.like_forum);
                }
                if (dataRes.new_recommend != null) {
                    this.asU.i(dataRes.new_recommend);
                }
                if (dataRes.banner != null) {
                    this.asV.i(dataRes.banner);
                }
                if (dataRes.recommend_forum_info != null) {
                    this.asW.H(dataRes.recommend_forum_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public w CD() {
        return this.asV;
    }

    public void a(w wVar) {
        this.asV = wVar;
    }

    public j CE() {
        return this.asT;
    }

    public void a(j jVar) {
        this.asT = jVar;
    }

    public o CF() {
        return this.asU;
    }

    public void a(o oVar) {
        this.asU = oVar;
    }

    public void au(boolean z) {
        this.Rs = z;
    }

    public boolean isSuccess() {
        return this.Rs;
    }

    public boolean CG() {
        return System.currentTimeMillis() / b.WF.longValue() == (((long) this.time) * 1000) / b.WF.longValue();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.Rs) {
            if (this.asT == null || this.asT.CT() == null || this.asT.CT().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
